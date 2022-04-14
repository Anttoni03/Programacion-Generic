/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE JComboBox

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JComboBox.

autor: Juan Montes de Oca
 */
package clasepractica_07_04_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class IlustracionGraficos_8 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_8().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 8");      

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());  
        

////////////////////////////////////////////////////////////////////////////////
//                   DECLARACIÓN GESTOR DE EVENTOS                            //
////////////////////////////////////////////////////////////////////////////////
//////////        DECLARACIONES GESTOR DE EVENTOS ActionListener   /////////////
        ActionListener gestorEventosLista = new ActionListener() {
                public void actionPerformed(ActionEvent ev){
                    //DECLARACIÓN COMPONENTE LOCAL JComboBox ASIGNÁNDOLE
                    //LA COMPONENTE JComboBox DONDE SE HA PRODUCIDO EL
                    //EVENTO
                    JComboBox comboLocal = (JComboBox) ev.getSource();
                    //ASIGNACIÓN AL String seleccion DEL LITERAL ASOCIADO
                    //A LA OPCIÓN SELECCIONADA DE LA COMPONENTE JComboBox
                    String seleccion = (String)comboLocal.getSelectedItem();
                    //VISUALIZACIÓN LITERAL
                    System.out.println("Selected: " + seleccion);
                }
        };

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JComboBox   /////////////
//////////DECLARACIÓN ARRAY DE COMPONENTES String PARA REPRESENTAR LAS DIFERENTES
        //OPCIONES DE LA COMPONENTE JComboBox
        String [] opciones={"OPCION_1", "OPCION_2", "OPCION_3", "OPCION_4","OPCION_5", 
            "OPCION_6"};
//////////DECLARACIÓN COMPONENTE JComboBox lista
        JComboBox lista = new JComboBox(opciones);
        //selección como activada la opción de la componente lista cuyo índice en el array
        //es el dado como parámetro
        lista.setSelectedIndex(3);
        //INTRODUCCIÓN COMPONENTE JComboBox lista EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(lista);
        //ASIGNACIÓN A LA COMPONENTE JComboBox lista del gestor de eventos
        //gestorEventosLista
        lista.addActionListener(gestorEventosLista);




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
