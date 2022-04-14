/*
FUNCIONALIDAD:
EJEMPLO CONTENEDOR JDialog
Un JDialog es una ventana que depende de otra ventana (de una JFrame). 
Si un JFrame se cierra, se cierran también los JDialog que dependen de ella; 
si se restablece, sus JDialog aparecen de nuevo. Este comportamiento se obtiene 
de forma automática.

OBJETIVO: ilustración introducción swing JAVA

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class IlustracionGraficos_19 {
    public static void main(String[] args) {   
        new IlustracionGraficos_19().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public void metodoPrincipal(){
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDORES                              //
//////////////////////////////////////////////////////////////////////////////// 
/////     DECLARACIÓN Y CONFIGURACIÓN CONTENEDOR JFrame ventanaPrincipal   /////
        JFrame ventanaPrincipal = new JFrame("VENTANA PRINCIPAL");
        //DIMENSIONAMIENTO CONTENEDOR JFrame ventanaPrincipal
        ventanaPrincipal.setSize(300,100);
//////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame  ventanaPrincipal   ///////        
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventanaPrincipal
        Container panelContenidosPrincipal=ventanaPrincipal.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidosPrincipal
        panelContenidosPrincipal.setLayout(new FlowLayout());   
        

/////   DECLARACIÓN Y CONFIGURACIÓN CONTENEDOR JDialog ventanaSecundaria   /////
        JDialog ventanaSecundaria = new JDialog(ventanaPrincipal,"VENTANA SECUNDARIA");
        //DIMENSIONAMIENTO CONTENEDOR JFrame ventanaSecundaria
        ventanaSecundaria.setSize(300,100);
        //CENTRADO DEL CONTENEDOR ventanaSecundaria EN EL CENTRO DE LA PANTALLA
        ventanaSecundaria.setLocationRelativeTo(null);  
        //ASIGNACIÓN GESTOR DE EVENTO WindowListener AL CONTENEDOR ventanaSecuendaria
        //PARA  QUE AL CERRARSE ventanaSecundaria INTERACTIVAMENTE SE MUESTRE 
        //ventanaPrincipal
        ventanaSecundaria.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                        ventanaPrincipal.setVisible(true);
                        ventanaSecundaria.setVisible(false);
                }
        });
//////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame  ventanaSecundaria   ///////        
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventanaSecundaria
        Container panelContenidosSecundaria=ventanaSecundaria.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidosSecundaria
        panelContenidosSecundaria.setLayout(new FlowLayout());       


////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////         
///////////DECLARACIÓN COMPONENTE JButton boton1
        JButton boton1 = new JButton("pulsa y abrirás la ventana secundaria");
        //introducción de la componente JButton boton1 en el panel de contenidos
        //del contenedor JFrame ventanaPrincipal
        panelContenidosPrincipal.add(boton1);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //abrir ventana contendor JDialog ventanaSecundaria
                ventanaSecundaria.setVisible(true);
            }
        });        

        
//////////DECLARACIÓN COMPONENTE JButton boton2
        JButton boton2 = new JButton("púlsame y volveras a la ventana principal");
        //introducción de la componente JButton boton2 en el panel de contenidos del contenedor
        //JDialog ventanaSecundaria
        panelContenidosSecundaria.add(boton2);
        //ASIGNACIÓN GESTOR DE EVENTOS A LA COMPONENTE JButton boton2
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //abrir ventana contenedor JFrame ventanaPrincipal
                ventanaPrincipal.setVisible(true);
                //cerrar ventana contenedor JDialog ventanaSecundaria
                ventanaSecundaria.setVisible(false);
            }
        });        
        
        
////////////////////////////////////////////////////////////////////////////////
//        ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame ventanaPrincipal           //
////////////////////////////////////////////////////////////////////////////////
        //CENTRADO DEL CONTENEDOR ventanaPrincipal EN EL CENTRO DE LA PANTALLA
        ventanaPrincipal.setLocationRelativeTo(null);    
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame 
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventanaPrincipal.setVisible(true);
    }
}
