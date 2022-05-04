/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN ItemListener PARA TRATAMIENTO EVENTO ItemEvent
CON COMPONENTE JComboBox

autor: Juan Montes de Oca
 */

package programaciongrafica__eventos;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class  eventos_ItemListener {
    //declaración método main
    public static void main(String[] args) { 
        new eventos_ItemListener().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal() {    
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame();  
        //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
        ventana.setTitle("ILUSTRACIÓN ItemListener");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout()); 
        //ASIGNAR COLOR DE FONDO AL PANEL DEL CONTENIDOS panelContenidos
        panelContenidos.setBackground(Color.WHITE);


////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////       DECLARACIÓN Y DEFINICIONES COMPONENTE JLabel      /////////////  
        JLabel etiqueta= new JLabel("ELIGE UN COLOR DE LA LISTA PARA CAMBIAR EL"
                + " COLOR DEL FONDO DE LA VENTANA");
        //Introducción de la componente JButton boton al panel de contenidos del
        //contenedor ventana
        panelContenidos.add(etiqueta);
 
//////////     DECLARACIÓN Y DEFINICIONES COMPONENTE JComboBox     ///////////// 
        //declaración array de Strings para definir las opciones de la componente
        //JComboBox lista
        String [] opciones={"ROJO","AZUL","AMARILLO","VERDE","CYAN",
            "MAGENTA","BLANCO","ROSA","NARANJA"};
        //declaración componente JComboBox
        JComboBox lista= new JComboBox(opciones);
        //selección opción BLANCO de la componente JComboBox
        lista.setSelectedIndex(6);
        //Introducción de la componente JButton boton al panel de contenidos del
        //contenedor ventana
        panelContenidos.add(lista);

        
//////////DECLARACIÓN GESTOR DE EVENTOS ItemEvent CON LA INTERFACE ItemListener
        //ASOCIÁNDOLO A LA COMPONENTE JComboBox lista
        lista.addItemListener(new ItemListener() {
            //TRATAMIENTO DEL EVENTO ItemEvent
            @Override
            public void itemStateChanged(ItemEvent evento) {
                //declaración variable Color local colorFondo
                Color colorFondo=Color.BLACK;
                //declaración array de componentes Color con los colores que
                //se corresponden, por posición, con las componentes del
                //array de opciones de la componente JComboBox lista
                Color [] colores={Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN,Color.CYAN,
                    Color.MAGENTA,Color.WHITE,Color.PINK,Color.ORANGE};
                //obención de la componente donde se ha generado el evento ItemEvent
                JComboBox combo = (JComboBox) evento.getSource();
                //bucle de búsqueda de la opción del array opciones con la opción 
                //elegida de la componente JComboBox y que ha causado el evento ItemEvent
                for (int i=0; i<opciones.length;i++) {
                    if (opciones[i]==combo.getSelectedItem()) {
                        //una vez detectada la componente del array opciones
                        //que coincide con la opción elegida, asignamos
                        //a la variable colorFondo la componente del array colores
                        //por correspondencia posicional
                        colorFondo=colores[i];
                        break;
                    }
                }
                //cambio del color del fondo del panel de contenidos con el
                //color asignado a colorFondo
                panelContenidos.setBackground(colorFondo);
            }
        } 
        );
        
        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(500,300);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}