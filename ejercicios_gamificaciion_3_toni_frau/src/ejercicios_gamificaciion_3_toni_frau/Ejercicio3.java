/*
 * FUNCIONALIDAD: crear subprograma para devolver el mayor de dos números enteros
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio3 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = 1,num2 = 2; 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN enteroMayor
        int mayor = new Ejercicio3().enteroMayor(num1,num2);
    }
    
    //método función para sumar enteros
    private int enteroMayor(int num1, int num2)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO
        resultado = (num1 > num2)? num1 : num2;
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
