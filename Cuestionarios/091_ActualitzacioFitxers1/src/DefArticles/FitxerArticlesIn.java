package DefArticles;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe lectura de fitxer d'articles. Un fitxer d'articles se gestiona amb el
 * fluxe d'objectes i aquests són els seus únics atributs al fitxer l'anomenam
 * f.
 *
 * @author miquelmascarooliver
 */
public class FitxerArticlesIn {

    private FileInputStream fis;
    private ObjectInputStream f;

    /**
     * El constructor obri un fitxer d'objectes per a lectura a partir del nom
     * del fitxer físic que passa per paràmetre
     *
     * @param nom
     */
    public FitxerArticlesIn(String nom) {
        try {
            fis = new FileInputStream(nom);
            f = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FitxerArticlesIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FitxerArticlesIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * mostraArticles: Un recorregut del fitxer fins al centinel·la que va
     * enregistrant les dades a una cadena de caracters.
     *
     * @return
     */
    public String mostraArticles() {
        String s = "";
        try {
            Article a = (Article) f.readObject();
            while (!a.esCentinela()) {
                s += a;
                s += "\n";
                a = (Article) f.readObject();
            }
        } catch (IOException ex) {
            Logger.getLogger(FitxerArticlesIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FitxerArticlesIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    /**
     * tancaArticles: tanca el fitxer
     */
    public void tancaArticles() {
        try {
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(FitxerArticlesIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * llegir: llegeix un article del fitxer
     *
     * @return
     */
    public Article llegir() {
        Article a = null;
        try {
            a = (Article) f.readObject();
        } catch (IOException ex) {
            Logger.getLogger(FitxerArticlesIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FitxerArticlesIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
