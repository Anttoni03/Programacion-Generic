/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras que contengan vocales y sean todas 'a'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio06 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio06().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        final char VOCAL_A_MIRAR = 'a';
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if (palabra.hayVocales() && palabra.vocalesSon(VOCAL_A_MIRAR)){
                System.out.println(palabra.toString());
            }
        }
    }
}
