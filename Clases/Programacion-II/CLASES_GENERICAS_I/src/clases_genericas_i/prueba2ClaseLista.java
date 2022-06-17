/*
EJEMPLO UTILIZACIÓN CLASE Lista
 */
package clases_genericas_i;

public class prueba2ClaseLista {
    public static void main(String [] argumentos) throws Exception {
        final int numeroElementos=10;
        Lista <Integer> milista=new Lista<Integer>(numeroElementos);
        //introducir 10 valores en la lista milista
        for (int i=0;i<numeroElementos;i++) {
            milista.introducir(i);
        }
        for (int i=0;!milista.estaVacia();i++) {
            System.out.println(milista.extraer((milista.numElementos()-1)));
        }    
    }    
}
