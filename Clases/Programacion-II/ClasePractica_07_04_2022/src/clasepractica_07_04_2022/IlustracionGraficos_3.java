/*
FUNCIONALIDAD:
VENTANA CON DOS COMPONENTES JCheckBox CON LOS LITERALES "BOTÓN 1" Y "BOTÓN 2". 
CON INTERACCIÓN: CONLLEVA LA VISUALIZACIÓN DEL ESTADO DEL BOTÓN PULSADO.

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JCheckBox

autor: Juan Montes de Oca
 */
package clasepractica_07_04_2022;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class IlustracionGraficos_3 {   
    //declaración método main
    public static void main(String args[]){ 
        new IlustracionGraficos_3().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    private void metodoPrincipal(){
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 3");        

        
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
//////////    DECLARACIONES Y DEFINICIONES COMPONENTES JCheckBox   /////////////
//////////DECLARACIONES Y DEFINICIONES COMPONENTE JCheckBox boton1
        //declaración componente JCheckBox boton1 asignándole el literal "BOTÓN 1"
        JCheckBox boton1 = new JCheckBox("BOTÓN 1");
        //asignación color del fondo de la componente JCheckBox boton1
        boton1.setBackground(new Color(255,0,0)); 
        //asignación color de trazado de la componente JCheckBox boton1
        boton1.setForeground(Color.yellow);
        //INTRODUCCIÓN COMPONENTE JCheckBox boton1 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(boton1);
        //declaración del gestor de eventos ItemEvent con la interface  ItemListener
        //ligado a la componente JCheckBox boton1
        boton1.addItemListener(new ItemListener() {  
                    public void itemStateChanged(ItemEvent evento){   
                        //llamada método tratamientoEvento para llevar a cabo el
                        //tratamiento del evento correspondiente a la interacción
                        //con la componente boton1
                        tratamientoEvento(evento);
                    }
        });

        
//////////DECLARACIONES Y DEFINICIONES COMPONENTE JCheckBox boton2 
        JCheckBox boton2 = new JCheckBox();
        //asignación literal "BOTÓN 2" a la componente JCheckBox boton2 
        boton2.setText("BOTÓN 2");
        //asignación color del fondo de la componente JCheckBox boton2
        boton2.setBackground(Color.GREEN);
        //INTRODUCCIÓN COMPONENTE JCheckBox boton2 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(boton2);
        //declaración del gestor de evento ligado a la componente JCheckBox boton1
        boton2.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent evento){
                    //se hace la implementación aqui mismo
                        if(evento.getStateChange()== ItemEvent.SELECTED){
                                    System.out.println("Selección BOTÓN 2");
                        }
                        else
                                    System.out.println("Deselección BOTÓN 2");
                    }
        });
        

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
  
    //MÉTODO QUE LLEVA  A CABO LA ACCIÓN DEL GESTOR DEL EVENTO DADO POR PARÁMETRO
    private void tratamientoEvento(ItemEvent evento){
       //en función del estado de selección de la componente se lleva a cabo el
       //tratamiento correspondiente
       if(evento.getStateChange() == ItemEvent.SELECTED)
            System.out.println("Selección BOTÓN 1");
        else
            System.out.println("Deselección BOTÓN 1");
    }
}
