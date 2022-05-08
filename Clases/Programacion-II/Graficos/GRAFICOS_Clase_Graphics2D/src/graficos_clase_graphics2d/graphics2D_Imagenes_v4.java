/*
FUNCIONALIDAD:
CARGA IMÁGENES A TRAVÉS DE BufferedImage y posterior visualización DE UNA 
DESPLAZÁNDOSE SOBRE LA OTRA.

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_Imagenes_v4 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_Imagenes_v4().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("VISUALIZACIÓN Y MOVIMIENTO DE IMÁGENES");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN COMPONENTE JComponent
        panelImagen panel=new panelImagen("fondo.jpg","uib.png");
        //introducción componente panel en el panel de contenidos 
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
        
        panel.movimiento();
    }
    
    private class panelImagen extends JComponent {
        private BufferedImage fondo=null,motivo=null;
        private int x=-70,y=200;   
        private final int RETARDO=5;

        public panelImagen(String nombreFondo,String nombreMotivo) {
            try {
                fondo = ImageIO.read(new File(nombreFondo));
                motivo = ImageIO.read(new File(nombreMotivo));                   
            } catch (IOException e) {
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            //Utilizamos Graphics2D para la visualización
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(fondo,0,0,this);
            g2d.drawImage(motivo,x,y,this);
        }
    
        //El contenedor JPanel decide su tamaño en función de la dimensión de
        //imagen
        @Override
        public Dimension getPreferredSize() {
            if (fondo == null) {
                return new Dimension(200, 200);
            } else {
                return new Dimension(fondo.getWidth(), fondo.getHeight());
            }
        }

        public void movimiento() {
            while(true){
                ciclo();
                repaint();
                try{
                    Thread.sleep(RETARDO);
                }catch(InterruptedException err){
                    System.out.println(err);
                }
            }
        }

        public void ciclo(){
            x += 1;
            if ( x > (890+70) ){
                x = -70;
            }
        }
    }    
}
