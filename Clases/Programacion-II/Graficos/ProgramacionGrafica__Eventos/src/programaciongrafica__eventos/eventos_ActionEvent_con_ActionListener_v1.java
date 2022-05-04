/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN INTERFACE ActionListener PARA TRATAMIENTO EVENTOS ActionEvent
CON COMPONENTE JButton

autor: Juan Montes de Oca
 */

package programaciongrafica__eventos;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

        
public class  eventos_ActionEvent_con_ActionListener_v1 {
    //declaración método main
    public static void main(String[] args) { 
        new eventos_ActionEvent_con_ActionListener_v1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {    
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame();  
        //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
        ventana.setTitle("ILUSTRACIÓN ActionListener");

        
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
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JButton     /////////////   
//////////DECLARACIONES Y DEFINICIONES COMPONENTE JButton boton 
        JButton boton= new JButton("PÚLSAME Y VERÁS COMO CAMBIO DE COLOR");
        //INTRODUCCIÓN COMPONENTE JButton boton EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(boton);
        
///////////DECLARACIÓN Y ASIGNACIÓN DEL GESTOR DE EVENTOS ActionEvent A LA COMPONENTE
        //JButton boton UTILIZANDO LA INTERFACE ActionListener
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //TRATAMIENTO EVENTO
                 //cambiar aleatoriamente el color del fondo de la componente JButton boton
                Random generador=new Random();
                int rojo=generador.nextInt(256);
                int verde=generador.nextInt(256);
                int azul=generador.nextInt(256);
                boton.setBackground(new Color(rojo,verde,azul));
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
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}