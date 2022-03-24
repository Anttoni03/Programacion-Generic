/*
CLASE Actualizacion
 */
package ActualizacionLibros;
import General.*;

//declaración tipo enumerado 
enum TiposActualizacion {
    MODIFICACION,
    ADICION,
    ELIMINACION
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
        if (actualizacion == TiposActualizacion.MODIFICACION)
        {
            System.out.print("CÓDIGO LIBRO A MODIFICAR: ");
            codigo=LT.readInt();
            System.out.print("NUEVO TÍTULO: ");
            titulo=LT.readLine();
        }
        else if (actualizacion == TiposActualizacion.ADICION)
        {
            System.out.print("CÓDIGO LIBRO A AÑADIR: ");
            codigo=LT.readInt();
            System.out.print("TÍTULO: ");
            titulo=LT.readLine();
        }
        else
        {
            System.out.println("CÓDIGO LIBRO A ELIMINAR");
            codigo=LT.readInt();
        }
    }   
    
    //métodos gets
    public int getCodigo() {
        return codigo;
    }    
    public String getTitulo() {
        return titulo;
    }  
    public TiposActualizacion getActualizacion() {
        return actualizacion;
    }
    
    //métodos sets
    public void setCodigo(int cod) {
        codigo=cod;
    }    
    public void setTitulo(String dato) {
        titulo=dato;
    }       
    public void setActualizacion() {
        System.out.print("TIPO DE ACTUALIZACIÓN: "
                + "\n[1] MODIFICACIÓN"
                + "\n[2] ADICIÓN"
                + "\n[3] ELIMINACIÓN"
                + "\n\t[OPCIÓN] ---> ");
        switch (LT.readInt())
        {
            case 1: actualizacion = TiposActualizacion.MODIFICACION;break;
            case 2: actualizacion = TiposActualizacion.ADICION;break;
            case 3: actualizacion = TiposActualizacion.ELIMINACION;break;
        }
    }
    
    public Libro generarLibro()
    {
        return new Libro(codigo, titulo);
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
