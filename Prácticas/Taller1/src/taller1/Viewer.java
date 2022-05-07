package taller1;

//Creador: Nahuel Vazquez

public class Viewer {
    
    //funcion que muestra las opciones del menu
    public void menuPrincipal() {
        System.out.println("-----------------------");
        System.out.println("1. Ver el contenido del fichero de texto e inicializa el fichero de votos.");
        System.out.println("2. Ver el contenido del fichero de votos de acceso aleatorio.");
        System.out.println("3. Un voto manual.");
        System.out.println("4. Simulacion de votos aleatorios.");
        System.out.println("5. Calcular el mejor album.");
        System.out.println("0. Salir.");
        System.out.println("");
        System.out.print("Seleccionar opcion: ");
    }

    //Mensaje de despedida
    void finPrograma() {
        System.out.println("Gracias por usar Gestion de Albumes V8!");
    }
    
    //Funcion que muestra el disco pasado por parametro mostrando ciertos atributos
    public void printBasedOnAlbums(Album album){
        System.out.println("Album{num="+album.getPosicion()+", any="+album.getAnoPublicado()+", impres="+album.getEdiciones()+", titol="+
                album.getTitulo()+", artista="+album.getArtista()+", tipus="+album.getTipo()+", estrelles="+album.getEstrellas()+"}");
    }
    
    //Funcion que muestra el disco pasado por parametro mostrando ciertos atributos
    public void printBestAlbum(Album album){
        System.out.println("AlbumVotos{num="+album.getPosicion()+", año="+album.getAnoPublicado()+
                ", imprimidos="+album.getEdiciones()+", votos="+album.getVotos()+
                ", titulo="+album.getTitulo()+", artista="+album.getArtista()+", tipo="+
                album.getTipo()+", estrellas="+album.getEstrellas());
    }
    
    //funcion que muestra un disco con un formato especial
    public void printAlbumVotes(Album album){
        final int INDICE_POSICION = 2;
        final int INDICE_VOTOS = 13;
        final int INDICE_TITULO = 17;
        final int INDICE_ARTISTA = 88;
        final int INDICE_ANO = 123;
        char[] arrayAlbum = "#     votos:                                                                   Artista:                               año:     ".toCharArray();
        
        //Rellenar Array con la posicion
        String posicion = Integer.toString(album.getPosicion());
        for(int i = INDICE_POSICION; i<(INDICE_POSICION+posicion.length());i++){
            arrayAlbum[i]=posicion.toCharArray()[i-INDICE_POSICION];
        }
        //Rellenar Array con la votos
        String votos = Integer.toString(album.getVotos());
        for(int i = INDICE_VOTOS; i<(INDICE_VOTOS+votos.length());i++){
            arrayAlbum[i]=votos.toCharArray()[i-INDICE_VOTOS];
        }
        //Rellenar Array con la Titulo
        for(int i = INDICE_TITULO; i<(INDICE_TITULO+album.getTitulo().length());i++){
            arrayAlbum[i]=album.getTitulo().toCharArray()[i-INDICE_TITULO];
        }
        //Rellenar Array con la artista
        for(int i = INDICE_ARTISTA; i<(INDICE_ARTISTA+album.getArtista().length());i++){
            arrayAlbum[i]=album.getArtista().toCharArray()[i-INDICE_ARTISTA];
        }
        //Rellenar Array con la año
        String ano = Integer.toString(album.getAnoPublicado());
        for(int i = INDICE_ANO; i<(INDICE_ANO+ano.length());i++){
            arrayAlbum[i]=ano.toCharArray()[i-INDICE_ANO];
        }
        for(int i = 0; i<arrayAlbum.length; i++){
            System.out.print(arrayAlbum[i]);
        }
        System.out.println();
    }
    
}
