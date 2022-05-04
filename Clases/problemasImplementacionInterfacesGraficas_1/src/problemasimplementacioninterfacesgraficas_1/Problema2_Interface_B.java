/*
. Implementar en JAVA la interface B teniendo en cuenta las funcionalidades asociadas a 
las siguientes componentes:
    - Componente JButton accion1  al pulsar el botón ACCIÓN 1 se visualizará 
    el literal “HAS PULSADO EL BOTÓN ACCIÓN 1” en la componente JTextField
    y en el contenedor JPanel panelVisual.
    - Componente JButton accion2  al pulsar el botón ACCIÓN 2 se visualizará 
    el literal “HAS PULSADO EL BOTÓN ACCIÓN 2” en la componente JTextField
    y en el contenedor JPanel panelVisual.
    - Componente JButton accion3  al pulsar el botón ACCIÓN 3 se visualizará 
    el literal “HAS PULSADO EL BOTÓN ACCIÓN 3” en la componente JTextField
    y en el contenedor JPanel panelVisual.
    - Componente JButton accion4  al pulsar el botón ACCIÓN 4 se visualizará 
    el literal “HAS PULSADO EL BOTÓN ACCIÓN 4” en la componente JTextField
    y en el contenedor JPanel panelVisual.
    - Componente JButton accion5  al pulsar el botón ACCIÓN 5 se visualizará 
    el literal “HAS PULSADO EL BOTÓN ACCIÓN 5” en la componente JTextField
    y en el contenedor JPanel panelVisual.
    - Componente JButton accion6  al pulsar el botón la ventana de la 
    aplicación será cerrada y la ejecución finalizará.
    - Componente JMenuItem primeroOpcion1  al seleccionar la opción 
    OPCION 1 del menú PRIMERO se visualizará el literal “HAS PULSADO LA 
    OPCIÓN OPCION 1 DEL MENÚ PRIMERO” en la componente JTextField y en 
    el contenedor JPanel panelVisual.
    - Componente JMenuItem primeroOpcion2  al seleccionar la opción 
    OPCION 2 del menú PRIMERO se visualizará el literal “HAS PULSADO LA 
    OPCIÓN OPCION 2 DEL MENÚ PRIMERO” en la componente JTextField y en 
    el contenedor JPanel panelVisual.
    - Componente JMenuItem segundoOpcion1  al seleccionar la opción 
    OPCION 1 del menú SEGUNDO se visualizará el literal “HAS PULSADO LA 
    OPCIÓN OPCIÓN 1 DEL MENÚ SEGUNDO” en la componente JTextField y 
    en el contenedor JPanel panelVisual.
    - Componente JMenuItem segundoOpcion2  al seleccionar la opción 
    OPCION 2 del menú SEGUNDO se visualizará el literal “HAS PULSADO LA 
    OPCIÓN OPCIÓN 2 DEL MENÚ SEGUNDO” en la componente JTextField y 
    en el contenedor JPanel panelVisual.
    - Componente JMenuItem segundoOpcion3  al seleccionar la opción 
    OPCION 3 del menú SEGUNDO se visualizará el literal “HAS PULSADO LA 
    OPCIÓN OPCIÓN 3 DEL MENÚ SEGUNDO” en la componente JTextField y 
    en el contenedor JPanel panelVisual.
    - Componente JMenuItem segundoOpcion4  al seleccionar la opción 
    OPCION 4 del menú SEGUNDO se visualizará el literal “HAS PULSADO LA 
    OPCIÓN OPCIÓN 4 DEL MENÚ SEGUNDO” en la componente JTextField y 
    en el contenedor JPanel panelVisual.
    - Componente JRadioButtonMenuItem cuartoOpcion1  al seleccionar la 
    opción OPCION 1 del menú CUARTO se visualizará el literal “HAS PULSADO 
    LA OPCIÓN OPCIÓN 1 DEL MENÚ CUARTO” en la componente JTextField y 
    en el contenedor JPanel panelVisual.

PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
*/

package problemasimplementacioninterfacesgraficas_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                             CLASE interface_6                              //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////    

public class Problema2_Interface_B {
    private Container panelContenidos;
    private JPanel panelVisual;
    private JLabel etiqueta;
    private JTextField texto;
    private JButton accion1,accion2,accion3,accion4,accion5,salir;
    private JMenuItem  primeroOpcion1, primeroOpcion2, segundoOpcion1, 
            segundoOpcion2, segundoOpcion3, segundoOpcion4, segundoOpcion5,
            terceroOpcion1, terceroOpcion2, terceroOpcion3, terceroOpcion4, 
            terceroOpcion5, terceroOpcion6;
    private JRadioButtonMenuItem cuartoOpcion1, cuartoOpcion2;
    private JFrame ventana;


    public static void main(String[] args) {
        new Problema2_Interface_B().metodoPrincipal();        
    }

    private void metodoPrincipal() {       
        //declaración contenedor JFrame 
        ventana=new JFrame();
        //título contenedor pruebaBotones
        ventana.setTitle("EJEMPLO DE INTERFACE NÚMERO 1");
        //asignación a panelContenidos del panel de contenidos del contenedor
        //JFrame
        panelContenidos=ventana.getContentPane();  
        panelContenidos.setLayout(new BorderLayout());
        
        inicializacion();
    }
    
    private void inicializacion() {
//////////////////////// GESTOR DE EVENTOS DE ACCIÓN
    ActionListener gestorEventosAccion=new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent evento) {
            //Declaración array de componentes Component para representar a todas
            //las componentes que pueden ser selecionadas por el usuario de manera
            //interactiva
            Component [] componentes={accion1,accion2,accion3,accion4,accion5,salir,
                    primeroOpcion1, primeroOpcion2, segundoOpcion1, 
                    segundoOpcion2, segundoOpcion3, segundoOpcion4, segundoOpcion5,
                    terceroOpcion1, terceroOpcion2, terceroOpcion3, terceroOpcion4, 
                    terceroOpcion5, terceroOpcion6,cuartoOpcion1, cuartoOpcion2};
            int indice;
            //obtener la componente en la que se ha generado el evento ActionEvent
            for (indice=0;indice<componentes.length && evento.getSource()!=componentes[indice];
                 indice++) {}
            //En función sde la componente donde se ha generado el evento ActionEvent
            //llevar a cabo el tratamiento correspodiente
            String mensaje="";
	    switch (indice) {
                    case 0:    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 1";
                               break;
                    case 1:    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 2";
                               break;
                    case 2:    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 3";
                               break;
                    case 3:    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 4";
                               break;
                    case 4:    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 5";
                               break;
                    case 5:    System.exit(0);
                               break;
                    case 6:    mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ PRIMERO";
                               break;
                    case 7:    mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ PRIMERO";
                               break;
                    case 8:    mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ SEGUNDO";
                               break;
                    case 9:    mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ SEGUNDO";
                               break;
                    case 10:    mensaje="HAS PULSADO LA OPCIÓN OPCION 3 DEL MENÚ SEGUNDO";
                               break;
                    case 11:    mensaje="HAS PULSADO LA OPCIÓN OPCION 4 DEL MENÚ SEGUNDO";
                               break;
                    case 12:    mensaje="HAS PULSADO LA OPCIÓN OPCION 5 DEL MENÚ SEGUNDO";
                               break;
                    case 13:    mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ TERCERO";
                               break;
                    case 14:    mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ TERCERO";
                               break;
                    case 15:    mensaje="HAS PULSADO LA OPCIÓN OPCION 3 DEL MENÚ TERCERO";
                               break;
                    case 16:    mensaje="HAS PULSADO LA OPCIÓN OPCION 4 DEL MENÚ TERCERO";
                               break;
                    case 17:    mensaje="HAS PULSADO LA OPCIÓN OPCION 5 DEL MENÚ TERCERO";
                               break;
                    case 18:    mensaje="HAS PULSADO LA OPCIÓN OPCION 6 DEL MENÚ TERCERO";
                               break;
                    case 19:    mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ CUARTO";
                               break;
                    case 20:    mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ CUARTO";
                               break;

                }
            //Cambiar el texto en la componente JTextField texto y en la componente
            //JLabel etiqueta
            texto.setText(mensaje);
            etiqueta.setText(mensaje);  
        }
    };
    
////////////////////////////////////////////////////////////////////////////////
//                      PANEL panelAcciones y COMPONENTES                     //
////////////////////////////////////////////////////////////////////////////////
        
/////////DECLARACIÓN CONTENEDOR JPanel panelAcciones 
        JPanel panelAcciones = new JPanel();     
        //asignación administrador GridLayout al contenedor con 8 filas y una
        //columna
        panelAcciones.setLayout(new GridLayout( 6, 1 ));

////////COMPONENTE JButton accion1
        accion1 = new JButton("ACCIÓN 1");
        //asignación tipografia a la componente JButton accion1
        accion1.setFont(new Font("arial", 0, 10));
        //asignación del gestor de eventos gestorEventosAccion al botón
        accion1.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion1 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion1);        
        
////////COMPONENTE JButton accion2
        accion2 = new JButton("ACCIÓN 2");
        //asignación tipografia a la componente JButton accion2
        accion2.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion2
        accion2.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion2 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion2);  
        
////////COMPONENTE JButton accion3
        accion3 = new JButton("ACCIÓN 3");
        //asignación tipografia a la componente JButton accion3
        accion3.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion3
        accion3.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion3 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion3);         
        
////////COMPONENTE JButton accion4
        accion4 = new JButton("ACCIÓN 4");
        //asignación tipografia a la componente JButton accion4
        accion4.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion4
        accion4.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion4 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion4);             
        
////////COMPONENTE JButton accion5
        accion5 = new JButton("ACCIÓN 5");
        //asignación tipografia a la componente JButton accion5
        accion5.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion5
        accion5.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion5 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion5);           
             
////////COMPONENTE JButton salir
        salir = new JButton("SALIR");
        //asignación tipografia a la componente JButton salir
        salir.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton salir
        salir.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton salir en el contenedor JPanel
        //panelColores
        panelAcciones.add(salir);           
                

////////////////////////////////////////////////////////////////////////////////
//                       COMPONENTE JTextField texto                          //
////////////////////////////////////////////////////////////////////////////////             

////////COMPONENTE JTextField texto
        texto=new JTextField();
         

////////////////////////////////////////////////////////////////////////////////
//                      PANEL panelVisual Y COMPONENTES                       //
////////////////////////////////////////////////////////////////////////////////

////////DECLARACIÓN CONTENEDOR JPanel panelVisual
        panelVisual=new JPanel();
        //asignación administrador de layout al contenedor JPanel panelVisual
        panelVisual.setLayout(new FlowLayout(FlowLayout.CENTER));
        
////////COMPONENTE JLabel etiqueta
        etiqueta=new JLabel();
        //asignación tipografía a la componente JLabel etiqueta
        etiqueta.setFont(new Font("arial", Font.BOLD, 18));
        //introducción componente JLabel etiqueta en el contenedor JPanel
        //panelVisual
        panelVisual.add(etiqueta);
        


        
////////////////////////////////////////////////////////////////////////////////
//                   PANEL panelMenu Y COMPONENTES ASOCIADAS                  //
////////////////////////////////////////////////////////////////////////////////          
       
////////DECLARACIÓN PANEL JPanel panelMenu
        JPanel panelMenu=new JPanel();
        
////////DECLARACIÓN COMPONENTE JMenuBar barraMenu
        JMenuBar barraMenu=new JMenuBar();

////////DECLARACIÓN DE LAS COMPONENTES JMenu ASOCIADAS A barraMenu
        JMenu primero=new JMenu("PRIMERO");
        JMenu segundo=new JMenu("SEGUNDO");
        JMenu tercero=new JMenu("TERCERO");
        JMenu cuarto=new JMenu("CUARTO");
        
////////COMPONENTES JMenuItem asociadas a la componente JMenu primero
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A primero y asignación
        //gestor de eventos a cada una de ellas
        primeroOpcion1=new JMenuItem("OPCIÓN 1");
        primeroOpcion1.addActionListener(gestorEventosAccion);
        primeroOpcion2=new JMenuItem("OPCIÓN 2");
        primeroOpcion2.addActionListener(gestorEventosAccion);
        //inclusión de las componentes JMenuItem a la componente 
        //JMenu primero
        primero.add(primeroOpcion1);
        primero.add(primeroOpcion2);         
        
////////COMPONENTES JMenuItem asociadas a la componente JMenu segundo
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A segundo y asignación
        //gestor de eventos a cada una de ellas
        segundoOpcion1=new JMenuItem("OPCIÓN 1");
        segundoOpcion1.addActionListener(gestorEventosAccion);
        segundoOpcion2=new JMenuItem("OPCIÓN 2");
        segundoOpcion2.addActionListener(gestorEventosAccion);
        segundoOpcion3=new JMenuItem("OPCIÓN 3");
        segundoOpcion3.addActionListener(gestorEventosAccion);
        segundoOpcion4=new JMenuItem("OPCIÓN 4");
        segundoOpcion4.addActionListener(gestorEventosAccion);
        segundoOpcion5=new JMenuItem("OPCIÓN 5");
        segundoOpcion5.addActionListener(gestorEventosAccion);
        //inclusión de las componentes JMenuItem a la componente JMenu segundo
        segundo.add(segundoOpcion1);
        segundo.add(segundoOpcion2);
        segundo.add(segundoOpcion3);
        segundo.add(segundoOpcion4);        
        segundo.add(segundoOpcion5);
      
////////COMPONENTES JMenuItem asociadas a la componente JMenu tercero
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A tercero y asignación
        //gestor de eventos a cada una de ellas
        terceroOpcion1=new JMenuItem("OPCIÓN 1");
        terceroOpcion1.addActionListener(gestorEventosAccion);
        terceroOpcion2=new JMenuItem("OPCIÓN 2");
        terceroOpcion2.addActionListener(gestorEventosAccion);
        terceroOpcion3=new JMenuItem("OPCIÓN 3");
        terceroOpcion3.addActionListener(gestorEventosAccion);
        terceroOpcion4=new JMenuItem("OPCIÓN 4");
        terceroOpcion4.addActionListener(gestorEventosAccion);
        terceroOpcion5=new JMenuItem("OPCIÓN 5");
        terceroOpcion5.addActionListener(gestorEventosAccion);
        terceroOpcion6=new JMenuItem("OPCIÓN 6"); 
        terceroOpcion6.addActionListener(gestorEventosAccion);
        //inclusión de las componentes JMenuItem a la componente JMenu tercero
        tercero.add(terceroOpcion1);
        tercero.add(terceroOpcion2);
        tercero.add(terceroOpcion3);
        tercero.add(terceroOpcion4);        
        tercero.add(terceroOpcion5);
        tercero.add(terceroOpcion6); 
        
////////COMPONENTES JMenuItem asociadas a la componente JMenu cuarto
        //DECLARACIONES COMPONENTES JRadioButtonMenuItem ASOCIADAS A cuarto y asignación
        //gestor de eventos a cada una de ellas
        cuartoOpcion1=new JRadioButtonMenuItem("OPCIÓN 1",false);
        cuartoOpcion1.addActionListener(gestorEventosAccion);
        cuartoOpcion2=new JRadioButtonMenuItem("OPCIÓN 2",true);
        cuartoOpcion2.addActionListener(gestorEventosAccion);
        //AGRUPACIÓN DE LOS BOTONES JRadioButtonMenuItem colorearMenu y sinColorearMenu en el
        //grupo ButtonGroup grupoJRadioButtonMenu
        ButtonGroup grupoJRadioButtonMenu= new ButtonGroup();
        grupoJRadioButtonMenu.add(cuartoOpcion1);
        grupoJRadioButtonMenu.add(cuartoOpcion2);
        //inclusión de las componentes JMenuItem a la componente JMenu cuarto
        cuarto.add(cuartoOpcion1);
        cuarto.add(cuartoOpcion2);

        
////////INLCUSIÓN MENUS EN LA BARRA DE MENUS
        barraMenu.add(primero);
        barraMenu.add(segundo);
        barraMenu.add(tercero);
        barraMenu.add(cuarto);
        
////////INCLUSIÓN barraMenu EN EL PANEL panelMenu
        panelMenu.add(barraMenu);

////////////////////////////////////////////////////////////////////////////////
//   DISTRIBUCIÓN PANELES Y COMPONENTES EN EL PANEL DE CONTENIDOS DEL JFrame  //
////////////////////////////////////////////////////////////////////////////////    
        
////////INCLUSIÓN DEL CONTENEDOR JPanel panelAcciones EN LA ZONA OESTE DEL CONTENEDOR 
////////panelContenidos
        panelContenidos.add(panelAcciones, BorderLayout.WEST);
        
////////INCLUSIÓN DEL CONTENEDOR JPanel panelMenu EN LA ZONA NORTH DEL CONTENEDOR 
////////panelContenidos
        panelContenidos.add(panelMenu, BorderLayout.NORTH); 

////////INCLUSIÓN DE LA COMPONENTE JTextFiel texto EN LA ZONA SUR DEL CONTENEDOR
////////panelContenidos
        panelContenidos.add(texto, BorderLayout.SOUTH);  
        
////////inclusión DE JPanel panelVisual en el area CENTRO del CONTENEDOR 
////////panelContenidos
        panelContenidos.add(panelVisual, BorderLayout.CENTER);        

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


}
