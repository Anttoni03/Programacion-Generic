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
        comprobacion si es primo booleano en falso;
        número entero primo;
    }
    ALGORITMO TRATAR DATOS
    {
        en bucle mientras j = número + 1 mientras no sea primo sumando 1 a j
        {
            número entero como contador en 0;
            en bucle mientras i = numero dado / 2 mientras sea mayor a 1 restando 1 a i
            {
                si módulo j entre i es 0 aumentar el contador; 
            }
            si el contador no es cero
            {
                ser primo es verdadero;
                el primo es la j;
            }
        }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado j de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio12 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        int numero = LT.readInt();
    
        //ACCIONES
        int primo = new Ejercicio12().esPrimo(numero);
        System.out.println(primo);
    }
  
    //método función que devuelve true si un primer número es divisor de un segundo
    private int esPrimo(int numero)
    {
        //DECLARACIONES
        boolean esPrimo = false;
        int primo = 0;
    
        //ACCIONES
        for (int j = ++numero; !esPrimo; j++)
        {
            int counter = 0;
            for (int i = numero / 2; i > 1; i--)
                if (j % i == 0)
                    counter++;
            
            if (counter == 0)
            {
                esPrimo = true;
                primo = j;
            }
        }
    
        //DEVOLVER RESULTADO
        return primo;
    }
}