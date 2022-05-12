/*
CLASE Panel

Declaraciónes y prestaciones dirigidas a la gestión de paneles de imágenes.
 */

/*
    realización: Juan Montes de Oca
 */


package tableroletras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Panel extends JPanel {
    //DECLARACIÓN DE ATRIBUTOS
    private static final int dimX=100;
    private static final int dimY=100;
    private Image imagen;
    
    //MÉTODO CONSTRUCTOR
    public Panel(String nombreImagen) {
        try {
            imagen=Toolkit.getDefaultToolkit().getImage(nombreImagen);
        }catch (Exception error) {}
        redimensionarImagen();
        setSize(dimX, dimY); 
        setBackground(Color.WHITE);
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Utilizamos Graphics2D para la visualización
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imagen,0,0,this);
    }    
    
    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color RED
    public void seleccionarPanel() {
        setBorder(BorderFactory.createLineBorder(Color.RED,5));     
    } 

    //lleva a cabo la actualización del cuadrado erroneo asignándole un
    //borde de color GREEN
    public void deseleccionarPanel() {
        setBorder(BorderFactory.createLineBorder(Color.WHITE,5));     
    } 
    
    //redimensionamiento de una imagen en base a las dimensiones de una
    //etiqueta
    public void redimensionarImagen() {
        imagen = imagen.getScaledInstance(dimX,
            dimY, java.awt.Image.SCALE_DEFAULT);
    }    

}
