/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticarExamen;

public class Ejercicio1
{
    private final int MAXIMOS_CARACTERES = 100;
    private final char FINAL_SECUENCIA = '.';
    private char caracter;

    public static void main(String[] argumentos) throws Exception
    {
        new Ejercicio1().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        System.out.print("Inserta un texto acabado en punto: ");
        
        for (int indice = 0; indice < MAXIMOS_CARACTERES || caracter != FINAL_SECUENCIA; indice++)
        {
            caracter = LT.readChar();
            if (esLetraMinuscula())
            {
                System.out.print(convertirAMayuscula());
            }
            else
            {
                System.out.print(caracter);
            }
        }
    }

    private char convertirAMayuscula()
    {
        return (char)((int)caracter - ((int)'a' - (int)'A'));
    }

    private boolean esLetraMinuscula()
    {
        return (int)'a' <= (int)caracter && (int)caracter <= (int)'z';
    }
}