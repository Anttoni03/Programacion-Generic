/*
CLASE Actualizacion
 */
package EjerciciosLibro;
import General.LT;

//declaración tipo enumerado 
enum TiposActualizacion {
    MODIFICACION
}

public class Actualizacion implements java.io.Serializable {
     // ATRIBUTOS
     private int codigo;
     private String titulo;
     private TiposActualizacion actualizacion;
     private static final Actualizacion CENTINELA=new Actualizacion(Integer.MAX_VALUE,"");

    // MÉTODOS CONSTRUCTORES
    public Actualizacion () {
        actualizacion=TiposActualizacion.MODIFICACION;    
    }
    
    public Actualizacion(int dato1, String dato2) {
        codigo=dato1;
        titulo=dato2;
        actualizacion=TiposActualizacion.MODIFICACION;
    }
    
    //MÉTODOS FUNCIONALES    
    //conversión a String de un objeto Libro con fines de visualización
    @Override
    public String toString() {
        return "CODIGO: " + codigo +" - TÍTULO: " + titulo+
                " - ACTUALIZACIÓN: " + actualizacion;
    } 
    
    //lectura por teclado actualización
    public void lectura() {
        System.out.print("CÓDIGO LIBRO A MODIFICAR: ");
        codigo=LT.readInt();
        System.out.print("NUEVO TÍTULO: ");
        titulo=LT.readLine();
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
   
    //método que devuelve el objeto Actualizacion CENTINELA
    public static Actualizacion getCentinela() {
        return CENTINELA;
    }
    
    //método que verifica si un objeto Actualizacion es centinela o no
    public boolean esCentinela() {
        return codigo==CENTINELA.codigo;
    }
}
