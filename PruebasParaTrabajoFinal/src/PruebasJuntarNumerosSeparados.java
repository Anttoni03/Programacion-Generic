/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonif
 */
public class PruebasJuntarNumerosSeparados {
    public static void main(String[] args) throws Exception
    {
        new PruebasJuntarNumerosSeparados().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        System.out.print("Cantidad de combinaciones de numeros a introducir: ");
        int cantidad = LT.readInt();
        int numeroIntro;
        int[] digitos = new int[9];
        int size;
        
        for (int i = 0; i < cantidad; i++)
        {
            size = 0;
            do {
                System.out.print("Introduce un digito(-1 para acabar): ");
                numeroIntro = LT.readInt();
                if (numeroIntro != -1)
                {
                    digitos[size] = numeroIntro;
                    size++;
                }
            } while(numeroIntro != -1);
            
            System.out.print("El numero formado por esos digitos es: ");
            System.out.println(juntarDigitos(digitos, size));
        }
    }
    
    private int juntarDigitos(int[] digitos, int size)
    {
        int resultado = 0;
        for (int i = size-1,iteraciones = 1; i >= 0; i--,iteraciones *= 10)
        {
            resultado += digitos[i] * iteraciones;
        }
        
        return resultado;
    }
}
