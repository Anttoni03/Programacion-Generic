package taller1;

//Creador: Nahuel Vazquez

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//Clase que permite la lectura de objetos albumes desde un archivo de acceso random
public class FitxerAlbums {

    //DECLARACIÓN ATRIBUTOS
    //declaración objeto RandomAccessFile para posibilitar la lectura/escritura
    //de objetos Album desde/en fichero
    private RandomAccessFile fichero = null;
    
    private final static int SIZE_TITULO = 61;//tamaño maximo en bytes del Titulo
    private final static int SIZE_ARTISTA = 29;//Tamaño maximo en bytes del Artista
    private final static int SIZE_TIPO = 19;//Tamaño maximo en bytes del tipo de album
    

    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public FitxerAlbums(File nombreFichero) {
        try {
            //instanciación objeto RandomAccessFile para establecer el enlace con
            //el fichero a nivel de lectura/escritura
            fichero = new RandomAccessFile(nombreFichero, "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
    }

    //METODOS FUNCIONALES
    //método escritura que posibilita la escritura de un objeto Album en el
    //fichero
    public void escritura(Album album) {
        try {
            //posicionamiento del puntero al final del fichero de objetos Album
            fichero.seek(fichero.length());
            //escritura en el fichero del atributo posicion correspondiente al
            //objeto Album 
            fichero.writeInt(album.getPosicion());
            //escritura en el fichero del atributo Año Publicado correspondiente al
            //objeto Album 
            fichero.writeInt(album.getAnoPublicado());
            //escritura en el fichero del atributo Titulo. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo Titulo
            escrituraString(album.getTitulo(), SIZE_TITULO);
            //escritura en el fichero del atributo Artista. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo Artista
            escrituraString(album.getArtista(), SIZE_ARTISTA);
            //escritura en el fichero del atributo Tipo. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo Tipo
            escrituraString(album.getTipo(), SIZE_TIPO);
            //escritura en el fichero del atributo Estrellas correspondiente al
            //objeto Album 
            fichero.writeFloat(album.getEstrellas());
            //escritura en el fichero del atributo Ediciones correspondiente al
            //objeto Album 
            fichero.writeInt(album.getEdiciones());
            //escritura en el fichero del atributo Votos correspondiente al
            //objeto Album 
            fichero.writeInt(album.getVotos());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método que posibilita la reescritura en el fichero de un objeto Album
    //en función del número que ocupa en el fichero
    public void escritura(Album album, int posicion) {
        try {
            //verificación si la posición del album a leer existe en el fichero
            if ((posicion > 0) && (posicion <= (fichero.length() / Album.getDimension()))) {
                //posicionamiento del puntero en el album de fichero objeto Album
                //correspondiente al número dado por parámetro
                fichero.seek((posicion - 1) * Album.getDimension());
                //escritura en el fichero del atributo posicion correspondiente al
                //objeto Album 
                fichero.writeInt(album.getPosicion());
                //escritura en el fichero del atributo Año Publicado correspondiente al
                //objeto Album 
                fichero.writeInt(album.getAnoPublicado());
                //escritura en el fichero del atributo Titulo. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo Titulo
                escrituraString(album.getTitulo(), SIZE_TITULO);
                //escritura en el fichero del atributo Artista. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo Artista
                escrituraString(album.getArtista(), SIZE_ARTISTA);
                //escritura en el fichero del atributo Tipo. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo Tipo
                escrituraString(album.getTipo(), SIZE_TIPO);
                //escritura en el fichero del atributo Estrellas correspondiente al
                //objeto Album 
                fichero.writeFloat(album.getEstrellas());
                //escritura en el fichero del atributo Ediciones correspondiente al
                //objeto Album 
                fichero.writeInt(album.getEdiciones());
                //escritura en el fichero del atributo Votos correspondiente al
                //objeto Album 
                fichero.writeInt(album.getVotos());
            } else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new InsercioDadesException("NO ES POSIBLE ESCRIBIR EL ELEMENTO DADO");
            }
        } catch (InsercioDadesException error) {
            System.out.println(error.toString());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método que lleva a cabo la escritura de un String en el fichero a través 
    //de la escritura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private void escrituraString(String campo, int dimension) throws IOException {
        try {
            //bucle de escritura en el fichero, caracter a caracter, del String
            //y en función de la dimensión dada
            for (int i = 0; ((i < dimension) && (i < campo.length())); i++) {
                //escritura en el fichero del caracter i-ésimo del String
                fichero.writeChar(campo.charAt(i));
            }
            //verificar si la dimensión del String dado es menor que la dimensión
            //del atributo que debe representar del objeto Contacto
            if (campo.length() < dimension) {
                //al ser la dimnensión del String menor que la dimensión del atributo
                //que representa del objeto Contacto se escribirán caracteres
                //espacio hasta llegar a la dimensión del atributo
                for (int i = 0; i < (dimension - campo.length()); i++) {
                    //escritura en el fichero del caracter espacio
                    fichero.writeChar(' ');
                }
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método lectura que posibilita la lectura de un objeto Album desde el
    //fichero
    public Album lectura() {
        //DECLARACIONES
        //declaración objeto Contacto
        Album album = new Album();

        //ACCIONES
        try {
            //lectura campo atributo posicion del objeto Album
            album.setPosicion(fichero.readInt());
            //lectura campo atributo año del objeto Album
            album.setAnoPublicado(fichero.readInt());
            //lectura campo atributo titulo del objeto Album a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            album.setTitulo(lecturaString(SIZE_TITULO));
            //lectura campo atributo artista del objeto Album a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            album.setArtista(lecturaString(SIZE_ARTISTA));
            //lectura campo atributo tipo del objeto Album a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            album.setTipo(lecturaString(SIZE_TIPO));
            //lectura campo atributo Estrellas del objeto Album
            album.setEstrellas(fichero.readFloat());
            //lectura campo atributo Ediciones del objeto Album
            album.setEdiciones(fichero.readInt());
            //lectura campo atributo votos del objeto Album
            album.setVotos(fichero.readInt());
        } catch (EOFException error) {
            return null;
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return album;
    }

    //método lectura que posibilita la lectura de un objeto Album desde el
    //fichero dado el número del album de fichero Album
    public Album lectura(int posicion) {
        //DECLARACIONES
        //declaración objeto Contacto
        Album album = new Album();

        //ACCIONES
        try {
            //verificación si la posición del album a leer existe en el fichero
            if ((posicion > 0) && (posicion <= (fichero.length() / Album.getDimension()))) {
                //posicionamiento puntero del fichero en el album de fichero
                //Album dado
                fichero.seek(((posicion - 1) * Album.getDimension()));
                //lectura campo atributo posicion del objeto Album
                album.setPosicion(fichero.readInt());
                //lectura campo atributo año del objeto Album
                album.setAnoPublicado(fichero.readInt());
                //lectura campo atributo titulo del objeto Album a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                album.setTitulo(lecturaString(SIZE_TITULO));
                //lectura campo atributo artista del objeto Album a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                album.setArtista(lecturaString(SIZE_ARTISTA));
                //lectura campo atributo tipo del objeto Album a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                album.setTipo(lecturaString(SIZE_TIPO));
                //lectura campo atributo Estrellas del objeto Album
                album.setEstrellas(fichero.readFloat());
                //lectura campo atributo Ediciones del objeto Album
                album.setEdiciones(fichero.readInt());
                //lectura campo atributo votos del objeto Album
                album.setVotos(fichero.readInt());
            } else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new InsercioDadesException("POSICIÓN NO EXISTENTE");
            }
        } catch (InsercioDadesException error) {
            System.out.println(error.toString());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return album;
    }

    //método que lleva a cabo la lectura de un String desde el fichero a través 
    //de la lectura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private String lecturaString(int dimension) {
        //DECLARACIONES
        //declaración String para ir concatenando los caracteres que van a ser
        //leidos desde el fichero
        String campo = "";

        try {
            //ACCIONES
            //bucle de lectura y concatenación de los caracteres desde el fichero
            for (int i = 0; i < dimension; i++) {
                //concatenación en el String campo del caracter leido desde el
                //fichero
                campo = campo + fichero.readChar();
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        //devolución del String resultante
        return campo;
    }

    public void close() {
        try {
            fichero.close();
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.toString());
        }
    }

}
