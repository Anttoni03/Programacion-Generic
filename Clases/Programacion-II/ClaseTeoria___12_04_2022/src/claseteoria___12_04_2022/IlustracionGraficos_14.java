/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE JFileChooser
Se utiliza para crear ventanas de diálogo simples y estándar

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JFileChooser.

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;

public class IlustracionGraficos_14 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_14().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 14");      

        
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
//////////   DECLARACIONES Y DEFINICIONES COMPONENTE JFileChooser  /////////////        
        //DECLARACIÓN COMPONENTE JFileChooser
        JFileChooser ventanaSeleccion=new JFileChooser();

        //CREACIÓN Y APERTURA VENTANA DE DIRECTORIOS Y FICHEROS
        int op=ventanaSeleccion.showOpenDialog(ventana);
        if(op==JFileChooser.APPROVE_OPTION) 
        {
            //visualización directorio/fichero seleccionado interactivamente
            System.out.println(ventanaSeleccion.getSelectedFile());
            //cerrar contenedor JFrame y finalizar aplicación
            System.exit(0);
        }
        

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