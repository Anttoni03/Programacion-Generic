/*
FUNCIONALIDAD:
    Ilustracion RENDERINGHINTS (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_RenderingHinst_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_RenderingHinst_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("RenderingHints");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 500);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN CONTENEDOR JPanel
        panelDibujo panel=new panelDibujo();
        //introducción contenedor JPanel panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(panel);
    
        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }
    
    class panelDibujo extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2=(Graphics2D)g;
            g2.setFont(new Font("Serif", Font.ITALIC, 60));
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            g2.drawString("TEXT_ANTIALIASING", 0, 60);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString("TEXT_ANTIALIASING_ON", 0, 150);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);            
            g2.setStroke(new BasicStroke(5f));
            g2.drawOval(20, 250, 60, 60);
            g2.drawLine(100, 250, 350, 325);
            g2.setFont(new Font("Serif", Font.PLAIN, 30));
            g2.drawString("SIN ANTIALIASING",400,320);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawOval(20, 350, 60, 60);
            g2.drawLine(100, 350, 350, 425);
            g2.drawString("CON ANTIALIASING",400,420);
        }
    }    
}
