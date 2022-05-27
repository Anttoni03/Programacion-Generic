/*
CLASE ClaseAlbumFicherosIn
Aglutina las delcaraciones y funcionalidades necesarias para posibilitar la lectura
de objetos Palabra desde un fichero de texto

 */
package taller1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AlbumFicheroLectura {
    //DECLARACIONES ATRIBUTOS
    //declaración atributo de objeto BufferedReader que posibilite el enlace
    //con el fichero de texto a nivel de lectura
    private BufferedReader fichero = null;
    
    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public AlbumFicheroLectura(String nombreFichero){
        try {
            //establecimiento enlace BufferedReader con fichero de texto identificado
            //a través del parámetro String nombreFichero dado
            fichero=new BufferedReader(new FileReader(nombreFichero));            
        }catch (FileNotFoundException error) {
            System.out.println("ERROR EN LA APERTURA DEL FICHERO");
        }
    }
    
    //MÉTODOS FUNCIONALES
    
    //MÉTODO lectura LLEVA A CABO LA LECTURA DE UNA PELICULA DESDE EL FICHERO
    //REPRESENTADO POR EL OBJETO BufferedReader CORRESPONDIENTE
    public Clase_Album lectura() {
        //DECLARACIONES
        //declaración objeto Palabra que reporesentara la pelicula leida desde
        //el fichero
        Clase_Album album = null;
        //declaración String linea para almacenar las lineas leidas desde el fichero
        String linea = null;
        //declaraciones Strings para representar los variables temporales correspondientes
        //a los atributos titulo y director de un objeto Pelicula
        String titulo,artista,tipoA;
        //declaración variable entera para representar la variable temporal correspondiente
        //al atributo año de un objeto Pelicula
        int año;
        int posicion;
        double estrellas;    
        int ediciones;
        //ACCIONES
        try {
            //lectura linea desde el fichero
            linea = fichero.readLine();
            if(linea != null) {
                
                //asignarle la posicion en la lista
                posicion = Integer.parseInt(linea);
                //asignale el año de edicion
                año = Integer.parseInt(fichero.readLine());
                //lectura siguiente linea y asignación a titulo del album
                titulo=fichero.readLine();
                //asignacion del artista/as del albm
                artista = fichero.readLine();
                //asignacion del tipo album
                tipoA = fichero.readLine();
                //asignación de las estrellas del album
                estrellas = Double.parseDouble(fichero.readLine());
                //asignacion de las ediciones
                ediciones = Integer.parseInt(fichero.readLine());
                //instanciación objeto película
                album = new Clase_Album(posicion,año,titulo,artista,tipoA,estrellas,ediciones);
            } 
            
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA EN EL FICHERO");
        }
        finally {
            //Devolver el objeto Pelicula
            return album;     
        }
    }
    
    //MÉTODO cerrarEnlaceFichero QUE LLEVA A CABO EL CIERRE DEL ENLACE BufferedReader
    //con el fichero 
    public void cerrarEnlaceFichero() {
        try {
            fichero.close();
        }catch (IOException error) {
            System.out.println("ERROR AL CERRAR EL FICHERO");
        }
        
    }
    
    
    
    
    
}
