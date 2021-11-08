/*
 * FUNCIONALIDAD: crear programa para inicializar 2 arrays de 10 enteros y mostrar
 * la resta componente a componente
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio04
{
    //DECLARACIONES DE CLASE
    int[] numeros1 = {2,6,3,7,3,0,3,7,4,4};
    int[] numeros2 = {7,4,8,4,8,3,7,3,89,12};
    int[] resta = new int[10];
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio04().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        //mensaje para introducir cadena
        restar();
        
        //VISUALIZAR EL RESULTADO
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO recibirNumeros
    private void restar()
    {
        for (int i = 0; i < numeros1.length; i++)
            resta[i] = numeros1[i] - numeros2[i];
    }
    
    //MÉTODO PROCEDIMIENTO visualizar
    private void visualizar()
    {
        for (int i = 0; i < numeros1.length; i++)
            System.out.println(numeros1[i] + " - " + numeros2[i]+ " = " + resta[i]);
    }
}