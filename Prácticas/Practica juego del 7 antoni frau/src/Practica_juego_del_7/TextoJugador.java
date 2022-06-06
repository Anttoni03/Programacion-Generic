//AUTOR: Antoni Frau Gordiola
package Practica_juego_del_7;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

class TextoJugador extends JPanel
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que indica el valor numérico a mostrar
    private int valor;

    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método sobreescrito paintComponent pinta los gráficos del elemento
    @Override
    public void paintComponent(Graphics g)
    {
        //obtener el pincel en Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        
        //definir un rectángulo y pintarlo de color verde oscuro
        Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
        g2.setPaint(new Color(40,150,40));
        g2.fill(rec);

        //definir el color y fuente del texto
        g2.setPaint(Color.WHITE);
        g2.setFont(new Font("Comic sans", Font.ITALIC | Font.BOLD, 30));
        //pintar el texto con un espaciado variable para mantenerlo centrado
        g2.drawString(valor+"", (valor < 10) ? 25 : 16, 25);
    }

    //Método reiniciar que aplica valores por defecto al panel
    public void reiniciar()
    {
        //da un valor de 0 por defecto
        setValor(0);
        //repinta la imagen
        repaint();
    }

    //Método setValor que aplica el valor numérico dado al texto
    public void setValor(int i)
    {
        valor = i;
    }
}