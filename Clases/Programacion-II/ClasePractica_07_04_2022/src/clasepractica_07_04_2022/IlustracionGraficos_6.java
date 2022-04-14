/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE JList

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JList

autor: Juan Montes de Oca
 */
package clasepractica_07_04_2022;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;

public class IlustracionGraficos_6 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_6().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {       
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 6");     

        
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
        String [] opciones={"OPCION_1", "OPCION_2", "OPCION_3", "OPCION_4","OPCION_5", 
            "OPCION_6"};
//////////DECLARACIÓN COMPONENTE JList lista
        JList lista=new JList(opciones);
        //INTRODUCCIÓN COMPONENTE JList lista EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(lista);
        

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

