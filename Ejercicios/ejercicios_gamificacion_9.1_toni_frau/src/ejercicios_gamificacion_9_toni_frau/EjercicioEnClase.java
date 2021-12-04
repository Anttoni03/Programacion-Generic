/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras con un número par de caracteres vocales e impar de consonantes
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class EjercicioEnClase {
    public static void main(String[] args) throws Exception
    {
        new EjercicioEnClase().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if ((palabra.cantidadVocales() % 2 == 0) && (palabra.cantidadConsonantes() % 2 != 0)){
                if (palabra.tieneVocales() && palabra.tieneConsonantes())
                System.out.println(palabra.toString());
            }
        }
    }
}
