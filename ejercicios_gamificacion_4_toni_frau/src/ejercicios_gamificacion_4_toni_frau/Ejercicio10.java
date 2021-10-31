/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras que tengan
 * un peso de código superior a 1000, siendo el peso de código la suma de código
 * de sus caracteres
 * una secuencia finalizada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 31.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio10 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA = '.';
    final char ESPACIO = ' ';
    final int PESO_BUSCADO = 1000;
    char caracter;
    int contadorPalabrasValidas = 0, pesoDePalabra = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio10().metodoPrincipal();
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
            if (pesoDePalabra > PESO_BUSCADO)
                contadorPalabrasValidas++;
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorPalabrasValidas + 
                " palabras con peso de código superior a 1000");
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra
    private void manejarPalabra()
    {
        while (caracter != FINAL_SECUENCIA && caracter != ESPACIO)
        {
            pesoDePalabra += caracter;
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarExcepciones
    private void manejarEspacio()
    {
        while (caracter == ESPACIO)
        {
            pesoDePalabra = 0;
            caracter = LT.readChar();
        }
    }
}
