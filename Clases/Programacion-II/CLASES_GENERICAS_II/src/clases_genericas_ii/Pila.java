package clases_genericas_ii;

public class Pila <T extends Comparador> {
    private final int TAMAÑO;
    private T [] elementos;
    private int indiceUltimoElemento;

    public Pila(int s) {
        TAMAÑO = s > 0 ? s : 10;
        elementos = (T []) new Comparador[TAMAÑO];
        indiceUltimoElemento = -1; // pila vacia, índice del elemento de arriba LIFO 
    }

    public void introducir(T elemento) { //push
        try {
            if (indiceUltimoElemento == TAMAÑO - 1) {
                throw new PilaLlena("LA PILA ESTÁ LLENA");
            }
            indiceUltimoElemento++;
            elementos[indiceUltimoElemento] = elemento;            
        }catch (PilaLlena error) {
            System.out.println(error.toString());
        }
    }

    public T extraer() { //pop
        try {
            if (indiceUltimoElemento == -1) {
                throw new PilaVacia("LA PILA ESTÁ VACIA");
            }                  
        }catch (PilaVacia error) {
            System.out.println(error.toString());
        }
        return elementos[indiceUltimoElemento--]; 
    }

    public boolean estaLlena() {
        return indiceUltimoElemento == TAMAÑO -1;
    }

    public boolean estaVacia() {
        return indiceUltimoElemento == -1;
    }
    
    
    public static class PilaLlena extends Exception {
         public PilaLlena(String s) {
            super(s);
        }
    }

    public static class PilaVacia extends Exception {
        public PilaVacia(String s) {
            super(s);
        }
    }

}
