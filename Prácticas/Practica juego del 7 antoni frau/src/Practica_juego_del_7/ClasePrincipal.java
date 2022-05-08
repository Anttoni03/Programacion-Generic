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
    private final int ANCHO = 900, ALTO = 700;
    MesaJuego mesa;
    
    public static void main(String[] args)
    {
        new ClasePrincipal().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("Juego del 7");

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();
        panelContenidos.setLayout(new BorderLayout());
        
        
        
        
        //================================================================
        mesa = new MesaJuego();
        
        //Instanciar mesa de juego con inicialización incluída
        Carta[] cards = mesa.getCartas();
        
        //Barajar las cartas de la mesa
        mesa.barajarCartas();
        
        //Empezar una partida
        mesa.repartirCartas();
        //================================================================
        
        
        
        
        
        
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
        floIA.setHgap(80);
        panelJugadoresIA.setLayout(floIA);
        panelJugadoresIA.setBackground(new Color(40,150,40));
        PanelCarta[] cartasIA = new PanelCarta[3];
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
        panelCartas.setBackground(new Color(40,150,40));
        GridLayout glo = new GridLayout(4,13,5,5);
        panelCartas.setLayout(glo);
        
        PanelCarta[] cartas = new PanelCarta[52];
        for (int i = 0; i < 52; i++)
        {
            cartas[i] = new PanelCarta(true);
            cartas[i].setImagen(cards[i].getImagen());
            panelCartas.add(cartas[i]);
        }
        
        panelMesa.add(panelCartas);
        //===================================================================
        
        
        
        
        
        
        
        
        //===================================================================
        //Panel de etiqueta del jugador
        JPanel textoJugador = new JPanel(){
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
        };
        
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
        BotonCarta[] cartasJugador = new BotonCarta[13];
        
        panelJugador.setLayout(new GridLayout(1,13, 5, 5));
        panelJugador.setBackground(new Color(40,150,40));
        for (int i = 0; i < cartasJugador.length; i++)
        {
            cartasJugador[i] = new BotonCarta(i);
            cartasJugador[i].setImagen(mesa.getJugador(0).getCarta(i).getImagen());
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
        JButton botonAccion = new JButton("Baraja");
        JButton botonJugar = new JButton("Juega");
        JButton botonReinicio = new JButton("Reinicia");
        
        panelBotonesInterfaz.add(botonAccion);
        panelBotonesInterfaz.add(botonJugar);
        panelBotonesInterfaz.add(botonReinicio);
        
        panelMesa.add(panelBotonesInterfaz);
        //==================================================================
        
        
        
        
        
        
        
        
        
        //==================================================================
        //Panel de interfaz del texto
        JPanel panelInterfaz = new JPanel();
        JTextField mensajeTexto = new JTextField(98);
        
        panelContenidos.add(panelInterfaz, BorderLayout.SOUTH);
        mensajeTexto.setEditable(false);
        panelInterfaz.add(mensajeTexto);
        //==================================================================
        
        
        
        
        
        
        //ajuste dimensión contenedor JFrame ventana en función de las entidades
        //introducidas en él
        ventana.setSize(ANCHO+20, ALTO);
        
        ventana.setLocationRelativeTo(null);
        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }
    
    private class PanelCarta extends JPanel
    {
        
        private BufferedImage imagen = null;
        private boolean esCarta;
        private int valor = 1;
        
        public PanelCarta(boolean c)
        {
            esCarta = c;
        }
        
        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new Color(30,110,30));
            Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
            g2.fill(rec);
            
            if (imagen != null)
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
        
        public void setValor(int i)
        {
            valor = i;
        }
        
        public void cambiarVisualizado()
        {
            setVisible(!isVisible());
        }
    }
    
    private class BotonCarta extends JButton
    {
        private BufferedImage imagen = null;
        private int orden;
        
        public BotonCarta(int ord)
        {
            orden = ord;
        }
        
        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g;
            
            g2.setPaint(new Color(30,110,130));
            Rectangle2D rec = new Rectangle2D.Float(0,0,getWidth(), getHeight());
            g2.fill(rec);
            
            if (imagen != null)
                g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
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
}