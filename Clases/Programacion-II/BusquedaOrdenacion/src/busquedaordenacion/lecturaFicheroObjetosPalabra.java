/*
Lectura de un fichero de objetos Palabra utilizando la clase RandomAccessFile

PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
 */

package busquedaordenacion;


public class lecturaFicheroObjetosPalabra {
    public static void main(String [] args) throws Exception {
        new lecturaFicheroObjetosPalabra().inicializacion();
    }
    public void inicializacion() throws Exception {            
        //DECLARACIONES
        
        FicheroPalabrasInOut fichero=null;
        
        //ACCIONES
        fichero=new FicheroPalabrasInOut("palabras.dat");
        Palabra palabra=new Palabra();
        palabra=fichero.lectura();
        while (palabra!=null) {
            System.out.println(palabra.toString());
            palabra=new Palabra();
            palabra=fichero.lectura();
        }
        fichero.cierre();      
    }
}
