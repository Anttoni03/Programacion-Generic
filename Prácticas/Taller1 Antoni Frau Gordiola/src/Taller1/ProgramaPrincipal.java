
package Taller1;
import java.io.*;

public class ProgramaPrincipal {
    
    public static void main(String[] args)
    {
        new ProgramaPrincipal().metodoPrincipal();
    }
    
    //Método metodoPrincipal que gestiona las opciones del usuario y ejecuta
    //los métodos que sean necesarios
    private void metodoPrincipal()
    {
        int opcion = 0;
        do
        {
            try{
                opcion = menuPrincipal();
                comprobarOpcion(opcion);
                switch (opcion) {
                    case 1:
                        titulo("CONTENIDO DE FICHERO DE ALBUMS");
                        contenidoFicheroAlbums();
                        continuar();
                        break;
                    case 2:
                        titulo("CONTENIDO DE FICHERO DE ALBUMS CON VOTOS");
                        contenidoFicheroAleatorio();
                        continuar();
                        break;
                    case 3:
                        titulo("VOTACIÓN MANUAL");
                        votoManual();
                        continuar();
                        break;
                    case 4:
                        titulo("VOTACIÓN ALEATORIA");
                        simularVotos();
                        continuar();
                        break;
                    case 5:
                        titulo("MEJOR ÁLBUM");
                        calcularMejorAlbum();
                        continuar();
                        break;
                }
            } catch (NumberFormatException e){
                System.err.println("ERROR: " + e.toString());
            } catch (InsercioDadesException e){
                System.err.println("ERROR: " + e.toString());
            } catch (Exception e){
                System.err.println("ERROR: " + e.toString());
            }
        } while (opcion != 0);
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
    
    //Método contingutFitxerAlbums que ª
    private void contenidoFicheroAlbums()
    {
        File f = new File("AlbumsVotes.dat");
        if (f.exists()) f.delete();
        
        FicheroAlbumLectura ficheroLectura = new FicheroAlbumLectura("GreatestAlbums.txt");
        FicheroAlbumInOut ficheroEscritura = new FicheroAlbumInOut("AlbumsVotes.dat");
        
        ficheroLectura.contarObjetos();
        Album album;
        for (int i = 0; i < ficheroLectura.getCantidadObjetos(); i++) {
            album = ficheroLectura.lecturaAlbum();
            System.out.println(album.toString());
            AlbumVotos albumVotos = new AlbumVotos();
            albumVotos.conversion(album);
            ficheroEscritura.escritura(albumVotos);
        }
        ficheroLectura.cerrarEnlace();
        ficheroEscritura.cerrarEnlace();
    }
    
    private void contenidoFicheroAleatorio()
    {
        
    }
    
    private void votoManual()
    {
        
    }
    
    private void simularVotos()
    {
        
    }
    
    private void calcularMejorAlbum()
    {
        
    }
    
    private void comprobarOpcion(int nombre) throws InsercioDadesException
    {
        if (nombre < 0 || 5 < nombre) throw new InsercioDadesException("ERROR DE OPCIÓN NO VÁLIDA");
    }
    
    private void continuar()
    {
        espaciado(2);
        System.out.print("<> Presiona \'intro\' para continuar · ");
        LT.readChar();
        espaciado(25);
    }
    
    private void espaciado(int i)
    {
        for (int j = 0; j < i; j++) {
            System.out.println("");
        }
    }
    
    private void titulo(String texto)
    {
        espaciado(2);
        System.out.print("<<<<<   "+texto+"   >>>>>");
        espaciado(1);
    }
}