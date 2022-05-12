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


public class TableroEtiquetas extends JPanel {
    private Etiqueta [] etiquetas;
    private int etiquetaSeleccionada;
    private static int FILAS=7,COLUMNAS=4;
    private static char [] caracteres="ABCDEFGHIJKLMNÑOPQRSTUVWXYZÇ".toCharArray();
    
    public TableroEtiquetas() {
        super();
        setLayout(new GridLayout(FILAS,COLUMNAS,2,2));
        etiquetas=new Etiqueta[caracteres.length];
        inicializacion();
    }
    
    public void inicializacion() {
        for (int i=0;i<caracteres.length;i++) {
            ImageIcon imagen=new ImageIcon("IMAGENES_CARACTERES/"+caracteres[i]+".jpg");
            etiquetas[i]=new Etiqueta(imagen);
            etiquetas[i].addMouseListener(eventosRaton());
            add(etiquetas[i]);
        }    
        etiquetaSeleccionada=0; 
    }
    
    public MouseListener eventosRaton() {
        MouseListener accion=new MouseListener(){
            @Override
            public void mousePressed(MouseEvent evento) {
                etiquetas[etiquetaSeleccionada].deseleccionarEtiqueta();
                int numeroComponente=0;
                for (;numeroComponente<etiquetas.length;numeroComponente++) {
                    if (evento.getSource()==etiquetas[numeroComponente]) break;
                }
                etiquetaSeleccionada=numeroComponente;
                etiquetas[etiquetaSeleccionada].seleccionarEtiqueta();
                System.out.println("CARACTER PULSADO: "+caracteres[etiquetaSeleccionada]);  
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
