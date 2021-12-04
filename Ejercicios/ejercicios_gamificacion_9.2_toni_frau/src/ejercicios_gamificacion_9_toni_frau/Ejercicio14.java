/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * parejas de palabras en las cuales ambas tengan la misma cantidad de vocales
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio14 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio14().metodoPrincipal();
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
                if (palabra2.cantidadVocales() == palabra1.cantidadVocales())
                    System.out.println(palabra1.toString() + " " + palabra2.toString());
        }
    }
}
