package clasepráctica__03_03_2022;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FUNCIONALIDAD: visualiza los números enteros separados por un espacio en
blanco contenidos en un fichero de nombre datos3.dat
OBJETIVOS:
    - uso de la clase FileInputStream.
autor: Juan Montes de Oca
 */

public class uso_clase_FileInputStream_4 {
    //declaración constante entera que representa el código de final de fichero
    private final int FINAL_FICHERO=-1;
    //declaración constante código de caracter correspondiente al espacio en blanco
    private final int ESPACIO=32;
    
    //declaración método main
    public static void main(String [] argumentos) {
        new uso_clase_FileInputStream_4().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {    
        //DECLARACIONES
        //declaración objeto FileInputStream para posibilitar la lectura de un
        //fichero a nivel de bytes
        FileInputStream fichero=null;
        //declaración variable entera para almacenar los bytes, uno a uno, que
        //van siendo leidos desde el fichero
        int codigo;
        //declaración e instanciación objeto Entero
        Entero numero=new Entero();
        
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
                    if (Entero.esDigitoNumerico(codigo)) {
                        numero.insertarDigito(codigo);
                    }
                    else {
                        //visualización numero entero
                        System.out.print(numero.toString()+" ");
                        numero=new Entero();
                    }
                    //lectura siguiente byte desde el fichero
                    codigo=fichero.read();
                }
                //visualización del último número entero si es que lo hay
                if (numero.representaValorNumerico()) {
                    System.out.print(numero+" ");
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
