/*
FUNCIONALIDAD: lectura de una fichero de enteros con DataInputSTream
 */

package busquedaordenacion;

import java.io.*;

public class lecturaFichero {
    public static void main(String[] args) {
        try{
            FileInputStream fichero=new FileInputStream("numeros.dat");
            BufferedInputStream buffer=new BufferedInputStream(fichero);
            DataInputStream datos=new DataInputStream(buffer);
            try {
                int contador=0;
                while (true) {
                    int entrada=datos.readInt();
                        System.out.println(entrada);
                    }
            } catch (Exception e) {datos.close();}
        } catch (Exception e) {System.out.println("ERRROR  " +
                e.toString());}
    }
}
