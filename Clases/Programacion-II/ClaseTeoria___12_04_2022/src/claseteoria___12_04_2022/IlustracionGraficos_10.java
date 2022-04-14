/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE JLabel

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JLabel

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;


import java.awt.*;
import javax.swing.*;

public class IlustracionGraficos_10 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_10().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 6");    

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());      

        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////      DECLARACIONES Y DEFINICIONES COMPONENTE JLabel     /////////////
        JLabel etiqueta=new JLabel("SOY UNA ETIQUETA");
        //INTRODUCCIÓN COMPONENTE JList lista EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(etiqueta);

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.pack();
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}
