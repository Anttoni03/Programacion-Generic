package taller2.pkg0;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Alberto Pérez Ancín
 */
public class AdministradorKukuKube {

    //CONSTANTES
    public static final int TAMAÑO_MAXIMO_GRID = 11;
    public static final int NUMERO_COMPONENTES_COLOR = 3;
    public static final int NUMERO_VALORES_RGB = 256;
    private static final int CANTIDAD_COLOR = 20;
    private static final int VALOR_MINIMO_GRID = 30;
    //DECLARACIONES
    private int dimensionGrid;
    private int clickarCorrectamente;
    private final int[] coordenadasCuadrado;
    private final Random r;
    private Color colorAleatorio;
    private Color colorAleatorioDiferente;

    public AdministradorKukuKube() {
        r = new Random();
        dimensionGrid = 2;
        coordenadasCuadrado = new int[2];
    }

    /**
     * Asigna nuevos colores a los cuadrados Primero, de manera aleatoria elige
     * un color para finalmente reducir el valor de la R, G y B del color
     * aleatoreo creando un color aleatoreo diferente parecido al primer color
     * creado
     */
    public void asignarNuevosColeresCuadrado() {
        int[] rgb = new int[3];
        int[] rgbDiferente = new int[3];
        for (int i = 0; i < NUMERO_COMPONENTES_COLOR; i++) {

            rgb[i] += r.nextInt(NUMERO_VALORES_RGB - VALOR_MINIMO_GRID) + 
                    VALOR_MINIMO_GRID;

            rgbDiferente[i] = (rgb[i]) - CANTIDAD_COLOR;
        }
        colorAleatorio = new Color(rgb[0], rgb[1], rgb[2]);
        colorAleatorioDiferente = new Color(rgbDiferente[0], rgbDiferente[1], 
                rgbDiferente[2]);
    }

    // GETTER COLOR ALEATORIO
    public Color getColorAleatorio() {
        return colorAleatorio;
    }

    // GETTER COLOR ALEATORIO DIFERENTE 
    public Color getColorAleatorioDiferente() {
        return colorAleatorioDiferente;
    }

    // GETTTER COORDENADAS CUADRADO
    public int[] getCoordenadasCuadrado() {
        return coordenadasCuadrado;
    }

    // GETTER DIMENSION GRID
    public int getDimensionGrid() {
        return dimensionGrid;
    }

    /**
     *
     * @return Verdadero si el juego se ha acabado y falso si no.
     */
    public boolean partidaAcabada() {
        return dimensionGrid >= TAMAÑO_MAXIMO_GRID;
    }

    /**
     * Actualiza el tamaño del tablero para pasar al siguiente nivel si ha
     * acertado el cuadrado diferente
     */
    public void actualizarTamañoTablero() {
        if (clickarCorrectamente % 1 == 0) {
            dimensionGrid++;
        }
    }

    // GETTER CLICKAR CORRECTAMENTE
    public int getClickarCorrectamente() {
        return clickarCorrectamente;
    }

    // SETTER CLICKAR CORRECTAMENTE
    public void setClickarCorrectamente(int ClickarCorrectamente) {
        this.clickarCorrectamente = clickarCorrectamente;
    }

    /**
     * Elige aleatoreamente un cuadrado
     */
    public void posicionCoordenadasCuadrado() {
        coordenadasCuadrado[0] = r.nextInt(dimensionGrid);
        coordenadasCuadrado[1] = r.nextInt(dimensionGrid);
    }
}
