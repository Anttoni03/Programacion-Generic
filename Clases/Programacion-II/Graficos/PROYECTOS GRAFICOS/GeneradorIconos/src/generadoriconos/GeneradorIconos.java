/*
GENERADOR DE IMÁGENES ICONO

realización: Juan Montes de Oca
*/

package generadoriconos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class GeneradorIconos extends JFrame implements MouseListener {
    //DECLARACIÓN DE ATRIBUTOS
    private Tablero tablero;
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem borrado;
    private JMenuItem escritura;
    private JMenuItem fin;    
    private int cociente=20; //cociente nos dará el factor por el que tenemos que subdividir
                        //el dibujo para adaptarlo a una imagen cuya dimensión vendrá
                        //dada por 1000/cociente. En el caso que el cociente tenga una
                        //dimensión de 10 tendremos una imagen de 100x100 pixeles.
    private int dimensionImagen=1000/cociente;

    public GeneradorIconos() {
        super("TALLER 2");
        inicializacion();
        setVisible(true);
    }

    private void inicializacion() {
        //Panel de visualización del tablero de casillas
        tablero = new Tablero();
        //Declaración de la barra de menu 
        barraMenu = new JMenuBar();
        //declaración opción MENU de la barra de menu
        menu = new JMenu("MENU");
        //declaración opciones de la opción MENU de la barra de menu
        borrado = new JMenuItem("BORRAR");
        escritura = new JMenuItem("GENERAR IMAGEN");
        fin = new JMenuItem("SALIR");
        
        //Gestor de eventos asociado a la opción GENERAR IMAGEN del menu
        escritura.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //GENERACIÓN DE IMAGEN CUYO CONTENIDO SEA LA ENTIDAD GRÁFICA REPRESENTADA
                //POR LAS CASILLAS DEL TABLERO
                BufferedImage imagen = new BufferedImage(dimensionImagen, dimensionImagen, BufferedImage.TYPE_INT_RGB);
                //creación del objeto Graphics g que posibilitará dibujar en la imagen
                //generada
                Graphics2D g = imagen.createGraphics(); 
                //dibujo de las casillas en la imagen generada
                for (int fila=0; fila <tablero.getNumCasillas(); fila++) {
                    for (int columna=0;columna<tablero.getNumCasillas();columna++) {
                        if (tablero.getEstadoCasilla(fila, columna)) {                                      
                            g.setColor(Color.BLACK);  
                        }                                 
                        else {                                         
                            g.setColor(Color.WHITE);   
                        }                          
                        g.fillRect((int)tablero.getX(fila, columna)/cociente, 
                        (int)tablero.getY(fila, columna)/cociente, 
                        ((int)tablero.getX(fila, columna)+20)/cociente, 
                        ((int)tablero.getY(fila, columna)+20)/cociente);             
                    }
                }
                try {
                    String nombreFichero="";
                    JFileChooser fichero=new JFileChooser();
                    fichero.showSaveDialog(escritura);
                    File nombre=fichero.getSelectedFile();
                    if (nombre != null) {
                        //volcado de la imagen a un fichero de formato jpg con el
                        //nombre dado a través de la componente JFileChooser
                        ImageIO.write(imagen, "jpg", new File(nombre+".jpg"));
                        JOptionPane.showMessageDialog(null,
                        "El archivo se ha guardado correctamente",
                        "Información: ",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch(IOException ex) {
                    JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado",
                            "Advertencia: ",JOptionPane.WARNING_MESSAGE);
                }
                
                tablero.repaint();
            }
        });

        //Gestor de eventos asociado a la opción BORRAR del menu
        borrado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                tablero.borrar();
                tablero.repaint();
            }
        });

        //Gestor de eventos asociado a la opción SALIR del menu
        fin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        
        //adición en la opción menu de las opciones BORRAR, GENERAR IMAGEN y SALIR
        menu.add(borrado);
        menu.add(escritura);
        menu.add(fin);
        //adición en la barra de menu de la opción MENU
        barraMenu.add(menu);
        //Adición en JFrame de la barra de menu
        setJMenuBar(barraMenu);
        //asociación del gestor de eventos del ratón MouseListener al JFrame
        addMouseListener(this);
        //adición en el JFrame del tablero de casillas
        getContentPane().add(tablero);
        setSize(tablero.getPreferredSize());
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void mouseClicked(MouseEvent me) {}

    //Gestor del evento del boton pulsado del ratón al JFrame
    @Override
    public void mousePressed(MouseEvent evento) {                   
        int x=evento.getX();                  
        int y=evento.getY();                  
        for (int fila=0; fila <tablero.getNumCasillas(); fila++) {                     
            for (int columna=0;columna<tablero.getNumCasillas();columna++) {                        
                if ((x>tablero.getX(fila, columna))&&                   
                        (x<tablero.getX(fila, columna)+20)&&                
                        (y>tablero.getY(fila, columna)+45)&&                
                        (y<tablero.getY(fila, columna)+65)) {                  
                    tablero.cambiarEstadoCasilla(fila,columna);               
                }                                                      
            }                  
        }                   
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
    
    public static void main(String[] args) {
        GeneradorIconos taller = new GeneradorIconos();
    }
}
