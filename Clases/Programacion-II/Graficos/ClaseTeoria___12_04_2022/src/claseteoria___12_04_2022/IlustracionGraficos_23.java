/*
FUNCIONALIDAD:
EJEMPLO UTILIZACIÓN JSplitPane

OBJETIVO: ilustración introducción swing JAVA

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class IlustracionGraficos_23 {

    public static void main(String[] args){
        new IlustracionGraficos_23().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal(){
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 23");      

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new BorderLayout()); 

////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN CONTENEDORES JPanel                        //
////////////////////////////////////////////////////////////////////////////////
//////////DECLARACIÓN CONTENEDOR JPanel inquierdo
        JPanel izquierdo=new JPanel();
        
//////////DECLARACIÓN CONTENEDOR JPanel derecho
        JPanel derecho=new JPanel();



////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN CONTENEDOR JSplitPane                      //
////////////////////////////////////////////////////////////////////////////////
        JSplitPane divisor = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        divisor.setEnabled(false);
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JLabel     /////////////   
//////////DECLARACIÓN COMPONENTE JLabel etiqueta1
        JLabel etiqueta1 = new JLabel("AREA 1");
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta1 EN EL CONTENEDOR Jpanel
        //izquierdo
        izquierdo.add(etiqueta1);
//////////DECLARACIÓN COMPONENTE JLabel etiqueta1
        JLabel etiqueta2 = new JLabel("AREA 2");    
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta12 EN EL CONTENEDOR JPanel
        //derecho
        derecho.add(etiqueta2);

////////////////////////////////////////////////////////////////////////////////
//           INTRODUCCIONES EN EL CONTENEDOR JSplitPane divisor               //
////////////////////////////////////////////////////////////////////////////////
        //INTRODUCCIÓN EN EL CONTENEDOR JSplitPane divisor DEL CONTENEDOR
        //JPanel izquierdo
        divisor.add(izquierdo);
        //INTRODUCCIÓN EN EL CONTENEDOR JSplitPane divisor DEL CONTENEDOR
        //JPanel derecho
        divisor.add(derecho);


////////////////////////////////////////////////////////////////////////////////
//           INTRODUCCIONES EN EL PANEL DE CONTENIDOS DEL JFrame              //
////////////////////////////////////////////////////////////////////////////////
        //introducción en el panel de contenidos del contenedor JFrame ventana de divisor dentro del
        //area CENTRAL utilizando el administrador de layout BorderLayout
        panelContenidos.add(divisor,BorderLayout.CENTER);

////////////////////////////////////////////////////////////////////////////////
//        ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame ventanaPrincipal           //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.setSize(300,300);
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}