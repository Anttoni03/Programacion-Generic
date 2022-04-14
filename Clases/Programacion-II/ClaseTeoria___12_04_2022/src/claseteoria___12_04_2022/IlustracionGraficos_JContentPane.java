/*
FUNCIONALIDAD:
ILUSTRACIÓN DE UTILIZACIÓN DEL PANEL JContentPane DE UN JFrame
Es recomendable utilizar JFrame.getContentPane().add() en lugar de JFrame.add()
para introducir componentes en el JFrame, pues, de esta manera estaremos
trabajando directamente con el panel de contenidos JContentPane.
Normalmente todas las componentes las introduciremos en el panel JContentPane a
excepción de las componentes JMenuBar.

OBJETIVO: ilustración introducción componentes swing JAVA

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;


public class  IlustracionGraficos_JContentPane {
    //declaración método main
    public static void main(String[] args) { 
        new IlustracionGraficos_JContentPane().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {    
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        //declaración contenedor JFrame ventana
        JFrame ventana=new JFrame();
        //asignación literal al contenedor ventana
        ventana.setTitle("ILUSTRACIONES SWING");
        //definición dimensión contenedor ventana
        ventana.setSize(250,200);
        //asignación del gestor de layout FlowLayout al contenedor ventana
        ventana.setLayout(new FlowLayout());
        
        //declaración panel de contenidos del JFrame, en este panel es donde
        //introduciremos, normalmente, todas las componentes, a excepción de
        //JMenuBar
        Container panelContenidos=ventana.getContentPane();

        //DECLARACIONES Y DEFINICIONES COMPONENTES JButton
        //declaración componente JButton boton1 asignándole la etiqueta "ACEPTAR"
        JButton boton= new JButton("BOTON");
        //asignación del color rojo al fondo de la componente boton
        boton.setBackground(Color.RED);
        //asignación del color blanco como color de trazado de la componente boton
        boton.setForeground(Color.WHITE);

        //Introducción de la componente JButton boton1 en el panel de contenidos
        //del contenedor JFrame
        panelContenidos.setBackground(Color.yellow);
        panelContenidos.add(boton);

        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }
}