/*
FUNCIONALIDAD:
SIMULACIÓN DESPLAZAMIENTO HORIZONTAL BOLA A TRAVÉS DE LA VENTANA CON 
COLISIONES EN BORDES VERTICALES

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class graphics2D_desplazamientoBola_v2 {
    //DECLARACIÓN ATRIBUTOS
    private final int dimX=1000,dimY=500;
    private int x=-50,y=200;  
    private int direccion=1;
    private panelImagen panel;
    
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_desplazamientoBola_v2().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("DESPLAZAMIENTO BOLA");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN COMPONENTE JComponent
        panel=new panelImagen();
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
        
        movimientoBola();
    }
    
    //método que lleva a cabo la gestión del movimiento de la bola actualizando
    //y verificando las abcisas
    private void movimientoBola() {
        final int RETRASO=5;
        
        while(true){
            actualizacionX();
            panel.repaint();
            try{
                //PARALIZACIÓN DE LA EJECUCIÓN DURANTE RETRASO/1000 SEGUNDOS
                //PARA SIMULAR LA VELOCIDAD DEL MOVIMIENTO DE LA
                //FIGURA ELIPSE
                Thread.sleep(RETRASO);
            }catch(InterruptedException err){
                System.out.println(err);
            }
        }
    }

    //método que lleva a cabo la verificación y actualización de las abcisas 
    //gestionando las colisiones con los bordes verticales del contenedor
    private void actualizacionX(){
        x += (1*direccion);
        if ( x > (dimX-50) ){
            direccion=-1;
        }
        if (x < 0) {
            direccion=1;
        }
    }
    
    private class panelImagen extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.RED);
            g2d.fill(new Ellipse2D.Float(x,y,50,50));
            g2d.setColor(Color.BLACK);
            g2d.draw(new Ellipse2D.Float(x,y,50,50));
        }

        //El contenedor JPanel decide su tamaño en función de la dimensión de
        //imagen
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(dimX,dimY);
        }
    }    
}
