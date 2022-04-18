package Taller1;

public class AlbumVotos {
    
    private static final int DIMENSION = 172;
    
    //Atributo que define la posición del álbum                 04 bytes
    private int posicion;
    //Atributo que define los votos totales del álbum           04 bytes
    private int votos;
    //Atributo que define el nombre del álbum  40 caracteres -> 80 bytes
    private String titulo;
    //Atributo que define el artista del álbum 40 caracteres -> 80 bytes
    private String artista;
    //Atributo que define el año de salida del álbum            04 bytes
    private int any;
    
    public AlbumVotos()
    {
        votos = 0;
    }
    
    public AlbumVotos(int posicion, String titulo, String artista, int any)
    {
        this.posicion = posicion;
        this.votos = 0;
        this.titulo = titulo;
        this.artista = artista;
        this.any = any;
    }
    
    
    public void setPosicion(int posicion)
    {
        this.posicion = posicion;
    }
    public void setVotos(int votos)
    {
        this.votos = votos;
    }
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    public void setArtista(String artista)
    {
        this.artista = artista;
    }
    public void setAny(int any)
    {
        this.any = any;
    }
    
    public int getPosicion()
    {
        return posicion;
    }
    public int getVotos()
    {
        return votos;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public String getArtista()
    {
        return artista;
    }
    public int getAny()
    {
        return any;
    }
    
    
    public void conversion(Album album)
    {
        posicion = album.getPosicion();
        titulo = album.getTitulo();
        artista = album.getArtista();
        any = album.getAny();
    }
    
    public String toString()
    {
        String resultado = "# "+posicion
                + "\tvotos: "+votos
                + "\t"+titulo
                + "\tArtista: "+artista
                + "\taño: "+any;
        return resultado;
    }
    
    public static int getDimension()
    {
        return DIMENSION;
    }
}
