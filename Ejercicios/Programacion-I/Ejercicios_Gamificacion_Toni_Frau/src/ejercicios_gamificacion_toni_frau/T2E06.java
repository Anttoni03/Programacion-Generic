/*
 * FUNCIONALIDAD: programa para mostrar si un número introducido por el usuario
 * es o no múltiplo de cinco
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL EJERCICIO 06{
    CREAR LA VARIABLE DEL NÚMERO NECESARIO;
    IMPRIMIR POR PANTALLA UN MENSAJE DEPENDIENDO DEL CÁLCULO DE SE ES MÚLTIPLO DE CINCO;
    
    ALGORITMO PARA CREAR VARIABLE{
        mostrar un mensaje para introducir un número entero;
        declarar una variable entera y asignarle un valor con entrada del usuario;
    }
    ALGORITMO PARA MOSTRAR UN MENSAJE DEPENDIENDO DE SI ES MÚLTIPLO DE CINCO{
        dentro de una decisión, if con la condición boleana de si el módulo con
        5 es cero;
        si es verdadero muestra un mensaje de que el número es múltiplo de cinco;
        si es falso muestra un mensaje de que el número no es múltiplo de cinco;
    }
}
*/
package ejercicios_gamificacion_toni_frau;

/**
 *
 * @author tonif
 */
public class T2E06
{
    public static void main(String[] args) throws Exception
    {
        System.out.print("INTRODUCE UN NÚMERO: ");
        int numero = LT.readInt();
        
        if (numero % 5 == 0)
            System.out.println("EL NÚMERO " + numero + " ES MÚLTIPLO DE CINCO");
        else
            System.out.println("EL NÚMERO " + numero + " NO ES MÚLTIPLO DE CINCO");
    }
}
