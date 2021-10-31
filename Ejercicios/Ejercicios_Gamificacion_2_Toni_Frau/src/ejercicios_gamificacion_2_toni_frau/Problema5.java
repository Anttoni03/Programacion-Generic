/*
 * FUNCIONALIDAD: programa para mostrar la posición e indicar cuál cada vocal de un mensaje introducido
 * por el usuario con final '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 16.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 05{
    VARIABLES PARA POSICIÓN Y CARÁCTER;
    DETECTAR E IMPRIMIR VOCAL;
    
    ALGORITMO PARA VARIABLES{
        variable entera de posición;
        variable char para caracter del mensaje;
        mostrar mensaje para insertar mensaje;
    }
    ALGORITMO DE DETECTAR VOCAL{
        mientras un caracter != '.'            
            comprobar si caracter es vocal;
                si es se imprime la vocal con posición;
            guardar la entrada de usuario en caracter;
            aumentar en 1 la posición;
    }
}
*/
package ejercicios_gamificacion_2_toni_frau;

public class Problema5 {
    public static void main(String[] args) throws Exception
    {
        int posicion = 1;
        char caracter;
        
        System.out.print("Introduce un mensaje: ");
        caracter = LT.readChar();
        while (caracter != '.')
        {
            if ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||(caracter=='u'))
                System.out.println("Carácter '" + caracter + "' posición " + posicion);
            caracter = LT.readChar();
            posicion++;
        }
    }
}
