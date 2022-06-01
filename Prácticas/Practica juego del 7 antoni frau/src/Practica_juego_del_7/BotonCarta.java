/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_juego_del_7;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

class BotonCarta extends JButton {
    
    private BufferedImage imagen = null;
    private boolean visualizar;

    public BotonCarta() {}

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(new Color(30,110,30));
        Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());

        g2.fill(rec);

        if (imagen != null && visualizar)
            g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }

    public void reiniciar()
    {
        visualizar = false;
        setVisible(false);
        setEnabled(false);
        repaint();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(56, 82);
    }

    public void verImagen(boolean ver)
    {
        visualizar = ver;
    }

    public void iniciar(BufferedImage img)
    {
        imagen = img;
        visualizar = true;
        setEnabled(true);
        setVisible(true);
        repaint();
    }
}