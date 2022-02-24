package PracticarExamen;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Ejercicio2
{
    private BufferedReader ficheroLectura;
    private BufferedWriter ficheroEscritura;
    private final int ESPACIO = (int)' ';
    private final int RETURN = (int)'\r';
    private final int SALTO_LINEA = (int)'\n';
    private final int FINAL_FICHERO = -1;
    private int codigo = (int)ESPACIO;
    private Palabra pal;
    public static void main(String[] argumentos) throws Exception
    {
        new Ejercicio2().metodoPrincipal();
    }

    private void metodoPrincipal() throws Exception
    {
        ficheroLectura = new BufferedReader(new FileReader("entrada.txt"));
        ficheroEscritura = new BufferedWriter(new FileWriter("salida.txt"));
        
        while (hayPalabras())
        {
            pal = lectura();
            if (pal.esValida())
            {
                ficheroEscritura.write(pal.toString());
            }
        }
        ficheroLectura.close();
        ficheroEscritura.close();
    }

    private boolean hayPalabras() throws Exception
    {
        buscarPalabra();
        return (codigo != FINAL_FICHERO);
    }
 
    private void buscarPalabra() throws Exception
    {
        while ((codigo == ESPACIO) || (codigo == RETURN) || (codigo == SALTO_LINEA))
        {
            codigo = ficheroLectura.read();
        }
    }

    private Palabra lectura() throws Exception
    {
        Palabra palabra = new Palabra();
        while ((codigo != ESPACIO) && (codigo != RETURN) && (codigo != SALTO_LINEA) && (codigo != FINAL_FICHERO))
        {
            palabra.adicionCaracter((char)codigo);
            codigo = ficheroLectura.read();
        }
        return palabra;
    }
}