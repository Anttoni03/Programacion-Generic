/*
FUNCIONALIDAD: programa que convierte una cantidad de euros a dólares o dólares a euros
OBJETIVO: prática para aprender java
FECHA DE REALIZACIÓN: 05.10.2021
AUTOR: Antoni Frau Gordiola
*/
/*
ALGORITMO DE CONVERSIÓN AL ELEGIR CONVERSIÓN{
    ESPERAR A QUE EL USUARIO INDIQUE EL TIPO DE CONVERSIÓN;
    EN FUNCIÓN DEL TIPO{
        RECOJER LA CANTIDAD A CONVERTIR DEL USUARIO;
        TRATAR LOS DATOS;
        MOSTRAR LOS DATOS TRATADOS;
    }

    ALGORITMO PARA ESPERAR A LA ENTRADA DEL TIPO DE CONVERSIÓN{
        un bucle sin fin preestablecido hasta que el tipo de conversión sea válido;
        indicar mensaje para el usuario sobre cómo indicar el tipo de conversión;
        almacenar la entrada del usuario según la conversión;
        mostrar por pantalla si es una entrada incorrecta;
    }
    ALGORITMO PARA REALIZAR LOS PASOS SEGÚN LA CONVERSIÓN{
        si es eur->dol
            almacenar la entrada del usuario para los euros;
            tratar los euros mediante el conversor, dolares = euros*CONVERSOR;
            mostrar el resultado del tratamiento de datos, los dólares;
        si es dol->eur
            almacenar la entrada del usuario para los dólares;
            tratar los dólares mediante el conversor, euros = dólares*CONVERSOR;
            mostrar el resultado del tratamiento de datos, los euros;
    }
}


*/
package conversoreurosdolares;

public class ElegirConversorEuroDolar {
    public static void main(String[] args) throws Exception{
        int operacion = -1;
        float dolares, euros;
        final float CONVERSION_DOL_EUR = 0.86f, CONVERSION_EUR_DOL = 1.16f;
        
        while (operacion != 0 && operacion != 1)
        {
            System.out.print("Si quiere convertir dolares a euros, introduce \"0\". En caso contrario introduce \"1\" :");
            operacion = LT.readInt();
            if (operacion != 0 && operacion != 1)
                System.out.println("Introduce un valor válido.");
        }
        
        if (operacion == 0)
        {
            System.out.print("Introduce una cantidad de dólares: ");
            dolares = LT.readFloat();
            euros = dolares*CONVERSION_DOL_EUR;
            System.out.println(dolares + " dólares son :" + euros + " euros.");
        }
        else
        {
            System.out.print("Introduce una cantidad de euros: ");
            euros = LT.readFloat();
            dolares = euros*CONVERSION_EUR_DOL;
            System.out.println(euros + " euros son :" + dolares + " dólares.");
        }
    }
}
