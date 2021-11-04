/*
 * FUNCIONALIDAD: crear programa para inicializar 1 array de 100 números enteros
 * y asignarle esos primeros primos y visualizarlos
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 02.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_5_toni_frau;

public class Ejercicio09 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio09().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIONES
        int[] primos = new int[100];
        
        //ACCIONES
        inicializar(primos);
        
        //VISUALIZACIÓN
        visualizacion(primos);
        
    }
    
    //método función invertirCadena que devuelve una cadena de los indicados primeros primos
    private void inicializar(int[] numeros)
    {
        //DECLARACIONES
        boolean llenoPrimos = false;
        int indice = 0;
        
        //ACCIONES
        for (int i = 1; !llenoPrimos ;i++)
        {            
            if (esPrimo(i))
            {
                numeros[indice] = i;
                indice++;
                if (indice == (numeros.length))
                    llenoPrimos = true;
            }
        }
    }
    
    //método función esPrimo que devuelve true si el número es primo
    private boolean esPrimo(int numero)
    {
        //DECLARACIONES
        boolean noEsPrimo = false;
    
        //ACCIONES
        for (int i = numero / 2; i > 1 && !noEsPrimo; i--)
            noEsPrimo = numero % i == 0;
    
        //DEVOLVER RESULTADO
        return !noEsPrimo;
    }
    
    //método proceso visualizacion para visualizar la cadena dato dada
    private void visualizacion(int[] dato)
    {
        for (int i = 0; i < dato.length; i++)
            System.out.println("La cadena invertiad en " + (i + 1) + " es " + dato[i]);
    }
}