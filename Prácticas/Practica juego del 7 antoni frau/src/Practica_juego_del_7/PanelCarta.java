/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_juego_del_7;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PanelCarta extends JPanel {
    
    private BufferedImage imagen = null;
    private boolean esCarta;
    private boolean visualizar;
    private int valor = 0;
    
    public PanelCarta(boolean c)
    {
        esCarta = c;
        visualizar = c;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(30,110,30));
        Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
        g2.fill(rec);

        if (imagen != null && visualizar)
        {
            g2.drawImage(imagen, esCarta?4:0, esCarta?4:0, 
                    getWidth()-(esCarta?4:0), getHeight()-(esCarta?4:0), this);
        }

        if (!esCarta)
        {
            g2.setPaint(Color.WHITE);
            g2.setFont(new Font("Comic sans", Font.ITALIC | Font.BOLD, 45));
            g2.drawString(valor+"", (valor > 9)?0:getWidth()/4, getHeight()/1.4f);
        }
    }
    
    public void setImagen(BufferedImage img)
    {
        imagen = img;
        repaint();
    }
    
    public void setImagen(String img)
    {
        try{
            imagen = ImageIO.read(new File(img));
        } catch (IOException e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    public void verImagen(boolean a)
    {
        visualizar = a;
        repaint();
    }
    
    public void setValor(int i)
    {
        valor = i;
    }
    
    public void reiniciar()
    {
        setValor(0);
        verImagen(esCarta);
    }
}
