/*
CREADOR: TONI ROCA CASTRO
CLASE FitxerAlbumTextLectura
 */
package talleravaluable1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FitxerAlbumTextLectura {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //declaración objeto BufferedReader
    private BufferedReader fichero=null;
    
    //MÉTODOS CONSTRUCTORES
    public FitxerAlbumTextLectura(String nombreFichero) {
        try {
            //instanciación objeto BufferedReader
            fichero=new BufferedReader(new FileReader(nombreFichero));
        }catch (FileNotFoundException error) {
            System.err.println(error.getMessage());
        }
    }
    
    //MÉTODOS FUNCIONALES
    //método lectura
    public Album lectura() {
        //DECLARACIONES
        //declaración e instanciación objeto Album
        Album album=new Album();
        
        //ACCIONES
        try {
            //lectura en el fichero de texto de los atributos del objeto Album
            //e inicialización de los atributos leídos en el objeto Album a 
            //devolver
            album.setPosicion(Integer.parseInt(fichero.readLine()));
            album.setAñoEdicion(Integer.parseInt(fichero.readLine()));
            album.setTitulo(fichero.readLine());
            album.setArtista(fichero.readLine());
            album.setTipoAlbum(fichero.readLine());
            album.setNumEstrellas(Float.parseFloat(fichero.readLine()));
            album.setNumEdiciones(Integer.parseInt(fichero.readLine()));
        }catch (NumberFormatException error) {
            //devolveremos null ya que significará que habremos llegado al final
            //del fichero (cuando hagamos Integer.parseInt al final del fichero
            //nos salta esta excepción)
            return null;
        }
        catch (IOException error) {
            System.err.println("ERROR: "+error.toString());
        }
        //devolvemos el objeto album
        return album;
    }
    
    //método cierreEnlaceFichero
    public void cierreEnlaceFichero() {
        try {
            //comprobamos si realmente se ha establecido enlace con el fichero
            if (fichero!=null) {
                //cerramos el enlace
                fichero.close();
            }
        }catch (IOException error) {
            System.err.println("ERROR: "+error.toString());
        }
    }
}
