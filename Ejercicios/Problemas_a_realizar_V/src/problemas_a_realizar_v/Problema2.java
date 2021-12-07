/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas_a_realizar_v;

public class Problema2 {
    public static void main(String[] argumentos) throws Exception
    {
        new Problema2().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception {
        //DECLARACIÓN DE VARIABLES
        int numeroInicial;
        System.out.print("Introducir un número: ");
        numeroInicial = LT.readInt();
        int[] numeroSeparado = new int[10];
        
        //TRATAMIENTO DE DATOS
        for (int i = numeroSeparado.length-1; i >= 0; i--)
        {
            int numero = (int) Math.floor(Math.abs(numeroInicial) / Math.pow(10, i));
            numeroSeparado[numeroSeparado.length - 1 - i] = numero;
            numeroInicial -= numero * Math.pow(10, i);
        }
        
        //QUITAR PRIMEROS CEROS
        int primerosCeros = 0;
        boolean primerNoCero = false;
        for (int i = 0; i < numeroSeparado.length && !primerNoCero; i++) {
            if (numeroSeparado[i] == 0) primerosCeros++;
            else primerNoCero = true;
        }
        int[] resultado = new int[numeroSeparado.length - primerosCeros];
        for (int i = 0; i < resultado.length; i++) {
            resultado[resultado.length - 1 - i] = numeroSeparado[numeroSeparado.length - 1 - i];
        }
        //IMPRIMIR RESUTADO
        System.out.print("Los dígitos son: " + resultado[0]);
        for (int i = 1; i < resultado.length; i++) {
            if (i != resultado.length - 1)
                System.out.print(", " + resultado[i]);
            else
                System.out.print(" y " + resultado[i]);
        }
        System.out.println();
    }
}
