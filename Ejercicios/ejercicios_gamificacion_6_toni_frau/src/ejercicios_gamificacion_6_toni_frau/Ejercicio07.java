/*
 * FUNCIONALIDAD: crear programa para inicializar 1 array de 10 componentes enteras
 * con valores estrictamente distintos y mostrarlos posteriormente
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio07
{
    //DECLARACIONES DE CLASE
    int[] numeros = new int[10];
    
    boolean hayIgual = false;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio07().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        recibirNumeros();
        
        //VISUALIZAR
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO recibirNumeros
    private void recibirNumeros()
    {
        for (int i = 0; i < numeros.length;)
        {
            System.out.print("Introduce el número " + (i+1) + ": ");
            numeros[i] = LT.readInt();
            hayIgual = false;
            
            for (int j = 0; j < i && !hayIgual; j++)
            {
                if (numeros[i] == numeros[j])
                    hayIgual =  true;
            }
            
            if (!hayIgual)
                i++;
            else
                System.out.println("Hay un número repetido");
        }
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar para visualizar resultados
    private void visualizar()
    {
        for (int i = 0; i<numeros.length;i++)
            System.out.println("El número es " + (i+1) + " es " + numeros[i]);
    }
}
