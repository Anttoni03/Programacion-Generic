package Taller1;

public class AlbumVotos {
    
    //DECLARACIÓN DE ATRIBUTOS    
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
    //Atributo de clase que indica la dimensión en bytes que ocupa un objeto de
    //la clase en el fichero
    private static final int DIMENSION = 264;
    
    //MÉTODOS
    //Método constructor para instanciar objetos AlbumVotos
    public AlbumVotos()
    {
        posicion = 0;
        votos = 0;
    }
     
    //MÉTODOS FUNCIONALES
    //Métodos setters de los atributos de objeto
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
    
    //Métodos getters de los atributos de objeto
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
    
    
    //Método conversión para aplicar los valores de un objeto Album indicado
    //a un objeto AlbumVotos
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
    
    //Método toString para generar un String con los datos generales del álbum
    @Override
    public String toString()
    {
        String resultado = "# "+posicion
                + "\tvotos: "+votos
                + "\t"+titulo
                + "\tArtista: "+artista
                + "\taño: "+any;
        return resultado;
    }
    
    //Método mostrarCompleto que genera un String con los datos completos
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
    
    //Método mostrarActualizado que genera un String con los datos necesarios
    //para verse actualizado después de realizarse una votación
    public String mostrarActualizado()
    {
        String resultado = "# "+posicion
                + "\tvotos: "+votos
                + "\tpara "
                + "para "+titulo
                + "\t de "+artista;
        
        return resultado;
    }
    
    //Método copiar que devuelve un objeto AlbumVotos idéntico como copia
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
    
    //Método de clase getDimension que devuelve el atributo DIMENSION
    public static int getDimension()
    {
        return DIMENSION;
    }
}