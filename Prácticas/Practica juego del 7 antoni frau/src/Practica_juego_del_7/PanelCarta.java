package Practica_juego_del_7;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PanelCarta extends JPanel
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que indica la imagen del panel
    private BufferedImage imagen = null;
    //Atributo de objeto que indica si se usa o no como carta
    private boolean esCarta;
    //Atributo de objeto que indica se se debe visualizar la imagen
    private boolean visualizar;
    //Atributo de objeto que indica el valor numérico a mostrar
    private int valor = 0;
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor para instanciar objetos PanelCarta
    public PanelCarta(boolean carta)
    {
        esCarta = carta;
        visualizar = carta;
    }
    
    //Método sobreescrito paintComponent pinta los gráficos del elemento
    @Override
    public void paintComponent(Graphics g)
    {
        //obtener el pincel en Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        
        //definir un rectángulo y pintarlo de color verde oscuro
        Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
        g2.setPaint(new Color(30,110,30));
        g2.fill(rec);
        
        //si se debe visualizar se pinta la imagen con desplazamiento si debe
        if (imagen != null && visualizar)
        {
            g2.drawImage(imagen, esCarta?4:0, esCarta?4:0, 
                    getWidth()-(esCarta?4:0), getHeight()-(esCarta?4:0), this);
        }
        
        //si no actúa como carta se pinta el valor numérico
        if (!esCarta)
        {
            //definir el color y la fuente
            g2.setPaint(Color.WHITE);
            g2.setFont(new Font("Comic sans", Font.ITALIC | Font.BOLD, 45));
            //pintar el valor con el espaciado necesario para estar centrado
            g2.drawString(valor+"", (valor > 9)?0:getWidth()/4, getHeight()/1.4f);
        }
    }
    
    //Método setImagen que aplica la imagen dada como imagen
    public void setImagen(BufferedImage img)
    {
        imagen = img;
        repaint();
    }
    //Método setImagen que aplica la imagen dada por texto
    public void setImagen(String img)
    {
        try{
            imagen = ImageIO.read(new File(img));
        } catch (IOException e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    //Método setVisualizar que indica se se debe visualizar o no la imagen
    public void setVisualizar(boolean ver)
    {
        visualizar = ver;
        repaint();
    }
    //Método setValor que aplica el valor numérico dado
    public void setValor(int i)
    {
        valor = i;
    }
    
    //Método reiniciar que aplica valores por defecto al panel
    public void reiniciar()
    {
        //da un valor de 0 por defecto
        setValor(0);
        //indica que se visualice si actúa como carta
        setVisualizar(esCarta);
    }
}
