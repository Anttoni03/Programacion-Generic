/*
CÁLCULO DE LAS PERMUTACIONES DE UN VECTOR
 */

package permutaciones;

public class CalculoPermutaciones {

    public static void main(String[] args) {
        int [] valores={0,1,2,3,4};
        Vector permutacion;
        Vector vector=new Vector(valores);
        System.out.println("LISTADO PERMUTACIONES SIN REPETECIÓN VECTOR "+vector.toString()+"\n");
        permutacion=vector.primeraPermutacion();
        do {
           System.out.println(permutacion.toString());
           permutacion=permutacion.siguientePermutacion();
        } while (!permutacion.ultimaPermutacion());
        System.out.println(permutacion);
    }
}
