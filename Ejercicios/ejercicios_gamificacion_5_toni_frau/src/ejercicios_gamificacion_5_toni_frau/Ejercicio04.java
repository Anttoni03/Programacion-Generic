/*
 * FUNCIONALIDAD: crear programa para inicializar 3 arrays de 10 componentes,
 * iniciando 1 en la declaración, otra por consola y la tercera siendo la suma
 * de las dos primeras posicionalmente. Luego mostrar el resultado
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 02.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_5_toni_frau;

public class Ejercicio04 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio04().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIONES
        int[] numeros1 = {1,2,3,4,5,6,7,8,9,10};
        int[] numeros2 = new int[10];
        int[] numeros3 = new int[10];
        
        //INICIALIZACIÓN
        inicializacion(numeros2);
        
        //ACCIONES
        suma(numeros1, numeros2, numeros3);
        
        visualizacion(numeros3);
    }
    
    //método proceso inicialzación para dar valores por consola a un array
    private void inicializacion(int[] dato)
    {
        //ACCIONES
        for (int i = 0; i < dato.length; i++)
        {
            System.out.print("Introduce un valor para la posición " + (i+1));
            dato[i] = LT.readInt();
        }
    }
    
    //método proceso suma que suma todas las componentes de dato1 y dato2 a dato3
    private void suma(int[] datos1,int[] datos2,int[] datos3)
    {
        //ACCIONES
        for (int i = 0; i < datos1.length;i++)
            datos3[i] = datos1[i] + datos2[i];
    }
    
    //método proceso visualización para visualizar los valores de dato
    private void visualizacion(int[] dato)
    {
        for (int i = 0; i<dato.length;i++)
            System.out.println("El tercer array en " + (i + 1) + " es " + dato[i]);
    }
}