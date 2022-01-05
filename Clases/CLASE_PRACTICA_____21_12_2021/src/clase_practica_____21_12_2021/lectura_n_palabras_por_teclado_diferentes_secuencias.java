/*
FUNCIONALIDAD: programa que verifica la adaptación de los método hayPalabras y
lectura de la clase Palabra para poder gestionar la lectura de objetos Palabras de diferentes
secuencias de caracteres introducidas por teclado en un mismo programa.
 */
package clase_practica_____21_12_2021;

public class lectura_n_palabras_por_teclado_diferentes_secuencias {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new lectura_n_palabras_por_teclado_diferentes_secuencias().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable entera para representar el número de palabras
        //a leer desde el teclado
        int numeroPalabras;
        //declaración objeto Palabra para almacenar las palabras a leer desde
        //el teclado, de una en una.
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //mensaje usuario para introducir número de palabras a leer y visualizar
        System.out.print("NÚMERO DE PALABRAS A LEER: ");
        //lectura número de palabras a leer
        numeroPalabras=LT.readInt();
        //bucle de lectura y visualización de palabras
        for (int indice=1;indice<=numeroPalabras;indice++) {
            System.out.print("INTRODUCIR PALABRA "+indice+": ");
            //verficación de existencia de palabras desde el teclado
            while (Palabra.hayPalabras()) {               
                //lectura palabra desde el teclado
                palabra.lectura();
                //visualización palabra leida
                System.out.println("LA PALABRA NÚMERO "+indice+" HA SIDO "+palabra.toString());
            }
        }
    }
    
}
