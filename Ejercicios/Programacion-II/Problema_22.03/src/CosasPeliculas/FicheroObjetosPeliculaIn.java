
package CosasPeliculas;

import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FicheroObjetosPeliculaIn {

    private ObjectInputStream fichero = null;
    
    public FicheroObjetosPeliculaIn(String rutaFichero)
    {
        try{
            fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(rutaFichero)));
        } catch(FileNotFoundException e){
            System.err.println("ERROR: " + e.toString());
        } catch(IOException e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    public Pelicula lectura(){
        Pelicula pelicula = null;
        try{
            pelicula = (Pelicula)fichero.readObject();
        } catch(ClassNotFoundException e){
            System.err.println("ERROR: " + e.toString());
        } catch(IOException e ){
            System.err.println("ERROR: "+ e.toString());
        } finally{
            return pelicula;
        }
    }
    
    public void cierre()
    {
        try{
            if (fichero != null)
                fichero.close();
        } catch(IOException e){
            System.err.println("ERROR: " + e.toString());
        }
    }
}
