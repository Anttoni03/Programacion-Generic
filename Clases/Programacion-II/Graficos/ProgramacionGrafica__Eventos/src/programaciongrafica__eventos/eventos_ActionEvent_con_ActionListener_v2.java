/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN INTERFACE ActionListener PARA TRATAMIENTO EVENTOS ActionEvent
CON COMPONENTES JButton y JMenuItem

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/*
          JMenu file = new JMenu("File");
    JMenuItem exitItem = new JMenuItem("Exit");
    exitItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                System.exit(0);
        }
    });
*/
public class  eventos_ActionEvent_con_ActionListener_v2 {
    //DECLARACIÓN ATRIBUTOS
    private JButton boton;
    private JMenuItem menu1Opcion1;
    
    //declaración método main
    public static void main(String[] args) { 
        new eventos_ActionEvent_con_ActionListener_v2().metodoPrincipal();
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
        boton= new JButton("PÚLSAME Y VERÁS COMO CAMBIO DE COLOR");
        //INTRODUCCIÓN COMPONENTE JButton boton EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(boton);
        boton.addActionListener(new gestorEvento());
        
        
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JMenuBar    ///////////// 
//////////DECLARACIÓN COMPONENTE JMenuBar (barra de menu)
        JMenuBar barraMenu=new JMenuBar();
        //INTRODUCIÓN COMPONENTE JMenuBar barraMenu EN EL CONTENEDOR JFrame ventana
        ventana.setJMenuBar(barraMenu);

//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JMenu    ///////////// 
//////////DECLARACIÓN COMPONENTE JMenu menu1
        JMenu menu1=new JMenu("MENÚ 1");

        
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JMenuItem  ///////////// 
/////////            ASOCIADAS A LA COMPONENTE JMenu menu1         /////////////
//////////DECLARACIÓN COMPONENTE JMenuItem menu1Opcion1
        menu1Opcion1= new JMenuItem("SALIR");
        //ASIGNACIÓN GESTOR DE EVENTOS A LA COMPONENTE JMenuItem menu1Opcion1
        menu1Opcion1.addActionListener(new gestorEvento());
//////////INTRODUCCIÓN EN LA COMPONENTE Jmenu menu1 DE LA COMPONENTE
        //menu1Opcion1
        menu1.add(menu1Opcion1);

        
//////////INTRODUCCIÓN DE LAS COMPONENTES JMenu menu1 y menu2 EN LA COMPONENTE 
        //JMenuBar barraMenu
        barraMenu.add(menu1);       
             


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
    
    
    //CLASE GESTOR DE EVENTOS
    private class gestorEvento implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evento) {
                {
                    switch (evento.getActionCommand()) {
                        case "PÚLSAME Y VERÁS COMO CAMBIO DE COLOR":
                                        //TRATAMIENTO EVENTO
                                        //cambiar aleatoriamente el color del fondo de la componente JButton boton
                                        Random generador=new Random();
                                        int rojo=generador.nextInt(256);
                                        int verde=generador.nextInt(256);
                                        int azul=generador.nextInt(256);
                                        boton.setBackground(new Color(rojo,verde,azul));
                                        break;
                        case "SALIR":   System.exit(0);
                    }
                }

            }
    }
}