// ORDENACIÓN SACUDIDA EN MEMORIA
//INTERNA A TRAVÉS DE UN VECTOR DE COMPONENTES ENTERAS


package busquedaordenacion;
import java.util.*;
public class ordenacionSacudida {
    public static void main(String args []) {
        Random rand = new Random();
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) vector[i]=rand.nextInt(100);
        System.out.println("\n\n\n VECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
        resultado=sacudida(vector);
        System.out.println("\n\n\n VECTOR ORDENADO CON SACUDIDA");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }

    //MÉTODO DE ORDENACIÓN SACUDIDA APLICADO EN UN
    //ARRAY DE COMPONENTES ENTERAS Y SIGUIENDO UN CRITERIO DE ORDENACIÓN
    //ASCENDENTE
    public static int [] sacudida(int numeros[]) {
        //DECLARACIONES
        //declaración variable que controlará el índice de la última componente
        //sobre la que se ha aplicado un intercambio
        int ultimaComponenteIntercambiada=0;
        //declaraciones variables de control de las pasadas en ambos sentidos
        //del algortimo de intercambios sucesivos
        int indiceIzquierdo, indiceDerecho;
        do {
            for(int indice=numeros.length-1;indice>0;indice--){
                //Burbuja hacia la izquierda
                //Los valores menores van hacia la izquierda
                if(numeros[indice-1] > numeros[indice]){
                    //INTERCAMBIAMOS LOS ELEMENTOS DE LAS POSICIONES ITERATIVAS
                    //UTILIZANDO UNA VARIABLE AUXILIAR
                    int auxiliar = numeros[indice];
                    numeros[indice] = numeros[indice-1];
                    numeros[indice-1] = auxiliar;
                    //actualización del índice de la última componente intercambiada
                    ultimaComponenteIntercambiada = indice;
                }
            }
            //actualización indiceIzquierdo con el índice de la última componente
            //intercambiada
            indiceIzquierdo = ultimaComponenteIntercambiada+1;
            //Burbuja hacia la derecha    
            //Los valores mayores van a la derecha
            for(int indice=1;indice<numeros.length;indice++){
                if(numeros[indice-1] > numeros[indice]){
                    //INTERCAMBIAMOS LOS ELEMENTOS DE LAS POSICIONES ITERATIVAS
                    //UTILIZANDO UNA VARIABLE AUXILIAR
                    int aux = numeros[indice];
                    numeros[indice] = numeros[indice-1];
                    numeros[indice-1] = aux;
                    //actualización del índice de la última componente intercambiada
                    ultimaComponenteIntercambiada = indice;
                }
            }            
            //actualización indiceDerecho con el índice de la última componente
            //intercambiada
            indiceDerecho = ultimaComponenteIntercambiada-1;
        }while(indiceDerecho >= indiceIzquierdo);
        //devolución vector ordenado
        return numeros;
    }

}
