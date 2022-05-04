/*
CLASE PanelPersonalizado HEREDA DE LA CLASE JPanel
 */

package claseteoria___12_04_2022;
import java.awt.*;
import javax.swing.*;

public class PanelPersonalizado extends JPanel {
    //DECLARACIÓN DE ATRIBUTOS
    public final static int CIRCULO = 1, CUADRADO = 2;
    private int figura; // usar figura para dibujar un óvalo o rectángulo
    
    //MÉTODOS
    
    //MÉTODO paintComponent
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //lleva a cabo el trazado de un círculo o de un rectángulo en función del
        //valor del atributo figura
        if ( figura == CIRCULO ) {
            //trazado de un círculo
            g.fillOval(115,10,60,60);
        }
        else if ( figura == CUADRADO ) {
            //trazado de un cuadrado
            g.fillRect(115,10,60,60 );
        }
    }

    //MÉTODO QUE ASIGNA VALOR DADO AL ATRIBUTO figura Y REDIBUJA EL CONTENEDOR
    //JPanel 
    public void dibujar( int figuraADibujar ) {
            figura = figuraADibujar;
            repaint(); //llama a paintComponent
    }
}
