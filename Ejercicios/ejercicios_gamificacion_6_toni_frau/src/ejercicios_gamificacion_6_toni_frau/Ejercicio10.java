/*
 * FUNCIONALIDAD: crear programa para recibir una dimensión para un array, llenar
 * todas las posiciones del array por teclado y visualizar el resultado
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 07.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio10
{
    //DECLARACIONES DE CLASE
    int dimension;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio10().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        System.out.print("Introduce la dimensión del array para dar valores: ");
        dimension = LT.readInt();
        int[] numeros = new int[dimension];
        
        recibirNumeros(numeros);
        
        //VISUALIZAR
        visualizar(numeros);
    }
    
    //MÉTODO PROCEDIMIENTO recibirNumeros
    private void recibirNumeros(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print("Introduce el número " + (i+1) + ": ");
            nums[i] = LT.readInt();
        }
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar(int[] nums)
    {
        for (int i = 0; i<nums.length;i++)
            System.out.println("El número " + (i+1) + " es " + nums[i]);
    }
}
