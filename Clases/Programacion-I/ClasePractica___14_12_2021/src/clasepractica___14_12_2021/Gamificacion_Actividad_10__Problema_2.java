/*
2. Dado un fichero de texto, de nombre problema2_1.txt, lleva la generación de dos ficheros, de
nombres problema2_NoPalindromos.txt y problema2_Palindromos.txt, de forma que en el primero de
estos ficheros grabará todas las palabras no palíndromos contenidas en el fichero de entrada y en
el segundo fichero grabará todas aquellas palabras palíndromos. Las palabras serán escritas
cada una en una línea en los ficheros correspondientes.
Nota: el fichero de entrada deberá ser generado a través de un editor de texto con el formato
texto.
 */
package clasepractica___14_12_2021;

public class Gamificacion_Actividad_10__Problema_2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_Actividad_10__Problema_2().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para poder leer objetos Palabra
        //desde un fichero de texto
        PalabraFicherosLectura fichero1;
        //declaración objetos PalabraFicherosEscritura para poder escribir objetos Palabra
        //en los dos fichero de texto de salida
        PalabraFicherosEscritura ficheroNoPalindromos,ficheroPalindromos;
        //declaración objeto Palabra para almacenar, de una en una, los objetos
        //Palabra leídos desde un fichero de texto
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura para establecer el enlace
        //con el fichero de texto problema2_1.txt en modo lectura a nivel de objetos
        //Palabra
        fichero1=new PalabraFicherosLectura("problema2_1.txt");
        //instanciación objeto PalabraFicherosEscritura para establecer el enlace
        //con el fichero de texto problema2_NoPalindromos.txt en modo escritura 
        //a nivel de objetos Palabra
        ficheroNoPalindromos=new PalabraFicherosEscritura("problema2_NoPalindromos.txt");
        //instanciación objeto PalabraFicherosEscritura para establecer el enlace
        //con el fichero de texto problema2_Palindromos.txt en modo escritura 
        //a nivel de objetos Palabra
        ficheroPalindromos=new PalabraFicherosEscritura("problema2_Palindromos.txt");
        //BUCLE DE LECTURA DESDE EL FICHERO problema2_1.txt Y ESCRITURA A NIVEL
        //DE OBJETOS Palabra EN LOS FICHEROS problema2_NoPalindromos.txt Y
        //problema2_Palindromos.txt
        while (fichero1.hayPalabras()) {
            //lectura objeto Palabra desde el fichero problema2_1.txt enlazado a través
            //del objeto fichero1
            palabra=fichero1.lectura();
            //TRATAMIENTO OBJETO Palabra LÉIDO PARA VERIFICAR SI ES UN PALÍNDROMO
            if (palabra.esPalindromo()) {
                //escritura objeto Palabra en el fichero problema2_Palindromos.txt
                ficheroPalindromos.escritura(palabra);
                //escritura en el fichero problema2_Palindromos.txt de un salto de linea
                ficheroPalindromos.nuevaLinea();
            }
            else {
                //escritura objeto Palabra en el fichero problema2_NoPalindromos.txt
                ficheroNoPalindromos.escritura(palabra);
                //escritura en el fichero problema2_NoPalindromos.txt de un salto de linea
                ficheroNoPalindromos.nuevaLinea();                
            }
        }
        //cierre enlaces con fichero
        fichero1.cerrarEnlaceFichero();
        ficheroPalindromos.cerrarEnlaceFichero();
        ficheroNoPalindromos.cerrarEnlaceFichero();
    }
        
}
