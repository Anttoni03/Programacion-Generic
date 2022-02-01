//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package pruebasparatrabajofinal;

public class Ficha {
    //DECLARACIÓN DE LOS ATRIBUTOS
    //atributo de objeto que representa el carácter alfabético de la ficha
    private char letra;
    //atributo de objeto que representa la cantidad total de esa ficha
    private int cantidad;
    //atributo de objeto que representa el valor de puntuación de la ficha
    private int valor;
    
    //MÉTODOS
    //método constructor que instancia una ficha con una letra, una cantidad y
    //un valor inicial definidos
    public Ficha(char let, int can, int val)
    {
        letra = let;
        cantidad = can;
        valor = val;
    }
    
    //método getLetra que devuelve el atributo letra
    public char getLetra()
    {
        return letra;
    }
    
    //método getCantidad que devuelve el atributo cantidad
    public int getCantidad()
    {
        return cantidad;
    }
    
    //método getValor que devuelve el atributo valor
    public int getValor()
    {
        return valor;
    }
    
    //método copiar que devuelve una copia del mismo objeto ficha
    public Ficha copiar()
    {
        Ficha ficha = new Ficha(letra, valor, valor);
        return ficha;
    }
    
    //método toString que devuelve un String con los atributos letra y valor
    public String toString()
    {
      return "Letra - " + letra + "\tPuntos - " + valor;
    }
}
