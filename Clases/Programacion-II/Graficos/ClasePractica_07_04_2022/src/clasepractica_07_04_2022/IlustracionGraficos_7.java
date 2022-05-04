/*
FUNCIONALIDAD:
EJEMPLO DE COMPONENTE JList CON MANIPULACIÓN DE EVENTOS Y BARRA DE DESPLAZAMIENTO
(JScrollPane).

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JList y contenedor JScrollPane.

autor: Juan Montes de Oca
 */
package clasepractica_07_04_2022;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class IlustracionGraficos_7 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_7().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 7");      

        
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
//////////       DECLARACIONES Y DEFINICIONES COMPONENTE List      /////////////
//////////DECLARACIÓN ARRAY DE COMPONENTES String PARA REPRESENTAR LAS DIFERENTES
        //OPCIONES DE LA COMPONENTE JList
        String [] opciones = { "OPCION_1", "OPCION_2", "OPCION_3", "OPCION_4","OPCION_5", 
            "OPCION_6","OPCION_7","OPCION_8","OPCION_9"};

//////////DECLARACIÓN COMPONENTE JList lista
        JList lista=new JList(opciones);

//////////DECLARACIÓN CONTENEDOR JScrollPane QUE REPRESENTA LA UTILIDAD DE la utilidad de 
        //BARRA DE DESPLAZAMIENTO ASOCIÁNDOLO CON LA COMPONENTE JList lista PARA QUE
        //APAREZCA EN ELLA CUANDO HAYA MÁS DE OCHO OPCIONES
        JScrollPane barraDesplazamiento = new JScrollPane(lista);

//////////INTRODUCCIÓN CONTENEDOR JScrollPane barraDesplazamiento EN EL PANEL
        //DE CONTENIDOS panelContenidos      
        panelContenidos.add(barraDesplazamiento);

//////////DECLARACIÓN GESTOR DE EVENTOS ListSelectionListener
        //CADA VEZ QUE SE PRODUZCA UN EVENTO EN LA LISTA SE LLEVARÁ A CABO 
        //EL CONJUNTO DE ACCIONES, EN ESTE CASO, EL PULSAR Y SOLTAR EL BOTÓN
        //DEL RATÓN SOBRE UNA OPCIÓN CONLLEVARÁ LA EJECUCIÓN DOS VECES.
        ListSelectionListener gestorEventosLista = new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evento) {
                    //DECLARACIÓN COMPONENTE JList LOCAL ASIGNÁNDOLE
                    //LA JList DONDE SE HA PRODUCIDO EL EVENTO
                    JList listaLocal = (JList) evento.getSource();
                    //ASIGNACIÓN A LA VARIABLE ENTERA indice DEL ÍNDICE DE LA
                    //OPCIÓN SELECCIONADA EN LA JList DONDE SE HA PRODUCIDO EL
                    //EVENTO
                    int indice = listaLocal.getSelectedIndex();
                    //ASIGNACIÓN A LA VARIABLE valor DEL LITERAL DE LA OPCIÓN
                    //SELECCIONADA EN LA JList
                    Object valor = listaLocal.getSelectedValue();
                    //VISUALIZACIÓN DATOS
                    System.out.println("Indice=> " + indice + " valor=> " + valor);
                }
        };
        
//////////ASIGNACIÓN DEL GESTOR DE EVENTOS gestorEventosLista A LA COMPONENTE
        //JList lista 
        lista.addListSelectionListener(gestorEventosLista);
        
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
