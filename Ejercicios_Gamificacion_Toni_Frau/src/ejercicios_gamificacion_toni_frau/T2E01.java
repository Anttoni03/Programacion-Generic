package ejercicios_gamificacion_toni_frau;

/*
 * FUNCIONALIDAD: guardar el valor de una constante a una variable entera para
 * imprimirla por pantalla con un mensaje
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL EJERCICIO 01{
    CREAR LAS VARIABLES Y CONSTANTES;
    IMPRIMIR POR PANTALLA UN MENSAJE CON UNA VARIABLE;
    
    ALGORITMO PARA CREAR VARIABLES{
        declarar una variable entera y no inicializarla;
        declarar e inicializar una constante entera con el valor 10;
        asignar el valor de la constante a la variable;
    }
    ALGORITMO PARA IMPRIMIR POR PANTALLA{
        imprimir a través del sistema con la variable;
    }
}
*/

/**
 *
 * @author tonif
 */
public class T2E01 {
    public static void main(String[] args) throws Exception
    {
        int variable;
        final int CONSTANTE = 10;
        variable = CONSTANTE;
        System.out.println("EL VALOR DE variable ES: " + variable);
    }
}
