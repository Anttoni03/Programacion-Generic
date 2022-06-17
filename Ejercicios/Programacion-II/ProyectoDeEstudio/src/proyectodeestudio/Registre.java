/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodeestudio;

public class Registre{
    private int[] quant = new int[4]; //0 SA, 1 INFECTAT, 2 CURAT, 3 DIFUNT      4 bytes * 4 = 16 bytes
    private static final int LONGIT = 16;

    public Registre(){
        for (int i = 0; i < 4; i++) quant[i] = 0;
    }
    
    public Registre(int[] dades){
        quant = dades.clone();
        for (int i : quant) i = 0;
    }

    public Registre(Poblacio[] pob){
        for (int i = 0; i < pob.length; i++){
            switch (pob[i].getEstat()){
                case SA: quant[0]++; break;
                case INFECTAT: quant[1]++; break;
                case CURAT: quant[2]++; break;
                case DIFUNT: quant[3]++; break;
            }
        }
    }

    public void actualitzar(Poblacio p){
        switch (p.getEstat()){
            case SA: quant[0]++; break;
            case INFECTAT: quant[1]++; break;
            case CURAT: quant[2]++; break;
            case DIFUNT: quant[3]++; break;
        }
    }
    
    public int getQuantitatSans(){
        return quant[0];
    }

    public int getQuantitatInfectats(){
        return quant[1];
    }

    public int getQuantitatCurats(){
        return quant[2];
    }

    public int getQuantitatDifunts(){
        return quant[3];
    }

    
    public static int getLongitud(){
        return LONGIT;
    }

    public String toString(){
        String r = "Registre{Sans=";
        r += quant[0] + ", Infectats=" + quant[1] + ", Curats=" + quant[2] + ", Difunts=" + quant[3] + "}";
        return r;
    }
}