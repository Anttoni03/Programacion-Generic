/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Estudiante
A NIVEL DE ESCRITURA CUANDO EL FICHERO A GRABAR SERÁ DE NUEVA CREACIÓN. SI ÉSTE
EXISTE PREVIAMENTE SU CONTENIDO SERÁ ELIMINADO
autor: Juan Montes de Oca
*/
package claseteorica__22_03_2022;

import java.io.*;

public final class FicheroObjetosEstudianteOut {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para establecer enlace con el fichero
    private ObjectOutputStream fichero=null;
    
    //MÉTODOS
    
    //MÉTODO CONSTRUCTOR
    public FicheroObjetosEstudianteOut(String nombreFichero) {
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
    
    //grabación de un ficheroIn Pelicula en el fichero correspondiente
    public void escritura(Estudiante pelicula) {
        try {
            //grabación objeto Pelicula dado
            fichero.writeObject(pelicula);   
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

