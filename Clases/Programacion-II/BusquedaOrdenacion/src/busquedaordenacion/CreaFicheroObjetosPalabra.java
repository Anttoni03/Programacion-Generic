/*
Creación de un fichero de objetos Palabra de las palabras contenidas en un texto
introducido por teclado.
Utilización de la clase RandomAccessFile.

PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
 */

package busquedaordenacion;


public class CreaFicheroObjetosPalabra {
    
    public static void main(String [] args) throws Exception {
        new CreaFicheroObjetosPalabra().inicializacion();
    }
    public void inicializacion() throws Exception {
        //DECLARACIONES
        Palabra palabra=new Palabra();
        FicheroPalabrasInOut fichero=null;
        
        //ACCIONES
        fichero=new FicheroPalabrasInOut("palabras.dat");
        System.out.print("INTRODUCIR TEXTO: ");
        while (Palabra.hayPalabras()) {
            palabra.lectura();
            fichero.escritura(palabra);
        }
        fichero.cierre();
    }
    
}
