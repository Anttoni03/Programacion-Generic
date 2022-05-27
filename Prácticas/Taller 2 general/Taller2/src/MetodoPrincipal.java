
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/*
El menú funciona
Cuando se introduce un valor válido para empezar partida, peta.
He puesto un system out print para verificar si se generan bien los botones y no se que falla
Creo que no está bien hecho lo que es pasar el JPaner de la clase Partida al metodoPrincipal (
no se que más hacer
*/
public class MetodoPrincipal {
    
        private int niveles;
        private int complejidad;
        private JFrame ventanaPartida=new JFrame("informacion");
        private JTextField textoNiveles=new JTextField();
        private JTextField textoComplejidad=new JTextField();
        private boolean partidaEnJuego=false;
        private JPanel panelVisualizacion,panelJuego;
        private Partida partida;
    
    public static void main(String[] args) throws IOException {
        new MetodoPrincipal().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws IOException{
        
        
        //declaración ventana
        JFrame ventana;
        
        ventana = new JFrame("KUKU KUBE");   
    
        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();
        //layout para el panel de contenidos
        panelContenidos.setLayout(new BorderLayout());   
        
        //declaración paneles JPanel
        JPanel panelInterfaces,panelStandby,panelSuperior,panelInformacion,panelInformativo1, panelInformativo2, 
        panelInformativo3, panelInformativo4,panelBotones;
        //inicialización panelVisualizador
        panelVisualizacion=new JPanel();
        
        
        //GESTOR DE EVENTOS
        
        ActionListener gestorEventos=new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent evento){
                    switch(evento.getActionCommand()){
                        case "SALIR":   System.exit(0);break;
                        case "NUEVA PARTIDA":   ventanaPartida.setVisible(true);break;
                        case "CANCELAR":        ventanaPartida.setVisible(false);break;
                        case "EMPEZAR":             try{  niveles=Integer.parseInt(textoNiveles.getText());
                                                    complejidad=Integer.parseInt(textoComplejidad.getText()); }catch(NumberFormatException e){}
                                                    System.out.println(complejidad+"  "+niveles);
                                                    if(verificacion()==true){
                                                        partida=new Partida(niveles,complejidad);
                                                        partida.jugarPartida(ventana);
                                                        ventanaPartida.setVisible(false);;break;
                                                   }else{
                                                    JOptionPane panelError=new JOptionPane();
                                                    panelError.showMessageDialog(null, "Datos introducidos incorrectos", "ERROR", 0);
                        
                                                        }
                    }
                }
        };
        
        
        
        
        
        ////////////////////////////////////////////////////////////////
        //                  VENTANA PREPARTIDA                        //
        ////////////////////////////////////////////////////////////////           
        
        try{
        Container containerNuevaPartida=ventanaPartida.getContentPane();
        
        //panel JPanel para poner las etiquetas y los text fields
        JPanel panelPrepartida = new JPanel();
        containerNuevaPartida.setLayout(new BorderLayout());
        containerNuevaPartida.add(panelPrepartida,BorderLayout.CENTER);
        panelPrepartida.setLayout(new GridLayout(4,1));
        //panel botones para meter los botones de empezar y cancelar
        JPanel botonesPartida=new JPanel();
        botonesPartida.setLayout(new GridLayout(1,2,5,5));
        containerNuevaPartida.add(botonesPartida,BorderLayout.SOUTH);
        
        //inicialización textFields para que el usuario introduzca la información sobre la dificultad

        //inicialización booleano para verificar si los numeros introducidos son válidos
        boolean verificacion=true;
        //inicialización ints para almacenar los numeros introducidos

        
        //inicialización botones de empezar y cancelar
        JButton botonEmpezar=new JButton("EMPEZAR");
        JButton botonCancelar=new JButton("CANCELAR");
        //añadir botones al gestor de eventos
        botonEmpezar.addActionListener(gestorEventos);
        botonCancelar.addActionListener(gestorEventos);
        botonEmpezar.addActionListener(new manipuladorEventosFuncionalidades());
        botonCancelar.addActionListener(new manipuladorEventosFuncionalidades());
        //introducción de los componentes dentro del JPanel panelPrepartida de la ventana
        panelPrepartida.add(new JLabel("SELECCIONE EL NIVEL DE COMPLEJIDAD ENTRE 1 Y 10",JLabel.LEFT));
        panelPrepartida.add(textoComplejidad);
        panelPrepartida.add(new JLabel("SELECCIONE LA CANTIDAD DE NIVELES A JUGAR ENTRE 1 Y 10",JLabel.LEFT));
        panelPrepartida.add(textoNiveles);
        
        //introducción de los componentes dentro del JPanel botonesPartida de la ventana
        botonesPartida.add(botonCancelar);
        botonesPartida.add(botonEmpezar);
    
        }catch(NumberFormatException e){}

        
        //retoques de la ventana
        ventanaPartida.pack();
        ventanaPartida.setLocationRelativeTo(null);
        
        
        
        
        
        ////////////////////////////////////////////////////////////////
        //                  GESTOR DE EVENTOS                         //
        ////////////////////////////////////////////////////////////////  
        
        
        
        
        
        ////////////////////////////////////////////////////////////////
        //                    PANEL BOTONES                           //
        ////////////////////////////////////////////////////////////////
        
        //inicializaión panel botones
        panelBotones=new JPanel();
        //layput panel botones
        panelBotones.setLayout(new GridLayout(1,2));
        //DECLARACIón botones del panel botones
        JButton botonSalir=new JButton("SALIR");
        JButton botonPartida=new JButton ("NUEVA PARTIDA");
        
        //fondo negro
        botonSalir.setBackground(Color.black);
        botonPartida.setBackground(Color.black);
        //letras blancas
        botonSalir.setForeground(Color.white);
        botonPartida.setForeground(Color.white);
        //añadir los botones al panelBotones
        panelBotones.add(botonPartida);
        panelBotones.add(botonSalir);
        //añadir botones al gestor de eventos
        botonPartida.addActionListener(gestorEventos);
        botonSalir.addActionListener(gestorEventos);
        
        panelContenidos.add(panelBotones,BorderLayout.SOUTH);
        
        
        
        
        
        ////////////////////////////////////////////////////////////////
        //                    PANEL SUPERIOR                          //
        ////////////////////////////////////////////////////////////////
        
        //inicialización panel superior
        panelSuperior=new JPanel();
        //layout
        panelSuperior.setLayout(new BorderLayout());
        
        ////////////////////////////////////////////////////////////////
        //                  PANEL INFORMACION                         //
        ////////////////////////////////////////////////////////////////
        
        //inicialización Panel Información
        panelInformacion=new JPanel();
        //color de fondo del panel a negro
        panelInformacion.setBackground(Color.BLACK);
        //layout del panel informacion
        panelInformacion.setLayout(new GridLayout (2,3,5,5));
        
        //inicializacion paneles informativos
        panelInformativo1=new JPanel();
        panelInformativo2=new JPanel();
        panelInformativo3=new JPanel();
        panelInformativo4=new JPanel();
        //layouts de paneles
        panelInformativo1.setLayout(new BorderLayout());
        panelInformativo2.setLayout(new BorderLayout());
        panelInformativo3.setLayout(new BorderLayout());
        panelInformativo4.setLayout(new BorderLayout());
        
        //PANEL 1
        //declaración etiquetas del panel 1
        JLabel etiquetaNomNivelesPartida=new JLabel("NIVELES PARTIDA");
        JLabel etiquetaValNivelesPartida=new JLabel("0",JLabel.RIGHT);
        etiquetaValNivelesPartida.setForeground(Color.RED);
        etiquetaValNivelesPartida.setPreferredSize(new Dimension(20,20));
        panelInformativo1.add(etiquetaNomNivelesPartida,BorderLayout.CENTER);
        panelInformativo1.add(etiquetaValNivelesPartida,BorderLayout.EAST);
        
        //PANEL 2
        //declaración etiquetas del panel 2
        JLabel etiquetaNomNivelesRestantes=new JLabel("NIVELES RESTANTES");
        etiquetaNomNivelesRestantes.setPreferredSize(new Dimension(200,20));
        JLabel etiquetaValNivelesRestantes=new JLabel("0",JLabel.RIGHT);
        etiquetaValNivelesRestantes.setPreferredSize(new Dimension(20,20));
        etiquetaValNivelesRestantes.setForeground(Color.RED);
        panelInformativo2.add(etiquetaNomNivelesRestantes,BorderLayout.CENTER);
        panelInformativo2.add(etiquetaValNivelesRestantes,BorderLayout.EAST);

        //PANEL 3
        //declaración etiquetas del panel 3
        JLabel etiquetaNomNivelActual=new JLabel("NIVEL ACTUAL");
        JLabel etiquetaValNivelActual=new JLabel("0",JLabel.RIGHT);
        etiquetaValNivelActual.setPreferredSize(new Dimension(20,20));
        etiquetaValNivelActual.setForeground(Color.RED);
        panelInformativo3.add(etiquetaNomNivelActual,BorderLayout.CENTER);
        panelInformativo3.add(etiquetaValNivelActual,BorderLayout.EAST);

        //PANEL 4
        //declaración etiquetas del panel 4
        JLabel etiquetaNombrePuntuacion=new JLabel("PUNTUACIÓN");
        JLabel etiquetaValPuntuacion=new JLabel("0",JLabel.RIGHT);
        etiquetaValPuntuacion.setPreferredSize(new Dimension(20,20));
        etiquetaValPuntuacion.setForeground(Color.RED);
        panelInformativo4.add(etiquetaNombrePuntuacion,BorderLayout.CENTER);
        panelInformativo4.add(etiquetaValPuntuacion,BorderLayout.EAST);        
        
        JPanel vacio1=new JPanel();
        JPanel vacio2=new JPanel();
        vacio1.setBackground(Color.BLACK);
        vacio2.setBackground(Color.BLACK);
        
        
        
        
        //añadir paneles por orden
        panelInformacion.add(panelInformativo1);
        panelInformacion.add(vacio1);
        panelInformacion.add(panelInformativo2);
        panelInformacion.add(panelInformativo3);
        panelInformacion.add(vacio2);
        panelInformacion.add(panelInformativo4);
        
        
        ////////////////////////////////////////////////////////////////
        //                       PANEL MENÚ                           //
        ////////////////////////////////////////////////////////////////
        
        //inicializacion menuBar bar
        JMenuBar menuBar=new JMenuBar();
        //layout
        panelSuperior.add(menuBar,BorderLayout.NORTH);
        //iniialización menuBar
        JMenu menu=new JMenu("MENU");
        
        //inicialización menu items
        JMenuItem itemPartida=new JMenuItem("NUEVA PARTIDA");
        JMenuItem itemSalir=new JMenuItem("SALIR");
        //añadir items al menu
        menu.add(itemPartida);
        menu.add(itemSalir);
        //gestion de eventos
        itemPartida.addActionListener(gestorEventos);
        itemSalir.addActionListener(gestorEventos);
        //añadir menu a la menu bar
        menuBar.add(menu);
        //añadir menubar y panel informacion al panel superior
        
        panelSuperior.add(panelInformacion,BorderLayout.CENTER);
        
        //añadir panelSuperior al panel de contenidos
        panelContenidos.add(panelSuperior,BorderLayout.NORTH);
        
        ////////////////////////////////////////////////////////////////
        //                  PANEL VISUALIZACIÓN                       //
        ////////////////////////////////////////////////////////////////
        
        //inicialización panel visualización
        panelVisualizacion=new JPanel();
        panelVisualizacion.setLayout(new CardLayout());
        panelContenidos.add(panelVisualizacion,BorderLayout.CENTER);
        
        
        
        
        
        
        
        ////////////////////////////////////////////////////////////////
        //                     PANEL STANDBY                          //
        ////////////////////////////////////////////////////////////////
        
        //inicialización Panel StandBy
        panelStandby=new JPanel();
        //layout
        panelStandby.setLayout(new FlowLayout());
        //inicialización JLabel para almacenar el gif
        
        //asignar el gif a la etiqueta
        ImageIcon uibGif = new ImageIcon("uib.gif");
        Image tamañoGif=uibGif.getImage();
        tamañoGif=tamañoGif.getScaledInstance(uibGif.getIconWidth()*2/3, uibGif.getIconHeight()*2/3, 0);
        uibGif.setImage(tamañoGif);
        JLabel uib=new JLabel(uibGif);
        panelStandby.add(uib);
        //añadir el gif al panel standby
        
        //añadir el panel standby al panel visualizador
        panelVisualizacion.add(panelStandby, "PANEL STANDBY");
        
        ////////////////////////////////////////////////////////////////
        //                     PANEL JUEGO                            //
        ////////////////////////////////////////////////////////////////        
        
        //inicialización panel juego
        panelJuego=new JPanel();
        panelVisualizacion.add(panelJuego,"PANEL JUEGO");
        
        

    
    
        
        
        
        
        
        
        ventana.setSize(550,670);
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
        
    }
    
    //método que verifica si los datos de la partida son correctos
    public boolean verificacion(){
        boolean dato=false;
        if((((niveles<11)&&(niveles>0))&&((complejidad<11)&&(complejidad>0)))){
        dato=true;
        }
        return dato;
    }    
    
    private class manipuladorEventosFuncionalidades implements ActionListener {
        Color color;
        @Override
        public void actionPerformed(ActionEvent evento)  { 
                CardLayout local = (CardLayout)(panelVisualizacion.getLayout());
                switch (evento.getActionCommand()) {
                    case "EMPEZAR":     //visualización en el panelInterfaces del
                                            //contenedor asociado al literal "PANEL JUEGO"
                                            local.show(panelVisualizacion, "PANEL JUEGO");
                                            break;
                    case "INTERFACE 2":     //visualización en el panelInterfaces del
                                            //contenedor asociado al literal "INTERFACE 2"
                                            local.show(panelVisualizacion, "PANEL STANDBY");
                                            break;
                    
                }
        }
}
    

    
}


//class panelDibujo extends JPanel {
//    @Override
//    public void paintComponent(Graphics g) {
//       Graphics2D g2=(Graphics2D)g;
//       g2.setColor(Color.RED);
//       
//    }
//}