// AUTOR: Antoni Frau Gordiola
/**
 * <a href="www.google.com"> Vídeo explicativo </a>
 */
package Practica_juego_del_7;

import java.util.Random;


public class Baraja {
    private static final int CANT_PALO = 13;
    private static final Carta[] barajaCartas = new Carta[CANT_PALO * 4];
    
    public static void inicializarBaraja()
    {
        for (int i = 0; i < barajaCartas.length; i++) {
            barajaCartas[i] = new Carta();
            if (i < CANT_PALO)
            {
                barajaCartas[i].setValor(i+1);
                barajaCartas[i].setPalo(Palo.PICAS);
                barajaCartas[i].setImagen("Cartes/"+(i+1)+"_of_spades.png");
            }
            else if (i < CANT_PALO*2)
            {
                barajaCartas[i].setValor(i-12);
                barajaCartas[i].setPalo(Palo.CORAZONES);
                barajaCartas[i].setImagen("Cartes/"+(i-12)+"_of_hearts.png");
            }
            else if (i < CANT_PALO*3)
            {
                barajaCartas[i].setValor(i-25);
                barajaCartas[i].setPalo(Palo.ROMBOS);
                barajaCartas[i].setImagen("Cartes/"+(i-25)+"_of_diamonds.png");
            }
            else
            {
                barajaCartas[i].setValor(i-38);
                barajaCartas[i].setPalo(Palo.TREBOLES);
                barajaCartas[i].setImagen("Cartes/"+(i-38)+"_of_clubs.png");
            }
        }
    }
    
    public static Carta[] barajar()
    {
        Carta[] barajadas = new Carta[barajaCartas.length];
        Random r = new Random();
        
        for (int i = 0; i < barajadas.length; i++) barajadas[i] = barajaCartas[i].copiar();
        
        for (int i = barajadas.length-1; i > 0; i--)
        {
            int rand = r.nextInt(i);
            Carta temp = barajadas[rand].copiar();
            barajadas[rand] = barajadas[i].copiar();
            barajadas[i] = temp.copiar();
        }
        return barajadas;
    }
    
    public static int getPosicionDeCarta(Carta carta)
    {
        for (int i = 0; i < barajaCartas.length; i++)
        {
            if (carta.getValor() == barajaCartas[i].getValor() &&
                    carta.getPalo() == barajaCartas[i].getPalo())
                return i;
        }
        return -1;
    }
    
    public static Carta[] getNuevaBaraja()
    {
        return barajaCartas;
    }
    public static int getCantidadPalo()
    {
        return CANT_PALO;
    }
}
