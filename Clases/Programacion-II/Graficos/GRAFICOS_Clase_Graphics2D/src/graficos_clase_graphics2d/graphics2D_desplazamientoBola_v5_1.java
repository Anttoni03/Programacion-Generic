/*
FUNCIONALIDAD:
SIMULACIÓN DESPLAZAMIENTO BOLA A TRAVÉS DE LA VENTANA CON COLISIONES EN BORDES

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class graphics2D_desplazamientoBola_v5_1 {
    //DECLARACIÓN ATRIBUTOS
    private final int dimX=1000,dimY=500;
    private panelDibujo panel;
    Bola [] bolas;
    boolean par=true;
    
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_desplazamientoBola_v5_1().metodoPrincipal();
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
        
        //SOLICITUD NÚMERO DE BOLAS
        System.out.print("INTRODUCIR NÚMERO DE BOLAS: ");
        int numeroBolas=LT.readInt();
        //definición array bolas
        bolas=new Bola[numeroBolas];
        //instanciación componentes bolas del array bolas
        inicializacionBolas();
        
        
        
        //ajuste dimensión contenedor JFrame ventana en función de las entidades
        //introducidas en él
        ventana.pack();
        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
        
        movimientoBolas();
    }

    
    private void inicializacionBolas() {
        Random generador;
        int coordX, coordY;
        int diametro;
        Color colorTrazado, colorRelleno;       
        for (int indice=0; indice<bolas.length; indice++) {
            //generación aleatoria diametro
            generador=new Random();
            diametro=generador.nextInt(50)+20;
            generador=new Random();
            coordX=generador.nextInt(dimX)+generador.nextInt(10);
            generador=new Random();
            coordY=generador.nextInt(dimY)+generador.nextInt(10);
            colorTrazado=new Color(0,0,0);
            colorRelleno=new Color(generador.nextInt(256),generador.nextInt(256),generador.nextInt(256));       
            bolas[indice]=new Bola(diametro, coordX, coordY, colorTrazado, colorRelleno);    
        }      
    }
    
    //método que lleva a cabo la actualización de la coordenada de la bola
    //y gestionar el dibuijo de la misma
    public void movimientoBolas() {
        final int RETRASO=5;        
        while(true){
            for (int indice=0; indice<bolas.length; indice++) {
                bolas[indice].actualizacionCoordenada(dimX, dimY);
            }
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
        
    private class panelDibujo extends JComponent {   
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (int indice=0; indice<bolas.length; indice++) {                        
                bolas[indice].dibujar(g2);
            }
        }

        //El contenedor JPanel decide su tamaño en función de la dimensión de
        //imagen
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(dimX,dimY);
        }
    }    
}
