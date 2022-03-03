package clasepráctica__03_03_2022;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
FUNCIONALIDAD: visualiza el contenido en bytes de un fichero imagen formato jpg de nombre
uib.jpg y realiza una copia del mismo en el fichero uibCopia.jpg
OBJETIVOS:
    - uso de las clases FileInputStream y FileOutputStream
autor: Juan Montes de Oca
 */

public class uso_clase_FileInputStream_FileOutputStream_1 {
    //declaración método main
    public static void main(String [] argumentos) {
        new uso_clase_FileInputStream_FileOutputStream_1().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {    
        //DECLARACIONES
        //declaración constante entera que representa el código de final de fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto FileInputStream para posibilitar la lectura de un
        //fichero a nivel de bytes
        FileInputStream fichero1;
        //declaración objeto FileOutputStream para posibilitar la lectura de un
        //fichero a nivel de bytes
        FileOutputStream fichero2;
        //declaración variable entera para almacenar los bytes, uno a uno, que
        //van siendo leidos desde el fichero
        int codigo;
        System.out.println("FileInput");
        
        //ACCIONES
        try {
            //instanciación objeto FileInputStream fichero para enlazar con fichero
            //uib.jpg
            fichero1=new FileInputStream("uib.jpg");
            //instanciación objeto FileOutputStream fichero para enlazar con fichero
            //uibCopia.jpg
            fichero2=new FileOutputStream("uibCopia.jpg");
            try {
                //lectura primer byte del fichero
                codigo=fichero1.read();
                //bucle de lectura y visualización
                while (codigo!=FINAL_FICHERO) {
                    //visualización byte leido del fichero uib.jpg
                    System.out.println(codigo);
                    //grabación byte leido en el fichero uibCopia.jpg
                    fichero2.write(codigo);
                    //lectura siguiente byte desde el fichero uib.jpg
                    codigo=fichero1.read();
                }                    
            }catch (IOException error) {
                System.err.println("ERROR ENTRADA/SALIDA CON FICHERO");
            }  
            finally {
                try {
                    //cierre del enlace FileInputStream
                    fichero1.close();   
                    //cierre del enlace FileOutputStream
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
