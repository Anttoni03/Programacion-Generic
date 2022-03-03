package clasepráctica__03_03_2022;

/*******************************************************************************
FUNCIONALIDAD: visibilidad del uso de la clase File.
autor: Juan Montes de Oca
*******************************************************************************/

import java.io.File;

public class usoClaseFile_1 {
    //declaración método main
    public static void main(String [] argumentos) {
        new usoClaseFile_1().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //declaración e instaciación objeto File con el fichero texto.txt
        File fichero=new File("texto.txt");
        //ejemplos uso funcionalidades clase File a través del objeto fichero
        if (fichero.exists()) {
            //método getName()
            System.out.println("Nombre del fichero : " + fichero.getName());
            //método getPath()
            System.out.println("Path relativo : " + fichero.getPath());
            //método getAbsolutePath()
            System.out.println("Path Absoluto : " + fichero.getAbsolutePath());
            //método setReadOnly()            
            if (fichero.setReadOnly()) {
                //método canRead()
                System.out.println(fichero.canRead() ? "es de lectura" : "no es de lectura");
            }
            //método canWrite()
            System.out.println(fichero.canWrite() ? "es de escritura" : "no es de escritura");
            //método length()
            System.out.println("Tamaño del fichero : " + fichero.length() + "Bytes");
        }
        else {
            System.out.println("EL FICHERO NO EXISTE");
        }            
    }   
}
