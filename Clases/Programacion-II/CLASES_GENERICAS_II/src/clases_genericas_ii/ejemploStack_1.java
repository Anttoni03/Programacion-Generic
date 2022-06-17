/*
FUNCIONALIDAD: introducción de 5 Strings en una pila y su extracción y visualización posterior.

OBJETIVO: INTRODUCCIÓN CLASE Stack
 */
package clases_genericas_ii;
import java.util.Stack;

public class ejemploStack_1 {
    public static void main(String [] argumentos) throws Exception {
        new ejemploStack_1().metodoPrincipal();
    }
    
    public void metodoPrincipal() throws Exception {
        //DELARACIONES
        //instanciación pila utilizando la clase Stack para objetos String
        Stack<String> pila=new Stack<String>();
        //declaración variable String para almacenar, de uno en uno, los 
        //literales String leidos desde el teclado
        String literal;
        
        //ACCIONES
        //introducción de 5 Strings leidos por teclado en la pila
        for (int indice=0;indice<5;indice++) {
            //lectura String desde el teclado
            System.out.print("INTRODUCIR LITERAL STRING "+(indice+1)+": ");
            literal=LT.readLine();
            //introducción del String leido en la pila
            pila.push(literal);
        }
        //extracción de los Strings contenidos en la pila y visualización de
        //los mismos
        while (!pila.empty()) {
            //extracción String de la pila
            literal=pila.pop();
            //visualización del String extraido de la pila
            System.out.println(literal);
        }
    }
    
    
}

