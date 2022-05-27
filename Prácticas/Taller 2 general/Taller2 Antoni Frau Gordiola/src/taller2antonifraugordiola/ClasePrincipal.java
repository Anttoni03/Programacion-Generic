/*
 * Clase principal con método main desde el que funciona y gestiona el programa
 */
package taller2antonifraugordiola;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClasePrincipal {

    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que representa la ventana gráfica principal
    private JFrame ventana;
    //Atributo de objeto que representa el panel de visualización central
    private JPanel panelVisualizacion;
    //Atributo de objeto que representa el panel o tablero de cuadrados de juego
    private PanelJuego panelJuego;
    //Atributo de objeto que indica los paneles informativos durante el juego
    private PanelInformativo[] panelesInfo;
    
    //Atributo de objeto constante que indica la dimensión de la ventana
    private final int ANCHO = 580, ALTO = 740;
    //Atributos de objeto que guardan los niveles a jugar y puntuación obtenida
    private int niveles, puntuacion;
    //Atributo de objeto que indica si hay o no una partida en curso
    private boolean enPartida = false;
    //Atributo de objeto constante que guarda las acciones del programa
    private final String[] ACCIONES = {"NUEVA PARTIDA", "SALIR"};
    //Atributo de objeto constante que guarda los campos informativos del juego
    private final String[] INFORMACION = {"NIVELES PARTIDA", "NIVELES RESTANTES",
        "NIVEL ACTUAL", "PUNTUACIÓN"};
    
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método main para ejecutar el programa
    public static void main(String[] args)
    {
        new ClasePrincipal().metodoPrincipal();
    }
    
    //Método metodoPrincipal que gestiona el control principal del programa
    private void metodoPrincipal()
    {
        //inicializaciones de la ventana principal y su contenido Container
        ventana = new JFrame("VISUALIZACIÓN IMAGEN");
        Container panelContenidos = ventana.getContentPane();
        //inicialización de los 3 divisores principales del programa
        JSplitPane[] divisores = new JSplitPane[3];
        
        //aplicar un BorderLayout al contenido de la ventana y meter dentro de
        //esta los divisores en separación vertical
        panelContenidos.setLayout(new BorderLayout());
        for (int i = 0; i < divisores.length; i++)
        {
            divisores[i] = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
            divisores[i].setEnabled(false);
        }
        
        
        
        
        
        
        
        //inicializaciones de la barra de menú y sus contenidos
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("MENÚ");
        JMenuItem[] itemsAcciones = new JMenuItem[ACCIONES.length];
        
        //instanciar las opciones del menú y añadirlas a este
        for (int i = 0; i < itemsAcciones.length; i++)
        {
            itemsAcciones[i] = new JMenuItem(ACCIONES[i]);
            //asignar gestores de acciones de acciones a las opciones del menú
            itemsAcciones[i].addActionListener(new GestorAcciones());
            menu.add(itemsAcciones[i]);
        }

        
        
        
        
        
        //instanciación del panel superior del programa
        JPanel panelSuperior = new JPanel();
        //aplicarle un tamaño indicado al panel superior
        panelSuperior.setPreferredSize(new Dimension(ANCHO,100));
        
        
        
        
        
        
        //instanciaciones del panel de datos informativos y de los datos
        JPanel panelInformacion = new JPanel();
        panelesInfo = new PanelInformativo[INFORMACION.length];
        
        //aplicar un tamaño al panel de datos, color de fondo negro y GridLayout
        panelInformacion.setPreferredSize(new Dimension(ANCHO-10,60));
        panelInformacion.setBackground(Color.BLACK);
        panelInformacion.setLayout(new GridLayout(2,2,130,0));
        
        //iniciar los datos informativos y añadirlos al panel de datos
        for (int i = 0; i < panelesInfo.length; i++)
        {
            panelesInfo[i] = new PanelInformativo(INFORMACION[i]);
            panelInformacion.add(panelesInfo[i]);
        }
        
        
        
        
        
        
        //instanciaciones del panel de visualización y el panel stanby inicial
        Dimension dimVisualizacion = new Dimension(ANCHO, ANCHO-20);
        panelVisualizacion = new JPanel();
        PanelStandby panelStandby = new PanelStandby("uib.gif", dimVisualizacion);
        
        //aplicar un tamaño indicado al panel de visualización y un CardLayout
        panelVisualizacion.setPreferredSize(dimVisualizacion);
        panelVisualizacion.setLayout(new CardLayout());
        
        //añadir el panel inicial y reiniciar el panel de juego, siendo ocultado
        panelVisualizacion.add(panelStandby, "Panel standby");
        reiniciarPanelJuego();
        
        
        
        
        
        
        //instanciación del panel de botones y los propios botones del programa
        JPanel panelBotones = new JPanel();
        JButton[] botones = new JButton[ACCIONES.length];
        
        //aplicar un GridLayout al panel de los botones
        panelBotones.setLayout(new GridLayout(1,2));
        //iniciar los botones y ponerlos en el panel de botones
        for (int i = 0; i < botones.length; i++)
        {
            botones[i] = new JButton(ACCIONES[i]);
            //aplicar los colores corresponidentes a los botones
            botones[i].setBackground(Color.BLACK);
            botones[i].setForeground(Color.WHITE);
            //aplicar gestores de acciones del programa a los botones
            botones[i].addActionListener(new GestorAcciones());
            
            panelBotones.add(botones[i]);
        }
        
        
        
        //adiciones correspondientes de los elementos a otros
        //adición del menú con sus opciones a la barra de menú
        barraMenu.add(menu);
        //adiciones de los elementos dentro de sus divisores correspondientes
        divisores[0].add(barraMenu);
        divisores[0].add(panelInformacion);
        divisores[1].add(panelSuperior);
        divisores[2].add(panelVisualizacion);
        divisores[2].add(panelBotones);
        //adición del divisor superior al panel superior
        panelSuperior.add(divisores[0]);
        //adiciones principales sobre los divisores al contenido de la ventana
        panelContenidos.add(divisores[1], BorderLayout.NORTH);
        panelContenidos.add(divisores[2], BorderLayout.SOUTH);
        
        
        //indicar que el programa finalizará cuando se cierre la ventana gráfica
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aplicar una dimensión indicada a la ventana gráfica
        ventana.setSize(ANCHO, ALTO);
        //establecer en el centro de la pantalla la ventana gráfica
        ventana.setLocationRelativeTo(null);
        //incapacitar la redimensión de la ventana gráfica manualmente
        ventana.setResizable(false);
        //activar la visualización de la ventana gráfica principal
        ventana.setVisible(true);
    }
    
    //Método reiniciarPanelJuego que gestiona el reinicio del panel de juego
    private void reiniciarPanelJuego()
    {
        //nuevo panelJuego indicando el gestor de eventos para los cuadrados
        panelJuego = new PanelJuego(new GestorCuadrado());
        //aplicar un tamaño inicial indicado al panel de juego
        panelJuego.setPreferredSize(new Dimension(ANCHO, ANCHO-40));
        //añadir el nuevo panel de juego al panel visualizador central
        panelVisualizacion.add(panelJuego, "Panel juego");
    }
    
    //Método nuevaPartida que gestiona lo relacionado a iniciar una partida
    private void nuevaPartida()
    {
        //indicar que hay una partida en curso
        enPartida = true;
        //reiniciar el panel de juego y la puntuación de la partida
        reiniciarPanelJuego();
        puntuacion = 0;
        //inicializar una cantidad de niveles y complejidad a jugar temporal
        int nivelesTemp = 0,complejidadTemp = 0, accion = -1;
        
        //bucle con el que se darán los datos de la nueva partida
        do{
            //instanciación de elementos del panel para recibir datos de juego
            JPanel emergente = new JPanel();
            JLabel insertaNiveles = new JLabel("Indica la cantidad de niveles[1..10]: "); 
            JTextField textoNiveles = new JTextField();
            JLabel insertaComplejidad = new JLabel("Indica la complejidad de juego[1..10]: "); 
            JTextField textoComplejidad = new JTextField();
            String[] opcion = {"Continuar"};
            
            //aplicar tamaños indicados al panel para recibir datos de juego
            emergente.setPreferredSize(new Dimension(230,100));
            textoNiveles.setPreferredSize(new Dimension(150,20));
            textoComplejidad.setPreferredSize(new Dimension(150,20));
            
            //añadir todos los elementos creados al panel de recibir datos
            emergente.add(insertaNiveles);
            emergente.add(textoNiveles);
            emergente.add(insertaComplejidad);
            emergente.add(textoComplejidad);

            //mostrar el panel de datos de juego como un mensaje de opción
            accion = JOptionPane.showOptionDialog(ventana,
                    emergente,
                    "Confirmación de datos de la partida",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, opcion, opcion[0]);
            
            //gestión try-catch para recibir los datos insertados en el panel
            try {
                //asignar la cantidad de niveles y complejidad si es posible
                nivelesTemp = Integer.parseInt(textoNiveles.getText());
                complejidadTemp = Integer.parseInt(textoComplejidad.getText());
            } catch (NumberFormatException e) {
                //"reiniciar" los valores de niveles y complejidad si hay error
                nivelesTemp = 0;
                complejidadTemp = 0;
            }
            
        } while ((nivelesTemp < 1 || 10 < nivelesTemp) || 
                (complejidadTemp < 1 || 10 < complejidadTemp) ||
                accion == -1);
        
        //guardar la cantidad de niveles a jugar y complejidad ya validados
        niveles = nivelesTemp;
        panelJuego.setComplejidad(complejidadTemp);
        
        //generar un nuevo panel de juego para la nueva partida
        panelJuego.generarNuevoPanel();
        
        //inicializar los datos informativos de la partida
        panelesInfo[0].setValor(niveles);
        panelesInfo[1].setValor(niveles);
        panelesInfo[2].setValor(1);
        
        //mostrar el panel de juego en lugar del panel standby con CardLayout
        CardLayout clo = (CardLayout) panelVisualizacion.getLayout();
        clo.show(panelVisualizacion, "Panel juego");
    }
    
    //Método finalPartida que gestiona toda la finalización de partidas jugadas
    private void finalPartida()
    {
        //mostrar una ventana emergente indicando que se ha terminado
        JOptionPane.showMessageDialog(ventana
            , "¡¡¡ LA PARTIDA HA TERMINADO CON UN TOTAL DE "
                    + puntuacion + " PUNTOS !!!"
            , "Mensaje"
            , JOptionPane.INFORMATION_MESSAGE
            , null);
        enPartida = false;
        
        //reiniciar los paneles informativos y la imagen de visualizado central
        for (int i = 0; i < panelesInfo.length; i++) panelesInfo[i].setValor(0);
        CardLayout clo = (CardLayout)panelVisualizacion.getLayout();
        clo.show(panelVisualizacion, "Panel standby");
    }
    
    //////////////////////////  CLASES GESTORAS  //////////////////////////
    //Clase que implementa ActionListener y gestiona las acciones principales
    private class GestorAcciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            //encontrar el índice del botón pulsado
            int i = 0;
            while (!event.getActionCommand().equals(ACCIONES[i])) i++;
            
            //switch de elección de acciones según el botón pulsado
            switch (i)
            {
                //caso de botón "nueva partida" pulsado
                case 0:
                    if (!enPartida)
                    {
                        //iniciar nueva partida si no hay partidas en curso
                        nuevaPartida();
                    }
                    else
                    {
                        //indicar que ya hay una partida en curso
                        JOptionPane.showMessageDialog(ventana
                            , "¡¡¡ NO SE PUEDE INICIAR UNA PARTIDA HABIENDO"
                                    + " UNA PARTIDA EN CURSO !!!"
                            , "Mensaje"
                            , JOptionPane.INFORMATION_MESSAGE
                            , null);
                    }
                    break;
                //caso de botón "salir" pulsado
                case 1:
                    //acabar la ejecución del programa
                    System.exit(0);
                    break;
            }
        }
    }
    
    //Clase que implementa ActionListener y gestiona las acciones de una partida
    private class GestorCuadrado implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            //iniciar un cuadrado como el cuadrado pulsado
            Cuadrado cuadrado = (Cuadrado)evento.getSource();
            
            //actualizar la información de cantidad de niveles restantes
            panelesInfo[1].setValor(niveles-panelJuego.getNivelActual());
            
            if (cuadrado.getDiferente())
            {
                //actualizar la puntuación obtenida
                puntuacion += panelJuego.getNivelActual()+1;
                panelesInfo[3].setValor(puntuacion);
            }
            else
            {
                //indicar que el cuadrado pulsado es fallido y ver el correcto
                panelJuego.indicarFallo(cuadrado);
                //indicar con un mensaje de diálogo que se ha fallado el nivel
                JOptionPane.showMessageDialog(ventana
                        , "¡¡¡ CUADRADO SELECCIONADO ERRÓNEO !!!"
                        , "Mensaje"
                        , JOptionPane.INFORMATION_MESSAGE
                        , null);
            }
            //actualizar el panel de juego con datos del siguiente nivel
            panelJuego.actualizar();
            if ((panelJuego.getNivelActual()-1) != niveles)
            {
                //generar el nuevo panel y actualizar los datos informativos
                panelJuego.generarNuevoPanel();
                panelesInfo[2].setValor(panelJuego.getNivelActual());
            }
            else
            {
                //si el nivel jugador era el último se finaliza el juego
                finalPartida();
            }
        }
    }
}