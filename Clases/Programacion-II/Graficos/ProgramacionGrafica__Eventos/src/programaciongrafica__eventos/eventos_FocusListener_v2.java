/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN FocusListener PARA TRATAMIENTO EVENTO FocusEvent

autor: Juan Montes de Oca
 */
package programaciongrafica__eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class eventos_FocusListener_v2 {
    //DECLARACIONES ATRIBUTOS
    private JTextField nombre, nif;
    private JLabel anotacion1, anotacion2;
    
    //declaración método main
    public static void main(String[] args) { 
        new eventos_FocusListener_v2().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN CONTENEDOR JFrame                          //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame();  
        //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
        ventana.setTitle("EJEMPLO EVENTOS DE FOCO");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN ADMINISTRADOR BorderLayout AL PANEL DE CONTENIDOS panelContenidos
        panelContenidos.setLayout(new BorderLayout());
 
        
////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN CONTENEDORES JPanel                        //
//////////////////////////////////////////////////////////////////////////////// 
/////////////    DECLARACIÓN CONTENEDOR JPanel panelSuperior    ////////////////
        JPanel panelSuperior=new JPanel();
        //ASIGNACIÓN ADMINISTRACIÓN FlowLayout  A LA CONTENEDOR JPanel panelSuperior 
        //CON JUSTIFICACIÓN A LA IZQUIERDA
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        //DEFINICIÓN DE LOS MÁRGENES TOP, LEFT, BOTTOM Y RIGHT DEL BORDE DEL
        //CONTENEDOR JPanel panelSuperior
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        //INTRODUCCIÓN EN EL CONTENEDOR PANEL DE CONTENIDOS DEL CONTENEDOR 
        //JPanel panelSuperior EN EL AREA NORTE DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(panelSuperior,BorderLayout.NORTH);
        
        
/////////////    DECLARACIÓN CONTENEDOR JPanel panelInferior    ////////////////        
        JPanel panelInferior=new JPanel();
        //ASIGNACIÓN ADMINISTRACIÓN FlowLayout  A LA CONTENEDOR JPanel panelInferior 
        //CON JUSTIFICACIÓN A LA IZQUIERDA
        panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
        //DEFINICIÓN DE LOS MÁRGENES TOP, LEFT, BOTTOM Y RIGHT DEL BORDE DEL
        //CONTENEDOR JPanel panelInferior
        panelInferior.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));  
        //INTRODUCCIÓN EN EL CONTENEDOR PANEL DE CONTENIDOS DEL CONTENEDOR 
        //JPanel panelInferior
        panelContenidos.add(panelInferior);
        //INTRODUCCIÓN EN EL CONTENEDOR PANEL DE CONTENIDOS DEL CONTENEDOR 
        //JPanel panelInferior EN EL AREA CENTRAL DEL ADMINISTRADOR BorderLayout
        panelContenidos.add(panelInferior,BorderLayout.CENTER);
        

////////////////////////////////////////////////////////////////////////////////
//                         DECLARACIÓN COMPONENTES                            //
//////////////////////////////////////////////////////////////////////////////// 
//////////DELARACIÓN COMPONENTE JLabel etiqueta1 CON JUSTIFICACIÓN IZQUIERDA
        JLabel etiqueta1=new JLabel("NOMBRE ESTUDIANTE",JLabel.LEFT);
        //INTRODUCCIÓN EN EL CONTENEDOR JPanel panelSuperior DE LA COMPONENTE
        //JLabel etiqueta1
        panelSuperior.add(etiqueta1);
        
//////////DELARACIÓN COMPONENTE JTextField nombre        
        nombre=new JTextField(20);
        //INTRODUCCIÓN EN EL CONTENEDOR JPanel panelSuperior DE LA COMPONENTE
        //JTextField nombre
        panelSuperior.add(nombre);
        //ASIGNACIÓN GESTOR DE EVENTOS FocusEvent A LA COMPONENTE JTextField
        //nombre CON LA INTERFACE FocusListener
        nombre.addFocusListener(new gestorEventoFoco());      
        
//////////DELARACIÓN COMPONENTE JLabel anotacion1         
        anotacion1=new JLabel("                         ");
        //INTRODUCCIÓN EN EL CONTENEDOR JPanel panelSuperior DE LA COMPONENTE
        //JLabel anotacion1
        panelSuperior.add(anotacion1);
        
//////////DELARACIÓN COMPONENTE JLabel etiqueta2 CON JUSTIFICACIÓN IZQUIERDA
        JLabel etiqueta2=new JLabel("NIF ESTUDIANTE           ",JLabel.LEFT);
        //INTRODUCCIÓN EN EL CONTENEDOR JPanel panelInferior DE LA COMPONENTE
        //JLabel etiqueta1
        panelInferior.add(etiqueta2);
        
//////////DELARACIÓN COMPONENTE JTextField nif        
        nif=new JTextField(20);
        //INTRODUCCIÓN EN EL CONTENEDOR JPanel panelInferior DE LA COMPONENTE
        //JTextField nif
        panelInferior.add(nif);   
        //ASIGNACIÓN GESTOR DE EVENTOS FocusEvent A LA COMPONENTE JTextField
        //nif CON LA INTERFACE FocusListener
        nif.addFocusListener(new gestorEventoFoco());   
        
//////////DELARACIÓN COMPONENTE JLabel anotacion2         
        anotacion2=new JLabel("                         ");
        //INTRODUCCIÓN EN EL CONTENEDOR JPanel panelInferior DE LA COMPONENTE
        //JLabel anotacion2
        panelInferior.add(anotacion2);

        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(560,100);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
    
    private class gestorEventoFoco implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            if(e.getSource() == nombre){
                anotacion1.setText("INTRODUCE TU NOMBRE");
            }
            if(e.getSource() == nif){
                anotacion2.setText("INTRODUCE TU NIF   ");
            }

        }
        @Override
        public void focusLost(FocusEvent e) {
            if(e.getSource() == nombre){
                anotacion1.setText("                   ");
            }
            if(e.getSource() == nif){
                anotacion2.setText("                   ");
            }

        }        
    }
}

