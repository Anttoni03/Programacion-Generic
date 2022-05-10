// AUTOR: Antoni Frau Gordiola
/**
 * <a href="www.google.com"> Vídeo explicativo </a>
 */
package Practica_juego_del_7;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

enum Palo { PICAS, CORAZONES, ROMBOS, TREBOLES}

public class Carta {
    private int valor = 0;
    private Palo palo = Palo.CORAZONES.PICAS;
    private BufferedImage imagen;
    
    public Carta() {}
    
    public void setValor(int valor)
    {
        this.valor = valor;
    }
    public void setPalo(Palo palo)
    {
        this.palo = palo;
    }
    public void setImagen(BufferedImage imagen)
    {
        this.imagen = imagen;
    }
    public void setImagen(String imagen)
    {
        try{
            this.imagen = ImageIO.read(new File(imagen));
        } catch (IOException e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    public int getValor()
    {
        return valor;
    }
    public Palo getPalo()
    {
        return palo;
    }
    public BufferedImage getImagen()
    {
        return imagen;
    }
    
    public Carta copiar()
    {
        Carta c = new Carta();
        c.valor = this.valor;
        c.palo = this.palo;
        c.imagen = this.imagen;
        
        return c;
    }
    
    public boolean esContigua(Carta carta)
    {
        //System.out.println("Comparar " + toString() + " con " + carta.toString());
        if (carta.palo != palo) return false;
        if ((carta.valor != valor-1) && (carta.valor != valor+1)) return false;
        
        return true;
    }
    
    public boolean esAsignada()
    {
        return valor != 0;
    }
    
    public String toString()
    {
        return valor + " de " + palo.name();
    }
}