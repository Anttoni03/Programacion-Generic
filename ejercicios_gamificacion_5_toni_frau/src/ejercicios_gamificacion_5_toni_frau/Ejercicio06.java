/*
 * FUNCIONALIDAD: crear programa para inicializar un array con resultados del fútbol, uno
 * con quinielas de apuestas y un tercero para comparar ambas, visualizando si es
 * o no acertado
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 02.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_5_toni_frau;

public class Ejercicio06 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio06().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIONES
        int[] resultados = {0,1,2,2,1,0,0,0,2,1,0,1,1,2,2};
        int[] apuestas = new int[resultados.length];
        boolean[] comparaciones = new boolean[resultados.length];
        
        //ACCIONES
        inicializar(apuestas);
        
        comparar(resultados, apuestas, comparaciones);
        
        //VISUALIZACIÓN
        mostrarResultados(comparaciones);
    }
    
    //método procedimiento inicializar que inicializa los valores de un array por consola
    private void inicializar(int[] numeros)
    {
        //ACCIONES
        for (int i = 0;i<numeros.length;i++)
        {
            System.out.print("Apuesta para " + (i+1) + ", 0 ganado, 1 perdido, 2 empate: ");
            numeros[i] = LT.readInt();
        }
    }
    
    //método proceso comparar para comparar entre resultados y apuestas a comparaciones
    private void comparar(int[] resultados, int[] apuestas, boolean[] comparaciones)
    {
        //ACCIONES
        for (int i = 0; i<resultados.length;i++)
        {
            comparaciones[i] = resultados[i] == apuestas[i];
        }
    }
    
    //método proceso mostrarResultados para visualizar la comparación de resultados con apuestas
    private void mostrarResultados(boolean[] comparaciones)
    {
        //ACCIONES
        for (int i = 0; i<comparaciones.length;i++)
            System.out.println("La apuesta " + (i+1) + " es " + (comparaciones[i]?"acertada":"fallida"));
    }
}