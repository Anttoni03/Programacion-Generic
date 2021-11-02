/*
FINALIDAD: este programa ilustra que el paso por parámetros en java se lleva a
cabo a través de la modalidad POR VALOR, es decir, el parámetro de la llamada
le pasa el valor al parámetro del subprograma, lo cual, no repercute en el contenido
del parametro de la llamada. No obstante, cuando se utiliza un OBJETO (los arrays en
java son objeto) como parámetro en la llamada a un subprograma, el paso por
parámetro utiliza la modalidad POR REFERENCIA, es decir, se pasa la dirección de
memoria el parámetro de llamada al del subproigrama, lo cual conlleva que cualquier 
modificación que, en el subprograma, se haga con el parámetro receptor va a repercutir
en el parámetro de llamada.
*/
package clasepractica_02_11_2021;

public class IlustracionPasoDeParametrosArrays {
    public static void main(String [] argumentos) throws Exception {
        new IlustracionPasoDeParametrosArrays().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaracion variable entera contador
        int contador=0;
        //declaración array variable de enteros de 5 componentes inicializadas a 0
        int [] contadores={0,0,0,0,0};
        
        //ACCIONES
        //llamada metodo incrementador de variable entera
        incrementador(contador);
        //llamada metodo incrementador de array de enteros
        incrementador(contadores);
        //visualización variable entera
        System.out.println("EL VALOR DE LA VARIABLE ENTERA ES: "+contador);
        //visualización componentes array
        for (int indice=0;indice<contadores.length;indice++) {
            System.out.println("COMPONENTE "+(indice+1)+": "+contadores[indice]);
        }
    }
    
    //método incrementador variable entera lleva a cabo el incremento del valor
    //dado por parametro
    private void incrementador(int dato) {
        dato++;
    }
    
    //metodo incrementador array de enteros lleva a caboel incremento del valor de
    //sus componenentes
    private void incrementador(int [] datos) {
         for (int indice=0;indice<datos.length;indice++) {
             datos[indice]++;
         }
    }
    
}
