package Taller1;

import java.io.*;

public class FicheroAlbumInOut {
    
    private RandomAccessFile fichero;
    
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
    
    public AlbumVotos lectura(int posicion)
    {
        AlbumVotos album = new AlbumVotos();
        try{
            if (0 < posicion && posicion <= fichero.length() / AlbumVotos.getDimension())
            {
                long pointer = fichero.getFilePointer();
                fichero.seek((posicion - 1) * AlbumVotos.getDimension());
                album = lectura();
                fichero.seek(pointer);
            }
            else
            {
                throw new InsercioDadesException("EL ÁLBUM A LEER NO EXISTE");
            }
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (InsercioDadesException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
        
        return album;
    }
    
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
                throw new InsercioDadesException("EL ÁLBUM A REESCRIBIR NO EXISTE. POS "+posicion);
            }
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (InsercioDadesException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    public void votar(Voto voto)
    {
        AlbumVotos album;
        album = lectura(voto.getPosicion());
        album.setVotos(album.getVotos() + voto.getPuntuacion());
        escritura(album, voto.getPosicion());
    }
    
    
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