/*
FUNCIONALIDAD:
EJEMPLO UTILIZACIÓN JToolBar

OBJETIVO: ilustración introducción swing JAVA

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class IlustracionGraficos_24 {
    public static void main(String[] args) {
        new IlustracionGraficos_24().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal(){
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 24");       

        
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
//////////       DECLARACIÓN Y DEFINICIONES COMPONENTE JLabel      /////////////          
//////////DECLARACIÓN COMPONENTE JLabel
        JLabel etiqueta = new JLabel("POR FAVOR, PULSAR UN BOTÓN");
        
        
////////   DECLARACIONES COMPONENTES JButton ASIGNÁNDOLES, A TRAVÉS DEL   //////
////////   CONSTRUCTOR UNA IMAGEN COMO ICONO                              //////
        
//////////DECLARACIÓN COMPONENTE JButton boton1 ASIGNÁNDOLE UNA IMAGEN COMO ICONO
        JButton boton1= new JButton(new ImageIcon("boton1.jpg"));
        //ASIGNACIÓN GESTOR DE EVENTO A LA COMPONENTE JButton boton1
        boton1.addActionListener(new ActionListener() {
                // AGREGAMOS UN OYENTE DE EVENTO AL BOTON boton1
                @Override
                public void actionPerformed(ActionEvent ev) {//Tratamiento del evento
                    // TRATAMIENTO DEL EVENTO
                    if (ev.getSource() == boton1) {
                        etiqueta.setText("GRACIAS, HA PULSADO EL BOTON 1");
                    }
                }
        });
        
//////////DECLARACIÓN COMPONENTE JButton boton2 ASIGNÁNDOLE UNA IMAGEN COMO ICONO
        JButton boton2= new JButton(new ImageIcon("boton2.jpg"));
        //ASIGNACIÓN GESTOR DE EVENTO A LA COMPONENTE JButton boton2
        boton2.addActionListener(new ActionListener() {
                // AGREGAMOS UN OYENTE DE EVENTO AL BOTON boton2
                @Override
                public void actionPerformed(ActionEvent ev) {
                    // TRATAMIENTO DEL EVENTO
                    if (ev.getSource() == boton2) {
                       etiqueta.setText("GRACIAS, HA PULSADO EL BOTON 2");
                    }
                }
        });
        
//////////DECLARACIÓN COMPONENTE JButton boton3 ASIGNÁNDOLE UNA IMAGEN COMO ICONO
        JButton boton3= new JButton(new ImageIcon("boton3.jpg"));
        //ASIGNACIÓN GESTOR DE EVENTO A LA COMPONENTE JButton boton3
        boton3.addActionListener(new ActionListener() {
                // AGREGAMOS UN OYENTE DE EVENTO AL BOTON boton3
                @Override
                public void actionPerformed(ActionEvent ev) {
                    // TRATAMIENTO DEL EVENTO
                    if (ev.getSource() == boton3) {
                       etiqueta.setText("GRACIAS, HA PULSADO EL BOTON 3");
                    }
                }
        });
        
        
//////////                 DECLARACIÓN JToolBar                       //////////       
        JToolBar barraHerramientas=new JToolBar();
        //INTRODUCCIÓN EN LA COMPONENTE JToolBar barraHerraientas LAS COMPONENTES
        //JButton boton1, boton2, y boton3 INTRODUCIENDO UN SEPARADOR ENTRE
        //boton2 y boton3introducción en el JToolBar barraHerramientas de las compomentes
        barraHerramientas.add(boton1);
        barraHerramientas.add(boton2);
        barraHerramientas.addSeparator();
        barraHerramientas.add(boton3);
              
        
////////////////////////////////////////////////////////////////////////////////
//          INTRODUCCIÓN EN EL PANEL DE CONTENIDOS panelContenidos            //
////////////////////////////////////////////////////////////////////////////////
        //INTRODUCCIÓN EN EL CONTENEDOR panelContenidos DE LA COMPONENTE JLabel
        //etiqueta EN EL AREA SUR DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(etiqueta,BorderLayout.CENTER);
        //INTRODUCCIÓN EN EL CONTENEDOR panelContenidos DE LA COMPONENTE JToolBar
        //EN EL AREA NORTE DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(barraHerramientas,BorderLayout.NORTH);
        
        
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