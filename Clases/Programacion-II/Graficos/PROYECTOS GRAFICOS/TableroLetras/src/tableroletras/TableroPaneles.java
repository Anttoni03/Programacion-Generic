/*
PANEL DE CARACTERES
 */
/*
    realización: Juan Montes de Oca
 */

package tableroletras;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


public class TableroPaneles extends JPanel {
    private Panel [] paneles;
    private int panelSeleccionado;
    private static int FILAS=7,COLUMNAS=4;
    private static char [] caracteres="ABCDEFGHIJKLMNÑOPQRSTUVWXYZÇ".toCharArray();
    
    public TableroPaneles() {
        super();
        setLayout(new GridLayout(FILAS,COLUMNAS,2,2));
        paneles=new Panel[caracteres.length];
        setSize(265, 450);
        inicializacion();
    }
    
    public void inicializacion() {
        for (int i=0;i<caracteres.length;i++) {
            paneles[i]=new Panel("IMAGENES_CARACTERES/"+caracteres[i]+".jpg");
            paneles[i].addMouseListener(eventosRaton());
            add(paneles[i]);
        }    
        panelSeleccionado=0; 
    }
    
    public MouseListener eventosRaton() {
        MouseListener accion=new MouseListener(){
            @Override
            public void mousePressed(MouseEvent evento) {
                paneles[panelSeleccionado].deseleccionarPanel();
                int numeroComponente=0;
                for (;numeroComponente<paneles.length;numeroComponente++) {
                    if (evento.getSource()==paneles[numeroComponente]) break;
                }
                panelSeleccionado=numeroComponente;
                paneles[panelSeleccionado].seleccionarPanel();
                System.out.println("CARACTER PULSADO: "+caracteres[panelSeleccionado]);
                
            }
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}   
        };
        return accion;
    }
}
