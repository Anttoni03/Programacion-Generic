//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package practicafinalscrabble;

public class clasePrincipal {
    
    //DECLARACIÓN DE LOS ATRIBUTOS
    //atributo de clase que indica cuantos turnos se deberán jugar al elegir la
    //opción partida
    private static int turnos;
    //atributo de clase que indica la opción del menú principal escogida
    private static int opcionMenu;
    //atributo de objeto de tipo AccionesPartida para las acciones del jugador
    private AccionesPartida jugador;
    //atributo de objeto de tipo AccionesPartida para las acciones de la máquina
    private AccionesPartida maquina;
    //atributo de objeto de tipo FicheroControlHistorio para hacer uso del
    //fichero de historial de partidas tanto en lectura como en escritura
    private FicheroControlHistorico registros;
    
    //MÉTODOS
    //declaración del método main
    public static void main(String[] args) throws Exception
    {
        new clasePrincipal().MetodoPrincipal();
    }
    
    //declaración del método MetodoPrincipal que ejecuta las acciones principales
    private void MetodoPrincipal() throws Exception{
        //bucle en el cual se seleccionarán las opciones del menú principal
        while (opcionMenu != 3)
        {
            //se muestra el menú principal y se escoge acción
            menuPrincipal();
            //condición para realizar la acción de nueva partida o ver registros
            if (opcionMenu == 1)
            {
                //instanciar el objeto jugador para poder realizar sus acciones
                jugador = new AccionesPartida(true);
                //declaración del modo a jugar, solitario o con la máquina
                boolean esSolo = menuJugar() == 1;
                //obtener el nombre del usuario
                obtenerNombre();
                //obtener el número de turnos de la partida
                obtenerTurnos();
                //realizar la partida con el modo indicado
                partida(esSolo);
            }
            else if (opcionMenu == 2)
            {
                //mostrar por pantalla los registros de partidas anteriores
                visualizarRegistros();
            }
        }
        //llamada para mostrar mensaje de finalización
        salir();
    }
    
    //método menuPrincipal que muestra el menú principal y guardar la selección
    private void menuPrincipal(){
        //mostrar por pantalla las opciones del menú principal
        System.out.println("\t \tMENÚ PRINCIPAL");
        System.out.print("Jugar una partida --> 1"
               + "\n"
               + "Visualizar historial de partidas --> 2"
               + "\n"
               + "Salir --> 3"
               + "\n>> ");
        //registrar la selección del usuario
        opcionMenu = LT.readInt();
        generarEspaciados(15);
    }
    
    //método menuJugar para visualizar el menú para escoger el modo de jugar
    private int menuJugar(){
        //mostrar por pantalla las opciones del menú del modo de juego
        System.out.println("\t \tMODO DE JUEGO");
        System.out.print("Jugar una partida solo --> 1"
               + "\n"
               + "Jugar contra el cerebro superior --> 2"
               + "\n>> ");
        //devolver la selección del usuario
        int modo = LT.readInt();
        generarEspaciados(15);
        return modo;
    }

    //método obtenerNombre que guarda el nombre que introduce el usuario
    private void obtenerNombre(){
        //mostrar por pantalla la petición para introducir el nombre
        System.out.print("Introduce tu nombre: ");
        //guardar en el atributo jugador el nombre introducido por el usuario 
        //como cadena de caracteres
        jugador.guardarNombre(LT.readLine().toCharArray());
    }
    
    //método obtenerTurnos encargado de guardar el número de turnos a jugar
    private void obtenerTurnos(){
        //mostrar por pantalla la petición para introducir el número de turnos
        System.out.print("Introduce el numero de turnos que deseas jugar: ");
        //guardar el número de turnos introducido por el usuario
        turnos = LT.readInt();
        generarEspaciados(15);
    }
    
    //método partida que realiza las acciones básicas de una partida unos turnos
    //determinados anteriormente
    private void partida(boolean solo) throws Exception
    {
        //instanciar el objeto maquina si el modo de juego no es solitario
        if (!solo)
        {
            maquina = new AccionesPartida(false);
        }
        //generar las fichas base leyéndolas del ficheroFichas
        AccionesFichas.generacionFichas();
        //bucle que se repite tantas veces como turnos se han elegido para
        //realizar cada turno
        for (int indice = 0; indice < turnos; indice++) {
            //indicar el turno actual
            System.out.println("\tTurno " + (indice+1));
            //indicar que es turno del jugador
            System.out.println("\tJugador");
            //realizar todas las acciones del jugador en su turno
            jugador.recibirTurno();
            //realizar todas las acciones de la máquina en su turno si el modo
            //de juego no es solitario
            if (!solo)
            {
                generarEspaciados(2);
                //indicar que es turno de la máquina
                System.out.println("\tMáquina");
                maquina.recibirTurno();
            }
            generarEspaciados(2);
        }
        //indicar final de partida
        System.out.println("\tFINAL DE LA PARTIDA");
        //visualizar puntos totales del jugador
        System.out.println("Has obtenido " + jugador.getPuntos() + " puntos!");
        //visualizar puntos totales de la máquina si el modo de juego no es solo
        if (!solo)
        {
            System.out.println("El cerebro superior ha obtenido " + maquina.getPuntos() + " puntos!");
        }
        //guardar los registros en el fichero histórico
        guardarRegistros();
        generarEspaciados(8);
    }
    
    //método guardarRegistros para usar el fichero de control histórico y escribir
    //en una nueva línea la fecha y hora, el nombre del jugador y sus puntos en
    //los turnos de la partida
    private void guardarRegistros() throws Exception
    {
        //instanciación del fichero de control histórico como modo de escritura
        registros = new FicheroControlHistorico(true, "registroPartidas.txt");
        //guardar los registros del jugador pasados por parámetros con fecha y hora
        registros.guardarRegistro(jugador.getNombre(), jugador.getPuntos(), turnos);
        //cerrar el enlace del fichero de registros
        registros.cerrarEnlace();
    }
    
    //método visualizarRegistros para mostrar por pantalla los registros del
    //fichero histórico de partidas
    private void visualizarRegistros() throws Exception
    {
        //instanciación del fichero de control histórico como modo de lectura
        registros = new FicheroControlHistorico(false,"registroPartidas.txt");
        //lectura del fichero
        registros.recuperarRegistros();
        //cerrar el enlace del fichero de registros
        registros.cerrarEnlace();
        generarEspaciados(2);
    }
    
    //método generarEspacios para realizar espaciados más cómodamente
    private void generarEspaciados(int espacios)
    {
        //bucle que realiza un salto de línea tantas veces como se haya indicado
        for (int indice = 0; indice < espacios; indice++) {
            System.out.println("");
        }
    }
    
    //método salir que indica la finalización del programa
    private void salir()
    {
        System.out.println("Gracias por jugar y hasta la próxima!!");
    }
}