/*
CLASE Pelicula
 */
package clasepractica__10_03_2022;

public class PeliculaConCentinela implements java.io.Serializable {
    //DECLARACIONES DE ATRIBUTOS
    private String titulo;
    private String director;
    private int año;
    //declaración atributo objeto CENTINELA
    private static final PeliculaConCentinela CENTINELA=new PeliculaConCentinela("","",0);
    
    //MÉTODOS CONSTRUCTORES
    //constructor vacío
    public PeliculaConCentinela() {}
    
    //constructor
    public PeliculaConCentinela(String dato1, String dato2, int dato3){
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

    //método lectura de un objeto PeliculaConCentinela desde el teclado
    public void lectura() {
        //MENSAJE USUARIO LECTURA PELÍCULA
        System.out.println("LECTURA PELÍCULA DESDE EL TECLADO");
        //mensaje usuario para introducir el título de la PeliculaConCentinela
        System.out.print("Título: ");
        //lectura título película
        titulo=LT.readLine();
        //mensaje usuario para introducir el director de la PeliculaConCentinela
        System.out.print("Director: ");
        //lectura director película
        director=LT.readLine();
        //mensaje usuario para introducir el año de la PeliculaConCentinela
        System.out.print("Año estreno: ");
        //lectura año película
        año=Integer.parseInt(LT.readLine());        
    }
    
    //MÉTODO toString
    @Override
    public String toString(){
        return "Título: "+titulo+" -  Director: "+director+" - Año: "+año;
    }
    
    //método esCentinela lleva a cabo la verificación de si un objeto PeliculaConCentinela
    //es el objeto CENTINELA
    public boolean esCentinela() {
        return año==CENTINELA.año;
    }
    
    //método getCentinela lelva a cabo la devolución del objeto CENTINELA
    public static PeliculaConCentinela getCentinela() {
        return CENTINELA;
    }
}
