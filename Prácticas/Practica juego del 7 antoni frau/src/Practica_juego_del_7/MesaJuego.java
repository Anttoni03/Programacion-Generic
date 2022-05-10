// AUTOR: Antoni Frau Gordiola
/**
 * <a href="www.google.com"> Vídeo explicativo </a>
 */
package Practica_juego_del_7;

import javax.swing.ImageIcon;


public class MesaJuego {
    private Jugador[] jugadores = new Jugador[4];
    private Carta[] cartasMesa;
    private int turnoJugador;
    
    public MesaJuego()
    {
        Baraja.inicializarBaraja();
        
        for (int i = 0; i < jugadores.length; i++)
        {
            ImageIcon temp = new ImageIcon("Cartes/Jug"+i+"Riu.png");
            
            jugadores[i] = new Jugador();
            jugadores[i].setImagen(temp);
        }
        turnoJugador = 0;
        
        reiniciarCartas();
    }
    
    public void reiniciarCartas()
    {
        cartasMesa = Baraja.getNuevaBaraja();
    }
    
    public void barajarCartas()
    {
        cartasMesa = Baraja.barajar();
    }
    
    public void repartirCartas()
    {
        Carta[] temp;
        
        for (int i = 0; i < jugadores.length; i++)
        {
            temp = new Carta[Baraja.getCantidadPalo()];
            
            for (int j = 0; j < temp.length; j++)
            {
                temp[j] = cartasMesa[i*Baraja.getCantidadPalo()+j].copiar();
                cartasMesa[i*Baraja.getCantidadPalo()+j] = new Carta();
            }
            
            jugadores[i].setCartas(temp);
        }
    }
    
    //Método de jugar el turno del jugador al que le toque y que devuelve true
    //si se ha seleccionado una carta válida y false si no
    public Carta jugarTurno(int numero)
    {
        Carta carta;
        
        if (turnoJugador == 0 && numero == -1)
            return null;
        else if (turnoJugador == 0)
            carta = jugadores[turnoJugador].jugadaManual(numero, cartasMesa);
        else
            carta = jugadores[turnoJugador].jugadaIA(cartasMesa);
        
        if (carta != null)
        {
            cartasMesa[Baraja.getPosicionDeCarta(carta)] = carta.copiar();
            return carta;
        }
        return null;
    }
    
    public void pasarTurno()
    {
        turnoJugador = (turnoJugador + 1) % jugadores.length;
    }
    
    public int haGanado()
    {
        for (int i = 0; i < jugadores.length; i++)
        {
            if (jugadores[i].getCantidadCartas() == 0) return i;
        }
        
        return -1;
    }
    
    public int getTurnoJugador()
    {
        return turnoJugador;
    }
    
    public Jugador getJugador(int i)
    {
        return jugadores[i];
    }
    public Carta[] getCartas()
    {
        return cartasMesa;
    }
}
