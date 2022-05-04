/*
FUNCIONALIDAD:
VENTANA CON DOS COMPONENTES JButton CON LOS LITERALES "BOTÓN 1" Y "BOTÓN 2". 
CON INTERACCIÓN: CONLLEVA LA VISUALIZACIÓN DEL LITERAL EN LA PANTALLA.
SE UTILIZA UN ÚNICO MANIPULADOR DE EVENTOS PARA LOS DOS BOTONES

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JButton

autor: Juan Montes de Oca
 */

package clasepractica_07_04_2022;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IlustracionGraficos_2 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_2().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 2"); 

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());
        
        
////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN GESTORES DE EVENTOS                        //
//////////////////////////////////////////////////////////////////////////////// 
/////////////    DECLARACIÓN GESTOR DE EVENTOS ActionListener   ////////////////
        ActionListener gestorEvento = new ActionListener() { 
            //TRATAMIENTO EVENTO
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.out.println("Literal del botón pulsado: " + 
                        evento.getActionCommand());
            }
        };

        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////
//////////DECLARACIÓN componente JButton boton1 ASIGNÁNDOLE LA ETIQUETA "BOTÓN 1"
        JButton boton1= new JButton("BOTÓN 1");
        //INTRODUCCIÓN COMPONENTE JButton boton1 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(boton1);
        //ASIGNACIÓN DEL GESTOR DE EVENTO gestorEvento A LA COMPONENTE JButton 
        //boton1
        boton1.addActionListener(gestorEvento);


//////////DECLARACIÓN componente JButton boton2 ASIGNÁNDOLE LA ETIQUETA "BOTÓN 2"
        JButton boton2= new JButton("BOTÓN 2");
        //INTRODUCCIÓN COMPONENTE JButton boton2 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(boton2);
        //ASIGNACIÓN DEL GESTOR DE EVENTO gestorEvento A LA COMPONENTE JButton 
        //boton2
        boton2.addActionListener(gestorEvento);
        
        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.pack();
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}