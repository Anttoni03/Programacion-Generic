/*
 * FUNCIONALIDAD: crear programa para inicializar 1 array de 10 componentes y
 * visualizar tantos asteriscos como sea el valor de cada componente
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio05
{
    //DECLARACIONES DE CLASE
    int[] numeros = {2,6,3,7,3,0,3,7,4,4};
    final char CARACTER_A_MOSTRAR = '*';
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio05().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        //mensaje para introducir cadena
        mostrar();
    }
    
    //MÉTODO PROCEDIMIENTO recibirNumeros
    private void mostrar()
    {
        for (int i = 0; i < numeros.length; i++)
        {
            for (int j = 0;j<numeros[i];j++)
                System.out.print(CARACTER_A_MOSTRAR);
            
            System.out.println();
        }
    }
}