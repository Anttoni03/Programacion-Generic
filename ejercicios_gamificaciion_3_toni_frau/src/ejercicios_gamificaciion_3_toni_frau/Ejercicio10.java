/*
 * FUNCIONALIDAD: crear subprograma que reciba un carácter y devuelva verdadero
 * si es una vocal y falso si no lo es
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO09
{
    HACER DECLARACIONES;
    TRATAR DATOS AL COMPARAR;
    DEVOLVER RESULTADO;

    ALGORITMO DECLARACIONES
    {
        resultado booleano;
    }
    ALGORITMO TRATAR DATOS
    {
        comparar si módulo de num2 entre num1 dados es 0 asignando al resultado;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio10 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = LT.readInt(), num2 = LT.readInt();
    
        //ACCIONES
        boolean esDivisor = new Ejercicio10().esDivisor(num1,num2);
        System.out.println(esDivisor?"Es divisor":"No es divisor");
    }
  
    //método función que devuelve true si un primer número es divisor de un segundo
    private boolean esDivisor(int num1,int num2)
    {
        //DECLARACIONES
        boolean esDivisor;
    
        //ACCIONES
        esDivisor = (num2%num1 == 0);
    
        //DEVOLVER RESULTADO
        return esDivisor;
    }
}