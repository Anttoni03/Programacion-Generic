/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_juego_del_7;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

class TextoJugador extends JPanel {
    
    private int valor;

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(40,150,40));
        Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());

        g2.fill(rec);

        g2.setPaint(Color.WHITE);
        g2.setFont(new Font("Comic sans", Font.ITALIC | Font.BOLD, 30));
        g2.drawString(valor+"", (valor < 10) ? 25 : 16, 25);
    }

    public void reiniciar()
    {
        setValor(0);
        repaint();
    }

    public void setValor(int i)
    {
        valor = i;
    }
}