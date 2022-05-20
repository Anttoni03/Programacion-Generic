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
import javax.swing.*;

public class IlustracionGraficos_13 {
    //DECLARACIONES
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_13().metodoPrincipal();
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
        //DECLARACIONES PARA PRIMER JOptionPane
        //String que contiene los literales de todos los botones del menu1
        String[] menu1 = {"Opcion1", "Opcion2","Mensaje Simple","Otro Menú",
            "PideCadena","PideEntero","Salir"};
        
        //variable entera para almacenar la opción elegida del menu del primer 
        //JOptionPane
        int opcion1;
        //GESTIÓN MENU PRIMER JOptionPane
        do{
            opcion1= JOptionPane.showOptionDialog(null, //contenedor por defecto: Frame
                                                 "Selecciona una opción", //texto visualizado
                                                 "Ejemplos con JOptionPane", //titulo de la ventana
                                                 JOptionPane.YES_NO_CANCEL_OPTION,//tipo de ventana
                                                                                  //YES_NO_OPTION, 2 botones Si y No
                                                                                  //YES_NO_CANCEL_OPTION, 3 botones Si, No y Cancelar
                                                                                  //OK_CANCEL_OPTION, 2 botones Ok y Cancelar (Default)
                                                 JOptionPane.QUESTION_MESSAGE, //tipo de mensaje
                                                                               // - ERROR_MESSAGE
                                                                               // - INFORMATION_MESSAGE
                                                                               // - WARNING_MESSAGE
                                                                               // - QUESTION_MESSAGE (por defecto)
                                                                               // - PLAIN_MESSAGE
                                                 null, //icono de la caja
                                                 menu1, //lista de botones
                                                 menu1[0]); //botón por default

            switch(opcion1) {
                case 0: System.out.println("Seleccionó la Opción 1");
                        break;
                case 1: System.out.println("Seleccionó la Opción 2");
                        break;
                case 2: JOptionPane.showMessageDialog(null,"Hola Mundo");
                        break;
                case 3: //DECLARACIONES PARA SEGUNDO JOptionPane
                        //String que contiene los literales de todos los botones del menu1
                        String[] menu2 = {"Opción 1","Opción 2","Salir"};
                        //variable entera para almacenar la opción elegida del menu del segundo
                        //JOptionPane
                        int opcion2;
                        //GESTIÓN MENU SEGUNDO JOptionPane
                        do{
                            opcion2 = JOptionPane.showOptionDialog(null,
                                                                   "Selecciona una opción",
                                                                   "JOptionPane.showOptionDialog",
                                                                   JOptionPane.YES_NO_CANCEL_OPTION,
                                                                   JOptionPane.INFORMATION_MESSAGE,
                                                                   null,
                                                                   menu2,
                                                                   menu2[0]);

                            switch(opcion2) {
                            case 0: System.out.println("Seleccionó la Opción 1");
                                    break;
                            case 1: System.out.println("Seleccionó la Opción 2");
                                    break;
                            case 2:
                                    opcion2 = -1;
                                    break;
                            }

                        }while(opcion2 != (-1));
                        break;

                case 4: //Solicitud cadena de caracteres
                        String input = "";
                        try {
                            input = JOptionPane.showInputDialog("Escribe algo");
                        }catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error");
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Cadena: " + input);
                        break;
                case 5: //solicitud número entero
                        int entero = 0;
                        try {
                            entero = Integer.parseInt(JOptionPane.showInputDialog("Escribe un entero"));
                        } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error");
                                break;
                                }
                        JOptionPane.showMessageDialog(null, "Número: " + entero);
                        //Se pueden hacer operaciones como siempre
                        if(entero < 5) {
                            JOptionPane.showMessageDialog(null, "El Núumero: " + entero + " es menor a 5");
                        }
                        break;
                case 6: //Salir del programa
                    System.exit(0);
                        opcion1 = -1;
                        break;
            }
        } while(opcion1 != (- 1) );
        
        
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
