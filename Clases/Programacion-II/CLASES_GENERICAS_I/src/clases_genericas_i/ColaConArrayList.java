
package clases_genericas_i;

import java.util.ArrayList;

public class ColaConArrayList <T> {
    Exception ColaVacia;
    private final ArrayList <T> cola;

    public ColaConArrayList() {
            cola = new ArrayList <T>();
    }

    public void introducir(T valor) {
            cola.add(valor);
    }

    public T extraer() throws ColaVacia, Exception {
            T elemento;
            if (!cola.isEmpty()) return cola.remove(0);
            else throw ColaVacia;
    }
        
   public int numElementos() {
           return cola.size();
   }
}
