//

public class clasePrincipal {
    
    //DECLARACION DE LOS ATRIBUTOS DE LA CLASE
    //variable de clase que indica cuantos turnos se deberán jugar al elegir la
    //opción de jugar
    private static int turnos;
    //variable de clase que indica cuál es el nombre que escogerá el jugador al
    //elegir la opción de jugar
    private static char[] nombreJugador;
    //
    AccionesPartida jugador;
    AccionesPartida maquina;
    FicheroControlHistorico registros;

    public clasePrincipal() {
    }
    
    public static void main(String[] args) throws Exception
    {
        new clasePrincipal().MetodoPrincipal();
    }
    
    private void MetodoPrincipal() throws Exception{
        int opcionMenu = 0;
        while (opcionMenu != 3)
        {
            opcionMenu = menuPrincipal();
            if (opcionMenu == 1)
            {
                jugador = new AccionesPartida(true);
                maquina = new AccionesPartida(false);
                
                int tipoPartida = menuJugar();
                obtenerNombre();
                obtenerTurnos();
                Partida(tipoPartida == 1);
            }
            if (opcionMenu == 2)
            {
                visualizarRegistros();
            }
        }
    }
    
    //METODO ENCARGADO DE VISUALIZAR UN MENÚ PRINCIPAL
    private int menuPrincipal(){
        System.out.println("\t \tMENU");
        System.out.println("1 --> Jugar una partida"
               + "\n"
               + "2 --> Visualizar el historial de partidas"
               + "\n"
               + "3 --> Salir"
               + "\n");
        return LT.readInt();
    }
    
    //METODO ENCARGADO DE VISUALIZAR EL MENÚ AL ESCOGER JUGAR UNA PARTIDA
    private int menuJugar(){
        System.out.println("\t \tMENU");
        System.out.println("1 --> Jugar una partida solo"
               + "\n"
               + "2 --> Jugar contra el cerebro superior"
               + "\n");
        return LT.readInt();
    }

    //METODO ENCARGADO DE SOLICITAR EL NOMBRE DEL JUGADOR
    private void obtenerNombre(){
        System.out.println("Introduce tu nombre: ");
        nombreJugador = LT.readLine().toCharArray();
    }
    
    //METODO ENCARAGADO DE SOLICITAR EL NUMERO DE TURNOS QUE DESEA JUGAR
    private void obtenerTurnos(){
        System.out.println("Introduce el numero de turnos que deseas jugar: ");
        turnos = LT.readInt();
        System.out.println("\n");
    }
    
    private void Partida(boolean solo) throws Exception
    {
        AccionesFichas.generacionFichas();
        for (int indice = 0; indice < turnos; indice++) {
            System.out.println("Turno " + (indice+1));
            jugador.recibirTurno();
            if (!solo)
            {
                maquina.recibirTurno();
            }
            System.out.println("\n\n");
        }
        System.out.println("Final de la partida!");
        System.out.println("Has obtenido " + jugador.getPuntos() + " puntos!");
        if (!solo)
        {
            System.out.println("El cerebro superior ha obtenido " + maquina.getPuntos() + " puntos!");
        }
        guardarRegistros();
    }
    
    private void guardarRegistros() throws Exception
    {
        registros = new FicheroControlHistorico(true, "registroPartidas.txt");
        registros.guardarRegistro(nombreJugador, jugador.getPuntos());
        registros.cerrarEnlace();
    }
    
    private void visualizarRegistros() throws Exception
    {
        registros = new FicheroControlHistorico(false,"registroPartidas.txt");
        registros.recuperarRegistros();
        registros.cerrarEnlace();
    }
}