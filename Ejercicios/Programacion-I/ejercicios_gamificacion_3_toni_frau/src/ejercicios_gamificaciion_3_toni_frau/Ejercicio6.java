/*
 * FUNCIONALIDAD: crear subprograma para evaluar si al menos dos de tres números
 * enteros son iguales y mostrarlo por pantalla
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO06
{
    HACER DECLARACIONES;
    TRATAR DATOS AL COMPARAR;
    DEVOLVER RESULTADO;

    ALGORITMO DECLARACIONES
    {
        resultado booleano en falso;
    }
    ALGORITMO TRATAR DATOS
    {
        comparar las combinaciones con num1, num2 y num3 si coinciden asignando resultado;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio6 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = LT.readInt(),num2 = LT.readInt(), num3 = LT.readInt(); 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN hayDosIguales
        boolean hayDosIguales = new Ejercicio6().hayDosIguales(num1,num2, num3);
        System.out.println(hayDosIguales?"Hay dos o más iguales iguales":"No hay dos o más iguales");
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
