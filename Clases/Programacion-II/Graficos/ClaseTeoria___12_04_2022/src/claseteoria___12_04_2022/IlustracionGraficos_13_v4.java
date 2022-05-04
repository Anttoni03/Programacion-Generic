/*
FUNCIONALIDAD:
EJEMPLO JOptionPane
Se utiliza para crear ventanas de diálogo.

OBJETIVO: ilustración introducción componentes swing JAVA

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class IlustracionGraficos_13_v4 {
    //DECLARACIONES
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_13_v4().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 13");       

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());             


////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN JOpcionPane                               //
////////////////////////////////////////////////////////////////////////////////
        //DECLARACIÓN ARRAY DE COMPONENTES String PARA DEFINIR LAS OPCIONES DE
        //JOptionPane
        String [] opciones={"VERANO","OTOÑO","INVIERNO","PRIMAVERA"};
        //DECLARACIÓN VARIABLE int PARA ALMACENAR EL VALOR INTRODUCIDO A
        //TRAVÉS DEL MÉTODO showOptionDialog DE JOptionPane
        int respuesta=JOptionPane.showOptionDialog(ventana, //contenedor padre
                                        "¿ CUÁL ES TU ESTACIÓN PREFERIDA ?", //texto visualizado 
                                          "SOY UN EJEMPLO DEL MÉTODO"
                                        + "showOptionDialog DE JOptionPane\n",//título ventana                              
                                         JOptionPane.DEFAULT_OPTION,//tipo de ventana
                                         JOptionPane.QUESTION_MESSAGE,//tipo de mensaje
                                                                         // - ERROR_MESSAGE
                                                                         // - INFORMATION_MESSAGE
                                                                         // - WARNING_MESSAGE
                                                                         // - QUESTION_MESSAGE (por defecto)
                                                                         // - PLAIN_MESSAGE 
                                         null, //icono de la ventana
                                         opciones, //array de opciones
                                         opciones[0]);//botón por defecto                         
            
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////  
//////////DECLARACIÓN COMPONENTES JTextArea explicacion
        JTextArea explicacion=new JTextArea(
                  "Habéis visto un ejemplo de la utilización del método showOptionDialog\n"
                + "de un JOptionPane. Se crea una ventana que visualiza un mensaje dado\n"
                + "como parámetro y los botones e iconos definidos posibilitando la introducción\n"
                + "de una respuesta pulsando uno de los botones.\n\n "
                + "RESPUESTA PULSADA: "+opciones[respuesta]);
        //ASIGNACIÓN TIPOGRAFÍA A LA COMPONENTE JTextArea explicacion
        explicacion.setFont(new Font("Arial",Font.BOLD,25));
        //INTRODUCCIÓN COMPONENTE JTextArea explicacion EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(explicacion);
               
        
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
}
