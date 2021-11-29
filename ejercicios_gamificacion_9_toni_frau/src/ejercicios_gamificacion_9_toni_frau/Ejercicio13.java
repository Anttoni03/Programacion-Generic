/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * parejas de palabras en las que la cantidad de carácteres de la primera palabra
 * diste de 1 de la cantidad de carácteres de la segunda
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio13 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio13().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra1 = new Palabra();
        Palabra palabra2 = new Palabra();
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            if (palabra2.cantidadCaracteres() != 0)
                Palabra.copiar(palabra2, palabra1);
            palabra2.lectura();
            
            if (palabra1.cantidadCaracteres() != 0)
                if (palabra2.cantidadCaracteres()-palabra1.cantidadCaracteres() == 1)
                    System.out.println(palabra1.toString() + " " + palabra2.toString());
        }
    }
}
