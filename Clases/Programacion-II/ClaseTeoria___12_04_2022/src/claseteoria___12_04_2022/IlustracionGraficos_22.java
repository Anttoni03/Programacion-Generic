/*
FUNCIONALIDAD:
EJEMPLO UTILIZACIÓN JTabbedPane

OBJETIVO: ilustración introducción swing JAVA

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;

import java.awt.*;
import javax.swing.*;
public class IlustracionGraficos_22 extends JFrame {
    public IlustracionGraficos_22() {
        super("ILUSTRACIÓN GRÁFICA 22");     
        
        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame
        Container panelContenidos=getContentPane();   
        
        //DECLARACIONES COMPONENTES JLabel
        JLabel etiqueta1 = new JLabel("PANEL PRIMERO", SwingConstants.CENTER);
        JLabel etiqueta2 = new JLabel("PANEL SEGUNDO", SwingConstants.CENTER);
        JLabel etiqueta3 = new JLabel("PANEL TERCERO", SwingConstants.CENTER);

        // CREACIÓN OBJETO JTabbedPane
        JTabbedPane Multipaneles = new JTabbedPane();

        // ESTABLECIMIENTO DEL PANEL panel1
        JPanel panel1 = new JPanel();
        panel1.add(etiqueta1);

        // INTRODUCCIÓN DEL PANEL panel1 al MULTIPANELES
        // addTab(String title, Icon icon, Component component, String tip)
        Multipaneles.addTab("PANEL 1", null, panel1, "PRIMER PANEL");

        // ESTABLECIMIENTO DEL PANEL panel2 E INCORPORACIÓN AL MULTIPANELES
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.YELLOW);
        panel2.add(etiqueta2);
        Multipaneles.addTab("PANEL 2", null, panel2, "SEGUNDO PANEL");

        // ESTABLECIMIENTO DEL PANEL panel3 E INCORPORACIÓN AL MULTIPANELES
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add( new JButton("Norte"), BorderLayout.NORTH );
        panel3.add( new JButton("Sur"), BorderLayout.SOUTH );
        panel3.add( new JButton("Oeste"), BorderLayout.WEST );
        panel3.add( new JButton("Este"), BorderLayout.EAST );
        panel3.add( etiqueta3, BorderLayout.CENTER );
        Multipaneles.addTab("PANEL 3", null, panel3, "TERCER PANEL");

        // INSERCIÓN DEL MULTIPANEL AL PANEL DE CONTENIDOS DEL JFrame
        panelContenidos.add(Multipaneles);
        
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame  EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        pack();
        //CENTRADO DEL CONTENEDOR JFrame EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //VISUALIZACIÓN CONTENEDOR JFrame
        setVisible( true );
    } 

    public static void main(String args[]) {
        IlustracionGraficos_22 demoMultipaneles = new IlustracionGraficos_22();
    }
}
