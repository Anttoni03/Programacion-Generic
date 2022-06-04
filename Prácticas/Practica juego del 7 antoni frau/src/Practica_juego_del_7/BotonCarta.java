// AUTOR: Antoni Frau Gordiola
package Practica_juego_del_7;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

class BotonCarta extends JButton
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que indica la imagen que se visualiza
    private BufferedImage imagen = null;
    //Atributo de objeto que indica si se debe o no visualizar el elemento
    private boolean visualizar;

    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor para instanciar objetos BotonCarta
    public BotonCarta() {}

    //Método sobreescrito paintComponent que pinta los gráficos del elemento
    @Override
    public void paintComponent(Graphics g)
    {
        //obtener el pincel en Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        
        //definir un rectángulo y pintarlo de color verde oscuro
        Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
        g2.setPaint(new Color(30,110,30));
        g2.fill(rec);
        
        //si se debe visualizar se pinta la imagen
        if (imagen != null && visualizar)
            g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }

    //Método reiniciar que asigna valores por defecto de reinicio al objeto
    public void reiniciar()
    {
        //los valores por defecto son sin mostrar imagen, invisible y no activo
        visualizar = false;
        setVisible(false);
        setEnabled(false);
        //repintar el elemento
        repaint();
    }
    
    //Método sobreescrito getPreferredSize para asignarle un tamaño por defecto
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(56, 82);
    }

    //Método setVisualizar que indica si la imagen se debe ver o no
    public void setVisualizar(boolean ver)
    {
        visualizar = ver;
    }

    //Método iniciar que aplica valores de inicio del elemento
    public void iniciar(BufferedImage img)
    {
        //asignar la imagen dada
        imagen = img;
        //los valores de inicio son mostrando imagen, visible y activo
        visualizar = true;
        setEnabled(true);
        setVisible(true);
        //repintar el elemento
        repaint();
    }
}