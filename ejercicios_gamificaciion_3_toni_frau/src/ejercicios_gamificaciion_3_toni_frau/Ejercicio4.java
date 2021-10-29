/*
 * FUNCIONALIDAD: crear subprograma para devolver el mayor de tres números enteros
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO04
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
        comparar num1, num2 y num3 con dos operadores ternarios concatenados y
        dar el mayor a resultado;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio4 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = LT.readInt(),num2 = LT.readInt(), num3 = LT.readInt(); 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN enteroMayor
        int mayor = new Ejercicio4().enteroMayor(num1,num2, num3);
        System.out.println("El máximo es " + mayor);
    }
    
    //método para evaluar el mayor de 3 enteros
    private int enteroMayor(int num1, int num2, int num3)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO
        resultado = (num1 >= num2)? ((num1 >= num3)? num1 : num3) : ((num2 >= num3)? num2 : num3);
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
