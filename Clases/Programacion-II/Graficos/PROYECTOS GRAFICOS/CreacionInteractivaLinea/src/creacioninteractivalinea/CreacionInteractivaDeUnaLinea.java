/*
FUNCIONALIDAD:
CREACIÓN INTERACTIVA DE UNA LÍNEA

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */
package creacioninteractivalinea;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class CreacionInteractivaDeUnaLinea {   
    private PanelVisualizacion panel;
    private Shape linea;

    //declaración método main
    public static void main(String[] args) { 
        new CreacionInteractivaDeUnaLinea().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("CREACIÓN INTERACTIVA DE LÍNEAS");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    
        panelContenidos.setLayout(new FlowLayout());
        //DECLARACIÓN COMPONENTE JComponent
        panel=new PanelVisualizacion();
        //introducción componente panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(panel);  
        
        ventana.pack();
        ventana.setVisible(true);
        linea=panel.crearLinea(0,0,0,0);
    }
    
    public class PanelVisualizacion extends JComponent {
        private Point puntoInicial=null;
        private Color colorTrazado=Color.WHITE;

        public PanelVisualizacion() {
            super();
            addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent evento) { // cuando se presiona el mouse
                    puntoInicial = new Point(evento.getX(), evento.getY());
                    colorTrazado=Color.YELLOW;
                    repaint();
                }

                public void mouseReleased(MouseEvent evento) { // cuando se deja de presionar el mouse
                    linea = crearLinea(puntoInicial.x, puntoInicial.y, evento.getX(), evento.getY());
                    colorTrazado=Color.WHITE;
                    repaint();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {

                public void mouseDragged(MouseEvent e) { // cuando se esta arrastrando el mouse
                    linea = crearLinea(puntoInicial.x, puntoInicial.y, e.getX(), e.getY());
                    colorTrazado=Color.YELLOW;
                    repaint();
                }
            });
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,40.0f));
            pintarFondo(g2);
            g2.setColor(colorTrazado);
            g2.draw(linea);
        }
        
        private void pintarFondo(Graphics2D g2) {
            g2.setColor(Color.BLACK);
            Rectangle2D fondo=new Rectangle2D.Float(0,0,getWidth(),getHeight());
            g2.fill(fondo);
        }

        private Line2D.Float crearLinea(int x1, int y1, int x2, int y2) {
            return new Line2D.Float(x1, y1, x2, y2);
        }
    
        //Devolución de la dimensión de la componente
        @Override 
        public Dimension getPreferredSize() {
            return new Dimension(800,600);

        }
    }    
}
