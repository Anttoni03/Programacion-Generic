/*
FUNCIONALIDAD: visualiza la suma de una secuencia de números enteros leidos uno
a uno desde el teclado. La finalización de la introducción de números para sumar
se llevará a término cuando el usuario introduzca por teclado el número 0.
OBJETIVO: ilustración del esquema de acción repetitivo utilizando la sentencia
for.
FECHA DE CREACIÓN: 15.10.2021
AUTOR: Juan Montes de Oca
 */
/*
ALGORITMO SUMA DE NÚMEROS {
    LECTURA NUMERO;
    TRATAMIENTO;
    VISUALIZACIÓN RESULTADO;
}
ALGORITMO TRATAMIENTO {
    PARA (;EL NÚMERO LEÍDO NO SEA 0;) {
        ACUMULAR NUMERO EN LA SUMA;
        LECTURA NUMERO;
    }
}
ALGORITMO LECTURA NUMERO {
    MENSAJE USUARIO;
    LECTURA VALOR NUMERO DESDE EL TECLADO;
}

*/
package clase_teorica__15_10_2021;

public class suma_numeros_v1_for {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración variable de tipo int para almacenar, de uno en uno, los
        //números enteros que van a ser introducidos por teclado para sumarlos
        int numero;
        //declaración variable de tipo int para almacenar la suma de los números
        //leídos desde el teclado
        int suma=0;
        
        //ACCIONES
        //LECTURA NUMERO
        //MENSAJE USUARIO
        System.out.print("INTRODUCIR NÚMERO A SUMAR (fin-->0): ");
        //LECTURA VALOR NUMERO DESDE EL TECLADO
        numero=LT.readInt();
        
        //TRATAMIENTO 
        for (;numero!=0;) {
            //ACUMULAR NUMERO EN LA SUMA
            suma=suma+numero;
            //LECTURA NUMERO
            //MENSAJE USUARIO
            System.out.print("INTRODUCIR NÚMERO A SUMAR (fin-->0): ");
            //LECTURA VALOR NUMERO DESDE EL TECLADO
            numero=LT.readInt();
        }
        
        //VISUALIZACIÓN RESULTADO
        System.out.println("LA SUMA DE LOS NÚMEROS INTRODUCIDOS ES "+suma);
    }
    
}
