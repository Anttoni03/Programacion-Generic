// ORDENACIÓN INSERCIÓN DIRECTA EN MEMORIA
//INTERNA A TRAVÉS DE UN VECTOR DE COMPONENTES ENTERAS
// realización: Juan Montes de Oca

package busquedaordenacion;
import java.util.*;
public class ordenacionInsercionDirecta {
     public static int numeroAleatorio(int min, int max) {
	return min + (new Random()).nextInt(max-min);
    }
    public static void main(String args []) {
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) vector[i]=numeroAleatorio(1,20);
        System.out.println("\n\n\nVECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
        resultado=insercionDirecta(vector);
        System.out.println("\n\n\n VECTOR ORDENADOR CON INSERCION DIRECTA");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }

    //MÉTODO DE ORDENACIÓN INSERCIÓN DIRECTA APLICADO EN UN
    //ARRAY DE COMPONENTES ENTERAS Y SIGUIENDO UN CRITERIO DE ORDENACIÓN
    //ASCENDENTE
    public static int []  insercionDirecta (int numeros[]) {
        //DECLARACIONES
        //declaraciones índices iterativos
        int indice1, indice2;
        //declaracion variable donde se almacenará el elemento menor en cada iteración
        int menor;
        
        //ACCIONES
        for (indice1=1; indice1<numeros.length; indice1++) {
            menor = numeros[indice1];
            for (indice2=indice1; (indice2>0) && (menor<numeros[indice2-1]); indice2--) {
                numeros[indice2] = numeros[indice2-1];
            }
            numeros[indice2] = menor;
            System.out.print("\nIter\t" +imp(numeros));
        }
        //devolución vector ordenado
        return numeros;
    }
    
    static String imp(int n[]){
        String r = "";
        for (int e : n)
            r+=e+"\t";
        return r;
    }
}

