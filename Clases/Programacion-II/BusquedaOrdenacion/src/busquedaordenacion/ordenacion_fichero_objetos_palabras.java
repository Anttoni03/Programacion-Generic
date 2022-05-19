/*
Ordenación, orden creciente, de un fichero de objetos Palabra en función del número
de caracteres de las palabras contenidas en él.
MÉTODO DE ORDENACIÓN UTILIZADO: Selección directa.

PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
 */
package busquedaordenacion;


public class ordenacion_fichero_objetos_palabras {
   public static void main( String [] args) {
       try {
           //declaraciones
            FicheroPalabrasInOut fichero=new FicheroPalabrasInOut("palabras.dat");
            //acciones
            //Implementación algoritmo Selección directa
            for (int i=0;i<fichero.getNumPalabras()-1;i++) {
                int minimo=i; 
                Palabra objetoPalabraMenor=new Palabra();
                objetoPalabraMenor=fichero.lectura(i);
                Palabra objetoPalabra_i=new Palabra();
                Palabra.copiar(objetoPalabraMenor,objetoPalabra_i);
                for (int j=i+1;j<fichero.getNumPalabras();j++) { 
                    Palabra objetoPalabraActual=new Palabra();
                    objetoPalabraActual=fichero.lectura(j);
                    if (objetoPalabraActual.menor(objetoPalabraMenor)){
                        minimo=j;
                        Palabra.copiar(objetoPalabraActual,objetoPalabraMenor);
                    }
                }
                fichero.escritura(objetoPalabraMenor,i);
                fichero.escritura(objetoPalabra_i,minimo);
            }
            fichero.cierre();
       }catch (Exception error) {
           System.out.println("ERROR: "+error.toString());
       }
    }
}
