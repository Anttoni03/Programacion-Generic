package Taller1;

public class Album {
    
    private int posicion;
    private int any;
    private String titulo;
    private String artista;
    private String tipo;
    private double estrellas;
    private int ediciones;
    
    private static final int CANTIDAD_LINEAS = 7;
    
    //MÉTODOS CONSTRUCTORES
    public Album()
    {
        
    }
    
    
    //MÉTODOS FUNCIONALES
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
    
    
    public static int getCantidadLineas()
    {
        return CANTIDAD_LINEAS;
    }
    
    
    public String toString()
    {
        String resultado = "Album{num="+posicion+", "
                + "any="+any+", "
                + "impres="+ediciones+", "
                + "titol="+titulo+", "
                + "artista="+artista+", "
                + "tipus="+tipo+", "
                + "estrelles="+estrellas+"}";
        
        return resultado;
    }
}
