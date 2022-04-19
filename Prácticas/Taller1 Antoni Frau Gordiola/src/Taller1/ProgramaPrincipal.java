
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
        FicheroAlbumInOut fichero = new FicheroAlbumInOut("AlbumsVotes.dat");
        AlbumVotos album;
        
        album = fichero.lectura();
        while (album != null && album.getPosicion() != 0)
        {
            System.out.println(album.toString());
            album = fichero.lectura();
        }
        fichero.cerrarEnlace();
    }
    
    private void votoManual()
    {
        FicheroAlbumInOut fichero = new FicheroAlbumInOut("AlbumsVotes.dat");
        Voto voto = new Voto();
        voto.lecturaManual();
        fichero.votar(voto);
        AlbumVotos album = fichero.lectura(voto.getPosicion());
        System.out.println(album.mostrarActualizado());
        fichero.cerrarEnlace();
    }
    
    private void simularVotos()
    {
        System.out.print("Número de votaciones que quieres generar [1..100]? ");
        FicheroAlbumInOut fichero = new FicheroAlbumInOut("AlbumsVotes.dat");
        int votaciones;
        try{
            votaciones = LT.readInt();
            comprobarVotaciones(votaciones);
            
            for (int i = 1; i <= votaciones; i++)
            {
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
    
    private void calcularMejorAlbum()
    {
        FicheroAlbumInOut fichero = new FicheroAlbumInOut("AlbumsVotes.dat");
        AlbumVotos album, mejorAlbum;
        
        album = fichero.lectura();
        mejorAlbum = album.copiar();
        while (album != null && album.getPosicion() != 0)
        {
            if (mejorAlbum.getVotos() < album.getVotos())
                mejorAlbum = album.copiar();
            
            album = fichero.lectura();
        }
        
        System.out.println("El mejor álbum es:");
        System.out.println(mejorAlbum.mostrarCompleto());
        
        fichero.cerrarEnlace();
    }
    
    private void comprobarOpcion(int nombre) throws InsercionDatosException
    {
        if (nombre < 0 || 5 < nombre) throw new InsercionDatosException("ERROR DE OPCIÓN NO VÁLIDA");
    }
    private void comprobarVotaciones(int numero) throws InsercionDatosException
    {
        if (numero < 0 || 100 < numero) throw new InsercionDatosException("ERROR DE OPCIÓN NO VÁLIDA");
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
        espaciado(2);
    }
}