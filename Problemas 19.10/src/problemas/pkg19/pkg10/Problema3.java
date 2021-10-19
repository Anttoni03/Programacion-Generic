/*
 * FUNCIONALIDAD: programa para realizar el sumatorio del tipo i=1->sum->n siendo
 * n un valor entero introducido por el usuario, mostrando el resultado al final
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 19.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 03{
    REGISTRAR LAS REPETICIONES Y CREAR LA SUMA;
    REALIZAR EL SUMATORIO CON ALGORITMO DE RECORRIDO;
    IMPRIMIR RESULTADO;
    
    ALGORITMO PARA RESGISTRAR Y CREAR VARIABLES{
        declarar variable entera para repeticiones;
        declarar variable decimal para la suma;
        mostrar mensaje para insertar mensaje;
        regisrar n por entrada de usuario;
    }
    ALGORITMO PARA REALIZAR EL SUMATORIO{
        para (i = 1 hasta i <= repeticiones sumando 1 a i)
            sumar a suma 3/(i+1) con casting a decimal;
    }
    ALGORITMO DE ESCRIBIR RESULTADO{
        imprimir por pantalla la suma;
    }
}
*/
package problemas.pkg19.pkg10;

public class Problema3 {
    public static void main(String[] args) throws Exception
    {
        int nVeces;
        float suma = 0f;
        
        System.out.println("Introduce un número entero para las repeticiones: ");
        nVeces = LT.readInt();
        
        for (int i = 1; i <= nVeces; i++)
            suma += 3/(float)(i+1);
        
        System.out.println("El resultado es : "+ suma);
    }
}
