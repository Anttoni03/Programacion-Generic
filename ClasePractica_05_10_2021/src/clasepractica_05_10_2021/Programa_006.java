package clasepractica_05_10_2021;

/*
FUNCIONALIDAD: lleva a cabo conversión de dolares a euros. El valor de los dólares a convertir
es introducido por teclado siendo visualizado el resultado en euros

FECHA REALIZACIÓN: 01.octubre.2021
ASIGNATURA: Programación I
ESTUDIOS: ING. Informática
AUTOR: Juan MOntes de Oca
 */

/* 
ALGORITMO Conversion Dolares a Euros {
    LECTURA IMPORTE DOLARES A CONVERTIR;
    TRATAMIENTO;
    VISUALIZAR RESULTADO;
}

ALGORITMO LECTURA IMPORTE DOLARES A CONVERTIR {
    MENSAJE USUARIO PARA INTRODUCIR IMPORTE DE DOLARES A CONVERTIR;
    LECTURA IMPORTE;
}

ALGORITMO TRATAMIENTO {
    EUROS=DOLARES*0.86;
}
*/

public class Programa_006 {
    //declaración del método main necesario para que la clase pueda ser ejecutada
    //directamente.
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración de variables y constantes que vamos a utilizar
        //declaración variable real del tipo double para representar el
        //importe de dolares a convertir
        double dolares;
        //declaración variable real del tipo double para representar el
        //importe de euros
        double euros;
        //declaración constante real del tipo double para representar la
        //unidad de conversión de dolares a euros
        final double CONVERSION=0.86;
        
        
        //ACCIONES
        //LECTURA IMPORTE DOLARES A CONVERTIR
        //MENSAJE USUARIO PARA INTRODUCIR IMPORTE DE DOLARES A CONVERTIR
        System.out.print("INTRODUCE IMPORTE DE DOLARES A CONVERTIR: ");
        //LECTURA IMPORTE
        dolares=LT.readDouble();
        
        //TRATAMIENTO
        euros=dolares*CONVERSION;
        
        //VISUALIZAR RESULTADO
        System.out.println("IMPORTE EUROS: "+euros+" euros.");
    } 
}
