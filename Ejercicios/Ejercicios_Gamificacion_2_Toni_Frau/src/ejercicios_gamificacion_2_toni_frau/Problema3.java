/*
 * FUNCIONALIDAD: programa para mostrar la cantidad de vocales de un mensaje introducido
 * por el usuario con final '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 16.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 03{
    VARIABLES PARA LOS NÚMEROS Y VOCALES;
    SUMA DE VOCALES;
    IMPRIMIR SUMA FINAL DE VOCALES;
    
    ALGORITMO PARA VARIABLES{
        variable entera de vocales;
        variable char para caracteres del mensaje;
        mostrar mensaje para insertar mensaje;
    }
    ALGORITMO DE CONTAR VOCALES{
        mientras un caracter != '.'
            comprobar si el caracter es vocal
                si es sumar a contador
            asignar entrada a caracter;
    }
    ALGORITMO PARA MOSTRAR UN MENSAJE DE SUMA{
        mostrar mensaje con la suma final de vocales;
    }
}
*/
package ejercicios_gamificacion_2_toni_frau;

public class Problema3 {
    public static void main(String[] args) throws Exception
    {
        int vocales = 0;
        
        System.out.print("Escribe un mensaje: ");
        char caracter = LT.readChar();        
        
        while (caracter != '.')
        {            
            if ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||(caracter=='u'))
                vocales++;
            caracter = LT.readChar();
        }
        
        System.out.println("La cantidad de vocales es: " + vocales);
    }
}
