//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package pruebasparatrabajofinal;

import pruebasparatrabajofinal.AccionesFichas;
import java.io.BufferedReader;
import java.io.FileReader;

public class FicheroDiccionarioLectura {
    
    private BufferedReader fichero;
    
    //variable de clase que indica la última letra leída a la hora de leer el
    //fichero de fichas
    private int codigoLeido = ' ';
    //variable de clase que indica el código de final de fichero
    private static final int FINAL_FICHERO = -1;
    private static final int COD_ESPACIO=(int) ' ';
    
    private static final int RETURN=(int) '\r';
    
    private static final int SALTO_LINEA=(int) '\n';
        
    public FicheroDiccionarioLectura(String rutaFichero) throws Exception
    {
        fichero = new BufferedReader(new FileReader(rutaFichero));
    }
    
    public boolean hayPalabras() throws Exception {
        buscarPalabra();
        return (codigoLeido!=FINAL_FICHERO);
    }
    
    private void buscarPalabra() throws Exception {
        while ((codigoLeido==COD_ESPACIO)||(codigoLeido==RETURN)||(codigoLeido==SALTO_LINEA)) {
            codigoLeido=fichero.read();
        }
    }
    
    public Palabra lectura() throws Exception {

        Palabra palabra=new Palabra();
        
        while ((codigoLeido!=FINAL_FICHERO)&&(codigoLeido!=COD_ESPACIO)&&(codigoLeido!=RETURN)
                &&(codigoLeido!=SALTO_LINEA)) {

            palabra.adicionCaracter((char) codigoLeido);
            codigoLeido=fichero.read();           
        }
        return palabra;
    }
    
    public boolean estaPalabra(Palabra pal) throws Exception
    {
        Palabra palabraLeer = new Palabra();
        while (hayPalabras())
        {
            palabraLeer = lectura();
            if (Palabra.iguales(palabraLeer, pal))
            {
                return true;
            }
        }
        return false;
    }
    
    public Palabra palabraCerebroSuperior(Ficha[] fichas) throws Exception
    {
        Palabra palabraLeer = new Palabra();
        Palabra pal = new Palabra();
        int mayorPuntuacion = 0;
        while (hayPalabras()) {            
            palabraLeer = lectura();
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
        return pal;
    }
    
    public void CerrarEnlace() throws Exception
    {
        fichero.close();
    }
}
