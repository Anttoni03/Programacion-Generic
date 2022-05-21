/*
 * Clase de panelInformativo que hereda de JPanel y se usa como panel para
 * visualizar un campo de datos y un valor numérico
 */
package taller2antonifraugordiola;

import java.awt.*;
import javax.swing.*;

public class PanelInformativo extends JPanel {
    
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto constante que guardará el nombre del campo a mostrar
    private final JLabel TEXTO;
    //Atributo de objeto constante que guardará el valor del campo a mostrar
    private final JLabel VALOR;

    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor que gestiona la instancia del objeto PanelInformativo
    public PanelInformativo(String txt)
    {
        //aplica transparencia total al fondo del contenedor y un FlowLayout
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT,5,3));

        //instancia las etiquetas del texto y valor y les aplica un tamaño
        TEXTO = new JLabel(txt);
        TEXTO.setPreferredSize(new Dimension(170,20));
        VALOR = new JLabel();
        VALOR.setPreferredSize(new Dimension(35,20));

        //se configuran las etiquetas de texto y valor con ajustes como la
        //fuente, el fondo, la transparencia ( ͡° ͜ʖ ͡°) que es totalmente opaca y
        //el color del las letras del texto
        TEXTO.setFont( new Font("Arial", Font.BOLD, 16));
        TEXTO.setBackground(Color.WHITE);
        TEXTO.setOpaque(true);
        TEXTO.setForeground(Color.BLACK);
        VALOR.setFont( new Font("Arial", Font.BOLD, 18));
        VALOR.setBackground(Color.WHITE);
        VALOR.setOpaque(true);
        VALOR.setForeground(Color.RED);
        
        //se aplica un alineamiento central al valor para que esté centrado
        VALOR.setHorizontalAlignment(0);
        //se aplica el valor 0 como valor inicial
        setValor(0);
        
        //se añaden el texto y el valor al panel contenedor general
        add(TEXTO);
        add(VALOR, BorderLayout.EAST);
    }

    //Método setValor que aplica y configura la etiqueta valor con el valor dado
    public void setValor(int val)
    {
        //indica cuántos 0s se necesitan a la izquierda del valor
        String temp = (val<100) ? ((val<10) ? ((val == 0) ? "000" : "00") : "0") : "";
        VALOR.setText(temp + ((val != 0) ? val : ""));
    }
}
