/*
 * FUNCIONALIDAD: crear subprograma para devolver el mayor de dos números enteros
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO03
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
        comparar num1 y num2 con operador ternario y dar el mayor a resultado;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio3 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        //declaración de 3 variables de tipo int para representar los 3 números enteros del problema
        int num1 = LT.readInt(),num2 = LT.readInt(); 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN enteroMayor
        int mayor = new Ejercicio3().enteroMayor(num1,num2);
        System.out.println("El máximo es " + mayor);
    }
    
    //método función para sumar enteros
    private int enteroMayor(int num1, int num2)
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