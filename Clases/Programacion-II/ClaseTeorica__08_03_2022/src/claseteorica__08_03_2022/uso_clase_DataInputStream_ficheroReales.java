package claseteorica__08_03_2022;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FUNCIONALIDAD: visualiza el contenido del fichero ficheroReales.dat.

OBJETIVOS:
    - uso de la clase DataInputStream.
autor: Juan Montes de Oca
 */

public class uso_clase_DataInputStream_ficheroReales {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new uso_clase_DataInputStream_ficheroReales().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() throws Exception {    
        //DECLARACIONES
        //declaración objeto DataInputStream para posibilitar la lectura de un
        //fichero a nivel de reales
        DataInputStream ficheroReales;
        //declaración variable real para representar los valores reales a leer
        //en el fichero ficheroReales
        double real;
        
        //ACCIONES
        try {
            //instanciación objeto DataInputStream fichero para enlazar con fichero
            //ficheroReales.dat
            ficheroReales=new DataInputStream
                (new BufferedInputStream(new FileInputStream("ficheroReales.dat")));

            //ACCIONES
            //lectura y visualización contenido ficheroEnteros.dat
            try {
                //lectura primer elemento real desde el fichero ficheroReales.dat
                real=ficheroReales.readDouble();
                //bucle de lectura y visualización
                while (true) {
                    //visualización real leido desde el fichero
                    System.out.print(real+" ");
                    //lectura siguiente real
                    real=ficheroReales.readDouble();   
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
                    ficheroReales.close();                 
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
            