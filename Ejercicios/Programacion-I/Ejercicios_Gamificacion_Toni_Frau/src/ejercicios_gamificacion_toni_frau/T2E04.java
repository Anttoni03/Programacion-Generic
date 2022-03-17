/*
 * FUNCIONALIDAD: programa para mostrar si un número real introducido por el
usuario pertenece o no al rango [-1.0,1.0]
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL EJERCICIO 04{
    CREAR LA VARIABLE DEL NÚMERO;
    IMPRIMIR POR PANTALLA UN MENSAJE DEPENDIENDO DE SI FORMA PARTE DEL RANGO INDICADO;
    
    ALGORITMO PARA CREAR VARIABLE{
        mostrar un mensaje para introducir un número;
        declarar una variable double y asignarle un valor con entrada del usuario;
    }
    ALGORITMO PARA MOSTRAR UN MENSAJE DEPENDIENDO DEL RANGO{
        dentro de una decisión, if con la condición boleana de si la variable
        es mayor o igual a -1.0 y menor a 1.0;
        si es verdadero muestra un mensaje de que el número está en el rango;
        si es falso muestra un mensaje de que el número no está en el rango;
    }
}
*/
package ejercicios_gamificacion_toni_frau;

/**
 *
 * @author tonif
 */
public class T2E04
{
    public static void main(String[] args) throws Exception
    {
        System.out.print("INTRODUCE UN NÚMERO: ");
        double numero = LT.readDouble();
        
        if (numero <= 1.0 && numero >= -1.0)
            System.out.print("EL NÚMERO PERTENECE AL RANGO [-1.0,1.0]");
        else
            System.out.print("EL NÚMERO NO PERTENECE AL RANGO [-1.0,1.0]");
    }
}
