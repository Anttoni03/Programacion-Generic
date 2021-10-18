/*
 * FUNCIONALIDAD: programa para mostrar si un número entero introducido por el
usuario es positivo o negativo
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL EJERCICIO 03{
    CREAR LA VARIABLE DEL NÚMERO;
    IMPRIMIR POR PANTALLA UN MENSAJE DEPENDIENDO DEL SIGNO DE LA VARIABLE;
    
    ALGORITMO PARA CREAR VARIABLE{
        mostrar un mensaje para introducir un número;
        declarar una variable entera y asignarle un valor con entrada del usuario;
    }
    ALGORITMO PARA MOSTRAR UN MENSAJE DEPENDIENDO DE LA VARIABLE{
        dentro de una decisión, if con la condición boleana de si la variable
        es mayor o menor a cero;
        si es positivo muestra un mensaje de que el número es positivo;
        si es negativo muestra un mensaje de que el número es negativo;
    }
}
*/
package ejercicios_gamificacion_toni_frau;

/**
 *
 * @author tonif
 */
public class T2E03
{
    public static void main(String[] args) throws Exception
    {
        System.out.print("INTRODUCE UN NÚMERO ENTERO: ");
        int numero = LT.readInt();
        
        if (numero >= 0)
            System.out.println("EL NÚMERO ES POSITIVO");
        else
            System.out.println("EL NÚMERO ES NEGATIVO");
    }
}
