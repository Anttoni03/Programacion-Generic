/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras con el primer y último carácter en mayúsculas
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio20 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio20().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            
            palabra.lectura();
            
            palabra.ponerMayusculas(0);
            palabra.ponerMayusculas(palabra.cantidadCaracteres()-1);
            
            System.out.println(palabra.toString());
        }
    }
}
