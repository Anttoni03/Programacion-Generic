package interfaces_graficas_05_05;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.*;


public class ClasePrincipalInterficieC {
    
    private String[] textosCol = {"ROJO", "VERDE", "AZUL", "CYAN", "MAGENTA", "AMARILLO"};
    private final String[] textosFig = {"RECTÁNGULO", "ELIPSE", "POLILÍNEA", "POLÍGONO", "TEXTO"};
    private PanelDibujo dibujo;
    private int comandoAccion;
    private int figura;
    private boolean rellenar;
    private boolean borrar = false;
    private Color colorBorrado = Color.WHITE;
    
    private JRadioButton colorearButton1 = new JRadioButton("COLOREADO", false);
    private JRadioButton colorearButton2 = new JRadioButton("SIN COLOREAR", true);
    private JRadioButtonMenuItem[] m4opciones = new JRadioButtonMenuItem[2];
    
    //declaración del método main
    public static void main(String[] args)
    {
        new ClasePrincipalInterficieC().metodoPrincipal();
    }
    
    //declaración del método metodoPrincipal
    public  void metodoPrincipal()
    {
        // ============== CREACIÓN DEL CONTENEDOR JFrame ventana =============
        JFrame ventana = new JFrame("INTERFÍCIE C");      
        //DECLARACIÓN DEL PANEL DE CONTENIDOS JContentPane DE LA VENTANA
        Container panelContenidos = ventana.getContentPane();
        //ASIGNACIÓN DEL LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        BorderLayout blo = new BorderLayout(10, 10);
        
        panelContenidos.setLayout(blo);
        panelContenidos.setBackground(new Color(120, 255, 120));
        //====================================================================
        
        
        
        
        
        
        
        // =============== CREACIÓN PANEL BOTONES COLORES ====================
        JPanel panelColores = new JPanel();
        JButton[] botones = new JButton[textosCol.length];
        GridLayout glo1 = new GridLayout(textosCol.length, 1, 15, 15);
        
        
        for (int i = 0; i < botones.length; i++)
        {
            botones[i] = new JButton(textosCol[i]);
            botones[i].addActionListener(new gestorColorEventos());
            panelColores.add(botones[i]);
        }
        botones[0].setBackground(new Color(255,70,70));
        botones[1].setBackground(new Color(70,255,70));
        botones[2].setBackground(new Color(70,70,255));
        botones[3].setBackground(new Color(70,255,255));
        botones[4].setBackground(new Color(255,80,255));
        botones[5].setBackground(new Color(255,255,70));
        
        panelColores.setBackground(new Color(255,215,15));
        panelColores.setLayout(glo1);
        panelContenidos.add(panelColores, BorderLayout.WEST);
        //====================================================================
        
        
        
        
        
        
        
        
        // =============== CREACIÓN PANEL BOTONES FIGURAS ====================
        JPanel panelFiguras = new JPanel();
        JButton[] figuras = new JButton[textosFig.length];
        GridLayout glo2 = new GridLayout(textosFig.length, 1, 15, 15);
        
        
        for (int i = 0; i < figuras.length; i++)
        {
            figuras[i] = new JButton(textosFig[i]);
            figuras[i].setBackground(Color.BLACK);
            figuras[i].setForeground(Color.WHITE);
            figuras[i].addActionListener(new gestorFigurasEventos());
            panelFiguras.add(figuras[i]);
        }
        
        panelFiguras.setBackground(new Color(110,175,255));
        panelFiguras.setLayout(glo2);
        panelContenidos.add(panelFiguras, BorderLayout.EAST);
        //====================================================================
        
        
        
        
        
        
        
        
        
        // ================= CREACIÓN PANEL panelVarios ======================
        JPanel panelVarios = new JPanel();
        JButton[] botonesVarios = new JButton[3];
        GridLayout variosGL = new GridLayout(1, botonesVarios.length, 15, 15);
        JPanel panelColoreado = new JPanel();
        ButtonGroup grupo = new ButtonGroup();
        GridLayout gltemp = new GridLayout(2,1);
        
        botonesVarios[0] = new JButton("COLOR BORRADO");
        botonesVarios[1] = new JButton("BORRAR");
        botonesVarios[2] = new JButton("SALIR");
        for (int i = 0; i < botonesVarios.length; i++)
        {
            botonesVarios[i].setBackground(Color.BLACK);
            botonesVarios[i].setForeground(Color.WHITE);
            panelVarios.add(botonesVarios[i]);
            
            if (i == 1) panelVarios.add(panelColoreado);
        }
        
        botonesVarios[0].addActionListener(new gestorElegirColorEvento());
        botonesVarios[1].addActionListener(new gestorColorEventos(true));
        botonesVarios[2].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });
        
        colorearButton1.setBackground(Color.BLACK);
        colorearButton1.addItemListener(new gestorRellenoEvento(true));
        colorearButton1.setForeground(Color.WHITE);
        colorearButton2.setBackground(Color.BLACK);
        colorearButton2.addItemListener(new gestorRellenoEvento(false));
        colorearButton2.setForeground(Color.WHITE);
        panelColoreado.add(colorearButton1, BorderLayout.NORTH);
        panelColoreado.add(colorearButton2, BorderLayout.CENTER);
        grupo.add(colorearButton1);
        grupo.add(colorearButton2);
        
        panelColoreado.setLayout(gltemp);
        panelVarios.setLayout(variosGL);
        panelVarios.setBackground(new Color(255,50,50));
        panelContenidos.add(panelVarios, BorderLayout.SOUTH);
        //====================================================================
        
        
        
        
        
        
        
        // ==================== CREACIÓN PANEL DIBUJO ========================
        dibujo = new PanelDibujo();
        
        dibujo.setLayout(new FlowLayout(FlowLayout.CENTER));
        //dibujo.setBackground(Color.CYAN);
        panelContenidos.add(dibujo, BorderLayout.CENTER);
        //====================================================================

        
        
        
        
        
        
        
        // ==================== CREACIÓN JMENU BAR ===========================
        JMenuBar barraMenu = new JMenuBar();
        
        ventana.setJMenuBar(barraMenu);
        JMenu menu1 = new JMenu("GENERAL"), menu2 = new JMenu("FIGURAS"),
                menu3 = new JMenu("COLOR FONDO"), menu4 = new JMenu("COLOREADO");
        ButtonGroup grupo2 = new ButtonGroup();
        JMenuItem[] m1opciones = new JMenuItem[2];
        m1opciones[0] = new JMenuItem("COLOR BORRADO");
        m1opciones[1] = new JMenuItem("BORRAR");
        JMenuItem[] m2opciones = new JMenuItem[5];
        for (int i = 0; i < m2opciones.length; i++) m2opciones[i] = new JMenuItem(textosFig[i]);
        JMenuItem[] m3opciones = new JMenuItem[6];
        for (int i = 0; i < m3opciones.length; i++) m3opciones[i] = new JMenuItem(textosCol[i]);
        m4opciones[0] = new JRadioButtonMenuItem("COLOREADO", false);
        m4opciones[0].addItemListener(new gestorRellenoEvento(true));
        m4opciones[1] = new JRadioButtonMenuItem("SIN COLOREAR", true);
        m4opciones[1].addItemListener(new gestorRellenoEvento(false));
    
        grupo2.add(m4opciones[0]);
        grupo2.add(m4opciones[1]);
        
        for (int i = 0; i < m1opciones.length; i++)
        {
            menu1.add(m1opciones[i]);
        }
        for (int i = 0; i < m2opciones.length; i++)
        {
            menu2.add(m2opciones[i]);
            m2opciones[i].addActionListener(new gestorFigurasEventos());
        }
        for (int i = 0; i < m3opciones.length; i++)
        {
            m3opciones[i].addActionListener(new gestorColorEventos());
            menu3.add(m3opciones[i]);
        }
        for (int i = 0; i < m4opciones.length; i++)
        {
            menu4.add(m4opciones[i]);
        }
        
        m1opciones[0].addActionListener(new gestorElegirColorEvento());
        m1opciones[1].addActionListener(new gestorColorEventos(true));
        
        barraMenu.add(menu1);
        barraMenu.add(menu2);
        barraMenu.add(menu3);
        barraMenu.add(menu4);
        //====================================================================
        
        
        
        
        
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.setSize(800,450);
        //ventana.pack();
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
        }
    
    
    // ================== PANEL DE DIBUJO PERSONALIZADO ======================
    private class PanelDibujo extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;            
            
            Color[] colores = {new Color(255,70,70), new Color(70,255,70), new Color(70,70,255), new Color(70,255,255),
                new Color(255,80,255), new Color(255,255,70)};
            
            g2.setPaint(borrar? colorBorrado : colores[comandoAccion]);
            borrar = false;
            
            g2.fill(new Rectangle2D.Float(0,0, getWidth(), getHeight()));
            
            int[] x = {30, 50, 70, 80, 85, 140,130, 70, 30}, 
                  y = {100,90, 15, 10, 60, 55, 120, 139,100};
            
            g2.setPaint(Color.BLACK);
            
            switch (figura)
            {
                case 0:
                    if (rellenar) g2.fill(new Rectangle2D.Float(30,30,250,150));
                    else g2.draw(new Rectangle2D.Float(30,30,250,150));
                    break;
                case 1:
                    if (rellenar) g2.fill(new Ellipse2D.Float(30,30,250,150));
                    else g2.draw(new Ellipse2D.Float(30,30,250,150));
                    break;
                case 2:
                    GeneralPath polilinea1 = new GeneralPath();
                    polilinea1.moveTo(30, 100);
                    polilinea1.lineTo(50, 90);
                    polilinea1.lineTo(70,15);
                    polilinea1.lineTo(80,10);
                    polilinea1.lineTo(85,60);
                    polilinea1.lineTo(140,55);
                    polilinea1.lineTo(130,120);
                    polilinea1.lineTo(40,130);
                    g2.draw(polilinea1);
                    break;
                case 3:
                    GeneralPath polilinea2 = new GeneralPath();
                    polilinea2.moveTo(30, 100);
                    polilinea2.lineTo(50, 90);
                    polilinea2.lineTo(70,15);
                    polilinea2.lineTo(80,10);
                    polilinea2.lineTo(85,60);
                    polilinea2.lineTo(140,55);
                    polilinea2.lineTo(130,120);
                    polilinea2.lineTo(40,130);
                    polilinea2.closePath();
                    if (rellenar) g2.fill(polilinea2);
                    else g2.draw(polilinea2);
                    break;
                case 4:
                    g.drawString("¿ CÓMO VAMOS ?", 220, 160);
                    break;
            }
        }
    }
    //========================================================================
    
    
    
    
    
    
    // ============== GESTOR EVENTOS DE COLORES PERSONALIZADO ================
    private class gestorColorEventos implements ActionListener
    {
        private boolean delete = false;
        public gestorColorEventos(){}
        public gestorColorEventos(boolean del){delete = del;}
        
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            borrar = delete;
            int i = 0;
            while (!evento.getActionCommand().equals(textosCol[i]) && i < textosCol.length-1) i++;
            
            comandoAccion = i;
            
            dibujo.repaint();
        }
    }
    //========================================================================
    
    
    
    
    
    
    // ==================== GESTOR DE DIBUJAR FIGURAS ========================
    private class gestorFigurasEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            int i = 0;
            while (!evento.getActionCommand().equals(textosFig[i]) && i < textosFig.length-1) i++;
            
            figura = i;
            
            dibujo.repaint();
        }
    }
    // =======================================================================
    
    
    
    
    
    
    
    
    // ============= GESTOR DE SELECCIÓN DE COLOR DE BORRADO =================
    private class gestorElegirColorEvento implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Color temp = JColorChooser.showDialog(null, "SELECCIONA EL COLOR DE BORRADO", colorBorrado);
            
            if (temp == null) return;
            
            colorBorrado = temp;
        }
    }
    //========================================================================
    
    
    
    
    
    
    
    // ================= GESTOR DE SELECCIÓN DE RELLENO ======================
    private class gestorRellenoEvento implements ItemListener
    {
        boolean fill;
        public gestorRellenoEvento(boolean f)
        {
            fill = f;
        }
        @Override
        public void itemStateChanged(ItemEvent evento)
        {
            rellenar = fill;
                        
            if (evento.getStateChange() == 1)
            {
                if (fill)
                {
                    if (evento.getSource().equals(colorearButton1)) m4opciones[0].setSelected(true);
                    else colorearButton1.setSelected(true);
                }
                else
                {
                    if (evento.getSource().equals(colorearButton2)) m4opciones[1].setSelected(true);
                    else colorearButton2.setSelected(true);
                }
                
                dibujo.repaint();
            }
        }
    }
}