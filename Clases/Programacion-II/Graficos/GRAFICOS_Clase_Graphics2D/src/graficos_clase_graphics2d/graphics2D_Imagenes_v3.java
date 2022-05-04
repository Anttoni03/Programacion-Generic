/*
FUNCIONALIDAD:
CARGA IMAGEN A TRAVÉS DE BufferedImage y posterior visualización dividida
en 9 partes. Posteriormente graba las 9 partes en ficheros imagen jpg.

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package graficos_clase_graphics2d;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class graphics2D_Imagenes_v3 {
    //declaración método main
    public static void main(String[] args) { 
        new graphics2D_Imagenes_v3().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Stroke");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN COMPONENTE JComponent
        panelImagen panel=new panelImagen("mafalda.jpg");
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
        
        panel.generaciónImagenesRecortes();
    }
    
    private class panelImagen extends JComponent {
        private BufferedImage imagen;

        public panelImagen(String nombre) {
            try {
                imagen = ImageIO.read(new File(nombre));
            } catch (IOException e) {
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            //Utilizamos Graphics2D para la visualización
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(imagen,0,0,this);
            //visualización malla de subdivisión de la imagen en 9 partes
            int y = 0;            
            for (int i = 0; i < 3; i++) {                
                int x = 0;                
                for (int j = 0; j < 3; j++) {                   
                    Rectangle2D.Float r = new Rectangle2D.Float(x, y, 100, 100);                   
                    g2d.draw(r);                   
                    x += 100;               
                }               
                y += 100;           
            }   
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
        
        //método que lleva a cabo el recorte de una imagen en 9 partes iguales
        //grabando cada uno de los recortres como una nueva imagen en formato
        //jpg.
        public void generaciónImagenesRecortes() {
            int y = 0;
            int k = 0;
            for (int i = 0; i < 3; i++) {
                int x = 0;
                for (int j = 0; j < 3; j++) {
                    BufferedImage imagenBuffer = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                    Graphics2D fichero = imagenBuffer.createGraphics();
                    BufferedImage imagenSalida = imagen.getSubimage(x, y, 100, 100);
                    fichero.drawImage(imagenSalida, null, 0, 0);
                    try {
                        ImageIO.write(imagenBuffer, "jpg", new File("recorte" + k + ".jpg"));
                    } catch (IOException ex) {
                        System.out.println("ERROR grabando la imagen: " + ex.getMessage());
                    }
                    x += 100;
                    k++;
                }
                y += 100;
            }
        }
    }    
}
