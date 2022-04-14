/*
FUNCIONALIDAD:
EJEMPLO COMPONENTES JTextField y JPasswordField

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JTextField y JPasswordField.

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ventana_IlustracionGraficos_11 extends JFrame {
    //DECLARACIONES ATRIBUTOS
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JTextField campoTexto3;
    private JPasswordField campoPalabraClave;

    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public ventana_IlustracionGraficos_11() {
        //invocación construtor de la clase madre JFrame
        super("ILUSTRACIÓN COMPONENTES JTextField y JPasswordField");
   
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());    

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////      DECLARACIONES Y DEFINICIONES COMPONENTE JLabel     /////////////
        //declaración componente JLabel asignándole el literal que visualizará
        JLabel etiqueta= new JLabel("INTERACTUAR CON LAS SIGUIENTES "
                + "COMPONENTES FINALIZANDO CON RETURN  >>>  ");
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(etiqueta);

///// DECLARACIONES Y DEFINICIONES COMPONENTES JTextField y JPasswordField /////
        //declaración componente JTextField vacia (el campo aparece
        //vacio a la espera de introducción de un texto por parte del usuario
        //cuando interactue sobre él)
        campoTexto1 = new JTextField(10);
        //INTRODUCCIÓN COMPONENTE JTextField campoTexto1 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(campoTexto1);
        //asignación de un gestor de eventos a la componente JTextField campoTexto1.
        //EL gestor de eventos será un objeto de la clase gestorEventos.
        campoTexto1.addActionListener(new gestorEventos());
        
        
        //declaración componente JTextField con texto de indicación (el campo aparece
        //con un literal que representa una indicación a la espera de introducción 
        //de un texto por parte del usuario cuando interactue sobre él)
        campoTexto2 = new JTextField("INTRODUZCA UN TEXTO AQUÍ");       
        //INTRODUCCIÓN COMPONENTE JTextField campoTexto2 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(campoTexto2);
        //asignación de un gestor de eventos a la componente JTextField campoTexto2.
        //EL gestor de eventos será un objeto de la clase gestorEventos.
        campoTexto2.addActionListener(new gestorEventos());

        
        //declaración componente JTextField con texto de indicación (el campo aparece
        //con un literal que representa una indicación)
        campoTexto3 = new JTextField( "CAMPO DE TEXTO NO EDITABLE");
        //desactivar edición interactiva de la compoenente campoTexto3
        campoTexto3.setEditable(false);      
        //INTRODUCCIÓN COMPONENTE JTextField campoTexto3 EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(campoTexto3);
        //asignación de un gestor de eventos a la componente JTextField campoTexto3.
        //EL gestor de eventos será un objeto de la clase gestorEventos.
        campoTexto3.addActionListener(new gestorEventos());

        
        //declaración componente JPasswordField que representa un campo de contraseña 
        //con una palabra clave predeterminado
        campoPalabraClave = new JPasswordField("CONTRASEÑA OCULTA");
        //INTRODUCCIÓN COMPONENTE JPasswordField campoPalabraClave EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(campoPalabraClave);
        //asignación de un gestor de eventos a la componente JPasswordField campoPalabraClave.
        //EL gestor de eventos será un objeto de la clase gestorEventos.
        campoPalabraClave.addActionListener(new gestorEventos());



////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        pack();
        //CENTRADO DEL CONTENEDOR JFrame EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame
        setVisible(true);
    }
    

    //CLASE INTERNA PARA LA GESTIÓN DE EVENTOS ActionListener
    private class gestorEventos implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent ev) {
            String cadena = "";
            JTextField [] entidades={campoTexto1,campoTexto2,campoTexto3,campoPalabraClave};
            String [] literales={"Campo Texto 1: ","Campo Texto 2: ","Campo Texto 3: ","Campo Contraseña: "};
            int indice=0;
            for (;ev.getSource()!=entidades[indice];indice++);
            cadena=literales[indice]+ev.getActionCommand();
            System.out.println(cadena);    
            JOptionPane.showMessageDialog(null, cadena,"RESULTADOS",JOptionPane.CANCEL_OPTION);
        } 
    } 
}
