/*
FUNCIONALIDAD: programa que convierte una cantidad de euros a dólares
OBJETIVO: prática para aprender java
FECHA DE REALIZACIÓN: 05.10.2021
AUTOR: Antoni Frau Gordiola
*/
/*
ALGORITMO DE CONVERSIÓN DE EUROS A DÓLARES{
    PEDIR AL USUARIO UNA CANTIDAD DE EUROS A CONVERTIR;
    TRATAR LOS DATOS;
    MOSTRAR LOS DATOS TRATADOS;

    ALGORITMO PARA PEDIR DATOS AL USUARIO{
        mostrar mensaje de qué cantidad quiere introducir;
        recibir y almacenar en memoria el mensaje del usuario;
    }

    ALGORITMO PARA TRATAR LOS DATOS{
        dolares = euros*UNIDAD_CONVERSION;
    }

    ALGORITMO PARA MOSTRAR LOS DATOS{
        mostrar por pantalla los datos tratados;
    }
}
*/
package conversoreurosdolares;

public class ConversorEurosDolares {

    public static void main(String[] args)
    {
        float dolares, euros;
        final float UNIDAD_CONVERSION = 1.16f;
        
        System.out.print("Introduce una cantidad de dolares para convertir: ");
        euros = LT.readFloat();
        
        dolares = euros*UNIDAD_CONVERSION;
        
        System.out.println(euros + " euros son: " + dolares + " dólares.");
    }
}
