/*
FUNCIONALIDAD:
EJEMPLO ADMINISTRADOR DE LAYOUT GridLayout

OBJETIVO: ilustración introducción administradores de
layouts

autor: Juan Montes de Oca
 */
package claseteoria___12_04_2022;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class IlustracionGraficos_18 extends JFrame  {
    //declaración variable booleana para gestionar acciones del gestor de eventos
    private boolean alternar = true;
    
    //CONSTRUCTOR
    public IlustracionGraficos_18() {
        //constructor de la clase JFrame
        super("ILUSTRACIÓN GRÁFICA 18");       

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();
        
        //DECLARACIÓN ADMINISTRADORES DE LAYOUTS GridLayout a utilizar
        GridLayout cuadricula1= new GridLayout( 2, 3, 10, 20 );
        GridLayout cuadricula2 = new GridLayout( 3, 2 );
        
        //ASIGNACIÓN AL PANEL DE CONTENIDOS panelContenidos DEL ADMINISTRADOR 
        //DE Layout cuadricula1
        panelContenidos.setLayout(cuadricula1);    

            
////////////////////////////////////////////////////////////////////////////////
//                    DECLARACIÓN GESTOR DE EVENTOS                           //
////////////////////////////////////////////////////////////////////////////////
        ActionListener gestorEvento;
        gestorEvento = new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent evento) {
                //si alternar es true asignar cuadricula2 como administrador
                //de layout
                if ( alternar ) panelContenidos.setLayout( cuadricula2 );
                //en caso contrario asignar como administrador de layout
                //cuadricula1
                else panelContenidos.setLayout( cuadricula1 );
                //cambiar el valor de la variable alternar
                alternar = !alternar; 
                //validación reasignación del administrador de layout
                validate();
            }
        };
         

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    ///////////// 
        //declaración array de constantes String con las etiquetas de los diferentes 
        //botones de la interface
        final String[] etiquetas ={"uno", "dos", "tres", "cuatro", "cinco", "seis"};
        //declaración array de componentes JButton
        JButton [] botones = new JButton[ etiquetas.length ];
        //bucle declaración y configuración componentes del array botones
        for ( int indice = 0; indice < etiquetas.length; indice++ ) {
            //instanciación componente JButton indice-ésimo
            botones[indice] = new JButton(etiquetas[indice] );
            //asignación a la componente JButton indice-ésima del 
            //gestor de eventos gestorEvento
            botones[indice].addActionListener(gestorEvento);
            //introducir la componente JButton indice-ésima al
            //panel de contenidos
            panelContenidos.add(botones[indice]);
        }
            
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame  EN FUNCIÓN
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

    public static void main( String args[] ) {
            IlustracionGraficos_18 aplicacion = new IlustracionGraficos_18();
    }
}
