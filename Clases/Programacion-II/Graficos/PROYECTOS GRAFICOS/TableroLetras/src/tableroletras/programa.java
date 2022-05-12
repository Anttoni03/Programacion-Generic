/*
FUNCIONALIDAD:
ILUSTRACIÓN DE LA VISUALIZACIÓN DE UN TABLERO DE CASILLAS CON EL QUE SE PUEDE
INTERACTUAR SELECCIONANDO CON EL RATÓN LAS CASILLAS QUE LO COMPONEN.

NOTA --> SE HAN REALIZADO 3 VERSIONES DIFERENCIADAS EN LA COMPONENTE UTILIZADA PARA
REPRESENTAR LAS CASILLAS DEL TABLERO: JLabel, JButton y JPanel.

autor: Juan Montes de Oca
 */

package tableroletras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class programa {
    //declaración método main
    public static void main(String[] args) {
        new programa().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("TABLERO DE LETRAS"); 

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane(); 
        panelContenidos.setLayout(new BorderLayout());
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////DECLARACIÓN CONTENEDOR JPanel
        TableroEtiquetas panel=new TableroEtiquetas();
//        TableroBotones panel=new TableroBotones();
//        TableroPaneles panel=new TableroPaneles();
        panelContenidos.add(panel,BorderLayout.CENTER);
      
        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(530, 900);
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}