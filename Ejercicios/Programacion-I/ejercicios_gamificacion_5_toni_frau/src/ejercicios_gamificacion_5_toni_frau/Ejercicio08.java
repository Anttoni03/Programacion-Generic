/*
 * FUNCIONALIDAD: crear programa para inicializar 1 array con números enteros
 * dados y visualizar otra cadena con esos valores con posición invertida
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 02.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_5_toni_frau;

public class Ejercicio08 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio08().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIONES
        int[] numeros = {10,20,30,40,50};
        
        int[] invertidos = invertirCadena(numeros);
        
        //VISUALIZACIÓN
        visualizacion(invertidos);
        
    }
    
    //método función invertirCadena que devuelve una cadena invertida a la dada
    private int[] invertirCadena(int[] dato)
    {
        //INICIALIZACIÓN
        int[] cadena = new int[dato.length];
        
        //ACCIONES
        for (int i = 0; i < dato.length; i++)
        {
            cadena[cadena.length - 1 - i] = dato[i];
        }
        
        //DEVOLVER LE VALOR
        return cadena;
    }
    
    //método proceso visualizacion para visualizar la cadena dato dada
    private void visualizacion(int[] dato)
    {
        for (int i = 0; i < dato.length; i++)
            System.out.println("La cadena invertiad en " + (i + 1) + " es " + dato[i]);
    }
}