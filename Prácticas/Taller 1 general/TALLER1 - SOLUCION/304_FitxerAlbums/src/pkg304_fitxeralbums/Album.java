/*
 * 
 */
package pkg304_fitxeralbums;

/**
 *
 * @author miquelmascarooliver
 */
public class Album {
    
    private int num, any, impres;
    private String titol, artista, tipus;
    private double estrelles;


    Album(int num, int any, String titol, String artista, String tipus, double estrelles, int impres) {
        this.num = num;
        this.any = any;
        this.titol = titol;
        this.artista = artista;
        this.tipus = tipus;
        this.estrelles = estrelles;
        this.impres = impres;
    }

    @Override
    public String toString() {
        return "Album{" + "num=" + num + ", any=" + any + ", impres=" + impres + ", titol=" + titol + ", artista=" + artista + ", tipus=" + tipus + ", estrelles=" + estrelles + '}';
    }

    public int getNum() {
        return num;
    }

    public int getAny() {
        return any;
    }

    public int getImpres() {
        return impres;
    }

    public String getTitol() {
        return titol;
    }

    public String getArtista() {
        return artista;
    }

    public String getTipus() {
        return tipus;
    }

    public double getEstrelles() {
        return estrelles;
    }
        
}
