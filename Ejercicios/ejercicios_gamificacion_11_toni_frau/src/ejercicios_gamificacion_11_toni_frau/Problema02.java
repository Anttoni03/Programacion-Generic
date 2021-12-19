/*
 * FUNCIONALIDAD: dado un fichero de texto, problema.txt, realizar la lectura
 * del contenido del fichero y la escritura del mismo pero decodificada con las
 * letras del alfabeto movidas 3 posiciones a la izquierda en otro fichero de texto
 * FECHA DE REALIZACIÓN: 18-12-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_11_toni_frau;

public class Problema02 {
    public static void main(String[] args) throws Exception
    {
        new Problema02().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIÓN DE VARIABLES
        PalabraFicherosLectura ficheroLectura = new PalabraFicherosLectura("problemaCodificado.txt");
        PalabraFicherosEscritura ficheroEscritura = new PalabraFicherosEscritura("problemaDecodificado.txt");
        Palabra palabra = new Palabra();
        
        //ACCIONES
        //leer cada palabra del archivo de lectura y decodificarlas para poder escribirlas de nuevo
        while (ficheroLectura.hayPalabras())
        {            
            palabra = ficheroLectura.lectura();
            palabra.decodificar();
            ficheroEscritura.escritura(palabra);
            ficheroEscritura.escrituraSeparador();
        }
        
        //cerrar los enlaces de los ficheros
        ficheroLectura.cerrarEnlaceFichero();
        ficheroEscritura.cerrarEnlaceFichero();
    }
}
