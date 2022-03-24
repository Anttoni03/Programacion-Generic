package EjerciciosEstudiantes;



/*
AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA LLEVAR A CABO LA GESTIÓN 
DE FICHEROS DE OBJETOS Estudiante A NIVEL DE ESCRITURA
*/

import java.io.*;

public class EstudianteObjetoFicherosOut {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos Estudiante
    private ObjectOutputStream fichero=null;
    
    //MÉTODO CONSTRUCTOR
    public EstudianteObjetoFicherosOut(String nombreFichero) { 
       try {
            //instanciación objeto ObjectOutputStream con el fichero dado
            //para posibilitar la escritura de objetos Estudiante
            fichero=new ObjectOutputStream(new BufferedOutputStream(
                                new FileOutputStream(nombreFichero)));      
       }catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       } 
   }     

    //MÉTODOS FUNCIONALES
    
    //MÉTODO escritura LLEVA A CABO LA ESCRITURA DE UN OBJETO Estudiante EN EL FICHERO
    //ENLAZADO CON EL OBJETO EstudianteObjetoFicherosOut
    public void escritura(Estudiante estudiante) {
        try {
            //escritura objeto Estudiante dado
            fichero.writeObject(estudiante);
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }      
    }
     
    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() {
        try {
            //verificar si el enlace con el fichero no es null
            if (fichero!=null) {
                    fichero.close();        
            }
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        } 
    }
}
   

