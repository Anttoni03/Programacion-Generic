/*
CLASE Libro
 */

package clases_problemas_a_realizar_17_03_2022;

//clase serializada para poder llevar a cabo la gestión de objetos Libro en
//ficheros a través del flujo de datos (clases ObjectInputStream y ObjectOutputStream
public class Libro implements java.io.Serializable {
    // ATRIBUTOS
     private int codigo;
     private String titulo;
     private static final Libro CENTINELA=new Libro(Integer.MAX_VALUE,"");
     
    // MÉTODOS CONSTRUCTORES
    public Libro() {
        codigo=0;
    }
    
    public Libro(int dato1, String dato2) {
        codigo=dato1;
        titulo=dato2;
    }
   
    //MÉTODOS FUNCIONALES
    //método que devuelve el objeto Libro centinela
    public static Libro getCentinela() {
        return CENTINELA;
    }
    
    //método que verifica si un objeto Libro es centinela o no
    public boolean esCentinela() {
        return codigo==CENTINELA.codigo;
    }
      
    //lectura de objeto Libro desde el teclado. 
    public void lectura() {
        System.out.print("CÓDIGO LIBRO: ");
        codigo=LT.readInt();
        System.out.print("TÍTULO LIBRO: ");
        titulo=LT.readLine();
    }   

    
    //conversión a String de un objeto Libro con fines de visualización
    @Override
    public String toString() {
        return "CODIGO: " + codigo +" - TÍTULO: " + titulo;
    } 
    
    //métodos gets
    public int getCodigo() {
        return codigo;
    }    
    public String getTitulo() {
        return titulo;
    }    
    
    //métodos sets
    public void setCodigo(int cod) {
        codigo=cod;
    }    
    public void setTitulo(String dato) {
        titulo=dato;
    }   
   
}


