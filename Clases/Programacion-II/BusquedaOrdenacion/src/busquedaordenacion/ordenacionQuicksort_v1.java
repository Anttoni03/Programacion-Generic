// ORDENACIÓN QUICKSORT
// realización: Juan Montes de Oca

package busquedaordenacion;
import java.util.*;


public class ordenacionQuicksort_v1 {
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



  public static int [] quicksort(int v[],int ini,int fin) {
    int aux, indIni=ini, indFin=fin, pivote;
    if(fin>ini) {
      pivote=v[(ini+fin)/2];
      while(indIni<indFin) {
        while((indIni<fin)&&(v[indIni]<pivote))  ++indIni;
        while((indFin>ini)&&(v[indFin]>pivote))  --indFin;
        if(indIni<=indFin) {
          aux=v[indIni];
          v[indIni]=v[indFin];
          v[indFin]=aux;
          ++indIni;
          --indFin;
        }
      }
      if(ini<indFin) quicksort(v,ini,indFin);
      if(indIni<fin) quicksort(v,indIni,fin);
    }
      return v;
  }

}
