/*
FUNCIONALIDAD:
ILUSTRACIÓN EVENTOS DEL TECLADO

OBJETIVO: ilustración introducción swing JAVA

autor: Juan Montes de Oca
 */

package interfacesgraficasusuario_ii;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class IlustracionGraficos_26_v2 extends JFrame {
    //DECLARACIÓN DE ATRIBUTOS
    private String linea1 = "", linea2 = "", linea3 = "";
    private JTextArea areaTexto;
    
    //MÉTODO CONSTRUCTOR
    public IlustracionGraficos_26_v2() {
        super("EJEMPLOS EVENTOS DEL TECLADO");
        

/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();

////////////////////////////////////////////////////////////////////////////////
//                          GESTOR DE EVENTOS                                 //
////////////////////////////////////////////////////////////////////////////////
/////////INSTANCIACIÓN OBJETO DE LA CLASE GestorEventosTeclado
        GestorEventosTeclado gestorEventos = new GestorEventosTeclado();


        //ASIGNACIÓN DEL GESTOR DE EVENTOS gestorEventos DEL TECLADO AL CONTENEDOR JFrame
        addKeyListener(gestorEventos);
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
///////////DECLARACIÓN  Y CONFIGURACIÓN COMPONENTE JTextArea areaTexto
        areaTexto = new JTextArea(10,15);
        //INTRODUCIR literal EN LA COMPONENTE JTextArea areaTexto
        areaTexto.setText("PULSE UNA TECLA");
        //DESACTIVAR LA INTERACCIÓN EN LA COMPONENTE JTextArea areaTexto
        areaTexto.setEnabled(false);
        //ASIGNAR COLOR DE TRAZADO TEXTO EN ESTADO DESAHILITADO
        areaTexto.setDisabledTextColor(Color.BLUE);
        //INTRODUCCIÓN EN EL PANEL DE CONTENIDOS panelContenidos DE LA
        //COMPONENTE JTextArea areaTexto
        panelContenidos.add(areaTexto);
        
////////////////////////////////////////////////////////////////////////////////
//                   ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                 //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame 
        setSize(400,200);
        //CENTRADO DEL CONTENEDOR JFrame EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame 
        setVisible(true);
    } 


    
////////////////////////////////////////////////////////////////////////////////
//                     CLASE GESTOR DE EVENTOS DEL TECLADO                    //
//////////////////////////////////////////////////////////////////////////////// 
    private class GestorEventosTeclado implements KeyListener {
        // getKeyText(int codigo_de_tecla) RETORNA UN STRING DEL NOMBRE DE LA TECLA CORRESPONDIENTE
        //                                 AL CÓDIGO (EJEMPLO: "A", "f1", ...)
        // getKeyCode() RETORNA EL ENTERO (ASCII) CORRESPONDIENTE AL CÓDIGO DE LA TECLA ASOCIADO A ESTE EVENTO.
        // getKeyChar() RETORNA EL CARACTER ASOCIADO CON LA TECLA (EJEMPLO: System.out.println(evento.getKeyChar());)

//////             GESTIÓN DEL EVENTO AL PULSAR CUALQUIER TECLA           //////
        @Override
        public void keyPressed(KeyEvent evento) {
            linea1 = "SE PULSÓ LA TECLA: " + evento.getKeyText(evento.getKeyCode());
            establecerLineas2y3(evento);
        }

//////             GESTIÓN DEL EVENTO AL SOLTAR CUALQUIER TECLA           //////
        @Override
        public void keyReleased(KeyEvent evento) {
            linea1 = "SE SOLTÓ LA TECLA: " + evento.getKeyText(evento.getKeyCode());
            establecerLineas2y3(evento);
        }

//  GESTIÓN DEL EVENTO AL PULSAR UNA TECLA QUE SE CORRESPONDA CON UN CARACTER //
        @Override
        public void keyTyped(KeyEvent evento) {
            // no hay nada
        }


//      MÉTODO PARA EL ESTABLECIMIENTO DE LA SEGUNDA Y TERCERA LINEA DE       //
//                                 VISUALIZACIÓN                              //
        private void establecerLineas2y3(KeyEvent evento) {
            //TECLAS DE ACCIÓN --> F1-F12, ImpPant, Inicio, Supr, etc..
            linea2 = "ESTA TECLA " + (evento.isActionKey() ? "" : "NO ") + "ES UNA TECLA DE ACCIÓN";
            String temp = evento.getKeyModifiersText(evento.getModifiers());
            //TECLAS MODIFICADORAS --> Ctrl, Shift, Alt, Ctrl+Alt
            linea3 = "TECLAS MODIFICADORAS PULSADAS: " + (temp.equals("") ? "NINGUNA" : temp);
            areaTexto.setText(linea1 + "\n" + linea2 + "\n" + linea3 + "\n");
        }
    } 
    
    //MÉTODO main
    public static void main( String args[] ) {
        IlustracionGraficos_26_v2 aplicacion = new IlustracionGraficos_26_v2();
    }
}
