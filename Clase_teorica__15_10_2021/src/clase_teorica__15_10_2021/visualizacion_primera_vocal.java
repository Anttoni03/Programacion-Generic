/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.' visualiza el primer caracter vocal contenido en la secuencia.
En caso que en la secuencia no haya ningún caracter vocal visualizará el mensaje
"EN LA SECUENCIA NO HAY VOCALES".
OBJETIVO: INTRODUCCIÓN AL TRATAMIENTO SECUENCIAL. ESQUEMA DE BÚSQUEDA.
FECHA DE CREACIÓN: 15.10.2021
AUTOR: Juan Montes de Oca
 */

/*
ALGORITMO VISUALIZACION PRIMERA VOCAL {
    INICIALIZACIÓN;
    LECTURA PRIMER CARACTER DE LA SECUENCIA;
    TRATAMIENTO DE BUSQUEDA;
    VISUALIZACIÓN RESULTADO;
}

ALGORITMO TRATAMIENTO DE BUSQUEDA {
    MIENTRAS ((CARACTER LEÍDO NO SEA EL ÚLTIMO CARACTER DE LA SECUENCIA) Y
              (CARACTER LEÍDO NO SEA VOCAL)) {
        LECTURA SIGUIENTE CARACTER DE LA SECUENCIA;
    }
}

ALGORITMO VISUALIZACIÓN RESULTADO {
    SI (CARACTER LEÍDO ES VOCAL) {
        VISUALIZAR EL CARACTER LEÍDO COMO PRIMERA VOCAL DE LA SECUENCIA;
    }
    SINO {
        VISUALIZAR MENSAJE "EN LA SECUENCIA NO HAY VOCALES";
    }
}
*/
package clase_teorica__15_10_2021;


public class visualizacion_primera_vocal {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración variable de tipo char para almacenar, de uno en uno, los
        //caracteres de la secuencia introducida por teclado
        char caracter;
        
        //ACCIONES
        //INICIALIZACIÓN
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //LECTURA PRIMER CARACTER DE LA SECUENCIA
        caracter=LT.readChar();
        //TRATAMIENTO DE BUSQUEDA
        while ((caracter!='.') && 
                !((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||(caracter=='u'))) {
            //LECTURA SIGUIENTE CARACTER DE LA SECUENCIA
            caracter=LT.readChar();
        }
        
        //VISUALIZAR RESULTADO
        if ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||(caracter=='u')) {
            System.out.println("EL PRIMER CARACTER VOCAL DE LA SECUENCIA ES "+caracter);
        }
        else {
            System.out.println("EN LA SECUENCIA NO HAY VOCALES");
        }
        
    }
    
}
