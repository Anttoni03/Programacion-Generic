package interfaces_graficas_05_05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClasePrincipalInterficieA {
    
    private String[] textos = {"ROJO", "VERDE", "AZUL", "CYAN", "MAGENTA", "AMARILLO"};
    private PanelDibujo visualizador = new PanelDibujo();
    private int comandoAccion = 0;
    
    //declaración del método main
    public static void main(String[] args)
    {
        new ClasePrincipalInterficieA().metodoPrincipal();
    }
    
    //declaración del método metodoPrincipal
    public  void metodoPrincipal()
    {
        //CREACIÓN DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("INTERFÍCIE A");      

        //DECLARACIÓN DEL PANEL DE CONTENIDOS JContentPane DE LA VENTANA
        Container panelContenidos = ventana.getContentPane();
        //ASIGNACIÓN DEL LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        BorderLayout blo = new BorderLayout(10, 10);
        
        panelContenidos.setLayout(blo);
        panelContenidos.setBackground(new Color(100, 20, 120));
        
        
        //CREACIÓN PANEL BOTONES
        JPanel panelBotones = new JPanel();
        JButton[] botones = new JButton[textos.length];        
        GridLayout glo = new GridLayout(textos.length, 1, 15, 15);
        
        panelBotones.setBackground(new Color(80,255,80));
        panelBotones.setLayout(glo);
        
        for (int i = 0; i < botones.length; i++)
        {
            botones[i] = new JButton(textos[i]);
            botones[i].addActionListener(new gestorEventos());
            panelBotones.add(botones[i]);
        }
        
        botones[0].setBackground(Color.RED);
        botones[1].setBackground(Color.GREEN);
        botones[2].setBackground(Color.BLUE);
        botones[3].setBackground(Color.CYAN);
        botones[4].setBackground(Color.MAGENTA);
        botones[5].setBackground(Color.YELLOW);
        
        panelContenidos.add(panelBotones, BorderLayout.WEST);
        
        
        //CREACIÓN PANEL SALIR
        JPanel panelSalir = new JPanel();
        JButton salir = new JButton("SALIR");
        
        salir.setBackground(Color.BLACK);
        salir.setForeground(Color.WHITE);
        salir.setSize(600, 10);
        salir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evento)
            {
                System.exit(0);
            }
        });
        panelSalir.setLayout(new BorderLayout());
        panelSalir.setBackground(new Color(80,210,255));
        panelSalir.add(salir);
        panelContenidos.add(panelSalir, BorderLayout.SOUTH);
        
        
        //CREACIÓN PANEL VISUALIZADOR        
        visualizador.setBackground(Color.RED);
        panelContenidos.add(visualizador, BorderLayout.CENTER);
        

        
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
    
    private class PanelDibujo extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN,
                Color.MAGENTA, Color.YELLOW};
            
            g.setColor(colores[comandoAccion]);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
    
    private class gestorEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            int i = 0;
            while (!evento.getActionCommand().equals(textos[i])) i++;
            
            comandoAccion = i;
            
            visualizador.repaint();
        }
    }
}