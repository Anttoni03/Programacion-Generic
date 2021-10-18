/*
FUNCIONALIDAD: ilustración de la entrada y salida de datos primitivos utilizando
métodos de la clase LT.
Los métodos a utilizar son:
 *  - LT.readChar(): lectura de un caracter
 *  - LT.readDouble(): lectura de número real (tipo double)
 *  - LT.readInt(): lectura de número entero (tipo int)
 *  - LT.readLine(): lectura línea de caracteres


OBJETIVO: introducción a la programación JAVA
FECHA DE CREACIÓN: 01.10.2021
AUTOR: juan
 */
package grupo_3;

public class Programa_EntradaSalidaLT {
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
        caracter = LT.readChar();
        //visualización contenido variable caracter
        System.out.println("EL CARACTER ALMACENADO EN LA VARIABLE caracter ES: "+caracter);       
        
        //LECTURA LINEA DE CARACTERES
        //visualización mensaje usuario
        System.out.print("INTRODUCE UNA LÍNEA DE CARACTERES: ");
        //lectura de la linea desde el teclado
        linea = LT.readLine(); 
        //visualización contenido variable linea
        System.out.println("LA SECUENCIA DE CARACTERES ALMACENADA EN LA VARIABLE linea ES: "+linea);
        
        
        //LECTURA DE UN NÚMERO ENTERO
        //mensaje usuario
        System.out.print("INTRODUCE UN NÚMERO ENTERO: ");
        //lectura número entero
        numero1= LT.readInt();
        //visualización contenido variable numero1
        System.out.println("EL NÚMERO ENTERO ALMACENADO EN LA VARIABLE numero1 ES: "+numero1);
        
        
        //LECTURA DE UN NÚMERO REAL
        //mensaje usuario
        System.out.print("INTRODUCE UN NÚMERO REAL: ");
        //lectura número real
        numero2= LT.readDouble();
        //visualización contenido variable numero2
        System.out.println("EL NÚMERO REAL ALMACENADO EN LA VARIABLE numero2 ES: "+numero2);
    }
    
}
