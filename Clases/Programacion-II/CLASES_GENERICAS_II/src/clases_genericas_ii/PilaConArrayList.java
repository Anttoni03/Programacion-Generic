
package clases_genericas_ii;

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

    public T extraer() {
        try {
            if (pila.isEmpty()) {
                throw new PilaVacia("PILA VACIA");
            }
        }catch (PilaVacia error) {
            System.out.println("PILA VACIA");
        }
        return pila.remove(pila.size()-1);
    }
    
    public boolean estaVacia() {
        return pila.isEmpty();
    }
        
   public int numElementos() {
       return pila.size();
   }

}
