/*
FUNCIONALIDAD:
EJEMPLO ADMINISTRADOR DE LAYOUT BorderLayout

OBJETIVO: ilustración introducción administradores de
layouts

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;

import java.awt.*;
import javax.swing.*;
public class IlustracionGraficos_17 {
    //declaración método main
    public static void main(String[] args){
        new IlustracionGraficos_17().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal(){
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 17");       

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new BorderLayout());    

        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    ///////////// 
//////////DECLARACIÓN COMPONENTE JButton boton1
        JButton boton1 = new JButton("BOTÓN NORTE");       
        //INTRODUCCIÓN COMPONENTE JButton boton1 EN EL PANEL DE CONTENIDOS
        //panelContenidos ZONA NORTE
        panelContenidos.add(boton1,BorderLayout.NORTH);
        
        
//////////DECLARACIÓN COMPONENTE JButton boton2
        JButton boton2 = new JButton("BOTÓN OESTE");       
        //INTRODUCCIÓN COMPONENTE JButton boton2 EN EL PANEL DE CONTENIDOS
        //panelContenidos ZONA NORTE
        panelContenidos.add(boton2,BorderLayout.WEST);
        
        
//////////DECLARACIÓN COMPONENTE JButton boton3
        JButton boton3 = new JButton("BOTÓN CENTRAL");       
        //INTRODUCCIÓN COMPONENTE JButton boton3 EN EL PANEL DE CONTENIDOS
        //panelContenidos ZONA NORTE
        panelContenidos.add(boton3,BorderLayout.CENTER);
        
             
//////////DECLARACIÓN COMPONENTE JButton boton4
        JButton boton4 = new JButton("BOTÓN ESTE");       
        //INTRODUCCIÓN COMPONENTE JButton boton4 EN EL PANEL DE CONTENIDOS
        //panelContenidos ZONA NORTE
        panelContenidos.add(boton4,BorderLayout.EAST);
        

//////////DECLARACIÓN COMPONENTE JButton boton5
        JButton boton5 = new JButton("BOTÓN SUR");       
        //INTRODUCCIÓN COMPONENTE JButton boton5 EN EL PANEL DE CONTENIDOS
        //panelContenidos ZONA NORTE
        panelContenidos.add(boton5,BorderLayout.SOUTH);
        

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
