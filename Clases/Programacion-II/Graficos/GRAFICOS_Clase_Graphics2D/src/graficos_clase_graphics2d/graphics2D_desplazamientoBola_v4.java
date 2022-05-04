/*
FUNCIONALIDAD:
SIMULACIÓN DESPLAZAMIENTO DE UNA BOLA DESDE UNA POSICIÓN INICIAL A UNA POSICIÓN
FINAL

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
import static java.lang.Math.sqrt;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_desplazamientoBola_v4 {
    //DECLARACIÓN ATRIBUTOS
    private final int dimX=1000,dimY=500;
    private double x=-50,y=200,destinoX,destinoY,incrementoX,incrementoY;
    private panelDibujo panel;
    
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_desplazamientoBola_v4().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  

        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("DESPLAZAMIENTO BOLA");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN COMPONENTE JComponent
        panel=new panelDibujo();
        //introducción componente panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(panel);
        
        
        obtencionCoordenadas();
        
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

    //método que lleva a cabo la actualización de la coordenada de la bola
    //y gestionar el dibuijo de la misma
    private void movimientoBola() {
        final int RETRASO=5;
        
        calculoIncrementosCoordenadas();
        while (!((Math.abs(Math.abs(x)-Math.abs(destinoX))<1)
                &&(Math.abs(Math.abs(y)-Math.abs(destinoY))<1))){
            actualizacionCoordenadaBola();
            panel.repaint();
            try{
                //PARALIZACIÓN DE LA EJECUCIÓN DURANTE RETRASO/1000 SEGUNDOS
                //PARA SIMULAR LA VELOCIDAD DEL MOVIMIENTO DE LA
                //FIGURA ELIPSE
                Thread.sleep(RETRASO);
            }catch(InterruptedException err){
                System.out.println(err);
            }
            calculoIncrementosCoordenadas();
        }
    }
    
    private void obtencionCoordenadas() {
        //lectura coordneada inicial y coordenada final de la bola
        System.out.print("COORDENADA x inicial bola: ");
        x=LT.readDouble();
        System.out.print("COORDENADA y inicial bola: ");
        y=LT.readDouble();
        System.out.print("COORDENADA x destino bola: ");
        destinoX=LT.readDouble();
        System.out.print("COORDENADA y destino bola: ");
        destinoY=LT.readDouble();        
    }

    //método que lleva a cabo la actualización de la coordenada de la bola
    private void actualizacionCoordenadaBola(){
        x += incrementoX;
        y += incrementoY;
    }

    //método que lleva a cabo el incremento de la coordenada de la bola
    //en función de la distancia a la coordenada destino
    private void calculoIncrementosCoordenadas() {
        double distanciax,distanciay;
        distanciax=destinoX-x;
        distanciay=destinoY-y;
        incrementoX=1*((distanciax)/
                (sqrt((distanciax*distanciax)+(distanciay*distanciay))));
        incrementoY=1*((distanciay)/
                (sqrt((distanciax*distanciax)+(distanciay*distanciay))));
    }
        
    private class panelDibujo extends JComponent {   

        @Override
        public void paintComponent(Graphics g) {       
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.RED);
            g2d.fill(new Ellipse2D.Double(x,y,50,50));
            g2d.setColor(Color.BLACK);
            g2d.draw(new Ellipse2D.Double(x,y,50,50));       
        }
        
        //El contenedor JPanel decide su tamaño en función de la dimensión de
        //imagen
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(dimX,dimY);
        }
    }    
}
