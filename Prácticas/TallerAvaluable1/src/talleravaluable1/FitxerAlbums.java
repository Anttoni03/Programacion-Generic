/*
CREADOR: TONI ROCA CASTRO
CLASE FitxerAlbums
 */
package talleravaluable1;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FitxerAlbums {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //declaración objeto RandomAccessFile
    private RandomAccessFile fichero=null;
    
    //MÉTODOS CONSTRUCTORES
    public FitxerAlbums(String nombreFichero) {
        try {
            //instanciación objeto RandomAccessFile
            fichero=new RandomAccessFile(nombreFichero,"rw");
        }catch (FileNotFoundException error) {
            System.err.println("ERROR: "+error.toString());
        }
    }
    
    //MÉTODOS FUNCIONALES
    //método lectura
    public Album lectura() {
        //DECLARACIONES
        //declaración objeto Album
        Album album=new Album();
        
        //ACCIONES
        try {
            //lectura de todos los atributos del objeto Album a leer
            album.setPosicion(fichero.readInt());
            album.setAñoEdicion(fichero.readInt());
            album.setTitulo(lecturaString(40));
            album.setArtista(lecturaString(40));
            album.setTipoAlbum(lecturaString(20));
            album.setNumEstrellas(fichero.readFloat());
            album.setNumEdiciones(fichero.readInt());
            album.setNumVotos(fichero.readInt());
            
        }catch (EOFException error) {
            return null;
        }catch (IOException error) {
            System.err.println("ERROR: "+error.toString());
        }
        //devolución objeto album 
        return album;
    }
    
    //método lectura, posibilita la lectura de un objeto Album contenido en el
    //fichero en la posición pasada por parámetro
    public Album lectura(int pos) {
        //DECLARACIONES
        //declaración objeto Album
        Album album=new Album();
        
        //ACCIONES
        try {
            //comprobamos que la introducción pasada por parámetro sea válida
            if ((pos>0)&&(pos<=fichero.length()/Album.getDIMENSION())) {
                //fijamos el puntero a la posición correspondiente
                fichero.seek((pos-1)*Album.getDIMENSION());
                //lectura de todos los atributos del objeto Album a leer
                album.setPosicion(fichero.readInt());
                album.setAñoEdicion(fichero.readInt());
                album.setTitulo(lecturaString(40));
                album.setArtista(lecturaString(40));
                album.setTipoAlbum(lecturaString(20));
                album.setNumEstrellas(fichero.readFloat());
                album.setNumEdiciones(fichero.readInt());
                album.setNumVotos(fichero.readInt());
            }else {
                //invocamos la excepción no predefinida en caso de que la
                //opción introducida no sea válida
                throw new InsercioDadesException("OPCIÓN DE LECTURA NO VÁLIDA");
            }
        }catch (InsercioDadesException | IOException error)  {
            System.err.println("ERROR: "+error.toString());
            return album;
        }
        //devolución objeto album 
        return album;
    }
    
    //método lecturaString, permite leer un String contenido en el fichero
    //pasando por parámetro la longitud de dicho String
    private String lecturaString(int caracteres) {
        //DECLARACIONES
        //declaración String a devolver
        String string="";
        
        //ACCIONES
        try {
            //bucle lectura caracteres del String a leer en el fichero
            for (int i=0;i<caracteres;i++) {
                string=string+fichero.readChar();
            }
        }catch (IOException error) {
            System.err.println("ERROR: "+error.toString());
            return string;
        }
        //devolución String leído
        return string;
    }
    
    //método escritura
    public void escritura(Album album) {
        //ACCIONES
        try {
            //escritura de todos los atributos del objeto album a escribir
            fichero.writeInt(album.getPosicion());
            fichero.writeInt(album.getAñoEdicion());
            escrituraString(album.getTitulo(), 40);
            escrituraString(album.getArtista(), 40);
            escrituraString(album.getTipoAlbum(), 20);
            fichero.writeFloat(album.getNumEstrellas());
            fichero.writeInt(album.getNumEdiciones());
            fichero.writeInt(album.getNumVotos());
        }catch (IOException error) {
            System.err.println("ERROR: "+error.toString());
        }
    }
    
    //método escritura, posibilita la reescritura de un objeto Album
    //existente en el fichero en la posición pasada por parámetro
    public void escritura(Album album, int pos) {
        //ACCIONES
        try {
            //comprobamos la válidez de la posición pasada por parámetro
            if ((pos>0)&&(pos<=fichero.length()/Album.getDIMENSION())) {
                //fijamos el puntero a la posición correspondiente
                fichero.seek((pos-1)*Album.getDIMENSION());
                //escritura de todos los atributos del objeto album a escribir
                fichero.writeInt(album.getPosicion());
                fichero.writeInt(album.getAñoEdicion());
                escrituraString(album.getTitulo(), 40);
                escrituraString(album.getArtista(), 40);
                escrituraString(album.getTipoAlbum(), 20);
                fichero.writeFloat(album.getNumEstrellas());
                fichero.writeInt(album.getNumEdiciones());
                fichero.writeInt(album.getNumVotos());
            }else {
                //invocamos la excepción no predefinida en caso de que la
                //opción introducida no sea válida
                throw new InsercioDadesException("OPCIÓN DE ESCRITURA NO VÁLIDA");
            }
        }catch (InsercioDadesException error) {
            System.err.println("ERROR: "+error);
        }
        catch (IOException error) {
            System.err.println("ERROR: "+error.toString());
        }
    }
    
    //método escrituraString, permite escribir un String en el fichero indicando
    //la longitud de dicho String por parámetro
    private void escrituraString(String dato,int dim) {
        //ACCIONES
        try {
            //bucle de escritura del String pasado por parámetro caracter a caracter
            for (int i=0;(i<dato.length())&&(i<dim);i++) {
                fichero.writeChar(dato.charAt(i));
            }
            //verificación de si la dimensión del String dado es menor que la 
            //dimensión del atributo que representa
            if (dato.length()<dim) {
                //escritura de espacios en blanco para completar los caracteres
                //para llegar a la dimensión del atributo que representa el dato
                for (int i=0;i<(dim-dato.length());i++) {
                    fichero.writeChar(' ');
                }
            }
        }catch (IOException error) {
            System.err.println("ERROR: "+error.toString());
        }
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
