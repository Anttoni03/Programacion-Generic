/*
FUNCIONALIDAD:
Ilustracion PAINT (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Color;
import java.awt.Container;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_setPaint_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_setPaint_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Paint");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 700);

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
            //declaración objeto Graphcis2D a partir del obejto Graphics g
            Graphics2D g2=(Graphics2D)g;
//ILUSTRACIÓN 1: ATRIBUTO PAINT UTILIZANDO SOLO COLOR
            //declaración objeto Rectangle2D
//            Rectangle2D rectangulo1=new Rectangle2D.Float(40,30,300,200);
//            //asignación con el método setPaint del color de pintado del objeto g2
//            g2.setPaint(Color.RED);
//            //pintado del rectángulo definido
//            g2.fill(rectangulo1);
            
//ILUSTRACIÓN 2: ATRIBUTO PAINT CON DEGRADADOS      
//            //declaración objeto Rectangle2D
//            Rectangle2D rectangulo2=new Rectangle2D.Float(40,40,300,200);
//            Rectangle2D rectangulo3=new Rectangle2D.Float(350,40,300,200);
//            Rectangle2D rectangulo4=new Rectangle2D.Float(660,40,300,200);
//            //declaración diferentes objetos GradientPaint que me posibilitan definir
//            //diferentes tipos de degradados(horizonatl, vertical, diagonal) a partir 
//            //de dos colores 
//            GradientPaint verticalGradient = new GradientPaint(40, 40, Color.YELLOW, 340, 240, Color.RED);
//            GradientPaint diagonalGradient = new GradientPaint(350, 40, Color.YELLOW, 650, 240, Color.RED);
//            GradientPaint horizontalGradient = new GradientPaint(660,40, Color.YELLOW, 960, 240, Color.RED);
//            g2.setPaint(verticalGradient);
//            g2.fill(rectangulo2);
//            g2.setPaint(diagonalGradient);
//            g2.fill(rectangulo3);
//            g2.setPaint(horizontalGradient);
//            g2.fill(rectangulo4);

//ILUSTRACIÓN 3: ATRIBUTO PAINT CON TEXTURAS (IMÁGENES)
            BufferedImage imagen = null;
            try {
                imagen = ImageIO.read (new File("luna.jpg"));
            }catch (IOException e) {}
            Rectangle rectanguloTextura = new Rectangle(10, 10, 60,30);
            TexturePaint tp = new TexturePaint(imagen, rectanguloTextura);
            Rectangle2D rectangulo1=new Rectangle2D.Float(40,30,300,200);
            g2.setPaint(tp);
            g2.fill(rectangulo1);
        }
    }    

}
