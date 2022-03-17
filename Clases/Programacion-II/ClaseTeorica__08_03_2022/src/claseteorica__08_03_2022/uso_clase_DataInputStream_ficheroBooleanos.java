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

public class uso_clase_DataInputStream_ficheroBooleanos {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new uso_clase_DataInputStream_ficheroBooleanos().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() throws Exception {    
        //DECLARACIONES
        //declaración objeto DataInputStream para posibilitar la lectura de un
        //fichero a nivel de booleanos
        DataInputStream ficheroBooleanos;
        //declaración variable booleana para representar los valores booleanos a leer
        //en el fichero ficheroBooleanos
        boolean booleano; 
        
        //ACCIONES
        try {
            //instanciación objeto DataInputStream fichero para enlazar con fichero
            //ficheroBooleanos.dat
            ficheroBooleanos=new DataInputStream(new BufferedInputStream(new FileInputStream("ficheroBooleanos.dat")));

            //ACCIONES
            //lectura y visualización contenido ficheroBooleanos.dat
            try {
                //lectura primer elemento booleano desde el fichero ficheroBooleanos.dat
                booleano=ficheroBooleanos.readBoolean();
                //bucle de lectura y visualización
                while (true) {
                    //visualización booleano leido desde el fichero
                    System.out.print(booleano+" ");
                    //lectura siguiente caracter
                    booleano=ficheroBooleanos.readBoolean();   
                }
            }catch (EOFException eof) {
                // NO HACEMOS NADA			
            }catch (IOException error) {
                System.out.println(error.toString());
            }catch (Exception error) {
                System.out.println(error.toString());
            }finally {
                try {
                    //cierre del enlace ficheroReales
                    ficheroBooleanos.close();               
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
