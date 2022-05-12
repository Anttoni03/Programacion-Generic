/*
CLASE QUE SIMULA EL MOVIMIENTO INTERACTIVO, A TRAVÉS DE LAS TECLAS DE DIRECCIÓN,
DE UNA BOLA A TRAVÉS DE UN TABLERO

autor: Juan Montes de Oca
*/

package desplazamientobolaportablero;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.IOException;

public class desplazamientoBolaTablero extends JFrame {

    public desplazamientoBolaTablero() {
        //constructor de la clase JFrame
        super("DESPLAZAMIENTO INTERACTIVO BOLA");       

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        Container panelContenidos=getContentPane();
        //asociación al contenedor JFrame del administrador de layout BorderLayout
        panelContenidos.setLayout(new BorderLayout());        

////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN COMPONENTES                               //
////////////////////////////////////////////////////////////////////////////////
//////////         DECLARACIÓN Y DEFINICIÓN CONTENEDOR Tablero     ///////////// 
        Tablero panel=new Tablero();
        //inclusión del contenedor panel en el area central del panel de contenidos 
        //del JFrame
        panelContenidos.add(panel, BorderLayout.CENTER);


//////////         DECLARACIÓN Y DEFINICIÓN COMPONENTE JLabel      ///////////// 
        JLabel texto=new JLabel(" MOVER DISCO ==> "
                + "TECLAS DESPLAZAMIENTO");
        texto.setOpaque(true);
        texto.setBackground(Color.BLACK);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("arial", 2, 25));
        //inclusión de la componente texto en el area sur del panel de 
        //contenidos del JFrame
        panelContenidos.add(texto, BorderLayout.SOUTH);

        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO  DEL CONTENEDOR JFrame  
        setSize(608,660);
        //CENTRADO DEL CONTENEDOR JFrame EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //VISUALIZACIÓN CONTENEDOR JFrame
        setVisible(true);
    }

    
    public static void main(String[] args) throws IOException {
        new desplazamientoBolaTablero();
    }

}
