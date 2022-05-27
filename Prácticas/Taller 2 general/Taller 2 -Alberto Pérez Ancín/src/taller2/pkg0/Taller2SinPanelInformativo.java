package taller2.pkg0;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alberto Pérez Ancín
 */
public class Taller2SinPanelInformativo extends JFrame {

    //DECLARACIONES
    //declaración del panel de contenidos
    private final Container panelContenidos;
    private JPanel panelVisualizacion;

    //MÉTODO MAIN
    public static void main(String[] args) {
        //CONTROL DE LA APARENCIA
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException | UnsupportedLookAndFeelException 
                error) {
            System.out.print(error.toString());
        }
        new Taller2SinPanelInformativo();
    }

    //CONTRUCTOR
    public Taller2SinPanelInformativo() {
        //instanciamos el panel 
        panelVisualizacion=new JPanel();
        //asignación administradores layout CardLayout al panel
        //de visualización
        panelVisualizacion.setLayout(new CardLayout());
        //título del contenedor
        //(la clase tiene extens JFrame!)
        setTitle("TALLER 2 PROG");
        //activación del cierre de ejecución 
        setDefaultCloseOperation(Taller2SinPanelInformativo.EXIT_ON_CLOSE);
        //redimensionamiento de la ventana
        setSize(600, 650);

        //asignamos el panel de contenidos del JFrame
        panelContenidos = getContentPane();
        //asignamos al panel de contenidos el 
        //administrador BorderLAyout
        panelContenidos.setLayout(new BorderLayout());
        //añadimos la imagen a visualizar en el centro
        Areavisualizacion panel = new Areavisualizacion("uib.gif");
        //añadimos el panelMenu al panelVisualización
        panelVisualizacion.add(panel, "PANEL MENU");
        //añadimos la imagen al panel de contenidos
        panelContenidos.add(panelVisualizacion, BorderLayout.CENTER);
        //declaración y definición de las otras componentes
        creacionInterface();
    }

    //método creación interface donde llevaremos a cabo la
    //creación de la interface
    private void creacionInterface() {
////////////////////////////////////////////////////////////////////////////////
//                   CONTENEDOR JPanel                                        //
////////////////////////////////////////////////////////////////////////////////
        //CREACIÓN DEL PANEL DE BOTONES
        JPanel panelBotones = new JPanel();
        //asignación al contenedor el layout correspondiente
        panelBotones.setLayout(new GridLayout(1, 2));

        ///COMPONENTES JButton
        //componente NUEVA_PARTIDA
        JButton nuevaPartida = new JButton("NUEVA PARTIDA");
        //asignación del color de las letras
        nuevaPartida.setForeground(Color.WHITE);
        //asignacioón del color de fondo
        nuevaPartida.setBackground(Color.BLACK);
        //obtenemos el manipulador de evento asociado
        //con el boton
        nuevaPartida.addActionListener(new manipuladorEventos());
        //añadimos el boton al panel 
        panelBotones.add(nuevaPartida);

        //componente SALIR
        JButton salir = new JButton("SALIR");
        //asignación del color de las letras
        salir.setForeground(Color.WHITE);
        //asignación del color de fondo
        salir.setBackground(Color.BLACK);
        //obtener el manipulador de evento asociado
        salir.addActionListener(new manipuladorEventos());
        //añadimos el botón al panel
        panelBotones.add(salir);

        //DECLARACIÓN SEPARADORES JSplitPane DE LA INTERFACE
        JSplitPane separadorSur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        //INCLUSIÓN DEL CONTENEDOR JPanel panelVarios EN EL SEPARADOR 
        // separadorSur 
        separadorSur.setBottomComponent(panelBotones);
        //AÑADIMOS EL PANEL DE BOTONES AL PANEL DE CONTENIDOS
        panelContenidos.add(separadorSur, BorderLayout.SOUTH);
////////////////////////////////////////////////////////////////////////////////
//                   CONTENEDOR JMenuBar                                      //
////////////////////////////////////////////////////////////////////////////////

        //CREACIÓN DE LA BARRA DEL MENÚ
        JMenuBar barraMenu = new JMenuBar();
        //declaración de la componente menú
        JMenu menu = new JMenu("MENU");

        //DECLARACIÓN DE LAS COMPONENTES DEL MENÚ//
        JMenuItem menuPartida = new JMenuItem("NUEVA PARTIDA");
        //le añadimos el gestor de eventos
        menuPartida.addActionListener(new manipuladorEventos());
        //declaración de la otra componente
        JMenuItem menuSalir = new JMenuItem("SALIR");
        //le añadimos el gestor de eventos
        menuSalir.addActionListener(new manipuladorEventos());

        //añadimos estos dos ítems al menú
        menu.add(menuPartida);
        menu.add(menuSalir);

        //añadimos el menú a la barra del menú
        barraMenu.add(menu);

        //AÑADIMOS AL PANEL DE CONTENIDOS LA BARRA DEL MENÚ
        panelContenidos.add(barraMenu, BorderLayout.NORTH);

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
//////////////////////////////////////////////////////////////////////////////// 
        setVisible(true);

                //DECLARACIÓNES
        //declaración del panel de juego 
        JPanel panelJuego=new JPanel();
        //declaración del Layout de la interface
        int fila=2;
        int columna=2;
        JButton boton=new JButton();
        boton.setBackground(Color.cyan);
        boton.setText("No me ha dado tiempo a juntarlo(El juego esta en el main"
                + " de Cuadrado)");
        panelJuego.add(boton);
        
        panelJuego.setLayout(new GridLayout(fila,columna,2,2));
        //añadimos el panel de juego al panel de visualización 
        panelVisualizacion.add(panelJuego, "PANEL DE JUEGO");
    }
    
////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                      CLASE AreaVisualizacion                               //
//                                                                            //
//////////////////////////////////////////////////////////////////////////////// 
    public class Areavisualizacion extends JPanel {

        //declaración de la imagen
        private final Image imagen;

        public Areavisualizacion(String nombre) {
            //atribuimos a la imagen la imagen a visualizar
            imagen = Toolkit.getDefaultToolkit().getImage(nombre);

        }

        @Override
        public void paintComponent(Graphics graf) {
            Graphics2D g2d = (Graphics2D) graf;
            g2d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

////////////////////////////////////////////////////////////////////////////////
//                              GESTOR DE EVENTOS                             //
////////////////////////////////////////////////////////////////////////////////
////////MANIPULADOR DE EVENTOS gestorEventos
    private class manipuladorEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            CardLayout local = (CardLayout)(panelVisualizacion.getLayout());
            switch (evento.getActionCommand()) {

                case "NUEVA PARTIDA":
                    local.show(panelVisualizacion,"PANEL DE JUEGO");
                    break;

                case "SALIR":
                    System.exit(0);
                    break;
            }
        }
    }

}
