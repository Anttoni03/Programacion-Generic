/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras que tengan una posición par en la secuencia al revés y en una posición
 * par en mayúsculas
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio19 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio19().metodoPrincipal();
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
                palabra.ponerMayusculas();
            else
                palabra.invertir();
            
            System.out.println(palabra.toString());
        }
    }
}
