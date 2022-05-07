package taller1;

//Creador: Nahuel Vazquez

//Clase album que aglutina todos los atributos que puede contener un disco y las funciones que se pueden realizar con este
public class Album {
//ENUM

    //Clase enumerada que define los diferentes tipos de album permitidos
    enum TiposAlbum {
        ALBUM("Album"), ALBUM_SOUNDTRACK("Album + Soundtrack"), ALBUM_COMPILATION("Album + Compilation"), ALBUM_LIVE("Album + Live"), ERROR("Error");

        private String tipo;

        private TiposAlbum(String tipo) {
            this.tipo = tipo;
        }

        public String getEtiquetaTipo() {
            return tipo;
        }
    }
    
    //Atributos
    private int posicion;
    private int anoPublicado;
    private String titulo;
    private String artista;
    private TiposAlbum tipo;
    private float estrellas;
    private int ediciones;
    private int votos = 0;

    //16+4+61+29+19
    private final static int dimension = 238;//129*2 ya que la funcion writeChar de RandomAccessFile utiliza codificacion UTF16 en vez de UTF8 y cada
    //caracter ocupa 2 bytes.
    
    //Objeto centinela para marcar el final de un archivo
    private static Album centinela = new Album(-1,-1,"","",TiposAlbum.ERROR,-1,-1,0); 

    //Metodos Constructores
    public Album() {
        posicion = 0;
        anoPublicado = 0;
        titulo = "";
        artista = "";
        tipo = TiposAlbum.ERROR;
        estrellas = 0;
        ediciones = 0;
        votos = 0;
    }

    public Album(int posicion, int anoPublicado, String titulo, String artista, TiposAlbum tipo, float estrellas, int ediciones) {
        this.posicion = posicion;
        this.anoPublicado = anoPublicado;
        this.titulo = titulo;
        this.artista = artista;
        this.tipo = tipo;
        this.estrellas = estrellas;
        this.ediciones = ediciones;
        votos = 0;
    }

    public Album(int posicion, int anoPublicado, String titulo, String artista, TiposAlbum tipo, float estrellas, int ediciones, int votos) {
        this.posicion = posicion;
        this.anoPublicado = anoPublicado;
        this.titulo = titulo;
        this.artista = artista;
        this.tipo = tipo;
        this.estrellas = estrellas;
        this.ediciones = ediciones;
        this.votos = votos;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setTipo(String tipo) {
        switch (tipo) {
            case "Album              ":
                this.tipo = TiposAlbum.ALBUM;
                break;
            case "Album":
                this.tipo = TiposAlbum.ALBUM;
                break;
            case "Album + Soundtrack ":
                this.tipo = TiposAlbum.ALBUM_SOUNDTRACK;
                break;
            case "Album + Soundtrack":
                this.tipo = TiposAlbum.ALBUM_SOUNDTRACK;
                break;
            case "Album + Compilation":
                this.tipo = TiposAlbum.ALBUM_COMPILATION;
                break;
            case "Album + Live       ":
                this.tipo = TiposAlbum.ALBUM_LIVE;
                break;
                case "Album + Live":
                this.tipo = TiposAlbum.ALBUM_LIVE;
                break;
            default:
                this.tipo = TiposAlbum.ERROR;
        }
    }

    public String getTipo() {
        return tipo.getEtiquetaTipo();
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEdiciones(int ediciones) {
        this.ediciones = ediciones;
    }

    public int getEdiciones() {
        return ediciones;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getVotos() {
        return votos;
    }

    public static int getDimension() {
        return dimension;
    }

    public boolean esValido() {
        if (posicion >= 1 && posicion <= 100) {
            return true;
        }
        return false;
    }
    
    public static boolean esCentinela(Album album){
        if(album.getPosicion()==-1){
            return true;
        }
        return false;
    }
    public static Album getCentinela(){
        return centinela;
    }

    public String toString() {
        String message = "Posicion:" + posicion + "Año Publicado:" + anoPublicado + "Titulo:" + titulo + "Artista:" + artista + "Tipo:"
                + tipo.getEtiquetaTipo() + "Estrellas:" + estrellas + "Ediciones:" + ediciones + "Votos:" + votos;

        return message;
    }
}
