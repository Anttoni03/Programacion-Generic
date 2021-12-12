
/*
 * FUNCIONALIDAD: dado un fichero de texto, Problema2_1.txt, realizar la lectura
 * del contenido del fichero y escribir las palabras palíndromas del fichero en 
 * otro fichero llamadao problema2_Palindromos.txt y las no palíndromas en el
 * fichero problema2_NoPalindromos.txt, escritas todas en líneas distintas
 * FECHA DE REALIZACIÓN: 12-12-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_10_toni_frau;

public class Ejercicio02 {
    public static void main(String[] argumentos) throws Exception
    {
        new Ejercicio02().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        Palabra palabra = new Palabra();
        
        PalabraFicherosLectura ficheroLectura = new PalabraFicherosLectura("Problema2_1.txt");
        PalabraFicherosEscritura escrituraPalindromos = new PalabraFicherosEscritura("Problema2_Palindrmos.txt");
        PalabraFicherosEscritura escrituraNoPalindromos = new PalabraFicherosEscritura("Problema2_NoPalindromos.txt");
        
        while (ficheroLectura.hayPalabras()) {            
            palabra = ficheroLectura.lectura();
            
            if (palabra.esPalindromo())
            {
                escrituraPalindromos.escritura(palabra);
                escrituraPalindromos.nuevaLinea();
            }
            else
            {
                escrituraNoPalindromos.escritura(palabra);
                escrituraNoPalindromos.nuevaLinea();
            }
        }
        
        ficheroLectura.cerrarEnlaceFichero();
        escrituraPalindromos.cerrarEnlaceFichero();
        escrituraNoPalindromos.cerrarEnlaceFichero();
    }
}
