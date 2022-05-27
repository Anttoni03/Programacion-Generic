/*
TALLER 2

SIMULACIÓN DEL JUEGO KUKU KUBE

JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
*/

package taller2_2021_2022;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                             CLASE taller2                                  //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////    

public class kukukube_CON_PANEL_INFORMATIVO {
////////DECLARACIÓN ATRIBUTOS
    private JFrame ventana;
    private Container panelContenidos;
    private static final int DIMENSION_X_VISUALIZACION=800;
    private static final int DIMENSION_Y_VISUALIZACION=800;
    private JLabel etiquetaValNivelesPartida,etiquetaValNivelActual, 
            etiquetaValNivelesRestantes, etiquetaValPuntuacion;
    private static Font tipografia1=new Font("ARIAL",Font.BOLD,25);
    private static Border borde1=BorderFactory.createRaisedBevelBorder();
    private JPanel panelVisualizacion;
    private JPanel panelStandby, panelJuego;
    private TableroCuadrados panelCuadrados;
    private int complejidad, nivel, numeroJuegos;
    private int juegosJugados;
    private int puntos=0;
    private boolean refrescarPanelJuego=false;
            
    
    //MÉTODO MAIN
    public static void main(String[] args) throws Exception {
         try { //Control de la apariencia
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception error) {
            System.out.println("NO SE HA ESTABLECIDO LA APARIENCIA DESEADA: " + error);
        }       
        new kukukube_CON_PANEL_INFORMATIVO().metodoPrincipal();        
    }
    
    private void metodoPrincipal() {       
        //título contenedor pruebaBotones
        ventana=new JFrame("TALLER 2 - PROGRAMACION II - 2021-2022 - UIB");
        //asignación a panelContenidos del panel de contenidos del JFrame
        panelContenidos=ventana.getContentPane();
        //asignación a panelContenidos del administrador de Layaout BorderLayout
        panelContenidos.setLayout(new BorderLayout());
        //declaración y definición contenedores y componentes de la interface
        creacionContenedoresYComponentes();                  
    }

    
////////MÉTODOS
    
    //MÉTODO QUE LLEVA  A CABO LA CONFORMACIÓN DE LA INTERFACE DE LA APLICACIÓN,
    //ACORDE AL DESEÑO DE LA MISMA, DECLARANDO Y DEFINIENDO TODAS LAS ENTIDADES
    //(CONTENEDORES, COMPONENTES, ADMINISTRADORES DE LAYOUT Y ASIGNACIÓN
    //DE GESTORES DE EVENTOS) NECESARIAS PARA ELLO
    private void creacionContenedoresYComponentes() {
        ////////////////////////////////////////////////////////////////////////
        //                                                                    //
        //           CONTENEDOR JPanel panelBotones y COMPONENTES             //
        ////////////////////////////////////////////////////////////////////////        
        //DECLARACIÓN CONTENEDOR JPanel panelBotones 
        JPanel panelBotones = new JPanel();     
        //ASIGNACIÓN AL CONTENEDOR panelBotones DEL ADMINISTRADOR DE LAYOUT 
        //GridLayout CON UNA ESTRUCTURA DE 1 FILA Y 4 COLUMNAS
        panelBotones.setLayout(new GridLayout( 1, 3 ));

        
        ////////COMPONENTE JButton nuevaPartidaBoton
        JButton nuevaPartidaBoton = new JButton("NUEVA PARTIDA");
        //asignación tipografia a la componente JButton nuevaPartidaBoton
        nuevaPartidaBoton.setFont(new Font("arial", Font.BOLD, 13));
        //asignación color de abrirBoton componente JButton nuevaPartidaBoton
        nuevaPartidaBoton.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton nuevaPartidaBoton
        nuevaPartidaBoton.setBackground(Color.BLACK);
        //manipulador de evento asociado a la componente 
        //JButton nuevaPartidaBoton
        nuevaPartidaBoton.addActionListener(new manipuladorEventosFuncionalidades());
        //inclusión de la componente JButton nuevaPartidaBoton en el contenedor JPanel
        //panelCreacion
        panelBotones.add(nuevaPartidaBoton);         
      
        
        ////////COMPONENTE JButton salirBoton
        JButton salirBoton = new JButton("SALIR");
        //asignación tipografia a la componente JButton salirBoton
        salirBoton.setFont(new Font("arial",Font.BOLD, 13));
        //asignación color de abrirBoton componente JButton salirBoton
        salirBoton.setForeground(Color.WHITE);
        //asignación color de fondo componente JButton salirBoton
        salirBoton.setBackground(Color.BLACK);
        //manipulador de evento asociado a la componente 
        //JButton salirBoton
        salirBoton.addActionListener(new manipuladorEventosFuncionalidades());
        //inclusión de la componente JButton salirBoton en el contenedor 
        //JPanel panelBotones
        panelBotones.add(salirBoton);             
        
        
////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                         CONTENEDOR JPanel panelSuperior                    //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////    
        JPanel panelSuperior=new JPanel();
        panelSuperior.setLayout(new BorderLayout());

////////////////////////////////////////////////////////////////////////////////
//////////                                                                    //
//////////          COMPONENTE JMenuBar barraMenu y COMPONENTES               //
////////////////////////////////////////////////////////////////////////////////  
        ////////DECLARACIÓN COMPONENTE JMenuBar barraMenu
        JMenuBar barraMenu=new JMenuBar();

        ////////DECLARACIÓN DE LAS COMPONENTES JMenu ASOCIADAS A barraMenu
        JMenu menu=new JMenu("MENÚ");
        
        ////////COMPONENTES JMenuItem asociadas a la componente JMenu menu
        //DECLARACIONES COMPONENTES JMenuItem ASOCIADAS A menu
        JMenuItem nuevaPartidaMenu=new JMenuItem("NUEVA PARTIDA");
        JMenuItem salirMenu=new JMenuItem("SALIR");
        //asignación manipulador eventos 
        nuevaPartidaMenu.addActionListener(new manipuladorEventosFuncionalidades());
        salirMenu.addActionListener(new manipuladorEventosFuncionalidades());
        //inclusión de las componentes JMenuItem a la componente 
        //JMenu menu
        menu.add(nuevaPartidaMenu);
        menu.add(salirMenu); 
        
        ////////INLCUSIÓN MENUS EN LA BARRA DE MENUS
        barraMenu.add(menu);

        
        JSplitPane separador1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        
        separador1.setTopComponent(barraMenu);
        
        //INTRODUCCIÓN JMenuBar separador1 EN EL CONTENEDOR JPanel panelSuperior               
        //EN LA ZONA NORTE DEL ADMINISTRADOR DE LAYOUT BorderLayout
        panelSuperior.add(separador1,BorderLayout.NORTH);
        
////////////////////////////////////////////////////////////////////////////////
//////////                                                                    //
//////////       CONTENEDOR JPanel panelInformacion Y COMPONENETES            //
//////////////////////////////////////////////////////////////////////////////// 
        JPanel panelInformacion=new JPanel();
        panelInformacion.setLayout(new GridLayout(2,2));
        
        
        //INTRODUCCIÓN CONTENEDOR JPanel panelInformacion EN EL CONTENEDOR JPanel
        //panelMenus EN EL AREA CENTRAL DEL ADMINISTRADOR BorderLayout
        panelSuperior.add(panelInformacion,BorderLayout.CENTER);

        ////////////////////////////////////////////////////////////////////////
        //CONTENEDORES JPanel panelInformativo1, panelInformativo2, panelInformativo3, panelInformativo4
        ////////////////////////////////////////////////////////////////////////
        JPanel panelInformativo1=new JPanel();
        panelInformativo1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelInformativo1.setBackground(Color.black);
        JPanel panelInformativo2=new JPanel();
        panelInformativo2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelInformativo2.setBackground(Color.black);
        JPanel panelInformativo3=new JPanel();
        panelInformativo3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelInformativo3.setBackground(Color.black);
        JPanel panelInformativo4=new JPanel();
        panelInformativo4.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelInformativo4.setBackground(Color.black);

        
        //INTRODUCCIÓN DE LOS CONTENEDORES JPanel panelInformativo1, panelInformativo2, panelInformativo3
        //Y panelInformativo4 EN EL CONTENEDOR JPanel panelInformacion 
        panelInformacion.add(panelInformativo1);
        panelInformacion.add(panelInformativo2);
        panelInformacion.add(panelInformativo3);
        panelInformacion.add(panelInformativo4);
        
        
        ////////////////////////////////////////////////////////////////////////
        //COMPONENTES JLabel CONTENEDOR JPanel panelInformativo1
        ////////////////////////////////////////////////////////////////////////
        //DECLARACIÓN COMPONENTE JLabel etiquetaNomNivelesPartida
        JLabel etiquetaNomNivelesPartida=new JLabel("NIVELES PARTIDA ");
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaNomNivelesPartida
        etiquetaNomNivelesPartida.setFont(tipografia1);
        etiquetaNomNivelesPartida.setBorder(borde1);
        etiquetaNomNivelesPartida.setBackground(Color.WHITE);
        etiquetaNomNivelesPartida.setOpaque(true);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaNomNivelesPartida 
        //EN EL CONTENEDOR JPanel panelInformativo1 
        panelInformativo1.add(etiquetaNomNivelesPartida);
                etiquetaNomNivelesPartida.setVerticalAlignment(3);
        //DECLARACIÓN COMPONENTE JLabel etiquetaValNivelesPartida
        etiquetaValNivelesPartida=new JLabel();
        etiquetaValNivelesPartida.setText("000");
        etiquetaValNivelesPartida.setForeground(Color.RED);
        etiquetaValNivelesPartida.setBorder(borde1);
        etiquetaValNivelesPartida.setBackground(Color.WHITE);
        etiquetaValNivelesPartida.setOpaque(true);
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaValNivelesPartida
        etiquetaValNivelesPartida.setFont(tipografia1);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaValNivelesPartida 
        //EN EL CONTENEDOR JPanel panelInformativo1 
        panelInformativo1.add(etiquetaValNivelesPartida);
 
        ////////////////////////////////////////////////////////////////////////
        //COMPONENTES JLabel CONTENEDOR JPanel panelInformativo2
        ////////////////////////////////////////////////////////////////////////
        //DECLARACIÓN COMPONENTE JLabel etiquetaNomNivelesRestantes
        JLabel etiquetaNomNivelesRestantes=new JLabel("NIVELES RESTANTES ");
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaNomNivelesRestantes
        etiquetaNomNivelesRestantes.setFont(tipografia1);
        etiquetaNomNivelesRestantes.setBorder(borde1);
        etiquetaNomNivelesRestantes.setBackground(Color.WHITE);
        etiquetaNomNivelesRestantes.setOpaque(true);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaNomNivelesRestantes 
        //EN EL CONTENEDOR JPanel panelInformativo2 
        panelInformativo2.add(etiquetaNomNivelesRestantes);
        //DECLARACIÓN COMPONENTE JLabel etiquetaValNivelesRestantes
        etiquetaValNivelesRestantes=new JLabel();
        etiquetaValNivelesRestantes.setText("000");
        etiquetaValNivelesRestantes.setForeground(Color.RED);
        etiquetaValNivelesRestantes.setBorder(borde1);
        etiquetaValNivelesRestantes.setBackground(Color.WHITE);
        etiquetaValNivelesRestantes.setOpaque(true);
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaValNivelesRestantes
        etiquetaValNivelesRestantes.setFont(tipografia1);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaValNivelesRestantes 
        //EN EL CONTENEDOR JPanel panelInformativo2 
        panelInformativo2.add(etiquetaValNivelesRestantes);

        ////////////////////////////////////////////////////////////////////////
        //COMPONENTES JLabel CONTENEDOR JPanel panelInformativo3
        ////////////////////////////////////////////////////////////////////////
        //DECLARACIÓN COMPONENTE JLabel etiquetaNomNivelActual
        JLabel etiquetaNomNivelActual=new JLabel("NIVEL ACTUAL       ");
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaNomNivelActual
        etiquetaNomNivelActual.setFont(tipografia1);
        etiquetaNomNivelActual.setBorder(borde1);
        etiquetaNomNivelActual.setBackground(Color.WHITE);
        etiquetaNomNivelActual.setOpaque(true);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaNomNivelActual 
        //EN EL CONTENEDOR JPanel panelInformativo3 
        panelInformativo3.add(etiquetaNomNivelActual);
        //DECLARACIÓN COMPONENTE JLabel etiquetaValNivelActual
        etiquetaValNivelActual=new JLabel();
        etiquetaValNivelActual.setText("000");
        etiquetaValNivelActual.setForeground(Color.RED);
        etiquetaValNivelActual.setBorder(borde1);
        etiquetaValNivelActual.setBackground(Color.WHITE);
        etiquetaValNivelActual.setOpaque(true);
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaValNivelActual
        etiquetaValNivelActual.setFont(tipografia1);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaValNivelActual 
        //EN EL CONTENEDOR JPanel panelInformativo3 
        panelInformativo3.add(etiquetaValNivelActual);

        ////////////////////////////////////////////////////////////////////////
        //COMPONENTES JLabel CONTENEDOR JPanel panelInformativo4
        ////////////////////////////////////////////////////////////////////////
        //DECLARACIÓN COMPONENTE JLabel etiquetaNombrePuntuacion
        JLabel etiquetaNombrePuntuacion=new JLabel("PUNTUACIÓN               ");
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaNombrePuntuacion
        etiquetaNombrePuntuacion.setFont(tipografia1);
        etiquetaNombrePuntuacion.setBorder(borde1);
        etiquetaNombrePuntuacion.setBackground(Color.WHITE);
        etiquetaNombrePuntuacion.setOpaque(true);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaNombrePuntuacion 
        //EN EL CONTENEDOR JPanel panelInformativo4
        panelInformativo4.add (etiquetaNombrePuntuacion);
        
        //DECLARACIÓN COMPONENTE JLabel etiquetaValPuntuacion
        etiquetaValPuntuacion=new JLabel();
        //ASIGNACIÓN TIPOGRAFÍA tipografia1 A LA COMPONENTE JLabel etiquetaValPuntuacion
        etiquetaValPuntuacion.setFont(tipografia1);
        etiquetaValPuntuacion.setText("000");
        etiquetaValPuntuacion.setForeground(Color.RED);
        etiquetaValPuntuacion.setBorder(borde1);
        etiquetaValPuntuacion.setBackground(Color.WHITE);
        etiquetaValPuntuacion.setOpaque(true);
        //INTRODUCCIÓN COMPONENTE JLabel etiquetaValPuntuacion 
        //EN EL CONTENEDOR JPanel panelInformativo4
        panelInformativo4.add (etiquetaValPuntuacion);   
        

        
////////////////////////////////////////////////////////////////////////////////
//////////                                                                    //
//////////            CONTENEDOR JPanel panelVisualizacion                    //
//////////////////////////////////////////////////////////////////////////////// 
        //DECLARACIÓN CONTENEDOR JPanel panelVisualizacion
        panelVisualizacion=new JPanel();
        //ASIGNACIÓN ADMINISTRADOR DE LAYOUT CardLayout
        panelVisualizacion.setLayout(new CardLayout());      
        
        ////////////////////////////////////////////////////////////////////////
        //                                                                    //
        //                  CONTENEDOR JPanel panelStandby                    //
        ////////////////////////////////////////////////////////////////////////  
        //DECLARACIÓN CONTENEDOR JPanel panelStandby
        panelStandby=new JPanel();
        //ASIGNACIÓN ADMINISTRADOR DE LAYOUT BorderLayout
        panelStandby.setLayout(new BorderLayout());
        
        //DECLARACIÓN COMPONENTE JLabel imagenUIB 
        JLabel imagenUIB=new JLabel(new ImageIcon("UIB.gif")); 
        //INTRODUCCIÓN COMPONENTE JLabel imagenUIB EN EL CONTENEDOR JPanel panelStandby
        //EN LA ZONA CENTRAL DEL ADMINISTRADOR BorderLayout
        panelStandby.add(imagenUIB,BorderLayout.CENTER);    
        
        //INTRODUCCIÓN CONTENEDOR JPanel panelStandby EN EL CONTENEDOR
        //panelFuncionalidades A TRAVÉS DEL ADMINISTRADOR DE LAYOUT
        //CardLayout UTILIZANDO EL STRING "STANDBY"
        panelVisualizacion.add(panelStandby,"STANDBY");  
        
////////////////////////////////////////////////////////////////////////////////
//////////                                                                    //
//////////                SEPARADORES JSplitPane DE LA INTERFACE              //
////////////////////////////////////////////////////////////////////////////////  
        //DECLARACIÓN SEPARADORES JSplitPane DE LA INTERFACE

        JSplitPane separador2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separador3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
 
        ////////////////////////////////////////////////////////////////////////
        //   DISTRIBUCIÓN SEPARADORES, CONTENEDORES Y COMPONENTES SEGÚN EL    //
        //   DISEÑO DE LA INTERFACE                                           //
        //////////////////////////////////////////////////////////////////////// 
        //INCLUSIÓN DEL CONTENEDOR JPanel panelSuperior EN EL SEPARADOR separador1 
        separador2.setTopComponent(panelSuperior);
        
        //INCLUSIÓN DEL SEPARADOR separador1 EN LA ZONA NORTE DEL ADMINISTRADOR 
        //DE LAYOUT BorderLayout ASIGNADO AL PANEL DE CONTENIDOS DEL JFrame
        panelContenidos.add(separador2, BorderLayout.NORTH);       
        
        //INCLUSIÓN DEL CONTENEDOR JPanel panelVisualizacion EN LA ZONA  
        //CENTRAL  DEL ADMINISTRADOR 
        //DE LAYOUT BorderLayout ASIGNADO AL PANEL DE CONTENIDOS DEL JFrame
        panelContenidos.add(panelVisualizacion, BorderLayout.CENTER);             
        
        //INCLUSIÓN DEL CONTENEDOR JPanel panelBotones EN EL SEPARADOR separador3
        separador3.setBottomComponent(panelBotones);      

        //INCLUSIÓN DEL SEPARADOR separador3 EN LA ZONA SUR  DEL ADMINISTRADOR 
        //DE LAYOUT BorderLayout ASIGNADO AL PANEL DE CONTENIDOS DEL JFrame
        panelContenidos.add(separador3, BorderLayout.SOUTH);   

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.pack();
        //CENTRADO DEL CONTENEDOR JFrame ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
/////////////////// FIN MÉTODO creacionContenedoresYComponentes ////////////////
    


////////////////////////////////////////////////////////////////////////////////
//                            MANIPULADORES DE EVENTOS                        //
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
////////    MANIPULADOR DE EVENTOS manipuladorEventosFuncionalidades   /////////
    private class manipuladorEventosFuncionalidades implements ActionListener {
        Color color;
        @Override
        public void actionPerformed(ActionEvent evento)  { 
            CardLayout panel = (CardLayout)(panelVisualizacion.getLayout());
            switch (evento.getActionCommand()) {
                case "NUEVA PARTIDA"           :    if (!refrescarPanelJuego) {
                                                        if (nuevaPartida()) {
                                                            nivel=2;
                                                            puntos=0;
                                                            juegosJugados=1;
                                                            jugar();
                                                            refrescarPanelJuego=true;
                                                            panel.show(panelVisualizacion, "NIVEL");                                                            
                                                        }
                                                    }
                                                    else {
                                                        JOptionPane.showMessageDialog(ventana, //contenedor padre
                                                          "¡¡¡ NO SE PUEDE INICIAR UNA PARTIDA HABIENDO\n"+
                                                          "           UNA PARTIDA EN CURSO  !!!"//texto visualizado
                                                          ); 
                                                    }
                                                    break;                           
                case "SALIR"                    :   System.exit(0);
            } 

    }}; 


////////////////////////////////////////////////////////////////////////////////
////////   CLASE MANIPULADOR DE EVENTOS manipuladorEventosPanelJuego   /////////
    private class manipuladorEventosPanelJuego implements MouseListener {
            @Override
            public void mousePressed(MouseEvent evento) {
                int cuadroSeleccionado=panelCuadrados.cuadroSeleccionado(evento);
                if (panelCuadrados.esCuadradoDiferente(cuadroSeleccionado)) {
                    panelCuadrados.seleccionaValida(cuadroSeleccionado);
                    puntos=puntos+(nivel);
                }
                else {
                    panelCuadrados.seleccionaErronea(cuadroSeleccionado);
                    JOptionPane.showMessageDialog(ventana, //contenedor padre
                          "¡¡¡  CUADRADO SELECCIONADO ERRÓNEO  !!!" //texto visualizado
                          ); 
                }
                if (juegosJugados==numeroJuegos) {
                        refrescarPanelJuego=false;
                        nivel=2;
                        actualizacionInformacionPartida();
                        JOptionPane.showMessageDialog(ventana, //contenedor padre
                          "¡¡¡ LA PARTIDA HA TERMINADO CON UN TOTAL DE "+
                          puntos+" PUNTOS"//texto visualizado
                          ); 
                        CardLayout panel = (CardLayout)(panelVisualizacion.getLayout());
                        panel.show(panelVisualizacion, "STANDBY"); 
                        juegosJugados=0;
                        numeroJuegos=0;
                        puntos=0;
                        actualizacionInformacionPartida();
                } 
                else {
                    juegosJugados++;
                    nivel++;
                    jugar();
                    CardLayout panel = (CardLayout)(panelVisualizacion.getLayout());
                    panel.show(panelVisualizacion, "NIVEL");
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}        
    }
    
    private boolean nuevaPartida() {
        panelJuego=new JPanel();
        //ASIGNACIÓN ADMINISTRADOR DE LAYOUT BorderLayout
        panelJuego.setLayout(new BorderLayout());   
        
        //declaración array de componentes String con los literales de los conceptos a introducir
        String [] datos={"NÚMERO DE NIVELES [1..10] ","COMPLEJIDAD [1..10]             "};
        //asignación a datos los datos introducidos a través del objeto lecturaDatos
        datos=new lecturaDatos(ventana,datos).getDatosTexto();
        if (datos!=null) {
            try {
                numeroJuegos=Integer.parseInt(datos[0]);
                complejidad=Integer.parseInt(datos[1]);                
            } catch (NumberFormatException error) {
                entradaIncorrecta();
                return false;
            }
            if (!((numeroJuegos>=1)&&(numeroJuegos<=10)&&(complejidad>=1)&&(complejidad<=10))) {
                entradaIncorrecta();
                return false;
            }
            return true;
        }
        else {
            entradaIncorrecta();
            return false;
        }
    }
    
    private void jugar() {       
        if (refrescarPanelJuego) {
            panelJuego.remove(panelCuadrados);
        }
        actualizacionInformacionPartida();
        
        panelCuadrados=new TableroCuadrados(DIMENSION_X_VISUALIZACION,DIMENSION_Y_VISUALIZACION,
                complejidad, nivel, new manipuladorEventosPanelJuego());
        panelJuego.add(panelCuadrados,BorderLayout.CENTER);

        panelVisualizacion.add(panelJuego,"NIVEL");        
    }
    
    private void actualizacionInformacionPartida() { 
        String [] ajustes={"","0","00","000"};
        etiquetaValNivelesPartida.setText(ajustes[3-String.valueOf(numeroJuegos).length()]+
                                                String.valueOf(numeroJuegos));
        etiquetaValNivelActual.setText(ajustes[3-String.valueOf(juegosJugados).length()]+
                                                String.valueOf(juegosJugados));
        etiquetaValNivelesRestantes.setText(ajustes[3-String.valueOf(numeroJuegos-juegosJugados).length()]+
                                                String.valueOf(numeroJuegos-juegosJugados));
        etiquetaValPuntuacion.setText(ajustes[3-String.valueOf(puntos).length()]+
                                                String.valueOf(puntos));
    }
    
    private void entradaIncorrecta() {
        JOptionPane.showMessageDialog(ventana, //contenedor padre
                                  "¡¡¡ NO HAS INTRODUCIDO LOS DATOS CORRECTAMENTE\n"+
                                  "    PARA INICIAR UNA PARTIDA !!!"//texto visualizado
                                  );         
    }

}
