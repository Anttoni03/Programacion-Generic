// ORDENACIÓN FICHERO DE ENTEROS
// MÉTODO SELECCIÓN DIRECTA  


package busquedaordenacion;

import java.io.*;

public class ordenacion_fichero_numeros {
   public static void main( String [] args) throws IOException {
       //declaraciones
        final int DIMENSION=4;
        int numeroActual,valor_i,valorMinimo;
        RandomAccessFile fichero=new RandomAccessFile("numeros.dat","rw");
        int numElementos=(int) fichero.length()/DIMENSION;
        //acciones
        for (int i=0;i<numElementos-1;i++) {
            int minimo=i;
            fichero.seek(i*DIMENSION);
            valor_i=fichero.readInt();valorMinimo=valor_i;
            for (int j=i+1;j<numElementos;j++) {
                fichero.seek(j*DIMENSION); numeroActual=fichero.readInt();
                if (numeroActual<valorMinimo){
                    minimo=j;
                    valorMinimo=numeroActual;
                }
            }
            fichero.seek(minimo*DIMENSION); fichero.writeInt(valor_i);
            fichero.seek(i*DIMENSION); fichero.writeInt(valorMinimo);
        }
        fichero.close();
    }
}
