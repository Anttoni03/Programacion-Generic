package DefArticles;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe lectura de fitxer d'actualitzacions. Un fitxer d'actualitzacions se
 * gestiona amb el fluxe d'objectes i aquests són els seus únics atributs al
 * fitxer l'anomenam f.
 *
 * @author miquelmascarooliver
 */
public class FitxerActualitzacionsIn {

    private FileInputStream fis;
    private ObjectInputStream f;

    /**
     * El constructor obri un fitxer d'objectes per a lectura a partir del nom
     * del fitxer físic que passa per paràmetre
     *
     * @param nom
     */
    public FitxerActualitzacionsIn(String nom) {
        try {
            fis = new FileInputStream(nom);
            f = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FitxerActualitzacionsIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FitxerActualitzacionsIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * mostraActualitzacions: Un recorregut del fitxer fins al centinel·la que
     * va enresgistrant les dades a una cadena de caracters
     *
     * @return
     */
    public String mostraActualitzacions() {
        String s = "";
        try {
            Actualitzacio a = (Actualitzacio) f.readObject();
            while (!a.esCentinela()) {
                s += a;
                s += "\n";
                a = (Actualitzacio) f.readObject();
            }
        } catch (IOException ex) {
            Logger.getLogger(FitxerActualitzacionsIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FitxerActualitzacionsIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    /**
     * tancaActualitzacions: tanca el fitxer
     */
    public void tancaActualitzacions() {
        try {
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(FitxerActualitzacionsIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * llegir: llegeix una actualització del fitxer
     *
     * @return
     */
    public Actualitzacio llegir() {
        Actualitzacio m = null;
        try {
            m = (Actualitzacio) f.readObject();
        } catch (IOException ex) {
            Logger.getLogger(FitxerActualitzacionsIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FitxerActualitzacionsIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
}
