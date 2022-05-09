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
        //cartasMesa = new Carta[jugadores.length * Baraja.getCantidadPalo()];
        
        for (int i = 0; i < jugadores.length; i++) jugadores[i] = new Jugador();
        turnoJugador = 0;
        
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
    
    public boolean jugarTurno(int numero)
    {
        Carta carta;
        
        if (turnoJugador == 0)
            carta = jugadores[turnoJugador].jugadaManual(numero, cartasMesa);
        else
            carta = jugadores[turnoJugador].jugadaIA(cartasMesa);
        
        if (carta != null)
        {
            cartasMesa[Baraja.getPosicionDeCarta(carta)] = carta.copiar();
            return true;
        }
        else return false;
    }
    
    public void pasarTurno()
    {
        turnoJugador = (turnoJugador + 1) % jugadores.length;
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
