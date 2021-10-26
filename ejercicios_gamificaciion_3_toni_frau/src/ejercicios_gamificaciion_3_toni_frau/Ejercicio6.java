/*
 * FUNCIONALIDAD: crear subprograma para evaluar si al menos dos de tres números
 * enteros son iguales y mostrarlo por pantalla
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio6 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = 1,num2 = 2, num3 = 3; 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN hayDosIguales
        boolean hayDosIguales = new Ejercicio6().hayDosIguales(num1,num2, num3);
    }
    
    //método para evaluar si al menos 2 de 3 números son iguales
    private boolean hayDosIguales(int num1, int num2, int num3)
    {
        //DECLARACIONES
        boolean resultado = false;
        
        //ACCIONES
        //TRATAMIENTO        
        resultado = (num1 == num2 || num1 == num3 || num2 == num3);
        
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
