/*
FUNCIONALIDAD: dado un fichero de texto de nombre palabras1.txt lleva a cabo la
visualización de las palabras contenidas en dicho fichero.
NOTA: UTILIZACIÓN CLASE PalabraFicherosLectura
 */
package clase_teoría___10_12_2021;

public class FicherosPalabras__Problema1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new FicherosPalabras__Problema1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para porder leer objetos Palabra
        //desde un fichero de texto
        PalabraFicherosLectura fichero;
        //declaración objeto Palabra para almacenar, de una en una, los objetos
        //Palabra leídos desde un fichero
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura para establecer el enlace
        //con el fichero de texto palabras1.txt en modo lectura a nivel de objetos
        //Palabra
        fichero=new PalabraFicherosLectura("palabras1.txt");
        //BUCLE DELECTURA DESDE EL FICHERO palabras1.txt Y VISUALIZACIÓN A NIVEL
        //DE OBJETOS Palabra
        while (fichero.hayPalabras()) {
            //lectura objeto Palabra desde el fichero palabras1.txt enlazado a través
            //del objeto fichero
            palabra=fichero.lectura();
            //visualización objeto Palabra leído
            System.out.println(palabra.toString());
        }
        //cierre enlace con fichero
        fichero.cerrarEnlaceFichero();
    }
    
}
