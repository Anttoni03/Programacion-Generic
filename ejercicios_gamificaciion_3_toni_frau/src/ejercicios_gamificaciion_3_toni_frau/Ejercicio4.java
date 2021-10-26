/*
 * FUNCIONALIDAD: crear subprograma para devolver el mayor de tres números enteros
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio4 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = 1,num2 = 2, num3 = 3; 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN enteroMayor
        int mayor = new Ejercicio4().enteroMayor(num1,num2, num3);
    }
    
    //método para evaluar el mayor de 3 enteros
    private int enteroMayor(int num1, int num2, int num3)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO
        resultado = (num1 > num2)? ((num1 > num3)? num1 : num3) : num2;
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
