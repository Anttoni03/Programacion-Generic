/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Actualizacion
A NIVEL DE ESCRITURA CUANDO EL FICHERO A GRABAR SERÁ DE NUEVA CREACIÓN. SI ÉSTE
EXISTE PREVIAMENTE SU CONTENIDO SERÁ ELIMINADO
*/
package claseteorica__22_03_2022;

import java.io.*;

public final class FicheroObjetosActualizacionOut {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para establecer enlace con el fichero
    private ObjectOutputStream fichero=null;
    
    //MÉTODOS
    
    //MÉTODO CONSTRUCTOR
    public FicheroObjetosActualizacionOut(String nombreFichero) {
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
    public void escritura(Actualizacion operacion) {
        try {
            //grabación objeto Actualizacion dado
            fichero.writeObject(operacion);   
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

