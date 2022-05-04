/*
FUNCIONALIDAD:
Ilustracion Figuras Geométricas (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_FigurasGeometricas_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_FigurasGeometricas_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("GeneralPath");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(250, 350);

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
            Rectangle2D rectangulo1=new Rectangle2D.Float(50.0f,50.0f,110.0f,200.0f);
            RoundRectangle2D rectangulo2=
                    new RoundRectangle2D.Float(60.0f,60.0f,90.0f,180.0f,25.0f,25.0f);
            Ellipse2D elipse=new Ellipse2D.Float(100.0f,80.0f,10.0f,10.0f);
            g2.draw(rectangulo1);
            g2.draw(rectangulo2);
            g2.draw(elipse);
        } 
    }
}
