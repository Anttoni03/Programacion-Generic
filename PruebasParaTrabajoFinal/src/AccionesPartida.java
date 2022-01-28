
public class AccionesPartida {
    
    private Ficha[] fichas;
    private int puntos = 0;
    private boolean esJugador;
    private FicheroDiccionarioLectura diccionario;
    
    public AccionesPartida(boolean jugador) throws Exception
    {
        esJugador = jugador;
    }
    
    public void aplicarPuntos(int variacion)
    {
        puntos += variacion;
    }
    
    public int getPuntos()
    {
        return puntos;
    }
    
    public void recibirTurno() throws Exception
    {
        fichas = AccionesFichas.sortearFichas();
        if (esJugador)
        {
            mostrarFichas();
            System.out.print("Escriba una palabra acabada en punto: ");
        }
        recibirPalabra();
    }
    
    public void finalizarTurno(Palabra pal) throws Exception
    {
        if (AccionesFichas.sePuedeFormar(pal, fichas) && palabraEnDiccionario(pal))
        {
            int puntosPal = AccionesFichas.obtenerPuntuacion(pal);
            if (esJugador)
            {
                System.out.println("La palabra es válida! Recibes " + puntosPal + " puntos!");
            }
            else
            {
                System.out.println("El cerebro superior ha montado " + pal.toString() + ". Recibe " + puntosPal + " puntos!");
            }
            aplicarPuntos(puntosPal);
        }
        else
        {
            System.out.println("La palabra no es válida! Recibes -10 puntos!");
            aplicarPuntos(-10);
        }
    }
    
    private void recibirPalabra() throws Exception
    {
        Palabra pal = new Palabra();
        if (esJugador)
        {
            Palabra.buscarPalabra();
            pal.lectura();
        }
        else
        {
            diccionario = new FicheroDiccionarioLectura("diccionarioCastellano.txt");
            pal = diccionario.palabraCerebroSuperior(fichas);
            diccionario.CerrarEnlace();
        }
        finalizarTurno(pal);
    }
    
    private boolean palabraEnDiccionario(Palabra pal) throws Exception
    {
        diccionario = new FicheroDiccionarioLectura("diccionarioCastellano.txt");
        boolean esta = diccionario.estaPalabra(pal);
        diccionario.CerrarEnlace();
        return esta;
    }
    
    private void mostrarFichas()
    {
        System.out.println("Fichas disponibles:");
        for (int indice = 0; indice < fichas.length; indice++) {
            System.out.println(fichas[indice].toString());
        }
        System.out.println("\n");
    }
}