import java.util.Random;

public class AccionesFichas {
    
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE
    //variable de clase que indica la cantidad de fichas que son repartidas
    private static final int CANTIDAD_REPARTIR = 11;
    //variable de clase que indica la cantidad de letras del abecedario
    private static final int CANTIDAD_FICHAS = 26;
    //variable de clase que representa las fichas base y sus características
    //al ser leidas
    private static Ficha[] fichasBase = new Ficha[CANTIDAD_FICHAS];

    private static FicheroFichasLectura ficheroFichas;
    
    //variable de clase usado para generar un número aleatorio al repartir las
    //fichas
    private static Random numeroAleatorio;
    
    //DECLARACIÓN DE LOS ATRIBUTOS DE OBJETO
    //variable de objeto que guarda la cantidad de fichas que se pueden repartir
    //con el mismo orden posicional que los carácteres dados al ser repartidas
    private static int cantidadRestante[] = new int[CANTIDAD_FICHAS];
    
    //metodo constructor
    public  AccionesFichas(){
    }
    
    //MÉTODO ENCARGADO DE LEER EL FICHERO Y OBTENER LAS LETRAS, SUS APARICIONES Y PUNTUACIONES
    public static void generacionFichas() throws Exception{
        ficheroFichas = new FicheroFichasLectura("ficheroFichas.txt");
                
        for(int indice = 0; indice<CANTIDAD_FICHAS;indice++){            
            char caracter = ' ';
            int cantidad = 0, valor = 0;
            
            if (ficheroFichas.EncontrarLetra())
            {
                caracter = ficheroFichas.LeerLetra();
            }
            
            if (ficheroFichas.EncontrarNumero())
            {
                cantidad = ficheroFichas.LeerNumeros();
            }
            
            if (ficheroFichas.EncontrarNumero())
            {
                valor = ficheroFichas.LeerNumeros();
            }
            
            fichasBase[indice] = new Ficha(caracter, cantidad, valor);            
        }
        ficheroFichas.CerrarEnlace();
    }
    
    //METODO ENCARGADO SORTEAR LAS 11 FICHAS ALEATORIAMENTE
    public static Ficha[] sortearFichas(){
        //
        Ficha[] fichas = new Ficha[CANTIDAD_REPARTIR];
        numeroAleatorio = new Random();
        int indiceLetra;
        
        for (int indice = 0; indice < CANTIDAD_FICHAS; indice++) {
            cantidadRestante[indice] = fichasBase[indice].getCantidad();
        }

        //
        for(int indice = 0; indice < CANTIDAD_REPARTIR; indice++){
            indiceLetra = numeroAleatorio.nextInt(CANTIDAD_FICHAS);
            if(cantidadRestante[indiceLetra] > 0){
                cantidadRestante[indiceLetra]--;
                fichas[indice] = fichasBase[indiceLetra].copiar();
            }
            else{
                indice--;
            }
        }
        return fichas;
    }
    
    public static boolean sePuedeFormar(Palabra pal, Ficha[] fich)
    {
        boolean[] usada = new boolean[fich.length];
        boolean esValida = true;
        for (int indice = 0; indice < pal.getNumeroCaracteres(); indice++) {
            boolean letraValida = false;
            for (int ind = 0; ind < fich.length && !letraValida; ind++) {
                if (!usada[ind] && pal.obtenerCaracter(indice) == fich[ind].getLetra())
                {
                    letraValida = true;
                    usada[ind] = true;
                }
            }
            esValida = esValida && letraValida;
            if (!esValida)
            {
                return false;
            }
        }
        return true;
    }
    
    public static int obtenerPuntuacion(Palabra pal)
    {
        int puntos = 0;
        for (int indice = 0; indice < pal.getNumeroCaracteres(); indice++) {
            for (int ind = 0; ind < fichasBase.length; ind++) {
                if (pal.obtenerCaracter(indice) == fichasBase[ind].getLetra())
                {
                    puntos += fichasBase[ind].getValor();
                }
            }
        }
        return puntos;
    }
}