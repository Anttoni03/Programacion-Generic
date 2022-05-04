/*
FUNCIONALIDAD:
CARGA IMÁGEN A TRAVÉS DE BufferedImage y  visualización.
Posterior dibujo sobre la imagen visualizada.

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_Imagenes_v5_1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_Imagenes_v5_1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Stroke");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN CONTENEDOR JPanel
        panelImagen panel=new panelImagen("fondo.jpg");
        //introducción contenedor JPanel panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(panel);
        
        //ajuste dimensión contenedor JFrame ventana en función de las entidades
        //introducidas en él
        ventana.pack();
        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }
    
    private class panelImagen extends JPanel {
        private BufferedImage imagen=null;

        public panelImagen(String nombre) {
            try {
                imagen = ImageIO.read(new File(nombre));
            } catch (IOException e) {
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(imagen,null,0,0);
            g2d.setColor(Color.yellow);
            g2d.fillOval(imagen.getWidth()/2-100, imagen.getHeight()/2-100, imagen.getWidth()/2, 
                             imagen.getHeight()/2);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 25));
            g2d.drawString("EDIFICIO ANSELM TURMEDA", imagen.getWidth()/2-50, imagen.getHeight()/2+30);
        }

        //El contenedor JPanel decide su tamaño en función de la dimensión de
        //imagen
        @Override
        public Dimension getPreferredSize() {
            if (imagen == null) {
                return new Dimension(200, 200);
            } else {
                return new Dimension(imagen.getWidth(), imagen.getHeight());
            }
        }
    }    
}
