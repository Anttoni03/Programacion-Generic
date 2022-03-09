

import java.io.*;

public class PeliculaObjetoFicherosIn {
    //ATRIBUTOS
    //declaración objeto ObjectInputStream para posibilitar la lectura en ficheros
    //a nivel de objetos
    private ObjectInputStream fichero =null;

     
    //MÉTODO CONSTRUCTOR   
    public PeliculaObjetoFicherosIn(String nombreFichero) {
       try {
           //instanciación objeto ObjectInputStream con el fichero dado
           //para posibilitar la lectura de objetos de dicho fichero 
           fichero = new ObjectInputStream(new BufferedInputStream
                            (new FileInputStream(nombreFichero)));
       }catch (FileNotFoundException error) {
           System.out.println("ERROR: "+error.toString());
       }
       catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       }   
    }
    
    //MÉTODOS FUNCIONALES
    
    //MÉTODO lectura LLEVA A CABO LA LECTURA DE UN OBJETO Pelicula
    public Pelicula lectura() { 
        //declaración objeto Palabra para alamcenar el objeto Pelicula a leer desde el fichero
        Pelicula pelicula=new Pelicula();
        try {
            //lectura objeto Pelicula leido desde el fichero
            pelicula= (Pelicula) fichero.readObject();      
        }catch (EOFException error) { 
            //devolución valor null porque hemos llegado al final del fichero
            return null;
        }catch (ClassNotFoundException | IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        }
        //devolución objeto Pelicula leido desde el fichero
        return pelicula;
    }

    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
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