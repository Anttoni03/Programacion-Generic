/*
 * Clase de panelStandby que hereda de JPanel y se encarga de visualizar un gif
 */
package taller2antonifraugordiola;

import java.awt.*;
import javax.swing.*;

public class PanelStandby extends JPanel {
    
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto constante que guardará el fig a mostrar
    private final JLabel etiquetaImagen;
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor que gestiona la instanciación del objeto PanelStandby
    public PanelStandby(String gif, Dimension dimension)
    {
        //aplica el tamaño con la dimensión recibida
        setPreferredSize(dimension);            
        
        //obtiene el gif indicado, reescala su imagen y la aplica en la etiqueta
        ImageIcon gif2 = new ImageIcon(gif);
        Image image = gif2.getImage();
        image = image.getScaledInstance(dimension.width, dimension.height, 0);
        gif2.setImage(image);
        etiquetaImagen = new JLabel(gif2);

        //añade la etiqueta al panel para mostrala
        add(etiquetaImagen);
    }
}