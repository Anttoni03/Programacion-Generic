/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Libro
A NIVEL DE LECTURA
*/
package EjerciciosLibro;
import java.io.*;

public class FicheroObjetosLibroIn { 
    //ATRIBUTOS
    //declaración objeto ObjectInputStream para establecer el enlace con el
    //fichero corespondiente a nivel de lectura de objetos
    private ObjectInputStream fichero=null;

    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public FicheroObjetosLibroIn(String nombreFichero) {
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
    //lectura objeto Libro desde fichero
    public Libro lectura() { 
        //declaración objeto Palabra para alamacenar el objeto Libro a leer desde el fichero
        Libro libro=new Libro();
        
        //ACCIONES       
        try {
            //lectura objeto Palabra leido desde el fichero
            libro= (Libro) fichero.readObject();      
        }catch (ClassNotFoundException | IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        }
        //devolución objeto Libro leido desde el fichero
        return libro; 
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

