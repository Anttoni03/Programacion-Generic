/*
 * FUNCIONALIDAD: programa para mostrar una suma de un determinado número de valores
 * insertados por el usuario utilizando la sentencia FOR
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 16.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 02{
    CREAR LAS VARIABLES DE LOS NÚMEROS NECESARIOS;
    REALIZAR LA SUMA DE LA CANTIDAD DE NÚMEROS DEFINIDOS POR EL USUARIO;
    IMPRIMIR POR PANTALLA UN MENSAJE DE LA SUMA FINAL;
    
    ALGORITMO PARA CREAR VARIABLES{
        mostrar un mensaje para introducir la cantidad de números a sumar;
        declarar una variable entera y asignarle un valor con entrada del usuario;
        declarar variable entera para la suma;
    }
    ALGORITMO DE SUMA DE NÚMEROS{
        iniciar un FOR para sumar valores;
        imprimir mensaje para introducir un valor;
        sumar a la suma el valor;
        reducir los numeros a sumar;
    }
    ALGORITMO PARA MOSTRAR UN MENSAJE DE SUMA{
        mostrar mensaje con la suma final;
    }
}
*/
package ejercicios_gamificacion_2_toni_frau;

public class Problema2 {
    public static void main(String[] args) throws Exception
    {
        System.out.print("Introduce la cantidad de números a sumar: ");
        int numerosASumar = LT.readInt();
        int sum = 0;
        
        for (int i = 0; i < numerosASumar; i++)
        {
            System.out.print("Introduce un número a sumar: ");
            int sumando = LT.readInt();
            sum += sumando;
        }       
        
        System.out.println("La suma final es: " + sum);
    }
}
