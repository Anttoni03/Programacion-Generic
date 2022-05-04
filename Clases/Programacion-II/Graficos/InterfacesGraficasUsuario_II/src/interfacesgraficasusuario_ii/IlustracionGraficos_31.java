/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE Choice

OBJETIVO: ilustración introducción componentes swing JAVA

autor: Juan Montes de Oca
 */
package interfacesgraficasusuario_ii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IlustracionGraficos_31 {
    //declaración método main
    public static void main(String[] args) { 
        new IlustracionGraficos_31().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("EJEMPLO COMPONENTE CHOICE");

        //redimensionamiento contenedor JFrame ventana
        ventana.setSize(300, 150);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();
        //asignación administrador de layout FlowLayout al panel de contenidos
        panelContenidos.setLayout(new FlowLayout());

        
        //DECLARACIÓN COMPONENTE Choice
        Choice selecciones=new Choice();
        //introducción objetos String en la componente Choice
        selecciones.add("PRIMERA ELECCIÓN");
        selecciones.add("SEGUNDA ELECCIÓN");
        selecciones.add("TERCERA ELECCIÓN");
        //activamos la tercera selección de la componente Choice
        selecciones.select("TERCERA ELECCIÓN");
        
        //ASIGNACIÓN GESTOR DE EVENTONS ItemListener a la componente
        //Choice
        selecciones.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {
                System.out.println(selecciones.getSelectedItem() );
            }
        });  
        
        //INTRODUCCIÓN COMPONENTE Choice EN EL PANEL DE CONTENIDOS
        //DEL CONTENEDOR JFrame
        panelContenidos.add(selecciones);

        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //activación cierre ejecución con salida ventana de windows
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // VISUALIZACION del contenedor JFrame ventana
        ventana.setVisible(true);
    }
}

