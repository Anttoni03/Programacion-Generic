/*
 * FUNCIONALIDAD: crear programa para recibir 10 numeros enteros. Devolver el mayor
 * y el menor acompañados del orden de introducción y la media de los números
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio02
{
    //DECLARACIONES DE CLASE
    int[] numeros = new int[10];
    int mayorPos = 0, menorPos = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio02().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        //mensaje para introducir cadena
        recbirNumeros();
        
        maximoYMinimo();
        
        //VISUALIZAR EL RESULTADO
        mediaAritmetica();
    }
    
    //MÉTODO PROCEDIMIENTO recibirNumeros
    private void recbirNumeros()
    {
        for (int i = 0; i < numeros.length; i++)
        {
            System.out.print("Introduce el número en " + (i+1) + ": ");
            numeros[i] = LT.readInt();
        }
    }
    
    //MÉTODO PROCEDIMIENTO maximoYMinimo
    private void maximoYMinimo()
    {
        for (int i = 0;i<numeros.length;i++)
        {
            if (numeros[i] > numeros[mayorPos])
                mayorPos = i;
            if (numeros[i] < numeros[menorPos])
                menorPos = i;
        }
        
        System.out.println("El mayor es " + numeros[mayorPos] + ", introducido el " + (mayorPos+1));
        System.out.println("El menor es " + numeros[menorPos] + ", introducido el " + (menorPos+1));
    }
    
    //método procedimiento mediaAritmética
    private void mediaAritmetica()
    {
        int suma = 0;
        for (int i = 0;i<numeros.length;i++)
            suma += numeros[i];
        
        System.out.println("La media es " + (float)suma/(float)numeros.length);
    }
}