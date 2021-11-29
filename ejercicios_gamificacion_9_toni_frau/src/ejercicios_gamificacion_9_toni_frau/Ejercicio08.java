/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras y su peso de código si es mayor a 750
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio08 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio08().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        final int PESO_A_MIRAR = 750;
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            palabra.lectura();
            
            if (palabra.pesoDeCodigo() > PESO_A_MIRAR){
                System.out.println(palabra.toString() + "\tPESO: " + palabra.pesoDeCodigo());
            }
        }
    }
}
