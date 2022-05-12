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
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class TableroBotones extends JPanel {
    private Boton [] botones;
    private int botonSeleccionado;
    private static int FILAS=7,COLUMNAS=4;
    private static char [] caracteres="ABCDEFGHIJKLMNÑOPQRSTUVWXYZÇ".toCharArray();
    
    public TableroBotones() {
        super();
        setLayout(new GridLayout(FILAS,COLUMNAS,2,2));
        botones=new Boton[caracteres.length];
        setSize(265, 450);
        inicializacion();
    }
    
    public void inicializacion() {
        for (int i=0;i<caracteres.length;i++) {
            ImageIcon imagen=new ImageIcon("IMAGENES_CARACTERES/"+caracteres[i]+".jpg");
            botones[i]=new Boton(imagen);
            botones[i].addMouseListener(eventosRaton());
            add(botones[i]);
        }    
        botonSeleccionado=0; 
    }
    
    public MouseListener eventosRaton() {
        MouseListener accion=new MouseListener(){
            @Override
            public void mousePressed(MouseEvent evento) {
                botones[botonSeleccionado].deseleccionarBoton();
                int numeroComponente=0;
                for (;numeroComponente<botones.length;numeroComponente++) {
                    if (evento.getSource()==botones[numeroComponente]) break;
                }
                botonSeleccionado=numeroComponente;
                botones[botonSeleccionado].seleccionarBoton();
                System.out.println("CARACTER PULSADO: "+caracteres[botonSeleccionado]);
                
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
