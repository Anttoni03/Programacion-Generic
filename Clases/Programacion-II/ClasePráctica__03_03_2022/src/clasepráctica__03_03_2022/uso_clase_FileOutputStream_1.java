package clasepráctica__03_03_2022;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
FUNCIONALIDAD: dado un array de enteros lleva a cabo la grabación en el fichero
datos4.gif del contenido de dicho array representando cada entero un byte a escribir
en dicho fichero.
OBJETIVOS:
    - uso de la clase FileOutputStream.

autor: Juan Montes de Oca
 */

public class uso_clase_FileOutputStream_1 {
    //declaración método main
    public static void main(String [] argumentos) {
        new uso_clase_FileOutputStream_1().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {    
        //DECLARACIONES
        //declaración array de enteros que contiene los bytes a escribir en el fichero
        final int datos[]={71,73,70,56,57,97,15,0,15,0,128,
                    0,0,255,255,255,0,0,0,44,0,0,0,0,15,0,15,0,0,2,33,
                    132,127,161,200,185,205,84,128,241,81,35,175,155,26,
                    228,254,105,33,102,121,165,201,145,169,154,142,172,
                    116,162,240,90,197,5,0,59};

        //declaración objeto FileOutputStream para posibilitar la escritura de un
        //fichero a nivel de bytes
        FileOutputStream fichero;
        
        //ACCIONES
        //instanciación objeto FileOutputStream fichero para enlazar con fichero
        //datos4.dat
        try {
            fichero=new FileOutputStream("datos4.gif");
            try {
                //bucle de escritura del array datos en el fichero
                for (int indice=0;indice<datos.length;indice++) {
                    fichero.write(datos[indice]);
                }            
            }catch (IOException error) {
                System.err.println("ERROR AL ESCRIBIR EN EL FICHERO");
            }  
            finally {
                try {
                    //cierre del enlace FileOutputStream
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
