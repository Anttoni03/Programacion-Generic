package Taller1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class FicheroAlbumLectura {
    
    //DECLARACIÓN DE ATRIBUTOS
    //atributo de objeto que indica el fichero a leer
    private BufferedReader fichero;
    
    private int cantidadObjetos;
    //atributo de clase que indica el código del salto de línea
    private final char SALTO_LINEA = '\n';
    //atributo de clase que indica el código de final de fichero
    private static final int FINAL_SECUENCIA = -1;
    
    private String rutaFichero;
    
    //MÉTODOS
    //método constructor con la ruta del fichero a leer
    public FicheroAlbumLectura(String rutaFichero)
    {
        try{
            this.rutaFichero = rutaFichero;
            fichero = new BufferedReader(new FileReader(rutaFichero));
        } catch (IOException e){
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    
    //método esLetra que devuelve si un carácter indicado es o no una letra
    public boolean esLetra(char caracter)
    {   
        return (int)caracter >= (int)'a' && (int)caracter <= (int)'z';
    }
    
    //método esLetra que devuelve si un carácter indicado corresponde a un
    //carácter numérico
    public boolean esNumero(char caracter)
    {
        return (int)caracter >= (int)'0' && (int)caracter <= (int)'9';
    }
    
    
    //método lecturaEntero que lee una linea y la convierte a entero
    public int lecturaEntero()
    {
        int resultado = 0;
        
        try{
            resultado = Integer.parseInt(fichero.readLine());
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        } finally {
            return resultado;
        }
    }
    
    //método lecturaDouble que lee una linea y la convierte a double
    public double lecturaDouble()
    {
        double resultado = 0;
        
        try{
            resultado = Double.parseDouble(fichero.readLine());
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        } finally {
            return resultado;
        }
    }
    
    //método lecturaLinea que lee una linea y la devuelve
    public String lecturaLinea()
    {
        String resultado = "";
        
        try{
            resultado = fichero.readLine();
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        } finally {
            return resultado;
        }
    }
    
    //método lecturaAlbum que lee los atributos necesarios para generar un
    //objeto Album y lo devuelve
    public Album lecturaAlbum()
    {
        Album album = null;
        try{
            album = new Album();
            album.setPosicion(lecturaEntero());
            album.setAny(lecturaEntero());
            album.setTitulo(lecturaLinea());
            album.setArtista(lecturaLinea());
            album.setTipo(lecturaLinea());
            album.setEstrellas(lecturaDouble());
            album.setEdiciones(lecturaEntero());
        } finally {
            return album;
        }
    }
    
    public int getCantidadObjetos()
    {
        return cantidadObjetos;
    }
    
    public void contarObjetos()
    {
        int contador = 1;
        int codigo;
        try{
            RandomAccessFile fichero2 = new RandomAccessFile(rutaFichero, "r");
            codigo = fichero2.read();
            while (codigo != -1)
            {
                if (codigo == SALTO_LINEA) contador++;
                codigo = fichero2.read();
            }
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        } finally {
            cantidadObjetos = contador / Album.getCantidadLineas();
        }
    }
    
    //método cerrarEnlace que cierra el enlace con el fichero
    public void cerrarEnlace()
    {
        try
        {
            fichero.close();
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
}