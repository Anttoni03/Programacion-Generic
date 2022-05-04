/*
FUNCIONALIDAD:
Ilustracion COMPOSITE (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_setComposite_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_setComposite_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Composite");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1030, 700);

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
              Graphics2D g2d = (Graphics2D)g;
              for(int i=0; i<11; i++) {
                    dibujarCuadrado(g2d, i*0.1F);      
              }
         }
         //método que lleva a cabo el dibujo de la composición de dos 
         //cuadrado compuestos con la modalidad SRC_OVER con diferentes
         //valores de transparencia
         private void dibujarCuadrado(Graphics2D g2d, float alfa) {
              int coordenada=10, dimension=60, desplazamiento=20;
              Composite composicionOriginal = g2d.getComposite();
              g2d.setPaint(Color.blue);
              Rectangle cuadradoDestino = new Rectangle(coordenada+desplazamiento, 
                      coordenada+desplazamiento, dimension,dimension);
              g2d.fill(cuadradoDestino);
              //asignación composición con la modalidad SRC_OVER y transparencia alfa
              g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alfa));
              g2d.setPaint(Color.green);
              Rectangle cuadradoFuente = new Rectangle(coordenada, coordenada, 
                      dimension, dimension);
              g2d.fill(cuadradoFuente);
              //resestablecimient composición original
              g2d.setComposite(composicionOriginal);
              //traslación
              g2d.translate((coordenada+dimension+desplazamiento), 0);
         } 
    }    

}
