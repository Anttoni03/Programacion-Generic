/*
CLASE Vector: aglutimos las declaraciones y las funcionalidades que nos van a posibilitar
gestionar objetos de la clase Vector.

*/

package problemasmatriciales;

import java.util.Random;

public class Vector {
    //ATRIBUTOS
    private double vector [];

    //MÉTODOS
    //Constructor
    public Vector(int dimension) {
        vector = new double[dimension];
    }

    @Override
    public String toString() {
        String resultado = "(";
        for (int i = 0; i < vector.length; i++) {
            resultado += vector[i] + " ";
        }
        return resultado + ")";
    }
    
    public String toStringChar()
    {
        String resultado = "(";
        for (int i = 0; i < vector.length; i++) {
            resultado += (char)(int)vector[i] + ((i == vector.length-1)?"":" ");
        }
        return resultado + ")";
    }
    
    //método que posibilita la lectura de un objeto Vector por teclado componente
    //a componente
    public void lectura() {
        try {
            for (int indice=0;indice<vector.length;indice++) {
                System.out.print("elemento "+indice+" : ");
                vector[indice]=LT.readDouble();   
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
    public void setValor(int indice, double valor) {
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
    
    public void ponerElemento(int posicion, double valor)
    {
        try{
            if (posicion < vector.length)
                vector[posicion] = valor;
            else
                throw new rangosInconsistentes("Rangos incosistentes");
        }
        catch (Exception e) {}
    }
    
    public Vector permutar(int origen, int destino)
    {
        Vector v = copiar();
        try{
            if (origen < v.vector.length && destino < v.vector.length)
            {
                double temp = v.vector[origen];
                v.vector[origen] = v.vector[destino];
                v.vector[destino] = temp;
            }
            else
                throw new rangosInconsistentes("Rangos inconsistentes");
        }
        catch (Exception e) {}
        
        return v;
    }
    
    
    public void combinatorios()
    {
        Vector v = copiar();
        int iter = 0;
        
        combinatoriosBucle(v, iter);
    }
    
    private void combinatoriosBucle(Vector v, int iter)
    {        
        if (iter == v.vector.length - 2)
        {
            System.out.println(v.toStringChar());
            System.out.println(v.permutar(iter, iter+1).toStringChar());
            
            return;
        }
        
        for (int i = iter; i < v.vector.length; i++)
        {
            v = v.permutar(iter, i);
            Vector aux = v.copiar();
            
            combinatoriosBucle(aux, iter+1);
        }
    }
    
    public Vector copiar()
    {
        Vector v = new Vector(vector.length);
        for (int i = 0; i < vector.length; i++)
        {
            v.vector[i] = vector[i];
        }
        return v;
    }
    
    public static class rangosInconsistentes extends Exception {
        public rangosInconsistentes(String s) {
            super(s);
        }
    }
}
