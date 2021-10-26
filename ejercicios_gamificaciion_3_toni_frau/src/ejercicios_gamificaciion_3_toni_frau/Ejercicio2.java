/*
 * FUNCIONALIDAD: crear subprograma para sumar dos números enteros e imprimir
 * su valor, pero no devuelve nada
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio2 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = 1,num2 = 2; 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN sumaEnteros
        new Ejercicio2().sumaEnteros(num1,num2);
    }
    
    //método para sumar enteros
    private void sumaEnteros(int num1, int num2)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO
        resultado = num1 + num2;
        
        //IMPRIMIR RESULTADO
        System.out.println("La suma es " + resultado);        
    }
}
