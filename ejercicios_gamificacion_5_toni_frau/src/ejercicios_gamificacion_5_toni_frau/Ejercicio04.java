/*
 * FUNCIONALIDAD: crear programa para inicializar un array en 100 componentes del
 * 1 al 100 y visualizar su suma y media aritmética
 * una secuencia finalizada en '.'
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
        int[] numeros1 = new int[10];
        int[] numeros2 = new int[10];
        int[] numeros3 = new int[10];
        
        //INICIALIZACIÓN
        inicializacion(numeros3);
        
        //ACCIONES
        sumaYMedia(numeros3);
    }
    
    //método proceso inicialzación para dar valores del 1 al 100 a numeros
    private void inicializacion(int[] dato)
    {
        for (int i = 0; i < dato.length; i++)
            dato[i] = i+1;
    }
    
    //método proceso sumaYMedia que suma todas las componentes de dato, hace la
    //media y las visualiza
    private void sumaYMedia(int[] dato)
    {
        //DECLARACIONES
        int suma = 0;
        
        //ACCIONES
        for (int i = 0; i < dato.length;i++)
            suma += dato[i];
        
        //visualizar la suma
        System.out.println("La suma de los componentes es " + suma);
        //visualizar la media aritmética
        System.out.println("La media de los componentes es " + (float)suma/dato.length);
    }
}