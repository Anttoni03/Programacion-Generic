/*
FUNCIONALIDAD:
Ilustracion CLIPPING PATH (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_clipping_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_clipping_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Clipping");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(210, 220);

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
           //declaración objeto elipse
           Ellipse2D elipse=new Ellipse2D.Float(30,30,120,120);
           //definición área de clipping con la figura dada por el objeto elipse
           g2.setClip(elipse);

           //PARA VER EL ÁREA DE CLIPPING DIBUJADA PODÉIS ACTIVAR LAS
           //SIGUIENTES SENTENCIAS Y PONER EN COMENTARIO LA SENTENCIA ANTERIOR
//           g2.setColor(Color.YELLOW);
//           //dibujo del objeto rectangulo aplicando el clipping asignado sobre él
//           g2.fill(elipse);  

           //declaración objeto rectangulo
           Rectangle2D rectangulo=new Rectangle2D.Float(40,40,100,100);
           g2.setColor(Color.BLUE);
           //dibujo del objeto rectangulo aplicando el clipping definido
           g2.fill(rectangulo);  
        }   
    }
}
