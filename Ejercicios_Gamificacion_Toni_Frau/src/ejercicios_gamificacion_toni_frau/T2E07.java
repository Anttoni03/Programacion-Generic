/*
 * FUNCIONALIDAD: programa para mostrar si un número introducido por el usuario
corresponde a un valor como evaluación
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL EJERCICIO 07{
    CREAR LAS VARIABLES DEL NÚMERO NECESARIO Y UN MENSAJE A MOSTRAR;
    ESCOJER UN MENSAJE A MOSTRAR DEPENDIENDO DEL NÚMERO;
    IMPRIMIR POR PANTALLA EL MENSAJE DESEADO;
    
    ALGORITMO PARA CREAR VARIABLES{
        mostrar un mensaje para introducir un número entero;
        declarar una variable entera y asignarle un valor con entrada del usuario;
        declarar e inicializar una variable String con valor vacío;
    }
    ALGORITMO PARA ESCOGER EL MENSAJE A MOSTRAR DEPENDIENDO DE LA NOTA{
        en una estructura switch, apuntar el mensaje para cada caso de la nota:
            si es 10, el mensaje será MATRÍCULA DE HONOR;
            si es 9, el mensaje será SOBRESALIENTE;
            si es 7 u 8, el mensaje será NOTABLE;
            si es 5 o 6, el mensaje será APROBADO;
            si es 0, 1, 2, 3 o 4, el mensaje será SUSPENSO;
    }
    ALGORITMO PARA MOSTRAR EL MENSAJE{
        mostrar un mensaje por pantalla con el mensaje escogido;
    }
}
*/
package ejercicios_gamificacion_toni_frau;

/**
 *
 * @author tonif
 */
public class T2E07
{
    public static void main(String[] args) throws Exception
    {
        System.out.print("INTRODUCE UNA NOTA: ");
        
        int nota = LT.readInt();
        
        String mensaje = "";
        
        switch (nota){
            case 10:
                mensaje = "MATRÍCULA DE HONOR";
                break;
            case 9:
                mensaje = "SOBRESALIENTE";
                break;
            case 7: case 8:
                mensaje = "NOTABLE";
                break;
            case 5: case 6:
                mensaje = "APROBADO";
                break;
            case 0: case 1: case 2: case 3: case 4:
                mensaje = "SUSPENSO";
                break;
        }
        
        System.out.println("LA NOTA " + nota + " ES UN " + mensaje);
    }
}
