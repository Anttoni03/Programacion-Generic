// AUTOR: Antoni Frau Gordiola
package Practica_juego_del_7;

import java.util.Random;

public class Baraja
{
    /////////////////////  DECLARACIÓN DE ATRIBUTOS  /////////////////////
    //Atributo de clase que indica la cantidad de cartas por palo
    private static final int CANT_PALO = 13;
    //Atributo de clase que guarda la cantidad total de cartas
    private static final Carta[] BARAJA = new Carta[CANT_PALO * 4];
    
    
    //////////////////////////////  MÉTODOS  //////////////////////////////
    //Método inicializarBaraja que inicia las cartas con los valores por defecto
    public static void inicializarBaraja()
    {
        //bucle for para instanciar las cartas 
        for (int i = 0; i < BARAJA.length; i++)
        {
            //inicializar cada carta individualmente
            BARAJA[i] = new Carta();
            //inicializar el valor que tendrá la carta
            int valor = i + 1 - (CANT_PALO) * (i / CANT_PALO);
            //aplicar el valor a la carta
            BARAJA[i].setValor(valor);
            
            //iniciar la carta con el palo de picas
            if (i < CANT_PALO)
            {
                BARAJA[i].setPalo(Palo.PICAS);
                BARAJA[i].setImagen("Cartes/"+(valor)+"_of_spades.png");
            }
            //iniciar la carta con el palo de corazones
            else if (i < CANT_PALO*2)
            {
                BARAJA[i].setPalo(Palo.CORAZONES);
                BARAJA[i].setImagen("Cartes/"+(valor)+"_of_hearts.png");
            }
            //iniciar la carta con el palo de rombos
            else if (i < CANT_PALO*3)
            {
                BARAJA[i].setPalo(Palo.ROMBOS);
                BARAJA[i].setImagen("Cartes/"+(valor)+"_of_diamonds.png");
            }
            //iniciar la carta con el palo de tréboles
            else
            {
                BARAJA[i].setPalo(Palo.TREBOLES);
                BARAJA[i].setImagen("Cartes/"+(valor)+"_of_clubs.png");
            }
        }
    }
    
    //Método barajar que devuelve cartas barajadas con el algoritmo Fisher-Yeats
    public static Carta[] barajar()
    {
        //inicialización de el array de cartas barajadas
        Carta[] barajadas = new Carta[BARAJA.length];
        //inicialización de un objeto random para barajar
        Random r = new Random();
        
        //copiar las cartas de la baraja por defecto a la baraja a barajar
        for (int i = 0; i < barajadas.length; i++) barajadas[i] = BARAJA[i].copiar();
        
        //bucle for para ir barajando todas las cartas
        for (int i = barajadas.length-1; i > 0; i--)
        {
            //inicializar un entero aleatorio y una carta con ese índice
            int rand = r.nextInt(i);
            Carta temp = barajadas[rand].copiar();
            //mover la carta de posición i a la posición aleatoria generada
            barajadas[rand] = barajadas[i].copiar();
            //mover la carta aleatoriamente seleccionada a la posición i
            barajadas[i] = temp.copiar();
        }
        //devolver las cartas barajadas
        return barajadas;
    }
    
    //Método getPosicionDeCarta que devuelve la posición de una carta dada
    public static int getPosicionDeCarta(Carta carta)
    {
        for (int i = 0; i < BARAJA.length; i++)
        {
            //devuelve la posición si la carta dada coindice con alguna
            if (carta.getValor() == BARAJA[i].getValor() &&
                    carta.getPalo() == BARAJA[i].getPalo())
                return i;
        }
        //devuelve -1 si no se encuentra en la las bajara por defecto
        return -1;
    }
    
    //Método getBaraja que devuelve la baraja de cartas por defecto
    public static Carta[] getBaraja()
    {
        return BARAJA;
    }
    
    //método getCantidadPalo que devuelve la cantidad de cartas de un mismo palo
    public static int getCantidadPalo()
    {
        return CANT_PALO;
    }
}
