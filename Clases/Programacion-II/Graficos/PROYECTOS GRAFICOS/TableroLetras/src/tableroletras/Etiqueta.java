/*
CLASE Etiqueta

Declaraciónes y prestaciones dirigidas a la gestión de etiquetas de imágenes.
 */

/*
    realización: Juan Montes de Oca
 */


package tableroletras;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Etiqueta extends JLabel{
    //DECLARACIÓN DE ATRIBUTOS
    private static final int dimX=100;
    private static final int dimY=100;
    
    //MÉTODO CONSTRUCTOR
    public Etiqueta(ImageIcon imagen) {
        setIcon(redimensionarImagenEtiqueta(imagen));
        setSize(dimX, dimY);    
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        setBackground(Color.WHITE);
        setOpaque(true);
    }

    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color RED
    public void seleccionarEtiqueta() {
        setBorder(BorderFactory.createLineBorder(Color.RED,5));     
    } 

    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color GREEN
    public void deseleccionarEtiqueta() {
        setBorder(BorderFactory.createLineBorder(Color.WHITE,5));     
    } 
    
    //redimensionamiento de una imagen en base a las dimensiones de una
    //etiqueta
    private ImageIcon redimensionarImagenEtiqueta(ImageIcon imagen) {
        Image imgEscalada = imagen.getImage().getScaledInstance(dimX,
            dimY, java.awt.Image.SCALE_DEFAULT);
        return new ImageIcon(imgEscalada); 
    }    

}
