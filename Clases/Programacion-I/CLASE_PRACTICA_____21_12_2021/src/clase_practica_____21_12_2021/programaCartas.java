/*
FUNCIONALIDAD: programa que utiliza la clase Carta para generar una baraja 
de cartas españolas y visualizar el reparto aleatorio 
de un número de cartas de la misma
 */
package clase_practica_____21_12_2021;
import java.util.Random;

public class programaCartas {
    //DECLARACIÓN ATRIBUTOS
    private static final int NUMERO_CARTAS=48;
    private static Carta [] baraja=new Carta[NUMERO_CARTAS];
    
    //método main
    public static void main(String[] args) throws Exception {
        new programaCartas().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        int numeroCartasRepartir;
        
        //ACCIONES
        generacionCartas();
        System.out.print("NÚMERO DE CARTAS A REPARTIR: ");
        numeroCartasRepartir = LT.readInt();
        int [] cartasRepartidas = repartir(numeroCartasRepartir);
        for (int indice = 0; indice < numeroCartasRepartir; indice++) {
            System.out.println(baraja[cartasRepartidas[indice]]);
        }
    }

    //método que lleva a cabo la generación de la baraja de cartas con los
    //palos de la baraja española
    private static void generacionCartas() {
        //ACCIONES
        //bucle de generación de las carats de la baraja
        for (int indice = 0; indice < 48; indice = indice + 4) {
            baraja[indice] = new Carta("OROS", (indice / 4) + 1);
            baraja[indice + 1] = new Carta("COPAS", (indice / 4) + 1);
            baraja[indice + 2] = new Carta("ESPADAS", (indice / 4) + 1);
            baraja[indice + 3] = new Carta("BASTOS", (indice / 4) + 1);
        }
    }

    private static int[] repartir(int numeroCartasRepartir) {
        //DECLARACIONES
        //declaración variable array de componentes enteras para almacenar las
        //cartas resultantes del proceso de repartir
        int [] cartasRepartidas = new int[numeroCartasRepartir];
        //declaración variable array de componentes booleanas para representar
        //con sus componentes las cartas de la baraja que han sido repartidas
        boolean [] cartasDadas = new boolean[baraja.length];
        //declaración objeto Random para introducir la aleatoriedad en el reparto de
        //cartas
        Random aleatorio = new Random();
        //declaración variable entera para almacenar el número de carta a repartir
        //resultante del proceso aleatorio
        int numero;
        
        //ACCIONES
        //inicialización a false de todas las componentes del array cartasDadas
        for (int indice = 0; indice < baraja.length; indice++) {
            cartasDadas[indice] = false;
        }
        //bucle de reparto de numeroCartasRepartir cartas a través del proceso aleatorio
        for (int indice = 0; indice < numeroCartasRepartir; indice++) {
            //generar número de carta aleatorio hasta que represente una carta
            //no repartida
            do {
                numero = aleatorio.nextInt(baraja.length);
            } while (cartasDadas[numero]);
            //actualizar la componente del array cartasDadas
            cartasDadas[numero] = true;
            //introducir el indice de la carta resultante del reparto en el array
            cartasRepartidas[indice] = numero;
        }
        //devolución array de las cartas resultantes del proceso de reparto
        return cartasRepartidas;
    }

    private void visualizacionBaraja() {
        for (int i = 0; i < 48; i++) {
            System.out.println(baraja[i]);
        }
    }
}
