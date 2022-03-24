/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Estudiante
A NIVEL DE LECTURA
autor: Juan Montes de Oca
*/
package claseteorica__22_03_2022;
import java.io.*;

public class FicheroObjetosEstudianteIn { 
    //ATRIBUTOS
    //declaración objeto ObjectInputStream para establecer el enlace con el
    //fichero corespondiente a nivel de lectura de objetos
    private ObjectInputStream fichero=null;

    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public FicheroObjetosEstudianteIn(String nombreFichero) {
        try {
            fichero = new ObjectInputStream(new BufferedInputStream
                    (new FileInputStream(nombreFichero)));
        }catch (FileNotFoundException error) {
           System.out.println("EN EL FICHERO NO HAY NINGUNA PELÍCULA");
        }
        catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
        }              
    }
    
    //MÉTODOS FUNCIONALES
    //lectura objeto Libro desde fichero
    public Estudiante lectura() { 
        //declaración objeto Palabra para alamacenar el objeto Libro a leer desde el fichero
        Estudiante estudiante=new Estudiante();
        
        //ACCIONES       
        try {
            //lectura objeto Palabra leido desde el fichero
            estudiante= (Estudiante) fichero.readObject();      
        }catch (ClassNotFoundException | IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        }
        //devolución objeto Libro leido desde el fichero
        return estudiante; 
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

