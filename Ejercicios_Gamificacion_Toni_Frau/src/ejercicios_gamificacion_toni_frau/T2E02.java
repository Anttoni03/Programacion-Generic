/*
 * FUNCIONALIDAD: guardar el valor de un caracter UNICODE a una variable entera
   para mostrarlo por pantalla
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL EJERCICIO 02{
    CREAR LAS VARIABLES Y ASIGNARLAS;
    IMPRIMIR POR PANTALLA UN MENSAJE CON UNA VARIABLE;
    
    ALGORITMO PARA CREAR VARIABLES{
        declarar una variable de un caracter con valor 'b';
        declarar una variable entera y no inicializarla;
        asignar el valor del caracter a la variable;
    }
    ALGORITMO PARA IMPRIMIR POR PANTALLA{
        imprimir a través del ssistema con la variable;
    }
}
*/
package ejercicios_gamificacion_toni_frau;

/**
 *
 * @author tonif
 */
public class T2E02
{
    public static void main(String[] args) throws Exception
    {
        char caracter = 'b';
        int codigo;
        codigo = caracter;
        System.out.println("EL CODIGO UNICODE DEL CARÁCTER " + caracter + " ES " + codigo);
    }
}
