/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.', visualiza la frecuencia de aparición de la pareja de 
caracteres 'l''a'.
ejemplo:
secuencia de entrada: hola que tal.
salida: el número de pareja de caracteres 'l''a' es 1.

OBJETIVO: TRATAMIENTO SECUENCIAL DE CARACTERES. TRATAMIENTO DE RECORRIDO A NIVEL
DE PAREJA DE CARACTERES.
FECHA DE CREACIÓN: 19.10.2021
Autor: Juan Montes de Oca
 */

package clase_teoria_29_10_2021;

public class FrecuenciaParejaDeCaracteres_v2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración constante de tipo char para representar el caracter de
        //final de secuencia
        final char FINAL_SECUENCIA='.';
        //declaración constantes de tipo char para representar los caracteres
        //integrantes de la pareja a buscar
        final char CARACTER1='l',CARACTER2='a';
        //declaración variables de tipo char para almacenar, de pareja en pareja, los
        //caracteres leídos de la secuencia
        char caracterPrimero=' ',caracterSegundo;
        //declaración variable de tipo int para almacenar el número de parejas de
        //caracteres a contar
        int contador=0;
        
        //ACCIONES
        //MENSAJE USUARIO PARA INTRODUCIR SECUENCIA DE CARACTERES
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //LECTURA CARACTER
        caracterSegundo=LT.readChar();
        //TRATAMIENTO DE RECORRIDO A NIVEL DE PAREJA DE CARACTERES
        while (caracterSegundo!=FINAL_SECUENCIA) {
            //TRATAMIENTO PAREJA DE CARACTERES
            //verificar si la pareja de caracteres conformada por los caracteres
            //que almacena es la pareja a buscar
            if ((caracterPrimero==CARACTER1)&&(caracterSegundo==CARACTER2)) {
                //INCREMETAR CONTADOR DE PAREJA DE CARACTERES A BUSCAR
                contador++;
            }
            //CONFORMAR SIGUIENTE PAREJA DE CARACTERES
            caracterPrimero=caracterSegundo;
            //lectura siguiente caracter
            caracterSegundo=LT.readChar();
        }
        
        //VISUALIZAR RESULTADO
        System.out.println("EL NÚMERO DE PAREJA DE CARACTERES "+CARACTER1+CARACTER2+" ES: "+contador);
    }
    
}