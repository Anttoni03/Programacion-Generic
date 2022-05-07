/*
CREADOR: TONI ROCA CASTRO
FECHA DE CREACIÓN: 11/04/2022
 */
package talleravaluable1;

import java.io.File;
import java.util.Random;

public class TallerAvaluable1 {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //declaración variable booleana para el control del programa
    private static boolean fin=false;
    //declaración String que represente el nombre del fichero de texto
    private static final String nombreFicheroTexto="GreatestAlbums.txt";
    //declaración String que represente el nombre del fichero Aleatorio
    private static final String nombreFicheroAleatorio="GreatestAlbumsRandom.dat";
    
    //método main
    public static void main(String[] args) {
        while (!fin) {
            new TallerAvaluable1().metodoPrincipal();
        }
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto File para comprobar la existencia del fichero
        //aleatorio
        File file=new File(nombreFicheroAleatorio);
        
        //ACCIONES
        try {
            //bucle programa principal
            while (!fin) {
                //llamada subprograma limpiarPantalla
                limpiarPantalla("");
                //llamada subprograma menu
                menu();
                //tratamiento opción introducida
                switch (LT.readInt()) {
                    case 0: //establecemos a true la variable fin para finalizar
                            fin=true;
                            break;
                    case 1: //llamada subprograma viewFicherotexto
                            viewFicherotexto();
                            break;
                    case 2: //si el fichero aleatorio no existe no podemos
                            //ejecutar la funcionalidad seleccionada
                            if (file.exists()) {
                                //llamada subprograma viewFicheroAleatorio
                                viewFicheroAleatorio();
                            }else {
                                //llamada subprograma noDisponible
                                noDisponible();
                            }
                            break;
                    case 3: //si el fichero aleatorio no existe no podemos
                            //ejecutar la funcionalidad seleccionada
                            if (file.exists()) {
                                //llamada subprograma voto
                                voto();
                            }else {
                                //llamada subprograma noDisponible
                                noDisponible();
                            }
                            break;
                    case 4: //si el fichero aleatorio no existe no podemos
                            //ejecutar la funcionalidad seleccionada
                            if (file.exists()) {
                                 //llamada subprograma votoAleatorio
                                votoAleatorio();
                            }else {
                                //llamada subprograma noDisponible
                                noDisponible();
                            }
                            break;
                    case 5: //si el fichero aleatorio no existe no podemos
                            //ejecutar la funcionalidad seleccionada
                            if (file.exists()) {
                                //llamada subprograma viewBestAlbum
                                viewBestAlbum();
                            }else {
                                //llamada subprograma noDisponible
                                noDisponible();
                            }
                            break;
                    default: //mensaje opción inválida 
                             System.out.println("¡¡¡¡ OPCIÓN NO VÁLIDA !!!!");
                             //llamada subprograma pausa
                             pausa();
                }
            }
        }catch (Exception error) {
            System.err.println("ERROR: "+error.toString());
            //llamada subprograma pausa
            pausa();
        }
    }
    
    //subprograma viewFicherotexto
    private void viewFicherotexto() {
        //DECLARACIONES
        //declaración objeto Album que almacene, de uno en uno, los objetos
        //Album leídos desde el fichero de texto
        Album album;
        //declaración objeto File para comprobar la existencia del fichero
        //aleatorio
        File file=new File(nombreFicheroAleatorio);
        //declaración variable booleana para el control de la sobrescritura
        boolean cont=true;
        
        //ACCIONES
        //comprobamos la existencia del fichero aleatorio
        if (file.exists()) {
            //mensaje usuario sobrescritura
            System.out.println("CUIDADO: si continuas el fichero "
                    +nombreFicheroAleatorio+" se sobrescribirá perdiendose así"
                    + "todos los votos realizados hasta la fecha");
            //llamada subprograma continuar
            cont=continuar();
        }
        //si se decide continuar realizamos el tratamiento correspondiente
        if (cont) {
            //declaración e instanciación objeto FitxerAlbumTextLectura
            FitxerAlbumTextLectura ficheroLectura=new FitxerAlbumTextLectura(nombreFicheroTexto);
            //declaración e instanciación objeto FitxerAlbums
            FitxerAlbums ficheroEscritura=new FitxerAlbums(nombreFicheroAleatorio);
            try {
                //llamada subprograma limpiarPantalla
                limpiarPantalla("       <--- VISUALIZACIÓN FICHERO "+nombreFicheroTexto+" --->");
                //lectura primer objeto del fichero de texto
                album=ficheroLectura.lectura();
                //bucle lectura objetos Album
                while (album!=null) {
                    //visualizamos el objeto leído
                    System.out.println(album.toString());
                    //escribimos el objeto en el fichero aleatorio
                    ficheroEscritura.escritura(album);
                    //lectura siguiente objeto Album
                    album=ficheroLectura.lectura();
                }
                //llamada subprograma pausa
                pausa();
            }catch (Exception error) {
                System.err.println("ERROR: "+error.toString());
            }finally {
                //cerramos los enlaces con los ficheros
                ficheroLectura.cierreEnlaceFichero();
                ficheroEscritura.cierreEnlaceFichero();
            }
        }
    }
    
    //subprograma viewFicheroAleatorio
    private void viewFicheroAleatorio() {
        //DECLARACIONES
        //declaración objeto Album que almacene, de uno en uno, los objetos
        //Album leídos desde el fichero aleatorio
        Album album;
        //declaración e instanciación objeto FitxerAlbums
        FitxerAlbums ficheroLectura=new FitxerAlbums(nombreFicheroAleatorio);
        
        //ACCIONES
        try {
            //llamada subprograma limpiarPantalla
            limpiarPantalla("       <--- VISUALIZACIÓN FICHERO "+nombreFicheroAleatorio+" --->");
            //lectura primer objeto del fichero aleatorio
            album=ficheroLectura.lectura();
            //bucle lectura objetos Album 
            while (album!=null) {
                //visualizamos el objeto leído
                System.out.println(album.toString_V2());
                //lectura siguiente objeto Album
                album=ficheroLectura.lectura();
            }
        }catch (Exception error) {
            System.err.println("ERROR: "+error.toString());
        }finally {
            //cerramos los enlaces con los ficheros
            ficheroLectura.cierreEnlaceFichero();
        }
        //llamada subprograma pausa
        pausa();
    }
    
    //subprograma voto
    private void voto() {
        //DECLARACIONES
        //declaración objeto Album que almacene el objeto Album a leer
        Album album;
        //declaración variable int que almacene la posición del Album en el 
        //fichero aleatorio y otra variable que almacene la puntuación
        int posicion,puntuacion;
        //declaración variable booleana para control si se desea continuar con
        //las votaciones
        boolean cont=true;
        //declaración constantes tipo int que representen la puntuación mínima
        //y máxima que se pueden realizar en las votaciones
        final int PUNT_MIN=1,PUNT_MAX=10;
        
        //ACCIONES
        //bucle votación
        while (cont) {
            //declaración e instanciación objeto FitxerAlbums
            FitxerAlbums fichero=new FitxerAlbums(nombreFicheroAleatorio);
            try {
                //llamada subprograma limpiarPantalla
                limpiarPantalla("<<<<<< NUEVA VOTACIÓN >>>>>>");
                //mensaje introducción posición del objeto Album a votar
                System.out.print("Número de disco que deseas votar [1..100]? ");
                //lectura posición introducida
                posicion=LT.readInt();
                //comprobamos que la posición es un número de una posición
                //existente (al realizar el método lectura de una posición
                //incorrecta salta la excepción no predefinida InsercioDadesException
                //, a pesar de que ya se trate la excepción lo compruebo con
                //anterioridad para que la excepción salte antes y no se ejecute 
                //el resto de funciones por un tema de visualización en la 
                //ventana output)
                if ((posicion<1)||(posicion>100)) {
                    //invocamos la excepción no predefinida InsercioDadesException
                    throw new InsercioDadesException("SE INTRODUJO UNA POSICIÓN"
                            + " FUERA DEL RANGO ESTABLECIDO");
                }
                //mensaje introducción puntuación a sumar
                System.out.print("Puntuación ["+PUNT_MIN+".."+PUNT_MAX+"]: ");
                //lectura puntuación
                puntuacion=LT.readInt();
                //comprobamos que la puntuación es un número del uno al diez
                if ((puntuacion<PUNT_MIN)||(puntuacion>PUNT_MAX)) {
                    //invocamos la excepción no predefinida InsercioDadesException
                    throw new InsercioDadesException("SE INTRODUJO UNA PUNTUACIÓN"
                            + " FUERA DEL RANGO ESTABLECIDO");
                }
                //leemos el objeto Album cuya posición ha sido introducida
                //por teclado
                album=fichero.lectura(posicion);
                //actualizamos el atributo votos
                album.updateVotos(puntuacion);
                //visualización por pantalla
                System.out.println("#"+album.getPosicion()+" votos: "
                        +album.getNumVotos()+" para "+album.getArtista());
                //escritura en el fichero del objeto una vez lo hemos
                //actualizado
                fichero.escritura(album, posicion);
            }catch (InsercioDadesException error) {
                System.err.println("ERROR: "+error.toString());
            }catch (Exception error) {
                System.err.println("ERROR: "+error.toString());
            }finally {
                //cerramos los enlaces con los ficheros
                fichero.cierreEnlaceFichero();
            }
            //llamada subprograma cont
            cont=continuar();
        }
    }
    
    //subprograma votoAleatorio
    private void votoAleatorio() {
        //DECLARACIONES
        //declaración objeto Album que almacene, de uno en uno, los objetos
        //Album a votar
        Album album;
        //declaración e instanciación objeto FitxerAlbums
        FitxerAlbums fichero=new FitxerAlbums(nombreFicheroAleatorio);
        //declaración constante tipo int que almacene la cantidad de puntuaciones
        //que se producen en una votación
        final int NUM_PUNTUACIONES=10;
        //declaración constantes tipo int que representen la cantidad mínima
        //y máxima de votaciones aleatorias que se pueden realizar
        final int VOT_MIN=1,VOT_MAX=100;
        //declaración variable int que almacene el número de votaciones que
        //desea realizar el usuario
        int numVotaciones;
        //declaración objeto Random para realizar la votación aleatoria
        Random random=new Random();
        
        //ACCIONES
        try {
            //llamada subprograma limpiarPantalla
            limpiarPantalla("<<<<<< VOTACIONES >>>>>>");
            //mensaje usuario introducción número de votaciones a realizar
            System.out.print("Número de votaciones que desea generar ["
                    +VOT_MIN+".."+VOT_MAX+"]? ");
            //lectura número de votaciones
            numVotaciones=LT.readInt();
            //comprobamos si se ha introducido un valor válido
            if ((numVotaciones<VOT_MIN)||(numVotaciones>VOT_MAX)) {
                //invocamos la excepción no predefinida
                throw new InsercioDadesException("SE INTRODUJO UN NÚMERO DE"
                        + " VOTACIONES FUERA DEL RANGO ESTABLECIDO");
            }else {
                //bucle votaciones
                for (int i=1;i<=numVotaciones;i++) {
                    //declaración variable String para concatenar el String a
                    //visualizar
                    String votacionString="Voto: "+i+"  ";
                    //bucle generación números aleatorios y asignación puntuación
                    for (int j=1;j<=NUM_PUNTUACIONES;j++) {
                        //asignación a una variable entera del número aleatorio
                        int pos=random.nextInt(100)+1;
                        //lectura objeto Album en la posición dada
                        album=fichero.lectura(pos);
                        //actualizamos su atributo votos
                        album.updateVotos(j);
                        //lo rescribimos en el fichero
                        fichero.escritura(album, pos);
                        //lo concatenamos en el String a visualizar
                        votacionString+="[#"+pos+" - "+j+"]  ";
                    }
                    //visualizamos el String
                    System.out.println(votacionString);
                }
            }
        }catch (InsercioDadesException error) {
            System.err.println("ERROR: "+error.toString());
        }catch (Exception error) {
            System.err.println("ERROR: "+error.toString());
        }finally {
            //cerramos los enlaces con los ficheros
            fichero.cierreEnlaceFichero();
        }
        //llamada subprograma pausa
        pausa();
    }
    
    //subprograma viewBestAlbum
    private void viewBestAlbum() {
        //declaración objeto Album que almacene, de uno en uno, los objetos
        //Album a leer
        Album album;
        //declaración e instanciación objeto FitxerAlbums
        FitxerAlbums fichero=new FitxerAlbums(nombreFicheroAleatorio);
        //declaración objeto Album que represente el objeto Album más votado
        Album albumPopular=new Album();
        
        //ACCIONES
        try {
            //llamada subprograma limpiarPantalla
            limpiarPantalla("<<<<<< ÁLBUM MÁS VOTADO >>>>>>");
            //lectura primer objeto del fichero
            album=fichero.lectura();
            //como no hemos leído más objetos album el primero que leemos es el
            //más popular, por ello lo copiamos 
            albumPopular.copiarAlbum(album);
            //bucle lectura objetos Album
            while (album!=null) {
                //comprobamos que el objeto Album es más votado que el objeto
                //Album más votado hasta el momento
                if (album.masVotadoQue(albumPopular)) {
                    //copiamos el album leído como el album más votado
                    albumPopular.copiarAlbum(album);
                }
                //lectura siguiente objeto Album del fichero
                album=fichero.lectura();
            }
            //visualizamos el album más votado
            System.out.println(albumPopular.toString_V3());
        }catch (Exception error) {
            System.err.println("ERROR: "+error.toString());
        }finally {
            //cerramos los enlaces con los ficheros
            fichero.cierreEnlaceFichero();
        }
        //llamada subprograma pausa
        pausa();
    }
    
    //subprograma menu
    private void menu() {
        System.out.println("     <----- MENU PRINCIPAL ----->");
        System.out.println("[1] VISUALIZACIÓN CONTENIDO FICHERO DE TEXTO Y"
                + " INICIALIZACIÓN FICHERO DE VOTOS");
        System.out.println("[2] VISUALIZACIÓN CONTENIDO FICHERO DE VOTOS");
        System.out.println("[3] VOTO MANUAL");
        System.out.println("[4] SIMULACIÓN VOTACIONES");
        System.out.println("[5] VISUALIZACIÓN MEJOR ALBUM");
        System.out.println("[0] SALIR");
        System.out.print("     Opción ---> ");
    }
    
    //subprograma limpiarPantalla
    private void limpiarPantalla(String dato) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+dato);
    }
    
    //subprograma pausa
    public void pausa() {
        System.out.print("[ CONTINUAR --> pulsar return ] ");         
        try {  
           LT.readChar();     
        } catch (Exception error) {
           System.out.println("ERROR: "+error.toString());
        }  
    }
    
    //subprograma cont
    private boolean continuar() {
       //DECLARACIONES
       //declaración variable char para obtener la respuesta por teclado
       char respuesta='n';
       
       //ACCIONES
       try {
           //mensaje para cont o no
           System.out.print("CONTINUAR (s/n):  "); 
           //lectura respuesta
           respuesta=LT.readChar();        
       }catch (Exception error) {
           System.out.println("ERROR CONTINUAR: "+error.toString());
       }
       return ((respuesta=='s') || (respuesta=='S'));
    }
    
    //subprograma noDisponible (para comprobar que funciona elimina el fichero
    //random y prueba a pulsar cualquier opción que no sea la 1)
    private void noDisponible() {
        System.out.println("El fichero "+nombreFicheroAleatorio+" no existe"
                + " todavía, por ello no se puede realizar la funcionalidad"
                + " seleccionada. Pulse OPCION [1] en el programa principal"
                + " para poder utilizar las otras opciones.");
        //llamada subrpograma pausa
        pausa();
    }
}
