/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras con un número par de caracteres consonantes
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio04 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio04().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if ((palabra.cantidadCaracteres() - palabra.cantidadVocales()) % 2 == 0){
                System.out.println(palabra.toString());
            }
        }
    }
}
