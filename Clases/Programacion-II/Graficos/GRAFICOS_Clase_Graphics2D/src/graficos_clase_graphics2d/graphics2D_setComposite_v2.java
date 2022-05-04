/*
FUNCIONALIDAD:
Ilustracion COMPOSITE (Graphics2D)

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics2D_setComposite_v2 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_setComposite_v2().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Composite");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1200, 450);

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
    
    //CLASE PARA INSTANCIAR OBJETOS JPanel
    class panelDibujo extends JPanel {
        //método paint
        @Override
        public void paintComponent(Graphics g) {
            dibujar(g, 20, 20,  1.0);
            dibujar(g, 20, 140, 0.5);
            dibujar(g, 20, 260, 0.0);
        }
        //método que lleva a cabo la visualización de la composición de dos
        //rectángulos (fuente y destino) con todas las modalidades de
        //composición aplicando un valor de transparencia alfa
        private void dibujar(Graphics g, int x, int y, double alfa) {
            //declaración atributo array de enteros inicializado con las diferentes
            //modalidades de composición
            final int[] modalidadesComposicion={AlphaComposite.XOR, AlphaComposite.SRC_ATOP,
                AlphaComposite.SRC_OVER,AlphaComposite.SRC_IN,AlphaComposite.SRC_OUT,
                AlphaComposite.DST_ATOP,AlphaComposite.DST_OVER,AlphaComposite.DST_IN,
                AlphaComposite.DST_OUT,AlphaComposite.CLEAR};  
            //declaración atributo array de String con los literales que representan
            //la nomenclatura de las modalidades de composición
            final String[] nombreComposicion = {"  XOR  ","SRC_ATOP","SRC_OVER",
                "SRC_IN","SRC_OUT","DST_ATOP","DST_OVER","DST_IN","DST_OUT"," CLEAR "};   
            
            //declaración objeto Graphics2D a partir del objeto Graphics dado
            Graphics2D g2d = (Graphics2D) g.create();
            
            //asignar como color de trazado el BLANCO
            g2d.setPaint(Color.WHITE);
            //dibujar rectángulo relleno con el color de trazado dada las 
            //coordenadas que se utiliza como color de fondo de los rectángulos
            //dibujados para tener una visión nítida de la composición visualizada
            g2d.fillRect(x-20, y-10, 1200, y+120);
            //bucle de visualización de la composición de los rectángulos
            //fuente y destino con las coordenadas y modalidad de composición
            //correspondientes a la iteración del bucle y teniendo en cuenta
            //el valor alfa de transparencia dado por parámetro
            for (int indice = 0; indice < modalidadesComposicion.length; x+=100, indice++) {
                //declaración y definición del objeto AlphaComposite con
                //la mnodalidad de composición 
                AlphaComposite parametroComposicion=AlphaComposite.getInstance(modalidadesComposicion[indice],(float) alfa);
                //declaración objeto BufferedImage
                BufferedImage bufferImagen = new BufferedImage(100, 100,
                        BufferedImage.TYPE_INT_ARGB);
                //declaración objeto Graphics2D a partir de bufferImagen para poder
                //dibujar sobre él
                Graphics2D composiciones = bufferImagen.createGraphics();
                //asignación color de trazado del objeto composiciones
                composiciones.setPaint(Color.blue);
                //dibujar rectángulo destino de la iteración indice 
                composiciones.fillRect(0, 0, 80, 80);
                //asignación el parámetro composite del contexto del objeto composiciones
                composiciones.setComposite(parametroComposicion);
                //asignación color de trazado del objeto composiciones
                composiciones.setPaint(Color.green);
                //dibujar rectángulo fuente de la iteración indice teniendo en
                //cuenta la composición definida en el contexto
                composiciones.fillRect(10, 10, 80, 80);
                //dibujo de la imagen bufferImagen a través del objeto g2d
                g2d.drawImage(bufferImagen, x, y, null);
                //asignar color de trazado del objeto g2d
                g2d.setPaint(Color.BLACK);
                //visualizar texto literal de la modalidad de composición 
                //llevada a cabo en la iteración actual
                g2d.drawString(nombreComposicion[indice], (x+15), y+110);    
            }
            //visualizar texto de la transparencia aplicada en las composiciones
            //realizadas
            g2d.drawString("CANAL ALFA: "+alfa,(x+20),y+50);
        }
    }    
}
