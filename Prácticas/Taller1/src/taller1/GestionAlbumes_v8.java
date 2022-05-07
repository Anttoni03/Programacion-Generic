package taller1;

//Creador: Nahuel Vazquez

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GestionAlbumes_v8 {

    //Atributos
    //Declaracion del atributo viewer que formatea los objetos Album para mostrarlos por consola
    private Viewer viewer;
    //Declaracion e inicializacion del atributo que indica la seleccion que realiza el usuario en el menu
    private int seleccion = -1;
    //Declaracion del objeto File que almacenará, una vez inicializado, el archivo de acceso aleatorio con los votos
    private File ficheroVotos;

    public static void main(String[] args) {
        new GestionAlbumes_v8().start();
    }

    private void start() {
        //inicializacion de viewer
        viewer = new Viewer();
        //inicializacion del ficheroVotos
        ficheroVotos = new File("ficheroVotos.dat");

        //Reinicio del archivo de acceso random para que los valores obtenidos en otras ejecuciones
        //no influyan la ejecución actual
        try {
            if (ficheroVotos.exists()) {
                ficheroVotos.delete();
                ficheroVotos.createNewFile();
            } else {
                ficheroVotos.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        menu();

    }

    public void menu() {

        viewer.menuPrincipal();
        seleccion = LT.readInt();
        //seleccion del menu
        try {

            switch (seleccion) {
                case 0:
                    viewer.finPrograma();
                    break;

                case 1:
                    mostrarAlbumes();
                    inicializarFicheroVotos();
                    menu();
                    break;
                case 2:
                    mostrarFicheroVotos();
                    menu();
                    break;
                case 3:
                    votoManual();
                    menu();
                    break;
                case 4:
                    votosRandom();
                    menu();
                    break;
                case 5:
                    encontrarMejorDisco();
                    menu();
                    break;
                default:
                    System.out.println("La opcion tiene que ser entre 0 y 5");
                    menu();
            }

        } catch (NullPointerException e) {
            System.out.println("Tienes que meter un numero entero. (entre 0 y 5)");
            System.out.println(e.getMessage());
            menu();
        }

    }

    //Funcion que muestra los albumes del archivo "GreatestAlbums.txt"
    public void mostrarAlbumes() {
        FicheroLecturaAlbum fichero = new FicheroLecturaAlbum("GreatestAlbums.txt");
        System.out.println();
        boolean lecturaPosible = fichero.hayContenido();
        if (lecturaPosible) {
            while (lecturaPosible) {
                Album album = fichero.getAlbum();
                viewer.printBasedOnAlbums(album);
                lecturaPosible = fichero.hayContenido();
            }
        } else {
            System.out.println("El fichero \"GreatestAlbums.txt\" esta vacío");
        }
        fichero.close();
    }

    
    //Funcion que inicializa el archivo de acceso arandom con los albumes de "GreatestAlbums.txt"
    public void inicializarFicheroVotos() {
        FitxerAlbums fichero = new FitxerAlbums(ficheroVotos);
        FicheroLecturaAlbum fichero2 = new FicheroLecturaAlbum("GreatestAlbums.txt");
        boolean lecturaPosible = fichero2.hayContenido();
        if (lecturaPosible) {
            while (lecturaPosible) {
                Album album = fichero2.getAlbum();
                fichero.escritura(album);
                lecturaPosible = fichero2.hayContenido();
            }
        } else {
            System.out.println("El fichero \"GreatestAlbums.txt\" esta vacío");
        }
        fichero.escritura(Album.getCentinela());
        fichero2.close();
        fichero.close();
    }

    //Funcion que muestra el contenido del fichero de acceso random con los votos
    public void mostrarFicheroVotos() {
        FitxerAlbums fichero = new FitxerAlbums(ficheroVotos);
        System.out.println("Contenidos del fichero de discos:");
        Album album = fichero.lectura();
        while (!Album.esCentinela(album)) {
            viewer.printAlbumVotes(album);
            album = fichero.lectura();
        }
        fichero.close();
    }

    //Funcion que permite al usuario, votar una cancion del listado y añadirle X votos
    public void votoManual() {
        FitxerAlbums fichero = new FitxerAlbums(ficheroVotos);
        Album album;
        try {
            System.out.print("Numero de disco que se quiere votar [1...100]?");
            int seleccion = LT.readInt();
            if (seleccion < 1 || seleccion > 100) {
                throw new InsercioDadesException("El numero introducido tiene que estar entre 1 y 100 (inclusivo)");
            }
            System.out.print("\nPuntuación [1...10]?");
            int puntuacion = LT.readInt();
            if (puntuacion < 1 || puntuacion > 10) {
                throw new InsercioDadesException("El numero introducido tiene que estar entre 1 y 10 (inclusivo)");
            }
            album = fichero.lectura(seleccion);
            album.setVotos(album.getVotos()+puntuacion);
            fichero.escritura(album, seleccion);
        } catch (InsercioDadesException e) {
            System.out.println("ERROR: " + e.getMessage());
            votoManual();
        } finally {
            fichero.close();
        }
    }

    //Funcion que genera una serie de 10*X votos donde el usuario indica el valor de X
    public void votosRandom() {
        Random rnd = new Random();
        FitxerAlbums fichero = new FitxerAlbums(ficheroVotos);
        Album album;
        try {
            System.out.print("Numero de votaciones que se quiere generar [1...100]?");
            int cantidad = LT.readInt();
            if (cantidad < 1 || cantidad > 100) {
                throw new InsercioDadesException("El numero introducido tiene que estar entre 1 y 100 (inclusivo)");
            }
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Voto: " + (i + 1) + "   ");
                for (int j = 1; j <= 10; j++) {
                    int posicion = rnd.nextInt(100) + 1;
                    System.out.print("[#" + posicion + " - " + j + "] ");

                    album = fichero.lectura(posicion);
                    album.setVotos(album.getVotos()+j);
                    fichero.escritura(album, posicion);
                }
                System.out.println();
            }
        } catch (InsercioDadesException e) {
            System.out.println("ERROR: " + e.getMessage());
            votosRandom();
        } finally {
            fichero.close();
        }
    }
    
    //Funcion que encuentra el primer Disco con la mayor cantidad de votos
    public void encontrarMejorDisco(){
        FitxerAlbums fichero = new FitxerAlbums(ficheroVotos);
        Album album;
        Album mejorAlbum = new Album();
        int mejorPuntuacion = 0;
        for(int i = 1; i<=100; i++){
            album = fichero.lectura();
            if(album.getVotos()>mejorPuntuacion){
                mejorPuntuacion = album.getVotos();
                mejorAlbum = album;
            }
        }
        System.out.println("El mejor album es:");
        viewer.printBestAlbum(mejorAlbum);
        fichero.close();
    }
}
