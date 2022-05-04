/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN MouseListener y MouseMotionListener PARA TRATAMIENTO 
EVENTO MouseEvent

autor: Juan Montes de Oca
 */

package programaciongrafica__eventos;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class eventos_MouseListener_v2 {
    //DECLARACIÓN ATRIBUTOS QUE SON COMPARTIDOS POR MÁS DE UN MÉTODO DE LA CLASE
    private panelDibujo panelSuperior;
    private panelDibujo [] areaColor; 
    
    //declaración método main
    public static void main(String[] args) { 
        new eventos_MouseListener_v2().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN CONTENEDOR JFrame                          //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame();  
        //ASIGNACIÓN NOMBRE AL CONTENEDOR JFrame ventana
        ventana.setTitle("ILUSTRACIÓN MouseListener");

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN ADMINISTRADOR GridLayout CON 3 FILAS Y 1 COLUMNA AL PANEL 
        //DE CONTENIDOS panelContenidos
        panelContenidos.setLayout(new GridLayout(3,1));
        

////////////////////////////////////////////////////////////////////////////////
//                     DECLARACIÓN CONTENEDORES JPanel                        //
//////////////////////////////////////////////////////////////////////////////// 
/////////////    DECLARACIÓN CONTENEDOR JPanel panelSuperior    ////////////////
        panelSuperior=new panelDibujo(340,100,Color.BLACK);      

/////////////     DECLARACIÓN CONTENEDOR JPanel panelColores    ////////////////       
        JPanel panelColores=new JPanel();
        //ASIGNACIÓN DEL ADMINISTRADOR GridLayout CON 1 FILA Y 4 COLUMNAS AL
        //CONTENEDOR JPanel panelColores
        panelColores.setLayout(new GridLayout(1,4));
          
//////////// DECLARACIÓN OBJETOS CONTENEDORES JPanel panelDibujo ///////////////
        Color [] colores={Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        areaColor=new panelDibujo[colores.length];
        for (int indice=0;indice<areaColor.length;indice++) {
            //INSTANCIACIÓN CONTENEDOR panelDibujo CORRESPONDIENTE A LA COMPONENTE
            //indice DEL ARRAY areaColor
            areaColor[indice]=new panelDibujo(85,85,colores[indice]);
            //INTRODUCCIÓN CONTENEDOR panelDibujo CORRESPONDIENTE A LA COMPONENTE
            //indice DEL ARRAY areaColor EN EL CONTENEDOR JPanel panelColores
            panelColores.add(areaColor[indice]);
            //ASIGNACIÓN GESTOR DE EVENTOS MouseEvent AL CONTENEDOR panelDibujo
            //CORRESPONDIENTE A LA COMPONENTE indice DEL ARRAY areaColor 
            areaColor[indice].addMouseListener(new gestorEventosRaton());
        }
       
        
////////////////////////////////////////////////////////////////////////////////
//                         DECLARACIÓN COMPONENTES                            //
//////////////////////////////////////////////////////////////////////////////// 
//////////DELARACIÓN COMPONENTE JLabel etiqueta1
        JLabel etiqueta= new JLabel("CAMBIA EL COLOR DE ARRIBA ELIGIENDO UNO DE ABAJO");
        //ASIGNACIÓN JUSTIFICACIÓN EN LA COMPONENTE JLabel etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        

////////////////////////////////////////////////////////////////////////////////
//       INTRODUCCIÓN CONTENEDORES Y COMPOENNETES EN EL PANEL DE CONTENIDOS   //
//////////////////////////////////////////////////////////////////////////////// 
        //INTRODUCCIÓN EN EL PANEL DE CONTENIDOS panelContenidos DEL CONTENEDOR
        //JPanel panelSUperior
        panelContenidos.add(panelSuperior);
        //INTRODUCCIÓN EN EL PANEL DE CONTENIDOS panelContenidos DE LA COMPONENTE
        //JLabel etiqueta
        panelContenidos.add(etiqueta);
        //INTRODUCCIÓN EN EL PANEL DE CONTENIDOS panelContenidos DEL CONTENEDOR
        //JPanel panelColores
        panelContenidos.add(panelColores);
        
        
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana 
        ventana.setSize(340, 270);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
    
    
    
////////////////////////////////////////////////////////////////////////////////
//                           CLASE panelDibujo                                //
//////////////////////////////////////////////////////////////////////////////// 
    private class panelDibujo extends JPanel {
        //DECLARACIÓN DE ATRIBUTOS
        private Color colorPanel;
        private int dimensionX,dimensionY;
        
        //MÉTODO CONSTRUCTOR
        public panelDibujo(int dimx,int dimy,Color color) {
            dimensionX=dimx;
            dimensionY=dimy;
            colorPanel=color;
            //DIMENSIONAMIENTO OBJETO panelDibujo
            setSize(dimensionX,dimensionY);
        }
        
        //CLASE paint
        @Override
        public void paint(Graphics g) {
            //COLOREAR EL FONDO DE COLOR NEGRO
            //asignar como color de trazado el color negro
            g.setColor(colorPanel);
            //se visualiza un rectángulo de dimensión igual a la dimensión  de
            //del contenedor JPanel que se está instanciando
            g.fillRect(0,0, dimensionX, dimensionY);
        }
        
        //MÉTODOS GET Y SET CORRESPONDIENTES AL ATRIBUTO colorPanel
        public Color getColor() {
            return colorPanel;
        }
        
        public void setColor(Color color) {
            colorPanel=color;
        }
    }

    
////////////////////////////////////////////////////////////////////////////////
//                       CLASE gestorEventosRaton                             //
//////////////////////////////////////////////////////////////////////////////// 
    private class gestorEventosRaton implements MouseListener {
            @Override
            public void mouseClicked(MouseEvent e) {
                //NO SE HACE NADA
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //NO SE HACE NADA
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //NO SE HACE NADA
            }

            @Override
            public void mousePressed(MouseEvent eventoRaton) {
                panelDibujo area=(panelDibujo) eventoRaton.getSource();
                panelSuperior.setColor(area.getColor());
                panelSuperior.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent eventoRaton) {
                //NO SE HACE NADA
            }    
    }
}

