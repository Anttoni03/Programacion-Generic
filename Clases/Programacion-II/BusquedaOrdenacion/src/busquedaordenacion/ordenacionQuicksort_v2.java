// ORDENACIÓN QUICKSORT

package busquedaordenacion;
import java.util.*;



public class ordenacionQuicksort_v2 {
    public static void main(String args []) {
        Random rand = new Random();
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) vector[i]=rand.nextInt(100);
        System.out.println("\n\n\n VECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
        resultado=quicksort(vector,0,vector.length-1);
        System.out.println("\n\n\n VECTOR ORDENADO CON QUICKSORT");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }



       public static int [] quicksort(int v[], int izda, int dcha) {
        int pivote; // Posición del pivote
        if (izda<dcha) {
            pivote = partir (v, izda, dcha);
            quicksort (v, izda, pivote-1);
            quicksort (v, pivote+1, dcha);
        }
        return v;
    }

    public static int partir(int v[], int primero, int ultimo) {
        int pivote = v[primero]; // Valor del pivote
        int temporal; // Variable auxiliar
        int izda = primero+1;
        int dcha = ultimo;
        do { // Pivotear…
            while ((izda<=dcha) && (v[izda]<=pivote))
                izda++;
            while ((izda<=dcha) && (v[dcha]>pivote))
                dcha--;
            if (izda < dcha) {
                temporal = v[izda];
                v[izda] = v[dcha];
                v[dcha] = temporal;
                dcha--;
                izda++;
            }
        } while (izda <= dcha);
        // Colocar el pivote en su sitio
        temporal = v[primero];
        v[primero] = v[dcha];
        v[dcha] = temporal;
        return dcha; // Posición del pivote
    }

}
