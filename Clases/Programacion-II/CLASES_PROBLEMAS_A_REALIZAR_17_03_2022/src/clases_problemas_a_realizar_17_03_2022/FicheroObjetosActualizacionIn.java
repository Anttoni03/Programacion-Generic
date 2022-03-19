/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Actualizacion
A NIVEL DE LECTURA
autor: Juan Montes de Oca
*/
package clases_problemas_a_realizar_17_03_2022;
import java.io.*;

public class FicheroObjetosActualizacionIn { 
    //ATRIBUTOS
    //declaración objeto ObjectInputStream para establecer el enlace con el
    //fichero corespondiente a nivel de lectura de objetos
    private ObjectInputStream fichero=null;

    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public FicheroObjetosActualizacionIn(String nombreFichero) {
        try {
            fichero = new ObjectInputStream(new BufferedInputStream
                    (new FileInputStream(nombreFichero)));
        }catch (FileNotFoundException error) {
           System.out.println("EN EL FICHERO NO HAY NINGÚN LIBRO");
        }
        catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
        }              
    }
    
    //MÉTODOS FUNCIONALES
    //lectura objeto Actualizacion desde fichero
    public Actualizacion lectura() { 
        //declaración objeto Actualizacion para almacenar el objeto Actualizacion a leer desde el fichero
        Actualizacion operacion=new Actualizacion();
        
        //ACCIONES       
        try {
            //lectura objeto Palabra leido desde el fichero
            operacion= (Actualizacion) fichero.readObject();      
        }catch (ClassNotFoundException | IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        }
        //devolución objeto Libro leido desde el fichero
        return operacion; 
    }

    //cierre enlace con fichero
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

