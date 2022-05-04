/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE JScrollBar

OBJETIVO: ilustración introducción componentes swing JAVA

autor: Juan Montes de Oca
 */
package interfacesgraficasusuario_ii;

import javax.swing.*;
import java.awt.*;

public class IlustracionGraficos_32 {
    //declaración método main
    public static void main(String[] args) { 
        new IlustracionGraficos_32().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("EJEMPLO COMPONENTE JScrollBar");

        //redimensionamiento contenedor JFrame ventana
        ventana.setSize(300, 150);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();
        //asignación administrador de layout FlowLayout al panel de contenidos
        panelContenidos.setLayout(new FlowLayout());

        
        //DECLARACIÓN componentes JScrollBar 
        JScrollBar una = new JScrollBar( Scrollbar.VERTICAL,0,1,0,255 );
                               //orientación-valor inicial-desfase-valor mínimo-
                               //valor máximo
                               //el desfase hace que el valor máximo al
                               //que llega la barra de desplazamiento
                               //sea (maximo-desfase)
        JScrollBar dos = new JScrollBar( Scrollbar.VERTICAL,0,1,0,255 );
        JScrollBar tres = new JScrollBar( Scrollbar.VERTICAL,0,1,0,255 );

        //INTRODUCCIÓN componentes JScrollBar EN EL PANEL DE CONTENIDOS
        //DEL CONTENEDOR JFrame
        panelContenidos.add(una);
        panelContenidos.add(dos);
        panelContenidos.add(tres);

        
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //activación cierre ejecución con salida ventana de windows
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // VISUALIZACION del contenedor JFrame ventana
        ventana.setVisible(true);
    }
}

