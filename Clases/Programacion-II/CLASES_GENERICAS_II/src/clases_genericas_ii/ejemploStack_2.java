/*
FUNCIONALIDAD: introducción de 5 enteros en una pila y su extracción y visualización porterior.

OBJETIVO: INTRODUCCIÓN CLASE Stack
 */
package clases_genericas_ii;
import java.util.Stack;

public class ejemploStack_2 {
    public static void main(String [] argumentos) throws Exception {
        new ejemploStack_2().metodoPrincipal();
    }
    
    public void metodoPrincipal() throws Exception {
        //DELARACIONES
        //instanciación pila utilizando la clase Stack para objetos enteros
        Stack<Integer> pila=new Stack<Integer>();
        //declaración variable entera para almacenar, de uno en uno, los 
        //enteros leidos desde el teclado
        int numero;
        
        //ACCIONES
        //introducción de 5 enteros leidos por teclado en la pila
        for (int indice=0;indice<5;indice++) {
            //lectura entero desde el teclado
            System.out.print("INTRODUCIR NÚMERO "+(indice+1)+": ");
            numero=LT.readInt();
            //introducción del enetro leido en la pila
            pila.push(numero);
        }
        //extracción de los enteros contenidos en la pila y visualización de
        //los mismos
        while (!pila.empty()) {
            //extracción elemento de la pila
            numero=pila.pop();
            //visualización del entero extraido de la pila
            System.out.println(numero);
        }
    }
    
    
}

