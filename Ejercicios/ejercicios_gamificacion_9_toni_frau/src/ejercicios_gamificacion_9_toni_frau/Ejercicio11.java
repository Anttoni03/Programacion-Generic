/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar la
 * cantidad de palabras que tienen tanta cantidad de carácteres hasta 20
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio11 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio11().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        int[] palabrasDeCaracteres = new int[20];
        for (int i = 0; i < palabrasDeCaracteres.length; i++) {
            palabrasDeCaracteres[i] = 0;
        }
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            palabrasDeCaracteres[palabra.cantidadCaracteres()-1]++;
        }
        
        for (int i = 0; i < palabrasDeCaracteres.length; i++) {
            System.out.println("Palabras de " + (i+1) + " carácter: " + palabrasDeCaracteres[i]);
        }
    }
}
