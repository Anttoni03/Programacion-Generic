package EjerciciosEstudiantes;



/*
AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA LLEVAR A CABO LA GESTIÓN 
DE FICHEROS DE OBJETOS Estudiante A NIVEL DE LECTURA
*/

import java.io.*;

public class EstudianteObjetoFicherosIn {
    //ATRIBUTOS
    //declaración objeto ObjectInputStream para posibilitar la lectura en ficheros
    //a nivel de objetos
    private ObjectInputStream fichero=null;

     
    //MÉTODO CONSTRUCTOR   
    public EstudianteObjetoFicherosIn(String nombreFichero) {
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
    
    //MÉTODO lectura LLEVA A CABO LA LECTURA DE UN OBJETO Estudiante EN EL FICHERO
    //ENLAZADO CON EL OBJETO EstudianteObjetoFicherosIn   
    public Estudiante lectura() { 
        //declaración objeto Estudiante para almacenar el objeto Estudiante a leer desde el fichero
        Estudiante estudiante=new Estudiante();
        try {
            //lectura objeto Estudiante leido desde el fichero
            estudiante= (Estudiante) fichero.readObject();      
        }catch (ClassNotFoundException | IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        }
        //devolución objeto Estudiante leido desde el fichero
        return estudiante;
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

