/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodeestudio;

import java.io.Serializable;
import java.util.Random;

enum Estat {SA, INFECTAT, CURAT, DIFUNT}

public class Poblacio implements Serializable {
    private int codi;
    private String nom;
    private Estat estat;
    private static final Poblacio CENTINELA = new Poblacio(-1,"",Estat.SA);

    public Poblacio() {}
    
    public Poblacio(int c, String n, Estat e){
        codi = c;
        nom = n;
        estat = e;
    }
    
    public void aleatori(String n){
        nom = n;
        Random r = new Random();
        codi = r.nextInt(20);
        estat = Estat.values()[r.nextInt(3)];
    }

    public int getCodi(){
        return codi;
    }

    public String getNom(){
        return nom;
    }

    public Estat getEstat(){
        return estat;
    }

    public static Poblacio getCentinela(){
        return CENTINELA;
    }

    public boolean esCentinela(){
        return codi == CENTINELA.getCodi();
    }

    public String toString(){
        String r = "Poblacio{codi=";
        r += codi + ", nom=" + nom + ", estat=" + estat.toString() + "}";
        return r;
    }
}
