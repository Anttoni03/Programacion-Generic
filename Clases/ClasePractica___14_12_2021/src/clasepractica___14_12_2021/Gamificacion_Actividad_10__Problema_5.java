/*
5. Dado un fichero, de nombre problema5_1.txt y una palabra introducida por teclado a petición del
programa, lleva a cabo la generación de otro fichero, de nombre problema5_2.txt, en el que se
escribirán todas las palabras contenidas en el fichero problema5_1.txt habiendo sido sustituidas
las palabras iguales a la palabra introducida por el usuario por la palabra “xxxxx”.
Nota: el fichero de entrada deberá ser generado a través de un editor de texto con el formato
texto.
 */
package clasepractica___14_12_2021;

public class Gamificacion_Actividad_10__Problema_5 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_Actividad_10__Problema_5().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para poder leer objetos Palabra
        //desde un fichero de texto
        PalabraFicherosLectura fichero1;
        //declaración objeto PalabraFicherosEscritura para poder escribir objetos Palabra
        //desde un fichero de texto
        PalabraFicherosEscritura fichero2;
        //declaración objeto Palabra para almacenar, de una en una, los objetos
        //Palabra leídos desde un fichero de texto
        Palabra palabraFichero=new Palabra();
        //declaración objeto Palabra para almacenar la palabra introducida
        //por el usuario por teclado
        Palabra palabraUsuario=new Palabra();
        //declaración objeto Palabra para almacenar la palabra sustituta "xxxxx"
        Palabra palabraSustituta=new Palabra("xxxxx");
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura para establecer el enlace
        //con el fichero de texto problema5_1.txt en modo lectura a nivel de objetos
        //Palabra
        fichero1=new PalabraFicherosLectura("uib.txt");
        //instanciación objeto PalabraFicherosEscritura para establecer el enlace
        //con el fichero de texto problema5_2.txt en modo escritura a nivel de objetos
        //Palabra
        fichero2=new PalabraFicherosEscritura("problema5_2.txt",true);
        //mensaje usuario para introducir palabra por teclado
        System.out.print("INTRODUCIR PALABRA A SUSTITUIR (finalizar con '.'): ");
        //lectura palabra por teclado
        if (Palabra.hayPalabras()) {
            palabraUsuario.lectura();
        }
        //BUCLE DE LECTURA DESDE EL FICHERO problema5_1.txt Y TRATAMIENTO
        while (fichero1.hayPalabras()) {
            //lectura objeto Palabra desde el fichero problema4.txt enlazado a través
            //del objeto fichero
            palabraFichero=fichero1.lectura();
            //tratamiento objeto Palabra leído desde el fichero
            if (Palabra.iguales(palabraUsuario, palabraFichero)) {
                //escritura en el fichero problema5_2.txt de la palabra sustituta
                //en lugar de la palabra leída desde el fichero problema5_1.txt
                fichero2.escritura(palabraSustituta);
            }
            else {
                //escritura en el fichero problema5_2.txt de la palabra leída
                //desde el fichero problema5_1.txt
                fichero2.escritura(palabraFichero);
            }
            //escritura en el fichero problema5_2.txt de un separador
            fichero2.escrituraSeparador();
        }
        //cierre enlaces con ficheros
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero();
    }
        
}
