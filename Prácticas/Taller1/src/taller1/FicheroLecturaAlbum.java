package taller1;

//Creador: Nahuel Vazquez

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

//Clase que permite la lectura secuencial de objetos album desde un fichero
public class FicheroLecturaAlbum {

    //DECLARACIONES ATRIBUTOS
    //Declaración atributo de clase constante entero que representa el final de
    //un fichero
    private static final int FINAL = -1;
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control RETURN
    private static final char RETURN = '\r';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final char SALTO_LINEA = '\n';

    private Album albumLeido = new Album();

    private BufferedReader albumes;

    private String text;

    //Constructor
    public FicheroLecturaAlbum(String nombreFichero) {
        boolean ficheroEncontrado = false;
        do {
            try {
                albumes = new BufferedReader(new FileReader(nombreFichero));
                ficheroEncontrado = true;
            } catch (FileNotFoundException ex) {
                System.out.println("Fichero de albumes \"GreatestAlbums.txt\" no ha sido encontrado.");
                System.out.println("Coloca dicho archivo en la carpeta del proyecto y aprieta retrun");
                LT.readChar();
            }
        } while (!ficheroEncontrado);
    }

    //metodos funcionales
    //metodo que permite la lectura de un objeto album desde un fichero
    public Album getAlbum() {
        try {
            //text=albumes.readLine();
            int posicion = Integer.parseInt(text);
            albumLeido.setPosicion(posicion);

            text = albumes.readLine();
            int anoPublicado = Integer.parseInt(text);
            albumLeido.setAnoPublicado(anoPublicado);

            text = albumes.readLine();
            String titulo = text;
            albumLeido.setTitulo(titulo);

            text = albumes.readLine();
            String artista = text;
            albumLeido.setArtista(artista);

            text = albumes.readLine();
            String tipo = text;
            albumLeido.setTipo(tipo);
            

            text = albumes.readLine();
            float estrellas = Float.parseFloat(text);
            albumLeido.setEstrellas(estrellas);

            text = albumes.readLine();
            int ediciones = Integer.parseInt(text);
            albumLeido.setEdiciones(ediciones);
        } catch (IOException ex) {
            ex.getMessage();
        }
        return albumLeido;
    }

    //funcion que devuelve true si hay contenido en el archivo y aun no se ha llegado al final de este
    public boolean hayContenido() {
        try {
            text = albumes.readLine();
            return albumes.ready() && text != null;
        } catch (IOException ex) {
            ex.getMessage();
        }

        return false;
    }
    
    //funcion que permite cerrar el enlace con el fichero
    public void close(){
        try {
            albumes.close();
        } catch (IOException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
    }
}
