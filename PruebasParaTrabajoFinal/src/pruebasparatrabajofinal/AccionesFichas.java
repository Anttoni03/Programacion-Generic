//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package pruebasparatrabajofinal;

import java.util.Random;

public class AccionesFichas {
    
    //DECLARACIÓN DE LOS ATRIBUTOS
    //atributo de clase que indica la cantidad de fichas que son repartidas
    private static final int CANTIDAD_REPARTIR = 11;
    //atributo de clase que indica la cantidad de letras del abecedario
    private static final int CANTIDAD_FICHAS = 26;
    //atributo de clase que representa las fichas base y sus características
    //al ser leidas
    private static Ficha[] fichasBase = new Ficha[CANTIDAD_FICHAS];
    //atributo de clase que conecta con el fichero de fichas para su lectura
    private static FicheroFichasLectura ficheroFichas;
    //atributo de clase usado para generar un número aleatorio al repartir las
    //fichas
    private static Random numeroAleatorio;
    //atributo de clase que guarda la cantidad de fichas que se pueden repartir
    //con el mismo orden posicional que los carácteres dados al ser repartidas
    private static int cantidadRestante[] = new int[CANTIDAD_FICHAS];
    
    
    //MÉTODOS
    //método generacionFichas que realiza la lectura del fichero de fichas y
    //registra las propiedades las 26 fichas como su letra, cantidad y valor
    public static void generacionFichas() throws Exception{
        //instanciación del ficheroFichas
        ficheroFichas = new FicheroFichasLectura("ficheroFichas.txt");
        //bucle que recorre todas las líneas del fichero de fichas para su lectura
        for(int indice = 0; indice<CANTIDAD_FICHAS;indice++){            
            //DECLARACIONES
            //el carácter que va a tener cada ficha
            char caracter = ' ';
            //la cantidad y valor que va a tener cada ficha
            int cantidad = 0, valor = 0;
            //búsqueda de una letra del fichero de fichas
            if (ficheroFichas.encontrarLetra())
            {
                //guardar la letra encontrada
                caracter = ficheroFichas.leerLetra();
            }
            //búsqueda de un número del fichero de fichas, que será la cantidad
            if (ficheroFichas.encontrarNumero())
            {
                //guardar la cantidad encontrada
                cantidad = ficheroFichas.leerNumeros();
            }
            //búsqueda de un número del fichero de fichas, que será el valor
            if (ficheroFichas.encontrarNumero())
            {
                //guardar el valor encontrado
                valor = ficheroFichas.leerNumeros();
            }
            //instanciar cada ficha con sus valores guardados anteriormente
            fichasBase[indice] = new Ficha(caracter, cantidad, valor);            
        }
        //cerrar el enlace con el fichero de fichas
        ficheroFichas.cerrarEnlace();
    }
    
    //método sortearFichas que reparte aleatoriamente, teniendo en cuenta las
    //cantidades de cada ficha originales, una cantidad determinada(11)
    public static Ficha[] sortearFichas(){
        //DECLARACIONES
        //instanciación de el array de fichas a devolver
        Ficha[] fichas = new Ficha[CANTIDAD_REPARTIR];
        //objeto Random que generará los números aleatorios que servirán de
        //índice para elegir qué ficha escoger
        numeroAleatorio = new Random();
        //valor aleatorio que indica un índice de la letra a escoger
        int indiceLetra;
        
        //ACCIONES
        //bucle para iniciar las cantidades restantes de las fichas y permitir
        //poder ser seleccionadas
        for (int indice = 0; indice < CANTIDAD_FICHAS; indice++) {
            cantidadRestante[indice] = fichasBase[indice].getCantidad();
        }
        //bucle en el que se decide aleatoriamente un índice para escoger una
        //ficha, que se comprueba si aún es posible ser escogida y se guarda
        //como ficha sorteada
        for(int indice = 0; indice < CANTIDAD_REPARTIR; indice++){
            //obtención de un número aleatorio como índice
            indiceLetra = numeroAleatorio.nextInt(CANTIDAD_FICHAS);
            //comprobación de las cantidades de dicha ficha restantes
            if(cantidadRestante[indiceLetra] > 0){
                //si es posible coger dicha ficha, se resta 1 a su cantidad y
                //se copia a las fichas sorteadas
                cantidadRestante[indiceLetra]--;
                fichas[indice] = fichasBase[indiceLetra].copiar();
            }
            else{
                indice--;
            }
        }
        //devolver las fichas sorteadas aleatoriamente
        return fichas;
    }
    
    //método sePuedeFormar que indica si una palabra enviada por parámetro está
    //formada por unas fichas también enviadas por parámetro
    public static boolean sePuedeFormar(Palabra pal, Ficha[] fich)
    {
        //DECLARACIONES
        //indicador posicionar con las fichas recibidas para saber si ya se han usado
        boolean[] usada = new boolean[fich.length];
        //bucle que recorre todas las letras de la palabra para comprobar si se
        //puede formar con las fichas pasadas
        for (int indice = 0; indice < pal.getNumeroCaracteres(); indice++) {
            //letraValida como indicador por defecto de que cada letra de la
            //palabra no se podrá formar(no sea válida)
            boolean letraValida = false;
            for (int ind = 0; ind < fich.length && !letraValida; ind++) {
                //condición de búsqueda en el que un carácter de las fichas
                //es posible ser usado en la palabra
                if (!usada[ind] && pal.obtenerCaracter(indice) == fich[ind].getLetra())
                {
                    //indicar que la letra de la palabra es válida
                    letraValida = true;
                    //indicar que la letra de las fichas ya está usada
                    usada[ind] = true;
                }
            }
            if (!letraValida)
            {
                //devolver falso si una letra no es válida porque ya no se podrá
                //formar la palabra
                return false;
            }
        }
        //devolver true porque se ha podido llegar al fin de la formación
        return true;
    }
    
    //método obtenerPuntuacion que devuelve la puntuación de una palabra dada
    //según los puntos de las fichas con las que esté formada la palabra
    public static int obtenerPuntuacion(Palabra pal)
    {
        //DECLARACIONES
        //puntos a contar
        int puntos = 0;
        
        //ACCIONES
        //bucle que recorre todas las letra de la palabra dada para buscar su
        //valor comparándolo las fichas originalmente leídas
        for (int indice = 0; indice < pal.getNumeroCaracteres(); indice++) {
            for (int ind = 0; ind < fichasBase.length; ind++) {
                //al encontrar una coincidencia de caracteres se suma el valor
                //de la ficha con dicho carácter
                if (pal.obtenerCaracter(indice) == fichasBase[ind].getLetra())
                {
                    puntos += fichasBase[ind].getValor();
                }
            }
        }
        //devolución de la suma total de puntos
        return puntos;
    }
}