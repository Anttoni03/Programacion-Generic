/*
3. Dados dos ficheros de texto, de nombres problema3_1.txt y problema3_2.txt, lleva a cabo la
grabación de todas las palabras contenidas en ellos en otro fichero de texto de nombre
problema3_3.txt. Las palabras se grabarán cada una en una línea diferente.
Nota: los ficheros de entrada deberán ser generados a través de un editor de texto con el
formato texto.
 */
package clasepractica___14_12_2021;

public class Gamificacion_Actividad_10__Problema_3 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_Actividad_10__Problema_3().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objetos PalabraFicherosLectura para poder leer objetos Palabra
        //desde los dos fichero de texto de lectura
        PalabraFicherosLectura fichero1,fichero2;
        //declaración objeto PalabraFicherosEscritura para poder escribir objetos Palabra
        //en el fichero de texto de salida
        PalabraFicherosEscritura fichero3;
        //declaración objeto Palabra para almacenar, de una en una, los objetos
        //Palabra leídos desde un fichero de texto
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura para establecer el enlace
        //con el fichero de texto problema3_1.txt en modo lectura a nivel de objetos
        //Palabra
        fichero1=new PalabraFicherosLectura("problema3_1.txt");
        //instanciación objeto PalabraFicherosLectura para establecer el enlace
        //con el fichero de texto problema3_2.txt en modo lectura a nivel de objetos
        //Palabra
        fichero2=new PalabraFicherosLectura("problema3_2.txt");
        //instanciación objeto PalabraFicherosEscritura para establecer el enlace
        //con el fichero de texto problema3_3.txt en modo escritura 
        //a nivel de objetos Palabra
        fichero3=new PalabraFicherosEscritura("problema3_3.txt");
        //BUCLE DE LECTURA DESDE EL FICHERO problema3_1.txt Y ESCRITURA A NIVEL
        //DE OBJETOS Palabra EN EL FICHERO problema3_3.txt
        while (fichero1.hayPalabras()) {
            //lectura objeto Palabra desde el fichero problema3_1.txt enlazado a través
            //del objeto fichero1
            palabra=fichero1.lectura();
            //escritura objeto Palabra leído en el fichero problema3_3.txt
            fichero3.escritura(palabra);
            //escritura separador en el fichero problema3_3.txt
            fichero3.nuevaLinea();
        }
        //BUCLE DE LECTURA DESDE EL FICHERO problema3_2.txt Y ESCRITURA A NIVEL
        //DE OBJETOS Palabra EN EL FICHERO problema3_3.txt
        while (fichero2.hayPalabras()) {
            //lectura objeto Palabra desde el fichero problema3_2.txt enlazado a través
            //del objeto fichero2
            palabra=fichero2.lectura();
            //escritura objeto Palabra leído en el fichero problema3_3.txt
            fichero3.escritura(palabra);
            //escritura separador en el fichero problema3_3.txt
            fichero3.nuevaLinea();
        }
        //cierre enlaces con fichero
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero();
        fichero3.cerrarEnlaceFichero();
    }
        
}
