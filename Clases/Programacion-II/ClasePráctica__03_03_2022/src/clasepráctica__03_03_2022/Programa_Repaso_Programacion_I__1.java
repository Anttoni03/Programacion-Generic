/*
1. Dado un fichero de texto visualiza el número de palabras contenidas en él.
 */
package clasepráctica__03_03_2022;

import java.io.FileNotFoundException;


public class Programa_Repaso_Programacion_I__1 {
    //eclaración método main
    public static void main(String [] argumentos) {
        new Programa_Repaso_Programacion_I__1().metodoPrincipal();
    }
    
    //declaración método principal
    private void metodoPrincipal(){
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para posibilitar la lectura
        //a nivel de palabras desde un fichero de texto
        PalabraFicherosLectura fichero;
        //declaración objeto palabra para almacenar, de una en una, las palabras
        //leídas desde el fichero
        Palabra palabra=new Palabra();
        //declaración variable entera para almacenar el número de palabras contenidas
        //en el fichero a leer
        int contador=0;
        
        //ACCIONES
        //instanciar objeto PalabraFicherosLectura fichero para establecer el enlace
        //con el fichero físico a nivel de lectura de palabras
        fichero=new PalabraFicherosLectura("ficheroPalabras.txt");
        //bucle de tratamiento de recorrido para la lectura y tratamiento a nivel
        //de palabras desde el fichero
        while (fichero.hayPalabras()) {
            //lectura palabra desde el fichero
            palabra=fichero.lectura();
            //tratamiento palabra
            //incrementar contador de palabras
            contador++;
        }
        //visualización contador de palabras
        System.out.println("EL NÚMERO DE PALABRAS CONTENIDAS EN EL FICHERO ES : "+contador);
        //cierre enlace fichero
        fichero.cerrarEnlaceFichero(); 
    }
    
}
