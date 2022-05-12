/*
VISUALIZACIÓN ANIMACIÓN GIF
 */
package visualizadoranimaciongif;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VisualizadorAnimacionGif  {
    //declaración método main
    public static void main(String[] args) { 
        new VisualizadorAnimacionGif().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("VISUALIZACIÓN ANIMACIÓN GIF");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane(); 
        panelContenidos.setLayout(new BorderLayout());
        
        JLabel EtiquetaTitulo=new JLabel();
        EtiquetaTitulo.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 32));
        EtiquetaTitulo.setText("        LOS MINIONS");
        panelContenidos.add(EtiquetaTitulo, java.awt.BorderLayout.NORTH);           

        JLabel EtiquetaImagen=new JLabel();
        EtiquetaImagen.setIcon(new ImageIcon("minions.gif"));
        panelContenidos.add(EtiquetaImagen, java.awt.BorderLayout.CENTER);
        
        //ajuste dimensión contenedor JFrame ventana en función de las entidades
        //introducidas en él
        ventana.pack();
        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }


}
