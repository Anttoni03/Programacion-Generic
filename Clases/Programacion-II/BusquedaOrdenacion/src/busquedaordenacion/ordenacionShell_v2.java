// ORDENACIÓN SHELL o INSERCIÓN POR INCREMENTOS DECRECIENTES EN MEMORIA
//INTERNA A TRAVÉS DE UN VCETOR DE COMPONENTES ENTERAS
// realización: Juan Montes de Oca

package busquedaordenacion;
import java.util.*;
public class ordenacionShell_v2 {
    public static void main(String args []) {
        Random rand = new Random();
        int vector []=new int[10];int resultado []=new int[10];
        for (int i=0;i<vector.length;i++) vector[i]=rand.nextInt(100);
        System.out.println("\n\n\n VECTOR SIN ORDENAR");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + vector[i]);
        resultado=shell(vector);
        System.out.println("\n\n\n ORDENADO CON SHELL");
        for (int i=0;i<vector.length;i++) System.out.print("\t" + resultado[i]);
        System.out.println();
    }

    //MÉTODO DE ORDENACIÓN SHELL APLICADO EN UN
    //ARRAY DE COMPONENTES ENTERAS Y SIGUIENDO UN CRITERIO DE ORDENACIÓN
    //ASCENDENTE
    public static int [] shell (int[] numeros){
        //DECLARACIONES
        int incremento,indice,intercambios;
        incremento=numeros.length;
        do{
            incremento=incremento/2;
            do{
                intercambios=0;
                indice=-1;
                do{
                    indice++;
                    if(numeros[indice]>numeros[indice+incremento]) {
                        int aux=numeros[indice];
                        numeros[indice]=numeros[indice+incremento];
                        numeros[indice+incremento]=aux;
                        intercambios++;
                    }
                }while(indice+incremento!=numeros.length-1);
            }while(intercambios!=0);
        }while(incremento>1);
        return numeros;
    }
}
