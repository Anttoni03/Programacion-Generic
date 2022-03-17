/*
4. Dado un fichero, de nombre problema4.txt, y una palabra introducida por teclado a petición del
programa, lleva a cabo la visualización de las veces que la palabra introducida aparece en el
fichero de entrada.
Nota: el fichero de entrada deberá ser generado a través de un editor de texto con el formato
texto.

 */
package clasepractica___14_12_2021;

public class Gamificacion_Actividad_10__Problema_4 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_Actividad_10__Problema_4().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para poder leer objetos Palabra
        //desde un fichero de texto
        PalabraFicherosLectura fichero;
        //declaración objeto Palabra para almacenar, de una en una, los objetos
        //Palabra leídos desde un fichero de texto
        Palabra palabraFichero=new Palabra();
        //declaración objeto Palabra para almacenar la palabra introducida
        //por el usuario por teclado
        Palabra palabraUsuario=new Palabra();
        //declaración variable entera para almacenar el número de apariciones
        //de la palabra introducida por teclado en el fichero
        int contador=0;
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura para establecer el enlace
        //con el fichero de texto problema4.txt en modo lectura a nivel de objetos
        //Palabra
        fichero=new PalabraFicherosLectura("problema4.txt");
        //mensaje usuario para introducir palabra por teclado
        System.out.print("INTRODUCIR PALABRA A BUSCAR (finalizar con '.'): ");
        //lectura palabra por teclado
        if (Palabra.hayPalabras()) {
            palabraUsuario.lectura();
        }
        //BUCLE DE LECTURA DESDE EL FICHERO problema4.txt Y CONTABILIZACIÓN
        //PALABRA INTRODUCIDA POR TECLADO
        while (fichero.hayPalabras()) {
            //lectura objeto Palabra desde el fichero problema4.txt enlazado a través
            //del objeto fichero
            palabraFichero=fichero.lectura();
            //tratamiento objeto Palabra leído desde el fichero
            if (Palabra.iguales(palabraUsuario, palabraFichero)) {
                //incrementar contador de aparaiciones de la palabra introducida7
                //por teclado en el fichero
                contador++;
            }
        }
        //cierre enlace con fichero
        fichero.cerrarEnlaceFichero();
        //visualización resultado
        System.out.println("EL NÚMERO DE APARICIONES DE LA PALABRA "+
                palabraUsuario.toString()+" EN EL FICHERO ES: "+contador);
    }
        
}
