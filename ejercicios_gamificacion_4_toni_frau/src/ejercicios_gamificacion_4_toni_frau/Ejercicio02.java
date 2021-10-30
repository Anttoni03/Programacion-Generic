/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras con un
 * número par e impar de caracteres introducidos en una secuencia finaliazada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio02 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA='.';
    final char ESPACIO=' ';
    char caracter;
    int contadorCaracteres = 0, contadorPalabrasImpares = 0, contadorPalabrasPares = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio02().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal
    private void metodoPrincipal()
    {
        //ACCIONES
        //mensaje para introducir cadena
        System.out.print("Introduce una cadena de caracteres: ");
        
        caracter = LT.readChar();
        //TRATAMIENTO DE RECORRIDO
        while (caracter != FINAL_SECUENCIA)
        {            
            manejarExcepciones();
            manejarPalabra();
            if (contadorCaracteres % 2 != 0)
                contadorPalabrasImpares++;
            else
                contadorPalabrasPares++;
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorPalabrasImpares + 
                " palabras impares y " + contadorPalabrasPares + " pares.");
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra
    private void manejarPalabra()
    {
        while (caracter != FINAL_SECUENCIA && caracter != ESPACIO)
        {            
            contadorCaracteres++;
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarExcepciones
    private void manejarExcepciones()
    {
        while (caracter == ESPACIO)
        {            
            contadorCaracteres = 0;
            caracter = LT.readChar();
        }
    }
}
