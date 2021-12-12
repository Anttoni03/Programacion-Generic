
/*
 * FUNCIONALIDAD: dado un fichero de texto, Problema4.txt, realizar la lectura
 * del contenido del fichero y una palabra por teclado, e indicar cuantas veces
 * aparece dicha palabra en el fichero
 * FECHA DE REALIZACIÓN: 12-12-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_10_toni_frau;

public class Ejercicio04 {
    public static void main(String[] argumentos) throws Exception
    {
        new Ejercicio04().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        Palabra palabra = new Palabra();
        String palabraUsuario;
        PalabraFicherosLectura ficheroLectura = new PalabraFicherosLectura("Problema4.txt");
        int contador = 0;
        
        System.out.print("Introduce una palabra: ");
        palabraUsuario = LT.readLine();
        
        while (ficheroLectura.hayPalabras()) {            
            palabra = ficheroLectura.lectura();
            if (palabraUsuario.equals(palabra.toString()))
            {
                contador++;
            }
        }
        
        ficheroLectura.cerrarEnlaceFichero();
        
        System.out.println("La palabra " + palabraUsuario + " se encuentra " + contador + " veces en el fichero");
    }
}
