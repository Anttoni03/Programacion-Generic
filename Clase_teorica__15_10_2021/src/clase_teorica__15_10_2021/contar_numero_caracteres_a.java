/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.' visualiza el número de carcateres 'a' contenidos en dicha
secuencia de caracteres.
ejemplo:
        secuencia de entrada: "hola como estamos."
        salida resultado: EL NÚMERO DE CARACTERES 'a' ES 2.
OBJETIVO : INTRODUCCIÓN TRATAMIENTO SECUENCIAL. ESQUEMA DE RECORRIDO
FECHA DE CREACIÓN: 15.10.2021
AUTOR: Juan Montes de Oca
 */
/*
ALGORITMO NUMERO DE CARACTERES a {
    INICIALIZACIÓN;
    LECTURA PRIMER CARACTER DE LA SECUENCIA INTRODUCIDA POR TECLADO ;
    TRATAMIENTO DE RECORRIDO;

    VISUALIZAR RESULTADO;
}

ALGORITMO TRATAMIENTO DE RECORRIDO {
    MIENTRAS (CARACTER LEÍDO NO SEA EL ÚLTIMO CARACTER DE LA SECUENCIA) {
	TRATAMIENTO CARACTER LEÍDO;
	LECTURA SIGUIENTE CARACTER DE LA SECUENCIA;
    }
}

ALGORITMO TRATAMIENTO CARACTER LEÍDO {
    SI (CARACTER LEÍDO ES IGUAL AL CARACTER 'a') {
        INCREMENTAR CONTADOR DE CARACTERES 'a';
    }
}

*/
package clase_teorica__15_10_2021;

public class contar_numero_caracteres_a {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración variable de tipo char para almacenar, de uno en uno, los
        //caracteres leídos de la secuencia introducida por teclado
        char caracter;
        //declaración variable de tipo int para almacenar el número de caracteres
        //'a' contenidos en la secuencia introducida por teclado
        int contador;
        
        //ACCIONES
        //INICIALIZACIÓN
        //inicializar a 0 la variable contador que representa el número de caracteres
        //'a' contenidos en la secuencia
        contador=0;
        //visualización mensaje usuario para introducir secuencia de caracteres
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //LECTURA PRIMER CARACTER DE LA SECUENCIA INTRODUCIDA POR TECLADO
        caracter=LT.readChar();
        //TRATAMIENTO DE RECORRIDO A NIVEL DE CARACTERES
        while (caracter!='.') {
            //TRATAMIENTO CARACTER LEÍDO
            if (caracter=='a') {
                //INCREMENTAR CONTADOR DE CARACTERES 'a'
                contador++;
            }     
            //LECTURA SIGUIENTE CARACTER DE LA SECUENCIA
            caracter=LT.readChar();  
        }       
        //VISUALIZAR RESULTADO
        System.out.println("EL NÚMERO DE CARACTERES 'a' ES "+contador);
    }
    
}
