/*
 * FUNCIONALIDAD: crear subprograma que reciba un número entero y devuelva su
 * valor absoluto
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = 1; 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN valorAbsoluto
        int hayDosIguales = new Ejercicio7().valorAbsoluto(num1);
    }
    
    //método para evaluar un número entero y devolver su valor absoluto
    private int valorAbsoluto(int num1)
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
