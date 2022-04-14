/*
FUNCIONALIDAD:
VENTANA CON DOS COMPONENTES JButton CON LOS LITERALES "BOTÓN 1" Y "BOTÓN 2". 
SIN INTERACCIÓN.

OBJETIVOS: 
    - ilustración introducción componentes swing JAVA.
    - componente JButton

autor: Juan Montes de Oca
 */

package clasepractica_07_04_2022;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class  IlustracionGraficos_1_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new IlustracionGraficos_1_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {    
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GRÁFICOS 1");
    
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos 
        //EL ADMINISTRADOR Layout LLEVA  A CABO LA DISTRIBUCIÓN DE LAS COMPONENTES
        //INTRODUCIDAS EN EL CONTENEDOR, A MEDIDA QUE VAN SIENDO INTRODUCIDAS EN
        //ÉL, DE IZQUIERDA A DERECHA Y DE ARRIBA A ABAJO.
        panelContenidos.setLayout(new FlowLayout());


////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////
//////////DECLARACIÓN componente JButton boton1 ASIGNÁNDOLE LA ETIQUETA "BOTÓN 1"
        JButton boton1= new JButton("BOTÓN 1");
        //INTRODUCCIÓN COMPONENTE JButton boton1 EN EL PANEL DE CONTENIDOS 
        //panelContenidosIntroducción
        panelContenidos.add(boton1);


//////////DECLARACIÓN componente JButton boton2 ASIGNÁNDOLE LA ETIQUETA "BOTÓN 2"
        JButton boton2= new JButton("BOTÓN 2");
        //INTRODUCCIÓN COMPONENTE JButton boton2 EN EL PANEL DE CONTENIDOS 
        //panelContenidosIntroducción
        panelContenidos.add(boton2);
        

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
//        ventana.pack();  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana PARA DIMENSIONAR CON 
        //LAS DIMENSIONES DADAS COMO ATRIBUTOS. EVIDENTEMENTE SE TENDRÁ QUE DECIDIR
        //POR ESTA FUNCIONALIDAD O POR LA FUNCIONALIDAD pack()
        ventana.setSize(550,400);  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}