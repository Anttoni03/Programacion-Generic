package clases_genericas_i;

public class Lista <T> {
    private final int tamaño;
    private T [] elementos;
    private int numElementos;

    public Lista(int s) {
        tamaño = s > 0 ? s : 10;
        elementos = (T []) new Object[tamaño];
        numElementos = 0; 
    }

    
    public void introducir(T item) { 
        try {
            if (numElementos == tamaño) {
                throw new ListaLlena("La lista está llena");
            }
            elementos[numElementos] = item;
            numElementos++;            
        } catch (ListaLlena error) {
            System.out.println(error.toString());
        }
    }

    public T extraer(int pos)  { 
        T elemento=null;
        try {
            if (numElementos == 0) {
                throw new ListaVacia("La lista está vacia");
            }
            if (!((pos >=0) && (pos<=(numElementos-1))) ) {
                throw new PosicionInexistente("La posición de extracción no es correcta");
            }
            elemento=elementos[pos];
            for (int i=pos+1;i<numElementos;i++) {
                elementos[i-1]=elementos[i];
            }
            numElementos--;
                 
        }catch (PosicionInexistente error) {
            System.out.println(error.toString());
        }catch (ListaVacia error) {
            System.out.println(error.toString());
        }
        return elemento;  
    }

    public T consultar(int pos) { 
        try {
            if (numElementos == 0) {
                throw new ListaVacia("La lista está vacia");
            }
            if (!((pos >=0) && (pos<=(numElementos-1))) ) {
                throw new PosicionInexistente("La posición de extracción no es correcta");
            }            
        }catch (PosicionInexistente error) {
            System.out.println(error.toString());
        }catch (ListaVacia error) {
            System.out.println(error.toString());
        }
        return elementos[pos];
    }
        
    public void intercambiar(int pos1,int pos2) { 
        try {
            if (numElementos > 1) {
                throw new NumeroElementosInsuficiente("Número de elemntos insuficiente "
                        + "para llevar a cabp el intercambio");
            }
            if ((!((pos1 >=0) && (pos1<=(numElementos-1))) ) || (!((pos2 >=0) && (pos2<=(numElementos-1))) ) ) {
                throw new PosicionInexistente("Posiciones incorrectas");
            }
            T elemento=elementos[pos1];
            elementos[pos1]=elementos[pos2];
            elementos[pos2]=elemento;            
        }catch (PosicionInexistente error) {
            System.out.println(error.toString());
        }catch (NumeroElementosInsuficiente error) {
            System.out.println(error.toString());
        }

    }
        
    public boolean estaLlena() {
        return numElementos == tamaño;
    }

    public boolean estaVacia() {
        return numElementos == 0;
    }
    
    public int numElementos(){
        return numElementos;
    }
    public static class ListaLlena extends Exception {
         public ListaLlena(String e) {
            super(e);
        }
    }

    public static class ListaVacia extends Exception {
        public ListaVacia(String e) {
            super(e);
        }
    }
    
    public static class PosicionInexistente extends Exception {
        public PosicionInexistente(String e) {
            super(e);
        }
    }    

    public static class NumeroElementosInsuficiente extends Exception {
        public NumeroElementosInsuficiente(String e) {
            super(e);
        }
    }  
}
