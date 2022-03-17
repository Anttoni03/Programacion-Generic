
import java.io.FileWriter;
import java.io.IOException;

public class PeliculaEscritura {
    
    private FileWriter fichero;
    private final int SALTO_LINEA = (int)'\n';
    private final int SEPARADOR_1 = (int)'{', SEPARADOR_2 = (int)'}';
    
    public PeliculaEscritura(String nombreFichero, boolean adicion)
    {
        try
        {
            fichero = new FileWriter(nombreFichero, adicion);
        } catch (IOException error)
        {
            System.err.println("Error al encontrar el fichero");
        }
    }
    
    public void escritura(Pelicula pelicula)
    {
        try
        {
            char[] mensaje = pelicula.toString().toCharArray();
            for (int i = 0; i < mensaje.length; i++)
            {
                fichero.write(mensaje[i]);
            }
            escrituraSeparaLineas(1);
        }catch (IOException error)
        {
            System.err.println("Error al escribir en el fichero");
        }
    }
    
    public void escrituraSeparaLineas(int iter)
    {
        try 
        {
            for (int i = 0; i < iter; i++) {
                fichero.write(SALTO_LINEA);
            }
        } catch (IOException error) 
        {
            System.err.println("Error al escribir en el fichero");
        }
    }
    
    public void escrituraSeparador1()
    {
        try 
        {
            fichero.write(SEPARADOR_1);
            escrituraSeparaLineas(1);
        } catch (IOException error) 
        {
            System.err.println("Error al escribir en el fichero");
        }
    }
    
    public void escrituraSeparador2()
    {
        try 
        {
            fichero.write(SEPARADOR_2);
            escrituraSeparaLineas(2);
        } catch (IOException error) 
        {
            System.err.println("Error al escribir en el fichero");
        }
    }
    
    public void cerrarEnlace()
    {
        try
        {
            fichero.close();
        } catch (IOException error)
        {
            System.err.println("Error al cerrar el enlace con el fichero");
        }
    }
}
