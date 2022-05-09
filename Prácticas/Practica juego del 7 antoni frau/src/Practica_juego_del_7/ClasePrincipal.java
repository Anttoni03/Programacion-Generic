// AUTOR: Antoni Frau Gordiola
/**
 * <a href="www.google.com"> Vídeo explicativo </a>
 */
package Practica_juego_del_7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClasePrincipal {
    //Atributos enteros constantes que indican el ancho y alto de la ventana
    private final int ANCHO = 900, ALTO = 700;
    //Atributo que gestiona las acciones y registros de la mesa de juego
    private MesaJuego mesa;
    //Atributo que indica las cartas que actualmente tiene la mesa
    private Carta[] cartasMesa;
    
    PanelCarta[] cartasIA;
    
    PanelCarta[] cartas;
    
    TextoJugador textoJugador;
    
    BotonCarta[] cartasJugador;
    
    JButton botonBarajar;
    JButton botonAccion;
    JButton botonReinicio;
    
    JTextField mensajeTexto;
    
    //Método main de inicio del programa
    public static void main(String[] args)
    {
        new ClasePrincipal().metodoPrincipal();
    }
    
    //Método metodoPrincipal que inicia el programa y sus acciones
    private void metodoPrincipal()
    {
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Juego del 7");

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();
        panelContenidos.setLayout(new BorderLayout());
        
        //reiniciarPartida();
        mesa = new MesaJuego();
        cartasMesa = mesa.getCartas();
        
        
        
        
        //==================================================================
        //Paneles principales de mesa y de interfaz
        JPanel panelMesa = new JPanel();
        FlowLayout floMesa = new FlowLayout();
        
        floMesa.setVgap(8);
        panelMesa.setLayout(floMesa);
        panelMesa.setBackground(new Color(40,150,40));
        panelContenidos.add(panelMesa);
        //==================================================================
        
        
        
        
        
        
        
        //===================================================================
        //Paneles de indicadores de jugadores IA
        JPanel panelJugadoresIA = new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(ANCHO,88);
            }
        };
        FlowLayout floIA = new FlowLayout();
        cartasIA = new PanelCarta[3];
        
        floIA.setHgap(80);
        panelJugadoresIA.setLayout(floIA);
        panelJugadoresIA.setBackground(new Color(40,150,40));
        
        for (int i = 0; i < cartasIA.length; i++) {
            cartasIA[i] = new PanelCarta(false){
                public Dimension getPreferredSize()
                {
                    return new Dimension(56,82);
                }
            };
            cartasIA[i].setImagen("Cartes/card_back_blue.png");
            panelJugadoresIA.add(cartasIA[i]);
        }
        
        panelMesa.add(panelJugadoresIA);
        //===================================================================
        
        
        
        
        
        
        
        
        
        //==================================================================
        //Paneles de cartas
        JPanel panelCartas = new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(ANCHO,350);
            }
        };
        GridLayout glo = new GridLayout(4,13,5,5);
        cartas = new PanelCarta[52];
        
        panelCartas.setBackground(new Color(40,150,40));
        panelCartas.setLayout(glo);
        
        for (int i = 0; i < cartas.length; i++)
        {
            cartas[i] = new PanelCarta(true);
            panelCartas.add(cartas[i]);
        }
        actualizarVisualizadoCartas();
        
        panelMesa.add(panelCartas);
        //===================================================================
        
        
        
        
        
        
        
        
        //===================================================================
        //Panel de etiqueta del jugador
        textoJugador = new TextoJugador();
        
        panelMesa.add(textoJugador);
        //==================================================================
        
        
        
        
        
        
        
        
        
        //==================================================================
        //Panel de cartas jugador
        JPanel panelJugador = new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(ANCHO,90);
            }
        };
        cartasJugador = new BotonCarta[13];
        
        panelJugador.setLayout(new GridLayout(1,13, 5, 5));
        panelJugador.setBackground(new Color(40,150,40));
        for (int i = 0; i < cartasJugador.length; i++)
        {
            cartasJugador[i] = new BotonCarta(i);
            //cartasJugador[i].setImagen(mesa.getJugador(0).getCarta(i).getImagen());
            panelJugador.add(cartasJugador[i]);
        }
        
        panelMesa.add(panelJugador);
        //==================================================================
        
        
        
        
        
        
        
        //==================================================================
        //Panel de botones de acción de interfaz
        JPanel panelBotonesInterfaz = new JPanel(){
            public Dimension getPreferredSize()
            {
                return new Dimension(ANCHO+20, 40);
            }
        };
        
        botonBarajar = new JButton("Baraja");
        botonAccion = new JButton("Juega");
        botonReinicio = new JButton("Reinicia");
        
        botonBarajar.addActionListener((ActionEvent event) -> {
            
            mesa.barajarCartas();
            cartasMesa = mesa.getCartas();
            actualizarVisualizadoCartas();
            
            botonAccion.setEnabled(true);
            botonReinicio.setEnabled(true);            
        });
        
        botonAccion.addActionListener((ActionEvent event) -> {
            
            switch (botonAccion.getActionCommand())
            {
                case "Juega":
                    comenzarPartida();
                    break;
                case "Pasa":
                    mesa.pasarTurno();
                    
                    break;
                case "Turno jugador":
                    
                    break;
            }
        });
        
        botonReinicio.addActionListener((ActionEvent event) -> {
            reiniciarPartida();
        });
                
        panelBotonesInterfaz.add(botonBarajar);
        panelBotonesInterfaz.add(botonAccion);
        panelBotonesInterfaz.add(botonReinicio);
        
        panelMesa.add(panelBotonesInterfaz);
        //==================================================================
        
        
        
        
        
        
        
        
        
        //==================================================================
        //Panel de interfaz del texto
        JPanel panelInterfaz = new JPanel();
        mensajeTexto = new JTextField(98);
        
        panelContenidos.add(panelInterfaz, BorderLayout.SOUTH);
        mensajeTexto.setEditable(false);
        panelInterfaz.add(mensajeTexto);
        //==================================================================
        
        

        
        
        
        //===============================================================
        //Procesos iniciales
        
        reiniciarPartida();
        
        //================================================================
        

        
        
        //ajuste dimensión contenedor JFrame ventana en función de las entidades
        //introducidas en él
        ventana.setSize(ANCHO+20, ALTO);
        //Poner la ventana principal en la posición central de la pantalla
        ventana.setLocationRelativeTo(null);
        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }
    
    private void reiniciarPartida()
    {
        //Reiniciar la mesa de juego y las cartas a usar
        mesa = new MesaJuego();
        cartasMesa = mesa.getCartas();
        
        //Reiniciar las puntuaciones de los bots
        for (int i = 0; i < cartasIA.length; i++) cartasIA[i].reiniciar();
        
        //Reiniciar los visualizados de las cartas de la mesa
        for (int i = 0; i < cartas.length; i++) cartas[i].reiniciar();
        actualizarVisualizadoCartas();
        
        //Reiniciar contador de cartas del jugador
        textoJugador.setValor(0);
        
        //Reiniciar cartas del jugador
        for (int i = 0; i < cartasJugador.length; i++) cartasJugador[i].reiniciar();
        
        //Reiniciar la interfaz y botones
        botonBarajar.setVisible(true);
        botonAccion.setText("Jugar");
        botonAccion.setEnabled(false);
        botonReinicio.setEnabled(false);
        
        mensajeTexto.setText("");
    }
    
    private void comenzarPartida()
    {
        //Dar las cartas a los jugadores
        mesa.repartirCartas();
        
        //Actualizar las puntuaciones de los bots
        actualizarCartasIA();
    }
    
    private void actualizarCartasIA()
    {
        for (int i = 0; i < cartasIA.length; i++)
        {
            cartasIA[i].verImagen(true);
            cartasIA[i].setValor(mesa.getJugador(i+1).getCantidadCartas());
        }
    }
    
    private void actualizarVisualizadoCartas()
    {
        for (int i = 0; i < cartas.length; i++)
        {
            cartas[i].setImagen(cartasMesa[i].getImagen());
        }
    }
    
    private class PanelCarta extends JPanel
    {
        
        private BufferedImage imagen = null;
        private boolean esCarta;
        private boolean visualizar;
        private int valor = 0;
        
        public PanelCarta(boolean c)
        {
            esCarta = c;
            visualizar = c;
        }
        
        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new Color(30,110,30));
            Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
            g2.fill(rec);
            
            if (imagen != null && visualizar)
                g2.drawImage(imagen, esCarta?4:0, esCarta?4:0, 
                        getWidth()-(esCarta?4:0), getHeight()-(esCarta?4:0), this);
            
            if (!esCarta)
            {
                g2.setPaint(Color.WHITE);
                g2.setFont(new Font("Comic sans", Font.ITALIC | Font.BOLD, 45));
                g2.drawString(valor+"", (valor > 9)?0:getWidth()/4, getHeight()/1.4f);
            }
        }
                
        public void setImagen(BufferedImage img)
        {
            imagen = img;
            repaint();
        }
        public void setImagen(String img)
        {
            try{
                imagen = ImageIO.read(new File(img));
            } catch (IOException e){
                System.err.println("ERROR: " + e.toString());
            }
        }
        
        public void verImagen(boolean a)
        {
            visualizar = a;
        }
        
        public void setValor(int i)
        {
            valor = i;
        }
        
        public void reiniciar()
        {
            setValor(0);
            verImagen(esCarta);
        }
    }
    
    private class BotonCarta extends JButton
    {
        private BufferedImage imagen = null;
        private boolean visualizar;
        private int orden;
        
        public BotonCarta(int ord)
        {
            orden = ord;
            visualizar = false;
            
            if (orden != 0)
                setVisible(false);
        }
        
        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g;
            
            g2.setPaint(new Color(30,110,30));
            Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
            
            g2.fill(rec);
            
            if (imagen != null && visualizar)
                g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
        
        public void reiniciar()
        {
            visualizar = false;
            setEnabled(false);
        }
        
        public Dimension getPreferredSize()
        {
            return new Dimension(56, 82);
        }
        
        public void setImagen(BufferedImage img)
        {
            imagen = img;
        }
    }
    
    private class TextoJugador extends JPanel
    {
        private int valor;
            
        public Dimension getPreferredSize()
        {
            return new Dimension(ANCHO, 30);
        }

        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.WHITE);
            g2.setFont(new Font("Comic sans", Font.ITALIC | Font.BOLD, 30));
            g2.drawString(valor+"", 25, 25);
        }

        public void setValor(int i)
        {
            valor = i;
        }
    }
}