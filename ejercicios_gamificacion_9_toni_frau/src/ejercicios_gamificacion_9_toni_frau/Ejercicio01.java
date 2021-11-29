/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar el
 * número de palabras con un número par de caracteres
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

/**
 *
 * @author tonif
 */
public class Ejercicio01 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio01().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        int contador = 0;
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if (palabra.numeroParDeCaracteres())
                contador++;
        }
        System.out.println("El número de palabras con un número par de caracteres es " + contador);
    }
}
