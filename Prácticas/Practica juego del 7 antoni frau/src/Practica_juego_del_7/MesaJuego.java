// AUTOR: Antoni Frau Gordiola
package Practica_juego_del_7;

import javax.swing.ImageIcon;

public class MesaJuego
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que indica los jugadores en la mesa
    private final Jugador[] JUGADORES = new Jugador[4];
    //Atributo de objeto que indica las cartas en la mesa
    private Carta[] cartasMesa;
    //Atributo de objeto que indica el turno de jugador actual
    private int turnoJugador = 0;
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor para instanciar el objeto MesaJuego
    public MesaJuego()
    {
        //bucle for para inicializar a los jugadores
        for (int i = 0; i < JUGADORES.length; i++)
        {
            //indicar una imagen por jugador, instanciarlo y aplicarle la imagen
            ImageIcon temp = new ImageIcon("Cartes/Jug"+i+"Riu.png");
            JUGADORES[i] = new Jugador();
            JUGADORES[i].setImagen(temp);
        }
        //reiniciar las cartas de la mesa
        cartasMesa = Baraja.getBaraja();
    }
    
    //Método barajarCartas que recibe un conjunto de cartas barajadas
    public void barajarCartas()
    {
        cartasMesa = Baraja.barajar();
    }
    
    //Método repartirCartas que reparte las cartas en mesa entre los jugadores
    public void repartirCartas()
    {
        //bucle for para aplicarle las cartas a todos los jugadores
        for (int i = 0; i < JUGADORES.length; i++)
        {
            //inicializar un array temporal por jugador a repartirle cartas
            Carta[] temp = new Carta[Baraja.getCantidadPalo()];
            //bucle for que reparte una cantidad de cartas por palo a jugadores
            for (int j = 0; j < temp.length; j++)
            {
                //añadir carta por parta al array temporal para repartir
                temp[j] = cartasMesa[i*Baraja.getCantidadPalo()+j].copiar();
                //iniciar las cartas repartidas como no asignadas en la mesa
                cartasMesa[i*Baraja.getCantidadPalo()+j] = new Carta();
            }
            //aplicarle las cartas indicadas al jugador
            JUGADORES[i].setCartas(temp);
        }
    }
    
    //Método jugarTurno que devuelve una carta si es posible jugar el turno
    public Carta jugarTurno(int modo)
    {
        //declarar una carta para devolver
        Carta carta;
        //indicar si se trata del jugador o de un jugador bot
        if (turnoJugador == 0)
            //si el modo es -1 indicar que no se puede
            if (modo == -1) return null;
            //si el modo no es -1 se usa para seleccionar la carta
            else carta = JUGADORES[turnoJugador].jugadaManual(modo, cartasMesa);
        else
            carta = JUGADORES[turnoJugador].jugadaBot(cartasMesa);
        
        //indicar la carta seleccionada a la mesa si no es nula y devolverla
        if (carta != null)
        {
            cartasMesa[Baraja.getPosicionDeCarta(carta)] = carta.copiar();
            return carta;
        }
        //devolver null al no haber llegado a devolver una carta
        return null;
    }
    
    //Método pasarTurno que avanza en 1 el turno activo de los jugadores
    public void pasarTurno()
    {
        turnoJugador = (turnoJugador + 1) % JUGADORES.length;
    }
    
    //Método haGanado que devuelve "true" si el jugador activo ha ganado
    public boolean haGanado()
    {
        //indicar si la cantidad de cartas del jugador activo es 0
        return JUGADORES[turnoJugador].getCantidadCartas() == 0;
    }
    
    //Método getTurnoJugador que devuelve el turno actual de los jugadores
    public int getTurnoJugador()
    {
        return turnoJugador;
    }
    //Método getJugador que devuelve el jugador indicado
    public Jugador getJugador(int i)
    {
        return JUGADORES[i];
    }
    //Método getCartas que devuelve las cartas de la mesa
    public Carta[] getCartas()
    {
        return cartasMesa;
    }
}
