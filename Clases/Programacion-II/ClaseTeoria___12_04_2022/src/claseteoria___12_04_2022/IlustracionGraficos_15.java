/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE JColorChooser
Se utiliza para la elección de color interactivamente a través de ventana
de selección

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JColorChooser

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IlustracionGraficos_15 extends JFrame {

    //constructor
    public IlustracionGraficos_15() {
        super( "ILUSTRACIÓN GRÁFICOS 15" );
        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////   
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());    

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JButton     /////////////
        JButton boton = new JButton( "POR FAVOR, PULSA PARA CAMBIAR MI COLOR" );
        //INTRODUCCIÓN COMPONENTE JButton boton EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(boton);
        //ASIGNACIÓN DEL GESTOR DE EVENTO A LA COMPONENTE JButton boton
        boton.addActionListener(new ActionListener(){
            // mostrar JColorChooser cuando el usuario haga clic en el botón
            @Override
            public void actionPerformed( ActionEvent evento ) {
                Color color = JColorChooser.showDialog(null, "SELECCIONE UN COLOR", 
                        Color.LIGHT_GRAY );
                // establecer color predeterminado, si no se devuelve un color
                // Si no se ha seleccionado ningún color por defecto se asigna el
                //color rojo
                if ( color == null ) color = Color.RED;
                // cambiar color de fondo del botón con el color seleccionado
                boton.setBackground(color);
            }
        });
        
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

    public static void main( String args[] ) {
        IlustracionGraficos_15 aplicacion = new IlustracionGraficos_15();
    }
}
