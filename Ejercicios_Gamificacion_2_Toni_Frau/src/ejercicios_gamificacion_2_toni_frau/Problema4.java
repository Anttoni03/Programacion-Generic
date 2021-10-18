/*
 * FUNCIONALIDAD: programa para mostrar la posición e indicar cuál es la primera vocal de un mensaje introducido
 * por el usuario con final '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 16.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO DEL PROBLEMA 04{
    VARIABLES PARA POSICIÓN Y VOCAL;
    DETECTAR PRIMERA VOCAL;
    IMPRIMIR POSICIÓN Y VOCAL;
    
    ALGORITMO PARA VARIABLES{
        variable entera de posición;
        variable char para caracter del mensaje;
        variable char para guardar vocal;
        mostrar mensaje para insertar mensaje;
    }
    ALGORITMO DE DETECTAR VOCAL{
        mientras un caracter != '.'            
            comprobar si no hay primera vocal;
                si no hay aumentar la posición;
                comprobar si es vocal;
                    si es se guarda en vocal;
            guardar la entrada de usuario en caracter;
    }
    ALGORITMO PARA MOSTRAR UN MENSAJE DE SUMA{
        comprobar si no hay vocales;
            si no hay mostrar mensaje que no hay;
            si hay mostrar posición y vocal;
    }
}
*/
package ejercicios_gamificacion_2_toni_frau;

public class Problema4 {
    public static void main(String[] args) throws Exception
    {
        int posicionVocal = 0;
        char vocal = '.', caracter;
        
        System.out.print("Introduce un mensaje: ");
        caracter = LT.readChar();
        while (caracter != '.')
        {            
            if (vocal == '.')
            {
                posicionVocal++;
                if ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||(caracter=='u'))
                    vocal = caracter;
            }
            caracter = LT.readChar();
        }
        
        if (vocal != '.')
            System.out.println("El primer carácter '" + vocal + "' ocupa la posición " + posicionVocal);
        else
            System.out.println("EN LA SECUENCIA NO HAY VOCALES");
    }
}
