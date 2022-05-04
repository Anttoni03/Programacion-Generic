/*
FUNCIONALIDAD:
EJEMPLO JScrollPane

OBJETIVO: ilustración introducción swing JAVA

autor: Juan Montes de Oca
 */

package claseteoria___12_04_2022;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class IlustracionGraficos_20 extends JFrame {
    
    public IlustracionGraficos_20() {
        //constructor de la clase JFrame
        super("ILUSTRACIÓN GRÁFICA 20");
               
      
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        
        Container panelContenidos=getContentPane();       
        //ASIGNACIÓN AL PANEL DE CONTENIDOS panelContenidos DEL ADMINISTRADOR 
        //DE Layout cuadricula1
        panelContenidos.setLayout(new FlowLayout());   


////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
///////////DECLARACIÓN  Y CONFIGURACIÓN COMPONENTE JList listaColores
        //declaración array de String con los nombres de colores
        final String[] colores = { "Negro", "Azul", "Cyan","Gris oscuro", 
        "Gris", "Verde", "Gris claro", "Magenta", "Naranja","Rosa", 
        "Rojo", "Blanco", "Amarillo" };
        //declaración objeto componente JList asignándole el array colores
        JList listaColores = new JList(colores);
        //INDICAR EL NÚMERO DE OPCIONES VISIBLES 
        listaColores.setVisibleRowCount(8); 
        //MODO DE SELECCIÓN OPCIONES DE LA COMPONENTE JList listaColores
        listaColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //DECLARACIÓN CONTENEDOR JScrollPane ASIGNÁNDOLO A LA COMPONENTE JList listaColores
        JScrollPane barraDesplazamiento1= new JScrollPane(listaColores);

        
//////////DECLARACIÓN Y CONFIGURACIÓN COMPONENTE JList listaCopia
        JList listaCopia = new JList();
        //INDICAR EL NÚMERO DE OPCIONES VISIBLES 
        listaCopia.setVisibleRowCount(5);
        //FIJAR DIMENSIÓN COMPOENENTE JList listaCopia
        listaCopia.setFixedCellWidth(100);
        listaCopia.setFixedCellHeight(15);
        //MODO DE SELECCIÓN OPCIONES DE LA COMPONENTE JList listaCopia
        listaCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION );
        //DECLARACIÓN OBJETO JScrollPane ASIGNÁNDOLO A LA COMPONENTE JList listaCopia
        JScrollPane barraDesplazamiento2= new JScrollPane(listaCopia);

        
///////////DECLARACIÓN y CONFIGURACIÓN COMPONENTE JButton boton
        JButton boton = new JButton("Copiar >>>");

        //ASIGNACIÓN DEL GESTOR DE EVENTOS ActionListener A LA COMPONENTE JButton
        //boton
        boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed( ActionEvent evento ) {
                    //copia en la JList listaCopia las componentes seleccionadas
                    //de la JList listaColores
                    listaCopia.setListData(listaColores.getSelectedValues());
                } 
        });   

        
///////////INTRODUCCIÓN COMPONENTES DECLARADAS EN EL PANEL DE CONTENIDOS panelContenidos       
        //INTRODUCCIÓN DEL CONTENEDOR barraDesplazamiento1 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(barraDesplazamiento1);        
        //INTRODUCCIÓN DE LA COMPONENTE JButton boton EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(boton);
        //INTRODUCCIÓN DEL CONTENEDOR barraDesplazamiento2 EN EL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.add(barraDesplazamiento2);        
        
        
////////////////////////////////////////////////////////////////////////////////
//        ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame ventanaPrincipal           //
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
    

    //MÉTODO main
    public static void main(String args[]){
            IlustracionGraficos_20 aplicacion = new IlustracionGraficos_20();
    }
}

