//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package pruebasparatrabajofinal;

public class AccionesPartida {
    
    //DECLARACIÓN DE LOS ATRIBUTOS
    //atributo de objeto que indica cuál es el nombre que escogerá el jugador
    private char[] nombre;
    //atributo de objeto que indica las fichas que puede usar al ser su turno
    private Ficha[] fichas;
    //atributo de objeto que indica los puntos de cada partida
    private int puntos = 0;
    //atributo de objeto que indica si el objeto se comporta como un jugador
    //o como una máquina
    private boolean esJugador;
    //atributo de objeto que referencia al lector del fichero diccionario
    private FicheroDiccionarioLectura diccionario;
    
    //MÉTODOS
    //método constructor que inicializar el modo de comportamiento
    public AccionesPartida(boolean jugador) throws Exception
    {
        esJugador = jugador;
    }
    
    //método guardarNombre que aplica el nombre dado por la cadena de caracteres
    public void guardarNombre(char[] nom)
    {
        nombre = nom;
    }
    
    //método getNombre que devuelve el atributo nombre
    public char[] getNombre()
    {
        return nombre;
    }
    
    //método aplicarPuntos que suma una variación de puntos indicada a los actuales
    public void aplicarPuntos(int variacion)
    {
        puntos += variacion;
    }
    
    //método getPuntos que devuelve el atributo puntos
    public int getPuntos()
    {
        return puntos;
    }
    
    //método recibirTurno que realiza primeras acciones del turno como el sorteo
    //de fichas y recibir una palabra para continuar el turno
    public void recibirTurno() throws Exception
    {
        //DECLARACIONES
        //se asignan las fichas que se podrán usar mediante el sorteador
        fichas = AccionesFichas.sortearFichas();
        
        //ACCIONES
        //si el modo de comportamiento es el de jugador se muestran las fichas
        //actuales para dar opción a la formación de una palabra
        if (esJugador)
        {
            mostrarFichas();
            System.out.print("Escriba una palabra acabada en punto: ");
        }
        //se procede a recibir una palabra
        recibirPalabra();
    }
    
    //método finalizarTurno que aplica puntos en base a la palabra dada
    public void finalizarTurno(Palabra pal) throws Exception
    {
        //DECLARACIONES
        //puntos que vale la palabra indicada
        int puntosPal;
        //se comprueba que la palabra se puede formar con las fichas actuales
        //y si se encuentra en el diccionario para aplicar los puntos que toquen
        if (AccionesFichas.sePuedeFormar(pal, fichas) && palabraEnDiccionario(pal))
        {
            //se guardan los puntos de la palabra al saber que es válida
            puntosPal = AccionesFichas.obtenerPuntuacion(pal);
            //se muestra un mensaje por pantalla indicando la puntuación obtenida
            //en función del modo de comportamiento
            if (esJugador)
            {
                System.out.println("La palabra es válida! Recibes " + puntosPal + " puntos!");
            }
            else
            {
                System.out.println("El cerebro superior ha montado " + pal.toString() + ". Recibe " + puntosPal + " puntos!");
            }
        }
        else
        {
            //se indica que la palabra no era válida y la penalización
            System.out.println("La palabra no es válida! Recibes -10 puntos!");
            //se guardan los puntos de la penalización
            puntosPal = -10;
        }
        //se aplican los puntos de la palabra
        aplicarPuntos(puntosPal);
    }
    
    //método recibirPalabra con el que se recibe una palabra como continuación
    //del turno
    private void recibirPalabra() throws Exception
    {
        //DECLARACIONES
        //instanciación de una palabra para su comprobación
        Palabra pal = new Palabra();
        
        //ACCIONES
        //si el modo de comportamiento es el de jugador el usuario introduce una
        //palabra por teclado, si no se genera una palabra destinada al modo
        // de la máquina cerebro superior
        if (esJugador)
        {
            Palabra.buscarPalabra();
            pal.lectura();
        }
        else
        {
            //instanciación el objeto diccionario con la ruta del fichero
            diccionario = new FicheroDiccionarioLectura("diccionarioCastellano.txt");
            pal = diccionario.palabraCerebroSuperior(fichas);
            //se cierra el enlace del fichero diccionario
            diccionario.CerrarEnlace();
        }
        //se procede a finalizar el turno con la palabra obtenida
        finalizarTurno(pal);
    }
    
    //método palabraEnDiccionario que indica si un palabra dada está en el en
    //diccionario 
    private boolean palabraEnDiccionario(Palabra pal) throws Exception
    {
        //instanciación del objeto de diccionario con la ruta del fichero
        diccionario = new FicheroDiccionarioLectura("diccionarioCastellano.txt");
        //se comprueba que la palabra dada esté
        boolean esta = diccionario.estaPalabra(pal);
        //se cierra el enlace con el fichero de diccionario
        diccionario.CerrarEnlace();
        //devolución de si la palabra dada está o no en el diccionario
        return esta;
    }
    
    //método mostrarFichas que muestra por pantalla el carácter y valor de
    //todas las fichas actuales
    private void mostrarFichas()
    {
        //indicar que muestra las fichas
        System.out.println("Fichas disponibles:");
        //bucle que recorre todas las fichas de las que dispone
        for (int indice = 0; indice < fichas.length; indice++) {
            System.out.println(fichas[indice].toString());
        }
        System.out.println("");
    }
}