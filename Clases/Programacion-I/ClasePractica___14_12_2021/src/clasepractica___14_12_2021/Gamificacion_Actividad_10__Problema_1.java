/*
1. Dado un fichero de texto, de nombre problema1_1.txt, lleva a cabo la escritura de todas las
palabras contenidas en dicho fichero en otro fichero de texto de nombre problema1_2.txt, de
forma que las palabras en el fichero de salida serán grabadas en la misma línea separadas con
un espacio.
Nota: el fichero de entrada deberá ser generado a través de un editor de texto con el formato
texto.
 */
package clasepractica___14_12_2021;

public class Gamificacion_Actividad_10__Problema_1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_Actividad_10__Problema_1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para poder leer objetos Palabra
        //desde un fichero de texto
        PalabraFicherosLectura fichero1;
        //declaración objeto PalabraFicherosEscritura para poder escribir objetos Palabra
        //en un fichero de texto
        PalabraFicherosEscritura fichero2;
        //declaración objeto Palabra para almacenar, de una en una, los objetos
        //Palabra leídos desde un fichero de texto
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura para establecer el enlace
        //con el fichero de texto problema1_1.txt en modo lectura a nivel de objetos
        //Palabra
        fichero1=new PalabraFicherosLectura("problema1_1.txt");
        //instanciación objeto PalabraFicherosEscritura para establecer el enlace
        //con el fichero de texto problema1_2.txt en modo escritura a nivel de objetos
        //Palabra
        fichero2=new PalabraFicherosEscritura("problema1_2.txt");
        //BUCLE DE LECTURA DESDE EL FICHERO problema1_1.txt Y ESCRITURA EN EL
        //FICHERO problema1_2.txt A NIVEL DE OBJETOS Palabra
        while (fichero1.hayPalabras()) {
            //lectura objeto Palabra desde el fichero problema1_1.txt enlazado a través
            //del objeto fichero1
            palabra=fichero1.lectura();
            //escritura objeto Palabra leído en el fichero problema1_2.txt enlazado
            //a través del objeto fichero2
            fichero2.escritura(palabra);
            //escritura en el fichero problema1_2.txt de un separador
            fichero2.escrituraSeparador();
        }
        //cierre enlace con fichero
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero();
    }
        
}
