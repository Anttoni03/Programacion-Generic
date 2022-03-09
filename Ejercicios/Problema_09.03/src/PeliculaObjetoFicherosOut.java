

import java.io.*;

public class PeliculaObjetoFicherosOut {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos cuando se desee crear un fichero nuevo
    private ObjectOutputStream fichero1=null;
    //declaración objeto AdicionObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos cuando se desee añadir objetos en un fichero ya existente
    private AdicionObjectOutputStream fichero2=null; 
    
    //MÉTODO CONSTRUCTOR
    public PeliculaObjetoFicherosOut(String nombreFichero) { 
       try {
           //declaración objeto File que enlace con el fichero dado por parámetro
            File F = new File(nombreFichero);         
            if (F.exists()) {  
                //instanciación objeto AdicionObjectOutputStream con el fichero dado
                //para posibilitar la adición de objetos  en dicho fichero
                fichero2 = new  AdicionObjectOutputStream(new BufferedOutputStream
                                            (new FileOutputStream(nombreFichero,true)));         
            }               
            else {    
                //instanciación objeto ObjectOutputStream con el fichero dado
                //para posibilitar la escritura de objetos en dicho fichero que será creado
                //como nuevo
                fichero1= new ObjectOutputStream(new BufferedOutputStream
                                            (new FileOutputStream(nombreFichero)));      
            }
       }
       catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       } 
   }     

    //MÉTODOS FUNCIONALES
    
    //MÉTODO escritura LLEVA A CABO LA ESCRITURA DE UN OBJETO Pelicula
    public void escritura(Pelicula pelicula) {
        try {
            //verificar si el fichero es de nueva creación o es un fichero, ya existente, donde
            //se está añadiendo un nuevo objeto Pelicula
            if (fichero2==null) {
                //escritura objeto Pelicula dado
                fichero1.writeObject(pelicula);
            }
            else {
                //escritura objeto Pelicula dado
                fichero2.writeObject(pelicula);
            }
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }   
    
    }
     
    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() {
        try {
            //verificar si el fichero es de nueva creación o es un fichero, ya existente, donde
            //se está añadiendo un nuevo objeto Pelicula
                if (fichero2==null) {
                    fichero1.close();
                }
                else {
                    fichero2.close();
                }              
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        } 
    }
}
   

