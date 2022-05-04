package interfaces_graficas_05_05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClasePrincipalInterficieB {
    
    String[] textos = {"ACCIÓN 1", "ACCIÓN 2", "ACCIÓN 3", "ACCIÓN 4", "ACCIÓN 5", "SALIR"};
    JPanel visualizador;
    JTextField texto;
    JLabel etiqueta;
    
    //declaración del método main
    public static void main(String[] args)
    {
        new ClasePrincipalInterficieB().metodoPrincipal();
    }
    
    //declaración del método metodoPrincipal
    public  void metodoPrincipal()
    {
        //CREACIÓN DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("INTERFÍCIE B");      
        //DECLARACIÓN DEL PANEL DE CONTENIDOS JContentPane DE LA VENTANA
        Container panelContenidos = ventana.getContentPane();
        //ASIGNACIÓN DEL LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        BorderLayout blo = new BorderLayout(10, 10);
        
        panelContenidos.setLayout(blo);
        panelContenidos.setBackground(new Color(250, 250, 50));
        
        
        //CREACIÓN PANEL BOTONES ACCIONES
        JPanel panelBotones = new JPanel();
        JButton[] botones = new JButton[textos.length];
        GridLayout glo = new GridLayout(textos.length, 1, 15, 15);
        
        panelBotones.setBackground(new Color(80,205,100));
        panelBotones.setLayout(glo);
        
        for (int i = 0; i < botones.length; i++)
        {
            botones[i] = new JButton(textos[i]);
            if (i < botones.length - 1)
                botones[i].addActionListener(new gestorEventos());
            
            panelBotones.add(botones[i]);
        }
        botones[botones.length-1].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evento)
            {
                System.exit(0);
            }
        });
        panelContenidos.add(panelBotones, BorderLayout.WEST);
        
        
        //CREACIÓN COMPONENTE TEXTO
        texto = new JTextField();
        
        texto.setBackground(new Color(245,90,225));
        panelContenidos.add(texto, BorderLayout.SOUTH);
        
        
        //CREACIÓN PANEL VISUALIZADOR
        visualizador = new JPanel();
        etiqueta = new JLabel();
        
        visualizador.add(etiqueta);
        visualizador.setLayout(new FlowLayout(FlowLayout.CENTER));
        visualizador.setBackground(Color.CYAN);
        panelContenidos.add(visualizador, BorderLayout.CENTER);
        

        //CREACIÓN JMENU BAR
        JMenuBar barraMenu = new JMenuBar();
        
        ventana.setJMenuBar(barraMenu);
        JMenu menu1 = new JMenu("PRIMERO"), menu2 = new JMenu("SEGUNDO"),
                menu3 = new JMenu("TERCERO"), menu4 = new JMenu("CUARTO");
        JMenuItem[] m1opciones = new JMenuItem[2];
        JMenuItem[] m2opciones = new JMenuItem[5];
        JMenuItem[] m3opciones = new JMenuItem[6];
        JRadioButtonMenuItem[] m4opciones = new JRadioButtonMenuItem[2];
        
        for (int i = 0; i < m1opciones.length; i++)
        {
            m1opciones[i] = new JMenuItem("OPCIÓN " + (i+1));
            m1opciones[i].addActionListener(new gestorEventos(0));
            menu1.add(m1opciones[i]);
        }
        for (int i = 0; i < m2opciones.length; i++)
        {
            m2opciones[i] = new JMenuItem("OPCIÓN " + (i+1));
            m2opciones[i].addActionListener(new gestorEventos(1));
            menu2.add(m2opciones[i]);
        }
        for (int i = 0; i < m3opciones.length; i++)
        {
            m3opciones[i] = new JMenuItem("OPCIÓN " + (i+1));
            m3opciones[i].addActionListener(new gestorEventos(2));
            menu3.add(m3opciones[i]);
        }
        for (int i = 0; i < m4opciones.length; i++)
        {
            m4opciones[i] = new JRadioButtonMenuItem("OPCIÓN " + (i+1));
            m4opciones[i].addActionListener(new gestorEventos(3));
            menu4.add(m4opciones[i]);
        }
        barraMenu.add(menu1);
        barraMenu.add(menu2);
        barraMenu.add(menu3);
        barraMenu.add(menu4);
        
        
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.setSize(650,400);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
    
    
    private class gestorEventos implements ActionListener
    {
        boolean acciones;
        int menu;
        
        public gestorEventos() { acciones = true; }
        
        public gestorEventos(int men)
        {
            acciones = false;
            menu = men;
        }
        
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            if (acciones)
            {
                texto.setText("HAS PULSADO EL BOTÓN " + evento.getActionCommand());
            }
            else
            {
                String men = "";
                switch (menu)
                {
                    case 0 -> men = "PRIMERO";
                    case 1 -> men = "SEGUNDO";
                    case 2 -> men = "TERCERO";
                    case 3 -> men = "CUARTO";
                }
                texto.setText("HAS PULSADO LA OPCIÓN " + evento.getActionCommand()
                        + " DEL MENÚ " + men);
                etiqueta.setText("HAS PULSADO LA OPCIÓN " + evento.getActionCommand()
                        + " DEL MENÚ " + men);
            }
        }
    }
}