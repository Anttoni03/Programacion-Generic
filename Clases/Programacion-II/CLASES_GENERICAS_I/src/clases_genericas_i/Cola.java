package clases_genericas_i;

public class Cola <T> {
    private final int TAMAÑO;
    private T [] elementos;
    private int indiceUltimoElemento;

    public Cola(int s) {
        TAMAÑO = s > 0 ? s : 10;
        elementos = (T []) new Object[TAMAÑO];
        indiceUltimoElemento = -1; 
    }

    public void introducir(T item) {
        try {
            if (indiceUltimoElemento == TAMAÑO - 1) {
                throw new ColaLlena("La cola está llena");
            }
            indiceUltimoElemento++;
            elementos[indiceUltimoElemento] = item;            
        }catch (ColaLlena error) {
            System.out.println(error.toString());
        }
    }

    public T extraer() { 
        T elemento=null;
        try {
            if (indiceUltimoElemento == -1) {
                throw new ColaVacia("La cola está vacia");
            }
            elemento=elementos[0];
            for (int i=1;i<=indiceUltimoElemento;i++) {
                elementos[i-1]=elementos[i];
            }
            indiceUltimoElemento--;            
        }catch (ColaVacia error) {
            System.out.println(error.toString());
        }
        return elemento;
    }

    public boolean estaLlena() {
        return indiceUltimoElemento == TAMAÑO -1;
    }

    public boolean estaVacia() {
        return indiceUltimoElemento == -1;
    }
    
    
    public static class ColaLlena extends Exception {
         public ColaLlena(String e) {
            super(e);
        }
    }
    
    public static class ColaVacia extends Exception {
        public ColaVacia(String e) {
            super(e);
        }
    }
}
