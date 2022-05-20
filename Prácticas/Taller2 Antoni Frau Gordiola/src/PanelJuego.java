
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;


public class PanelJuego extends JPanel {
    
    private int cantidad = 2;
    private Color colorGeneral;
    private Cuadrado[] cuadrados;
    private int complejidad;
    private ActionListener gestorEventos;
    
    public PanelJuego(ActionListener al)
    {
        cuadrados = new Cuadrado[12*12];
        Random r = new Random();
        colorGeneral = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        
        gestorEventos = al;
    }
    
    public void generarPanel()
    {
        int espacio = (cantidad < 6) ? 4 : ((cantidad < 9) ? 3 : 2);
        GridLayout glo = new GridLayout(cantidad, cantidad, espacio, espacio);
        setLayout(glo);
        
        for (int i = (cantidad != 2)?(cantidad-1)*(cantidad-1):0; i < cantidad * cantidad; i++)
        {
            cuadrados[i] = new Cuadrado();
            cuadrados[i].addActionListener(gestorEventos);
            add(cuadrados[i]);
        }
        
        for (int i = 0; i < cantidad * cantidad; i++)
            cuadrados[i].setColor(colorGeneral);
        
        int indice = new Random().nextInt(cantidad*cantidad);
        cuadrados[indice].setDiferente(complejidad);
    }
    
    public void actualizar()
    {
        for (int i = 0; i < cantidad * cantidad; i++) cuadrados[i].desmarcar();
        cantidad++;
        
        Random r = new Random();
        colorGeneral = new Color(r.nextInt(196)+30,r.nextInt(196)+30,r.nextInt(196)+30);
        
        generarPanel();
    }
    
    public void setComplejidad(int cmp)
    {
        complejidad = cmp;
    }
    
    public void setGestorEventos(ActionListener al)
    {
        gestorEventos = al;
    }
    
    public int getCantidadCuadrados()
    {
        return cantidad;
    }
    
    public int getNivelActual()
    {
        return cantidad-1;
    }
    
    public int buscarDiferente()
    {
        int indice = 0;
        while (!cuadrados[indice].esDiferente()) indice++;
        return indice;
    }
    
    public void indicarFallo()
    {
        cuadrados[buscarDiferente()].marcar();
        cuadrados[buscarDiferente()].setNoDiferente();
    }
}