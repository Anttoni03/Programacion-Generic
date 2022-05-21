/*
 * Clase de cuadrados interactuables que funcionan como botones del juego
 */
package taller2antonifraugordiola;

import java.awt.Color;
import javax.swing.*;

public class Cuadrado extends JButton {
    
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que representa si el cuadrado es el diferente del nivel
    private boolean diferente = false;
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor que gestiona la instanciación de un botón-Cuadrado
    public Cuadrado() {}
    
    //Método marcar que la aplica un borde dependiendo de si es o no diferente
    public void marcar()
    {
        setBorder(BorderFactory.createLineBorder((diferente) ? Color.GREEN : Color.RED, 3));
    }
    
    //Método desmarcar que le aplica un borde vacío para desmarcarlo
    public void desmarcar()
    {
        setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
    }
    
    //Método setDiferente que aplica las diferencias al cuadrado
    public void setDiferente(int complejidad)
    {
        //indicar que es un cuadrado diferente
        diferente = true;
        //restar una cantidad según la función f(cmpj) = 49 - 2.75 * cmpj^1.18
        int cambio = (int)(49 - 2.75*(Math.pow((double)complejidad,1.18)));
        //aplicar el mismo color con la catidad calculada restada
        Color bg = getBackground();
        Color color = new Color(
                bg.getRed()-cambio,
                bg.getGreen()-cambio,
                bg.getBlue()-cambio);
        setBackground(color);
    }
    
    //Método setNoDiferente que indica que el cuadrado no es diferente
    public void setNoDiferente()
    {
        diferente = false;
    }
    
    //Método esDiferente que devuleve si el cuadrado es diferente
    public boolean getDiferente() { return diferente; }
}
