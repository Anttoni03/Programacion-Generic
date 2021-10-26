/*
 * FUNCIONALIDAD: crear subprograma que reciba un carácter y devuelva verdadero
 * si es igual a 'a' y falso si no lo es
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio8 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        char caracter;
        final char CARACTER_A_COMPROBAR = 'a';
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN valorAbsoluto
        boolean esIgual = new Ejercicio8().caracterIgual(caracter);
    }
    
    //método función para evaluar si un carácter es o no a otro previamente indicado('a')
    private boolean caracterIgual(char caracter)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO        
        resultado = (num1 >= 0)? num1 : -num1;
        
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
