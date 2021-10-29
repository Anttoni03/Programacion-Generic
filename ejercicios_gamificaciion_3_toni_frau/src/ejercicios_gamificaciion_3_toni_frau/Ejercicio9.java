/*
 * FUNCIONALIDAD: crear subprograma que reciba un carácter y devuelva verdadero
 * si es una vocal y falso si no lo es
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 26.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
/*
ALGORITMO SUBPROGRAMA EJERCICIO09
{
    HACER DECLARACIONES;
    TRATAR DATOS AL COMPARAR;
    DEVOLVER RESULTADO;

    ALGORITMO DECLARACIONES
    {
        resultado booleano en falso;
        constantes char con los valores de vocales('a','e','i','o',u');
    }
    ALGORITMO TRATAR DATOS
    {
        comparar si el caracter dado es igual al uno buscado asignando al resultado;
    }
    ALGORITMO DEVOLVER RESULTADO
    {
        devolver resultado de función;
    }
}
*/
package ejercicios_gamificaciion_3_toni_frau;

public class Ejercicio9 {
    public static void main(String[] args) throws Exception{
        //DECLARACIONES
        char caracter = LT.readChar();
        //ACCIONES
        boolean esVocal = new Ejercicio9().esVocal(caracter);
        System.out.println(esVocal?"Es vocal":"No es vocal");
    }
  
    //método función que evalúa un carácter y devuelve true si es una vocal y false si no lo es
    private boolean esVocal(char caracter)
    {
        //DECLARACIONES
        boolean esVocal = false;
        final char VOCAl1 = 'a', VOCAL2 = 'e', VOCAL3 = 'i', VOCAL4 = 'o', VOCAL5 = 'u';
    
        //ACCIONES
        if (caracter == VOCAl1 || caracter == VOCAL2 || caracter == VOCAL3 || caracter == VOCAL4 || caracter == VOCAL5)
            esVocal = true;
    
        //DEVOLVER RESULTADO
        return esVocal;
    }
}