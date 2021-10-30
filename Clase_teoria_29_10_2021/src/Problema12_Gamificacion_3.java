/*
PROBLEMA 12
Siguiente primero.
Subprograma que recibe un número entero y devuelve el número primo más pequeño
que sea mayor que este número. Por ejemplo,
siguientePrimero(7) = 11; siguientePrimero(14) = 17; 
 */


public class Problema12_Gamificacion_3 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Problema12_Gamificacion_3().metodoPrincipal();
    }
    
    //método metodoPrincipal
    public void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable entera ara representar el número entero a gestionar
        int numero=24;
        
        
        //ACCIONES
        //visualización del primer numero primo siguiente al numero
        System.out.println("EL PRIMER NÚMERO PRIMO SUPERIOR AL NÚMERO "+numero+" ES"+siguientePrimo(numero));
    }
    
    //método función siguientePrimo que devuelve el primer número primo superior al número
    //dado por parámetro
    private int siguientePrimo(int dato) {
        //DECLARACIONES
        boolean encontrado=false;
        int numeroVerificacion;
        
        //ACCIONES
        for (numeroVerificacion=dato+1;!encontrado;numeroVerificacion++) {
            encontrado=verificacionPrimo(numeroVerificacion);
        }
        return numeroVerificacion;
    }
    
    
    //método función de tipo booleano para verificar si un número dado por 
    //parámetro es primo o no
    private boolean verificacionPrimo(int dato) {
        //DECLARACIONES
        //declaración variable booleana para controlar el confirmacion
        //de si el número contenido en dato es primo o no
        boolean confirmacion=false;
        
        //ACCIONES
        //tratamiento verificación (la estrategía utilizada es la de
        //revisar el resto de las divisiones del número dado [dato] por un
        //divisor que comienza por ser dato/2 en la primera iteración y
        //es decrementado en cada una de ellas mientras sea mayor que 1.
        //Si el divisor llega a valer 1 significará que el número es primo pues
        //no ha habido ningún divisor con el que el resto de la división haya
        //sido 0 [controlado a través de la condición de finalización (divisor>1).
        //No obstante, si en una de las divisiones el resto fuera 0, significaría
        //que el número NO es primo y por ello se da el valor true a confirmacion. Ello
        //hará que a través de la condición de finalización que controla tal
        //situación (!confirmacion) haga terminar el bucle iterativo for.
        for (int divisor=dato/2;((divisor>1)&&!confirmacion);divisor--) {
            confirmacion=((dato%divisor)==0);
        }
        
        //devolvemos la negación del valor de la variable booleana confirmacion
        //de forma que si confirmacion contiene el valor TRUE significa que el
        //número NO ES PRIMO y si contiene el valor FALSE significará que SI ES
        //PRIMO
        return !confirmacion;
    }
    
}
