/*
    AUTOR: Alex Rodríguez Nieto
    ASIGNATURA: Programación II
    PROFESOR: Juan Montes de Oca
 */
package taller_2.taller_2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class Programa_principal {
    
    public static void main(String [] args){
        
        new Programa_principal().metodoPrincipal();
        
    }
    
    //DECLARACIÓN DE VARIABLES
    //Variable que guardara el numero de niveles que el jugador introduzca por teclado
    int numeroNiveles;
    //Variable que guardara el numero de dificultad que el jugador introduzca por teclado
    int numeroComplejidad;
    //Variable que irá guardando el nivel actual en el que se encuentra la partida
    int nivel = 0;
    //Variable que irá guardando la puntuación obtenida
    int puntuacion = 0;
    //Variable JButton que nos servirá para generar todos aquellos botones en los que si el usuario pulsa, contará como un error
    JButton botonMalo;
    //Variable JButton que nos servirá para generar el botón diferente al resto, y por tanto el botón al que el usuario debería darle
    JButton botonBueno;
    //Variable ActionListener con la que controlaremos todos los eventos que se produzcan
    ActionListener manipuladorEventos;
    //Variable booleana que nos permitirá saber si hay una partida en curso o no
    boolean partidaEnCurso;
    
    private void metodoPrincipal(){
        
        //VENTANA
        //JFrame que será la ventana principal en la que estará todo el programa
        JFrame ventana = new JFrame("Taller 2");
        //Container que cogemos a partir del JFrame anterior
        Container panelContenidos = ventana.getContentPane();
        
        //PANEL VISUALIZACIÓN
        //JPanel donde estará el logo de la UIB y posteriormente el juego con los botones al inicar una partida
        JPanel panelVisualizacion = new JPanel();
        //Le asignamos un CardLayout para poder cambiar entre el panel de menu y el panel de juego
        panelVisualizacion.setLayout(new CardLayout());
        
        //GESTOR DE EVENTOS
        manipuladorEventos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evento){
                
                //Variable CardLayout que nos permitirá elegir que panel queremos enseñar
                CardLayout local = (CardLayout)(panelVisualizacion.getLayout());
                
                switch(evento.getActionCommand()){
                    
                    //Si el usuario le da a cualquier botón con el nombre Salir el programa se detendrá
                    case "SALIR":       System.exit(0);
                    
                    //Si el usuario le da a cualquier botón con el nombre Nueva Partida en caso de que ya haya una partida en curso se mostrará un mensaje
                    //a través de una ventana emergente al usuario, en caso de que no haya una partida en curso se le pedirá al usuario que introduzca el
                    //número de niveles y la dificultad a través de 2 ventanas emergentes, si los niveles y la dificultad están en el rango correcto se iniciará
                    //una partida creando un nuevo JPanel panelJuego y pasándolo por parámetro al subprograma partida y se mostrará el panel de juego en pantalla,
                    //en caso de que el nivel o la complejidad no estén en el rango correcto se le avisará al usuario a través de una ventana emergente
                    case "NUEVA PARTIDA":   if(partidaEnCurso){
                        
                                                JOptionPane.showMessageDialog(null, "¡¡¡ NO SE PUEDE INICIAR UNA PARTIDA HABIENDO UNA PARTIDA EN CURSO !!!");
                                                break;
                        
                                            }
                                                
                                            String niveles = JOptionPane.showInputDialog(ventana, "Número de niveles (1-10):");
                                            String complejidad = JOptionPane.showInputDialog(ventana, "Número de dificultad (1-10):");
                                            
                                            if((niveles != null) && (complejidad != null) && (0 < Integer.parseInt(niveles)) && (11 > Integer.parseInt(niveles)) &&
                                               (0 < Integer.parseInt(complejidad)) && (11 > Integer.parseInt(complejidad))){
                                                
                                                nivel = 1;
                                                numeroNiveles = Integer.parseInt(niveles);
                                                numeroComplejidad = Integer.parseInt(complejidad);
                                                
                                                //PANEL JUEGO
                                                JPanel panelJuego = new JPanel();
                                                partida(panelJuego);
                                                panelVisualizacion.add(panelJuego, "panelJuego");
                                            
                                                local.show(panelVisualizacion, "panelJuego");
                                                
                                                partidaEnCurso = true;
                                                
                                            }
                                            
                                            else{
                                                
                                                JOptionPane.showMessageDialog(null, "¡¡¡ RANGO DE NIVELES O DE DIFICULTAD INCORRECTO !!!");
                                                
                                            }
                                            
                                            break;
                    
                    //Si el usuario le da a un boton malo el borde de este se pondrá en rojo y el borde del botón correcto se pondrá en verde, además se avisará
                    //al usuario de que ha fallado a través de una ventana emergente, en caso de que se encuentre en el último nivel también avisaremos al usuario
                    //de que la partida ha terminado a través de una ventana emergente, volveremos a restablecer todas la variables necesarias y mostraremos el menu,
                    //en caso de que la partida aún no se encuentre en el último nivel simplemente nos iremos al siguiente nivel
                    case " ":     JButton boton = (JButton)evento.getSource();
                                  boton.setBorder((BorderFactory.createLineBorder(Color.RED, 3)));
                                  botonBueno.setBorder((BorderFactory.createLineBorder(Color.GREEN, 3)));
                    
                                  JFrame ventanaEmergente = new JFrame();
                                  JOptionPane.showMessageDialog(ventanaEmergente, "¡¡¡ CUADRADRO SELECCIONADO ERRÓNEO !!!");
                                  
                                  if(nivel == numeroNiveles){

                                    nivel = 1;
                                    JOptionPane.showMessageDialog(null, "LA PARTIDA HA TERMINADO CON UN TOTAL DE " + puntuacion + " PUNTOS");
                                    puntuacion = 0;
                                    partidaEnCurso = false;
                                    local.show(panelVisualizacion, "panelStandby");

                                  }

                                else{
                                      
                                    nivel++;
                                    //PANEL JUEGO
                                    JPanel panelJuego = new JPanel();
                                    partida(panelJuego);
                                    panelVisualizacion.add(panelJuego, "panelJuego");

                                    local.show(panelVisualizacion, "panelJuego");

                                }
                                  
                                  break;
                    
                }
                
                //Si el usuario le da al botón bueno en caso de que sea el último nivel se sumará la puntuación correspondiente, avisaremos al usuario
                //de que la partida ha terminado a través de una ventana emergente, volveremos a restablecer todas la variables necesarias y mostraremos el menu,
                //en caso contrario sumaremos la puntuación correspondiente y nos iremos al siguiente nivel
                if(evento.getSource() == botonBueno){
                    
                    if(nivel == numeroNiveles){
                        
                        puntuacion += (nivel + 1);
                        nivel = 1;
                        JOptionPane.showMessageDialog(null, "LA PARTIDA HA TERMINADO CON UN TOTAL DE " + puntuacion + " PUNTOS");
                        puntuacion = 0;
                        partidaEnCurso = false;
                        local.show(panelVisualizacion, "panelStandby");
                        
                    }
                    
                    else{
                        
                        puntuacion += (nivel + 1);
                        nivel++;
                        //PANEL JUEGO
                        JPanel panelJuego = new JPanel();
                        partida(panelJuego);
                        panelVisualizacion.add(panelJuego, "panelJuego");

                        local.show(panelVisualizacion, "panelJuego");
                        
                    }
                }
                
            }
            
        };
        
        //PANEL STANDBY
        //Variable JPanel que será la que usaremos como menú
        JPanel panelStandby = new JPanel();
        panelStandby.setLayout(new BorderLayout());
        
        //PANEL INFORMATIVO
        //Incorporamos el panelInformativo al norte dentro del Panel que forma el menú
        panelInformativo(panelStandby);
        
        //IMAGEN
        //Colocamos la imagen de la UIB en el centro del panel
        JLabel imagenUib = new JLabel(new ImageIcon("uib.gif"));
        panelStandby.add(imagenUib, BorderLayout.CENTER);
        
        panelVisualizacion.add(panelStandby, "panelStandby");
        
        panelContenidos.add(panelVisualizacion, BorderLayout.CENTER);
        
        //PANEL BOTONES
        //Colocamos el panel de abajo que contendrá los botones Nueva Partida y Salir
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,2));
        
        //BOTONES
        //BOTÓN NUEVA PARTIDA
        JButton botonNuevaPartida = new JButton("NUEVA PARTIDA");
        botonNuevaPartida.setBackground(Color.BLACK);
        botonNuevaPartida.setForeground(Color.WHITE);
        botonNuevaPartida.setFont(new Font("arial", 0, 20));
        botonNuevaPartida.addActionListener(manipuladorEventos);
        panelBotones.add(botonNuevaPartida, BorderLayout.WEST);
        //BOTÓN SALIR
        JButton botonSalir = new JButton("SALIR");
        botonSalir.setBackground(Color.BLACK);
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setFont(new Font("arial", 0, 20));
        botonSalir.addActionListener(manipuladorEventos);
        panelBotones.add(botonSalir, BorderLayout.EAST);
        //SEPARADOR ENTRE PANEL DE BOTONES Y PANEL DE VISUALIZACIÓN
        JSplitPane separadorBotonesVisualizacion = new JSplitPane(SwingConstants.HORIZONTAL, panelVisualizacion, panelBotones);
        panelContenidos.add(separadorBotonesVisualizacion);
        
        panelContenidos.add(panelBotones, BorderLayout.SOUTH);
        
        //MENU
        //Colocamos el Menu con sus respectivas opciones
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        JMenuItem nuevaPartidaMenu = new JMenuItem("NUEVA PARTIDA");
        JMenuItem salirMenu = new JMenuItem("SALIR");
        nuevaPartidaMenu.addActionListener(manipuladorEventos);
        salirMenu.addActionListener(manipuladorEventos);
        menu.add(nuevaPartidaMenu);
        menu.add(salirMenu);
        barraMenu.add(menu);
        
        panelContenidos.add(barraMenu, BorderLayout.NORTH);
        
        //VISUALIZACIÓN DE LA VENTANA
        //Ajustamos el tamaño de la ventana, que se cierre al darle a la cruz, que no se pueda redimensionar y que sea visible
        ventana.setSize(808, 930);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);
        
    }
    
    //Subprograma partida que nos irá generando los niveles a medida que avanza la partida
    private void partida(JPanel panelJuego){
        
        //Asignamos un nuevo BorderLayout al panel de juego
        panelJuego.setLayout(new BorderLayout());
        //Creamos un nuevo panel panelJuegoBotones para poderlo diferenciar del panelInformativo que añadiremos más adelante
        JPanel panelJuegoBotones = new JPanel();
        Random random = new Random();
        //Creamos un color totalmente aleatorio
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        //Dividimos el panelJuegoBotones en las casillas que sea necesarias dependiendo del nivel en el que nos encontremos
        panelJuegoBotones.setLayout(new GridLayout(nivel + 1, nivel + 1));
        //Escogemos de manera aleatoria una de estas celdas que será la casilla donde irá el botón diferente
        int celdaRandom = random.nextInt((nivel + 1)*(nivel + 1));
        
        //Bucle para recorrer todas las casillas en las que está dividida el panelJuegoBotones
        for(int i = 0; i < (nivel + 1)*(nivel + 1); i++){
            
            //Creamos un nuevo botonMalo con el nombre " " con el cuál podremos acceder desde el manipulador de eventos
            botonMalo = new JButton(" ");
            
            //Si se trata de la celda que hemos seleccionado de manera aleatoria creamos el botón diferente en esta casilla
            if(celdaRandom == i){
                
                botonBueno = new JButton();
                Color colorDiferente = colorDiferente(color);
                botonBueno.setBackground(colorDiferente);
                botonBueno.setBorder((BorderFactory.createLineBorder(Color.WHITE, 2)));
                botonBueno.addActionListener(manipuladorEventos);
                panelJuegoBotones.add(botonBueno);
                
            }
            
            //Si no se trata de la casilla seleccionada aleatoriamente se añadirá un botón malo en esa casilla
            else{
                
                botonMalo.setBackground(color);
                botonMalo.setBorder((BorderFactory.createLineBorder(Color.WHITE, 2)));
                botonMalo.addActionListener(manipuladorEventos);
                panelJuegoBotones.add(botonMalo);
                
            }
            
        }
        
        //Metemos el panelJuegoBotones en el centro dentro del panelJuego
        panelJuego.add(panelJuegoBotones, BorderLayout.CENTER);
        //Metemos el panelInformativo al norte dentro del panelJuego
        panelInformativo(panelJuego);
        
    }
    
    //Subprograma colorDiferente que nos permitirá crear un color diferente en la casilla seleccionada aleatoriamente dependiendo de la dificultad
    private Color colorDiferente(Color color){
        
            //Variable Color donde guardaremos este color diferente
            Color colorDiferente;
            //A cada una de las componentes del color de las otras casillas le sumamos un numero que va a depender de la dificultad seleccionada por el usuario,
            //mientras más dificultad menos se le sumará a las componentes del color y por tanto más difícil de distinguir de las otras casillas
            int componenteRojo = color.getRed() + 4*(11 - numeroComplejidad);
            int componenteVerde = color.getGreen() + 4*(11 - numeroComplejidad);
            int componenteAzul = color.getBlue() + 4*(11 - numeroComplejidad);  
            
            //En caso de que al sumarle un número a la componente esta se salga del rango que tiene, lo que haremos será restarle ese número en vez de sumarselo
            if(componenteRojo > 255){
                
                componenteRojo = componenteRojo-((4*(11 - numeroComplejidad))*2);
                
            }
            
            if(componenteVerde > 255){
                
                componenteVerde = componenteVerde-((4*(11 - numeroComplejidad))*2);
                
            }
            
            if(componenteAzul > 255){
                
                componenteAzul = componenteAzul-((4*(11 - numeroComplejidad))*2);
                
            }
            
            //Le asignamos las nuevas componentes a la variable colorDiferente
            colorDiferente = new Color(componenteRojo, componenteVerde, componenteAzul);
            
            //Devolvemos el colorDiferente
            return colorDiferente;
            
    }
    
    //Subprograma que nos servirá para crear el panelInformativo, tanto en el menu como dentro del juego
    private void panelInformativo(JPanel panel){
        
        //Creamos el panelInformativo con el fondo negro y le asignamos un GridBagLayout para poderlo separar en casillas de distinto tamaño entre si
        JPanel panelInformativo = new JPanel();
        panelInformativo.setLayout(new GridBagLayout());
        panelInformativo.setBackground(Color.BLACK);
        
        //Creamos un GridBagContraints que nos servirá para poder indicar cuanto tiene que ocupar cada componente a nivel de casillas
        GridBagConstraints constraints = new GridBagConstraints();
        
        //NIVELES PARTIDA
        //Añadimos la etiqueta Niveles Partida
        JLabel nivelesPartida = new JLabel("NIVELES PARTIDA");
        nivelesPartida.setBackground(Color.WHITE);
        nivelesPartida.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        nivelesPartida.setOpaque(true);
        nivelesPartida.setFont(new Font("arial", 1, 25));
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 3; // El área de texto ocupa 3 columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(nivelesPartida, constraints);
        
        //NÚMERO NIVELES PARTIDA
        //Añadimos la etiqueta que indica el numero de Niveles de la Partida
        //Esta etiqueta irá cambiando dependiendo de la variable numeroNiveles
        String nombreNumeroNivelesPartida = cerosIzquierda(numeroNiveles) + numeroNiveles;
        JLabel numeroNivelesPartida = new JLabel(nombreNumeroNivelesPartida);
        numeroNivelesPartida.setBackground(Color.WHITE);
        numeroNivelesPartida.setForeground(Color.RED);
        numeroNivelesPartida.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        numeroNivelesPartida.setOpaque(true);
        numeroNivelesPartida.setFont(new Font("arial", 1, 25));
        constraints.gridx = 4; // El área de texto empieza en la columna cuatro.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa 1 columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(numeroNivelesPartida, constraints);
        
        //ESPACIO1
        JLabel espacio1 = new JLabel("                                                                  ");
        espacio1.setBackground(Color.BLACK);
        espacio1.setOpaque(true);
        panelInformativo.add(espacio1);
        
        //NIVELES RESTANTES
        //Añadimos la etiqueta Niveles Restantes
        JLabel nivelesRestantes = new JLabel("NIVELES RESTANTES");
        nivelesRestantes.setBackground(Color.WHITE);
        nivelesRestantes.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        nivelesRestantes.setOpaque(true);
        nivelesRestantes.setFont(new Font("arial", 1, 25));
        constraints.gridx = 7; // El área de texto empieza en la columna siete.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 3; // El área de texto ocupa 3 columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(nivelesRestantes, constraints);
        
        //NÚMERO NIVELES RESTANTES
        String nombreNumeroNivelesRestantes;
        //Si el numero de niveles restantes es negativo significa que estamos en el menú y por tanto debemos mostrar un 0,
        //en caso de que estemos en partida mostraremos el número de niveles restantes
        if(numeroNiveles - nivel < 0){
            nombreNumeroNivelesRestantes = cerosIzquierda(numeroNiveles - nivel) + 0;
        }
        else{
            nombreNumeroNivelesRestantes = cerosIzquierda(numeroNiveles - nivel) + (numeroNiveles - nivel);           
        }
        JLabel numeroNivelesRestantes = new JLabel(nombreNumeroNivelesRestantes);
        numeroNivelesRestantes.setBackground(Color.WHITE);
        numeroNivelesRestantes.setForeground(Color.RED);
        numeroNivelesRestantes.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        numeroNivelesRestantes.setOpaque(true);
        numeroNivelesRestantes.setFont(new Font("arial", 1, 25));
        constraints.gridx = 10; // El área de texto empieza en la columna diez.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa 1 columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(numeroNivelesRestantes, constraints);
        
        //NIVEL ACTUAL
        //Añadimos la etiqueta Nivel Actual
        JLabel nivelActual = new JLabel("NIVEL ACTUAL      ");
        nivelActual.setBackground(Color.WHITE);
        nivelActual.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        nivelActual.setOpaque(true);
        nivelActual.setFont(new Font("arial", 1, 25));
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila uno
        constraints.gridwidth = 3; // El área de texto ocupa 3 columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(nivelActual, constraints);
        
        //NÚMERO NIVEL ACTUAL
        //Esta etiqueta irá cambiando dependiendo de la variable nivel
        String nombreNumeroNivelActual = cerosIzquierda(nivel) + nivel;
        JLabel numeroNivelActual = new JLabel(nombreNumeroNivelActual);
        numeroNivelActual.setBackground(Color.WHITE);
        numeroNivelActual.setForeground(Color.RED);
        numeroNivelActual.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        numeroNivelActual.setOpaque(true);
        numeroNivelActual.setFont(new Font("arial", 1, 25));
        constraints.gridx = 4; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        panelInformativo.add(numeroNivelActual, constraints);
        
        //ESPACIO2
        JLabel espacio2 = new JLabel("                                                                  ");
        espacio1.setBackground(Color.BLACK);
        espacio1.setOpaque(true);
        constraints.gridx = 5; // El área de texto empieza en la columna cinco.
        constraints.gridy = 1; // El área de texto empieza en la fila uno
        constraints.gridwidth = 3; // El área de texto ocupa tres columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(espacio2, constraints);
        
        //PUNTUACIÓN
        //Añadimos la etiqueta Punutación
        JLabel etiquetaPuntuacion = new JLabel("PUNTUACIÓN              ");
        etiquetaPuntuacion.setBackground(Color.WHITE);
        etiquetaPuntuacion.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        etiquetaPuntuacion.setOpaque(true);
        etiquetaPuntuacion.setFont(new Font("arial", 1, 25));
        constraints.gridx = 7; // El área de texto empieza en la columna siete.
        constraints.gridy = 1; // El área de texto empieza en la fila uno
        constraints.gridwidth = 3; // El área de texto ocupa 3 columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(etiquetaPuntuacion, constraints);
        
        //NÚMERO PUNTUACIÓN
        //Esta etiqueta dependerá de la variable puntuacion
        String nombreNumeroPuntuacion = cerosIzquierda(puntuacion) + puntuacion;
        JLabel numeroPuntuacion = new JLabel(nombreNumeroPuntuacion);
        numeroPuntuacion.setBackground(Color.WHITE);
        numeroPuntuacion.setForeground(Color.RED);
        numeroPuntuacion.setBorder((BorderFactory.createLineBorder(Color.BLACK, 3)));
        numeroPuntuacion.setOpaque(true);
        numeroPuntuacion.setFont(new Font("arial", 1, 25));
        constraints.gridx = 10; // El área de texto empieza en la columna diez.
        constraints.gridy = 1; // El área de texto empieza en la fila uno
        constraints.gridwidth = 1; // El área de texto ocupa 1 columnas.
        constraints.gridheight = 1; // El área de texto ocupa 1 filas.
        panelInformativo.add(numeroPuntuacion, constraints);
        
        //Añadimos el panelInformativo al panel que nos han pasado por parámetro, que puede ser el menú o el panel de juego
        panel.add(panelInformativo, BorderLayout.NORTH);
        
    }
    
    //Subprograma cerosIzquierda que nos permitirá poner ceros a la izquierda en las etiquetas del panelInformativo
    private String cerosIzquierda(int valor){
        
        //Creamos una variable String vacía
        String ceros = "";
        
        //En caso de que el valor que nos pasan por parametro sea mayor que 10 significa que tan solo debemos colocar un 0 a la izquierda
        if(valor > 9){
                ceros += 0;
        }
        
        //En caso de que la variable sea menor que 10 significa que debemos colocar 2 ceros a la izquierda
        else{
            for(int i = 0; i < 2; i++){
                ceros += 0;
            }
        }
        
        //Devolvemos el String
        return ceros;
        
    }
    
}