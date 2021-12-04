/*
 * FUNCIONALIDAD: dada una secuencia de carácteres acabada en '.', visualizar las
 * palabras que tengan la misma cantidad de caracteres que la primera de la cadena
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 29-11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_9_toni_frau;

public class Ejercicio17 {
    public static void main(String[] args) throws Exception
    {
        new Ejercicio17().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Palabra palabra = new Palabra();
        int caracteresPrimera = 0;
        boolean esPrimeraPalabra = true;
        
        System.out.print("Introduce una secuencia: ");
        while (Palabra.hayPalabras())
        {
            
            palabra.lectura();
            if (esPrimeraPalabra)
                caracteresPrimera = palabra.cantidadCaracteres();
            
            if ((caracteresPrimera == palabra.cantidadCaracteres()) && !esPrimeraPalabra)
                System.out.println(palabra.toString());
            
            esPrimeraPalabra = false;
        }
    }
}
