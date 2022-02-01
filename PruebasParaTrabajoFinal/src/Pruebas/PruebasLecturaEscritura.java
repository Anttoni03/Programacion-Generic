package Pruebas;


import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.BufferedWriter;

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
        BufferedWriter esc = new BufferedWriter(new FileWriter("cosa.txt", true));
        
        
        esc.write("Holaaaa");
        esc.close();
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
