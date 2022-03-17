/*
 * FUNCIONALIDAD: crear programa para inicializar 2 arrays de 10 enteros y comprobar
 * si son iguales
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio03
{
    //DECLARACIONES DE CLASE
    int[] numeros1 = {2,6,3,7,3,0,3,7,4,4};
    int[] numeros2 = {2,6,3,5,3,0,3,7,4,4};
    boolean sonIguales = true;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio03().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        //mensaje para introducir cadena
        igualar();
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Los dos arrays" + (!sonIguales?" no ":" ") + "son iguales");
    }
    
    //MÉTODO PROCEDIMIENTO recibirNumeros
    private void igualar()
    {
        for (int i = 0; i < numeros1.length && sonIguales; i++)
        {
            if (numeros1[i] != numeros2[i])
                sonIguales = false;
        }
    }
}