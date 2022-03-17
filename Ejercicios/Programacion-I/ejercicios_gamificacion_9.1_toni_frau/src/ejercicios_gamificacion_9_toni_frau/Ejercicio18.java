/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras que tengan una posición par en la secuencia
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio18 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio18().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        int contadorPalabras = 0;
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            
            palabra.lectura();
            contadorPalabras++;
            
            if (contadorPalabras % 2 == 0)
                System.out.println(palabra.toString());
        }
    }
}
