package ejercicios_gamificacion_10_toni_frau;

/*
 * FUNCIONALIDAD: dado un fichero de texto, Problema1_1.txt, realizar la lectura
 * del contenido del fichero y escribir ese contenido en otro fichero   problema1_2.txt
 * separado por un espacio entre palabra y palabra.
 * FECHA DE REALIZACIÓN: 12-12-2021
 * AUTOR: Antoni Frau Gordiola
 */

public class Ejercicio01 {
    public static void main(String[] argumentos) throws Exception
    {
        new Ejercicio01().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        Palabra palabra = new Palabra();
        
        PalabraFicherosLectura ficheroLectura = new PalabraFicherosLectura("Problema1_1.txt");
        PalabraFicherosEscritura ficheroEscritura = new PalabraFicherosEscritura("Problema1_2.txt");
        
        while (ficheroLectura.hayPalabras()) {            
            palabra = ficheroLectura.lectura();
            
            ficheroEscritura.escritura(palabra);
            
            ficheroEscritura.escrituraSeparador();
        }
        
        ficheroLectura.cerrarEnlaceFichero();
        ficheroEscritura.cerrarEnlaceFichero();
    }
}
