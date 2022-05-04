/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN AdjustmentListener PARA TRATAMIENTO EVENTO AdjustmentEvent

autor: Juan Montes de Oca
 */
package programaciongrafica__eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class  eventos_AdjustmentListener {
    //declaración método main
    public static void main(String[] args) { 
        new eventos_AdjustmentListener().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {          
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame();  
        //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
        ventana.setTitle("ILUSTRACIÓN AdjustmentListener");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN COLOR DE FONDO AL PANEL DE CONTENIDOS panelContenidos
        panelContenidos.setBackground(Color.BLACK);
        //ASIGNACIÓN DEL GESTOR DE LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new BorderLayout());         
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////   DECLARACIONES Y DEFINICIONES COMPONENTE JScrollBar    /////////////  
        JScrollBar barraDesplazamiento = new JScrollBar(JScrollBar.HORIZONTAL, 
                0, 20, 0, 500); //orientación-valor inicial-desfase-valor mínimo-
                                //valor máximo
                                //el desfase hace que el valor máximo al
                                //que llega la barra de desplazamiento
                                //sea (maximo-desfase)
        //INTRODUCCIÓN COMPONENTE JScrollBar barraDesplazamiento EN EL PANEL DE CONTENIDOS 
        //panelContenidos EN EL AREA NORTE DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(barraDesplazamiento,BorderLayout.NORTH);
        
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JLabel      /////////////  
        JLabel etiqueta=new JLabel();
        //ASIGNACIÓN LITERAL A LA COMPONENTE JLabel eqtiqueta
        etiqueta.setText("                            VALOR ACTUAL BARRA "
                + "DE DESPLAZAMIENTO = " + barraDesplazamiento.getValue());
        //ASIGNACIÓN COLOR DE TRAZADO A LA COMPONENTE JLabel etiqueta
        etiqueta.setForeground(Color.WHITE);
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta EN EL PANEL DE CONTENIDOS 
        //panelContenidos EN EL AREA CENTRO DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(etiqueta,BorderLayout.CENTER);
        
///////////DECLARACIÓN Y ASIGNACIÓN DEL GESTOR DE EVENTOS AdjustmentEvent A LA COMPONENTE
        //JScrollBar barraDesplazamiento UTILIZANDO LA INTERFACE AdjustmentListener        
        barraDesplazamiento.addAdjustmentListener(new AdjustmentListener() {
              //TRATAMIENTO DEL EVENTO ItemEvent
              @Override
              public void adjustmentValueChanged(AdjustmentEvent e) {
                //asignación de nuevo texto a la componente etiqueta
                etiqueta.setText("                            VALOR ACTUAL BARRA "
                        + "DE DESPLAZAMIENTO = " + barraDesplazamiento.getValue());
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