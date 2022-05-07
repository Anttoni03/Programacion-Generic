/*
 * A l’any 2020 la revista de música Rolling Stone va actualitzar la seva llista
 * dels millors 500 àlbums de tots els temps. El fitxer de text adjunt 
 * GreatestAlbums.txt conté la informació dels 100 primers ordenats del millor 
 * al pitjor. Es tracta d’un fitxer de text sense format, codificat amb UTF-8, 
 * amb canvis de línia i retorns de carro. Dins el fitxer la informació està 
 * estructurada en línies de text per a cada un dels 100 àlbums de la següent
 * manera:
 * •	Posició dins la llista (de l’1 al 100)
 * •	Any d’edició
 * •	Títol de l’àlbum
 * •	Artista o grup intèrpret
 * •	Tipus: Àlbum, Àlbum + Soundtrack, Àlbum + Compilation o Àlbum + Live
 * •	Nombre d’estrelles (valor entre 1 i 5)
 * •	Nombre d’edicions
 * El taller consisteix en dissenyar un programa que gestioni aquesta 
 * informació per poder votar el millor àlbum, en concret és demana que 
 * s’implementi un menú per consola amb aquestes opcions
 */
package pkg304_fitxeralbums;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author miquelmascarooliver
 */
public class GestioAlbums {

    /**
     * Classe per al tractament dels errors inserint les dades
     */
    public static class InsercioDadesException extends Exception {
    }

    /**
     * @param args the command line arguments
     * Gestiona el menú amb les opcions que demana l'enunciat
     */
    public static void main(String[] args) {
        final int MAXALBUMS = 100;
        try {
            BufferedReader fAlbums;
            boolean sortir = false;
            FitxerAlbums fRAF = new FitxerAlbums("FitxersDiscs.dat");
            boolean fitxerCreat = false;
            while (!sortir) {
                try {
                    menu();
                    int opcio = llegirEnter("\n Insereix opció: ");
                    if (opcio < 0 || opcio > 5) {
                        throw new InsercioDadesException();
                    }
                    switch (opcio) {
                        case 1:
                            fAlbums = new BufferedReader(new FileReader("GreatestAlbums.txt"));
                            String s = fAlbums.readLine();
                            System.out.println("\nContingut del fitxer de text:");
                            fRAF.delete(); // Inicialitza - esborra el fitxer de vots
                            while (s != null) { // Recorregut del fitxer de text
                                int num = Integer.parseInt(s);
                                int any = Integer.parseInt(fAlbums.readLine());
                                String titol = fAlbums.readLine();
                                String artista = fAlbums.readLine();
                                String tipus = fAlbums.readLine();
                                double estrelles = Double.parseDouble(fAlbums.readLine());
                                int impres = Integer.parseInt(fAlbums.readLine());
                                Album a = new Album(num, any, titol, artista, tipus, estrelles, impres);
                                System.out.println(a);
                                fRAF.write(a); // Emmgatzema l'album al fitxer
                                s = fAlbums.readLine();
                            }
                            fAlbums.close();
                            fitxerCreat = true; // Si val fals no es poden executar les altres opcions
                            break;
                        case 2:
                            System.out.println("Contingut del fitxer de discs:\n" + fRAF.toString());
                            break;
                        case 3:
                            AlbumVots a = null;
                            int disc = llegirEnter("Num de disc que vols votar [1..100]? ");
                            if (disc < 1 || disc > MAXALBUMS || !fitxerCreat) {
                                throw new InsercioDadesException();
                            }
                            int punts = llegirEnter("Puntuació [1..10]: ");
                            if (punts < 1 || punts > 10) {
                                throw new InsercioDadesException();
                            }
                            a = fRAF.discVota(disc, punts);
                            System.out.println("#" + a.getNum() + " vots: " + a.getVots() + " per " + a.getTitol() + " de " + a.getArtista());
                            break;
                        case 4:
                            System.out.println("Votació aleatoria");
                            final int NUMVOTS = 100;
                            int vots = llegirEnter("Nombre de votacions que vols generar [1..100]? ");
                            if (vots < 1 || vots > NUMVOTS || !fitxerCreat) {
                                throw new InsercioDadesException();
                            }
                            final int PUNTS = 10;
                            for (int i = 0; i < vots; i++) {
                                System.out.print("Vot: " + (i + 1) + blancs(i + 1));
                                for (int j = 0; j < PUNTS; j++) { // Les 10 votacions
                                    Random r = new Random();
                                    int n = r.nextInt(MAXALBUMS) + 1; // de l'1 al 100
                                    fRAF.discVota(n, j + 1);
                                    System.out.print("[#" + n + blancs(n) + "- " + (j + 1) + "] ");
                                }
                                System.out.println();
                            }
                            break;
                        case 5:
                            System.out.println("El millor àlbum és:");
                            System.out.println(fRAF.calculaMillor());
                            break;
                        case 0:
                            sortir = true;
                            break;
                    }
                } catch (InsercioDadesException exd) {
                    System.out.println("ERROR: A la inserció de dades");
                } catch (Exception ex) {
                    System.out.println("ERROR: A la inserció de dades");
                }
            }
            fRAF.delete(); // En acabar esborra el fitxer
        } catch (IOException ex) {
            System.out.println("ERROR: Excepció IO al main");
        }
    }

    private static void menu() {
        System.out.println("\nGestió dels discs que s'haurien d'escoltar\n");
        System.out.println("1. Veure el contingut del fitxer de text i inicialitza fitxer de vots");
        System.out.println("2. Veure el contingut del fitxer de vots d'accès aleatori");
        System.out.println("3. Un vot manual");
        System.out.println("4. Simula vots aleatoris");
        System.out.println("5. Calcula el millor àlbum");
        System.out.println("0. Sortir");
    }
    /**
     * Per inserir les dades de consola
     * @param msg
     * @return
     * @throws pkg304_fitxeralbums.GestioAlbums.InsercioDadesException 
     */
    private static int llegirEnter(String msg) throws InsercioDadesException {
        int x = 0;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(msg);
            String s = in.readLine();
            x = Integer.parseInt(s);
        } catch (Exception e) {
            throw new InsercioDadesException();
        }
        return x;
    }

    /**
     * Simplement per treure les dades alineades
     * @param x
     * @return 
     */
    private static String blancs(int x) {
        String s = "";
        if (x < 10) {
            s = "   ";
        } else if (x < 100) {
            s = "  ";
        } else {
            s = " ";
        }
        return s;
    }
}
