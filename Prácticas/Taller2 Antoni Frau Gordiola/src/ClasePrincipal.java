
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



public class ClasePrincipal {
    
    private final int ANCHO = 580, ALTO = 740;
    
    private JFrame ventana;
    PanelJuego panelJuego;
    JPanel panelVisualizacion;
    PanelInformativo[] panelesInfo;
    
    private final String[] ACCIONES = {"NUEVA PARTIDA", "SALIR"};
    private final String[] INFORMACION = {"NIVELES PARTIDA", "NIVELES RESTANTES",
        "NIVEL ACTUAL", "PUNTUACIÓN"};
    private boolean enPartida = false;
    private int niveles,puntuacion;
    
    public static void main(String[] args)
    {
        new ClasePrincipal().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        ventana = new JFrame("VISUALIZACIÓN IMAGEN");
        
        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos = ventana.getContentPane();    
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
        
        ventana.setJMenuBar(barraMenu);         //Esta línea no es necesaria, pero allí está ¯\_( ͡° ͜ʖ ͡°)_/¯
        barraMenu.add(menu);
        
        divisores[0].add(barraMenu);
        //==================================================================

        
        
        
        
        
        
        
        //===================================================================
        //PANEL SUPERIOR
        JPanel panelSuperior = new JPanel();
        panelSuperior.setPreferredSize(new Dimension(ANCHO,100));
        
        divisores[1].add(panelSuperior);
        //==================================================================
                
        
        
        
        
        
        
        
        
        //==================================================================
        //PANEL DE INFORMACIÓN
        JPanel panelInformacion = new JPanel();
        panelInformacion.setPreferredSize(new Dimension(ANCHO-10,58));
        panelesInfo = new PanelInformativo[INFORMACION.length];
        
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
        panelVisualizacion = new JPanel();
        PanelStandby panelStandby = new PanelStandby("uib.gif");
        
        panelVisualizacion.setPreferredSize(new Dimension(ANCHO,ANCHO-40));
        panelVisualizacion.setLayout(new CardLayout());
        panelVisualizacion.setBackground(Color.PINK);
        
        panelVisualizacion.add(panelStandby, "Panel standby");
        
        reiniciarPanelJuego();
        
        //divisores[1].add(panelVisualizacion);
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
    
    private void reiniciarPantalla()
    {
        for (int i = 0; i < panelesInfo.length; i++)
        {
            panelesInfo[i].setValor(0);
        }
        
        CardLayout clo = (CardLayout)panelVisualizacion.getLayout();
        clo.show(panelVisualizacion, "Panel standby");
    }
    
    private void reiniciarPanelJuego()
    {
        panelJuego = new PanelJuego(new GestorCuadrado());
        panelJuego.setPreferredSize(new Dimension(ANCHO, ANCHO-40));
        panelVisualizacion.add(panelJuego, "Panel juego");
    }
    
    private void nuevaPartida()
    {
        enPartida = true;
        reiniciarPanelJuego();
        puntuacion = 0;
        
        int nivelesTemp = 0,complejidadTemp = 0;
        
        do{
            JPanel emergente = new JPanel();
            JLabel insertaNiveles = new JLabel("Indica la cantidad de niveles[1..10]: "); 
            JTextField textoNiveles = new JTextField();
            JLabel insertaComplejidad = new JLabel("Indica la complejidad de juego[1..10]: "); 
            JTextField textoComplejidad = new JTextField();
            
            emergente.setPreferredSize(new Dimension(230,100));
            textoNiveles.setPreferredSize(new Dimension(150,20));
            textoComplejidad.setPreferredSize(new Dimension(150,20));
            
            emergente.add(insertaNiveles);
            emergente.add(textoNiveles);
            emergente.add(insertaComplejidad);
            emergente.add(textoComplejidad);

            JOptionPane.showMessageDialog(ventana, emergente);

            if (textoNiveles.getText() != null)
                nivelesTemp = Integer.parseInt(textoNiveles.getText());
            else
                nivelesTemp = 0;
            
            if (textoComplejidad.getText() != null)
                complejidadTemp = Integer.parseInt(textoComplejidad.getText());
            else
                complejidadTemp = 0;
            
        } while ((nivelesTemp < 1 || 10 < nivelesTemp) || 
                (complejidadTemp < 1 || 10 < complejidadTemp));
        
        niveles = nivelesTemp;
        panelJuego.setComplejidad(complejidadTemp);
        
        panelJuego.generarPanel();
        
        panelesInfo[0].setValor(niveles);
        panelesInfo[1].setValor(niveles);
        panelesInfo[2].setValor(1);
        
        CardLayout clo = (CardLayout) panelVisualizacion.getLayout();
        clo.show(panelVisualizacion, "Panel juego");
    }
    
    private void finalPartida()
    {
        JOptionPane.showMessageDialog(ventana
            , "¡¡¡ LA PARTIDA HA TERMINADO CON UN TOTAL DE "
                    + puntuacion + " PUNTOS !!!"
            , "Mensaje"
            , JOptionPane.INFORMATION_MESSAGE
            , null);
        
        enPartida = false;
        reiniciarPantalla();
    }
    
    private class PanelInformativo extends JPanel {
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
            
            setValor(0);
            
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
    
    private class GestorAcciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            int i = 0;
            while (!event.getActionCommand().equals(ACCIONES[i])) i++;
            
            switch (i)
            {
                case 0:
                    if (!enPartida)
                    {
                        nuevaPartida();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(ventana
                            , "¡¡¡ NO SE PUEDE INICIAR UNA PARTIDA HABIENDO"
                                    + " UNA PARTIDA EN CURSO !!!"
                            , "Mensaje"
                            , JOptionPane.INFORMATION_MESSAGE
                            , null);
                    }
                    break;
                case 1:
                    System.exit(0);
                    break;
            }
        }
    }
    
    private class PanelStandby extends JPanel {    
        JLabel etiquetaImagen;
        public PanelStandby(String gif)
        {
            setPreferredSize(new Dimension(ANCHO-10,ANCHO-40));            
            
            
            ImageIcon gif2 = new ImageIcon(gif);
            Image image = gif2.getImage();
            image = image.getScaledInstance(ANCHO-10, ANCHO-40, 0);
            gif2.setImage(image);
            etiquetaImagen = new JLabel(gif2);
            
            
            etiquetaImagen.setOpaque(true);
            add(etiquetaImagen);
        }
    }
    
    private class GestorCuadrado implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            Cuadrado cuadrado = (Cuadrado)evento.getSource();
            
            if (cuadrado.esDiferente())
            {
                cuadrado.setNoDiferente();
                puntuacion += panelJuego.getNivelActual()+1;
                panelesInfo[3].setValor(puntuacion);
            }
            else
            {
                panelJuego.indicarFallo();
                cuadrado.marcar();
                JOptionPane.showMessageDialog(ventana
                        , "¡¡¡ CUADRADO SELECCIONADO ERRÓNEO !!!"
                        , "Mensaje"
                        , JOptionPane.INFORMATION_MESSAGE
                        , null);
            }
            
            if (panelJuego.getNivelActual() != niveles)
            {
                panelesInfo[1].setValor(niveles-panelJuego.getNivelActual());
                panelJuego.actualizar();
                panelesInfo[2].setValor(panelJuego.getNivelActual());
            }
            else
            {
                finalPartida();
            }
        }
    }
}