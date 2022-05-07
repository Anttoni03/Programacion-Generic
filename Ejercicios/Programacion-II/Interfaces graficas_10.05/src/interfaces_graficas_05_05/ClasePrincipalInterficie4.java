package interfaces_graficas_05_05;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;


public class ClasePrincipalInterficie4 {
    
    private final String[] textosBot = {"SELECCIONAR", "LEER", "VISUALIZAR", 
        "BORRAR", "SALIR"};
    private String fichero = "";
    private String contenido = "";
    private JTextArea display;
    
    
    //declaración del método main
    public static void main(String[] args)
    {
        new ClasePrincipalInterficie4().metodoPrincipal();
    }
    
    //declaración del método metodoPrincipal
    public  void metodoPrincipal()
    {
        // ============== CREACIÓN DEL CONTENEDOR JFrame ventana =============
        JFrame ventana = new JFrame("INTERFÍCIE 4");      
        //DECLARACIÓN DEL PANEL DE CONTENIDOS JContentPane DE LA VENTANA
        Container panelContenidos = ventana.getContentPane();
        //ASIGNACIÓN DEL LAYOUT BorderLayout AL PANEL DE CONTENIDOS
        BorderLayout blo = new BorderLayout(10, 10);
        
        panelContenidos.setLayout(blo);
        panelContenidos.setBackground(new Color(255, 80, 255));
        //====================================================================
        
        
        
        
        
        
        
        // ================== CREACIÓN PANEL DE BOTONES ======================
        JPanel panelBotones = new JPanel();
        JButton[] botones = new JButton[textosBot.length];
        
        for (int i = 0; i < botones.length; i++)
        {
            botones[i] = new JButton(textosBot[i]);
            botones[i].addActionListener(new gestorAccionEventos());
            panelBotones.add(botones[i]);
        }
        botones[0].setBackground(new Color(255,70,70));
        botones[1].setBackground(new Color(255,60,200));
        botones[2].setBackground(new Color(60,60,255));
        botones[3].setBackground(new Color(190,190,190));
        botones[4].setBackground(new Color(255,255,70));
        
        panelBotones.setBackground(new Color(90,90,255));
        panelContenidos.add(panelBotones, BorderLayout.NORTH);
        //====================================================================
        
        
        
        
        
        
        
        // ============= CREACIÓN PANEL VISUALIZADOR / DISPLAY ===============
        display = new JTextArea();
        JScrollPane barraDesplazamiento = new JScrollPane(display);
        
        display.setAutoscrolls(true);
        display.setBackground(new Color(255,220,70));
        panelContenidos.add(barraDesplazamiento, BorderLayout.CENTER);
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
    
    
    
    
    
    
    // ============ MÉTODO DE LECTURA DEL FICHERO SELECCIONADO ===============
    public void leerFichero()
    {
        BufferedReader f;
        try
        {
            f = new BufferedReader(new FileReader(fichero));
            contenido = "";
            int cod = f.read();
            
            while (cod != -1)
            {
                contenido += (char)cod;
                cod = f.read();
            }
            
            f.close();
        }
        catch (Exception e)
        {
            System.err.println("ERROR");
        }
    }
    //========================================================================
    
    
    
    
    
    
    // ======== MÉTODO DE COMPROBACIÓN DE LA SELECCIÓN DE UN FICHERO =========
    public boolean ficheroSeleccionado()
    {
        File f = new File(fichero);
        
        return f.exists();
    }
    //========================================================================
    
    
    
    
    
    
    
    
    
    
    // ========== MÉTODO QUE INDICA QUE NO HAY FICHERO SELECCIONADO ==========
    public void ficheroNoSeleccionado()
    {
        contenido = "NO SE HA SELECCIONADO NINGÚN FICHERO";
        display.setText(contenido);
    }
    //========================================================================
    
    
    
    
    
    
    
    
    
    // =============== MÉTODO DE BORRADO Y REINICIO DE DATOS =================
    public void borrar()
    {
        contenido = "";
        fichero = "";
        display.setText(contenido);
    }
    //========================================================================
    
    
    
    
    
    
    
    
    
    // ==================== GESTOR DE DIBUJAR FIGURAS ========================
    private class gestorAccionEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            int i = 0;
            while (!evento.getActionCommand().equals(textosBot[i])) i++;
            
            switch (i)
            {
                case 0:
                    JFileChooser seleccionFichero = new JFileChooser();
                    int op = seleccionFichero.showOpenDialog(null);
                    if (op == JFileChooser.APPROVE_OPTION)
                        fichero = seleccionFichero.getSelectedFile().getPath();
                    
                    System.out.println(fichero);
                    break;
                case 1:
                    if (ficheroSeleccionado()) leerFichero();
                    else ficheroNoSeleccionado();
                    break;
                case 2:
                    if (ficheroSeleccionado()) display.setText(contenido);
                    else ficheroNoSeleccionado();
                    break;
                case 3:
                    borrar();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    // =======================================================================
}