/*
 * FUNCIONALIDAD: programa para mostrar tantas veces un carácter como la posición
 * que ocupa en un mensaje introducido por el usuario con final '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 16.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 07{
    VARIABLES PARA CARÁCTER Y POSICIÓN;
    INVERTIR E IMPRIMIR VOCAL;
    
    ALGORITMO PARA VARIABLES{
        variable entera para posicion;
        variable char para caracter del mensaje;
        mostrar mensaje para insertar mensaje;
    }
    ALGORITMO DE ESCRIBIR CARÁCTER{
        mientras un caracter != '.'
            aumentar valor de posición;
            bucle for de 0 hasta posición incremento 1
                imprimir el caracter;
            guardar la entrada de usuario en caracter;
    }
}
*/
package ejercicios_gamificacion_2_toni_frau;

public class Problema7 {
    public static void main(String[] args) throws Exception
    {
        int posicion = 0;
        char caracter;
        System.out.print("Introduce un mensaje: ");
        caracter = LT.readChar();
        while (caracter != '.')
        {
            posicion++;
            for (int i = 0; i < posicion; i++)
                System.out.print(caracter);
            caracter = LT.readChar();
        }
    }
}