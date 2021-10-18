/*
FUNCIONALIDAD: dada un importe de dolares, introducido por teclado a petición
del programa, es visualizado el importe en euros correspondiente.
OBJETIVO: introducción programación
FECHA DE CREACIÓN: 05.10.2021
AUTOR: juan
 */

/*
ALGORITMO CONVERSIÓN DOLARES A EUROS {
    LECTURA IMPORTE DOLARES;
    TRATAMIENTO;
    VISUALIZAR RESULTADO;
}

ALGORITMO LECTURA IMPORTE DOLARES {
    MENSAJE USUARIO PARA SOLICITAR IMPORTE DOLARES A CONVERTIR;
    LECTURA VALOR IMPORTE DOLARES;
}

ALGORITMO TRATAMIENTO {
    EUROS=DOLARES*UNIDAD_CONVERSIÓN;
}

}
*/



package clasepractica_05_10_2021;


public class ProgramaDolaresEuros {
    //método main
    public static void main(String [] argfumentos) throws Exception {
        //DECLARACIONES
        //declaración variable de tipo double para almacenar el importe en
        //dolares
        double dolares;
        //declaración variable de tipo double para almacenar el importe en
        //euros
        double euros;
        //declaración constante de tipo double para almacenar el valor de
        //la unidad de conversión de dolares a euros+¡
        final double UNIDAD_CONVERSION=0.86;
        
        //ACCIONES
        //LECTURA IMPORTE DOLARES
        //MENSAJE USUARIO PARA SOLICITAR IMPORTE DOLARES A CONVERTIR
        System.out.print("INTRODUCE EL IMPORTE DE DOLARES A CONVERTIR: ");
        //LECTURA VALOR IMPORTE DOLARES
        dolares=LT.readDouble();
        
        //TRATAMIENTO
        euros=dolares*UNIDAD_CONVERSION;
        
        //VISUALIZAR RESULTADO
        System.out.println("EL IMPORTE EN EUROS ES: "+euros+" euros."); 
    }
}
