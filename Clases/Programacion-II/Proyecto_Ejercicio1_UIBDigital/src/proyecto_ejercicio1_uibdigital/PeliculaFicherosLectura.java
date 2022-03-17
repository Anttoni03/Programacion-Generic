/*
CLASE PalabraFicherosIn
Aglutina las delcaraciones y funcionalidades necesarias para posibilitar la lectura
de objetos Palabra desde un fichero de texto
 */
package proyecto_ejercicio1_uibdigital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PeliculaFicherosLectura {
    //DECLARACIONES ATRIBUTOS
    //declaración atributo de objeto BufferedReader que posibilite el enlace
    //con el fichero de texto a nivel de lectura
    private BufferedReader fichero=null;
    
    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public PeliculaFicherosLectura(String nombreFichero){
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
    public Pelicula lectura() {
        //DECLARACIONES
        //declaración objeto Palabra que reporesentara la pelicula leida desde
        //el fichero
        Pelicula pelicula=null;
        //declaración String linea para almacenar las lineas leidas desde el fichero
        String linea=null;
        //declaraciones Strings para representar los variables temporales correspondientes
        //a los atributos titulo y director de un objeto Pelicula
        String titulo,director;
        //declaración variable entera para representar la variable temporal correspondiente
        //al atributo año de un objeto Pelicula
        int año;
        
        //ACCIONES
        try {
            //lectura linea desde el fichero
            linea=fichero.readLine();
            if (linea!=null) {
                //asignar a titulo la linea leída
                titulo=linea;
                //lectura siguiente linea y asignación a director de la misma
                director=fichero.readLine();
                //lectura siguiente linea y asignación, una vez convertida a entera, a año
                año=Integer.parseInt(fichero.readLine());
                //instanciación objeto película
                pelicula=new Pelicula(titulo,director,año);
            } 
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA EN EL FICHERO");
        }
        finally {
            //Devolver el objeto Pelicula
            return pelicula;     
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
