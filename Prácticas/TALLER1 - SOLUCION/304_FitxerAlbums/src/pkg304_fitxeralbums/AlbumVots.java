package pkg304_fitxeralbums;

/**
 * Classe emmagatzemada dins el random accés file. No usa herència!!! per tant té
 * les mateixes dades que la classe Album + un int. Sertia més correcte usar herencia
 * però al curs només es veu el concepte de manera introductòria
 * @author miquelmascarooliver
 */
public class AlbumVots {
    private int num, any, impres, vots;
    private String titol, artista, tipus;
    private double estrelles;
    
    /**
     * Constructor de l'àlbum amb vots
     * @param num Posició dins la llista
     * @param any Any d'edició
     * @param titol de l'àlbum
     * @param artista nom de l'intèrpret
     * @param tipus pot ser album, compilació, banda sonora o directe
     * @param estrelles valoració
     * @param impres nombre d'edicions
     * @param vots nombre de vots rebuts
     */
    public AlbumVots(int num, int any, String titol, String artista, String tipus, double estrelles, int impres, int vots) {
        this.num = num;
        this.any = any;
        this.titol = titol;
        this.artista = artista;
        this.tipus = tipus;
        this.estrelles = estrelles;
        this.impres = impres;
        this.vots = vots;
    }

    public String toStringCompacte() {
        return "# " + num + blancs(num) + "vots: " + vots + blancs(vots) + titol + " Artista: " + artista +  " any: " + any;
    }

    @Override
    public String toString() {
        return "AlbumVots{" + "num=" + num + ", any=" + any + ", impres=" + impres + ", vots=" + vots + ", titol=" + titol + ", artista=" + artista + ", tipus=" + tipus + ", estrelles=" + estrelles + '}';
    }

    /**
     * Per a la sortida alineada
     * @param x posa blanc en funció del nombre precedent
     * @return 
     */
    private String blancs(int x) {
        String s = "";
        if (x < 10) s = "   ";
        else if (x < 100) s = "  ";
        else s = " ";
        return s;
    }

    public int getVots() {
        return vots;
    }

    public int getNum() {
        return num;
    }

    public int getAny() {
        return any;
    }

    public String getTitol() {
        return titol;
    }

    public String getArtista() {
        return artista;
    }
    
}
