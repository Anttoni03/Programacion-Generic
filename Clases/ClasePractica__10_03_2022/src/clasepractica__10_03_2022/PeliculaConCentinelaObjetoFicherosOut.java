/*
CLASE PeliculaObjetoFicherosIn posibilita la gestión de la escritura de objetos
PeliculaConCentinela en un fichero utilizando la clase ObjectOutputStream
 */
package clasepractica__10_03_2022;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PeliculaConCentinelaObjetoFicherosOut {
    //DECLARACIÓN DE ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura de
    //objetos en un fichero utilizando la clase ObjectOutputStream
    ObjectOutputStream fichero=null;
    
    //MÉTODO CONSTRUCTOR
    public PeliculaConCentinelaObjetoFicherosOut(String nombreFichero) {
        try {
            //instanciación objeto ObjectOutputStream fichero para establecer
            //en enlace con el fichero físico nombreFichero
            fichero=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero)));
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: ESTABLECIMIENTO ENLACE CON EL FICHERO "+nombreFichero);
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO "+nombreFichero);
        }
    }
    
    //MÉTODOS FUNCIONALES
    
    //método escritura lleva a cabo la grabación del objeto PeliculaConCentinela, dado por teclado,
    //en el fichero correspondiente
    public void escritura(PeliculaConCentinela pelicula) {
        try {
            //escritura objeto PeliculaConCentinela pelicula en el fichero
            fichero.writeObject(pelicula);
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO");
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
