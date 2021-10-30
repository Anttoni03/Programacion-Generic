/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras que comiencen
 * por "ab"
 * una secuencia finalizada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio09 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA = '.';
    final char ESPACIO = ' ';
    final char PRIMER_CARACTER = 'a', SEGUNDO_CARACTER = 'b';
    char caracter1, caracter2;
    int contadorPalabrasValidas = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio09().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal
    private void metodoPrincipal()
    {
        //ACCIONES
        //mensaje para introducir cadena
        System.out.print("Introduce una cadena de caracteres: ");
        
        caracter2 = LT.readChar();
        caracter1 = ' ';
        //TRATAMIENTO DE RECORRIDO
        while (caracter2 != FINAL_SECUENCIA)
        {
            manejarEspacio();
            manejarPalabra();
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorPalabrasValidas + 
                " palabras con al menos 2 vocales y de una cantidad impar de caracteres");
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra
    private void manejarPalabra()
    {
        while (caracter2 != FINAL_SECUENCIA && caracter2 != ESPACIO)
        {
            caracter2 = LT.readChar();
            if (caracter1 == PRIMER_CARACTER && caracter2 == SEGUNDO_CARACTER)
                contadorPalabrasValidas++;
            caracter1 = caracter2;
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarExcepciones
    private void manejarEspacio()
    {
        while (caracter2 == ESPACIO)
        {
            caracter2 = LT.readChar();
        }
    }
}
