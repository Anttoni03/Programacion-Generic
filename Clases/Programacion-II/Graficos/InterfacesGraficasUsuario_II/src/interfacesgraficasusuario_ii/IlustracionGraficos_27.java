/*
FUNCIONALIDAD:
EJEMPLO UTILIZACIÓN CLASE Color

OBJETIVO: ilustración introducción  swing JAVA

autor: Juan Montes de Oca
 */
package interfacesgraficasusuario_ii;

import java.awt.*;
import javax.swing.*;
public class IlustracionGraficos_27 {
    //declaración método main
    public static void main(String[] args) { 
        new IlustracionGraficos_27().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {   
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 27");      

        
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
//////////      DECLARACIONES Y DEFINICIONES COMPONENTES JLabel    ///////////// 
//////////DECLARACIÓN COMPONENTE JLabel etiqueta1
        JLabel etiqueta1=new JLabel("PRIMERA ETIQUETA");
        //ASIGNACIÓN COLOR DE TRAZADO A LA COMPONENTE JLabel etiqueta1
        etiqueta1.setForeground(new Color(255,0,0));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta1 EN EL PANEL DE CONTENIDOS 
        //panelContenidos 
        panelContenidos.add(etiqueta1);
//////////DECLARACIÓN COMPONENTE JLabel etiqueta2
        JLabel etiqueta2=new JLabel("SEGUNDA ETIQUETA");
        //ASIGNACIÓN COLOR DE TRAZADO A LA COMPONENTE JLabel etiqueta2
        etiqueta2.setForeground(Color.BLUE);
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta2 EN EL PANEL DE CONTENIDOS 
        //panelContenidos 
        panelContenidos.add(etiqueta2);
        

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.pack();
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}