
package clases_genericas_i;

import java.util.ArrayList;

public class PilaConArrayList <T> {
    Exception PilaVacia;
    private final ArrayList <T> pila;
 
    public PilaConArrayList() {
            pila = new ArrayList <T> ();
    }

    public void introducir(T valor) {
            pila.add(valor);
    }

    public T extraer() throws PilaVacia, Exception {
            T elemento;
            if (!pila.isEmpty()) {
                return pila.remove(pila.size()-1);
            }
            else throw PilaVacia;
    }
        
   public int numElementos() {
           return pila.size();
   }

}
