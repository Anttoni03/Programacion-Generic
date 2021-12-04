/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras con un número mayor de caracteres vocales que consonantes
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio05 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio05().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if ((palabra.cantidadCaracteres() - palabra.cantidadVocales()) < palabra.cantidadVocales()){
                System.out.println(palabra.toString());
            }
        }
    }
}
