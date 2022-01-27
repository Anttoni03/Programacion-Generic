
import java.io.FileReader;
import java.io.BufferedReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonif
 */
public class PruebasLecturaEscritura {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new PruebasLecturaEscritura().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {        
        int l;
        int i;
        BufferedReader lector = new BufferedReader(new FileReader("ficheroFichas.txt"));
        System.out.println((int)'\n');
        l = lector.read();
        
        for (i = 0; l != -1;l = lector.read())
        {
            if (l == 13) i++;
            
            if (isLetOrNum((char)l))
                System.out.println((char)l);
            else
            {
                System.out.print("\t");
                System.out.println(l);
            }         
        }
        
        System.out.println("Cantidad: " + i);
        lector.close();
    }
    
    private boolean isLetOrNum(char c)
    {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        boolean notFound = true;
        for (int i = 0; i < letters.length && notFound; i++) {
            notFound = notFound && (c != letters[i]);
        }
        for (int i = 0; i < numbers.length && notFound; i++) {
            notFound = notFound && (c != numbers[i]);
        }
        
        return !notFound;
    }
}
