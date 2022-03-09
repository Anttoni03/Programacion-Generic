/*
CLASE Pelicula
 */


public class Pelicula implements java.io.Serializable{
    //DECLARACIONES DE ATRIBUTOS
    private String titulo;
    private String director;
    private int año;
    
    //MÉTODOS CONSTRUCTORES
    //constructor vacío
    public Pelicula() {}
    
    //constructor
    public Pelicula(String dato1, String dato2, int dato3){
        titulo = dato1;
        director = dato2;
        año = dato3;
    }
    
    //MÉTODOS GET's
    public String getTitulo(){
        return titulo;
    }
    
    public String getDirector(){
        return director;
    }
    
    public int getAño(){
        return año;
    }

    //MÉTODOS SET's
    public void setTitulo(String dato){
        titulo=dato;
    }
    
    public void setDirector(String dato){
        director=dato;
    }
    
    public void setAño(int dato){
        año=dato;
    }

    //método lectura de un objeto Pelicula desde el teclado
    public void lectura() {
        //MENSAJE USUARIO LECTURA PELÍCULA
        System.out.println("LECTURA PELÍCULA DESDE EL TECLADO");
        //mensaje usuario para introducir el título de la película
        System.out.print("Título: ");
        //lectura título película
        titulo=LT.readLine();
        //mensaje usuario para introducir el director de la película
        System.out.print("Director: ");
        //lectura director película
        director=LT.readLine();
        //mensaje usuario para introducir el año de la película
        System.out.print("Año estreno: ");
        //lectura año película
        año=Integer.parseInt(LT.readLine());        
    }
    
    //MÉTODO toString
    @Override
    public String toString(){
        return "Título: "+titulo+" -  Director: "+director+" - Año: "+año;
    }
}
