/*
Autor: Jaume Cantallops Comas
 */
package taller1;



public class Clase_Album {
       
    //Atributs de la classe Clase_Álbum
    //atribut d'objecte tipus int 
    private int posicion_en_la_lista;
    //atribut d'objecte tipus int 
    private int año_edicion;
    //atribut d'objecte tipus string
    private String titulo;
    //atribut d'objecte tipus string 
    private String artista;
    //atributo constante de objeto tipo string
    private String tipos_Album;
    //atribut d'objecte tipus double
    private double estrellas;
    //atribut d'objecte tipus int
    private int ediciones;
    //atribut constant de classe que respresentarà el número total de bytes d'un objecte Clase_Album
    //posicion_en_la_lista << 4 bytes
    //año_edicion << 4 bytes
    //titol << 64 bytes
    //artista << 32 bytes
    //estrellas << 8 bytes
    //ediciones << 4
    //tipos_Album << 32
    //votos << 4
    private static final int DIMENSION = 280;
    
    private int votos; 
    
    
    //MÈTODES 
    //Mètode contructors
    //inicialitzam l'atribut "votos" a 0
    public Clase_Album() {
        votos = 0;
    }
    
    public Clase_Album(int i,int añ,String t,String a,String ti,double e,int ed){
        
        posicion_en_la_lista = i;
        año_edicion = añ;
        titulo = t;
        artista = a;
        tipos_Album = ti;
        estrellas = e;
        ediciones = ed;
        votos = 0;
    }
    
    //Mètodes funcionals
    //mètode toString, passa tots els atributs de l'objecte a una string perquè 
    //es visualitzi a la pantalla
    public String tostring(){
        
        return "Album{num="+posicion_en_la_lista+", impres="+año_edicion+", titol="
                +titulo+", artista="+artista+", tipus="+tipos_Album+", estrelles="
                +estrellas+"}";
    }
    
    //mètode toString que passa els atributs necessaris per (l'opció 2) de l'objecte
    //a una string perquè es visualitzi a la pantalla
    public String toString2(){
        
        return "# "+posicion_en_la_lista+"    vots: "+votos+"   "+titulo+"                                  artista: "
                +artista+"                              any: "+año_edicion;
    }
    
    //mètode toString que passa els atributs necessaris per (l'opció 5) de l'objecte
    //a una string perquè es visualitzi a la pantalla    
    //mètdode de classe que retorna la dimenció (en bytes) d'un objecte de la classe
    public String toString5(){
        return "AlbumVots{num="+posicion_en_la_lista+"  ,any="+año_edicion+"   impres="+
                +ediciones+",   votos="+votos+",   titol="+titulo+",   artista="+artista;
    }
    public static int getDIMENSION(){
        return DIMENSION;
    }
    
    //mètodes set que passant per paràmentre un int, double o strign l'asigneran
    //a l'atribut corresponent
    public void setPosicion_en_la_lista(int i){
        posicion_en_la_lista = i;
    }
    
    public void setAño_edicion(int i){
        año_edicion = i;
    }
    
    public void setTitulo(String t){
        titulo = t;
    }
    
    public void setArtista(String a){
        artista = a;
    }
    
    public void setTipo_Album(String t){
        tipos_Album = t;
    }
    
    public void setEsterllas(double e){
        estrellas = e;
    }
    
    public void setEdiciones(int i){
        ediciones = i;
    }
    
    public void setVotos(int i){
        votos = i;
    }
    
    //mètodes get que serviran per obtenir el contingut d'un atribut de l'objecte
    public int getPosicion_en_la_lista(){
        return posicion_en_la_lista;
    }
    
    public int getAño_edicion(){
        return año_edicion;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getArtista(){
        return artista;
    }
    
    public String getTipo_album(){
        return tipos_Album;
    }
   
    public double getEstrellas(){
        return estrellas;
    }
    
    public int getEdiciones(){
        return ediciones;
    }
    
    public int getVotos(){
        return votos;
    }
}
