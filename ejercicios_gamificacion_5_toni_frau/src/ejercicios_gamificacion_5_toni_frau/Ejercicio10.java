/*
 * FUNCIONALIDAD: crear programa para inicializar 1 array de 10 elementos inicializados
 * por consola para mostrar la suma, la suma de posiciones pares y la suma de posiciones
 * impares si se decide por consola
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 02.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_5_toni_frau;

public class Ejercicio10 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio10().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIONES
        int[] numeros = new int[10];
        int[] operaciones = new int[3];
        
        
        //ACCIONES
        inicializar(numeros);
        
        decidirOperacion(operaciones);
        
        mostrarOperaciones(numeros, operaciones);
    }
    
    //método procedimiento inicializar que inicializa los valores de un array por consola
    private void inicializar(int[] numeros)
    {
        //ACCIONES
        for (int i = 0;i<numeros.length;i++)
        {
            System.out.print("Introduce un valor para la posición " + (i+1) + ": ");
            numeros[i] = LT.readInt();
        }
    }
    
    //método procedimiento decidirOperacion para asignar las operaciones a hacer
    private void decidirOperacion(int[] operaciones)
    {
        //ACCIONES
        System.out.print("Insertar 1 si se quiere ver la suma de todos, 0 si no: ");
        operaciones[0] = LT.readInt();
        System.out.print("Insertar 1 si se quiere ver la suma de pares, 0 si no: ");
        operaciones[1] = LT.readInt();
        System.out.print("Insertar 1 si se quiere ver la suma de impares, 0 si no: ");
        operaciones[2] = LT.readInt();
    }
    
    //método procedimiento mostrarOperaciones que realiza las operaciones indicada con los números dados
    private void mostrarOperaciones(int[] numeros, int[] operaciones)
    {
        //DECLARACIONES
        int suma = 0;
        
        //ACCIONES
        if (operaciones[0] == 1)
        {
            suma = 0;
            for (int i = 0;i<numeros.length;i++)
                suma += numeros[i];
            
            //VISUALIZACIÓN SI HACE FALTA
            System.out.println("La suma es: " + suma);
        }
        if (operaciones[1] == 1)
        {
            suma = 0;
            for (int i = 0;i<numeros.length;i++)
                if (i % 2 == 0)
                    suma += numeros[i];
            
            //VISUALIZACIÓN SI HACE FALTA
            System.out.println("La suma de posiciones pares es: " + suma);
        }
        if (operaciones[2] == 1)
        {
            suma = 0;
            for (int i = 0;i<numeros.length;i++)
                if (i % 2 == 1)
                    suma += numeros[i];
            
            //VISUALIZACIÓN SI HACE FALTA
            System.out.println("La suma de posiciones impares es: " + suma);
        }
    }
}