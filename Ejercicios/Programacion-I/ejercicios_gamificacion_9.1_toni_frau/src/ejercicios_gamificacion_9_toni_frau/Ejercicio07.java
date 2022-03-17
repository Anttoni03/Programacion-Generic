/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras que contengan vocales y sean todas 'e' y 'o'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio07 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio07().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        final char[] VOCALES_A_MIRAR = {'e','o'};
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if (palabra.hayVocales() && palabra.vocalesSon(VOCALES_A_MIRAR)){
                System.out.println(palabra.toString());
            }
        }
    }
}
