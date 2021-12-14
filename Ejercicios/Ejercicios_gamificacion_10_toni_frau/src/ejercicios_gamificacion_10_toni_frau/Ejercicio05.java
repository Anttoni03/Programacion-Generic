
/*
 * FUNCIONALIDAD: dado un fichero de texto, Problema5_1.txt, realizar la lectura
 * del contenido del fichero y una palabra por teclado, y generar otro fichero
 * Problema5_2.txt con el mismo contenido del primer fichero pero sustituyendo
 * las palabras coincidentes con la dada por xxxxx
 * FECHA DE REALIZACIÓN: 12-12-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_10_toni_frau;

public class Ejercicio05 {
    public static void main(String[] argumentos) throws Exception
    {
        new Ejercicio05().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        Palabra palabra = new Palabra();
        final Palabra PALABRA_SUSTITUTIVA = new Palabra("xxxxxx");
        String palabraUsuario;
        PalabraFicherosLectura ficheroLectura = new PalabraFicherosLectura("Problema5_1.txt");
        PalabraFicherosEscritura ficheroEscritura = new PalabraFicherosEscritura("Problema5_2.txt");
        
        System.out.print("Introduce una palabra: ");
        palabraUsuario = LT.readLine();
        
        while (ficheroLectura.hayPalabras()) {            
            palabra = ficheroLectura.lectura();
            if (palabraUsuario.equals(palabra.toString()))
                ficheroEscritura.escritura(PALABRA_SUSTITUTIVA);
            else
                ficheroEscritura.escritura(palabra);
            
            ficheroEscritura.escrituraSeparador();
        }
        
        ficheroLectura.cerrarEnlaceFichero();
        ficheroEscritura.cerrarEnlaceFichero();
    }
}
