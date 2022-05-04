/*
FUNCIONALIDAD:
EJEMPLO DE OBJETOS JRadioButton utilizando un solo manipulador de eventos para cada objeto
JRadioButton y se crea una clase interna para ello.

OBJETIVO: 
    - ilustración introducción componentes swing JAVA.
    - componente JRadioButton

autor: Juan Montes de Oca
 */
package clasepractica_07_04_2022;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IlustracionGraficos_4 {
    //DECLARACIONES ATRIBUTOS
    //DECLARACIÓN COMPONENTE JTextField texto
    private static JTextField texto; 
    
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_4().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 4");    

        
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
//////////INSTANCIACIÓN COMPONENTE JTextField texto
        texto = new JTextField( "cambia el estilo del tipo de letra", 30);
//////////INTRODUCCIÓN DE LA COMPONENTE JTextField texto EN EL PANEL DE
        panelContenidos.add(texto);
        
//////////          DECLARACIONES COMPONENTES JRadioButton         /////////////
//////////DECLARACIÓN COMPONENTES JRadioButton botonSimple, botonNegrita y botonCursiva
        JRadioButton botonSimple = new JRadioButton("Simple",false);
        JRadioButton botonNegrita = new JRadioButton("Negrita",false);
        JRadioButton botonCursiva = new JRadioButton("Cursiva",false);
        
//////////INTRODUCCIÓN DE LAS COMPONENTES JRadioButton DECLARADAS EN EL PANEL DE
        //CONTENIDOS panelContenidos
        panelContenidos.add(botonSimple);
        panelContenidos.add(botonNegrita);
        panelContenidos.add(botonCursiva);        

//////////DECLARACIÓN OBJETO ButtonGroup PARA ESTABLECER LA RELACIÓN LÓGICA
        //ENTRE LAS COMPONENTES JRadioButton PARA QUE SEÁN EXCLUSIVOS
        ButtonGroup grupoBotonesOpcion = new ButtonGroup();
        grupoBotonesOpcion.add(botonSimple);
        grupoBotonesOpcion.add(botonNegrita);
        grupoBotonesOpcion.add(botonCursiva);

/////////DECLARACIONES OBJETOS Font PARA ESTABLECER DIFERENTES TIPOGRAFÍAS //////        
        Font tipoLetraSimple = new Font("Arial", Font.PLAIN, 12);
        Font tipoLetraNegrita = new Font("Arial", Font.BOLD, 14);
        Font tipoLetraCursiva = new Font("Arial", Font.ITALIC, 12);

/////////ASIGNACIÓN GESTOR DE EVENTOS A LAS COMPONENTES JRadioButton DECLARADAS
        botonSimple.addItemListener(new gestorEventos(tipoLetraSimple));
        botonNegrita.addItemListener(new gestorEventos(tipoLetraNegrita));
        botonCursiva.addItemListener(new gestorEventos(tipoLetraCursiva));

        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(350,100);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }

    //CLASE GESTOR DE EVENTOS ItemListener
    private class gestorEventos implements ItemListener {
        private Font tipoDeLetra;
        public gestorEventos(Font f) {
                tipoDeLetra = f;
        }
        @Override
        public void itemStateChanged(ItemEvent evento) {
            //MODIFICA LA TIPOGRAFÍA DE LA COMPONENTE JTextField texto
            texto.setFont(tipoDeLetra);
        }
    }
}
