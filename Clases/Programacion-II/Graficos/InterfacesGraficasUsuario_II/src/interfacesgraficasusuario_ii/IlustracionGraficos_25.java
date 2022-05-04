/*
FUNCIONALIDAD:
EJEMPLO JMenuBar, Jmenu y JmenuItem

OBJETIVO: ilustración introducción  swing JAVA

autor: Juan Montes de Oca
 */
package interfacesgraficasusuario_ii;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class IlustracionGraficos_25 {
    //declaración método main
    public static void main(String[] args) {
        new IlustracionGraficos_25().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("ILUSTRACIÓN GÁFICOS 25");   
        
        
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTE JMenuBar    ///////////// 
//////////DECLARACIÓN COMPONENTE JMenuBar (barra de menu)
        JMenuBar barraMenu=new JMenuBar();
        //INTRODUCIÓN COMPONENTE JMenuBar barraMenu EN EL CONTENEDOR JFrame ventana
        ventana.setJMenuBar(barraMenu);

//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JMenu    ///////////// 
//////////DECLARACIÓN COMPONENTE JMenu menu1
        JMenu menu1=new JMenu("MENÚ 1");
//////////DECLARACIÓN COMPONENTE JMenu menu2
        JMenu menu2=new JMenu("MENÚ 2"); 
        
        
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JMenuItem  ///////////// 
/////////            ASOCIADAS A LA COMPONENTE JMenu menu1         /////////////
//////////DECLARACIÓN COMPONENTE JMenuItem menu1Opcion1
        JMenuItem menu1Opcion1= new JMenuItem("MENÚ 1 - OPCIÓN 1");
        //ASIGNACIÓN GESTOR DE EVENTOS A LA COMPONENTE JMenuItem menu1Opcion1
        menu1Opcion1.addActionListener(new gestorEvento());
//////////DECLARACIÓN COMPONENTE JMenuItem menu1Opcion2        
        JMenuItem menu1Opcion2= new JMenuItem("MENÚ 1 - OPCIÓN 2");
        //ASIGNACIÓN GESTOR DE EVENTOS A LA COMPONENTE JMenuItem menu1Opcion2
        menu1Opcion2.addActionListener(new gestorEvento());
//////////INTRODUCCIÓN EN LA COMPONENTE Jmenu menu1 DE LAS COMPONENTES 
        //menu1Opcion1 y menu1OPcion2
        menu1.add(menu1Opcion1);
        menu1.add(menu1Opcion2);

////////  DECLARACIONES Y DEFINICIONES COMPONENTES JCheckBoxMenuItem  ////////// 
//////// Y JRadioButtonMenuItem ASOCIADAS A LA COMPONENTE JMenu menu2 //////////
//////////DECLARACIÓN COMPONENTE JCheckBoxMenuItem menu2Opcion1
        JCheckBoxMenuItem menu2Opcion1= new JCheckBoxMenuItem("MENÚ 2 - OPCIÓN 1");
        //ASIGNACIÓN GESTOR DE EVENTOS A LA COMPONENTE JMenuItem menu2Opcion1
        menu2Opcion1.addActionListener(new gestorEvento());
//////////DECLARACIÓN COMPONENTE JCheckBoxMenuItem menu2Opcion2
        JCheckBoxMenuItem menu2Opcion2= new JCheckBoxMenuItem("MENÚ 2 - OPCIÓN 2",true);
        //ASIGNACIÓN GESTOR DE EVENTOS A LA COMPONENTE JMenuItem menu2Opcion2
        menu2Opcion2.addActionListener(new gestorEvento());
//////////DECLARACIÓN COMPONENTE JCheckBoxMenuItem menu2Opcion3
        JRadioButtonMenuItem menu2Opcion3= new JRadioButtonMenuItem("MENÚ 2 - OPCIÓN 3",true);
        //ASIGNACIÓN GESTOR DE EVENTOS A LA COMPONENTE JMenuItem menu2Opcion3
        menu2Opcion3.addActionListener(new gestorEvento());
//////////INTRODUCCIÓN EN LA COMPONENTES Jmenu menu2 DE LAS COMPONENTES
        //Menu2Opcion1, menu2Opcion2 y menu2Opcion3
        menu2.add(menu2Opcion1);
        menu2.add(menu2Opcion2);
        //INTRODUCCIÓN SEPARADOR
        menu2.addSeparator(); 
        menu2.add(menu2Opcion3);

        
//////////INTRODUCCIÓN DE LAS COMPONENTES JMenu menu1 y menu2 EN LA COMPONENTE 
        //JMenuBar barraMenu
        barraMenu.add(menu1);
        barraMenu.add(menu2);

////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //DIMENSIONAMIENTO CONTENEDOR JFrame ventana 
        ventana.setSize(300,200);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
    
    //CLASE GESTOR DE EVENTOS
    private class gestorEvento implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.out.println("OPCIÓN: " + evento.getActionCommand());
            }
    }
}
