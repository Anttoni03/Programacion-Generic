/*
 * FUNCIONALIDAD: crear subprograma que reciba un carácter y devuelva verdadero
 * si es igual a 'a' y falso si no lo es
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO08
{
    HACER DECLARACIONES;
    TRATAR DATOS AL COMPARAR;
    DEVOLVER RESULTADO;

    ALGORITMO DECLARACIONES
    {
        resultado booleano;
        constante char con el valor a comprobar('a');
    }
    ALGORITMO TRATAR DATOS
    {
        comparar si el caracter dado es igual al buscado asignando a resultado;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio8 {
    public static void main(String[] args) throws Exception
    {
        //DECLARACIONES
        char caracter = LT.readChar();        
        
        //ACCIONES
        //LLAMADA A LA FUNCIÓN valorAbsoluto
        boolean esIgual = new Ejercicio8().caracterIgual(caracter);
        System.out.println(esIgual?"Es \'a\'":"No es \'a\'");
    }
    
    //método función para evaluar si un carácter es o no a otro previamente indicado('a')
    private boolean caracterIgual(char caracter)
    {
        //DECLARACIONES
        boolean resultado;
        final char CARACTER_A_COMPROBAR = 'a';
        
        //ACCIONES
        //TRATAMIENTO        
        resultado = caracter == CARACTER_A_COMPROBAR;
        
        
        //DEVOLVER RESULTADO
        return resultado;
    }
}
