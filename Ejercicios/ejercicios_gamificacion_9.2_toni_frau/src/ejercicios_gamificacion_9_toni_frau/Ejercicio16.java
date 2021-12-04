/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras que tengan las mismas vocales que la primera de la cadena
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio16 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio16().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        int[] vocalesPrimera = new int[5], vocalesPalabra = new int[5];
        boolean esPrimeraPalabra = true;
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            boolean mismasVocales = true;
            
            palabra.lectura();
            if (esPrimeraPalabra)
                vocalesPrimera = palabra.cantidadPorVocal();
            else
                vocalesPalabra = palabra.cantidadPorVocal();
            
            for (int i = 0; i < 5; i++) {
                mismasVocales = mismasVocales && (vocalesPrimera[i] == vocalesPalabra[i]);
            }
            
            if (mismasVocales && !esPrimeraPalabra)
                System.out.println(palabra.toString());
            
            esPrimeraPalabra = false;
        }
    }
}
