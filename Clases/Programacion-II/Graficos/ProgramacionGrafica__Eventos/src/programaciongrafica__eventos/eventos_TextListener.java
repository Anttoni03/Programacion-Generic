/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN TextListener PARA TRATAMIENTO EVENTO TextEvent

ATENCIÓN: EN NetBeans TextListener NO ES APLICABLE A COMPONENTES DE
TEXTO SWING, POR ESO EN ESTE EJEMPLO UTILIZAMOS LA COMPONENTE awt TextField

autor: Juan Montes de Oca
 */

package programaciongrafica__eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class  eventos_TextListener {
    private TextField entradaTexto;
    
    //declaración método main
    public static void main(String[] args) { 
        new eventos_TextListener().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {    
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame();  
        //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
        ventana.setTitle("ILUSTRACIÓN TextListener");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());         
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JLabel      /////////////          
        JLabel etiqueta= new JLabel("CAMBIAR NOMBRE VENTANA: INTRODUCIR NUEVO NOMBRE ");
        //INTRODUCCIÓN COMPONENTE JLabel etiqueta EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(etiqueta);
        
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE TextField   ///////////// 
        entradaTexto= new TextField(50);
        //INTRODUCCIÓN COMPONENTE TextField entradaTexto EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(entradaTexto);
///////////DECLARACIÓN Y ASIGNACIÓN DEL GESTOR DE EVENTOS TextEvent A LA COMPONENTE
        //JTextField entradaTexto UTILIZANDO LA INTERFACE TextListener        
        entradaTexto.addTextListener(new TextListener() {     
            //TRATAMIENTO DEL EVENTO ItemEvent
            @Override
            public void textValueChanged(TextEvent evento) {
                //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
                ventana.setTitle(entradaTexto.getText());
            }            
       });
        

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(500,100);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
    
}