
/*
CREADOR. TONI ROCA CASTRO
CLASE Album

Dimensión en bytes de cada atributo de la clase Album
pos ---> 4 bytes
añoEdicion ---> 4 bytes
titulo ---> 40 caracteres * 2 bytes = 80 bytes
artista ---> 40 caracteres * 2 bytes = 80 bytes
tipoAlbum ---> 20 caracteres * 2 bytes = 40 bytes
numEstrellas ---> 4 bytes
numEdiciones  ---> 4 bytes
numVotos ---> 4 bytes

 */
package talleravaluable1;

public class Album {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //declaración atributo de objeto que represente la posición dentro de la
    //lista del objeto Album
    private int pos;
    //declaración atributo de objeto que represente el año de edición del objeto
    //Album
    private int añoEdicion;
    //declaración atributo de objeto que represente el título del objeto Album
    private String titulo;
    //declaración atributo de objeto que represente el artista o grupo del
    //objeto Album
    private String artista;
    //declaración atributo de objeto que represente el tipo de album del objeto
    //Album
    private String tipoAlbum;
    //declaración atributo de objeto que represente el número de estrellas del
    //objeto estrella
    private float numEstrellas;
    //declaración atributo de objeto que represente el número de ediciones del
    //objeto Album
    private int numEdiciones;
    //declaración atributo de objeto que represente el número de votos del
    //objeto Album
    private int numVotos=0;
    //declaración atributo de clase que represente la dimensión en bytes de un
    //objeto Album
    private static final int DIMENSION=220;
    
    //MÉTODOS CONSTRUCTORES
    public Album() {
        numVotos=0;
    }
    
    //MÉTODOS FUNCIONALES
    //método toString, convierte un objeto Album a String
    @Override
    public String toString() {
        return "Album{num="+pos+", año="+añoEdicion+", impreso="+numEdiciones
                + ", titulo="+titulo+", artista="+artista+", tipo="+tipoAlbum
                + ", estrellas="+numEstrellas+"}";
    }
    
    //método toString_V2, convierte un objeto Album a String
    public String toString_V2() {
        return "# "+pos+"  votos: "+numVotos+"  "+titulo+"  Artista: "+artista
                +"  año: "+añoEdicion;
    }
    
    //método toString_V3, convierte un objeto Album a String
    public String toString_V3() {
        return "Album{num="+pos+", año="+añoEdicion+", impreso="+numEdiciones
                + ", votos="+numVotos+ ", titulo="+titulo+", artista="
                +artista+", tipo="+tipoAlbum+ ", estrellas="+numEstrellas+"}";
    }
    //MÉTODOS setters
    //método setPosicion
    public void setPosicion(int dato) {
        pos=dato;
    }
    //método setAñoEdicion
    public void setAñoEdicion(int dato) {
        añoEdicion=dato;
    }
    //método setTitulo
    public void setTitulo(String dato) {
        titulo=dato;
    }
    //método setArtista
    public void setArtista(String dato) {
        artista=dato;
    }
    //método setTipoAlbum
    public void setTipoAlbum(String dato) {
        tipoAlbum=dato;
    }
    //método setNumEstrellas
    public void setNumEstrellas(float dato) {
        numEstrellas=dato;
    }
    //método setNumEdiciones
    public void setNumEdiciones(int dato) {
        numEdiciones=dato;
    }
    //método setNumVotos
    public void setNumVotos(int dato) {
        numVotos=dato;
    }
    
    //MÉTODOS getters
    //método getDIMENSION
    public static int getDIMENSION() {
        return DIMENSION;
    }
    //método getPosicion
    public int getPosicion() {
        return pos;
    }
    //método getAñoEdicion
    public int getAñoEdicion() {
        return añoEdicion;
    }
    //método getTitulo
    public String getTitulo() {
        return titulo;
    }
    //método getArtista
    public String getArtista() {
        return artista;
    }
    //método getTipoAlbum
    public String getTipoAlbum() {
        return tipoAlbum;
    }
    //método getNumEstrellas
    public float getNumEstrellas() {
        return numEstrellas;
    }
    //método getNumEdiciones
    public int getNumEdiciones() {
        return numEdiciones;
    }
    //método getNumVotos
    public int getNumVotos() {
        return numVotos;
    }
    
    //método updateVotos
    public void updateVotos(int newVotos) {
        numVotos=numVotos+newVotos;
    }
    
    //método copiarAlbum, lleva a cabo la copia de los atributos de un objeto
    //album pasado por parámetro en el objeto que llama al método
    public void copiarAlbum(Album album) {
        //copiamos todos los atributos
        pos=album.getPosicion();
        añoEdicion=album.getAñoEdicion();
        titulo=album.getTitulo();
        artista=album.getArtista();
        tipoAlbum=album.getTipoAlbum();
        numEstrellas=album.getNumEstrellas();
        numEdiciones=album.getNumEdiciones();
        numVotos=album.getNumVotos();
    }
    
    //método masVotadoQue, que devuelve true cuando el objeto pasado por parámetro
    //es menos votado que el objeto Album que llama al método. Además si ambos
    //objetos contienen el mismo número de votos se comprueba quien ocupa una
    //posición más baja en la lista (más baja es que esta mejor en el top 100)
    public boolean masVotadoQue(Album album) {
        //ACCIONES
        return ((numVotos>album.getNumVotos())||((numVotos==album.getNumVotos())&&(pos<album.getPosicion())));
    }
}
