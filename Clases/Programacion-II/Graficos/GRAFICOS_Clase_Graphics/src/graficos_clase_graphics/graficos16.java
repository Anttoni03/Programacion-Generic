/*
FUNCIONALIDAD:
Ilustracion drawPolyline

OBJETIVO: ilustración introducción Graphics

autor: Juan Montes de Oca
 */
package graficos_clase_graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.*;
public class graficos16 {
    //declaración método main
    public static void main(String[] args) { 
        new graficos16().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);

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
        public void paint(Graphics g) {
            //COLOREAR EL FONDO DE COLOR NEGRO
            g.setColor(Color.BLACK);
            g.fillRect(0,0, getWidth(), getHeight());
            //DIBUJAR UNA POLILINEA A PARTIR DE LOS ARRAYS DE SUS PUNTOS 
            g.setColor(Color.green);
            int[] x={100, 150, 170, 190, 200};
            int[] y={120, 280, 200, 250, 60};
            g.drawPolyline(x, y, x.length);      
        }
    }
}
