/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * parejas de palabras en las cuales ambas tengan las mismas vocales
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio15 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio15().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra1 = new Palabra();
        Palabra palabra2 = new Palabra();
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            boolean mismasVocales = true;
            
            if (palabra2.cantidadCaracteres() != 0)
                Palabra.copiar(palabra2, palabra1);
            palabra2.lectura();
            
            for (int i = 0; i < 5; i++) {
                mismasVocales = mismasVocales && (palabra1.cantidadPorVocal()[i] == palabra2.cantidadPorVocal()[i]);
            }
            
            if (mismasVocales)
                System.out.println(palabra1.toString() + " " + palabra2.toString());
        }
    }
}
