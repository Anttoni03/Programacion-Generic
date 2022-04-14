/*
FUNCIONALIDAD:
EJEMPLO ADMINISTRADOR DE LAYOUT FlowLayout

OBJETIVO: ilustración introducción administradores de
layouts swing

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IlustracionGraficos_16_v2 {
    //declaración método main
    public static void main(String[] args){
        new IlustracionGraficos_16_v2().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal(){
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 16");    

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos con una justificación a la derecha
        //y espaciados horizontal y vertical de 40 y 60 respectivamente
        panelContenidos.setLayout(new FlowLayout(FlowLayout.RIGHT,40,60));     
        
        

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////        
//////////declaración array de componentes JButton
        JButton [] botones=new JButton[10];
        //bucle declaraciones componentes JButton del array botones
        for (int indice=0;indice<botones.length;indice++) {
            botones[indice]=new JButton("BOTON "+(indice+1));
        }
        
        //bucle introducción de las componentes JButton del array botones7
        //en el contenedor ventana
        for (int indice=0;indice<botones.length;indice++) {
            ventana.add(botones[indice]);
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

