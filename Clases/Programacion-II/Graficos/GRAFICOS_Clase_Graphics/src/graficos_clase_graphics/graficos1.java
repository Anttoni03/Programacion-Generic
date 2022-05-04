/*
FUNCIONALIDAD:
Ilustracion drawLine

OBJETIVO: ilustración introducción Graphics

autor: Juan Montes de Oca
 */
package graficos_clase_graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.*;

public class graficos1 {
    //declaración método main
    public static void main(String[] args) { 
        new graficos1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

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
            //asignar como color de trazado el color negro
            g.setColor(Color.BLACK);
            //se visualiza un rectángulo de dimensión igual a la dimensión  de
            //del contenedor JPanel que se está instanciando
            g.fillRect(0,0, getWidth(), getHeight());
            //DIBUJAR UNA LÍNEA
            g.setColor(Color.green);
            g.drawLine(20,20,200,200);
        }
    }
}

