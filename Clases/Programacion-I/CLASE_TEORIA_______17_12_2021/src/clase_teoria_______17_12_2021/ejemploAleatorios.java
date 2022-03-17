/*
EJEMPLO ALEATORIOS
ILUSTRACIÓN DEL MÉTODO random DE LA CLASE Math y DE LA CLASE Random
 */
package clase_teoria_______17_12_2021;

import java.util.Random;

public class ejemploAleatorios {
    //método main
    public static void main(String[] args) throws Exception {
        new ejemploAleatorios().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {     
        //MODALIDAD Math
        //generación numeros aleatorios reales con Math.random en [0.0,1.0)
        System.out.println("generación numeros aleatorios reales con Math.random en [0.0,1.0)");
        for (int indice=0;indice<10;indice++) {
            //generación número indice-ésimo en [0.0,1.0)
            double numero=Math.random();
            //visualización número indice-ésimo 
            System.out.print(numero+" ");
        }
        System.out.println();
        //generación numeros aleatorios enteros con Math.random en [0,10)
        System.out.println("generación numeros aleatorios enteros con Math.random en [0,10)");
        for (int indice=0;indice<10;indice++) {
            //generación número indice-ésimo en [0,10)
            int numero=(int) (Math.random()*10);
            //visualización número indice-ésimo 
            System.out.print(numero+" ");
        }   
        System.out.println();
        //generación numeros aleatorios enteros con Math.random en [1,10]
        System.out.println("generación numeros aleatorios enteros con Math.random en [1,10]");
        for (int indice=0;indice<10;indice++) {
            //generación número indice-ésimo en [1,10]
            int numero=(int) (Math.random()*10)+1;
            //visualización número indice-ésimo 
            System.out.print(numero+" ");
        }
        
        
        
        //MODALIDAD CLASE Random        
        
        System.out.println();
        //generación numeros aleatorios enteros con Random en [0,10)
        
        System.out.println("generación numeros aleatorios enteros con Random en [0,10)");
        //instanciación objeto Random
        Random generador=new Random();
        for (int indice=0;indice<10;indice++) {
            //generación número indice-ésimo en [0,10)
            int numero=generador.nextInt(10);
            //visualización número indice-ésimo 
            System.out.print(numero+" ");
        }     
        System.out.println();
        //generación numeros aleatorios enteros con Random en [1,10]
        System.out.println("generación numeros aleatorios enteros con Random en [1,10]");
        //instanciación objeto Random
        Random generador1=new Random();
        for (int indice=0;indice<10;indice++) {
            //generación número indice-ésimo en [0,10)
            int numero=generador1.nextInt(10)+1;
            //visualización número indice-ésimo 
            System.out.print(numero+" ");
        }     
        
        
        System.out.println();
        //generación numeros aleatorios enteros con Random en [0,10) con semilla
        System.out.println("generación numeros aleatorios enteros con Random en [0,10) con semilla");
        //instanciación objeto Random
        int semilla=5;
        Random generador2=new Random(semilla);
        for (int indice=0;indice<10;indice++) {
            //generación número indice-ésimo en [0,10)
            int numero=generador2.nextInt(10);
            //visualización número indice-ésimo 
            System.out.print(numero+" ");
        }  
        
        System.out.println();
        //utilización generación aleatorios para generar índices de un array
        System.out.println("utilización generación aleatorios para generar índices de un array");
        final char [] ALFA = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //generación numeros aleatorios enteros con Random en [0,10) con semilla
        //instanciación objeto Random
        Random generador3=new Random();
        for (int indice=0;indice<10;indice++) {
            //generación número indice-ésimo en [0,ALFA.length)
            int numero=generador3.nextInt(ALFA.length);
            //visualización caracter de índice numero
            System.out.print(ALFA[numero]+" ");
        }  
        System.out.println();   
    }
}    
