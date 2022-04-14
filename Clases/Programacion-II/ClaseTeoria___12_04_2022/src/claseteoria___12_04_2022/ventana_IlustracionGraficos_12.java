/*
FUNCIONALIDAD:
EJEMPLO COMPONENTE JTextArea A TRAVÉS DEL CUAL PODEMOS COPIAR EL TEXTO DE UN 
AREA A OTRA PULSANDO UN BOTÓN

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JTextArea.

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ventana_IlustracionGraficos_12 extends JFrame {
    //DECLARACIÓN ATRIBUTOS
    private JTextArea area1, area2;
    private JButton botonCopiar;

    //MÉTODO CONSTRUCTOR
    public ventana_IlustracionGraficos_12() {
        //llamada al constructor de la clase JFrame (que es la clase
        //de la que procede)
        super("JTextArea");
 
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new FlowLayout());   
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////      DECLARACIONES Y DEFINICIONES COMPONENTE JTextArea     /////////////
        //DECLARACIÓN String PARA ALMACENAR EL TEXTO A INTRODUCIR EN LA COMPONENTE
        //JTextArea
        String texto = "Ésta es una cadena de\ndemostración para\n" +
        "ilustrar cómo copiar texto\nde un área de texto a \n" +
        "otra, utilizando un\nevento externo";

        //DECLARACIÓN COMPONENTE JTextArea area1 CON EL TEXTO DEL String texto
        area1 = new JTextArea(texto,10,15);
        //DECLARACIÓN CONTENEDOR JScrollPane Y ASOCIACIÓN CON ÉL DE LA COMPONENTE
        //JTextArea area1 PARA PRESTACIÓN DE BARRA DE DESPLAZAMIENTO CUANDO
        //LA SUPERFICIE DE LA COMPONENTE JTextArea area1 NO SEA SUFICIENTE
        //PARA LA VISUALIZACIÓN DE TODO EL TEXTO INTRIODUCIDO EN ELLA
        JScrollPane barraDesplazamiento1= new JScrollPane(area1);
        //INTRODUCCIÓN CONTENEDOR JScrollPane barraDesplazamiento1 EN EL PANEL 
        //DE CONTENIDOS panelContenidos
        panelContenidos.add(barraDesplazamiento1);

        
        //DECLARACIÓN COMPONENTE JButton
        botonCopiar = new JButton("COPIAR >>>");
        //INTRODUCCIÓN COMPONENTE JButton botonCopiar EN EL PANEL DE CONTENIDOS 
        //panelContenidos
        panelContenidos.add(botonCopiar);
        //asignamos el gestor de evento a la componente JButton botonCopiar
        botonCopiar.addActionListener(new ActionListener() { 
                // ASIGNA  area2 EL TEXTO DE area1
                public void actionPerformed(ActionEvent ev) {
                    area2.append(area1.getText());
                }
        });
        

        //DECLARACIÓN COMPONENTE JTextArea area2
        area2 = new JTextArea(10,15);
        //desactivamos edición en la componente JTextArea area2
        area2.setEditable(false);
        //DECLARACIÓN CONTENEDOR JScrollPane Y ASOCIACIÓN CON ÉL DE LA COMPONENTE
        //JTextArea area2 PARA PRESTACIÓN DE BARRA DE DESPLAZAMIENTO CUANDO
        //LA SUPERFICIE DE LA COMPONENTE JTextArea area1 NO SEA SUFICIENTE
        //PARA LA VISUALIZACIÓN DE TODO EL TEXTO INTRIODUCIDO EN ELLA
        JScrollPane barraDesplazamiento2= new JScrollPane(area2);
        //INTRODUCCIÓN CONTENEDOR JScrollPane barraDesplazamiento2 EN EL PANEL 
        //DE CONTENIDOS panelContenidos
        panelContenidos.add(barraDesplazamiento2);

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        pack();
        //CENTRADO DEL CONTENEDOR JFrame EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        //VISUALIZACIÓN CONTENEDOR JFrame 
        setVisible(true);
    }
}
