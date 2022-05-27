package Taller1;

public class Album {
    
    //DECLARACIÓN DE ATRIBUTOS
    //Atributo de objeto que define la posición del álbum
    private int posicion;
    //Atributo de objeto que define el año del álbum (en catalán para no usar
    //el carácter 'ñ'
    private int any;
    //Atributo de objeto que define el título del álbum
    private String titulo;
    //Atributo de objeto que define el artista del álbum
    private String artista;
    //Atributo de objeto que define el tipo del álbum
    private String tipo;
    //Atributo de objeto que define las estrellas del álbum
    private double estrellas;
    //Atributo de objeto que define las ediciones hechas del álbum
    private int ediciones;
    //Atributo de clase que define la cantidad de líneas que se usan para
    //representar un objeto álbum en el fichero donde se almacenan
    private static final int CANTIDAD_LINEAS = 7;
    
    
    //MÉTODOS
    //Método constructor para instanciar objetos Album
    public Album()
    {
        posicion = 0;
    }
    
    //MÉTODOS FUNCIONALES
    //Métodos setters de los atributos de objeto
    public void setPosicion(int posicion)
    {
        this.posicion = posicion;
    }
    public void setAny(int any)
    {
        this.any = any;
    }
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    public void setArtista(String artista)
    {
        this.artista = artista;
    }
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    public void setEstrellas(double estrellas)
    {
        this.estrellas = estrellas;
    }
    public void setEdiciones(int ediciones)
    {
        this.ediciones = ediciones;
    }
    
    //Métodos getters de los atributos de objeto
    public int getPosicion()
    {
        return posicion;
    }
    public int getAny()
    {
        return any;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public String getArtista()
    {
        return artista;
    }
    public String getTipo()
    {
        return tipo;
    }
    public double getEstrellas()
    {
        return estrellas;
    }
    public int getEdiciones()
    {
        return ediciones;
    }
    
    
    //Método getter de clase para el atributo CANTIDAD_LINEAS
    public static int getCantidadLineas()
    {
        return CANTIDAD_LINEAS;
    }
    
    //Método toString para generar un String con los datos del álbum
    @Override
    public String toString()
    {
        String resultado = "Album{num="+posicion+", "
                + "año="+any+", "
                + "impresiones="+ediciones+", "
                + "título="+titulo+", "
                + "artista="+artista+", "
                + "tipo="+tipo+", "
                + "estrellas="+estrellas+"}";
        
        return resultado;
    }
}