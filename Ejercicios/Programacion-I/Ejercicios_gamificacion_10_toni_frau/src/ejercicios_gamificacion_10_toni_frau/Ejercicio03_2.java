
/*
 * FUNCIONALIDAD: dados dos ficheros de texto, Problema3_1.txt y Problema3_2,
 * realizar la lectura de ambos ficheros y grabar su contenido en otro, Problema3_3
 * de forma que cada palabra se visualice en una línea distinta
 * FECHA DE REALIZACIÓN: 12-12-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_10_toni_frau;

public class Ejercicio03_2 {
    public static void main(String[] argumentos) throws Exception
    {
        new Ejercicio03_2().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        Palabra palabra = new Palabra();
        
        PalabraFicherosLectura ficheroLectura1 = new PalabraFicherosLectura("Problema3_1.txt");
        PalabraFicherosEscritura ficheroEscritura = new PalabraFicherosEscritura("Problema3_3.txt");
        
        while (ficheroLectura1.hayPalabras())
        {
            palabra = ficheroLectura1.lectura();
            ficheroEscritura.escritura(palabra);
            ficheroEscritura.nuevaLinea();
        }
        ficheroLectura1.cerrarEnlaceFichero();
        PalabraFicherosLectura ficheroLectura2 = new PalabraFicherosLectura("Problema3_2.txt");

        while (ficheroLectura2.hayPalabras()) {            
            palabra = ficheroLectura2.lectura();
            ficheroEscritura.escritura(palabra);
            ficheroEscritura.nuevaLinea();
        }
        
        ficheroLectura2.cerrarEnlaceFichero();
        ficheroEscritura.cerrarEnlaceFichero();
    }
}
