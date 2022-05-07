/*
1. Implementar en JAVA la interface A teniendo en cuenta las funcionalidades asociadas
a las siguientes componentes:
    - Componente JButton rojo  al pulsar el botón ROJO el contenedor JPanel
    visualizador se visualizará con el color rojo.
    - Componente JButton verde  al pulsar el botón VERDE el contenedor
    JPanel visualizador se visualizará con el color verde.
    - Componente JButton azul  al pulsar el botón AZUL el contenedor JPanel
    visualizador se visualizará con el color azul.
    - Componente JButton magenta  al pulsar el botón MAGENTA el contenedor
    JPanel visualizador se visualizará con el color magenta.
    - Componente JButton amarillo  al pulsar el botón AMARILLO el contenedor
    JPanel visualizador se visualizará con el color amarillo.
    - Componente JButton salir  al pulsar el botón SALIR la ventana de la
    aplicación será cerrada y la ejecución finalizará.

Nota: el contenedor JPanel visualizador se ha de considerar como una componente 
donde la visualización debe hacerse a través de un método paintComponent(Graphics g) 
utilizando la clase Graphics.

PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
*/

package problemasimplementacioninterfacesgraficas_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                             CLASE interface_5                              //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////    

public class Problema1_Interface_A_con_Graphics {
    //ATRIBUTOS
    private AreaVisualizacion visualizador;
    private Color colorFondo=Color.BLACK;
    private Container panelContenidos;
    private JFrame ventana;
    
                

    public static void main(String[] args) {
        new Problema1_Interface_A_con_Graphics().metodoPrincipal();        
    }

    private void metodoPrincipal() {   
        //declaración contenedor JFrame 
        ventana=new JFrame();
        //título contenedor pruebaBotones
        ventana.setTitle("EJEMPLO DE INTERFACE NÚMERO 1");
        //asignación a panelContenidos del panel de contenidos del contenedor
        //JFrame
        panelContenidos=ventana.getContentPane();  
        inicializacion();
    }

    private void inicializacion() {
        
////////////////////////////////////////////////////////////////////////////////
//                              GESTOR DE EVENTOS                             //
////////////////////////////////////////////////////////////////////////////////

////////MANIPULADOR DE EVENTOS gestorEventos
        ActionListener gestorEventos=new ActionListener()  { 
                @Override
                public void actionPerformed(ActionEvent evento)  { 
                        switch (evento.getActionCommand()) {
                            case "ROJO"         :colorFondo=Color.RED;break;
                            case "VERDE"        :colorFondo=Color.GREEN;break;
                            case "AZUL"         :colorFondo=Color.BLUE;break;
                            case "CYAN"         :colorFondo=Color.CYAN;break;
                            case "MAGENTA"      :colorFondo=Color.MAGENTA;break;
                            case "AMARILLO"     :colorFondo=Color.YELLOW;break;
                            case "SALIR"        ://Salir de la aplicación
                                                 System.exit(0);
                        }
                        //Refrescar ventana gráfica Dibujo
                        visualizador.repaint();
                }
        }; 


////////////////////////////////////////////////////////////////////////////////
//                      PANEL panelBotones y COMPONENTES                      //
////////////////////////////////////////////////////////////////////////////////
        
/////////DECLARACIÓN CONTENEDOR JPanel panelBotones 
        JPanel panelBotones = new JPanel();     
        //asignación administrador GridLayout al contenedor con 8 filas y una
        //columna
        panelBotones.setLayout(new GridLayout( 6, 1 ));

////////COMPONENTE JButton rojo
        JButton rojo = new JButton("ROJO");
        //asignación tipografia a la componente JButton rojo
        rojo.setFont(new Font("arial", Font.BOLD, 14));
        //asignación color de trazado componente JButton rojo
        rojo.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton rojo
        rojo.setBackground(Color.RED);
        //manipulador de evento asociado a la componente 
        //JButton rojo
        rojo.addActionListener(gestorEventos);
        //inclusión de la componente JButton rojo en el contenedor JPanel
        //panelColores
        panelBotones.add(rojo);        
        
////////COMPONENTE JButton verde
        JButton verde = new JButton("VERDE");
        //asignación tipografia a la componente JButton verde
        verde.setFont(new Font("arial", Font.BOLD, 14));
        //asignación color de trazado componente JButton verde
        verde.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton verde
        verde.setBackground(Color.GREEN);
        //manipulador de evento asociado a la componente 
        //JButton verde
        verde.addActionListener(gestorEventos);
        //inclusión de la componente JButton verde en el contenedor JPanel
        //panelColores
        panelBotones.add(verde);  
        
////////COMPONENTE JButton azul
        JButton azul = new JButton("AZUL");
        //asignación tipografia a la componente JButton azul
        azul.setFont(new Font("arial", Font.BOLD, 14));
        //asignación color de trazado componente JButton azul
        azul.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton azul
        azul.setBackground(Color.BLUE);
        //manipulador de evento asociado a la componente 
        //JButton azul
        azul.addActionListener(gestorEventos);
        //inclusión de la componente JButton azul en el contenedor JPanel
        //panelColores
        panelBotones.add(azul);         
        
////////COMPONENTE JButton cyan
        JButton cyan = new JButton("CYAN");
        //asignación tipografia a la componente JButton cyan
        cyan.setFont(new Font("arial", Font.BOLD, 14));
        //asignación color de trazado componente JButton cyan
        cyan.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton cyan
        cyan.setBackground(Color.CYAN);
        //manipulador de evento asociado a la componente 
        //JButton cyan
        cyan.addActionListener(gestorEventos);
        //inclusión de la componente JButton cyan en el contenedor JPanel
        //panelColores
        panelBotones.add(cyan);             
        
////////COMPONENTE JButton magenta
        JButton magenta = new JButton("MAGENTA");
        //asignación tipografia a la componente JButton magenta
        magenta.setFont(new Font("arial", Font.BOLD, 14));
        //asignación color de trazado componente JButton magenta
        magenta.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton magenta
        magenta.setBackground(Color.MAGENTA);
        //manipulador de evento asociado a la componente 
        //JButton magenta
        magenta.addActionListener(gestorEventos);
        //inclusión de la componente JButton magenta en el contenedor JPanel
        //panelColores
        panelBotones.add(magenta);           
             
////////COMPONENTE JButton amarillo
        JButton amarillo = new JButton("AMARILLO");
        //asignación tipografia a la componente JButton amarillo
        amarillo.setFont(new Font("arial", Font.BOLD, 14));
        //asignación color de trazado componente JButton amarillo
        amarillo.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton amarillo
        amarillo.setBackground(Color.YELLOW);
        //manipulador de evento asociado a la componente 
        //JButton amarillo
        amarillo.addActionListener(gestorEventos);
        //inclusión de la componente JButton amarillo en el contenedor JPanel
        //panelColores
        panelBotones.add(amarillo);           
             
      
        ////////////////////////////////////////////////////////////////////////
        //              PANEL panelSalir y COMPONENTE                         //
        //////////////////////////////////////////////////////////////////////// 
        
////////DECLARACIÓN CONTENEDOR JPanel panelSalir
        
//////////DECLARACIÓN contenedor JPanel para colocar la componente JButton salir
        JPanel panelSalir = new JPanel();

        //asignación administrador GridLayout 
        panelSalir.setLayout(new  GridLayout());

////////COMPONENTE JButton salir
        JButton salir = new JButton("SALIR");
        //asignación tipografia a la componente JButton salir
        salir.setFont(new Font("arial", Font.BOLD, 14));
        //asignación color de trazado componente JButton salir
        salir.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton salir
        salir.setBackground(Color.BLACK);
        //manipulador de evento asociado a la componente 
        //JButton salir
        salir.addActionListener(gestorEventos);
        //inclusión de la componente JButton salir en el contenedor JPanel
        //panelVarios
        panelSalir.add(salir);  


////////////////////////////////////////////////////////////////////////////////
//                   CONTENEDOR JPanel visualizador                           //
//////////////////////////////////////////////////////////////////////////////// 
        
////////DECLARACIÓN COMPONENTE AreaVisualizacion visualizador
        visualizador=new AreaVisualizacion();


 
////////////////////////////////////////////////////////////////////////////////
//   DISTRIBUCIÓN PANELES Y COMPONENTES EN EL CONTENEDOR JFrame ventana       //
//////////////////////////////////////////////////////////////////////////////// 
        
////////INCLUSIÓN DEL CONTENEDOR JPanel panelBotones EN LA ZONA OESTE DEL BorderLayout 
////////EN EL PANEL DE CONTENIDOS DEL CONTENEDOR JFrame
        panelContenidos.add(panelBotones, BorderLayout.WEST);     

////////INCLUSIÓN DEL CONTENEDOR JPanel panelSalir EN LA ZONA SUR DEL BorderLayout 
////////EN EL PANEL DE CONTENIDOS DEL CONTENEDOR JFrame
        panelContenidos.add(panelSalir, BorderLayout.SOUTH);  
        
////////inclusión DEL CONTENEDOR JPanel visualizador en el area CENTRO DEL PANEL DE
////////CONTENIDOS DEL CONTENEDOR JFrame
        panelContenidos.add(visualizador, BorderLayout.CENTER);        
        
        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(650,550);
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
    
    //////////////////////////////////////////////////////////////////////////////
    //                                                                          //
    //                         CLASE AreaVisualizacion                          //
    //                                                                          //
    ////////////////////////////////////////////////////////////////////////////// 
    public class AreaVisualizacion extends JPanel {
        @Override
        public void paintComponent(Graphics g) {   
            //llevar a cabo el pintado de todo el panel de color colorFondo a
            //a través de la visualización de un rectángulo con las dimensiones
            //del panel
             g.setColor(colorFondo);
             //declaración rectángulo con las dimensiones del panel
             g.fillRect(0, 0, getWidth(), getHeight());  
        }
    } 

}
