/*
 * FUNCIONALIDAD: programa para mostrar la suma, resta, multiplicación, división
y módulo de dos número introducidos por el usuario
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL EJERCICIO 05{
    CREAR LAS VARIABLES DE LOS NÚMEROS;
    IMPRIMIR POR PANTALLA UN MENSAJE CON LOS CÁLCULOS DEFINIDOS;
    
    ALGORITMO PARA CREAR VARIABLES{
        mostrar un mensaje para introducir un primer número;
        declarar una variable entera y asignarle un valor con entrada del usuario;
        mostrar un mensaje para introducir un segundo número;
        declarar una variable entera y asignarle un valor con entrada del usuario;
    }
    ALGORITMO PARA MOSTRAR UN MENSAJE SOBRE LOS CÁLCULOS DEFINIDOS{
        mensaje que tendrá la suma de los números con salto de línea seguido del
        cálculo de la resta, salto de línea, la multiplicación, la división y el
        módulo sin un salto de línea más;
    }
}
*/
package ejercicios_gamificacion_toni_frau;

/**
 *
 * @author tonif
 */
public class T2E05
{
    public static void main(String[] args) throws Exception
    {
        int num1, num2;
        System.out.print("INTRODUCE UN PRIMER NÚMERO: ");
        num1 = LT.readInt();
        System.out.print("INTRODUCE UN SEGUNDO NÚMERO: ");
        num2 = LT.readInt();
        
        System.out.println("LA SUMA " + num1 + " + " + num2 + " ES IGUAL A " + (num1+num2) +
                           "\nLA RESTA " + num1 + " - " + num2 + " ES IGUAL A " + (num1-num2) + 
                           "\nEL PRODUCTO " + num1 + " * " + num2 + " ES IGUAL A " + (num1*num2) +
                           "\nLA DIVISIÓN " + num1 + " / " + num2 + " ES IGUAL A " + ((float)num1/num2) +
                           "\nEL RESTO DE LA DIVISIÓN " + num1 + " / " + num2 + " ES IGUAL A " + (num1%num2));
    }
}
