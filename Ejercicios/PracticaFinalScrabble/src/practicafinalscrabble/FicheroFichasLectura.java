//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package practicafinalscrabble;

import java.io.BufferedReader;
import java.io.FileReader;

public class FicheroFichasLectura {
    
    //DECLARACIÓN DE ATRIBUTOS
    //atributo de objeto que indica el fichero a leer
    private BufferedReader fichero;
    //atributo de objeto que indica la última letra leída a la hora de leer el
    //fichero de fichas
    private int codigoLeido = ' ';
    //atributo de clase que indica el código de final de fichero
    private static final int FINAL_SECUENCIA = -1;
    
    //MÉTODOS
    //método constructor con la ruta del fichero a leer
    public FicheroFichasLectura(String rutaFichero) throws Exception
    {
        fichero = new BufferedReader(new FileReader(rutaFichero));
    }
    
    //método encontrarLetra que realiza la lectura en el fichero hasta encontrar
    //una letra
    public boolean encontrarLetra() throws Exception
    {
        //bucle de lectura de condición detectar una no letra
        while (!esLetra((char)codigoLeido))
        {
            //realizar una lectura del fichero
            codigoLeido = fichero.read();
        }
        //devolver si se ha llegado al final del fichero o no
        return codigoLeido != FINAL_SECUENCIA;
    }
    
    //método encontrarNumero que realiza la lectura en el fichero hasta encontrar
    //un número
    public boolean encontrarNumero() throws Exception
    {
        //bucle de lectura de condición detectar un no número
        while (!esNumero((char)codigoLeido))
        {
            //realizar una lectura del fichero
            codigoLeido = fichero.read();
        }
        //devolver si se ha llegado al final del fichero o no
        return codigoLeido != FINAL_SECUENCIA;
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
    
    //método leerLetra para devolver el último código leído, que debe
    //corresponder a una letra
    public char leerLetra()
    {
        return (char)codigoLeido;
    }
    
    //método leerNumeros que devuleve un entero de los dígitos que lea del fichero
    public int leerNumeros() throws Exception
    {
        //DECLARACIONES
        //cadena para guardar los dígitos leídos con un máximo de 9
        int[] digitos = new int[9];
        //indicador de la medida o dimensión del número(su cantidad de dígitos)
        int medida = 0;
        
        //ACCIONES
        //bucle con condición de ser un número para registrar los carácteres numéricos
        while (esNumero((char)codigoLeido))
        {            
            digitos[medida] = codigoLeido - '0';
            medida++;
            codigoLeido = fichero.read();
        }
        //devolver los dígitos leídos por separado al ser juntados
        return juntarDigitos(digitos, medida);
    }
    
    //método juntarDigitos que recibe una cadena de dígitos individuales y la
    //dimensión o cantidad de dígitos que deben tener estos al juntarse
    private int juntarDigitos(int[] digitos, int dimension){
        //DECLARACIONES
        //valor del resultado al juntar los dígitos
        int resultado = 0;
        
        //ACCIONES
        //bucle interativo para juntar los dígitos dados con su dimensión
        for (int i = dimension-1,iteraciones = 1; i >= 0; i--,iteraciones *= 10)
        {
            resultado += digitos[i] * iteraciones;
        }
        //devolución de los dígitos dados por separado al juntarse
        return resultado;
    }
    
    //método cerrarEnlace que cierra el enlace con el fichero
    public void cerrarEnlace() throws Exception
    {
        fichero.close();
    }
}