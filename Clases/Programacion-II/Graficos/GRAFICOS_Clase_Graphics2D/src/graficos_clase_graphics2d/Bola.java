/*
CLASE BOLA
 */
package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class Bola extends JComponent {
    //DECLARACIÓN DE ATRIBUTOS
    private int x,y;
    private int diametro,direccionX=1,direccionY=1;
    private Color colorRelleno, colorTrazado;
    
    public Bola(int datoDiametro, int datoX, int datoY, Color datoColorTrazado, Color datoColorRelleno) {
        diametro=datoDiametro;
        x=datoX;
        y=datoY;
        colorTrazado=datoColorTrazado;
        colorRelleno=datoColorRelleno;
    }

    public void dibujar(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(colorRelleno);
        g2.fill(new Ellipse2D.Float(x,y,diametro,diametro));
        g2.setColor(colorTrazado);
        g2.draw(new Ellipse2D.Float(x,y,diametro,diametro));
    }    
    
    public void actualizacionCoordenada(int dimX, int dimY) {
        x += (1*direccionX);
        y += (1*direccionY);
        //verificación coordenada X
        if ( x > (dimX-50) ){
            direccionX=-1;
        }
        if (x < 0) {
            direccionX=1;
        }
        //verificación coordenada Y
        if ( y > (dimY-50) ){
            direccionY=-1;
        }
        if (y < 0) {
            direccionY=1;
        } 
    }
}
