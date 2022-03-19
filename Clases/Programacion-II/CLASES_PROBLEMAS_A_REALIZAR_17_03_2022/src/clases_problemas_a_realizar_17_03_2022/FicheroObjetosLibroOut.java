/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Libro
A NIVEL DE ESCRITURA CUANDO EL FICHERO A GRABAR SERÁ DE NUEVA CREACIÓN. SI ÉSTE
EXISTE PREVIAMENTE SU CONTENIDO SERÁ ELIMINADO
*/
package clases_problemas_a_realizar_17_03_2022;

import java.io.*;

public final class FicheroObjetosLibroOut {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para establecer enlace con el fichero
    private ObjectOutputStream fichero=null;
    
    //MÉTODOS
    
    //MÉTODO CONSTRUCTOR
    public FicheroObjetosLibroOut(String nombreFichero) {
       try {
            //se establece el enlace
            //con el fichero a través de un objeto ObjectOutputStream
            fichero= new ObjectOutputStream(new BufferedOutputStream
                        (new FileOutputStream(nombreFichero)));         
       }catch (FileNotFoundException error) {
           System.out.println("ERROR: "+error.toString());
       }
       catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       }

    }
    
    //MÉTODOS FUNCIONALES
    
    //grabación de un ficheroIn Libro en el fichero correspondiente
    public void escritura(Libro libro) {
        try {
            //grabación objeto Libro dado
            fichero.writeObject(libro);   
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
        }
    }
    
    //cierre enlace con el fichero
    public void cierre() {     
        try {
            if (fichero!=null) {
                fichero.close();
            }
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
        }
    }
}

