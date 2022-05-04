/*
3. Implementar en JAVA la interface C teniendo en cuenta las funcionalidades asociadas a 
las siguientes componentes:
    - Componente JButton rojo  al pulsar el botón ROJO el contenedor JPanel 
    dibujo se visualizará con el color rojo.
    - Componente JMenuItem rojoMenu  al seleccionar la opción ROJO del 
    menú COLOR FONDO el contenedor JPanel dibujo se visualizará con el 
    color rojo.
    - Componente JMenuItem borrarMenu  al seleccionar la opción BORRAR
    del menú GENERAL el contenedor JPanel dibujo se visualizará con el color 
    de borrado. Por defecto, si no es cambiado, el color de borrado es el 
    blanco.
    - Componente JButton borrar  al pulsar el botón BORRAR el contenedor 
    JPanel dibujo se visualizará con el color blanco. Por defecto, si no es 
    cambiado, el color de borrado es el blanco.
    - Componente JMenuItem colorBorradoMenu  al seleccionar la opción 
    COLOR BORRADO el usuario podrá cambiar el color de borrado 
    seleccionándolo interactivamente a través de la ventana de selección de 
    color.
    - Componente JButton colorBorrado  al pulsar el botón COLOR BORRADO 
    el usuario podrá cambiar el color de borrado seleccionándolo
    interactivamente a través de la ventana de selección de color.
    - Componente JButton salir  al pulsar el botón SALIR al pulsar el botón
    SALIR la ventana de la aplicación será cerrada y la ejecución finalizará.


PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
*/

package problemasimplementacioninterfacesgraficas_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                             CLASE interface_7                              //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////    

public class Problema3_Interface_C extends JFrame{
    //ATRIBUTOS
    private int opcion;
    private JPanel dibujo;
    private boolean coloreado=false;
    private Color colorTrazado=Color.GREEN;
    private Color colorFondo=Color.WHITE;
    private String texto="¿ HOLA COMO ESTÁIS ?";
    private JRadioButtonMenuItem colorearMenuBoton,sinColorearMenuBoton;
    private JRadioButton colorear,sinColorear;
    private Container panelContenidos;
    private JFrame ventana;


    public static void main(String[] args) {
        new Problema3_Interface_C().metodoPrincipal();        
    }

    private void metodoPrincipal() {    
        //declaración contenedor JFrame
        ventana=new JFrame();
        //título contenedor pruebaBotones
        ventana.setTitle("PROBLEMA 3 - INTERFACE C");
        //asignación panel de contenidos del JFrame al contenedor panelContenidos
        panelContenidos=ventana.getContentPane();
        
        inicializacion();
    }

    private void inicializacion() {
////////////////////////////////////////////////////////////////////////////////
//                            MANIPULADORES DE EVENTOS                        //
////////////////////////////////////////////////////////////////////////////////

////////MANIPULADOR DE EVENTOS manipuladorEventos
        ActionListener manipuladorEventos=new ActionListener()  { 
                @Override
                public void actionPerformed(ActionEvent evento)  { 
                        switch (evento.getActionCommand()) {
                            case "ROJO"         :dibujo.setBackground(Color.RED);
                                                 break;
                            case "COLOR BORRADO":Color color = JColorChooser.showDialog(null, "SELECCIONE UN COLOR", 
                                                        Color.LIGHT_GRAY );
                                                 // establecer color predeterminado, si no se devuelve un color
                                                 // Si no se ha seleccionado ningún color por defecto se asigna el
                                                 //color rojo
                                                 if ( color == null ) color = Color.RED;
                                                    // cambiar color de fondo del botón con el color seleccionado
                                                 colorFondo=color;
                                                 break;
                            case "BORRAR"       :dibujo.setBackground(colorFondo);
                                                 break;
                            case "SALIR"        ://Salir de la aplicación
                                                 System.exit(0);
                        }      
                }
        }; 

////////////////////////////////////////////////////////////////////////////////
//                      PANEL panelColores y COMPONENTES                      //
////////////////////////////////////////////////////////////////////////////////
        
/////////DECLARACIÓN CONTENEDOR JPanel panelColores 
        JPanel panelColores = new JPanel();     
        //asignación administrador GridLayout al contenedor con 8 filas y una
        //columna
        panelColores.setLayout(new GridLayout( 6, 1 ));

////////COMPONENTE JButton rojo
        JButton rojo = new JButton("ROJO");
        //asignación tipografia a la componente JButton rojo
        rojo.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton rojo
        rojo.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton rojo
        rojo.setBackground(Color.RED);
        //manipulador de evento asociado a la componente 
        //JButton rojo
        rojo.addActionListener(manipuladorEventos);
        //inclusión de la componente JButton rojo en el contenedor JPanel
        //panelColores
        panelColores.add(rojo);        
        
////////COMPONENTE JButton verde
        JButton verde = new JButton("VERDE");
        //asignación tipografia a la componente JButton verde
        verde.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton verde
        verde.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton verde
        verde.setBackground(Color.GREEN);
        //inclusión de la componente JButton verde en el contenedor JPanel
        //panelColores
        panelColores.add(verde);  
        
////////COMPONENTE JButton azul
        JButton azul = new JButton("AZUL");
        //asignación tipografia a la componente JButton azul
        azul.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton azul
        azul.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton azul
        azul.setBackground(Color.BLUE);
        //inclusión de la componente JButton azul en el contenedor JPanel
        //panelColores
        panelColores.add(azul);         
        
////////COMPONENTE JButton cyan
        JButton cyan = new JButton("CYAN");
        //asignación tipografia a la componente JButton cyan
        cyan.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton cyan
        cyan.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton cyan
        cyan.setBackground(Color.CYAN);
        //inclusión de la componente JButton cyan en el contenedor JPanel
        //panelColores
        panelColores.add(cyan);             
        
////////COMPONENTE JButton magenta
        JButton magenta = new JButton("MAGENTA");
        //asignación tipografia a la componente JButton magenta
        magenta.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton magenta
        magenta.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton magenta
        magenta.setBackground(Color.MAGENTA);
        //inclusión de la componente JButton magenta en el contenedor JPanel
        //panelColores
        panelColores.add(magenta);           
             
////////COMPONENTE JButton amarillo
        JButton amarillo = new JButton("AMARILLO");
        //asignación tipografia a la componente JButton amarillo
        amarillo.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton amarillo
        amarillo.setForeground(Color.BLACK);
        //asignación color de fondo componente JButton amarillo
        amarillo.setBackground(Color.YELLOW);
        //inclusión de la componente JButton amarillo en el contenedor JPanel
        //panelColores
        panelColores.add(amarillo);           
                

////////////////////////////////////////////////////////////////////////////////
//                      PANEL panelFiguras y COMPONENTES                      //
////////////////////////////////////////////////////////////////////////////////        
        
////////DECLARACIÓN contenedor JPanel para colocar 5 componentes JButton
        JPanel panelFiguras = new JPanel();
        
        //asignación administrador GridLayout al contenedor con 5 filas y una
        //columna
        panelFiguras.setLayout(new GridLayout( 5, 1 ));

////////COMPONENTE JButton rectangulo
        JButton rectangulo = new JButton("RECTANGULO");
        //asignación tipografia a la componente JButton rectangulo
        rectangulo.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton rectangulo
        rectangulo.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton rectangulo
        rectangulo.setBackground(Color.BLACK);
        //inclusión de la componente JButton rectangulo en el contenedor JPanel
        //panelColores
        panelFiguras.add(rectangulo);        
 
////////COMPONENTE JButton elipse
        JButton elipse = new JButton("ELIPSE");
        //asignación tipografia a la componente JButton elipse
        elipse.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton elipse
        elipse.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton elipse
        elipse.setBackground(Color.BLACK);
        //inclusión de la componente JButton elipse en el contenedor JPanel
        //panelColores
        panelFiguras.add(elipse);        
 
////////COMPONENTE JButton polilinea
        JButton polilinea = new JButton("POLILINEA");
        //asignación tipografia a la componente JButton polilinea
        polilinea.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton polilinea
        polilinea.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton polilinea
        polilinea.setBackground(Color.BLACK);
        //inclusión de la componente JButton polilinea en el contenedor JPanel
        //panelColores
        panelFiguras.add(polilinea);      
 
////////COMPONENTE JButton poligono
        JButton poligono = new JButton("POLIGONO");
        //asignación tipografia a la componente JButton poligono
        poligono.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton poligono
        poligono.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton poligono
        poligono.setBackground(Color.BLACK);
        //inclusión de la componente JButton poligono en el contenedor JPanel
        //panelColores
        panelFiguras.add(poligono);      
 
////////COMPONENTE JButton texto
        JButton texto = new JButton("TEXTO");
        //asignación tipografia a la componente JButton texto
        texto.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JButton texto
        texto.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton texto
        texto.setBackground(Color.BLACK);
        //inclusión de la componente JButton texto en el contenedor JPanel
        //panelColores
        panelFiguras.add(texto);      

       
////////////////////////////////////////////////////////////////////////////////
//                       PANEL panelVarios y COMPONENTES                      //
////////////////////////////////////////////////////////////////////////////////             
        
//////////DECLARACIÓN contenedor JPanel para colocar 3 componentes JButton y el
        //contenedor JPanel panelColoreado
        JPanel panelVarios = new JPanel();

        //asignación administrador GridLayout 
        panelVarios.setLayout(new  GridLayout(1,4));
        

////////COMPONENTE JButton fondo
        JButton colorBorrado = new JButton("COLOR BORRADO");
        //asignación color de colorBorrado componente JButton COLOR TRAZADO
        colorBorrado.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton COLOR TRAZADO
        colorBorrado.setBackground(Color.BLACK);
        //manipulador de evento asociado a la componente 
        //JButton COLOR TRAZADO
        colorBorrado.addActionListener(manipuladorEventos);      
        //inclusión de la componente JButton fondo en el contenedor JPanel
        //panelVarios
        panelVarios.add(colorBorrado);        

////////COMPONENTE JButton borrar
        JButton borrar = new JButton("BORRAR");
        //asignación color de colorBorrado componente JButton borrar
        borrar.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton borrar
        borrar.setBackground(Color.BLACK);
        //manipulador de evento asociado a la componente 
        //JButton borrar
        borrar.addActionListener(manipuladorEventos);
        //inclusión de la componente JButton borrar en el contenedor JPanel
        //panelVarios
        panelVarios.add(borrar);        
      
        ///////////////////////////////////////////////////////////////////////
        //              PANEL panelColoreado y COMPONENTES                   //
        /////////////////////////////////////////////////////////////////////// 
        
////////DECLARACIÓN CONTENEDOR JPanel panelColoreado
        JPanel panelColoreado=new JPanel();
        //asignación administrador de layout FlowLayout al panel panelColoreado
        panelColoreado.setLayout(new GridLayout(2,1));
        
/////////COMPONENTE JRadioButton colorear
        colorear = new JRadioButton("COLOREAR",false);
        //asignación tipografia a la componente JRadioButton colorear
        colorear.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JRadioButton colorear
        colorear.setForeground(Color.WHITE);
        //asignación color de fondo componente JRadioButton colorear
        colorear.setBackground(Color.BLACK);
        //inclusión de la componente JRadioButton colorear en el contenedor JPanel
        //panelVarios
        panelColoreado.add(colorear);        
        
////////COMPONENTE JRadioButton sinColorear
        sinColorear = new JRadioButton("SIN COLOREAR",true);
        //asignación tipografia a la componente JRadioButton sinColorear
        sinColorear.setFont(new Font("arial", 0, 10));
        //asignación color de colorBorrado componente JRadioButton sinColorear
        sinColorear.setForeground(Color.WHITE);
        //asignación color de fondo componente JRadioButton sinColorear
        sinColorear.setBackground(Color.BLACK);
        //inclusión de la componente JRadioButton sinColorear en el contenedor JPanel
        //panelVarios
        panelColoreado.add(sinColorear); 

////////AGRUPACIÓN DE LOS BOTOTNES JRadioButton colorear y sinColorear en el
////////grupo ButtonGroup grupoJRadioButton
        ButtonGroup grupoJRadioButton= new ButtonGroup();
        grupoJRadioButton.add(colorear);
        grupoJRadioButton.add(sinColorear);

////////INCLUSIÓN CONTENEDOR panelColoreado EN EL CONTENEDOR JPanel panelVarios
        panelVarios.add(panelColoreado);
              

////////COMPONENTE JButton salir
        JButton salir = new JButton("SALIR");
        //asignación color de colorBorrado componente JButton salir
        salir.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton salir
        salir.setBackground(Color.BLACK);
        //manipulador de evento asociado a la componente 
        //JButton salir
        salir.addActionListener(manipuladorEventos);
        //inclusión de la componente JButton salir en el contenedor JPanel
        //panelVarios
        panelVarios.add(salir);  

        
////////////////////////////////////////////////////////////////////////////////
//                   PANEL panelMenu Y COMPONENTES ASOCIADAS                  //
////////////////////////////////////////////////////////////////////////////////          
       
////////DECLARACIÓN PANEL JPanel panelMenu
        JPanel panelMenu=new JPanel();
        
////////DECLARACIÓN COMPONENTE JMenuBar barraMenu
        JMenuBar barraMenu=new JMenuBar();

////////DECLARACIÓN DE LAS COMPONENTES JMenu ASOCIADAS A barraMenu
        JMenu generalMenu=new JMenu("GENERAL");
        JMenu figurasMenu=new JMenu("FIGURAS");
        JMenu coloresMenu=new JMenu("COLOR FONDO");
        JMenu coloreadoMenu=new JMenu("COLOREADO");
        
////////COMPONENTES JMenuItem asociadas a la componente JMenu generalMenu
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A generalMenu
        JMenuItem colorBorradoMenu=new JMenuItem("COLOR BORRADO");
        JMenuItem borrarMenu=new JMenuItem("BORRAR");
        //asignación manipulador eventos 
        colorBorradoMenu.addActionListener(manipuladorEventos);
        borrarMenu.addActionListener(manipuladorEventos);
        //inclusión de las componentes JMenuItem a la componente 
        //JMenu generalMenu
        generalMenu.add(colorBorradoMenu);
        generalMenu.add(borrarMenu);         
        
////////COMPONENTES JMenuItem asociadas a la componente JMenu figurasMenu
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A figurasMenu
        JMenuItem rectanguloMenu=new JMenuItem("RECTANGULO");
        JMenuItem elipseMenu=new JMenuItem("ELIPSE");
        JMenuItem polilineaMenu=new JMenuItem("POLILINEA");
        JMenuItem poligonoMenu=new JMenuItem("POLIGONO");
        JMenuItem textoMenu=new JMenuItem("TEXTO");
        //inclusión de las componentes JMenuItem a la componente JMenu figurasMenu
        figurasMenu.add(rectanguloMenu);
        figurasMenu.add(elipseMenu);
        figurasMenu.add(polilineaMenu);
        figurasMenu.add(poligonoMenu);        
        figurasMenu.add(textoMenu);
      
////////COMPONENTES JMenuItem asociadas a la componente JMenu coloresMenu
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A coloresMenu
        JMenuItem rojoMenu=new JMenuItem("ROJO");
        JMenuItem verdeMenu=new JMenuItem("VERDE");
        JMenuItem azulMenu=new JMenuItem("AZUL");
        JMenuItem cyanMenu=new JMenuItem("CYAN");
        JMenuItem magentaMenu=new JMenuItem("MAGENTA");
        JMenuItem amarilloMenu=new JMenuItem("AMARILLO");      
        //inclusión de las componentes JMenuItem a la componente JMenu coloresMenu
        coloresMenu.add(rojoMenu);
        coloresMenu.add(verdeMenu);
        coloresMenu.add(azulMenu);
        coloresMenu.add(cyanMenu);        
        coloresMenu.add(magentaMenu);
        coloresMenu.add(amarilloMenu); 
        //asignación manipulador eventos manipuladorEventos a la componente JMenuItem
        //rojoMenu
        rojoMenu.addActionListener(manipuladorEventos);

        
////////COMPONENTES JMenuItem asociadas a la componente JMenu coloreadoMenu
        //DECLARACIONES COMPONENTES JRadioButtonMenuItem ASOCIADAS A coloreadoMenu
        colorearMenuBoton=new JRadioButtonMenuItem("COLOREAR",false);
        sinColorearMenuBoton=new JRadioButtonMenuItem("SIN COLOREAR",true);
        //AGRUPACIÓN DE LOS BOTONES JRadioButtonMenuItem colorearMenu y sinColorearMenu en el
        //grupo ButtonGroup grupoJRadioButtonMenu
        ButtonGroup grupoJRadioButtonMenu= new ButtonGroup();
        grupoJRadioButtonMenu.add(colorearMenuBoton);
        grupoJRadioButtonMenu.add(sinColorearMenuBoton);
        //inclusión de las componentes JMenuItem a la componente JMenu coloreadoMenu
        coloreadoMenu.add(colorearMenuBoton);
        coloreadoMenu.add(sinColorearMenuBoton);

        
////////INLCUSIÓN MENUS EN LA BARRA DE MENUS
        barraMenu.add(generalMenu);
        barraMenu.add(figurasMenu);
        barraMenu.add(coloresMenu);
        barraMenu.add(coloreadoMenu);
        
////////INCLUSIÓN barraMenu EN EL PANEL panelMenu
        panelMenu.add(barraMenu, BorderLayout.NORTH);
        
        
////////////////////////////////////////////////////////////////////////////////
//                   COMPONENTE JComponent dibujo ASOCIADA                    //
//////////////////////////////////////////////////////////////////////////////// 

        
////////DECLARACIÓN COMPONENTE AreaDibujo dibujo
        dibujo=new JPanel();


////////////////////////////////////////////////////////////////////////////////
//   DISTRIBUCIÓN PANELES Y COMPONENTES EN EL CONTENEDOR JFrame interface_7   //
//////////////////////////////////////////////////////////////////////////////// 

////////INCLUSIÓN DEL CONTENEDOR JPanel panelColores EN LA ZONA OESTE DEL CONTENEDOR 
////////panelContenidos
        panelContenidos.add(panelColores, BorderLayout.WEST);

////////INCLUSIÓN DEL CONTENEDOR JPanel panelFiguras EN LA ZONA ESTE DEL CONTENEDOR 
////////panelContenidos
         panelContenidos.add(panelFiguras, BorderLayout.EAST);  

////////INCLUSIÓN DEL CONTENEDOR JPanel panelMenu EN LA ZONA NORTE DEL CONTENEDOR 
////////panelContenidos
         panelContenidos.add(panelMenu, BorderLayout.NORTH); 

////////INCLUSIÓN DEL CONTENEDOR JPanel panelVarios EN LA ZONA SUR DEL  CONTENEDOR 
////////panelContenidos
         panelContenidos.add(panelVarios, BorderLayout.SOUTH);  
        
////////inclusión DE CONTENEDOR JPanel dibujo en el area CENTRO del CONTENEDOR 
////////panelContenidos
         panelContenidos.add(dibujo, BorderLayout.CENTER);        

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
