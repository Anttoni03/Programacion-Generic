/*
 * Clase de panel de juego que gestiona los datos y acciones de toda una partida
 */
package taller2antonifraugordiola;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;

public class PanelJuego extends JPanel {
    
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que representa la cantidad de filas/columnas de cubos
    //del tablero en el nivel actual
    private int cantidad = 2;
    //Atributo de objeto que representa la complejidad de la partida
    private int complejidad;
    //Atributo de objeto que indica el color de los cuadrados del nivel actual
    private Color colorGeneral;
    //Atributo de objeto constante que guarda todos los cuadrados posibles a ver
    private final Cuadrado[] cuadrados;
    //Atributo de objeto constante que guarda el gestor eventos para asignar a
    //los cuadrados interactivos
    private final ActionListener gestorEventos;
    
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor que gestiona la instanciación de una PanelJuego
    public PanelJuego(ActionListener al)
    {
        //instanciar la cantidad cuadrada de cuadrados interactivos por fila
        cuadrados = new Cuadrado[12*12];
        //generar un color aleatorio general a asignar a los cuadrados
        Random r = new Random();
        colorGeneral = new Color(r.nextInt(196)+50,r.nextInt(196)+50,r.nextInt(196)+50);
        //guardar el gestor de eventos recibido;
        gestorEventos = al;
    }
    
    //Método actualizar que actualizar los valores del tablero por niveles
    public void actualizar()
    {
        //encuentra el índice del cuadrado diferente y lo reinicia
        int indice = 0;
        while (!cuadrados[indice].getDiferente()) indice++;
        cuadrados[indice].setNoDiferente();
        
        //desmarca todos los cuadrados
        for (int i = 0; i < cantidad * cantidad; i++) cuadrados[i].desmarcar();
        //aumenta la cantidad de cuadrados por fila/columna en 1
        cantidad++;
        
        //generar un color aleatorio general a asignar a los cuadrados
        Random r = new Random();
        colorGeneral = new Color(r.nextInt(196)+50,r.nextInt(196)+50,r.nextInt(196)+50);
    }
    
    //Método generarNuevoPanel que gestiona la creación de paneles por nivel
    public void generarNuevoPanel()
    {
        //cambiar el layout para actualizar filas y columnas
        int espacio = (cantidad < 6) ? 4 : ((cantidad < 9) ? 3 : 2);
        GridLayout glo = new GridLayout(cantidad, cantidad, espacio, espacio);
        setLayout(glo);
        
        //iniciar los cuadrados restantes la nueva cantidad que se requiera
        int inicio = (cantidad != 2) ? (cantidad-1) * (cantidad-1) : 0;
        for (int i = inicio; i < cantidad * cantidad; i++)
        {
            cuadrados[i] = new Cuadrado();
            //aplicar el gestor de eventos guardado a los cuadrados
            cuadrados[i].addActionListener(gestorEventos);
            //añadir los nuevos cuadrados al panel
            add(cuadrados[i]);
        }
        
        //aplicar a todos los cuadrados necesarios el color general
        for (int i = 0; i < cantidad * cantidad; i++)
            cuadrados[i].setBackground(colorGeneral);
        
        //indicar a un cuadrado aleatorio su diferenciación respecto a los demás
        int indice = new Random().nextInt(cantidad*cantidad);
        cuadrados[indice].setDiferente(complejidad);
    }
    
    //Método indicarFallo que gestiona cambios al fallar la selección del nivel
    public void indicarFallo(Cuadrado fallido)
    {
        //encuentra el índice del cuadrado diferente
        int indice = 0;
        while (!cuadrados[indice].getDiferente()) indice++;
        
        //marca el cuadrado diferente y el fallido
        cuadrados[indice].marcar();
        fallido.marcar();
    }
    
    //Método setComplejidad que recibe un entero y lo registra como dificultad
    public void setComplejidad(int cmp)
    {
        complejidad = cmp;
    }
    
    //Método getNivelActual que devuelve el nivel actual de la partida
    public int getNivelActual()
    {
        return cantidad-1;
    }
}