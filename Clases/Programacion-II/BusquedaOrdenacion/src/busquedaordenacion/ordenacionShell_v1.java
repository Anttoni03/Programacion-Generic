// ORDENACIÓN SHELL o INSERCIÓN POR INCREMENTOS DECRECIENTES EN MEMORIA
//INTERNA A TRAVÉS DE UN VECTOR DE COMPONENTES ENTERAS
// realización: Juan Montes de Oca

package busquedaordenacion;
import java.util.*;
public class ordenacionShell_v1 {
    public static void main(String args []) {
        Random rand = new Random();
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) vector[i]=rand.nextInt(100);
        System.out.println("\n\n\n VECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
                System.out.print("\n\n");
        resultado=ordenarShell(vector);
        System.out.println("\n\n\n VECTOR ORDENADO CON SHELL");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }

    //MÉTODO DE ORDENACIÓN SHELL APLICADO EN UN
    //ARRAY DE COMPONENTES ENTERAS Y SIGUIENDO UN CRITERIO DE ORDENACIÓN
    //ASCENDENTE
     public static int [] ordenarShell (int [] numeros) {
        for (int incremento = numeros.length / 2;incremento > 0;incremento /= 2) {
            for (int i = incremento; i < numeros.length; i++) {
                for (int j = i; j >= incremento && numeros[j - incremento] > numeros[j]; j -= incremento) {
                    //INTERCAMBIAMOS LOS ELEMENTOS DE LAS POSICIONES ITERATIVAS
                    //UTILIZANDO UNA VARIABLE AUXILIAR
                    int auxiliar = numeros[j];
                    numeros[j] = numeros[j - incremento];
                    numeros[j - incremento] = auxiliar;
                }
            }
        }
        //devolución vector ordenado
        return numeros;
    }
}
