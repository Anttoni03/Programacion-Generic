/*
FUNCIONALIDAD: visualiza la suma de una secuencia de números enteros leídos desde
el teclado. El número de números a sumar es introducido por el usuario antes de
proceder a la introducción de la secuencia de numeros a sumar.
OBJETIVO: ilustración esquema de acción repetitivo a través de la sentencia while
 */
/*
ALGORITMO SUMA DE NÚMEROS {
    LECTURA NÚMERO DE NÚMEROS A SUMAR;
    TRATAMIENTO;
    VISUALIZACIÓN RESULTADO;
}
ALGORITMO TRATAMIENTO {
    MIENTRAS (NO SE HAYAN LEIDO TODOS LOS NÚMEROS A SUMAR) {
        LECTURA NUMERO;
        INCREMENAR NÚMERO DE NÚMEROS LEÍDOS;
        ACUMULAR NÚMERO LEÍDO EN LA SUMA;
    }
}
*/
package clase_teorica__15_10_2021;

public class suma_numeros_v2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración variable de tipo int para almacenar el número de números
        //a sumar
        int numNumeros;
        //declaración variable de tipo int para almacenar, de uno en uno, los
        //números enteros que van a ser introducidos por teclado para sumarlos
        int numero;
        //declaración variable de tipo int para almacenar la suma de los números
        //leídos desde el teclado
        int suma=0;
        //declaración variable de tipo int para almacenar el contador de números
        //leídos
        int contadorNumeros=0;
        
        //ACCIONES
        //LECTURA NÚMERO DE NÚMEROS A SUMAR
        System.out.print("INTRODUCIR EL NÚMERO DE NÚMEROS A SUMAR: ");
        numNumeros=LT.readInt();
        //TRATAMIENTO
        while (contadorNumeros<numNumeros) {
            //LECTURA NUMERO
            System.out.print("INTRODUCIR NÚMERO A SUMAR: ");
            numero=LT.readInt();
            //INCREMENAR NÚMERO DE NÚMEROS LEÍDOS
            contadorNumeros++;
            //ACUMULAR NÚMERO LEÍDO EN LA SUMA
            suma=suma+numero;
        }
        
        //VISUALIZACIÓN RESULTADO
        System.out.println("LA SUMA DE LOS NÚMEROS LEÍDOS ES "+ suma);
    }
    
}
