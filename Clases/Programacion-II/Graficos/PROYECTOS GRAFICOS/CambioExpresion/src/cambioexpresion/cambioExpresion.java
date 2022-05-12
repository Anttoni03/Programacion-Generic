/*
FUNCIONALIDAD:
SIMULACIÓN DEL CAMBIO DE EXPRESIÓN INTERACTIVAMENTE

OBJETIVO: introducción programación gráfica
 */

package cambioexpresion;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class cambioExpresion {
    //DECLARACIÓN ATRIBUTOS
    private boolean sonrisa=true;
    private panelImagen panel;
    
    //declaración método main
    public static void main(String[] args) { 
        new cambioExpresion().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        JFrame ventana = new JFrame("DESPLAZAMIENTO BOLA");
        ventana.setSize(325, 300); 

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane();    

        //DECLARACIÓN COMPONENTE  JComponent
        panel=new panelImagen();
        //introducción componente panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(panel,BorderLayout.CENTER);
 
        //DECLARACIÓN COMPONENTE JButton
        JButton boton1= new JButton("CAMBIAR EXPRESION"); 
        boton1.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent evento) { 
                    sonrisa=!sonrisa;
                    panel.repaint();
            }
        });
        panelContenidos.add(boton1,BorderLayout.SOUTH);       

        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);

    }
    
    
    private class panelImagen extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //pintar fondo de color negro
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, 325, 266);
            //pintar base cara
            g2.setColor(Color.YELLOW);
            Ellipse2D baseCara=new Ellipse2D.Double(105,70,100,100);
            g2.fill(baseCara);
            //pintar ojos
            g2.setColor(Color.BLACK);
            Ellipse2D ojoIzquierdo=new Ellipse2D.Double(125,100,10,10);
            Ellipse2D ojoDerecho=new Ellipse2D.Double(175,100,10,10);
            g2.fill(ojoIzquierdo); // ojo izquierdo
            g2.fill(ojoDerecho); // ojo derecho
            //pintar nariz
            Line2D nariz=new Line2D.Double(155,100,155,120);
            g2.draw(nariz); // nariz
            g2.setStroke(new BasicStroke(3.0f,BasicStroke.CAP_SQUARE,
                BasicStroke.JOIN_ROUND,40.0f));
            if (sonrisa) g2.drawArc(118,120,75,30,180,180);
            else  g2.drawArc(118,125,75,30,180,-180);
        }       
    }    
}
