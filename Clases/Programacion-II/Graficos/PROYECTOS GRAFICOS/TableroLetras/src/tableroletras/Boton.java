/*
CLASE Boton

Declaraciónes y prestaciones dirigidas a la gestión de botones de imágenes.
 */

/*
    realización: Juan Montes de Oca
 */


package tableroletras;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {
    //DECLARACIÓN DE ATRIBUTOS
    private static final int dimX=100;
    private static final int dimY=100;
    
    //MÉTODO CONSTRUCTOR
    public Boton(ImageIcon imagen) {
        setIcon(redimensionarImagenBoton(imagen));
        setSize(dimX, dimY);       
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setVerticalAlignment(javax.swing.SwingConstants.CENTER); 
        setBackground(Color.WHITE);
        setOpaque(true); 
    }
    
    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color RED
    public void seleccionarBoton() {
        setBorder(BorderFactory.createLineBorder(Color.RED,5));     
    } 

    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color GREEN
    public void deseleccionarBoton() {
        setBorder(BorderFactory.createLineBorder(Color.WHITE,5));     
    } 
    
    //redimensionamiento de una imagen en base a las dimensiones de una
    //etiqueta
    public ImageIcon redimensionarImagenBoton(ImageIcon imagen) {
        Image imgEscalada = imagen.getImage().getScaledInstance(dimX-4,
            dimY-4, java.awt.Image.SCALE_DEFAULT);
        return new ImageIcon(imgEscalada); 
    }    

}
