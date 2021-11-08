/*
 * FUNCIONALIDAD: crear programa para introducir por consola hasta 25 números y
 * mostrarlos al final clasificándolos por ser pares o impares
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio08
{
    //DECLARACIONES DE CLASE
    int[] pares = new int[25], 
            impares = new int[25];
    
    int numero = 1;
    final int NUMERO_FINALIZADOR = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio08().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        recibirNumeros();
        
        //VISUALIZAR
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO recibirNumeros PARA RECIBIR NÚMEROS Y CLASIFICARLOS
    private void recibirNumeros()
    {
        for (int iPares = 0, iImpares = 0; 
                iPares + iImpares < pares.length && numero != NUMERO_FINALIZADOR;)
        {
            System.out.print("Introduce un número: ");
            numero = LT.readInt();
            
            if (numero % 2 == 0)
            {
                pares[iPares] = numero;
                iPares++;
            }
            else
            {
                impares[iImpares] = numero;
                iImpares++;
            }
        }
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        for (int i = 0; i<pares.length;i++)
            if (pares[i] != 0)
                System.out.println("El número de los pares " + (i+1) + " es " + pares[i]);
        
        for (int i = 0; i<impares.length;i++)
            if (impares[i] != 0)
                System.out.println("El número de los impares " + (i+1) + " es " + impares[i]);
    }
}
