/*
FUNCIONALIDAD: ventana con una resolución equivalente a la mitad de la pantalla
y visualizada en el centro de ésta. Como componentes aparecen una JTextArea
(con varias lineas de texto y con fondo de color amarillo y trazado de color
rojo) y una JLabel (etiqueta) con el texto "ESTO ES UNA ETIQUETA" de color azul.

DISEÑO INTERFACE: ver PDF interface_2.pdf

autor: Juan Montes de Oca
 */

package programasimplementacioninterfaces_1;

import javax.swing.*;
import java.awt.*;

////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                             CLASE interface_2                              //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////  

public class interface_2 {
    //declaración método main
    public static void main(String[] args) { 
        new interface_2().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() { 
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("MI PRIMERA VENTANA");
        //DECLARACIÓN OBJETO Dimension PARA OBTENER LA DIMENSIÓN DE LA PANTALLA
        //EN LA QUE ESTEMOS EJECUTANDO
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        //DECLARACIÓN VARIABLES ENTERAS Y ASIGNACIÓN EN ELLAS DE LA RESOLUCIÓN
        //HORIZONTAL Y VERTICAL DE LA PANTALLA
        int dimensionX=(int) dimension.getWidth();
        int dimensionY=(int) dimension.getHeight();
        //DIMENSIONAR EL CONTENEDOR JFrame ventana CON LA MITAD DE LA RESOLUCIÓN
        //DE LA PANTALLA
        ventana.setSize(dimensionX/2, dimensionY/2);  

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane(); 
        panelContenidos.setLayout(new FlowLayout());

        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////      DECLARACIÓN Y DEFINICIONES COMPONENTE jTextArea    /////////////        
        JTextArea areaTexto = new JTextArea(); 
        //CAMBIO DEL COLOR DE FONDO/TRAZADO DE LA COMPONENTE JTextArea areaTexto
        areaTexto.setBackground(Color.yellow);
        areaTexto.setForeground(Color.RED);
        //ASIGNACIÓN TEXTO A LA COMPONENTE JTextArea areaTexto
        areaTexto.setText("soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea\n"
                + "soy un texto dentro de una componente JTextArea");
        //INTRODUCCIÓN COMPONENTE JTextArea areaTexto EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(areaTexto);
        

//////////      DECLARACIÓN Y DEFINICIONES COMPONENTE jTextArea    /////////////  
        JLabel etiqueta=new JLabel("ESTO ES UNA ETIQUETA");
        //ASIGNACIÓN COLOR TRAZADO A LA COMPONENTE JLabel etiqueta
        etiqueta.setForeground(Color.BLUE);
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(etiqueta);


////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}
