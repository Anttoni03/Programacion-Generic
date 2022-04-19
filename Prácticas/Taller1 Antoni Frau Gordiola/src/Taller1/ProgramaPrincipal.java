
package Taller1;
import java.io.*;

public class ProgramaPrincipal {
    
    //DECLARACIÓN DE ATRIBUTOS
    //Atributo de clase que guarda el nombre del fichero de albums original
    private static final String FICHERO_ALBUMS = "GreatestAlbums.txt";
    //Atributo de clase que guarda el nombre del fichero de albums con voto
    private static final String FICHERO_VOTOS = "AlbumsVotes.dat";
    
    
    //MÉTODOS
    //Método main del programa principal
    public static void main(String[] args)
    {
        new ProgramaPrincipal().metodoPrincipal();
    }
    
    //Método metodoPrincipal que gestiona las opciones del usuario y ejecuta
    //los métodos que sean necesarios según la opción
    private void metodoPrincipal()
    {
        int opcion = 0;
        //Bucle while que repite la gestión del menú principal mientras no se
        //decida seleccionar la opción de salida
        do
        {
            try{
                opcion = menuPrincipal();
                comprobarOpcion(opcion);
                //Estructura switch para ejecutar la opción de las que dispone
                //el usuario
                switch (opcion) {
                    case 1:
                        titulo("CONTENIDO DE FICHERO DE ALBUMS");
                        contenidoFicheroAlbums();
                        break;
                    case 2:
                        titulo("CONTENIDO DE FICHERO DE ALBUMS CON VOTOS");
                        contenidoFicheroAleatorio();
                        break;
                    case 3:
                        titulo("VOTACIÓN MANUAL");
                        votoManual();
                        break;
                    case 4:
                        titulo("VOTACIÓN ALEATORIA");
                        simularVotos();
                        break;
                    case 5:
                        titulo("MEJOR ÁLBUM");
                        calcularMejorAlbum();
                        break;
                }
                //Mensaje para continuar si es que no se finaliza el programa
                if (opcion != 0)
                    continuar();
            } catch (NumberFormatException e){
                System.err.println("ERROR: " + e.toString());
            } catch (InsercionDatosException e){
                System.err.println("ERROR: " + e.toString());
            } catch (Exception e){
                System.err.println("ERROR: " + e.toString());
            }
        } while (opcion != 0);
    }
    
    //Método contenidoFicheroAlbums que muestra el contenido del fichero de
    //albums original a nivel de objetos Album y lo registra en otro fichero
    //con el atributo votos para usarlos
    private void contenidoFicheroAlbums()
    {
        //Borra el fichero con albums y votos si ya existía previamente
        File f = new File("AlbumsVotes.dat");
        if (f.exists()) f.delete();
        
        //Inicialización de los ficheros con albums original y con votos
        FicheroAlbumLectura ficheroLectura = new FicheroAlbumLectura(FICHERO_ALBUMS);
        FicheroAlbumInOut ficheroEscritura = new FicheroAlbumInOut(FICHERO_VOTOS);
        //Declaración del objeto Album para leerlo tratarlo y el contador para
        //la cantidad de objetos Album del fichero de albums original
        Album album;
        int cantidadObjetos;
        
        //Registrar la cuenta de los objetos del fichero de albums original
        //para realizar la lectura completa de este
        cantidadObjetos = ficheroLectura.contarObjetos();
        
        //Bucle for que realiza la lectura de la cantidad de objetos registrada
        //del fichero de albums, mostrarlos por pantalla y guardarlos en el
        //fichero con sus datos y los votos
        for (int i = 0; i < cantidadObjetos; i++) {
            album = ficheroLectura.lecturaAlbum();
            System.out.println(album.toString());
            AlbumVotos albumVotos = new AlbumVotos();
            albumVotos.conversion(album);
            ficheroEscritura.escritura(albumVotos);
        }
        
        //Cerrar los enlaces de ambos ficheros
        ficheroLectura.cerrarEnlace();
        ficheroEscritura.cerrarEnlace();
    }
    
    //Método contenidoFicheroAleatorio que muestra el contenido del fichero de
    //albums con el atributo votos
    private void contenidoFicheroAleatorio()
    {
        //Inicialización del fichero de albums con votos
        FicheroAlbumInOut fichero = new FicheroAlbumInOut(FICHERO_VOTOS);
        //Declaración del objeto AlbumVotos para visualizar los albums leídos
        AlbumVotos album;
        
        //Bucle while de recorrido para la lectura y visualización por pantalla
        //de todos los objetos AlbumVotos del fichero indicado
        album = fichero.lectura();
        while (album != null && album.getPosicion() != 0)
        {
            System.out.println(album.toString());
            album = fichero.lectura();
        }
        
        //Cerrar el enlace del fichero de albums con votos
        fichero.cerrarEnlace();
    }
    
    //Método votoManual que pide al usuario una posición de álbum y aplica una
    //puntuación también indicada para aplicársela a dicho álbum
    private void votoManual()
    {
        //Inicialización del fichero de albums con votos
        FicheroAlbumInOut fichero = new FicheroAlbumInOut("AlbumsVotes.dat");
        //Inicialización de un objeto Voto para facilitar la votación
        Voto voto = new Voto();
        
        try{
            //Lectura y aplicación de 1 voto al fichero, creado por el usuario y
            //cambiado en el fichero de albums con votos de acceso aleatorio
            voto.lecturaManual();
            fichero.votar(voto);

            //Lectura del objeto cambiado para visualizarlo por pantalla
            AlbumVotos album = fichero.lectura(voto.getPosicion());
            System.out.println(album.mostrarActualizado());
        } catch (InsercionDatosException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        } finally {
            //Cerrar el enlace con el fichero de albums con votos
            fichero.cerrarEnlace();
        }
    }
    
    //Método simularVotos encargado de realizar una cantidad introducida por el
    //usuario de votaciones, aleatorias, en la que cada votación cuenta con
    //10 votos individuales
    private void simularVotos()
    {
        //Inicialización del fichero de albums con votos
        FicheroAlbumInOut fichero = new FicheroAlbumInOut("AlbumsVotes.dat");
        //Declaración de la variable votaciones para registrar la cantidad de 
        //votaciones a realizar
        int votaciones;
        
        //Indicar la cantidad de votaciones y a través del usuario y realizar
        //un bucle con las iteraciones indicadas
        System.out.print("Número de votaciones que quieres generar [1..100]? ");
        try{
            votaciones = LT.readInt();
            comprobarVotaciones(votaciones);
            
            for (int i = 1; i <= votaciones; i++)
            {
                //Bucle con 10 iteraciones en las que se genera un objeto Voto
                //y se carga con valores aleatorios para posteriormente,
                //visualizarlas por pantalla y guardar los cambios del fichero
                System.out.print("Vot: "+i+"\t ");
                for (int j = 1; j <= 10; j++)
                {
                    Voto voto = new Voto();
                    voto.lecturaAleatoria(j);
                    fichero.votar(voto);
                    System.out.print(voto.toString()+" ");
                }
                espaciado(1);
            }
        } catch (InsercionDatosException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (NumberFormatException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        } finally {
            fichero.cerrarEnlace();
        }
    }

    //Método calcularMejorAlbum encargado de recorrer el fichero de albums con
    //votos e indicar visualizando por pantalla el álbum con mayor votos
    private void calcularMejorAlbum()
    {
        //Inicialización del fichero de albums con votos
        FicheroAlbumInOut fichero = new FicheroAlbumInOut("AlbumsVotes.dat");
        //Declaración de 2 objetos AlbumVotos para resgistrar los albums leídos
        //del fichero y el leído con mayor votos respectivamente
        AlbumVotos album, mejorAlbum;
        
        //Inicializar los objetos AlbumVotos para empezar el recorrido
        album = fichero.lectura();
        mejorAlbum = album.copiar();
        
        //Bucle while de recorrido para buscar en todo el fichero de albums
        //cuál tiene mayor votos comparando con el de mayor votos encontrado
        while (album != null && album.getPosicion() != 0)
        {
            if (mejorAlbum.getVotos() < album.getVotos())
                mejorAlbum = album.copiar();
            
            album = fichero.lectura();
        }
        
        //Impresión por pantalla del mejor álbum encontrado
        System.out.println("El mejor álbum es:");
        System.out.println(mejorAlbum.mostrarCompleto());
        
        //Cerrar el enlace con el fichero de albums con votos
        fichero.cerrarEnlace();
    }
    
    
    
    //Método menuPrincipal que se engarga de visualizar y recibir la opción de
    //la acción a ejecutar por el usuario
    private int menuPrincipal()
    {
        System.out.print("Gestión de los discos que se deberían de escuchar\n\n"
                + "1. Ver el contenido del fichero de texto e inicializar el fichero de votos\n"
                + "2. Ver el contenido del fichero de votos de acceso aleatorio\n"
                + "3. Un voto manual\n"
                + "4. Simula votos aleatorios\n"
                + "5. Calcula el mejor álbum\n"
                + "0. Salir\n\n"
                + "\tInserta un opción: ");
        return LT.readInt();
    }
    
    //Método comprobarOpcion que lanza una excepción personalizada si no cumple
    //las indicaciones de las opciones válidas entre el menú principal
    private void comprobarOpcion(int nombre) throws InsercionDatosException
    {
        if (nombre < 0 || 5 < nombre) throw new InsercionDatosException("ERROR DE OPCIÓN NO VÁLIDA");
    }
    //Método comprobarVotaciones que lanza una excepción personalizada si no
    //comple las indicaciones de la cantidad de votaciones a realizar
    private void comprobarVotaciones(int numero) throws InsercionDatosException
    {
        if (numero < 0 || 100 < numero) throw new InsercionDatosException("ERROR DE OPCIÓN NO VÁLIDA");
    }
    
    //Método continuar que pausa el programa hasta pulsar la tecla 'enter'
    private void continuar()
    {
        espaciado(2);
        System.out.print("<> Presiona \'intro\' para continuar · ");
        LT.readChar();
        espaciado(25);
    }
    
    //Método espaciado que genera los espacios en pantalla que se le indique
    private void espaciado(int i)
    {
        for (int j = 0; j < i; j++) {
            System.out.println("");
        }
    }
    
    //Método titulo que muestra un título con los espaciados correspondientes
    private void titulo(String texto)
    {
        espaciado(2);
        System.out.print("<<<<<   "+texto+"   >>>>>");
        espaciado(2);
    }
}