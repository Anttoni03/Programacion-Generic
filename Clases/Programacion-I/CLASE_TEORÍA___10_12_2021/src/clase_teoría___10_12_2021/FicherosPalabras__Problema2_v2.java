/*
FUNCIONALIDAD: dado un texto introducido por teclado y acabado con el caracter '.',
lleva a cabo la lectura de las palabras contenidas en el texto y la escritura de
éstas en un fichero de texto de nombre palabras2.txt
NOTA: LAS PALABRAS SERÁN GRABADAS EN EL FICHERO CADA UNA EN UNA LÍNEA.
 */
package clase_teoría___10_12_2021;

public class FicherosPalabras__Problema2_v2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new FicherosPalabras__Problema2_v2().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosEscritura para poder escribir objetos Palabra
        //en un fichero de texto
        PalabraFicherosEscritura fichero;
        //declaración objeto Palabra para almacenar, de una en una, los objetos
        //Palabra leídos desde el texto introducido por teclado
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //instanciación objeto PalabraFicherosEscritura para establecer el enlace
        //con el fichero de texto palabras2.txt en modo escritura a nivel de objetos
        //Palabra
        fichero=new PalabraFicherosEscritura("palabras2.txt");
        //mesnaje usuario para introducir texto por teclado
        System.out.print("INTRODUCIR TEXTO: ");
        //BUCLE DE LECTURA DESDE EL TEXTO INTRODUCIDO POR TECLADO Y ESCRITURA EN
        //EL FICHERO palabrs2.txt A NIVEL DE OBJETOS Palabra
        while (Palabra.hayPalabras()) {
            //lectura objeto Palabra desde el texto introducido por teclado
            palabra.lectura();
            //escribir el objeto Palabra leído desde el texto en el fichero
            //palabras2.txt
            fichero.escritura(palabra);
            //introducir salto de línea en el fichero palabras2.txt
            fichero.nuevaLinea();
        }
        //cierre enlace con fichero
        fichero.cerrarEnlaceFichero();
    }
    
}
