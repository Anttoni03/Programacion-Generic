/*
. Implementar en JAVA la interface B2 teniendo en cuenta las funcionalidades asociadas a 
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

***************************** NOTA IMPORTANTE **********************************
En esta vérsión los literales de las opciones de los menús han sido modificados 
para que no existan dos opciones con el mismo literal asociado.
********************************************************************************

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

public class Problema2_Interface_B2 {
    private Container panelContenidos;
    private JPanel panelVisual;
    private JLabel etiqueta;
    private JTextField texto;
    private JFrame ventana;


    public static void main(String[] args) {
        new Problema2_Interface_B2().metodoPrincipal();        
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
            //En función sde la componente donde se ha generado el evento ActionEvent
            //llevar a cabo el tratamiento correspodiente
            String mensaje="";
	    switch (evento.getActionCommand()) {
                    case "ACCIÓN 1":    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 1";
                                        break;
                    case "ACCIÓN 2":    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 2";
                                        break;
                    case "ACCIÓN 3":    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 3";
                                        break;
                    case "ACCIÓN 4":    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 4";
                                        break;
                    case "ACCIÓN 5":    mensaje="HAS PULSADO EL BOTÓN ACCIÓN 5";
                               break;
                    case "SALIR":       System.exit(0);
                                        break;
                    case "OPCIÓN 1.1":  mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ PRIMERO";
                                        break;
                    case "OPCIÓN 1.2":  mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ PRIMERO";
                                        break;
                    case "OPCIÓN 2.1":  mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ SEGUNDO";
                                        break;
                    case "OPCIÓN 2.2":  mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ SEGUNDO";
                                        break;
                    case "OPCIÓN 2.3":  mensaje="HAS PULSADO LA OPCIÓN OPCION 3 DEL MENÚ SEGUNDO";
                                        break;
                    case "OPCIÓN 2.4":  mensaje="HAS PULSADO LA OPCIÓN OPCION 4 DEL MENÚ SEGUNDO";
                                        break;
                    case "OPCIÓN 2.5":  mensaje="HAS PULSADO LA OPCIÓN OPCION 5 DEL MENÚ SEGUNDO";
                                        break;
                    case "OPCIÓN 3.1":  mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ TERCERO";
                                        break;
                    case "OPCIÓN 3.2":  mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ TERCERO";
                                        break;
                    case "OPCIÓN 3.3":  mensaje="HAS PULSADO LA OPCIÓN OPCION 3 DEL MENÚ TERCERO";
                                        break;
                    case "OPCIÓN 3.4":  mensaje="HAS PULSADO LA OPCIÓN OPCION 4 DEL MENÚ TERCERO";
                                        break;
                    case "OPCIÓN 3.5":  mensaje="HAS PULSADO LA OPCIÓN OPCION 5 DEL MENÚ TERCERO";
                                        break;
                    case "OPCIÓN 3.6":  mensaje="HAS PULSADO LA OPCIÓN OPCION 6 DEL MENÚ TERCERO";
                               break;
                    case "OPCIÓN 4.1":  mensaje="HAS PULSADO LA OPCIÓN OPCION 1 DEL MENÚ CUARTO";
                               break;
                    case "OPCIÓN 4.2":  mensaje="HAS PULSADO LA OPCIÓN OPCION 2 DEL MENÚ CUARTO";
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
        JButton accion1 = new JButton("ACCIÓN 1");
        //asignación tipografia a la componente JButton accion1
        accion1.setFont(new Font("arial", 0, 10));
        //asignación del gestor de eventos gestorEventosAccion al botón
        accion1.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion1 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion1);        
        
////////COMPONENTE JButton accion2
        JButton accion2 = new JButton("ACCIÓN 2");
        //asignación tipografia a la componente JButton accion2
        accion2.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion2
        accion2.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion2 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion2);  
        
////////COMPONENTE JButton accion3
        JButton accion3 = new JButton("ACCIÓN 3");
        //asignación tipografia a la componente JButton accion3
        accion3.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion3
        accion3.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion3 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion3);         
        
////////COMPONENTE JButton accion4
        JButton accion4 = new JButton("ACCIÓN 4");
        //asignación tipografia a la componente JButton accion4
        accion4.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion4
        accion4.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion4 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion4);             
        
////////COMPONENTE JButton accion5
        JButton accion5 = new JButton("ACCIÓN 5");
        //asignación tipografia a la componente JButton accion5
        accion5.setFont(new Font("arial", 0, 10));
        //asignación gestor de eventos a la componente JButton accion5
        accion5.addActionListener(gestorEventosAccion);
        //inclusión de la componente JButton accion5 en el contenedor JPanel
        //panelColores
        panelAcciones.add(accion5);           
             
////////COMPONENTE JButton salir
        JButton salir = new JButton("SALIR");
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
        JMenuItem primeroOpcion1=new JMenuItem("OPCIÓN 1.1");
        primeroOpcion1.addActionListener(gestorEventosAccion);
        JMenuItem primeroOpcion2=new JMenuItem("OPCIÓN 1.2");
        primeroOpcion2.addActionListener(gestorEventosAccion);
        //inclusión de las componentes JMenuItem a la componente 
        //JMenu primero
        primero.add(primeroOpcion1);
        primero.add(primeroOpcion2);         
        
////////COMPONENTES JMenuItem asociadas a la componente JMenu segundo
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A segundo y asignación
        //gestor de eventos a cada una de ellas
        JMenuItem segundoOpcion1=new JMenuItem("OPCIÓN 2.1");
        segundoOpcion1.addActionListener(gestorEventosAccion);
        JMenuItem segundoOpcion2=new JMenuItem("OPCIÓN 2.2");
        segundoOpcion2.addActionListener(gestorEventosAccion);
        JMenuItem segundoOpcion3=new JMenuItem("OPCIÓN 2.3");
        segundoOpcion3.addActionListener(gestorEventosAccion);
        JMenuItem segundoOpcion4=new JMenuItem("OPCIÓN 2.4");
        segundoOpcion4.addActionListener(gestorEventosAccion);
        JMenuItem segundoOpcion5=new JMenuItem("OPCIÓN 2.5");
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
        JMenuItem terceroOpcion1=new JMenuItem("OPCIÓN 3.1");
        terceroOpcion1.addActionListener(gestorEventosAccion);
        JMenuItem terceroOpcion2=new JMenuItem("OPCIÓN 3.2");
        terceroOpcion2.addActionListener(gestorEventosAccion);
        JMenuItem terceroOpcion3=new JMenuItem("OPCIÓN 3.3");
        terceroOpcion3.addActionListener(gestorEventosAccion);
        JMenuItem terceroOpcion4=new JMenuItem("OPCIÓN 3.4");
        terceroOpcion4.addActionListener(gestorEventosAccion);
        JMenuItem terceroOpcion5=new JMenuItem("OPCIÓN 3.5");
        terceroOpcion5.addActionListener(gestorEventosAccion);
        JMenuItem terceroOpcion6=new JMenuItem("OPCIÓN 3.6"); 
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
        JRadioButtonMenuItem cuartoOpcion1=new JRadioButtonMenuItem("OPCIÓN 4.1",false);
        cuartoOpcion1.addActionListener(gestorEventosAccion);
        JRadioButtonMenuItem cuartoOpcion2=new JRadioButtonMenuItem("OPCIÓN 4.2",true);
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
