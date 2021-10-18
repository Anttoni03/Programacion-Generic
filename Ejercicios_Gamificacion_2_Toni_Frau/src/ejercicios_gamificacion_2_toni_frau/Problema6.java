/*
 * FUNCIONALIDAD: programa para mostrar invertir los caracteres de maýusculas a minúsculas
 * y viceversa de un mensaje introducido por el usuario con final '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 16.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 06{
    VARIABLE PARA CARÁCTER;
    INVERTIR E IMPRIMIR VOCAL;
    
    ALGORITMO PARA VARIABLE{
        variable char para caracter del mensaje;
        mostrar mensaje para insertar mensaje;
    }
    ALGORITMO DE INVERTIR CARÁCTER{
        mientras un caracter != '.'            
            comprobar si caracter es mayúscula;
                si es se imprime el carácter en minúscula;
                si no es imprime el carácter en mayúscyla;
            guardar la entrada de usuario en caracter;
    }
}
*/
package ejercicios_gamificacion_2_toni_frau;

public class Problema6 {
    public static void main(String[] args) throws Exception
    {
        char caracter;
        System.out.print("Introduce un mensaje: ");
        caracter = LT.readChar();
        while (caracter != '.')
        {
            if (caracter == ' ')
                System.out.print(caracter);
            else if ((int)caracter > 96)
                System.out.print((char)((int)caracter - 32));
            else
                System.out.print((char)((int)caracter + 32));
            caracter = LT.readChar();
        }
    }
}