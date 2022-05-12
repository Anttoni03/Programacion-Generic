/*
FUNCIONALIDAD:
VISUALIZACIÓN INTERACTIVA CONTROLADA A TRAVÉS DE LOS BOTONES DEL RATÓN

OBJETIVO: introducción programación gráfica
 */

package visualizacioninteractivaconraton;


import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class visualizacionInteractivaControladaBotonesRaton {
    //DECLARACIÓN ATRIBUTOS
    //Declaración atributo entero figura que nos permitirá almacenar en ella el
    //botón pulsado (izquierdo (0), central (1), derecho (2)).
    private  int figura=0;
    private panelImagen panel;
    
    //declaración método main
    public static void main(String[] args) { 
        new visualizacionInteractivaControladaBotonesRaton().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("VISUALIZACIÓN INTERACTIVA");
        ventana.setSize(400, 300); 

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN COMPONENTE  JComponent
        panel=new panelImagen();
        //introducción componente panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(panel);
 
        //asociamos al JFrame ventana el gestor de eventos del ratón MouseListener. Tenemos
        //que tener en cuenta que el gestor de eventos MouseListener, al ser una
        //clase abstracta deberán de declararse todos los métodos que aglutina aunque
        //no los utilicemos (en ese caso su cuerpo de acciones estará vacio)
        //Los métodos que aglutina la clase MouseListener son: mousePressed, mouseClicked,
        //mouseReleased,mouseEntered y mouseExited.
        //En nuestro caso, como solo nos interesa el pulsar un botón, solo tendrá acciones
        //el método mousePressed
        ventana.addMouseListener(new MouseListener() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //asignamos al atributo figura el valor que le corresponde en función
                    //del botón pulsado
                    switch (e.getButton()) {
                            case 1: {figura=1;break;}
                            case 2: {figura=2;break;}
                            case 3: {figura=3;break;}
                    }     
                    //llamamos al método repaint() del panel para que desde este se ejecute el
                    //paint() y por lo tanto volveremos a redibujar lo que representa
                    //el método paint().
                    panel.repaint();            
                }
                public void mouseClicked(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}    
        });   

        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);

    }
    
    
    private class panelImagen extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            pintarFondo(g2);
            switch (figura) {
                case 1: {   //instanciación objeto Ellipse2D
                            Ellipse2D elipse=new Ellipse2D.Double(140,70,100,100);
                            //dibujo de un disco de color rojo
                            g2.setColor(Color.RED);
                            g2.fill(elipse);
                            break;
                        }
                case 2: {   //instanciación objeto Rectangle2D
                            Rectangle2D rectangulo=new Rectangle2D.Double(140,70,100,100);
                            //dibujo de un cuadrado de color azul
                            g2.setColor(Color.BLUE);
                            g2.fill(rectangulo);
                            break;
                        }
                case 3: {   //visualización del literal "HOLA" en color NEGRO
                            g2.setColor(Color.BLACK);
                            g2.drawString("HOLA",180,120);
                            break;
                        }
            }
        } 
        
        private void pintarFondo(Graphics2D g2) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,getWidth(),getHeight());
        }
    }    
}
