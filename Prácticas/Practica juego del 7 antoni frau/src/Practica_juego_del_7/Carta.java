// AUTOR: Antoni Frau Gordiola
package Practica_juego_del_7;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

enum Palo { PICAS, CORAZONES, ROMBOS, TREBOLES}

public class Carta
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que indica el valor numérico de la carta
    private int valor = 0;
    //Atributo de objeto que indica el palo de la carta
    private Palo palo = Palo.CORAZONES;
    //Atributo de objeto que indica la imagen delantera de la carta
    private BufferedImage imagen;
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor para instanciar objetos Carta
    public Carta() {}
    
    //Método setValor para indicarle un valor a la carta
    public void setValor(int valor)
    {
        this.valor = valor;
    }
    //Método setPalo para indicarle un palo a la carta
    public void setPalo(Palo palo)
    {
        this.palo = palo;
    }
    //Método setImagen para indicarle una imagen a la carta por imagen
    public void setImagen(BufferedImage imagen)
    {
        this.imagen = imagen;
    
    }
    //Método setImagen para indicarle una imagen a la carta por nombre
    public void setImagen(String imagen)
    {
        try{
            this.imagen = ImageIO.read(new File(imagen));
        } catch (IOException e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    //Método getValor que devuelve el valor de la carta
    public int getValor()
    {
        return valor;
    }
    //Método getPalo que devuelve el palo de la carta
    public Palo getPalo()
    {
        return palo;
    }
    //Método getImagen que devuelve la imagen de la carta
    public BufferedImage getImagen()
    {
        return imagen;
    }
    
    //Método copiar que devuelve una copia de la Carta
    public Carta copiar()
    {
        Carta c = new Carta();
        c.valor = this.valor;
        c.palo = this.palo;
        c.imagen = this.imagen;
        
        return c;
    }
    
    //Método esContigua que indica si una carta es contigua por palo y valor
    public boolean esContigua(Carta carta)
    {
        //devuelve falso si no coinciden los palos o los valores no son próximos
        if (carta.palo != palo) return false;
        if ((carta.valor != valor-1) && (carta.valor != valor+1)) return false;
        //devuelve true al llegar a que son contiguas
        return true;
    }
    
    //Método esAsignada que indica si la carta ya ha sido asignada con un valor
    public boolean esAsignada()
    {
        return valor != 0;
    }
    
    //Método sobreescrito toString que devuelve un texto describiendo la Carta
    @Override
    public String toString()
    {
        return valor + " de " + palo.name();
    }
}