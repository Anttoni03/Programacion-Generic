package claseteorica__08_03_2022;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FUNCIONALIDAD: visualiza el contenido del fichero ficheroEnteros.dat.

OBJETIVOS:
    - uso de la clase DataInputStream.
autor: Juan Montes de Oca
 */

public class uso_clase_DataInputStream_ficheroEnteros {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new uso_clase_DataInputStream_ficheroEnteros().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() throws Exception {    
        //DECLARACIONES
        //declaración objeto DataInputStream para posibilitar la lectura de un
        //fichero a nivel de enteros
        DataInputStream ficheroEnteros;
        //declaración variable entera para representar los valores enteros a leer
        //en el fichero ficheroEnteros
        int entero;
        
        //ACCIONES
        try {
        //instanciación objeto DataInputStream fichero para enlazar con fichero
        //ficheroEnteros.dat
        ficheroEnteros=new DataInputStream(new BufferedInputStream(new FileInputStream("ficheroEnteros.dat")));

            //lectura y visualización contenido ficheroEnteros.dat
            try {
                //lectura primer elemento entero desd el fichero ficheroEnteros.dat
                entero=ficheroEnteros.readInt();
                //bucle de lectura y visualización
                while (true) {
                    //visualización entero leido desde el fichero
                    System.out.print(entero+" ");
                    //lectura siguiente entero
                    entero=ficheroEnteros.readInt();   
                }
            }catch (EOFException eof) {
                // NO HACEMOS NADA			
            }catch (IOException error) {
                System.out.println(error.toString());
            }catch (Exception error) {
                System.out.println(error.toString());
            }finally {
                try {
                    //cierre del enlace ficheroEnteros
                    ficheroEnteros.close();               
                }catch (IOException error) {
                    System.out.println(error.toString());
                }            
            }
        }catch (FileNotFoundException error) {
            System.out.println(error.toString());
        }catch (Exception error) {
                System.out.println(error.toString());
        }
    }
}
