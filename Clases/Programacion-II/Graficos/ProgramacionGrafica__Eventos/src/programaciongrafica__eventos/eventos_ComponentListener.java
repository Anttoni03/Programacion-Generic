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
public class  eventos_ComponentListener {
    //declaración método main
    public static void main(String[] args) { 
        new eventos_ComponentListener().metodoPrincipal();
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
        ventana.setTitle("ILUSTRACIÓN ComponentListener");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();


        
////////////////////////////////////////////////////////////////////////////////
///  DECLARACIÓN GESTOR DE EVENTOS WindowEvent ASOCIADO AL CONTENEDOR JFrame  //
///  CON INTERFACE ComponentListener                                             //
//////////////////////////////////////////////////////////////////////////////// 
        ventana.addComponentListener(new ComponentListener() {
	@Override
                public void componentHidden(ComponentEvent e) {
                        //implementación código gestión evento
                }
                @Override
                public void componentShown(ComponentEvent e) {
                        //implementación código gestión evento
                }
                @Override
                public void componentMoved(ComponentEvent e) {
                        System.out.println("VENTANA SE HA MOVIDO");
                }
                @Override
                public void componentResized(ComponentEvent e) {
                        System.out.println("VENTANA HA CAMBIADO DE TAMAÑO");
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