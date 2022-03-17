/*
CLASE CodificacionAlfabetica

FUNDAMENTADA EN LA UTILIZACIÓN DE DOS ARRAYS DE CARACTERES PARA EL SUMINISTRO
DE LA INFORMACIÓN NECESARIA PARA LA REPRESENTACIÓN DEL ALFABETO Y DEL
ALFABETO CODIFICADO
 */
package clase_practica_____21_12_2021;

import java.util.Random;

public class CodificacionAlfabetica_V2 {
    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de clase constante entero para representar 
    //número de caracteres que conforman el alfabeto
    private static final int NUMERO_CARACTERES=27;
    //declaración atributo de clase constante array de caracteres para representar
    //alfabeto
    private static final char [] ALFABETO="abcdefghijklmnñopqrstuvwxyz".toCharArray();
    //declaración atributo de clase constante array de caracteres para representar
    //alfabeto codificado una vez se obtenga a través del constructor el desplazamiento
    //por medio de la semilla dada
    private static final char [] ALF_COD=new char[ALFABETO.length];
    //declaración atributo de objeto variable entero para representar el
    //desplazamiento del alfabeto utilizado en la codificación
    private int desplazamiento;
    
    //MÉTODOS
    //CONSTRUCTOR
    public CodificacionAlfabetica_V2(int semilla) {
        //cálculo del desplazamiento en función de la semilla dada
        //para ello debemos declarar un objeto Random que actue como
        //generador con la semilla multiplicada por ejemplo por 1000 porque
        //si las semillas son pequeñas no hay cambios en la generación de
        //la secuencia aleatoria
        Random generador=new Random(semilla*1000);
        //obtención del desplazamiento de forma aleatoria a través del
        //generador.
        //el desplazamiento del alfabeto tendrá que tener un valor entero
        //perteneciente al intervalo [0,NUMERO_CARACTERES).
        desplazamiento=(int) (generador.nextDouble()*NUMERO_CARACTERES);
        //generación alfabeto codificado a partir del desplazamiento obtenido
        generacionAlfabetoCodificado();
    }
    
    //MÉTODOS FUNCIONALES
    //MÉTODO generacionAlfabetoCodificado LLEVA A TÉRMINO LA GENERACIÓN DEL ALFABETO
    //CODIFICADO A PARTIR DEL DESPLAZAMIENTO OBTENIDO EN EL CONSTRUCTOR
    public void generacionAlfabetoCodificado() {
        //DECLARACIONES
        //declaración variable entera para representar la posición en el
        //atributo array ALFABETO del caracter codificado dado un caracter
        //del alfabeto
        int posicion;
        //asignación al array ALF_COD de los caracteres codificados correspondientes
        //a los caracteres del array ALFABETO
        for (int indice=0;indice<ALF_COD.length;indice++) {
            if ((indice+desplazamiento)<ALF_COD.length) {
                //obtención de la posición
                posicion=indice+desplazamiento;
            }
            else {
                //debido a que la suma a indice del desplazamiento
                //a aplicar supera el rango de acceso al array vamos
                //a obtener la nueva posición utilizando el operador resto %
                posicion=(indice+desplazamiento)%NUMERO_CARACTERES;  
            }
            //asignación a la componente indice-ésima del array ALF_COD
            //el caracter codificado correspondiente al caracter del
            //array ALFABETO de la misma componente
            ALF_COD[indice]=ALFABETO[posicion];
        }
    }
    
    //MÉTODO codificar LLEVA A TÉRMINO LA OBTENCIÓN DEL CARACTER CODIFICADO
    //DEL CARACTER DADO POR PARÁMETRO
    public char codificar(char caracter) {
        if (valido(caracter)) {
            return ALF_COD[posicion(1,caracter)];
        }
        else {
            return caracter;
        }
        
    }

    //MÉTODOS FUNCIONALES
    //MÉTODO deCodificar LLEVA A TÉRMINO LA OBTENCIÓN DEL CARACTER DECODIFICADO
    //DEL CARACTER DADO POR PARÁMETRO
    public char deCodificar(char caracter) {
        if (valido(caracter)) {
            return ALFABETO[posicion(2,caracter)];            
        }
        else {
            return caracter;
        }

    }    
    
    //MÉTODO posicion OBTIENE LA POSICIÓN EN EL ARRAY ALFABETO DE UN CARACTER
    //DADO POR PARÁMETRO
    public int posicion(int operacion,char caracter) {
        //declaración variable indice para acceder al array ALFABETO
        int indice=0;
        switch (operacion) {
            case 1 ://búsqueda del caracter dado en el array ALFABETO
                    for (indice=0;caracter!=ALFABETO[indice];indice++) {}
                    break;
            case 2 ://búsqueda del caracter dado en el array ALFABETO
                    for (indice=0;caracter!=ALF_COD[indice];indice++) {}
                    break;                    
        }
        //devolución posición del caracter dado
        return indice;
    }
    
    //MÉTODO valido VERIFICA SI UN CARACTER DADO ES UN CARACTER QUE PUEDE
    //SER CODIFICADO O DECODIFICADO
    public boolean valido(char caracter) {
        //verificamos si el caracter está dentro del array ALFABETO, si es así,
        //devolveremos true, en caso contrario devolveremos false
        for (int indice=0;indice<ALFABETO.length;indice++) {
            if (caracter==ALFABETO[indice]) {
                return true;
            }
        }
        return false;
    }
    
}
