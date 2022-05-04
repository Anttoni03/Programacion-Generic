/*
FUNCIONALIDAD:
EJEMPLO UTILIZACIÓN CLASE Font

OBJETIVO: ilustración introducción  swing JAVA

autor: Juan Montes de Oca
 */
package interfacesgraficasusuario_ii;

import java.awt.*;
import javax.swing.*;
public class IlustracionGraficos_28 {
    //declaración método main
    public static void main(String[] args) { 
        new IlustracionGraficos_28().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() { 
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 28");      

        
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
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JLabel     /////////////
//////////DECLARACIÓN COMPONENTE JLabel etiqueta1
        JLabel etiqueta1 = new JLabel("pepe");    
        //ASIGNACIÓN TIPOGRAFÍA COMPONENTE JLabel etiqueta1
        etiqueta1.setFont(new Font("Times", Font.PLAIN, 20));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta1 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(etiqueta1);
    
//////////DECLARACIÓN COMPONENTE JLabel etiqueta2
        JLabel etiqueta2 = new JLabel("Arial");     
        //ASIGNACIÓN TIPOGRAFÍA COMPONENTE JLabel etiqueta2
        etiqueta2.setFont(new Font("Arial", Font.BOLD, 32));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta2 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(etiqueta2);
        
//////////DECLARACIÓN COMPONENTE JLabel etiqueta3
        JLabel etiqueta3 = new JLabel("Comic Sans MS");
        //ASIGNACIÓN TIPOGRAFÍA COMPONENTE JLabel etiqueta3
        etiqueta3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta3 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(etiqueta3);       
        
//////////DECLARACIÓN COMPONENTE JLabel etiqueta4
        JLabel etiqueta4 = new JLabel("MS Gothic");    
        //ASIGNACIÓN TIPOGRAFÍA COMPONENTE JLabel etiqueta4
        etiqueta4.setFont(new Font("MS Gothic", Font.BOLD,20));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta4 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(etiqueta4);                  
        
//////////DECLARACIÓN COMPONENTE JLabel etiqueta5
        JLabel etiqueta5 = new JLabel("Brodway");   
        //ASIGNACIÓN TIPOGRAFÍA COMPONENTE JLabel etiqueta5
        etiqueta5.setFont(new Font("Brodway", Font.BOLD | Font.ITALIC, 28));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta5 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(etiqueta5);                 
           

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(200,200);
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}
