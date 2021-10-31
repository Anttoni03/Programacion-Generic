/*
FUNCIONALIDAD: ilustración de la entrada y salida de datos primitivos utilizando
sentencias propias de Java.
Las sentencias a utilizar serán: 
    LECTURA CARACTER DESDE EL TECLADO
    - char variable = (char)System.in.read();
    LECTURA LINEA DE CARACTERES DESDE EL TECLADO
    - BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    - String línea = in.readLine(); 
    LECTURA NÚMERO ENTERO DESDE EL TECLADO
    - BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    - String linea = in.readLine();
    - int numero=Integer.parseInt(linea);
    LECTURA NÚMERO REAL DESDE EL TECLADO
    - BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    - String linea = in.readLine();
    - float numero1=Float.parseFloat(linea);
    - double numero2=Double.parseDouble(línea);
    SALIDA POR PANTALLA
    - System.out.print (expresión);
    - System.out.println(expresión);

OBJETIVO: introducción a la programación JAVA
FECHA DE CREACIÓN: 01.10.2021
AUTOR: juan
 */
package grupo_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Programa_EntradaSalidaJava {
    //método main necesario para que el programa pueda ser ejecutado directamente
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración de una variable de tipo char para poder almacenar el caracter
        //a leer desde el teclado
        char caracter;
        //declaración de una variable de tipo String para poder almacenar una
        //línea de caracteres a leer desde el teclado
        String linea;
        //declaración variable de tipo int para almacenar un número entero a 
        //leer desde el teclado
        int numero1;
        //declaración variable de tipo double para almacenar un número real
        //a leer desde el teclado
        double numero2;
        
        //ACCIONES
        //LECTURA CARACTER
        //visualización mensaje al usuario
        System.out.print("INTRODUCE UN CARACTER: ");
        //lectura de un caracter desde el teclado
        caracter = (char)System.in.read();
        //visualización contenido variable caracter
        System.out.println("EL CARACTER ALMACENADO EN LA VARIABLE caracter ES: "+caracter);       
        
        //eliminar el caracter return del buffer de entrada para vaciar dicho buffer
        System.in.read();
        
        //LECTURA LINEA DE CARACTERES
        //declaración para leer linea de caracteres desde el teclado (SOLO SE TIENE QUE
        //HACER UNA VEZ EN EL PROGRAMA)
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //visualización mensaje usuario
        System.out.print("INTRODUCE UNA LÍNEA DE CARACTERES: ");
        //lectura de la linea desde el teclado
        linea = in.readLine(); 
        //visualización contenido variable linea
        System.out.println("LA SECUENCIA DE CARACTERES ALMACENADA EN LA VARIABLE linea ES: "+linea);
        
        
        //LECTURA DE UN NÚMERO ENTERO
        //mensaje usuario
        System.out.print("INTRODUCE UN NÚMERO ENTERO: ");
        //lectura de la secuencia de caracteres que conforman el número leido
        linea= in.readLine();
        //conversión de la secuencia de caracteres leidos a valor entero
        numero1= Integer.parseInt(linea);
        //visualización contenido variable numero1
        System.out.println("EL NÚMERO ENTERO ALMACENADO EN LA VARIABLE numero1 ES: "+numero1);
        
        
        //LECTURA DE UN NÚMERO REAL
        //mensaje usuario
        System.out.print("INTRODUCE UN NÚMERO REAL: ");
        //lectura de la secuencia de caracteres que conforman el número leido
        linea= in.readLine();
        //conversión de la secuencia de caracteres leidos a valor real double
        numero2= Double.parseDouble(linea);
        //visualización contenido variable numero2
        System.out.println("EL NÚMERO REAL ALMACENADO EN LA VARIABLE numero2 ES: "+numero2);
    }
    
}
