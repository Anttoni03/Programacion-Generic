package taller2.pkg0;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alberto Pérez Ancín
 */
public class Cuadrado implements MouseListener {

    //DECLARACIONES
    private static JFrame frame;
    static JPanel panel;
    private static Cuadrado KukuKube;
    private static AdministradorKukuKube administrador;
    private static JButton[][] cuadrados;

    public static void main(String[] args) {
        administrador = new AdministradorKukuKube();
        frame = new JFrame("KukuKube");

        int dimensionGrid = administrador.getDimensionGrid();
        panel = new JPanel(new GridLayout(dimensionGrid, dimensionGrid));

        KukuKube = new Cuadrado();
        frame.setContentPane(panel);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);

        cuadrados = construirInterfaz();
    }

    /**
     * Elimina todos los cuadrados del tablero
     *
     * @param cuadrados
     */
    public static void limpiarTablero(JButton[][] cuadrados) {
        int dimensionGridActual = administrador.getDimensionGrid();
        for (int i = 0; i < dimensionGridActual; i++) {
            for (int j = 0; j < dimensionGridActual; j++) {
                panel.remove(cuadrados[i][j]);
                cuadrados[i][j] = null;

            }

        }
    }

    /**
     * Coloca el tablero del juego asignando color y añadiendo MouseListener.
     *
     * @param cuadrados
     */
    private static void ponerTablero(JButton[][] cuadrados) {
        int dimensionGridActual = administrador.getDimensionGrid();
        for (int i = 0; i < dimensionGridActual; i++) {
            for (int j = 0; j < dimensionGridActual; j++) {
                cuadrados[i][j] = new JButton();
                cuadrados[i][j].addMouseListener(KukuKube);
                cuadrados[i][j].setBackground(administrador.
                        getColorAleatorio());
                panel.add(cuadrados[i][j]);
            }
        }
    }

    /**
     * Devuelve el cuadrado que tendrá el color diferente
     *
     * @param cuadrados
     * @return
     */
    private static JButton getCuadradoSeleccionado(JButton[][] cuadrados) {
        int[] CuadradoSeleccionado = administrador.getCoordenadasCuadrado();
        return cuadrados[CuadradoSeleccionado[0]][CuadradoSeleccionado[1]];
    }

    /**
     * Inicializa la Interfaz
     *
     * @return
     */
    private static JButton[][] construirInterfaz() {
        int dimensionGridActual = administrador.getDimensionGrid();
        JButton[][] cuadrados = new JButton[dimensionGridActual]
                [dimensionGridActual];
        //Coloca los cuadrados en su sitio
        panel.setLayout(new GridLayout(dimensionGridActual, 
                dimensionGridActual));
        administrador.asignarNuevosColeresCuadrado();
        ponerTablero(cuadrados);
        //Elige un cuadrado nuevo
        administrador.posicionCoordenadasCuadrado();
        //Cambia el color del cuadrado nuevo recientemente elegido 
        getCuadradoSeleccionado(cuadrados).setBackground(administrador.
                getColorAleatorioDiferente());
        SwingUtilities.updateComponentTreeUI(frame);
        return cuadrados;
    }

    /**
     * Actualiza el tablero y controla el final de la partida
     */
    private static void actualizarTablero() {
        limpiarTablero(cuadrados);

        if (administrador.partidaAcabada()) {
            JOptionPane.showConfirmDialog(frame, "El juego ha acabado");
            return;
        }

        administrador.actualizarTamañoTablero();;
        cuadrados = construirInterfaz();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton CuadradoSeleccionado = getCuadradoSeleccionado(cuadrados);
        if (e.getSource() == CuadradoSeleccionado) {
            actualizarTablero();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
