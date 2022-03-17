package clasepráctica__03_03_2022;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
FUNCIONALIDAD: visualiza el contenido en bytes de un fichero imagen formato jpg de nombre
uib.jpg y realiza una copia en el fichero uibCopia.jpg
OBJETIVOS:
    - uso de la clases FileInputStream, FileOutputStream, BufferedInputStream y
    BufferedOutputStream.
 */

public class uso_clase_BufferedInputStream_BufferedOutputStream_1 {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new uso_clase_BufferedInputStream_BufferedOutputStream_1().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() throws Exception {    
        //DECLARACIONES
        //declaración constante entera que representa el código de final de fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto BufferedInputStream para posibilitar la lectura de un
        //fichero utilizando un buffer
        BufferedInputStream fichero1;
        //declaración objeto BufferedOutputStream para posibilitar la lectura de un
        //fichero utilizando un buffer
        BufferedOutputStream fichero2;
        //declaración variable entera para almacenar los bytes, uno a uno, que
        //van siendo leidos desde el fichero
        int codigo;
        
        //ACCIONES
        try {
            //instanciación objeto BufferedInputStream fichero para enlazar con fichero
            //uib.jpg
            fichero1=new BufferedInputStream(new FileInputStream("uib.jpg"));
            //instanciación objeto BufferedOutputStream fichero para enlazar con fichero
            //uibCopia.jpg
            fichero2=new BufferedOutputStream(new FileOutputStream("uibCopia.jpg"));
            try {
                //lectura primer byte del fichero
                codigo=fichero1.read();
                //bucle de lectura y visualización
                while (codigo!=FINAL_FICHERO) {
                    //visualización byte leido del fichero uib.jpg
                    System.out.print(codigo);
                    //grabación byte leido en el fichero uibCopia.jpg
                    fichero2.write(codigo);
                    //lectura siguiente byte desde el fichero uib.jpg
                    codigo=fichero1.read();
                }                      
            }catch (IOException error) {
                System.err.println("ERROR AL LEER DEL FICHERO");
            }  
            finally {
                try {
                    //cierre del enlace BufferedInputStream
                    fichero1.close();   
                    //cierre del enlace BufferedOutputStream
                    fichero2.close();                    
                }catch (IOException error) {
                    System.err.println("ERROR AL CERRAR EL FICHERO");
                }
            }    
        }catch (FileNotFoundException error) {
            System.err.println("ERROR: FICHERO NO EXISTENTE");
        }
    }
}
