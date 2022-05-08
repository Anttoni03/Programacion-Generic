// AUTOR: Antoni Frau Gordiola
/**
 * <a href="www.google.com"> Vídeo explicativo </a>
 */
package Practica_juego_del_7;


public class Jugador {
    private Carta[] cartas;
    
    public Jugador()
    {
        cartas = null;
    }
    
    public void setCartas(Carta[] cartas)
    {
        this.cartas = new Carta[cartas.length];
        for (int i = 0; i < this.cartas.length; i++) 
            this.cartas[i] = cartas[i].copiar();
    }
    
    public Carta[] getCartas()
    {
        return cartas;
    }
    public Carta getCarta(int i)
    {
        return cartas[i];
    }
    public int getCantidadCartas()
    {
        int contador = 0;
        
        for (int i = 0; i < cartas.length; i++)
            if (cartas[i].esAsignada()) contador++;
            
        return contador;
    }
    
    public Carta jugadaIA(Carta[] cartasMesa)
    {        
        for (int i = 0; i < cartas.length; i++)
        {
            if (!cartas[i].esAsignada()) continue;
            
            if (cartaValida(cartas[i], cartasMesa))
            {
                Carta temp = cartas[i].copiar();
                cartas[i] = new Carta();
                return temp;
            }
        }
        return null;
    }
    
    public Carta jugadaManual(int i, Carta[] cartasMesa)
    {
        if (cartaValida(cartas[i], cartasMesa))
        {
            Carta temp = cartas[i].copiar();
            cartas[i] = new Carta();
            return temp;
        }
        return null;
    }
    
    private boolean cartaValida(Carta carta, Carta[] mesa)
    {
        if (carta.getValor() == 7)
            return true;
        
        for (int j = 0; j < mesa.length; j++)
        {
            if (!mesa[j].esAsignada()) continue;


            if (j != 0)
            {
                if (mesa[j-1].esContigua(carta))
                    return true;
            }
            if (j != mesa.length-1)
            {
                if (mesa[j+1].esContigua(carta))
                    return true;
            }
        }

        return false;
    }
}
