/*
CLASE PeliculaFicherosEscritura
Aglutina las declaraciones y funcionalidades necesarias para posibilitar la escritura
de objetos Pelicula en un fichero de texto
 */
package clasepractica__10_03_2022;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PeliculaFicherosEscritura {
    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control RETURN
    private static final int RETURN=(int) '\r';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';
    //declaración atributo de objeto BufferedWriter que posibilite el enlace
    //con el fichero de texto a nivel de escritura
    private BufferedWriter fichero=null;  
    
    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public PeliculaFicherosEscritura(String nombreFichero) {
        try {
            //establecimiento enlace BufferedWriter con fichero de texto identificado
            //a través del parámetro String nombreFichero dado
            fichero=new BufferedWriter(new FileWriter(nombreFichero));            
        }catch (IOException error) {
            System.err.println("ERROR EN LA APERTURA DEL FICHERO");
        }
    }

    //CONSTRUCTOR PARA AÑADIR SIN  ELIMINAR FICHERO SI EXISTE PREVIAMENTE
    public PeliculaFicherosEscritura(String nombreFichero,boolean adicion) {
        try {
            //establecimiento enlace BufferedWriter con fichero de texto identificado
            //a través del parámetro String nombreFichero dado
            fichero=new BufferedWriter(new FileWriter(nombreFichero,adicion));
        }catch (IOException error) {
            System.err.println("ERROR EN LA APERTURA DEL FICHERO");
        }
    }    
    //MÉTODOS FUNCIONALES
    
    //MÉTODO escritura QUE LLEVA A CABO LA ESCRITURA DE UNA PELICULA EN EL
    //FICHERO DE TEXTO REPRESENTADO POR EL OBJETO BufferedWriter CORRESPONDIENTE
    public void escritura(Pelicula pelicula) {
        try {
            fichero.write(pelicula.getTitulo());
            nuevaLinea();
            fichero.write(pelicula.getDirector());
            nuevaLinea();
            fichero.write(Integer.toString(pelicula.getAño()));
            nuevaLinea();       
        }catch (IOException error) {
            System.err.println("ERROR EN LA APERTURA DEL FICHERO");
        }
    }
    
    //MÉTODO nuevaLinea QUE LLEVA A CABO LA CREACIÓN DE UNA NUEVA LINEA
    //EN EL FICHERO
    //NOTA: SI TRABAJAMOS EN WINDOWS TENEMOS QUE TENER EN CUENTA QUE
    //LA CREACIÓN DE UNA NUEVA LINEA EN UN FICHERO (NORMALMENTE SE LLAMA SALTO
    //DE LINEA) ES NESARIO LLEVARLO A CABO CON LOS CARACTERES DE CONTROL
    //RETURN Y SALTO DE LINEA.
    //EN MAC O LINUX SOLO SERÍA NECEARIO EL CARACTER DE CONTROL SALTO DE LINEA
    public void nuevaLinea() {
        try {
            //escritura caracter de control RETURN en el fichero
            fichero.write(RETURN);
            //escritura caracter de control SALTO_LINEA en el fichero
            fichero.write(SALTO_LINEA);
        }catch (IOException error) {
            System.err.println("ERROR EN LA APERTURA DEL FICHERO");
        }
    }
    
    //MÉTODO cerrarEnlaceFichero QUE LLEVA A CABO EL CIERRE DEL ENLACE BufferedWriter
    //con el fichero 
    public void cerrarEnlaceFichero(){
        try {
            fichero.close();           
        }catch (IOException error) {
            System.err.println("ERROR EN LA APERTURA DEL FICHERO");
        }
    }
}
