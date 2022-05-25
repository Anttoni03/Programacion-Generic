/*
CLASE Cuadrado

Declaraciónes y prestaciones dirigidas a la gestión de etiquetas de colores
 */

/*
    realización: Juan Montes de Oca
 */


package taller2_2021_2022;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Cuadrado extends JLabel{
    //DECLARACIÓN DE ATRIBUTOS
    
    //MÉTODO CONSTRUCTOR
    public Cuadrado() {}
    
    public Cuadrado(Color color, int dimX, int dimY) {
        setBackground(color);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        setPreferredSize(new Dimension(dimX,dimY));
    }
    
    //MÉTODOS FUNCIONALES
    public void cambiarColor(Color color) {
        setBackground(color);
    }
    
    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color RED
    public void seleccionErronea() {
        setBorder(BorderFactory.createLineBorder(Color.RED,5));     
    } 

    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color GREEN
    public void seleccionValida() {
        setBorder(BorderFactory.createLineBorder(Color.GREEN,5));     
    } 
}
