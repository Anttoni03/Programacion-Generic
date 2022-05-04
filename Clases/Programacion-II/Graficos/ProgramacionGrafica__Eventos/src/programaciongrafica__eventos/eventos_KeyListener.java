/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN KeyListener PARA TRATAMIENTO EVENTO KeyEvent

autor: Juan Montes de Oca
 */

package programaciongrafica__eventos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class  eventos_KeyListener {
    //declaración método main
    public static void main(String[] args) { 
        new eventos_KeyListener().metodoPrincipal();
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
        ventana.setTitle("ILUSTRACIÓN KeyListener");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN COLOR DE FONDO AL PANEL DE CONTENIDOS panelContenidos
        panelContenidos.setBackground(Color.BLACK);
        //ASIGNACIÓN DEL GESTOR DE LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new BorderLayout());         
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////             DECLARACIÓN TIPOGRAFÍAS A UTILIZAR          /////////////
        Font tipoGrafia1=new Font("Arial",Font.BOLD,30);
        Font tipoGrafia2=new Font("Comic Sans MS",Font.ITALIC,20);
        
        
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JLabel     /////////////          
//////////DECLARACIÓN COMPONENTE JLabel etiqueta1 ASIGNANDO UNA JUSTIFICACIÓN
        //CENTRADA
        JLabel etiqueta1= new JLabel("PULSA UNA TECLA",SwingConstants.CENTER);
        //ASIGNACIÓN COLOR DE TRAZADO A LA COMPONENTE JLabel etiqueta1
        etiqueta1.setForeground(Color.WHITE);
        //ASIGNACIÓN TIPOGRAFÍA A LA COMPONENTE JLabel etiqueta1
        etiqueta1.setFont(tipoGrafia1);
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta1 EN EL PANEL DE CONTENIDOS 
        //panelContenidos EN EL AREA NORTE DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(etiqueta1,BorderLayout.NORTH);
        
//////////DECLARACIÓN COMPONENTE JLabel etiqueta2 
        JLabel etiqueta2= new JLabel("NINGUNA LETRA PULSADA");
        //ASIGNACIÓN COLOR DE TRAZADO A LA COMPONENTE JLabel etiqueta1
        etiqueta2.setForeground(Color.YELLOW);
        //ASIGNACIÓN TIPOGRAFÍA A LA COMPONENTE JLabel etiqueta1
        etiqueta2.setFont(tipoGrafia2);  
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta2 EN EL PANEL DE CONTENIDOS 
        //panelContenidos EN EL AREA CENTRO DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(etiqueta2,BorderLayout.CENTER);
        
        
////////////////////////////////////////////////////////////////////////////////
//                          GESTOR DE EVENTOS                                 //
////////////////////////////////////////////////////////////////////////////////        
//////////    DECLARACIÓN GESTOR DE EVENTOS KeyEvent ASOCIADO AL PANEL    //////
//////////    DE CONTENIDOS panelContenidos CON LA INTERFACE KeyListener  //////
        ventana.addKeyListener(new KeyListener() {
            @Override
            //tratamiento del evento cuando una tecla ha sido pulsada y soltada
            public void keyTyped(KeyEvent e) {
                    //NO HAGO NADA
            }
            @Override
            //tratamiento del evento cuando una tecla ha sido pulsada
            public void keyPressed(KeyEvent e) {
                //asignación nuevo texto a la componente etiqueta2
                etiqueta2.setText("TECLA PULSADA: "+e.getKeyText(e.getKeyCode()));
            }
            @Override
            //tratamiento del evento cuando una tecla ha sido soltada
            public void keyReleased(KeyEvent e) {
                    //NO HAGO NADA
            }
        });

        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(400,150);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}