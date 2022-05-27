package Taller1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class FicheroAlbumLectura {
    
    //DECLARACIÓN DE ATRIBUTOS
    //Atributo de objeto que indica el fichero a leer
    private BufferedReader fichero;
    //Atributo de objeto que indica la ruta del fichero
    private String rutaFichero;
    //Atributo de clase que indica el código del salto de línea
    private final char SALTO_LINEA = '\n';
    
    
    //MÉTODOS
    //Método constructor con la ruta del fichero a leer
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
        
    //MÉTODOS FUNCIONALES    
    //Método lecturaEntero que lee una linea y la convierte a entero
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
    
    //Método lecturaDouble que lee una linea y la convierte a double
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
    
    //Método lecturaLinea que lee una linea y la devuelve
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
    
    //Método lecturaAlbum que lee los atributos necesarios para generar un
    //objeto Album y lo devuelve
    public Album lecturaAlbum()
    {
        Album album = new Album();
        
        album.setPosicion(lecturaEntero());
        album.setAny(lecturaEntero());
        album.setTitulo(lecturaLinea());
        album.setArtista(lecturaLinea());
        album.setTipo(lecturaLinea());
        album.setEstrellas(lecturaDouble());
        album.setEdiciones(lecturaEntero());
        
        return album;
    }
    
    //Método contarObjetos que cuenta la cantidad de lineas y devuelve la
    //cantidad de objetos Album según su longitud en el fichero por el
    //atributo de la propia clase Album
    public int contarObjetos()
    {
        //Declarar el fichero2 para hacer un recorrido de los carácteres del
        //fichero y contar así sus lineas
        RandomAccessFile fichero2;
        //Inicializar el contador de líneas del fichero a 1 y declarar el
        //codigo de lectura para los carácteres del fichero2
        int contador = 1;
        int codigo;
        
        try{
            fichero2 = new RandomAccessFile(rutaFichero, "r");
            codigo = fichero2.read();
            
            //Bucle de recorrido para contar los carácteres de salto de línea
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
            //Devolver las líneas dividido entre las líneas por objeto de la
            //clase Album para obtener la cantidad de objetos en la clase
            return contador / Album.getCantidadLineas();
        }
    }
    
    //Método cerrarEnlace que cierra el enlace con el fichero
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