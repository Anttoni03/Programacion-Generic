/*
Autor: Jaume Cantallops Comas
NOTA: No hem funciona la escriure un objecte album a una posició determinada però si que en
puc llegir un a una posició determinada. Per això, a l'opció 2 he fet q llegeixí un
album aleatoriament per demostrar-ho
Les opcions 3,4 i 5 no poren funcionar ja que la 4 i la 5 necessiten la escritura i la 
opció 5 perquè la 3 i la 4 que s'encarrenguen d'asignar vots als àlbuns no funcionen.
Però el codic en si de les opcions hauria d'estar bé

 */
package taller1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Random;
public class Taller1 {
    
    //declarar un objeto album "global"
    Clase_Album album = new Clase_Album();
    //atributo constante que asignara el numero de albunes del fitxero
    private final int TOTAL_FICHEROS = 100;

    public static void main(String[] args) throws Exception {
        new Taller1().metodoPrincipal();
    }
    
    //mètode principal
    private void metodoPrincipal() throws IOException, Exception{
        

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        //mostrar el menú
        mostrar_menu();
        
        //bucle principal
        //declaram variable per controlar el bucle principal 
        boolean caso0 = false;
        while(!caso0){
            //delceram una variable per llegir l'opció i llavors la llegim
            int opcio = Integer.parseInt (br.readLine());
            
            switch(opcio){
                case 1:
                        mostra_fitxer();
                    break;
                case 2:
                        mostra_fitxer_vots();
                    break;
                case 3:
                        votar_un_album();
                    break;
                case 4:
                        votar_random();
                    break;
                case 5:
                        mejor_punt();
                    break;
                case 0:
                    caso0 = true;
                    break;
            }
            if (opcio !=0){
                mostrar_menu();
            }
        }
    }
    
    //mètode que permetrà la visualització del menú d'opcions i el mensatge 
    //perquè n'esculli una
    private void mostrar_menu(){
        System.out.println("1. Veure el contingut del fitxer de text i inicialitza el fitxer de vots");
        System.out.println("2. Veure el contingut del fitxer de vots d'acce´s aleatori");
        System.out.println("3. Un vot manual");
        System.out.println("4. Simula vots aleatoris");
        System.out.println("5. Calcula el millor àlbum");        
        System.out.println("0. Sortir");   
        //mensatge a l'usuari 
        System.out.print("Insereix l'opció: "); 
    }
    
    //mètode de fer el que demana l'enunciat a  (opció 1)
    private void mostra_fitxer() throws Exception {
        
        //Decleram un objecte AlbumFicheroLectura i un objecte FicheroClase_AlbumInOut
        AlbumFicheroLectura fichero = new AlbumFicheroLectura("GreatestAlbums.txt");
        FicheroClase_AlbumInOut fichero1 = new FicheroClase_AlbumInOut("Album_Votos.dat");
        //llegim les primeres linies que formen un objecte al fitxer GreatesAlbums.txt
        album = fichero.lectura();
        //bucle
        while (album !=  null){
            //escrivim l'objecte album llegit
            fichero1.escritura(album);
            //mostram per pantalla l'objecte album llegit
            System.out.println(album.tostring());
            //tornam a llegir un altre objecte
            album = fichero.lectura();
        
        }
        
        //tancam els enllaços dels fitxers
        fichero.cerrarEnlaceFichero();
        fichero1.cierre();
    }
    //mètode de fer el que demana l'enunciat a  (opció 2)
    public void mostra_fitxer_vots()throws Exception{
        
        //declarar objecte fitxer FicheroClase_AlbumInOut
        FicheroClase_AlbumInOut fichero1 = new FicheroClase_AlbumInOut("Album_Votos.dat");
        
        album = fichero1.lectura();
        while (album != null){
            System.out.println(album.toString2());
            album = fichero1.lectura();
            
        }
        //les linies de codi per demostrar que pot llegir un objecte àlbum passant
        //per paràmetre la posició
        album = fichero1.lectura(num_random(TOTAL_FICHEROS));
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println(album.tostring());
        //tancar enllaç del fitxer
        fichero1.cierre();
    }
    //mètode de fer el que demana l'enunciat a  (opció 3)
    public void votar_un_album() throws Exception{
       
        FicheroClase_AlbumInOut fichero1 = new FicheroClase_AlbumInOut("Album_Votos.dat");
        //mensatge a l'usuari perquè tri el número de l'album
        System.out.print("Num de disc el que vols votar [1...100]: ");
        //llegir el número del disc
        int i = LT.readInt();
        //mensatge a l'usuari perquè introdueixi la puntuació 
        System.out.print("\nPuntuació [1...10]");
        int p = LT.readInt();
        
        //llegir l'albun de la posició introduida per l'usuari
        album = fichero1.lectura(i);
        System.out.println(album.tostring());
        //posam els vots introduits per l'usuari l'atribut votos de l'objecte album
        album.setVotos(p);
        //tornam a escriure l'objecte album
        fichero1.escritura(album, i);
        //tancar enllaç fitxer
        fichero1.cierre();
        
    }
    
    //mètode de fer el que demana l'enunciat a  (opció 4)
    private void votar_random() throws Exception{
        
        FicheroClase_AlbumInOut fichero1 = new FicheroClase_AlbumInOut("Album_Votos.dat");
        
        //mensatge a l'usuari per demanar quantes votacions vol
        System.out.print("Nombre de votacions que vols generar [1..100]? ");
        //llegir el nombre de votacions i guardar-lo a una variable
        int numero_votaciones = LT.readInt();
        
        //bulce
        for (int i = 1;i<=numero_votaciones;i++){
            //fila que es vorà a la pantalla amb els números dels àlbums i els
            //seus respecitus vots 
            System.out.print("Vot: "+i+"    ");
            for (int y = 0;y<10;y++){
                //declaració d'una varialbe tipus int per guardar el nombre random
                int random = num_random(TOTAL_FICHEROS);
                //guardar a l'objecte album, l'objecte album a la posició random
                album = fichero1.lectura(random);
                //sumar els vots que ja tenia l'objecte àlbum al fitxer més
                //els vots que li han de sumar 
                album.setVotos(y+album.getVotos());
                //escriure a la mateixa posició l'album amb els vots sumats
                fichero1.escritura(album,random);
                //mostar per pantalla el número de l'album i els vots que se li
                //sumaran
                System.out.print("  [#"+random+" - "+y+"+]");
                
            }
            //botar linia
            System.out.println();
            
        }
        //tancar enllaç del fitxer
        fichero1.cierre();
                
    }
    
    //mètode que retorna un  num roandom 
    private int num_random(int dim){
        
        //delcaració d'un objecte random
        Random random = new Random();
        
        return random.nextInt(dim)+1;
 
    }
    
    //mètode de fer el que demana l'enunciat a  (opció 5)
    private void mejor_punt() throws Exception{
        
        FicheroClase_AlbumInOut fichero1 = new FicheroClase_AlbumInOut("Album_Votos.dat");
        
        //declerar un objecte àlbum per guardar l'àlbum amb més vots
        Clase_Album album1 = new Clase_Album();

        //bulce per trobar l'àlbum amb major puntuació
        for (int i = 1;i<=TOTAL_FICHEROS;i++){
            //lectura i asignació a un objecte àlbum
            //de l'àlbum a la posició "i" del fitxer "fichero1"
            album = fichero1.lectura(i);
            
            if (album.getVotos()>album1.getVotos()){
                album1 = album;
            }           
            
        }
        
        //mensatge a l'usuari de l'àlbum amb més vots 
        System.out.println(album1.toString5());
        
    }

}
