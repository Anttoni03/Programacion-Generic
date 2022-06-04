// AUTOR: Antoni Frau Gordiola
package Practica_juego_del_7;

import javax.swing.ImageIcon;

public class Jugador
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de objeto que indica las cartas de la mano del jugador
    private Carta[] cartas;
    //Atributo de objeto que indica la imagen que representa al jugador
    private ImageIcon imagen;
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método constructor para instanciar objetos Jugador
    public Jugador()
    {
        cartas = null;
    }
    
    //Método setCartas que inicializa las cartas de la mano con las cartas dadas
    public void setCartas(Carta[] cartas)
    {
        this.cartas = new Carta[cartas.length];
        for (int i = 0; i < this.cartas.length; i++) 
            this.cartas[i] = cartas[i].copiar();
    }
    //Método setImagen que indica la imagen del jugador 
    public void setImagen(ImageIcon img)
    {
        imagen = img;
    }
    
    //Método getCartas que devuelve las cartas de la mano
    public Carta[] getCartas()
    {
        return cartas;
    }
    //Método getCarta que devuelve la cartas de la mano con posición dada
    public Carta getCarta(int i)
    {
        return cartas[i];
    }
    //Método getCantidadCartas que devuelve la cantidad de cartas en la mano
    public int getCantidadCartas()
    {
        //inicializar contador para llevar la cuenta de cartas asignadas
        int contador = 0;
        //contar la cantidad de cartas asignadas porque son las cartas activas
        for (int i = 0; i < cartas.length; i++)
            if (cartas[i].esAsignada()) contador++;
        //devolver la cantidad de cartas activas contadas
        return contador;
    }
    //Método getImagen que devuelve la imagen asociada al jugador
    public ImageIcon getImagen()
    {
        return imagen;
    }
    
    //Método jugadaBot que devuelve una carta como jugada de un jugador máquina
    public Carta jugadaBot(Carta[] cartasMesa)
    {
        //bucle for para repasar todas las cartas disponibles
        for (int i = 0; i < cartas.length; i++)
        {
            //no admitir como opción una carta no asignada
            if (!cartas[i].esAsignada()) continue;
            
            //si es válida para usarse en la mesa se selecciona dicha carta
            if (cartaValida(cartas[i], cartasMesa))
            {
                Carta temp = cartas[i].copiar();
                cartas[i] = new Carta();
                return temp;
            }
        }
        //devuelve null si no hay ninguna carta disponible para usar
        return null;
    }
    
    //Método jugadaManual que devuelve una carta por la jugada de un humano
    public Carta jugadaManual(int i, Carta[] cartasMesa)
    {
        //si es válida para usarse en la mesa se selecciona dicha carta
        if (cartaValida(cartas[i], cartasMesa))
        {
            Carta temp = cartas[i].copiar();
            cartas[i] = new Carta();
            return temp;
        }
        //devuelve null si la carta no está disponible para usar
        return null;
    }
    
    //Método cartaValida que indica si una carta es o no válida
    private boolean cartaValida(Carta carta, Carta[] mesa)
    {
        //indicar que si la carta es un 7, por esencia del juego, es válida
        if (carta.getValor() == 7) return true;
        
        //bucle for para reconocer si la carta es válida para seleccionarla
        for (int j = 0; j < mesa.length; j++)
        {
            if (!mesa[j].esAsignada()) continue;
            
            if (mesa[j].esContigua(carta)) return true;
        }

        return false;
    }
}
