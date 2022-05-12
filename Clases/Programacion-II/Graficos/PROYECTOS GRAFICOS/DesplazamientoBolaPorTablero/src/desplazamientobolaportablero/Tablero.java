/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desplazamientobolaportablero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Juan
 */
public class Tablero extends JPanel {
        private Casilla [][] casillas=new Casilla[8][8];
        //numero de casillas en una fila y en una columna
        final int NUMERO_CASILLAS_LADO = 8;
        //número máximo de pixels del panel
        final int LADO_PANEL = 600;
        //número de pixels de un lado
        final int LADO_CASILLA = LADO_PANEL / NUMERO_CASILLAS_LADO;
        
        public Tablero() {
            //Instanciación de las componentes Casilla de la matriz casillas
            for (int fila=0; fila <8; fila++) {
                for (int columna=0;columna<8;columna++) {
                    casillas[fila][columna]=new Casilla(fila,columna,LADO_CASILLA);
                }
            }
            //inicializamos el objeto Casilla corespondiente a la componente (0,0)
            //con el estado de ocupada. Todas las demás componentes han sido inicializadasç
            //con el estado de liberada
            casillas[0][0].setOcupada();
            //asignamos el gestor de eventos de teclado al objeto PanelTablero
            addKeyListener(new EventosTeclado());
            //dirijimos la atención de la ejecución al objeto PanelTablero
            setFocusable(true);
            //redimensionamos el objeto PanelTablero
            setSize(606,628);
        }
      
        @Override
        public void paintComponent(Graphics g) {  
            //DECLARACIONES
            //instanciación objeto Graphics2D para acceder a las funcionalidades y entidades
            //de la libreria Graphics2D
            Graphics2D g2d = (Graphics2D) g;
            //asignar el color blanco como color de trazado 
            g2d.setColor(Color.WHITE);
            //instanciación objeto Rentangle que represente toda la superficie de visualización
            //con el objetivo de colorear el fondo de visualización con el color blanco
            Rectangle2D rectangulo=new Rectangle2D.Double(0,0,LADO_PANEL,LADO_PANEL);
            //visualización del objeto rectangulo
            g2d.fill(rectangulo);
            //Tratamiento iterativo para detectar la casilla del tablero ocupada y
            //dibujar en ella la bola roja
            for (int fila=0; fila < 8; fila++) {       
                for (int columna=0; columna < 8; columna++) {            
                    if (casillas[fila][columna].estado()) {     
                        //cambiar el color de trazado a ROJO
                        g.setColor(Color.RED);
                        //dibujo en la superficie de la casilla ocupada una bola
                        //de color rojo y de dimensiones 45x45 píxeles
                        g.fillOval(casillas[fila][columna].getX()+15, 
                                   casillas[fila][columna].getY()+15, 45, 45);
                    }                          
                }   
            }               
            //tratamiento iterativo para dibujar en el tablero las líneas horizontales y
            //verticales que representan la estructura del tablero en casillas
            int y = 0;     
            g.setColor(Color.BLACK);    
            for (int i = 1; i <= NUMERO_CASILLAS_LADO+1; i++) {       
                int x = 0;       
                for (int j = 1; j <= NUMERO_CASILLAS_LADO+1; j++) {           
                    g.drawLine(x, y, x, 600);         
                    g.drawLine(x, y, 600, y);          
                    x += LADO_CASILLA;        
                }       
                y += LADO_CASILLA;
            }
        }   
        
    //clase gestión de eventos del teclado
    private class EventosTeclado implements KeyListener {
            @Override
            public void keyPressed(KeyEvent evento) {
                boolean cambio=false;      
                for (int fila=0; fila < 8; fila++) {       
                    for (int columna=0; columna < 8; columna++) {        
                        if (casillas[fila][columna].estado()) {     
                            //En función de la casilla pulsada
                            switch (evento.getKeyText(evento.getKeyCode())) {
                                //Si la casilla pulsada es la casilla de dirección Arriba
                                case "Up": 
                                            
                                          if (columna!=0) {
                                              casillas[fila][columna-1].setOcupada();
                                              casillas[fila][columna].setLiberada();
                                           }
                                           cambio=true;
                                           break;
                                //Si la casilla pulsada es la casilla de dirección Derecha    
                                case "Right": 
                                          if (fila!=7) {
                                              casillas[fila+1][columna].setOcupada();
                                              casillas[fila][columna].setLiberada();
                                           }
                                           cambio=true;
                                           break;
                                //Si la casilla pulsada es la casilla de dirección Abajo
                                case "Down":  
                                            if (columna!=7) {
                                              casillas[fila][columna+1].setOcupada();
                                              casillas[fila][columna].setLiberada();
                                           }
                                           cambio=true;
                                           break;
                                //Si la casilla pulsada es la casilla de dirección Izquierda    
                                case "Left":  
                                          if (fila!=0) {
                                              casillas[fila-1][columna].setOcupada();
                                              casillas[fila][columna].setLiberada();
                                           }
                                           cambio=true;
                                           break;
                            }
                            break;
                        }           
                    }
                    //si ha habido ya un cambio se finaliza el tratamiento
                    if (cambio) {
                        break;
                    }
                }
                repaint();
            }

            @Override
            public void keyTyped(KeyEvent ke) { }

            @Override
            public void keyReleased(KeyEvent ke) { }        
    }
    
}
       
