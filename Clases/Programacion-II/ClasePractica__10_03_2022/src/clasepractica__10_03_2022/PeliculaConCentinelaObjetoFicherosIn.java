/*
CLASE PeliculaObjetoFicherosIn posibilita la gestión de la lectura de objetos
PeliculaConCentinela desde un fichero utilizando la clase ObjectInputStream
 */
package clasepractica__10_03_2022;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PeliculaConCentinelaObjetoFicherosIn {
    //DECLARACIÓN DE ATRIBUTOS
    //declaración objeto ObjectInputStream para posibilitar la lectura desde
    //un fichero a través de objetos
    ObjectInputStream fichero=null;
    
    //MÉTODO CONSTRUCTOR
    public PeliculaConCentinelaObjetoFicherosIn(String nombreFichero) {
        try {
            //instanciar objeto ObjectInputStream fichero para establecer el
            //enlace con el fichero físico nombreFichero
            fichero=new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreFichero)));
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: ESTABLECIMIENTO ENLACE CON EL FICHERO "+nombreFichero);
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO "+nombreFichero);
        }
    }
    
    //MÉTODOS FUNCIONALES
    
    //método lectura lleva a cabo la lectura de un objeto Pelicula desde el fichero
    //correspondiente
    public PeliculaConCentinela lectura() {
        //DECLARACIONES
        PeliculaConCentinela pelicula=new PeliculaConCentinela();
        
        //ACCIONES
        try {
            //lectura objeto Pelicula desde el fichero
            pelicula= (PeliculaConCentinela) fichero.readObject();
        }catch (IOException error) {
            pelicula=null;
            System.out.println("ERROR DE LECTURA CON EL FICHERO");
        }catch (ClassNotFoundException error) {
            pelicula=null;
            System.out.println("ERROR AL NO ENCONTRAR LA CLASE Pelicula");
        }finally {
            return pelicula;     
        }
    }
    
    //método cerrarEnlaceFichero lleva a cabo el cierre del enlace con el fichero
    //correspondiente
    public void cerrarEnlaceFichero() {
        try {
            if (fichero!=null) {
                //cierre del enlace con el fichero
                fichero.close();
            }
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO");
        }
    }    
}
