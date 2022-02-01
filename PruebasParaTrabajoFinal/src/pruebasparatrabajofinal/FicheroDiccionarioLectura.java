//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package pruebasparatrabajofinal;

import pruebasparatrabajofinal.AccionesFichas;
import java.io.BufferedReader;
import java.io.FileReader;

public class FicheroDiccionarioLectura {
    
    //DECLARACIÓN DE LOS ATRIBUTOS
    //atributo de objeto que indica el fichero a leer
    private BufferedReader fichero;
    //atributo de objeto que indica la última letra leída a la hora de leer el
    //fichero de fichas
    private int codigoLeido = ' ';
    //variable de clase que indica el código de final de fichero
    private static final int FINAL_FICHERO = -1;
    //atributo de clase que indica el código espacio a la hora de leer el
    //fichero de fichas
    private static final int COD_ESPACIO=(int) ' ';
    //atributo de clase que indica el código return a la hora de leer el
    //fichero de fichas
    private static final int RETURN=(int) '\r';
    //atributo de clase que indica el código de salto de línea a la hora de leer el
    //fichero de fichas
    private static final int SALTO_LINEA=(int) '\n';
    
    //MÉTODOS
    //método constructor con la ruta del fichero
    public FicheroDiccionarioLectura(String rutaFichero) throws Exception
    {
        fichero = new BufferedReader(new FileReader(rutaFichero));
    }
    
    //método hayPalabras para verificar si en el fichero hay palabras a leer
    public boolean hayPalabras() throws Exception {
        //se busca una palabra
        buscarPalabra();
        //indica si se ha acabado de leer el fichero o no
        return (codigoLeido!=FINAL_FICHERO);
    }
    
    //método buscarPalabra que lee en el fichero mientras no encuentre palabras
    private void buscarPalabra() throws Exception {
        //bucle para seguir leyendo en el fichero mientras no sea una palabra
        while ((codigoLeido==COD_ESPACIO)||(codigoLeido==RETURN)||(codigoLeido==SALTO_LINEA)) {
            codigoLeido=fichero.read();
        }
    }
    
    //método lectura que lee una palabra al ser encontrada mientras esta no finalice
    public Palabra lectura() throws Exception {
        //DECLARACIONES
        //instanciación de una palabra para ser leída
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //bucle de lectura de la palabra mientras esta no se termine
        while ((codigoLeido!=FINAL_FICHERO)&&(codigoLeido!=COD_ESPACIO)&&(codigoLeido!=RETURN)
                &&(codigoLeido!=SALTO_LINEA)) {

            palabra.adicionCaracter((char) codigoLeido);
            codigoLeido=fichero.read();           
        }
        //devolución de la palabra leída
        return palabra;
    }
    
    //método estaPalabra para indicar si una palabra dada se encuentra en el fichero
    public boolean estaPalabra(Palabra pal) throws Exception
    {
        //DECLARACIONES
        //instanciar palabra para leer durante el fichero
        Palabra palabraLeer = new Palabra();
        
        //ACCIONES
        //bucle de lectura de las palabras del fichero
        while (hayPalabras())
        {
            //lectura de una palabra
            palabraLeer = lectura();
            //comprobación de la palabra leída con la dada inicialmente
            if (Palabra.iguales(palabraLeer, pal))
            {
                //devolver true si estas dos palabras coinciden
                return true;
            }
        }
        //devolver false al acabar por no encontrar una palabra coincidente
        return false;
    }
    
    //método palabraCerebroSuperior que genera una palabra del diccionario
    //para el modo de la máquina del cerebro superior
    public Palabra palabraCerebroSuperior(Ficha[] fichas) throws Exception
    {
        //DECLARACIONES
        //instanciación de las palabras a leer
        Palabra palabraLeer = new Palabra();
        //instanciación de la palabra a devolver
        Palabra pal = new Palabra();
        //indicador con la mayor puntuación de la palabra a devolver
        int mayorPuntuacion = 0;
        
        //ACCIONES
        //bucle de búsqueda en el fichero del diccionario para encontrar la
        //palabra que se pueda formar con las fichas dadas con mayor valor
        while (hayPalabras()) {            
            //se lee una palabra del diccionario
            palabraLeer = lectura();
            //si esa palabra se puede formar se comprueban sus puntos y compara
            //con la de mayor puntuación guardada, si esta es mayor se reemplaza
            if (AccionesFichas.sePuedeFormar(palabraLeer, fichas))
            {
                int nuevaPuntuacion = AccionesFichas.obtenerPuntuacion(palabraLeer);
                if (nuevaPuntuacion >= mayorPuntuacion)
                {
                    mayorPuntuacion = nuevaPuntuacion;
                    Palabra.copiar(palabraLeer, pal);
                }
            }
        }
        //devuelve la palabra con la mayor puntuación formada
        return pal;
    }
    
    //método cerrarEnlace que cierra el enlace con el fichero
    public void cerrarEnlace() throws Exception
    {
        fichero.close();
    }
}