/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras con un
 * número impar de caracteres introducidos en una secuencia finaliazada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio01 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA='.';
    final char ESPACIO=' ';
    char caracter;
    int contadorCaracteres = 0, contadorPalabrasImpares = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio01().metodoPrincipal();
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
            manejarEspacio();
            manejarPalabra();
            if (contadorCaracteres % 2 != 0)
                contadorPalabrasImpares++;
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorPalabrasImpares + " palabras impares");
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
    private void manejarEspacio()
    {
        while (caracter == ESPACIO)
        {            
            contadorCaracteres = 0;            
            caracter = LT.readChar();
        }
    }
}
