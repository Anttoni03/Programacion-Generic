/*
FUNCIONALIDAD: visualiza y borra el mensaje "HOLA, ¿CÓMO ESTÁS?" a través de la
interacción de los dos botones.
nota --> UN GESTOR DE EVENTOS PARA CADA UNO DE LOS BOTONES.

DISEÑO INTERFACE: ver pdf interface_3_v1

autor: Juan Montes de Oca
 */

package programasimplementacioninterfaces_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                           CLASE interface_3_v1                             //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////  

public class interface_3_v1 extends JFrame {
    //DECLARACIONES ATRIBUTOS
    //DECLARACIÓN OBJETO Container PARA REPRESENTAR EL PANEL DE
    //CONTENIDOS DEL OBJETO JFrame
    private Container panelContenidos;
    
    //MÉTODO CONSTRUCTOR
    public interface_3_v1() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //ASIGNACIÓN TÍTULO CONTENEDOR JFrame
        super("VISUALIZADOR");
        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        panelContenidos=getContentPane(); 
        //ASIGNACIÓN DEL ADMINISTRADOR DE LAYOUT BorderLayout AL PANEL DE
        //CONTENIDOS panelContenidos
        panelContenidos.setLayout(new BorderLayout());
        inicializacion();
    }

    //MÉTODO inicializacion
    private void inicializacion() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDORES                              //
////////////////////////////////////////////////////////////////////////////////
//////////         DECLARACIÓN CONTENEDOR JPanel panelBotones      /////////////
        JPanel panelBotones=new JPanel();
        //asignación administrador de Layout FlowLayout al contenedor JPanel
        //panelBotones
        panelBotones.setLayout(new FlowLayout());
        //asignación color de fondo al contenedor JPanel panelBotones
        panelBotones.setBackground(Color.red);
        //inclusión en la zona CENTRO del panel de contenidos del JFrame del 
        //contenedor JPanel panelBotones
        panelContenidos.add(panelBotones,BorderLayout.CENTER);
        

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////    DECLARACIONES Y DEFINICIONES COMPONENTE JTextField   /////////////
        JTextField texto = new JTextField();
        //desactivación EDICIÓN en la componente JTextField texto
        texto.setEditable(false);
        //asignación color de fondo a la componente JTextField texto
        texto.setBackground(Color.black);
        //asignación color de trazado a la componente JTextField texto
        texto.setForeground(Color.white);
        //activación justificación izquierda en la componente JTestField
        texto.setHorizontalAlignment(JTextField.CENTER);
        //asignación tipografía a la componente JTestField
        texto.setFont(new Font("arial", Font.BOLD, 25));
        //introducción  de la componente JTextField texto en la zona 
        //NORTE del contenedor panelContenidos
        panelContenidos.add(texto,BorderLayout.NORTH);

        
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////
//////////DECLARACIÓN COMPONENTE JButton boton1
        JButton boton1 = new JButton("ESCRIBIR");
        //asignación tipografia a la componente JButton boton1
        boton1.setFont(new Font("arial",Font.BOLD, 25));
        //introducción componente JButton botton1 en el contenedor JPanel panelBotones
        panelBotones.add(boton1);
        //asignación gestor de eventos ActionEvent con interface ActionListener
        //a la componente JButton boton1
        boton1.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent evento) { 
                        //visualizar el texto "ESCRIBIR" en la componente JTextField texto
                        texto.setText("HOLA, ¿CÓMO ESTÁS?");
                }
        });
        

//////////DECLARACIÓN COMPONENTE JButton boton2
        JButton boton2 = new JButton("BORRAR");
        //asignación tipografia a la componente JButton boton2
        boton2.setFont(new Font("arial",Font.BOLD, 25));
        //introducción componente JButton botton1 en el contenedor JPane2 panelBotones
        panelBotones.add(boton2);
        //asignación gestor de eventos ActionEvent con interface ActionListener
        //a la componente JButton boton2
        boton2.addActionListener(new ActionListener() {  
                @Override
                public void actionPerformed(ActionEvent evento) { 
                        //visualizar el texto "" en la componente JTextField texto
                        //lo cual cnlleva al borrado del contenido
                        texto.setText("");
                        }
        });

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA EN EL CONTENEDOR 
        //JFrame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //REDIMENSIONAMIENTO CONTENEDOR JFrame EN FUNCIÓN DE LAS COMPONENTES INTRODUCIDAS
        //EN ÉL
        pack();
        //CENTRADO DEL CONTENEDOR JFrame EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        setVisible(true);
    }

    //MÉTODO main
    public static void main(String[] args) {
        interface_3_v1 ventana=new interface_3_v1();
    }
}
