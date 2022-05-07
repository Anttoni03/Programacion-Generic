package taller1;

/*
Classe que permet llegir i escriure a fitxers .dat
 */
import java.io.*;
import taller1.Clase_Album;

public class FicheroClase_AlbumInOut {
    
    //Declaració d'atributs
    //declaració d'objeto RandomAccessFile per possibilitar la lectura/escritura
    //d'objetes Clase_Album desde/en fitxer
    RandomAccessFile fichero = null;
    //declaración objeto Contacto
    Clase_Album album = new Clase_Album();
    
    
    //MÈTODES
    //mètode constructor
    public FicheroClase_AlbumInOut(String nombreFichero) throws Exception { 
        try {
            //instanciació de l'objecet RandomAccessFile per establir l'enllaç 
            //amb el fitxer a nivell de lectura/escritura
            fichero = new RandomAccessFile(nombreFichero,"rw");
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }    
    
    
    
    //Mètodes Funcionals
    //mètode de lectura que possibilita la lectura de un objecte Clase_Album desde
    //el fitxer
    public Clase_Album lectura() {
        //DECLARACIONES
        //declaración objeto Contacto
        Clase_Album album= new Clase_Album();
        
        //ACCIONES
        try {
            //lectura camp atributo codigo del objeto Contacto
            album.setPosicion_en_la_lista(fichero.readInt());
            //lectura camp edicion
            album.setAño_edicion(fichero.readInt());
            //lectura camp titulo a través del mètode lecturaString
            album.setTitulo(lecturaString(64));
            //lectura camp artista a través del mètode lecturaString
            album.setArtista(lecturaString(32));
            //lectura camp tipus album
            album.setTipo_Album(lecturaString(32));
            //lectura camp estrellas
            album.setEsterllas(fichero.readDouble());
            //lectura camp ediciones   
            album.setEdiciones(fichero.readInt());
            //lectura del nombre de vots de l'alabum
            album.setVotos(fichero.readInt());
        }catch (EOFException error) {
            return null;
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return album;
    }
    
    //mètod que duu a terme la lectura d'un string desde el fitxer a través de 
    //la lectura de dos caràcters que el formen en funció del nombre donats per
    //paràmetre
    private String lecturaString(int dimension) {
        //Declaracions
        //declaració d'un string per enquedear els caracters que van sent llegits
        //desde el fitxer
        String campo="";
        
        try {
            //Accions
            //bucle de lectura i enquedenement dels caracters desde el fitxer 
            for (int i=0;i<dimension;i++) {
                //enquedenament en el stringcampo del caracter llegit desde el
                //fitxer
                campo=campo+fichero.readChar();
            }  
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
            return campo;            
        }
        //devolució de l'estring resultant
        return campo;
    }
    
    //método escritura que posibilita la adicion de un objeto Contacto en el
    //fichero
    public  void escritura(Clase_Album album) {
        try {
            //posicionamiento puntero del fichero para escribir el nuevo objeto
            //Contacto dado al final del fichero
            fichero.seek(fichero.length());
            //escritura en el fichero del atributo código correspondiente al
            //objeto contacto 
            fichero.writeInt(album.getPosicion_en_la_lista());
            //escritura en el fichero del atributo nombre. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre
            fichero.writeInt(album.getAño_edicion());
            //escritura en el fichero del atributo telefono. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre
            escrituraString(album.getTitulo(), 64);
            //escritura en el fichero del atributo email. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre            
            escrituraString(album.getArtista(), 32);
            //escritura en el fichero del atributo direccion. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre            
            escrituraString(album.getTipo_album(), 32);
            //escritura en el fichero del atributo edad correspondiente al
            //objeto contacto 
            fichero.writeDouble(album.getEstrellas()); 
            //escritura en el fichero del atributo elimiando correspondiente al
            //objeto contacto 
            fichero.writeInt(album.getEdiciones());
            
            fichero.writeInt(album.getVotos());
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    
    //mètode extret dels exercicis proporcionats per part del professor:
    //método que lleva a cabo la escritura de un String en el fichero a través 
    //de la escritura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private void escrituraString (String campo, int dimension) throws IOException {
        try {
            //bucle de escritura en el fichero, caracter a caracter, del String
            //y en función de la dimensión dada
            for (int i=0;((i<dimension) && (i<campo.length())); i++) {
                //escritura en el fichero del caracter i-ésimo del String
                fichero.writeChar(campo.charAt(i));
            }
            //verificar si la dimensión del String dado es menor que la dimensión
            //del atributo que debe representar del objeto Contacto
            if (campo.length()<dimension) {
                //al ser la dimnensión del String menor que la dimensión del atributo
                //que representa del objeto Contacto se escribirán caracteres
                //espacio hasta llegar a la dimensión del atributo
                for (int i=0; i<(dimension-campo.length()); i++) {
                    //escritura en el fichero del caracter espacio
                    fichero.writeChar(' ');
                }
            }            
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());            
        }
    }
    //mètode per tancar el fitxer
    public void cierre() throws Exception {
        try {
            fichero.close();            
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //método lectura que posibilita la lectura de un objeto Contacto desde el
    //fichero dado la posición del elemento de fichero Contacto
    public Clase_Album lectura(int posicion) {
        //DECLARACIONES
        //declaración objeto Contacto
        Clase_Album album = new Clase_Album();
        
        //ACCIONES
        try {
            //verificación si la posición del elemento a leer existe en el fichero
            if ((posicion>0)&&(posicion<=(fichero.length()/Clase_Album.getDIMENSION()))) {
                //posicionamiento puntero del fichero en el elemento de fichero
                //album dado
                fichero.seek(((posicion-1)*Clase_Album.getDIMENSION()));
                //lectura de la posició de l'objecte album
                album.setPosicion_en_la_lista(fichero.readInt());
                //lectura del camp atribut any d'edició
                album.setAño_edicion(fichero.readInt());
                //lectura campo atributo titulo del objeto album a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                album.setTitulo(lecturaString(64));
                //lectura campo atributo artista del objeto album a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                album.setArtista(lecturaString(32));
                //lectura campo atributo tipo album del objeto album a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                album.setTipo_Album(lecturaString(32));
                //lectura del campo atributo de número de estrellas
                album.setEsterllas(fichero.readDouble());
                //lectura campo atributo ediciones del objeto album
                album.setEdiciones(fichero.readInt());
                //lectura del campo atributo de número de votos
                album.setVotos(fichero.readInt());
            }
            else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new EntradaIncorrecta("CONTACTO NO EXISTENTE");                
            }
        }catch (EntradaIncorrecta error) {
            System.out.println(error.toString());
            return album;
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return album;
    }
    
        //método que posibilita la reescritura en el fichero de un objeto Contacto
    //en función del posicion que ocupa en el fichero
    public void escritura(Clase_Album contacto,int posicion) {
        try {
            //verificación si la posición del contacto a leer existe en el fichero
            if ((posicion>0)&&(posicion<=(fichero.length()/Clase_Album.getDIMENSION()))) {
                //posicionamiento del puntero en el elemento de fichero objeto Contacto
                //correspondiente al número dado por parámetro
                fichero.seek((posicion-1)*Clase_Album.getDIMENSION());            
                //escritura en el fichero del atributo código correspondiente al
                //objeto contacto 
                fichero.writeInt(album.getPosicion_en_la_lista());
                //escritura en el fichero del atributo nombre. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre
                fichero.writeInt(album.getAño_edicion());
                //escritura en el fichero del atributo titulo Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre
                escrituraString(album.getTitulo(), 64);
                //escritura en el fichero del atributo artista Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre            
                escrituraString(album.getArtista(), 32);
                //escritura en el fichero del atributo direccion. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre            
                escrituraString(album.getTipo_album(), 32);
                //escritura en el fichero del atributo edad correspondiente al
                //objeto contacto 
                fichero.writeDouble(album.getEstrellas());
                //escritura en el fichero del atributo elimiando correspondiente al
                //objeto contacto 
                fichero.writeInt(album.getEdiciones());
                //escritura en el fichero del atributo votos 
                fichero.writeInt(album.getVotos());
            }
            else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new EntradaIncorrecta("NO ES POSIBLE ESCRIBIR EL CONTACTO DADO");                 
            }
        }catch (EntradaIncorrecta error) {
            System.out.println(error.toString());
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
}
