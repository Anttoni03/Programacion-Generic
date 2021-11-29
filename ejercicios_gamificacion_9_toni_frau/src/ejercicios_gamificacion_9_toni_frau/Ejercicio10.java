/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras que sean palíndromas y sus carácteres sean todos vocales
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio10 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio10().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if (palabra.esPalindroma() && (palabra.cantidadCaracteres() == palabra.cantidadVocales())){
                System.out.println(palabra.toString());
            }
        }
    }
}
