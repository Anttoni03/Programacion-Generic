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
        en bucle mientras i = numero dado / 2 mientras sea mayor a 1 restando 1 a i
        {
            comprobar si módulo número dado entre i es 0 asignando a resultado; 
        }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver lo contrario del resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio11 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int num1 = LT.readInt();
    
        //ACCIONES
        boolean esPrimo = new Ejercicio11().esPrimo(num1);
        System.out.println(esPrimo?"Es primo":"No es primo");
    }
  
    //método función que devuelve true si un primer número es divisor de un segundo
    private boolean esPrimo(int numero)
    {
        //DECLARACIONES
        boolean noEsPrimo = false;
    
        //ACCIONES
        for (int i = numero / 2; i > 1; i--)
            noEsPrimo = numero % i == 0;
    
        //DEVOLVER RESULTADO
        return !noEsPrimo;
    }
}