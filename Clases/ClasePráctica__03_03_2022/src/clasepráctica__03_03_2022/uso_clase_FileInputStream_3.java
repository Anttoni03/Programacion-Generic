package clasepráctica__03_03_2022;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FUNCIONALIDAD: visualiza los bytes contenidos en un fichero de nombre datos3.dat
OBJETIVOS:
    - uso de la clase FileInputStream.
autor: Juan Montes de Oca
 */

public class uso_clase_FileInputStream_3 {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new uso_clase_FileInputStream_3().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() throws Exception {    
        //DECLARACIONES
        //declaración constante entera que representa el código de final de fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto FileInputStream para posibilitar la lectura de un
        //fichero a nivel de bytes
        FileInputStream fichero;
        //declaración variable entera para almacenar los bytes, uno a uno, que
        //van siendo leidos desde el fichero
        int codigo;
        
        //ACCIONES
        try {
            //instanciación objeto FileInputStream fichero para enlazar con fichero
            //datos3.dat
            fichero=new FileInputStream("datos3.dat");
            try {
                //lectura primer byte del fichero
                codigo=fichero.read();
                //bucle de lectura y visualización
                while (codigo!=FINAL_FICHERO) {
                    //visualización byte leido
                    System.out.print(codigo+" ");
                    //lectura siguiente byte desde el fichero
                    codigo=fichero.read();
                }             
            }catch (IOException error) {
                System.err.println("ERROR AL LEER DEL FICHERO");
            }  
            finally {
                try {
                    //cierre del enlace FileInputStream
                    fichero.close();                       
                }catch (IOException error) {
                    System.err.println("ERROR AL CERRAR EL FICHERO");
                }
            }         
        }catch (FileNotFoundException error) {
            System.err.println("ERROR: FICHERO NO EXISTENTE");
        }
    }
}
