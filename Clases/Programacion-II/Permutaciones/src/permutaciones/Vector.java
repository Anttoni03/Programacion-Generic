/*
CLASE Vector: aglutimos las declaraciones y las funcionalidades que nos van a posibilitar
gestionar objetos de la clase Vector de elementos enteros.
*/

package permutaciones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Vector {
    //ATRIBUTOS
    private int [] vector;

    //MÉTODOS
    //Constructor
    public Vector(int componentes) {
        vector = new int[componentes];
    }

    public Vector(int [] dato) {
        vector = dato;
    }
    @Override
    public String toString() {
        String resultado = "( ";
        for (int i = 0; i < vector.length; i++) {
            resultado += vector[i] + " ";
        }
        return resultado + ")";
    }
    
    //método que posibilita la lectura de un objeto Vector por teclado componente
    //a componente
    public void lectura() {
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in)); 

        try {
            for (int indice=0;indice<vector.length;indice++) {
                System.out.print("elemento "+indice+" : ");
                vector[indice]=Integer.parseInt(teclado.readLine());   
            }            
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }

    //método que lleva a cabo el cálculo del módulo de un objeto Vector
    public double modulo() {
        double resultado = 0;
        for (int i = 0; i < vector.length; i++) {
            resultado += vector[i] * vector[i];
        }
        return Math.sqrt(resultado);
    }
 
    //método que lleva  a cabo la asignación aleatoria de valores a las componentes
    //de un objeto Vector
    public void asignacionAleatoria(int limite) {
        Random valor = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = valor.nextInt(limite);
        }
    }

    //método que lleva a cabo la modificación del valor de una componente, cuyo índice
    //es dado por parámetro, de un objeto Vector
    public void setValor(int indice, int valor) {
        this.vector[indice] = valor;
    }

    //método que devuelve la dimensión de un objeto Vector
    public int getDimension() {
        return vector.length;
    }
   
    //método de clase lleva a cabo la obtención del angulo que forman dos objetos
    //Vector dados parámetro
    private static double anguloVectores(Vector a,Vector b) {
        //declaraciones
        double resultado=0;
        
        try {
            resultado=0.0;   
            for (int i = 0; i < a.vector.length; i++) {
                resultado=resultado+a.vector[i]*b.vector[i];
            }
            resultado=resultado/(a.modulo()*b.modulo());            
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
        return resultado;
    }
    
    //método de objeto que lleva a cabo la obtención del angulo que forman un objeto
    //Vector con otro objeto Vector dado por parámetro
    private double anguloVectores(Vector b) {
        //declaraciones
        double resultado=0;
        
        try {
            resultado=0.0;   
            for (int i = 0; i < vector.length; i++) {
                resultado=resultado+vector[i]*b.vector[i];
            }
            resultado=resultado/(modulo()*b.modulo());            
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
        return resultado;
    }
    
    //método de clase que lleva a cabo el producto escalar de dos objetos Vector
    //dados por parámetro
    public static double productoEscalar(Vector a, Vector b) {
        double resultado=0;
        try {
            if (a.vector.length != b.vector.length) {
                throw new rangosInconsistentes("Rangos inconsistentes");
            }
            resultado= (a.modulo()*b.modulo()*(Vector.anguloVectores(a,b)));            
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
        return resultado;
    } 
    
    //método de objeto que lleva a cabo el producto escalar de un objeto Vector
    //con otro objeto Vector dado por parámetro
    public double productoEscalar(Vector b) {
        double resultado=0;
        try {
            if (vector.length != b.vector.length) {
                throw new rangosInconsistentes("Rangos inconsistentes");
            }
            resultado= (modulo()*b.modulo()*(anguloVectores(b)));            
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
        return resultado;
    } 
    
    public static class rangosInconsistentes extends Exception {
        public rangosInconsistentes(String s) {
            super(s);
        }
    }
    
    public Vector primeraPermutacion() {
        return new Vector(vector);
    }
    
    public boolean ultimaPermutacion() {
        for (int indice1=0,indice2=vector.length-1;indice1<vector.length;indice1++,indice2--) {
            if (vector[indice1]!=indice2) {
                return false;
            }
        }
        return true;
    }
    
    public Vector siguientePermutacion() {
        Vector local=new Vector(this.vector);
        int indice1, indice2, auxiliar;
        //BÚSQUEDA ELEMENTO A CAMBIAR
        for (indice1=vector.length-2;vector[indice1]>vector[indice1+1];indice1--) {}

        //BÚSQUEDA ELEMENTO A INTERCAMBIAR
        for (indice2=vector.length-1;vector[indice2]<vector[indice1];indice2--) {}

        //INTERCAMBIO
        auxiliar = local.vector[indice1];
        local.vector[indice1] = local.vector[indice2];
        local.vector[indice2] = auxiliar;
        
        //REORDENACIÓN A LA DERECHA DE indice1
        for (indice1++, indice2 = vector.length - 1; indice1 < indice2; indice1++, indice2--) {
            auxiliar = local.vector[indice1];
            local.vector[indice1] = local.vector[indice2];
            local.vector[indice2] = auxiliar;
        }
        //DEVOLUCIÓN PERMUTACIÓN OBTENIDA
        return local;
    }
}
