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

public class uso_clase_DataInputStream_ficheroCaracteres {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new uso_clase_DataInputStream_ficheroCaracteres().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() throws Exception {    
        //DECLARACIONES
        //declaración objeto DataInputStream para posibilitar la lectura de un
        //fichero a nivel de caracteres
        DataInputStream ficheroCaracteres;
        //declaración variable caracter para representar los valores caracteres a leer
        //en el fichero ficheroCaracteres
        char caracter;
        
        //ACCIONES
        try {
        //instanciación objeto DataInputStream fichero para enlazar con fichero
        //ficheroCaracteres.dat
        ficheroCaracteres=new DataInputStream(new BufferedInputStream(new FileInputStream("ficheroCaracteres.dat")));
         
            //lectura y visualización contenido ficheroCaracteres.dat
            try {
                //lectura primer elemento caracter desde el fichero ficheroCaracteres.dat
                caracter=ficheroCaracteres.readChar();
                //bucle de lectura y visualización
                while (true) {
                    //visualización caracter leido desde el fichero
                    System.out.print(caracter+" ");
                    //lectura siguiente caracter
                    caracter=ficheroCaracteres.readChar();   
                }
            }catch (EOFException eof) {
                // NO HACEMOS NADA			
            }catch (IOException error) {
                System.out.println(error.toString());
            }catch (Exception error) {
                System.out.println(error.toString());
            }finally {
                try {
                    //cierre del enlace ficheroReales.dat
                    ficheroCaracteres.close();               
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
