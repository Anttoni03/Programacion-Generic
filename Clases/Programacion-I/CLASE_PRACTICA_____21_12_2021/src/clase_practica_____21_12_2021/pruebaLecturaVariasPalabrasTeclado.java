/*
FUNCIONALIDAD: programa que verifica la adaptación de los método hayPalabras y
lectura de la clase Palabra para poder gestionar la lectura de objetos Palabras de diferentes
secuencias de caracteres introducidas por teclado en un mismo programa.
 */
package clase_practica_____21_12_2021;


public class pruebaLecturaVariasPalabrasTeclado {
    public static void main(String [] argumentos) throws Exception {
        Palabra pal1=new Palabra();               
        Palabra pal2=new Palabra();    
        //LECTURA PRIMERA PALABRA
        System.out.print("INTRODUCIR PALABRA: ");
        while (Palabra.hayPalabras()) {
            pal1.lectura();
        }
        System.out.println(pal1.toString());
        System.out.print("INTRODUCIR TEXTO: ");
        //BUCLE LECTURA PALABRAS TEXTO
        while (Palabra.hayPalabras()) {
            pal2.lectura();
            System.out.println(pal2.toString());
        }        
    }   
}
