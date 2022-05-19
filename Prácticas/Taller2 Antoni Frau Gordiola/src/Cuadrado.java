
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class Cuadrado extends JButton {
    
    private boolean diferente = false;
    public boolean marcado = false;
    
    public Cuadrado() {}
    
    public void setDiferente(int variacion)
    { 
        diferente = true;
        int cambio = (int)((10f/variacion)*10f);
        System.out.println(cambio);
        Color bg = getBackground();
        Color color = new Color(
                (bg.getRed()-cambio < 0) ? 0 : bg.getRed()-cambio,
                (bg.getGreen()-cambio < 0) ? 0 : bg.getGreen()-cambio,
                (bg.getBlue()-cambio < 0) ? 0 : bg.getBlue()-cambio);
        setBackground(color);
    }
    
    public void setNoDiferente()
    {
        diferente = false;
    }
    
    public boolean esDiferente() { return diferente; }
    
    
    public void marcar()
    {
        setBorder(BorderFactory.createLineBorder((diferente) ? Color.GREEN : Color.RED, 3));
        marcado = true;
    }
    
    public void desmarcar()
    {
        setBorder(BorderFactory.createLineBorder(Color.GREEN,0));
        marcado = false;
    }
    
    public void setColor(Color color)
    {
        setBackground(color);
    }
    
    public Cuadrado copiar()
    {
        
        return null;
    }
}
