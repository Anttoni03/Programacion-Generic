/*
FUNCIONALIDAD: dado un número entero, leído desde el teclado, visualiza los
n primeros múltiplos del número introducido. El número de múltiplos a visualizar
será introducido también desde el teclado.
OBJETIVO: introducción a la programación - esquema de acción repetitivo a través de
la sentencia while.
FECHA DE CREACIÓN: 08.10.2021
AUTOR: Juan Montes de Oca
 */
/*
ALGORITMO VISUALIZACIÓN MÚLTIPLOS {
    LECTURA DATOS;
    TRATAMIENTO;
}
ALGORITMO LECTURA DATOS {
    LECTURA NÚMERO DE MÚLTIPLOS A VISUALIZAR;
    LECTURA NÚMERO DEL CUAL SE QUIERE VISUALIZAR LOS MÚLTIPLOS;
}

ALGORITMO LECTURA NÚMERO DE MÚLTIPLOS A VISUALIZAR {
    MENSAJE USUARIO PARA INTRODUCIR EL NÚMERO DE MÚLTIPLOS A VISUALIZAR;
    LECTURA VALOR NÚMERO DE MÚLTIPLOS;
}

ALGORITMO LECTURA NÚMERO DEL CUAL SE QUIERE VISUALIZAR LOS MÚLTIPLOS {
    MENSAJE USUARIO PARA INTRODUCIR NÚMERO;
    LECTURA VALOR NÚMERO;
}

ALGORITMO TRATAMIENTO {
    PARA (;NO SE HAYAN VISUALIZADO TODOS LOS MÚLTIPLOS A VISUALIZAR;INCREMENTAR EL NÚMERO DE MÚLTIPLOS VISUALIZADOS) {
        OBTENER EL SIGUIENTE MÚLTIPLO DEL NÚMERO INTRODUCIDO;
        VISUALIZAR MÚLTIPLO OBTENIDO;   
    }
}
*/
package clase_teorica__15_10_2021;


public class visualizacionMultiplos_for {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración variable de tipo int para alamcenar el número de múltiplos
        //a visualizar
        int numeroMultiplos;
        //declaración variable detipo int para almacenar el número del cual se
        //van a obtener los múltiplos
        int numero;
        //declaración variable de tipo int para almacenar los múltiplos, de uno
        //en uno
        int multiplo;
        //declaración variable de tipo int para contar el número de múltiplos
        //que van siendo visualizados
        int contadorMultiplos=0;
        
        //ACCIONES
        //LECTURA DATOS
        //LECTURA NÚMERO DE MÚLTIPLOS A VISUALIZAR
        //MENSAJE USUARIO PARA INTRODUCIR EL NÚMERO DE MÚLTIPLOS A VISUALIZAR
        System.out.print("INTRODUCIR NÚMERO DE MÚLTIPLOS A VISUALIZAR: ");
        //LECTURA VALOR NÚMERO DE MÚLTIPLOS
        numeroMultiplos=LT.readInt();
        //LECTURA NÚMERO DEL CUAL SE QUIERE VISUALIZAR LOS MÚLTIPLOS
        //MENSAJE USUARIO PARA INTRODUCIR NÚMERO
        System.out.print("INTRODUCIR NÚMERO: ");
        //LECTURA VALOR NÚMERO
        numero=LT.readInt();
        
        //TRATAMIENTO
        for (;contadorMultiplos<numeroMultiplos;contadorMultiplos++) {
            //OBTENER EL SIGUIENTE MÚLTIPLO DEL NÚMERO INTRODUCIDO
            multiplo=(contadorMultiplos+1)*numero;
            //VISUALIZAR MÚLTIPLO OBTENIDO
            System.out.println(multiplo);
        }             
    }  
}
