/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas_a_realizar_v;

import java.io.FileReader;
import java.io.FileWriter;

public class Problema1 {
    public static void main(String[] argumentos) throws Exception
    {
        new Problema1().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception {
        FileReader ficheroIn = new FileReader("Problema1.txt");
        FileWriter ficheroOutVocales = new FileWriter("Problema1Vocales.txt");
        FileWriter ficheroOutConsonantes = new FileWriter("Problema1Consonantes.txt");
        String mensajeVocales = "";
        String mensajeConsonantes = "";
        int codigo;
        final int FINAL_FICHERO = -1;
        final char ESPACIO = ' ';
        
        codigo = ficheroIn.read();
        
        while (codigo != FINAL_FICHERO) {            
            if ((char)codigo != ESPACIO)
            {
                String textito = "";
                int[] numero = conversor(codigo);
                for (int i = 0; i < numero.length; i++) {
                    textito += numero[i];
                }
                if (esVocal((char)codigo))
                    mensajeVocales += ("Tiene " + textito + " que es " + (char)codigo + "\n");
                else
                    mensajeConsonantes += ("Tiene " + textito + " que es " + (char)codigo + "\n");
                
            }
            codigo = ficheroIn.read();
        }
        
        char[] textoEnCharsVocales = mensajeVocales.toCharArray();
        for (int i = 0; i < textoEnCharsVocales.length; i++) {
            ficheroOutVocales.write(textoEnCharsVocales[i]);
        }
        
        char[] textoEnCharsConsonantes = mensajeConsonantes.toCharArray();
        for (int i = 0; i < textoEnCharsConsonantes.length; i++) {
            ficheroOutConsonantes.write(textoEnCharsConsonantes[i]);
        }
        
        ficheroOutVocales.close();
        ficheroOutConsonantes.close();
    }
    
    private boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    private int[] conversor(int numeroInicial) {
        //DECLARACIÓN DE VARIABLES
        int[] numerosSeparados = new int[10];
        
        //TRATAMIENTO DE DATOS
        for (int i = numerosSeparados.length-1; i >= 0; i--)
        {
            int numero = (int) Math.floor(Math.abs(numeroInicial) / Math.pow(10, i));
            numerosSeparados[numerosSeparados.length - 1 - i] = numero;
            numeroInicial -= numero * Math.pow(10, i);
        }
        
        //QUITAR PRIMEROS CEROS
        int primerosCeros = 0;
        boolean primerNoCero = false;
        for (int i = 0; i < numerosSeparados.length && !primerNoCero; i++) {
            if (numerosSeparados[i] == 0) primerosCeros++;
            else primerNoCero = true;
        }
        
        int[] resultado = new int[numerosSeparados.length - primerosCeros];
        for (int i = 0; i < resultado.length; i++) {
            resultado[resultado.length - 1 - i] = numerosSeparados[numerosSeparados.length - 1 - i];
        }
        
        return resultado;
    }
}
