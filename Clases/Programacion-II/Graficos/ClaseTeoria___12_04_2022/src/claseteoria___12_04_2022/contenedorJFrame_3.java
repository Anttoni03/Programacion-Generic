/*
IDEM CLASE contenedorJFrame_2.java Y ADEMÁS:
    - ASIGNACIÓN COLOR DEL FONDO DEL CONTENEDOR JFrame CON setBackground(.
    - DECLARACIÓN PANEL DE CONTENIDOS getContentPane() DEL CONTENEDOR JFrame.
    - ASIGNACIÓN COLOR DEL FONDO DEL PANEL DE CONTENIDOS getContentPane() CON
    PARÁMETRO DE TRANSPARENCIA A TRAVÉS DEL CONSTRUCTOR Color(R,G,B,A) COMO 
    PARÁMETROS ENTEROS DENTRO DEL RANGO [0,255].
 */
package claseteoria___12_04_2022;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class contenedorJFrame_3 {
    //declaración método main
    public static void main(String[] args) { 
        new contenedorJFrame_3().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    private void metodoPrincipal() {    
/////////////               CONTENEDOR JFrame                   ////////////////        
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("MI PRIMERA VENTANA");
        //REDIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana
        ventana.setSize(500,300);
        //ASIGNACIÓN COLOR DEL FONDO AL CONTENEDOR JFrame ventana
        ventana.setBackground(Color.BLUE);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana CON LA CONSIGUIENTE FINALIZACIÓN DE LA EJECUCIÓN DE LA
        //APLICACIÓN
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN COLOR DEL FONDO AL PANEL DE CONTENIDOS panelContenidos
        //CON CANAL ALFA [transparencia --> 0, opacidad --> 255]
        panelContenidos.setBackground(new Color(255,0,0,125));        
    }
}
