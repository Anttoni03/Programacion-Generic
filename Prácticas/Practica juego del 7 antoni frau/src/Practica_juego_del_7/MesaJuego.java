// AUTOR: Antoni Frau Gordiola
/**
 * <a href="www.google.com"> Vídeo explicativo </a>
 */
package Practica_juego_del_7;


public class MesaJuego {
    private Jugador[] jugadores = new Jugador[4];
    private Carta[] cartasMesa;
    private int turnoJugador;
    
    public MesaJuego()
    {
        Baraja.inicializarBaraja();
        
        for (int i = 0; i < jugadores.length; i++) jugadores[i] = new Jugador();
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
    public boolean jugarTurno(int numero)
    {
        Carta carta;
        
        if (turnoJugador == 0 && numero == 0)
            return false;
        else if (turnoJugador == 0)
            carta = jugadores[turnoJugador].jugadaManual(numero, cartasMesa);
        else
            carta = jugadores[turnoJugador].jugadaIA(cartasMesa);
        
        if (carta != null)
        {
            System.out.println("Debug(pos carta) - " + Baraja.getPosicionDeCarta(carta));
            System.out.println("Debug(carta) - " + carta.toString());
            cartasMesa[Baraja.getPosicionDeCarta(carta)] = carta.copiar();
            return true;
        }
        System.out.println("A");
        return false;
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
    
    public Jugador getJugador(int i)
    {
        return jugadores[i];
    }
    public Carta[] getCartas()
    {
        return cartasMesa;
    }
}
