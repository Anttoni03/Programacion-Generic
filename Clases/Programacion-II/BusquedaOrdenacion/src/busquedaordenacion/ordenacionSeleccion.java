// ORDENACIÓN SELECCIÓN DIRECTA EN MEMORIA
//INTERNA A TRAVÉS DE UN VECTOR DE COMPONENTES ENTERAS
// realización: Juan Montes de Oca

package busquedaordenacion;
import java.util.*;
public class ordenacionSeleccion {
    public static void main(String args []) {
        Random rand = new Random();
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) {
            vector[i]=rand.nextInt(100);
        }
        System.out.println("\n\n\nVECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
        resultado=seleccionDirecta(vector);
        System.out.println("\n\n\n VECTOR ORDENADO CON SELECCION DIRECTA");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }

    //MÉTODO DE ORDENACIÓN SELECCIÓN DIRECTA APLICADO EN UN
    //ARRAY DE COMPONENTES ENTERAS Y SIGUIENDO UN CRITERIO DE ORDENACIÓN
    //ASCENDENTE
    public static int [] seleccionDirecta (int numeros[]) {
        //DECLARACIONES
        //declaración índices iterativos
        int indice1, indice2;
        //declaración variable donde se alamcenará la posición, en el vector, donde
        //se encuentra el elmento menor de los que quedan por ordenar
        int posicion_menor; 

        //ACCIONES
        for (indice1=0; indice1<numeros.length-1; indice1++) {
            posicion_menor = indice1;
            for (indice2=indice1+1; indice2<numeros.length; indice2++) {
                if (numeros[indice2]<numeros[posicion_menor]) {
                    posicion_menor = indice2;
                }
            } 
            //INTERCAMBIAMOS LOS ELEMENTOS DE LAS POSICIONES posicion_menor y la
            //POSICIÓN ITERATIVA indice1 UTILIZANDO UNA VARIABLE AUXILIAR
            int auxiliar = numeros[indice1]; 
            numeros[indice1] = numeros[posicion_menor]; 
            numeros[posicion_menor] = auxiliar; 
        }
        //devolución vector ordenado
        return numeros; 
    }
}
