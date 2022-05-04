/*
FUNCIONALIDAD:
EJEMPLO EVENTOS DEL RATÓN

OBJETIVO: ilustración introducción  swing JAVA

autor: Juan Montes de Oca
 */
package interfacesgraficasusuario_ii;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class IlustracionGraficos_29 extends JFrame {
    //MÉTODO CONSTRUCTOR
    public IlustracionGraficos_29(){
        super("EVENTOS DEL RATÓN");
        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();
 

        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
///////////DECLARACIÓN  Y CONFIGURACIÓN COMPONENTE JLabel etiqueta
        JLabel etiqueta= new JLabel("");
        //INTRODUCCIÓN EN EL PANEL DE CONTENIDOS panelContenidos DE LA
        //COMPONENTE JLabel etiqueta
        panelContenidos.add(etiqueta);


////////////////////////////////////////////////////////////////////////////////
//                          GESTOR DE EVENTOS                                 //
////////////////////////////////////////////////////////////////////////////////
//////////       GESTOR DE EVENTOS DEL RATÓN MouseMotionListener      //////////
        addMouseMotionListener(new MouseMotionAdapter() {
            //MÉTODO INVOCADO CUANDO SE PULSA UN BOTÓN DEL RATÓN CON DESPLAZAMIENTO
            @Override
            public void mouseDragged(MouseEvent eventoRaton) { 
                etiqueta.setText("    [] coordenadas del raton: (" + 
                        Integer.toString(eventoRaton.getX()) +", " +
                        Integer.toString(eventoRaton.getY()) +")       ");
                System.out.println("RATÓN EN MOVIMIENTO CON BOTÓN PULSADO");
            }   

            //MÉTODO INVOCADO CUANDO SE DESPLAZA RATÓN SIN PULSAR NINGÚN BOTÓN
            @Override
            public void mouseMoved(MouseEvent e) {// cuando se está desplazando el ratón sin ningún botón pulsado
                etiqueta.setText("    [] coordenadas del raton: (" + 
                        Integer.toString(e.getX()) +", " +
                        Integer.toString(e.getY()) +")       ");
                System.out.println("RATÓN EN MOVIMIENTO SIN BOTÓN PULSADO");
            }
        });


//////////            GESTOR DE EVENTOS DEL RATÓN MouseListener       //////////
        addMouseListener(new MouseListener() {
            //MÉTODO INVOCADO CUANDO SE LLEVA A CABO UN CLICK EN ALGÚN BOTÓN DEL RATÓN
            public void mouseClicked(MouseEvent e) {
                    System.out.println("CLICK");
            }

            //MÉTODO INVOCADO CUANDO EL CURSOR DEL RATÓN ENTRA EN EL ÁREA DE LA SUPERFICIE
            //DEL CONTENEDOR/COMPONENTE ASOCIADO
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("RATÓN ENTRA EN LA VENTANA");
            }

            //MÉTODO INVOCADO CUANDO EL CURSOR DEL RATÓN SALE DEL ÁREA DE LA SUPERFICIE
            //DEL CONTENEDOR/COMPONENTE ASOCIADO
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("RATÓN SALE DE LA VENTANA");
            }

            //MÉTODO INVOCADO CUANDO UN BOTÓN DEL RATÓN ES PULSADO
            @Override
            public void mousePressed(MouseEvent eventoRaton) {
                switch (eventoRaton.getButton()) {
                    case 1: {
                            System.out.println("BOTON IZQUIERDO PULSADO");
                            break;}
                    case 2: {
                            System.out.println("BOTON CENTRAL PULSADO");
                            break;}
                    case 3: 
                            System.out.println("BOTON DERECHO PULSADO");
                            break;
                }

            }

            //MÉTODO INVOCADO CUANDO UN BOTÓN DEL RATÓN ES SOLTADO (se deja de pulsar)
            @Override
            public void mouseReleased(MouseEvent eventoRaton) {
                  switch (eventoRaton.getButton()) {
                    case 1: 
                        System.out.println("BOTON IZQUIERDO SOLTADO");
                        break;
                    case 2: 
                        System.out.println("BOTON CENTRAL SOLTADO");
                        break;
                    case 3: 
                        System.out.println("BOTON DERECHO SOLTADO");
                        break;
                    }
            }
        });

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

    //MÉTODO main
    public static void main(String args[]) {
            IlustracionGraficos_29 aplicacion = new IlustracionGraficos_29();
    }
}