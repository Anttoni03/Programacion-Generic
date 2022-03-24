
package CosasPeliculas;

import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroObjetosPeliculaOut {
    
    private ObjectOutputStream fichero = null;
    
    public FicheroObjetosPeliculaOut(String rutaFichero){
        try{
            fichero = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(rutaFichero)));
        } catch (IOException e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    public void escritura(Pelicula pelicula){
        try{
            fichero.writeObject(pelicula);
        } catch(IOException e){
            System.err.println("ERROR: " + e.toString());
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
