package Taller1;

public class AlbumVotos {
    
    private static final int DIMENSION = 264;
    
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
    //Atributo que define las ediciones del álbum               04 bytes
    private int ediciones;
    //Atributo que define el tipo del álbum    40 caracteres -> 80 bytes
    private String tipo;
    //Atributo que define las estrellas del álbum               08 bytes
    private double estrellas;
    
    
    public AlbumVotos()
    {
        posicion = 0;
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
    
    
    public void conversion(Album album)
    {
        posicion = album.getPosicion();
        titulo = album.getTitulo();
        artista = album.getArtista();
        any = album.getAny();
        
        ediciones = album.getEdiciones();
        tipo = album.getTipo();
        estrellas = album.getEstrellas();
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
    
    public String mostrarCompleto()
    {
        String resultado = "AlbumVotos{num="+posicion+", "
                + "año="+any+", "
                + "impres="+ediciones+", "
                + "votos="+votos+", "
                + "título="+titulo+", "
                + "artista="+artista+", "
                + "tipo="+tipo+", "
                + "estrellas="+estrellas+"}";
        
        return resultado;
    }
    
    public String mostrarActualizado()
    {
        String resultado = "# "+posicion
                + "\tvotos: "+votos
                + "\tpara "
                + "para "+titulo
                + "\t de "+artista;
        
        return resultado;
    }
    
    public AlbumVotos copiar()
    {
        AlbumVotos album = new AlbumVotos();
        album.posicion = posicion;
        album.votos = votos;
        album.titulo = titulo;
        album.artista = artista;
        album.any = any;
        album.ediciones = ediciones;
        album.tipo = tipo;
        album.estrellas = estrellas;
        
        return album;
    }
    
    public static int getDimension()
    {
        return DIMENSION;
    }
}