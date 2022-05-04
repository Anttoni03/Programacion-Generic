/*
FUNCIONALIDAD:
Ilustracion STROKE (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_Stroke_v1 {
    Color color=Color.YELLOW;
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_Stroke_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Stroke");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane(); 
        panelContenidos.setLayout(new BorderLayout());

        //DECLARACIÓN CONTENEDOR JPanel
        panelDibujo panel=new panelDibujo();
        //introducción contenedor JPanel panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(panel,BorderLayout.CENTER);
        ventana.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    //implementación código gestión evento al clickar ratón
            }
            @Override
            public void mousePressed(MouseEvent e) {
                    //implementación código gestión evento al pulsar botón
                    color=Color.RED;
                    panel.repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                    //implementación código gestión evento al soltar botón
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                    //implementación código gestión evento al entrar el ratón en la fuente 	
            }
            @Override
            public void mouseExited(MouseEvent e) {
                    //implementación código gestión evento al salir el ratón de la fuente
            }
        } );   

        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
        inicializar();
    }
    
    public void inicializar() {
        color=Color.black;
    }
    
    class panelDibujo extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            //declaración de atributos
            //declaraxión array de patrones de trazado
            float[] patrones = {20.0f,10.0f,5.0f,10.0f};
            //declaración objeto Graphcis2D a partir del objeto Graphics g
            Graphics2D g2=(Graphics2D)g;
            Rectangle2D rectangulo=new Rectangle2D.Float(40,30,300,200);
            Line2D linea=new Line2D.Float(100,100,200,200);
            //DECLARACIÓN CARACTERISTICAS 1 ATRIBUTO STROKE 
//            g2.setStroke(new BasicStroke(40.0f,
//                BasicStroke.CAP_SQUARE,
//                BasicStroke.JOIN_ROUND,
//                40.0f));
            //DECLARACIÓN CARACTERISTICAS 2 ATRUBUTO STROKE
            g2.setStroke(new BasicStroke(3.0f,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_MITER,
                2.0f, patrones, 0.0f));
//nota: HAY QUE PONER EN COMENTARIO LAS DOS CARCATERÍSTICAS PARA VER
//LAS PRESTACIONES DEL PINCEL POR DEFECTO. PONER UNA DE LAS DOS EN
//COMENTARIO PARA PODER VER LAS PRESTACIONES DEL PINCEL SEGÚN LAS 
//CARACTERÍSTICAS CON LAS QUE HEMOS DEFINIDO EL ATRIBUTO STROKE DEL PINCEL
            g2.setColor(color);
            g2.draw(linea);
            g2.draw(rectangulo);
        }
    }    
}
