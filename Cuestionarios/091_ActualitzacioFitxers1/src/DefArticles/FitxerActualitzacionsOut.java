package DefArticles;

/**
 * Classe escritura de fitxer d'actualitzacions. Un fitxer d'actualitzacions se
 * gestiona amb el fluxe d'objectes i aquests són els seus únics atributs al
 * fitxer l'anomenam f.
 *
 * @author miquelmascarooliver
 */
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FitxerActualitzacionsOut {

    private FileOutputStream fos;
    private ObjectOutputStream f;

    /**
     * El constructor obri un fitxer d'objectes per a escritura a partir del nom
     * del fitxer físic que passa per paràmetre
     *
     * @param nom
     */
    public FitxerActualitzacionsOut(String nom) {
        try {
            fos = new FileOutputStream(nom);
            f = new ObjectOutputStream(fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FitxerActualitzacionsOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FitxerActualitzacionsOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * tancaActualitzacions: tanca el fitxer
     */
    public void tancaActualitzacions() {
        try {
            f.writeObject(Actualitzacio.CENTINELA);
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(FitxerActualitzacionsOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * escriure: escriu una actualització al fitxer
     *
     * @param m
     */
    public void escriu(Actualitzacio m) {
        try {
            f.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(FitxerActualitzacionsOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
