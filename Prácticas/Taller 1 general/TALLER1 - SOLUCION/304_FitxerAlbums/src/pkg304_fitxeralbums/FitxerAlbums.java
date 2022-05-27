package pkg304_fitxeralbums;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe per a la gestió del fitxer d'àlbums i fer les votacions per trobar el
 * millor. El fitxer és simplement un Random Access File on els registres tenen
 * la MIDAREG i són 
 * @author miquelmascarooliver 3 strings de 40 + 3 ints + 1 double + 1 int pels vots rebuts
 */
public class FitxerAlbums {

    public static final int MIDASTRING = 40; // mida dels strings
    private static final int MIDAREG = (MIDASTRING * 2) * 3 + 4 * 3 + 8 + 4; // 3 strings + 3 ints + 1 double + 1 int pels vots rebuts

    private final File arxiu;
    private RandomAccessFile f;

    public FitxerAlbums(String nomFitxer) throws FileNotFoundException, IOException {
        arxiu = new File(nomFitxer);
        f = new RandomAccessFile(arxiu, "rw");
        f.close();
    }

    /**
     * Enregistra un àlbum a memòria
     * @param a Classe Album
     * @throws IOException 
     */
    public void write(Album a) throws IOException {
        f = new RandomAccessFile(arxiu, "rw");
        f.seek(f.length());
        f.writeInt(a.getNum());
        f.writeInt(a.getAny());
        f.writeChars(toStringMaxim(a.getTitol()));
        f.writeChars(toStringMaxim(a.getArtista()));
        f.writeChars(toStringMaxim(a.getTipus()));
        f.writeDouble(a.getEstrelles());
        f.writeInt(a.getImpres());
        f.writeInt(0); // Inicializa vots a zero
        f.close();
    }

    /**
     * Converteix l'string a la mida dels que s'emmagatzemen dins el fitxer
     * @param cad Cadena de caràcters de qualsevol mida
     * @return Cadena de caràcters de MIDASTRING
     */
    private static String toStringMaxim(String cad) {
        String s = "";
        if (cad.length() > MIDASTRING) {
            s = cad.substring(0, MIDASTRING);
        } else {
            for (int i = 0; i < cad.length(); i++) {
                s += cad.charAt(i);
            }
            for (int i = cad.length(); i < MIDASTRING; i++) {
                s += " ";
            }
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        try {                        
            f = new RandomAccessFile(arxiu, "r");
            long numReg = f.length() / MIDAREG; // N'hi ha 100
            for (int i = 0; i < numReg; i++) {
                AlbumVots a = llegirAlbum(f);
                s += a.toStringCompacte() + "\n";
            }
            f.close();           
            
        } catch (IOException ex) {
            Logger.getLogger(FitxerAlbums.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    /**
     * Llegeix un objecte AlbumVots (Album + int) des de la psició on està el
     * File Pointer
     * @param f Fitxer d'accés aleatori
     * @return Objecte de la classe AlbumVots
     * @throws IOException 
     */
    private static AlbumVots llegirAlbum(RandomAccessFile f) throws IOException {
        int num = f.readInt();
        int any = f.readInt();
        String titol = "";
        for (int i = 0; i < MIDASTRING; i++) {
            titol += f.readChar();
        }
        String artista = "";
        for (int i = 0; i < MIDASTRING; i++) {
            artista += f.readChar();
        }
        String tipus = "";
        for (int i = 0; i < MIDASTRING; i++) {
            tipus += f.readChar();
        }
        double estrelles = f.readDouble();
        int impres = f.readInt();
        int vots = f.readInt();
        AlbumVots a = new AlbumVots(num, any, titol, artista, tipus, estrelles, impres, vots);
        return a;
    }

    /**
     * Esborra el fitxer
     */
    public void delete() {
        arxiu.delete();
    }

    /**
     * Modifica el nombre de vots per un àlbum determinat
     * @param vot àlbum que rep la puntuació
     * @param punts incrementa la seva puntuació amb aquest valor
     * @return 
     */
    public AlbumVots discVota(int vot, int punts) {
        AlbumVots a = null;
        try {
            long i = (long) vot;
            f = new RandomAccessFile(arxiu, "rw");
            long index = (i * MIDAREG) - 4;
            f.seek(index); // Abans dels vots
            int v = f.readInt();
            v += punts;
            f.seek(index);
            f.writeInt(v);
            f.seek((i - 1) * MIDAREG); // els discs estàn emmagatzemats del 0 al 99 per tant el que volem modificar és i-1
            a = llegirAlbum(f);
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FitxerAlbums.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FitxerAlbums.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    /**
     * Algorisme del màxim segon el nombre de vots en cas d'empat es quedarà amb el primer (menor posició)
     * @return 
     */
    public AlbumVots calculaMillor() {
        AlbumVots millor = null;
        try {
            f = new RandomAccessFile(arxiu, "r");
            if (f.length() > 0) { // Això és redundant ja que està controlat amb els errors del main
                millor = llegirAlbum(f);
                long numReg = f.length() / MIDAREG;
                for (int i = 1; i < numReg; i++) {
                    AlbumVots a = llegirAlbum(f);
                    if (a.getVots() > millor.getVots()) {
                        millor = a;
                    }
                }
            }
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FitxerAlbums.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FitxerAlbums.class.getName()).log(Level.SEVERE, null, ex);
        }
        return millor;
    }

}
