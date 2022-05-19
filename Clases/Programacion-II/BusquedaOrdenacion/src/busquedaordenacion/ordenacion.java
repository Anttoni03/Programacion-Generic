// ORDENACIÓN SACUDIDA

package busquedaordenacion;
import java.util.*;
public class ordenacion {
    public static void main(String args []) {
        Random rand = new Random();
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) vector[i]=rand.nextInt(5);
        System.out.println("\n\n\n VECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
        resultado=sacudida(vector);
        System.out.println("\n\n\n VECTOR ORDENADO CON SACUDIDA");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }

    public static int [] sacudida(int numeros[]) {
        int ultimo=0, izquierda, derecha,num=numeros.length;
        do {
            for(int i=num-1;i>0;i--){
                //Burbuja hacia la izquierda
                //Los valores menores van a la izquierda
                if(numeros[i-1] > numeros[i]){
                    int aux = numeros[i];
                    numeros[i] = numeros[i-1];
                    numeros[i-1] = aux;
                    ultimo = i;
                }
            }
            izquierda = ultimo+1;
            for(int j=1;j<num;j++){
                if(numeros[j-1] > numeros[j]){
                    int aux = numeros[j];
                    numeros[j] = numeros[j-1];
                    numeros[j-1] = aux;
                    ultimo = j;
                }
            }
            derecha = ultimo-1;
        }while(derecha >= izquierda);
        return numeros;
    }

}
