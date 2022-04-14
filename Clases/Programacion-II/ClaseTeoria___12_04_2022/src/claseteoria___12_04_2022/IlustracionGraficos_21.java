/*
FUNCIONALIDAD:
EJEMPLO UTILIZACIÓN CONTENEDOR JPanel

OBJETIVO: ilustración introducción swing JAVA

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class IlustracionGraficos_21 extends JFrame {

    public IlustracionGraficos_21() {
        super("ILUSTRACIÓN GRÁFICA 21");
          
        
//////////PANEL DE CONTENIDOS DEL CONTENEDOR JFrame  ventanaPrincipal   ///////        
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();
        
//////////DECLARACIÓN CONTENEDOR PanelPersonalizado panelDibujo 
        //COMO ÁREA DE VISUALIZACIÓN GRÁFICA
        PanelPersonalizado panelDibujo = new PanelPersonalizado();
        //ASIGNACIÓN COLOR DEL FONDO AL CONTENEDOR panelDibujo
        panelDibujo.setBackground(Color.ORANGE);

//////////DECLARACIÓN CONTENEDOR JPanel panelBotones
        JPanel panelBotones = new JPanel();
        //ASIGNACIÓN DEL ADMINISTRADOR DE LAYOUT GridLayout AL CONTENEDOR JPanel
        //panelBotones
        panelBotones.setLayout(new GridLayout(1,2));
        

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    ///////////// 
//////////DECLARACIÓN COMPONENTE JButton boton1
        JButton boton1 = new JButton("CUADRADO");
        //ASIGNACIÓN GESTOR DE EVENTOS ActionListener A LA COMPONENTE JButton boton1
        boton1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed( ActionEvent evento ) {
                    //ejecutar método dibujar del contenedor PanelPersonalizado
                    //para dibujar un cuadrado
                    panelDibujo.dibujar(PanelPersonalizado.CUADRADO );
                }
        });
        //INTRODUCCIÓN DE LA COMPONENTE JButton boton1 EN EL CONTENEDOR JPanel
        //panelBotones
        panelBotones.add(boton1);

//////////DECLARACIÓN COMPONENTE JButton boton2
        JButton boton2 = new JButton("CÍRCULO");
        //ASIGNACIÓN GESTOR DE EVENTOS ActionListener A LA COMPONENTE JButton boton2
        boton2.addActionListener(new ActionListener(){
                @Override
                //ejecutar método dibujar del contenedor PanelPersonalizado
                //para dibujar un círculo
                public void actionPerformed( ActionEvent evento ) {
                        panelDibujo.dibujar(PanelPersonalizado.CIRCULO );
                }
        });
        //INTRODUCCIÓN DE LA COMPONENTE JButton boton2 EN EL CONTENEDOR JPanel
        //panelBotones
        panelBotones.add(boton2);

        
////////////////////////////////////////////////////////////////////////////////
//  INTRODUCCIONES PANEL DE CONTENIDOS panelContenidos DEL CONNTENEDOR JFrame //                              //
////////////////////////////////////////////////////////////////////////////////
        //INTRODUCCIÓN DEL CONTENEDOR panelDibujo EN EL PANEL DE CONTENIDOS
        //panelContenidos DEL CONTENEDOR JFrame EN EL AREA CENTRAL DEL 
        //ADMINISTRADOR BorderLayout
        panelContenidos.add(panelDibujo, BorderLayout.CENTER );
        //INTRODUCCIÓN DEL CONTENEDOR panelBotones EN EL PANEL DE CONTENIDOS
        //panelContenidos DEL CONTENEDOR JFrame EN EL AREA SUR DEL 
        //ADMINISTRADOR BorderLayout
        panelContenidos.add( panelBotones, BorderLayout.SOUTH );

        
////////////////////////////////////////////////////////////////////////////////
//        ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame ventanaPrincipal           //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO CONTENEDOR JFrame
        setSize(300,150);
        //CENTRADO DEL CONTENEDOR JFrame EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //VISUALIZACIÓN CONTENEDOR JFrame 
        setVisible(true);
    }

    public static void main( String args[] ) {
            IlustracionGraficos_21 aplicacion = new IlustracionGraficos_21();
    }
}
