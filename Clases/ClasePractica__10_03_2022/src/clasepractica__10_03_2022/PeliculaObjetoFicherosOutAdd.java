/*
CLASE PeliculaObjetoFicherosIn posibilita la gestión de la escritura de objetos
Pelicula en un fichero utilizando la clase AddObjectOutputStream que permite
la adición de objetos
 */
package clasepractica__10_03_2022;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PeliculaObjetoFicherosOutAdd {
    //DECLARACIÓN DE ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura de
    //objetos en un fichero utilizando la clase ObjectOutputStream para el caso
    //que el fichero sea de nueva creación
    ObjectOutputStream fichero1=null;
    //declaración objeto AdicionObjectOutputStream para posibilitar la escritura de
    //objetos en un fichero utilizando la clase ObjectOutputStream para el caso
    //que en el fichero se vayan a añadir objetos
    AdicionObjectOutputStream fichero2=null;
    
    //MÉTODO CONSTRUCTOR
    public PeliculaObjetoFicherosOutAdd(String nombreFichero) {
        try {
            //declaración e instanciación objeto File con el fichero físico nombreFichero
            File f=new File(nombreFichero);
            //verificar si el fichero nombreFichero existe
            if (f.exists()) {
                //instanciación objeto AdicionObjectOutputStream fichero2 para el establecimiento
                //del enlace con el fichero a nivel de adición de objetos preservando
                //el contenido del fichero existente
                fichero2=new AdicionObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero,true)));
            }else {
                //instanciación objeto ObjectOutputStream fichero para establecer
                //en enlace con el fichero físico nombreFichero
                fichero1=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero)));                
            }
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: ESTABLECIMIENTO ENLACE CON EL FICHERO "+nombreFichero);
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO "+nombreFichero);
        }
    }
    
    //MÉTODOS FUNCIONALES
    
    //método escritura lleva a cabo la grabación del objeto Pelicula, dado por teclado,
    //en el fichero correspondiente
    public void escritura(Pelicula pelicula) {
        try {
            //verificar con que objeto fichero se tiene que llevar a cabo la escritura
            if (fichero1==null) {
                //escritura objeto Pelicula pelicula en el fichero con el objeto fichero2
                fichero2.writeObject(pelicula);
            }
            else {
                //escritura objeto Pelicula pelicula en el fichero con el objeto fichero
                fichero1.writeObject(pelicula);                
            }

        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO");
        }
    }
    
    //método cerrarEnlaceFichero lleva a cabo el cierre del enlace con el fichero
    //correspondiente
    public void cerrarEnlaceFichero() {
        try {
            if (!((fichero1==null)&&(fichero2==null))) {
                //verificar con qué objeto fichero se ha establecido el enlace
                if (fichero1==null) {
                    //cierre enlace objeto fichero2
                    fichero2.close();
                }
                else {
                    //cierre enlace objeto fichero1
                    fichero1.close();
                }   
            }
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO");
        }
    }    
}
