/*
 * FUNCIONALIDAD: programa para realizar el factorial de un número entero introducido
 * por el usuario
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 19.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 01{
    REGISTRAR EL NÚMERO;
    REALIZAR EL FACTORIAL DEL NÚMERO;
    IMPRIMIR RESULTADO;
    
    ALGORITMO PARA RESGISTRAR Y CREAR VARIABLES{
        declarar variable entera para factorial;
        mostrar mensaje para insertar mensaje;
        regisrar valor por entrada de usuario;
    }
    ALGORITMO PARA REALIZAR EL SUMATORIO{
        para (i = valor-1 hasta i = 1 restando 1 a i)
            multiplicar valor con i;
    }
    ALGORITMO DE ESCRIBIR RESULTADO{
        imprimir por pantalla el valor resultado;
    }
}
*/
package problemas.pkg19.pkg10;

public class Problema1 {
    public static void main(String[] args) throws Exception
    {
        int valor;
        
        System.out.print("Introduce un número para realizar el factorial: ");
        valor = LT.readInt();
        
        for (int i = valor - 1; i > 1; i--)
            valor *= i;
        
        System.out.println("El factorial es: " + valor);
    }
}
