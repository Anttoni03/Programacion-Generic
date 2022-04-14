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


public class IlustracionGraficos_9 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_9().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 9");      

        
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
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JComboBox   /////////////
//////////DECLARACIÓN ARRAY DE COMPONENTES String PARA REPRESENTAR LAS DIFERENTES
        //OPCIONES DE LA COMPONENTE JComboBox
        String [] opciones={"OPCION_1", "OPCION_2", "OPCION_3", "OPCION_4","OPCION_5", 
            "OPCION_6"};
//////////DECLARACIÓN COMPONENTE JComboBox lista
        JComboBox lista = new JComboBox(opciones);
        //selección como activada la opción de la componente lista cuyo índice en el array
        //es el dado como parámetro
        lista.setSelectedIndex(0);
        //INTRODUCCIÓN COMPONENTE JComboBox lista EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(lista);
        //ASIGNACIÓN A LA COMPONENTE JComboBox lista del gestor de eventos
        //ActionListener
        lista.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evento){
                    JComboBox cb = (JComboBox)evento.getSource();
                    String seleccion = (String)cb.getSelectedItem();
                    System.out.println("Selección: " + seleccion);
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
}
