/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN WindowListener PARA TRATAMIENTO EVENTO WindowEvent

autor: Juan Montes de Oca
 */

package programaciongrafica__eventos;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class  eventos_WindowListener {
    //declaración método main
    public static void main(String[] args) { 
        new eventos_WindowListener().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {          
////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN CONTENEDOR JFrame                          //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame();  
        //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
        ventana.setTitle("ILUSTRACIÓN WindowListener");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();


        
////////////////////////////////////////////////////////////////////////////////
///  DECLARACIÓN GESTOR DE EVENTOS WindowEvent ASOCIADO AL CONTENEDRO JFrame  //
///  CON INTERFACE WindowListener                                             //
//////////////////////////////////////////////////////////////////////////////// 
        ventana.addWindowListener(new WindowListener() {
            //TRATAMIENTO DEL EVENTO WindowEvent
            @Override
            public void windowOpened(WindowEvent evento) {
                JOptionPane.showMessageDialog(ventana, "VENTANA ABIERTA "
                        + "POR PRIMERA VEZ");
            }
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(ventana,"LA VENTANA SE VA "
                        + "A CERRAR Y LA APLICACIÓN VA A FINALIZAR");
                System.exit(0);
            }
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("VENTANA CERRADA");
            }
            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("VENTANA MINIMIZADA");
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("VENTANA MAXIMIZADA");
            }
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("VENTANA ACTIVA");
                //fondo panel de contenidos CYAN
                panelContenidos.setBackground(Color.CYAN);
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("VENTANA NO ACTIVA");
                //fondo panel de contenidos BLACK
                panelContenidos.setBackground(Color.BLACK);
            }
        });

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(500,100);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}