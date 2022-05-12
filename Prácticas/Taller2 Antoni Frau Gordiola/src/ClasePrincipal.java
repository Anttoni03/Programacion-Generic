
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;



public class ClasePrincipal {
    
    private final int ANCHO = 580, ALTO = 740;
    
    private final String[] ACCIONES = {"NUEVA PARTIDA", "SALIR"};
    private final String[] INFORMACION = {"NIVELES PARTIDA", "NIVELES RESTANTES",
        "NIVEL ACTUAL", "PUNTUACIÓN"};
    
    public static void main(String[] args)
    {
        new ClasePrincipal().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("VISUALIZACIÓN IMAGEN");
        
        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    
        panelContenidos.setLayout(new BorderLayout());
        
        JSplitPane[] divisores = new JSplitPane[3];
        for (int i = 0; i < divisores.length; i++)
        {
            divisores[i] = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
            divisores[i].setEnabled(false);
        }
        
        
        
        
        
        
        ///================================================================
        //BARRA DE MENÚ
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("MENÚ");
        JMenuItem[] itemsAcciones = new JMenuItem[ACCIONES.length];
        
        for (int i = 0; i < itemsAcciones.length; i++)
        {
            itemsAcciones[i] = new JMenuItem(ACCIONES[i]);
            itemsAcciones[i].addActionListener(new GestorAcciones());
            menu.add(itemsAcciones[i]);
        }
        
        //TODO: Poner gestor de eventos en nuevaPartidaItem y salirItem
        ventana.setJMenuBar(barraMenu);         //Esta línea no es necesaria, pero allí está ¯\_( ͡° ͜ʖ ͡°)_/¯
        barraMenu.add(menu);
        
        divisores[0].add(barraMenu);
        //==================================================================

        
        
        
        
        
        
        
        //===================================================================
        //PANEL SUPERIOR
        JPanel panelSuperior = new JPanel(){
            @Override
            public Dimension getPreferredSize()
            {
                return new Dimension(ANCHO,100);
            }
        };
        
        //panelSuperior.setBackground(Color.GREEN);
        divisores[1].add(panelSuperior);
        //==================================================================
                
        
        
        
        
        
        
        
        
        //==================================================================
        //PANEL DE INFORMACIÓN
        JPanel panelInformacion = new JPanel(){
            @Override
            public Dimension getPreferredSize()
            {
                return new Dimension(ANCHO-10,58);
            }
        };
        PanelInformativo[] panelesInfo = new PanelInformativo[INFORMACION.length];
        
        panelInformacion.setBackground(Color.BLACK);
        panelInformacion.setLayout(new GridLayout(2,2,130,6));
        for (int i = 0; i < panelesInfo.length; i++)
        {
            panelesInfo[i] = new PanelInformativo(INFORMACION[i]);
            panelInformacion.add(panelesInfo[i]);
        }
        
        divisores[0].add(panelInformacion);
        panelSuperior.add(divisores[0]);
        //===================================================================
        
        
        
        
        
        
        
        //==================================================================
        //CONTENEDORES DE VISUALIZACIÓN
        JPanel panelVisualizacion = new JPanel(){
            @Override
            public Dimension getPreferredSize()
            {
                return new Dimension(ANCHO,ANCHO);
            }
        };
        PanelGif panelStandby = new PanelGif("uib.gif");
        JPanel panelJuego = new JPanel();
        
        panelVisualizacion.setBackground(Color.BLACK);
        panelVisualizacion.add(panelStandby, "Panel standby");
        panelVisualizacion.add(panelJuego, "Panel juego");
        //divisor2.add(panelVisualizacion);
        divisores[2].add(panelVisualizacion);
        //==================================================================
        
        
        
        
        
        
        
        
        
        //==================================================================
        //PANEL DE BOTONES
        JPanel panelBotones = new JPanel();
        JButton[] botones = new JButton[ACCIONES.length];
        
        for (int i = 0; i < botones.length; i++)
        {
            botones[i] = new JButton(ACCIONES[i]);
            botones[i].setBackground(Color.BLACK);
            botones[i].setForeground(Color.WHITE);
            botones[i].addActionListener(new GestorAcciones());
            
            panelBotones.add(botones[i]);
        }
        
        panelBotones.setLayout(new GridLayout(1,2));
        divisores[2].add(panelBotones);
        //===================================================================
        
        
        
        
        
        
        
        
        
        
                
        panelContenidos.add(divisores[1], BorderLayout.NORTH);
        panelContenidos.add(divisores[2], BorderLayout.SOUTH);
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ajuste dimensión contenedor JFrame ventana en función de las entidades
        //introducidas en él
        ventana.setSize(ANCHO, ALTO);
        ventana.setLocationRelativeTo(null);
        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }
    
    private void nuevaPartida()
    {
        
    }
    
    private class PanelInformativo extends JPanel{
        private final JLabel TEXTO;
        private final JLabel VALOR;
        
        public PanelInformativo(String txt)
        {
            setOpaque(false);
            setBackground(Color.ORANGE);
            setLayout(new FlowLayout(FlowLayout.LEFT,5,3));
            
            TEXTO = new JLabel(txt);
            TEXTO.setPreferredSize(new Dimension(170,20));
            VALOR = new JLabel();
            VALOR.setPreferredSize(new Dimension(35,20));
            
            TEXTO.setFont( new Font("Arial", Font.BOLD, 16));
            TEXTO.setBackground(Color.WHITE);
            TEXTO.setOpaque(true);
            TEXTO.setForeground(Color.BLACK);
            VALOR.setFont( new Font("Arial", Font.BOLD, 18));
            VALOR.setBackground(Color.WHITE);
            VALOR.setOpaque(true);
            VALOR.setForeground(Color.RED);
            VALOR.setHorizontalAlignment(0);
            
            setValor(222);
            
            add(TEXTO);
            add(VALOR, BorderLayout.EAST);
        }
        
        
        public void setValor(int val)
        {
            String temp = (val<100) ? ((val<10) ? ((val == 0) ? "000" : "00") : "0") : "";
            VALOR.setText(temp + ((val != 0) ? val : ""));
            repaint();
        }
    }
    
    private class GestorAcciones implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
            int i = 0;
            while (!event.getActionCommand().equals(ACCIONES[i])) i++;
            
            switch (i)
            {
                case 0:
                    nuevaPartida();
                    break;
                case 1:
                    System.exit(0);
                    break;
            }
        }
    }
    
    private class PanelGif extends JPanel{    
        JLabel etiquetaImagen;
        public PanelGif(String gif)
        {
            etiquetaImagen=new JLabel();
            
            //etiquetaImagen.setOpaque(true);
            //setPreferredSize(new Dimension(ANCHO-200,ANCHO-200));
            //etiquetaImagen.setPreferredSize(new Dimension(ANCHO-200,ANCHO-200));
            etiquetaImagen.setIcon(new ImageIcon(gif));
            add(etiquetaImagen);
        }
    }
}
