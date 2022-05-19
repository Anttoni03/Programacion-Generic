// ORDENACIÓN INTERCAMBIO SUCESIVOS (BURBUJA)EN MEMORIA
//INTERNA A TRAVÉS DE UN VECTOR DE COMPONENTES ENTERAS
// realización: Juan Montes de Oca

package busquedaordenacion;
import java.util.*;
public class ordenacionIntercambiosSucesivos {
    public static void main(String args []) {
        Random rand = new Random();
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) vector[i]=rand.nextInt(100);
        System.out.println("\n\n\nVECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
        resultado=burbuja(vector);
        System.out.println("\n\n\n VECTOR ORDENADO CON BURBUJA");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        resultado=burbuja2(vector);
        System.out.println("\n\n\n VECTOR ORDENADO CON BURBUJA 2");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }

    //MÉTODO DE ORDENACIÓN BURBUJA O INTERCAMBIOS SUCESIVOS APLICADO EN UN
    //ARRAY DE COMPONENTES ENTERAS Y SIGUIENDO UN CRITERIO DE ORDENACIÓN
    //ASCENDENTE
    public static int [] burbuja (int numeros[]) {
        for (int indice1=0; indice1<numeros.length-1; indice1++) {
            for (int indice2=0; indice2<numeros.length-1; indice2++) {
                if (numeros[indice2] > numeros[indice2+1]) {
                    //INTERCAMBIAMOS LOS ELEMENTOS DE LAS POSICIONES ITERATIVAS
                    //UTILIZANDO UNA VARIABLE AUXILIAR
                    int auxiliar = numeros[indice2];
                    numeros[indice2] = numeros[indice2+1];
                    numeros[indice2+1] = auxiliar;
                }
            }
        }
        //devolución vector ordenado
        return numeros;
    }

    
    //OPTIMIZACIÓN DEL ALGORITMO DE LA BURBUJA 
    //LA OPTIMIZACIÓN ESTÁ FUNDAMENTADA EN LA UTILIZACIÓN DE UNA VARIABLE
    //BOOLEANA PARA DETECTAR CUANDO NO SE HAYA LLEVADO A CABO NINGÚN INTERCAMBIO
    //EN UNA ITERACIÓN, HECHO QUE SIGNIFICARÁ QUE EL VECTOR YA ESTÁ ORDENADO Y
    //POR LO TANTO SE PUEDE FINALIZAR EL TRATAMIENTO SIN LLEVAR A CABO LAS
    //ITERACIONES RESTANTES
    public static int [] burbuja2 (int numeros[]) {
        //DECLARACIONES
        //declaración variable iterativa del bucle principal de tratamiento
        int indice1=0;
        //declaración variable booleana para controlar la ordenación del
        //vector
        boolean ordenado=false;

        //ACCIONES
        while ((indice1<numeros.length-1)&&(!ordenado)) {
            //al comienzo de cada iteración asignamos true a la vairable
            //booleana para controlar si no se ha llevado a cabo ningún
            //intercambio
            ordenado=true;
            for (int indice2=0; indice2<numeros.length-1; indice2++) {
                if (numeros[indice2] > numeros[indice2+1]) {
                    //asignamos false a la variable booleana con lo que
                    //se identifica que en esta iteración del bucle principal ya
                    //ha habido al menos un intercambio y por lo tanto
                    //el vector no estaría ordenado al final de la misma
                    ordenado=false;
                    //INTERCAMBIAMOS LOS ELEMENTOS DE LAS POSICIONES ITERATIVAS
                    //UTILIZANDO UNA VARIABLE AUXILIAR
                    int auxiliar = numeros[indice2];
                    numeros[indice2] = numeros[indice2+1];
                    numeros[indice2+1] = auxiliar;
                }
            }
            //incremeto del indice iterativo del bucle principal
            indice1++;
        }
        //devolución del vector ordenado
        return numeros;
    }
    
}
