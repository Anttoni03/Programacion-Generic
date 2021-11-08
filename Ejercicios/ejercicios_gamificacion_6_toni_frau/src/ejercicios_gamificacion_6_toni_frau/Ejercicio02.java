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
    int mayor = 0, mayorPos = 0, menor = 0, menorPos = 0;
    
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
        mayor = numeros[0];
        mayorPos = 0;
        menor = numeros[0];
        menorPos = 0;
        for (int i = 0;i<numeros.length;i++)
        {
            if (numeros[i] > mayor)
            {
                mayor = numeros[i];
                mayorPos = i;
            }
            if (numeros[i] < menor)
            {
                menor = numeros[i];
                menorPos = i;
            }
        }
        
        System.out.println("El mayor es " + mayor + ", introducido el " + mayorPos);
        System.out.println("El menor es " + menor + ", introducido el " + menorPos);
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