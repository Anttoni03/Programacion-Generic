/*
 * Actualització de fitxers amb un fitxer d'actualitzacions que conté algunes
 * modificacions del registres original. Solucio basada en la fusio simètrica
 *
 * En aquesta versió dins el paquet de definició d'articles hi ha les classes:
 * Article, Actualitzacio, FitxerArticlesIn, FitxerArticlesOut,
 * FiterActualitzacionsIn i FitxerActualitzacionsOut aquestes 4 darreres s'usen
 * per gestionar de forma abstracta els conceptes de fitxers d'articles i
 * d'actualitzacions amb mètodes de lectura i escritura similars als oferts per
 * les classes ObjectStream tant d'enstrada com de sortida.
 *
 * Amb un menú simple es gestionen les opcions d'inserir articles i actualitzacions,
 * veure els continguts dels 4 fitxers del problema i fer el procés d'actualització.
 *
 * El control d'errors no està fet
 */
package pkg091_actualitzaciofitxers1;

/**
 *
 * @author miquelmascarooliver
 */
import java.io.*;
import DefArticles.*;

public class ActualitzacioFitxers1 {

    public static void main(String[] args) {
        boolean sortir = false;
        int opcio = 0;
        while (!sortir) {
            menu();
            opcio = llegirNum("\n\n\tInserir opció: ");
            switch (opcio) {
                case 1:
                    FitxerArticlesOut fout = new FitxerArticlesOut("articles.dat");
                    int n = llegirNum("\nQuans articles vols entrar? ");
                    System.out.println("Insereix les dades de " + n + " articles"
                            + "\nEls codis de menor a major");
                    for (int i = 1; i <= n; i++) {
                        String s = llegirCadena("Nom article: ");
                        int x = llegirNum("Codi article: ");
                        Article a = new Article(s, x);
                        fout.escriu(a);
                    }
                    fout.tancaArticles();
                    break;
                case 2:
                    FitxerActualitzacionsOut gout = new FitxerActualitzacionsOut("actualitzacions.dat");
                    n = llegirNum("\nQuantes actualitzacions vols entrar? ");
                    System.out.println("Insereix les dades de " + n + " actualitzacions"
                            + "\nEls codis de menor a major");
                    for (int i = 1; i <= n; i++) {
                        String s = llegirCadena("Nom article: ");
                        int x = llegirNum("Codi article: ");
                        Actualitzacio m = new Actualitzacio(s, x);
                        gout.escriu(m);
                    }
                    gout.tancaActualitzacions();
                    break;
                case 3:
                    actualitza("articles.dat", "actualitzacions.dat", "nouarticles.dat", "anomalies.dat");
                    break;
                case 4:
                    FitxerArticlesIn fin = new FitxerArticlesIn("articles.dat");
                    System.out.println("Contingut del fitxer d'articles\n" + fin.mostraArticles());
                    fin.tancaArticles();
                    break;
                case 5:
                    FitxerActualitzacionsIn gin = new FitxerActualitzacionsIn("actualitzacions.dat");
                    System.out.println("Contingut del fitxer d'actualitzacions\n" + gin.mostraActualitzacions());
                    gin.tancaActualitzacions();
                    break;
                case 6:
                    FitxerArticlesIn hin = new FitxerArticlesIn("nouarticles.dat");
                    System.out.println("Contingut del fitxer d'articles nous\n" + hin.mostraArticles());
                    hin.tancaArticles();
                    break;
                case 7:
                    FitxerActualitzacionsIn iin = new FitxerActualitzacionsIn("anomalies.dat");
                    System.out.println("Contingut del fitxer d'anomalies\n" + iin.mostraActualitzacions());
                    iin.tancaActualitzacions();
                    break;
                case 0:
                    sortir = true;
                    break;
            }

        }

    }

    private static void menu() {
        System.out.println("\n\nACTUALITZACIÓ DE FITXERS D'ARTICLES");
        System.out.println("\n\t1. Inserir articles");
        System.out.println("\t2. Inserir modificacions");
        System.out.println("\t3. Actualitza articles");
        System.out.println("\t4. Veure articles");
        System.out.println("\t5. Veure modificacions");
        System.out.println("\t6. Veure nous articles");
        System.out.println("\t7. Veure anomalies");
        System.out.println("\t0. Sortir");
    }

    private static void actualitza(String nommaster, String nomactualitzacions,
            String nomnmaster, String nomanomalies) {
        try {
            FitxerArticlesIn master = new FitxerArticlesIn(nommaster);
            FitxerActualitzacionsIn updt = new FitxerActualitzacionsIn(nomactualitzacions);
            FitxerArticlesOut nmaster = new FitxerArticlesOut(nomnmaster);
            FitxerActualitzacionsOut anom = new FitxerActualitzacionsOut(nomanomalies);
            Article a = master.llegir();
            Actualitzacio m = updt.llegir();
            while (!a.esCentinela() || !m.esCentinela()) {
                if (a.getCodi() < m.getCodi()) {
                    nmaster.escriu(a);
                    a = master.llegir();
                } else if (a.getCodi() == m.getCodi()) {
                    a.modifica(m);
                    m = updt.llegir();
                } else {
                    anom.escriu(m);
                    m = updt.llegir();
                }
            }
            master.tancaArticles();
            nmaster.tancaArticles();
            updt.tancaActualitzacions();
            anom.tancaActualitzacions();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String llegirCadena(String msg) {
        String s = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(msg);
            s = in.readLine();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return s;

    }

    private static int llegirNum(String msg) {
        int x = 0;
        try {
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(msg);
            s = in.readLine();
            x = Integer.parseInt(s);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return x;
    }
}
