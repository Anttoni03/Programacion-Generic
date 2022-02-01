//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package pruebasparatrabajofinal;

public class Ficha {
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE
    //variable de objeto que representa el carácter alfabético de la ficha
    private char letra;
    //variable de objeto que representa la cantidad total de esa ficha
    private int cantidad;
    //variable de objeto que representa el valor de puntuación de la ficha
    private int valor;
    
    //MÉTODO CONSTRUCTOR
    public Ficha(char let, int can, int val)
    {
        letra = let;
        cantidad = can;
        valor = val;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER EL CARÁCTER
    public char getLetra()
    {
        return letra;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER LA CANTIDAD DE LA FICHA
    public int getCantidad()
    {
        return cantidad;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER EL VALOR
    public int getValor()
    {
        return valor;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER UNA COPIA DEL OBJETO FICHA
    public Ficha copiar()
    {
        Ficha ficha = new Ficha(letra, valor, valor);
        return ficha;
    }
    
    public String toString()
    {
      return "Letra - " + letra + "\tPuntos - " + valor;
    }
}
