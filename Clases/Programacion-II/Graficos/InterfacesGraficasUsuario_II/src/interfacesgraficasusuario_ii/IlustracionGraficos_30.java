/*
FUNCIONALIDAD:
EJEMPLO CLASE ImageIcon
OBJETIVO: ilustración introducción  swing JAVA

autor: Juan Montes de Oca
 */
package interfacesgraficasusuario_ii;

import java.awt.*;
import javax.swing.*;
public class IlustracionGraficos_30 {
    //declaración método main
    public static void main(String[] args) { 
        new IlustracionGraficos_30().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {   
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 30");      

        
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
        JLabel etiqueta1=new JLabel();
        //ASIGNACIÓN ICONO A LA COMPONENTE JLabel etiqueta1
        etiqueta1.setIcon(new ImageIcon("sol.jpg"));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta1 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(etiqueta1);
        
//////////DECLARACIÓN COMPONENTE JLabel etiqueta2
        JLabel etiqueta2=new JLabel();
        //ASIGNACIÓN ICONO A LA COMPONENTE JLabel etiqueta2
        etiqueta2.setIcon(new ImageIcon("luna.jpg"));
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta2 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(etiqueta2);        


//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////        
//////////DECLARACIÓN COMPONENTE JButton boton1
        JButton boton1=new JButton("GEOGRAFÍA");
        //ASIGNACIÓN ICONO A LA COMPONENTE JButton boton1
        boton1.setIcon(new ImageIcon("mallorca.jpg"));
        //INTRODUCCIÓN COMPONENTE JButton boton1 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(boton1);
        
//////////DECLARACIÓN COMPONENTE JButton boton2
        JButton boton2=new JButton("FORMACIÓN");
        //ASIGNACIÓN ICONO A LA COMPONENTE JButton boton2
        boton2.setIcon(new ImageIcon("uib.jpg"));
        //INTRODUCCIÓN COMPONENTE JButton boton2 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(boton2);


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