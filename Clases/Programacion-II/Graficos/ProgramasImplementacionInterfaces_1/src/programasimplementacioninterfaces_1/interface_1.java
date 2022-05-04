/*
FUNCIONALIDAD: ventana con una resolución equivalente a la mitad de la pantalla
y visualizada en el centro de ésta. Como componente aparece una JLabel (etiqueta)
con el texto "ESTO ES UNA ETIQUETA".

INTERFACE: ver PDF ejemploGraficos_1_INTERFACE.pdf

autor: Juan Montes de Oca
 */

package programasimplementacioninterfaces_1;

import javax.swing.*;
import java.awt.*;

////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                             CLASE interface_1                              //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////  
public class interface_1 {
    //declaración método main
    public static void main(String[] args) { 
        new interface_1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("MI PRIMERA VENTANA");
        //DECLARACIÓN OBJETO Dimension PARA OBTENER LA DIMENSIÓN DE LA PANTALLA
        //EN LA QUE ESTEMOS EJECUTANDO
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        //DECLARACIÓN VARIABLES ENTERAS Y ASIGNACIÓN EN ELLAS DE LA RESOLUCIÓN
        //HORIZONTAL Y VERTICAL DE LA PANTALLA
        int dimensionX=(int) dimension.getWidth();
        int dimensionY=(int) dimension.getHeight();
        //DIMENSIONAR EL CONTENEDOR JFrame ventana CON LA MITAD DE LA RESOLUCIÓN
        //DE LA PANTALLA
        ventana.setSize(dimensionX/2, dimensionY/2);  

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane(); 
//        panelContenidos.setLayout(new FlowLayout());
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////      DECLARACIONES Y DEFINICIONES COMPONENTE JLabel     /////////////
        JLabel etiqueta=new JLabel("ESTO ES UNA ETIQUETA");
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(etiqueta);

        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}
