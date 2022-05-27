package Taller1;

import java.io.*;

public class FicheroAlbumInOut {
    
    //DECLARACIÓN DE ATRIBUTOS
    //Atributo de objeto que indica el fichero con el que se trabaja
    private RandomAccessFile fichero;
    
    //MÉTODOS
    //Método constructor con el nombre del fichero
    public FicheroAlbumInOut(String nombreFichero)
    {
        try{
            fichero = new RandomAccessFile(nombreFichero, "rw");
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    //MÉTODOS FUNCIONALES
    //Método lectura que realiza la lectura de un AlbumVotos en la posición del
    //puntero actual y lo devuelve
    public AlbumVotos lectura()
    {
        AlbumVotos album = new AlbumVotos();
        
        try{
            album.setPosicion(fichero.readInt());
            album.setVotos(fichero.readInt());
            album.setTitulo(lecturaString(40));
            album.setArtista(lecturaString(40));
            album.setAny(fichero.readInt());
            album.setEdiciones(fichero.readInt());
            album.setTipo(lecturaString(40));
            album.setEstrellas(fichero.readDouble());
        } catch (EOFException e) {
            
        }
        catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
        
        return album;
    }
    
    //Método lectura que realiza la lectura de un AlbumVotos en la posición que
    //se indique por parámetro y lo devuelve
    public AlbumVotos lectura(int posicion)
    {
        //Inicialización del álbum a leer y devolver
        AlbumVotos album = new AlbumVotos();
        try{
            //Se aplica el puntero a la posición indicada con la dimensión en
            //bytes del la clase y se realiza la lectura, luego se devuleve el
            //puntero a la posición inicial
            if (0 < posicion && posicion <= fichero.length() / AlbumVotos.getDimension())
            {
                long pointer = fichero.getFilePointer();
                fichero.seek((posicion - 1) * AlbumVotos.getDimension());
                album = lectura();
                fichero.seek(pointer);
            }
            else
            {
                throw new InsercionDatosException("EL ÁLBUM A LEER NO EXISTE");
            }
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (InsercionDatosException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
        
        return album;
    }
    
    //Método escritura que escribe el AlbumVotos indicado al final del fichero
    public void escritura(AlbumVotos album)
    {
        try{
            fichero.seek(fichero.length());
            
            fichero.writeInt(album.getPosicion());
            fichero.writeInt(album.getVotos());
            fichero.writeChars(escrituraString(album.getTitulo(), 40));
            fichero.writeChars(escrituraString(album.getArtista(), 40));
            fichero.writeInt(album.getAny());
            fichero.writeInt(album.getEdiciones());
            fichero.writeChars(escrituraString(album.getTipo(), 40));
            fichero.writeDouble(album.getEstrellas());
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    //Método escritura que escribe el AlbumVotos indicado en la posición
    //indicada con la longitud en bytes de la clase AlbumVotos
    public void escritura(AlbumVotos album, int posicion)
    {
        try{
            if (0 < posicion && posicion <= fichero.length() / AlbumVotos.getDimension())
            {
                fichero.seek((posicion - 1) * AlbumVotos.getDimension());
            
                fichero.writeInt(album.getPosicion());
                fichero.writeInt(album.getVotos());
                fichero.writeChars(escrituraString(album.getTitulo(), 40));
                fichero.writeChars(escrituraString(album.getArtista(), 40));
                fichero.writeInt(album.getAny());
                fichero.writeInt(album.getEdiciones());
                fichero.writeChars(escrituraString(album.getTipo(), 40));
                fichero.writeDouble(album.getEstrellas());
            }
            else
            {
                throw new InsercionDatosException("EL ÁLBUM A REESCRIBIR NO EXISTE. POS "+posicion);
            }
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (InsercionDatosException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    //Método votar que cambia un AlbumVoto del fichero indicado por el voto y
    //lo reescribe en la misma posición
    public void votar(Voto voto)
    {
        //Declaración del álbum a leer y cambiar
        AlbumVotos album;
        
        //Lectura y cambio de votos del álbum
        album = lectura(voto.getPosicion());
        album.setVotos(album.getVotos() + voto.getPuntuacion());
        
        //Reescritura del objeto en su posición original
        escritura(album, voto.getPosicion());
    }
    
    //Método lecturaString que devuelve un String con los carácteres indicados
    //del fichero
    private String lecturaString(int cantidadCaracteres)
    {
        String temp = "";
        
        try{
            for (int i = 0; i < cantidadCaracteres; i++)
            {
                temp += fichero.readChar();
            }
        } catch (IOException e){
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e){
            System.err.println("ERROR: " + e.toString());
        }
        finally {
            return temp;
        }
    }
    
    //Método escrituraString que gestiona la escritura de un texto indicado con
    //la longitud de carácteres indicada al fichero
    private String escrituraString(String texto, int cantidadCaracteres)
    {
        String temp = "";
        try{
            for (int i = 0; i < texto.length() && i < cantidadCaracteres; i++)
            {
                temp += texto.charAt(i);
            }
            
            if (texto.length() < cantidadCaracteres){
                for (int i = 0; i < cantidadCaracteres - texto.length(); i++)
                {
                    temp += ' ';
                }
            }
        } catch (Exception e){
            System.err.println("ERROR: " + e.toString());
        } finally{
            return temp;
        }
    }
    
    //Método cerrarEnlace que cierra el enlace con el fichero
    public void cerrarEnlace()
    {
        try{
            fichero.close();
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
}