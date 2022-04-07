package DefArticles;

/**
 * Classe escritura de fitxer d'articles. Un fitxer d'articles se gestiona amb
 * el fluxe d'objectes i aquests són els seus únics atributs al fitxer
 * l'anomenam f.
 *
 * @author miquelmascarooliver
 */
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FitxerArticlesOut {

    private FileOutputStream fos;
    private ObjectOutputStream f;

    /**
     * El constructor obri un fitxer d'objectes per a escritura a partir del nom
     * del fitxer físic que passa per paràmetre
     *
     * @param nom
     */
    public FitxerArticlesOut(String nom) {
        try {
            fos = new FileOutputStream(nom);
            f = new ObjectOutputStream(fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FitxerArticlesOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FitxerArticlesOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Escriu un objecte article.
     *
     * @param a
     */
    public void escriu(Article a) {
        try {
            f.writeObject(a);
        } catch (IOException ex) {
            Logger.getLogger(FitxerArticlesOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Tanca el fitxer i escriu el centinel·la.
     */
    public void tancaArticles() {
        try {
            f.writeObject(Article.CENTINELA);
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(FitxerArticlesOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
