/*
 * FUNCIONALIDAD: crear subprograma para devolver el mayor de tres números enteros
 * ayudándose del subprograma de evaluar el mayor de 2 números enteros del problema 3
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO05
{
    HACER DECLARACIONES;
    TRATAR DATOS AL COMPARAR;
    DEVOLVER RESULTADO;

    ALGORITMO DECLARACIONES
    {
        resultado de número entero;
    }
    ALGORITMO TRATAR DATOS
    {
        comparar num1, num2 y num3 usando dos veces el subprograma del comparador
        del ejercicio 3 y dar el mayor a resultado;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio5 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = LT.readInt(),num2 = LT.readInt(), num3 = LT.readInt(); 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN enteroMayor
        int mayor = new Ejercicio5().enteroMayor(num1,num2, num3);
        System.out.println("El máximo es " + mayor);
    }
    
    //método para evaluar el mayor de 3 enteros
    private int enteroMayor(int num1, int num2, int num3)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO
        resultado = (new Ejercicio5().enteroMayorEj3(
                new Ejercicio5().enteroMayorEj3(num1,num2),num3));
        
        //DEVOLVER RESULTADO
        return resultado;
    }
    
    //método para evaluar mayor de 2 enteros del ejercicio 3
    private int enteroMayorEj3(int num1, int num2)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO
        resultado = (num1 >= num2)? num1 : num2;
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
