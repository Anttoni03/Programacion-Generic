/*
FUNCIONALIDAD: introducción de 5 caracteres en una pila y su extracción y visualización porterior.

OBJETIVO: INTRODUCCIÓN CLASE Stack
 */
package clases_genericas_ii;
import java.util.Stack;

public class ejemploStack_3 {
    public static void main(String [] argumentos) throws Exception {
        new ejemploStack_3().metodoPrincipal();
    }
    
    public void metodoPrincipal() throws Exception {
        //DELARACIONES
        //instanciación pila utilizando la clase Stack para objetos caracter
        Stack<Character> pila=new Stack<Character>();
        //declaración variable char para almacenar, de uno en uno, los 
        //caracteres leidos desde el teclado
        char caracter;
        
        //ACCIONES
        //introducción de 5 caracteres leidos por teclado en la pila
        for (int indice=0;indice<5;indice++) {
            //lectura entero desde el teclado
            System.out.print("INTRODUCIR CARACTER "+(indice+1)+": ");
            caracter=LT.readChar();
            //introducción del caracter leido en la pila
            pila.push(caracter);
        }
        //extracción de los caracteres contenidos en la pila y visualización de
        //los mismos
        while (!pila.empty()) {
            //extracción elemento de la pila
            caracter=pila.pop();
            //visualización del caracter extraido de la pila
            System.out.println(caracter);
        }
    }
    
    
}

