/*
FUNCIONALIDAD:
Ilustracion TRANSFORM (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_transform_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_transform_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("transform");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(250, 250);

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
            int ancho=this.getSize().width;
            int largo=this.getSize().height;
            g2.setColor(Color.BLACK);
            g2.fill(new Rectangle2D.Float(0.0f,0.0f,ancho,largo));
            AffineTransform transformacion=g2.getTransform();
            transformacion.translate(ancho/2,largo/2);
            g2.transform(transformacion);
            transformacion.setToRotation(2*Math.PI/8.0);       
            for (int i=0;i<8; i++) {
                Random col=new Random();
                g2.setColor(new Color(col.nextInt(255),col.nextInt(255),col.nextInt(255)));
                g2.drawString("Programación II",0.0f,0.0f);
                g2.transform(transformacion);
            }
        }    
    }
}
