/*
 * FUNCIONALIDAD: crear subprograma que reciba un número entero y devuelva su
 * valor absoluto
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO07
{
    HACER DECLARACIONES;
    TRATAR DATOS AL COMPARAR;
    DEVOLVER RESULTADO;

    ALGORITMO DECLARACIONES
    {
        resultado número entero;
    }
    ALGORITMO TRATAR DATOS
    {
        comparar si número dado es mayor o igual a 0 y asignarle su positivo con
        operador ternario;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int numero = LT.readInt(); 
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN valorAbsoluto
        int valAbsoluto = new Ejercicio7().valorAbsoluto(numero);
        System.out.println("Es " + valAbsoluto);
    }
    
    //método para evaluar un número entero y devolver su valor absoluto
    private int valorAbsoluto(int numero)
    {
        //DECLARACIONES
        int resultado;
        
        //ACCIONES
        //TRATAMIENTO        
        resultado = (numero >= 0)? numero : -numero;
        
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
