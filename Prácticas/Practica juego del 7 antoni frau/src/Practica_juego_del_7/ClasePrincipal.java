// AUTOR: Antoni Frau Gordiola
package Practica_juego_del_7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** <a href="https://youtu.be/0u33Nt3KwUM"> Vídeo explicativo </a> */
public class ClasePrincipal 
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributos de objeto de enteros constantes que indican el ancho y alto
    private final int ANCHO = 900, ALTO = 688;
    //Atributo de objeto que gestiona las acciones y datos de la mesa de juego
    private MesaJuego mesa;
    //Atributo de objeto que guarda los paneles de los indicadores de los bots
    private PanelCarta[] cartasBots;
    //Atributo de objeto que guarda los paneles de cartas de la mesa
    private PanelCarta[] cartas;
    //Atributo de objeto que guarda los paneles de las cartas del jugador
    private BotonCarta[] cartasJugador;
    //Atributo de objeto que guarda el panel de texto del jugador
    private TextoJugador textoJugador;
    //Atributo de objeto que guada el campo de texto de las acciones en partida
    private JTextField mensajeTexto;
    
    //Atributo de objeto que guarda el botón de barajar las cartas de la mesa
    private JButton botonBarajar;
    //Atributo de objeto que guarda el botón general de las acciones del juego
    private JButton botonAccion;
    //Atributo de objeto que guada el botón de reinicio del juego
    private JButton botonReinicio;
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método main de inicio del programa
    public static void main(String[] args)
    {
        new ClasePrincipal().metodoPrincipal();
    }
    
    //Método metodoPrincipal que gestiona el control principal del programa
    private void metodoPrincipal()
    {
        //declaración e inicialización de la ventana de juego y sus contenidos
        JFrame ventana = new JFrame("Juego del 7");
        Container panelContenidos=ventana.getContentPane();
        //inicialización del objeto MesaJuego como la mesa de la partida
        mesa = new MesaJuego();
        
        //aplicar un BorderLayout a los contenidos de la ventana de juego
        panelContenidos.setLayout(new BorderLayout());
        //llamada a la inicialización de las cartas de la baraja
        Baraja.inicializarBaraja();
        
        
        
        
        
        
        //declaración e inicialización de panel principal de mesa
        JPanel panelMesa = new JPanel();
        
        //añadir un FlowLayout al panel de mesa y establecer su color de fondo
        panelMesa.setLayout(new FlowLayout());
        panelMesa.setBackground(new Color(40,150,40));
        //añadir el panel de mesa a los contenidos de la ventana
        panelContenidos.add(panelMesa);
        
        
        
        
        
        
        //declarar e inicializar los paneles de jugadores bots
        JPanel panelJugadoresBot = new JPanel();
        FlowLayout floIA = new FlowLayout();
        cartasBots = new PanelCarta[3];
        
        //aplicar un espaciado horizontal entre los indicadores de los bots
        floIA.setHgap(ANCHO / 5);
        //aplicar el tamaño, la disposición y la trasparencia del panel de bots
        panelJugadoresBot.setPreferredSize(new Dimension(ANCHO,88));
        panelJugadoresBot.setLayout(floIA);
        panelJugadoresBot.setOpaque(false);
        
        //bucle for inicializador de los indicadores de los bots
        for (int i = 0; i < cartasBots.length; i++) {
            //instanciación del indicador (carta)
            cartasBots[i] = new PanelCarta(false);
            //aplicar un tamaño definido
            cartasBots[i].setPreferredSize(new Dimension(56,82));
            //indicarle la imagen a usar al indidor del bot
            cartasBots[i].setImagen("Cartes/card_back_blue.png");
            //añadir el indicador del bot al panel de los indicadores
            panelJugadoresBot.add(cartasBots[i]);
        }
        //añadir el panel de indicadores de bots a los contenidos de la ventana
        panelMesa.add(panelJugadoresBot);        
        
        
        
        
        
        
        //instanciar e inicializar el panel de las cartas de la mesa y su Layout
        JPanel panelCartas = new JPanel();
        GridLayout glo = new GridLayout(4,13,5,5);
        cartas = new PanelCarta[52];
        
        //aplicar un tamaño, transparencia y el layout al panel de cartas
        panelCartas.setPreferredSize(new Dimension(ANCHO, 350));
        panelCartas.setOpaque(false);
        panelCartas.setLayout(glo);
        
        //bucle for que inicializa las cartas de la mesa y las añade al panel
        for (int i = 0; i < cartas.length; i++)
        {
            cartas[i] = new PanelCarta(true);
            panelCartas.add(cartas[i]);
        }
        //llamada al método actualizador de visualización general de las cartas
        actualizarVisualizadoCartas();
        //añadir el panel de cartas de la mesa al panel de la mesa
        panelMesa.add(panelCartas);
        
        
        
        
        
        
        //inicialización del texto indicador del jugador
        textoJugador = new TextoJugador();
        
        //aplicar un tamaño definido al texto del jugador y añadirlo a la mesa
        textoJugador.setPreferredSize(new Dimension(ANCHO, 30));
        panelMesa.add(textoJugador);
        
        
        

        
        
        //instanciar e inicializar el panel de cartas del jugador y las cartas
        JPanel panelJugador = new JPanel();
        cartasJugador = new BotonCarta[13];
        
        //aplicar un tamaño, transparencia y disposición al panel del jugador
        panelJugador.setPreferredSize(new Dimension(ANCHO, 90));
        panelJugador.setOpaque(false);
        panelJugador.setLayout(new GridLayout(1,13, 5, 5));
        
        //bucle for que inicializa las cartas jugador, les da un gestor de
        //eventos y las añade al panel del jugador
        for (int i = 0; i < cartasJugador.length; i++)
        {
            cartasJugador[i] = new BotonCarta();
            panelJugador.add(cartasJugador[i]);
            cartasJugador[i].addActionListener(new GestorEventosCarta());
        }
        
        //añadir el panel del jugador al panel de la mesa de juego
        panelMesa.add(panelJugador);
        
        
        
        
        
        
        //instanciación del panel de botones de la interfaz
        JPanel panelBotonesInterfaz = new JPanel();
        //instanciación de botones de barajar, acción general y reinicio partida
        botonBarajar = new JButton("Baraja");
        botonAccion = new JButton("Juega");
        botonReinicio = new JButton("Reinicia");
        
        //aplicar un tamaño definido al panel de los botones
        panelBotonesInterfaz.setPreferredSize(new Dimension(ANCHO+20, 40));
        
        //añadir un gestor de eventos al botón de barajar
        botonBarajar.addActionListener((ActionEvent event) -> {
            //llamada al método de barajar las cartas de la mesa
            mesa.barajarCartas();
            //llamada al método actualizador de visualización de las cartas
            actualizarVisualizadoCartas();
            //activar los botones de acción general y reinicio
            botonAccion.setEnabled(true);
            botonReinicio.setEnabled(true);
            //reiniciar mensaje del campo de texto del juego
            mensajeTexto.setText("La baraja está barajada");
        });
        //añadir un gestor de eventos al botón de acción general
        botonAccion.addActionListener(new GestorEventosAccion());
        //añadir un gestor de eventos al botón de reinicio de partida
        botonReinicio.addActionListener((ActionEvent event) -> {
            reiniciarPartida();
        });
        
        //añadir los botones de la interfaz al panel de los botones
        panelBotonesInterfaz.add(botonBarajar);
        panelBotonesInterfaz.add(botonAccion);
        panelBotonesInterfaz.add(botonReinicio);
        //añadir el panel de los botones al panel de contenidos de la ventana
        panelMesa.add(panelBotonesInterfaz);
        
        
        
        
        
        
        //instanciar el panel de la interfaz del texto y el campo de texto
        JPanel panelInterfaz = new JPanel();
        mensajeTexto = new JTextField(90);
        
        //indicar que el campo no se puede editar
        mensajeTexto.setEditable(false);
        
        //añadir el campo de texto al panel del texto y este al panel de ventana
        panelInterfaz.add(mensajeTexto);
        panelContenidos.add(panelInterfaz, BorderLayout.SOUTH);
        
        
        
        
        
        
        //llamada al método reiniciador del juego para iniciarlo
        reiniciarPartida();
        
        //indicar que el programa finalizará cuando se cierre la ventana gráfica
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aplicar una dimensión indicada a la ventana gráfica
        ventana.setSize(ANCHO+20, ALTO);
        //establecer en el centro de la pantalla la ventana gráfica
        ventana.setLocationRelativeTo(null);
        //incapacitar la redimensión de la ventana gráfica manualmente
        ventana.setResizable(false);
        //activar la visualización de la ventana gráfica principal
        ventana.setVisible(true);
    }
    
    //Método reiniciarPartida que aplica los ajustes iniciales de juego
    private void reiniciarPartida()
    {
        //Reiniciar la mesa de juego
        mesa = new MesaJuego();
        
        //Reiniciar los indicadores de los bots
        for (int i = 0; i < cartasBots.length; i++) cartasBots[i].reiniciar();
        //Reiniciar los visualizados de las cartas de la mesa
        for (int i = 0; i < cartas.length; i++) cartas[i].reiniciar();
        actualizarVisualizadoCartas();
        //Reiniciar cartas del jugador
        for (int i = 0; i < cartasJugador.length; i++) cartasJugador[i].reiniciar();
        
        //Reiniciar contador de cartas del jugador
        textoJugador.reiniciar();
        
        //Reiniciar la interfaz y botones
        botonBarajar.setVisible(true);
        botonAccion.setText("Juega");
        botonAccion.setEnabled(false);
        botonReinicio.setEnabled(false);
        
        //Poner un texto de inicio de partida en el campo de texto
        mensajeTexto.setText("Antes de comenzar es necesario mezclar la baraja");
    }
    
    //Método comenzarPartida que inicia los procesos de una nueva partida
    private void comenzarPartida()
    {
        //dar las cartas a los jugadores
        mesa.repartirCartas();
        actualizarVisualizadoCartas();
        
        //actualizar los contadores de los jugadores humano y bots
        actualizarContadorJugadores();
        for (int i = 0; i < cartasBots.length; i++)
            cartasBots[i].setVisualizar(true);            
        //actualizar las cartas del jugador
        actualizarCartasJugador();
        
        //actualizar la interfaz y botones
        botonBarajar.setVisible(false);
        botonAccion.setText("Pasa");
        
        //mostrar todas las cartas de la mesa
        for (int j = 0; j < cartas.length; j++) cartas[j].setVisualizar(true);
        
        //aplicar un texto de partida iniciada en el campo de texto
        mensajeTexto.setText("Las cartas están repartidas. Es tu turno, pon un 7 si tienes");
    }
    
    //Método turnoBot que completa el turno de un jugador máquina
    private void turnoBot()
    {
        //instanciación de una carta temporal auxiliar y del jugador activo
        Carta tempCarta = mesa.jugarTurno(-1);
        int bot = mesa.getTurnoJugador();
        
        //realizar la jugada si se podía o pasar si no hay acción disponible
        if (tempCarta != null)
            mensajeTexto.setText("El BOT " + (bot) + " ha colocado el ["+tempCarta.toString()+"]");
        else
            mensajeTexto.setText("El BOT " + (bot) + " pasa");
    }
    
    //Método finalPartida que gestiona las acciones del final de una partida
    private void finalPartida(int ganador)
    {
        //desactiva el botón de acciones
        botonAccion.setEnabled(false);
        //mostrar una ventana emergente indicando el jugadar que ha ganado
        JOptionPane.showMessageDialog(null
                , (ganador == 0)? "HAS GANADO!" : ("HA GANADO EL BOT " + ganador)
                , "HEY!"
                , JOptionPane.INFORMATION_MESSAGE
                , mesa.getJugador(ganador).getImagen());
    }
    
    //Método activarCartasJugador que activa las cartas del jugador asignadas
    private void activarCartasJugador()
    {
        //bucle for que comprueba si las cartas son asignadas y se activan
        for (int i = 0; i < cartasJugador.length; i++)
            if (mesa.getJugador(0).getCarta(i).esAsignada())
                cartasJugador[i].setEnabled(true);
    }
    
    //Método actualizarVisualizadoCartas que pone las imágenes de cartas en mesa
    private void actualizarVisualizadoCartas()
    {
        for (int i = 0; i < cartas.length; i++)
            cartas[i].setImagen(mesa.getCartas()[i].getImagen());
    }
    
    //Método actualizarContadorJugadores que actualiza los indicadores de cartas
    private void actualizarContadorJugadores()
    {
        //aplica el nuevo valor al indicador de cartas del jugador y hace repint
        textoJugador.setValor(mesa.getJugador(0).getCantidadCartas());
        textoJugador.repaint();
        
        //bucle for para actualizar los contadores de cartas de los bots
        for (int i = 0; i < cartasBots.length; i++)
        {
            cartasBots[i].setValor(mesa.getJugador(i+1).getCantidadCartas());
            cartasBots[i].repaint();
        }
    }
    
    //Método actualizarCartasJugador que pone las imágenes de cartas del jugador
    private void actualizarCartasJugador()
    {
        for (int i = 0; i < cartasJugador.length; i++)
            cartasJugador[i].iniciar(mesa.getJugador(0).getCarta(i).getImagen());
    }
    
    //////////////////////////  CLASES GESTORAS  //////////////////////////
    //Clase que implementa ActionListener y gestiona las acciones generales
    private class GestorEventosAccion implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            //switch de elección de acciones según el estado del botón pulsado
            switch (botonAccion.getActionCommand())
            {
                //el caso de acción "Juega" comienza una nueva partida
                case "Juega":
                    //llamada al método que comienza una partida
                    comenzarPartida();
                    break;
                //el caso de acción "Pasa" deja el turno sin jugar
                case "Pasa":
                    //bucle for que desactiva cartas del jugador para no usarlas
                    for (int i = 0; i < cartasJugador.length; i++)
                        cartasJugador[i].setEnabled(false);
                    //llamada a actualizar el contador de los jugadores
                    actualizarContadorJugadores();
                    //cambiar la acción del botón a "Turno jugador"
                    botonAccion.setText("Turno jugador");
                    //aplicar la acción de pasar en el campo de texto
                    mensajeTexto.setText("Has pasado");
                    break;
                //el caso de acción "Turno jugador" que pasa el turno de un bot
                case "Turno jugador":
                    //se pasa un turno en la mesa de juego
                    mesa.pasarTurno();
                    //se realiza el turno del bot correspondiente
                    turnoBot();
                    //se actualizan las imágenes de cartas con las de la mesa
                    actualizarVisualizadoCartas();
                    //se actualizan los contadores de los jugadores
                    actualizarContadorJugadores();
            
                    //si es el turno del último se permite el turno del jugador
                    if (mesa.getTurnoJugador() == cartasBots.length)
                    {
                        mesa.pasarTurno();
                        activarCartasJugador();
                        botonAccion.setText("Pasa");
                    }
                    //comprobar el final de la partida
                    if (mesa.haGanado()) finalPartida(mesa.getTurnoJugador());
                    break;
            }
        }
    }
    
    //Clase que implementa ActionListener y gestiona las acciones de las cartas
    private class GestorEventosCarta implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            //buscar el índice de la carta seleccionada con bucle while
            int indice = 0;
            while (!cartasJugador[indice].equals(evento.getSource())) indice++;
            //jugar el turno con la carta seleccionada y registrarla
            Carta temp = mesa.jugarTurno(indice);
            //si el registro de carta no es nulo realizar la acción
            if (temp != null)
            {
                //ocultar la carta seleccionada del jugador
                cartasJugador[indice].setVisualizar(false);
                //bucle for que desactiva las cartas del jugador para no usarlas
                for (int i = 0; i < cartasJugador.length; i++)
                    cartasJugador[i].setEnabled(false);
                //actualización de los contadores de cartas de los jugadores
                actualizarContadorJugadores();
                //cambiar la acción del botón de acciones a "Turno jugador"
                botonAccion.setText("Turno jugador");
                //actualización de las imágenes de cartas con las de la mesa
                actualizarVisualizadoCartas();
                //aplicar el texto de la carta seleccionada en el campo de texto
                mensajeTexto.setText("Has colocado el ["+temp.toString()+"]");
                //comprobar el final de la partida
                if (mesa.haGanado()) finalPartida(mesa.getTurnoJugador());
            }
            //si el registro de carta es nulo indicar que no es válida
            else
            {
                //ejecutar un sonido de error
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}