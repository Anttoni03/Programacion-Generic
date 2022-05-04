/*
FUNCIONALIDAD:
CARGA IMAGEN A TRAVÉS DE java.awt.Toolkit. con getImage y posterior 
visualización (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class graphics2D_Imagenes_v2 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_Imagenes_v2().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("VISUALIZADOR IMAGEN");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN COMPONENTE JComponent        
        panelImagen panel=new panelImagen("mafalda.jpg");
        //introducción componente JComponent panel en el panel de contenidos 
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
    
    private class panelImagen extends JComponent {
        private Image imagen;

        public panelImagen(String nombre) {
            imagen = Toolkit.getDefaultToolkit().getImage(nombre);
            // las dos sentencias posteriores han sido
            // declaradas para dar tiempo a la carga
            // de la imagen y de esta forma ver
            // una de las diferencias que presenta este 
            // método con el de BufferedImage.
            int ancho=imagen.getWidth(this);
            int alto=imagen.getHeight(this);
        }

        @Override
        public void paintComponent(Graphics g) {            
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(imagen,0,0,this);
        }    

        //El contenedor JPanel decide su tamaño en función de la dimensión de
        //imagen
        @Override
        public Dimension getPreferredSize() {
            if (imagen == null) {
                return new Dimension(200, 200);
            } else {
                return new Dimension(imagen.getWidth(this), imagen.getHeight(this));
            }
        }
    }    
}
