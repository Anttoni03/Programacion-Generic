/*
FUNCIONALIDAD: lleva a cabo la resolución de una ecuación de primer grado del
tipo ax+b=0, donde el coeficiente de las x (a) y el término independiente (b)
son introducidos por el usuarfio, a través del teclado. Posteriormente a la 
resolución visualiza el resultado por pantalla. 
OBJETIVO: prática para aprender java
FECHA DE REALIZACIÓN: 05.10.2021
AUTOR: Antoni Frau Gordiola
*/
/*
ALGORITMO ECUACION PRIMER GRADO {
    LECTURA DATOS ECUACIÓN;
    TRATAMIENTO;
    VISUALIZAR RESULTADO;
}

ALGORIMTO LECTURA DATOS ECUACIÓN {
    LECTURA COEFICIENTE ECUACIÓN;
    LECTURA TÉRMINO INDEPENDIENTE;
}

ALGORIMTO LECTURA COEFICIENTE ECUACIÓN {
    MENSAJE USUARIO PARA INTRODUCIR POR TECLADO EL COEFICIENTE DE LA ECUACIÓN;
    LECTURA VALOR COEFICIENTE POR TECLADO;
}
ALGORITMO LECTURA TÉRMINO INDEPENDIENTE {
    MENSAJE USUARIO PARA INTRODUCIR EL TÉRMINO INDEPENDIENTE DE LA ECUACIÓN;
    LECTURA VALOR TÉRMINO INDEPENDIENTE POR TECLADO;
}

ALGORITMO TRATAMIENTO {
    x=-TERMINO INDEPENDIENTE/COEFICIENTE;
}
*/
package conversoreurosdolares;

public class esquemaSecuencialEcuacionPrimerGrado {
    public static void main(String[] args) throws Exception
    {
        float coeficiente, incognita, terminoIndependiente;
        
        System.out.print("Indique el término que multiplica la incógnita: ");
        coeficiente = LT.readFloat();
        
        System.out.print("Indique el término independiente: ");
        terminoIndependiente = LT.readFloat();
        
        incognita = - (terminoIndependiente / coeficiente);
        
        System.out.println("El resultado es: " + incognita);
    }
}
