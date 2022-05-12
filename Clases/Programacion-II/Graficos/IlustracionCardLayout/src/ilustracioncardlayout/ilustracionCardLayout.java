/*
ILUSTRACIÓN UTILIZACIÓN ADMINISTRADOR DE LAYOUT CardLayout
 */
package ilustracioncardlayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juan
 */
public class ilustracionCardLayout {
    private JPanel panelInterfaces, interface1, interface2;
    private Dibujo interface3;
    private JFrame ventana;
    //declaración método main
    public static void main(String[] args) {
        new ilustracionCardLayout().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        ventana = new JFrame("ILUSTRACIÓN CardLayout"); 

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new BorderLayout());     
        
        


        
////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                DECLARACIÓN CONTENEDORES y COMPONENTES                      //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//////////        DECLARACIÓN CONTENEDOR JPanel  panelBotones      /////////////
////////////////////////////////////////////////////////////////////////////////
        JPanel panelBotones=new JPanel();
        //asignación administrador de Layout GridLayout
        panelBotones.setLayout(new GridLayout(1,3,2,2));
        //introducción contenedor JPanel panelBotones en el contenedor panelContenidos
        panelContenidos.add(panelBotones,BorderLayout.SOUTH);
        

//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////
//////////DECLARACIÓN componente JButton boton1 
        JButton boton1= new JButton("INTERFACE 1");
        //INTRODUCCIÓN COMPONENTE JButton boton1 EN EL PANEL panelBotones
        panelBotones.add(boton1);
        //ASIGNACIÓN DEL GESTOR DE EVENTO gestorEvento A LA COMPONENTE JButton 
        //boton1
        boton1.addActionListener(new manipuladorEventosFuncionalidades());

//////////DECLARACIÓN componente JButton boton2 
        JButton boton2= new JButton("INTERFACE 2");
        //INTRODUCCIÓN COMPONENTE JButton boton2 EN EL PANEL panelBotones
        panelBotones.add(boton2);
        //ASIGNACIÓN DEL GESTOR DE EVENTO gestorEvento A LA COMPONENTE JButton 
        //boton2
        boton2.addActionListener(new manipuladorEventosFuncionalidades());
        
//////////DECLARACIÓN componente JButton boton3 
        JButton boton3= new JButton("INTERFACE 3");
        //INTRODUCCIÓN COMPONENTE JButton boton2 EN EL PANEL panelBotones
        panelBotones.add(boton3);
        //ASIGNACIÓN DEL GESTOR DE EVENTO gestorEvento A LA COMPONENTE JButton 
        //boton2
        boton3.addActionListener(new manipuladorEventosFuncionalidades());
        
        
////////////////////////////////////////////////////////////////////////////////        
//////////     DECLARACIÓN CONTENEDOR JPanel  panelInterfaces      /////////////
////////////////////////////////////////////////////////////////////////////////
        panelInterfaces=new JPanel();
        //asignación administradorde layout CardLayout
        panelInterfaces.setLayout(new CardLayout());
        
        panelContenidos.add(panelInterfaces,BorderLayout.CENTER);


////////////////////////////////////////////////////////////////////////////////
//////////        DECLARACIÓN CONTENEDOR JPanel interface1         /////////////
        interface1=new JPanel();
        //ASIGNACIÓN ADMINISTRADOR DE LAYOUT BorderLayout
        interface1.setLayout(new BorderLayout());
        
        
//////////DECLARACIÓN COMPONENTE JLabel imagenUIB 
        JLabel imagenUIB=new JLabel(new ImageIcon("imagen.jpg"));    
        //INTRODUCCIÓN COMPONENTE JLabel imagenUIB EN EL CONTENEDOR JPanel interface1
        //EN LA ZONA CENTRAL DEL ADMINISTRADOR BorderLayout
        interface1.add(imagenUIB,BorderLayout.CENTER);  
        
        //INTRODUCCIÓN CONTENEDOR interface1 EN EL CONTENEDOR panelInterfaces
        //ASOCIADO AL LITERAL "INTERFACE 1"
        panelInterfaces.add(interface1,"PANEL 1");
        
////////////////////////////////////////////////////////////////////////////////
//////////       DECLARACIÓN CONTENEDOR JPanel interface2          /////////////
        interface2=new JPanel();
        //ASIGNACIÓN ADMINISTRADOR DE LAYOUT BorderLayout
        interface2.setLayout(new GridLayout(4,4,2,2));
        
        
//////////DECLARACIÓN ARRAY COMPONENTES JButton
        JButton [] botones=new JButton[16];
        for (int indice=0;indice<botones.length;indice++) {
            botones[indice]=new JButton("BOTÓN "+(indice+1));
            botones[indice].setBackground(new Color(new Random().nextInt(256),
                                                    new Random().nextInt(256),
                                                    new Random().nextInt(256)));
            interface2.add(botones[indice]);
        }
        
        //INTRODUCCIÓN CONTENEDOR interface2 EN EL CONTENEDOR panelInterfaces
        //ASOCIADO AL LITERAL "INTERFACE 2"
        panelInterfaces.add(interface2,"PANEL 2");
        
////////////////////////////////////////////////////////////////////////////////
//////////       DECLARACIÓN CONTENEDOR Dibujo interface3          /////////////
        interface3=new Dibujo();
  
        //INTRODUCCIÓN CONTENEDOR interface3 EN EL CONTENEDOR panelInterfaces
        //ASOCIADO AL LITERAL "INTERFACE 3"
        panelInterfaces.add(interface3,"PANEL 3");        
      
        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.pack();
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }    


    
    private class Dibujo extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            //Utilizamos Graphics2D para la visualización
            Graphics2D g2 = (Graphics2D) g;      
            
            Rectangle2D rectangulo=new Rectangle2D.Double(0,0,
                                            ventana.getWidth(),ventana.getHeight());
            g2.setColor(Color.red);
            g2.fill(rectangulo);
        }
    }
    
        private class manipuladorEventosFuncionalidades implements ActionListener {
        Color color;
        @Override
        public void actionPerformed(ActionEvent evento)  { 
                CardLayout local = (CardLayout)(panelInterfaces.getLayout());
                switch (evento.getActionCommand()) {
                    case "INTERFACE 1":     //visualización en el panelInterfaces del
                                            //contenedor asociado al literal "INTERFACE 1"
                                            local.show(panelInterfaces, "PANEL 1");
                                            break;
                    case "INTERFACE 2":     //visualización en el panelInterfaces del
                                            //contenedor asociado al literal "INTERFACE 2"
                                            local.show(panelInterfaces, "PANEL 2");
                                            break;
                    case "INTERFACE 3":     //visualización en el panelInterfaces del
                                            //contenedor asociado al literal "INTERFACE 3"
                                            local.show(panelInterfaces, "PANEL 3");
                                            break;
                }

    }}; 
}
