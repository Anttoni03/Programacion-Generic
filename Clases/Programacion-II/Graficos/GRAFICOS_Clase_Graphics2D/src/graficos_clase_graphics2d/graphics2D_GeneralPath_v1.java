/*
FUNCIONALIDAD:
Ilustracion GeneralPath (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_GeneralPath_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_GeneralPath_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("GeneralPath");
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
            g2.setColor(Color.green);
            //Creacion de la figura con GeneralPath
            GeneralPath figura=new GeneralPath();
            figura.moveTo(50.0f,50.0f);
            figura.lineTo(100.0f,50.0f);
            figura.curveTo(120.0f,30.0f,120.0f,100.0f,180.0f,125.0f);
            figura.lineTo(50.0f,150.0f);
            figura.closePath();

            //Relleno y contorno
            g2.fill(figura);
            g2.setColor(Color.blue);
            g2.draw(figura);
        } 
    }
}
