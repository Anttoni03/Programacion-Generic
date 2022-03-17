import java.io.FileReader;
import java.io.IOException;

public class PeliculaLectura {
    
    private FileReader fichero;
    private final int SALTO_LINEA = (int)'\n';
    private final int RETURN = (int)'\r';
    private final int ESPACIO = (int)' ';
    private final int INICIADOR = (int)':';
    private final int FINAL_FICHERO = -1;
    private int codigo = ESPACIO;
    
    public PeliculaLectura(String nombreFichero)
    {
        try
        {
            fichero = new FileReader(nombreFichero);
        } catch (IOException error)
        {
            System.err.println("Error al encontrar el fichero");
        }
    }
    
    public boolean hayInformacion()
    {
        buscarInformacion();
        return codigo != FINAL_FICHERO;
    }
    
    public void buscarInformacion() {
        try
        {
            while (codigo != INICIADOR && codigo != FINAL_FICHERO) 
            {
                codigo=fichero.read();
            }
            if (codigo != FINAL_FICHERO)
                codigo = fichero.read();
        }catch (IOException error) 
        {
            System.out.println("ERROR DE LECTURA EN EL FICHERO");
        }

    }
    
    public char[] lecturaTitulo()
    {
        return lectura(true);
    }
    
    public char[] lecturaDirector()
    {
        return lectura(false);
    }
    
    private char[] lectura(boolean lecturaTitulo)
    {
        try{
            char[] dato = new char[30];
            int i;
            for (i = 0; esLetraNumeroEspacio(codigo, lecturaTitulo) ; i++) {
                dato[i] = (char)codigo;
                codigo = fichero.read();
            }
            char[] datoFinal = new char[i];
            for (int j = 0; j < i; j++) {
                datoFinal[j] = dato[j];
            }
            return datoFinal;
        }catch (IOException error)
        {
            System.out.println("Error al leer el fichero");
            return null;
        }
    }
    
    public int lecturaEstreno()
    {
        try
        {
            int[] dato = new int[9];
            int i;
            for (i = 0; esNumero(codigo); i++)
            {
                dato[i] = codigo;
                codigo = fichero.read();
            }
            int estreno = digitosAValor(dato, i);
            return estreno;
        }catch (IOException error)
        {
            System.err.println("Error al escribir en el fichero");
            return 0;
        }
    }
    
    public boolean esLetraNumeroEspacio(int codigo, boolean espacio)
    {
        boolean resultado = (int)'0' <= codigo && codigo <= (int)'9' ||
                (int)'a' <= codigo && codigo <= (int)'z' ||
                (int)'A' <= codigo && codigo <= (int)'Z';
        
        if (!espacio) return resultado;
        else return resultado || codigo == ESPACIO;
    }
    
    private int digitosAValor(int[] digitos, int cantidad)
    {
        int valor = 0;
        for (int i = 0; i < cantidad; i++) {
            valor += (digitos[i]-(int)'0') * Math.pow(10, cantidad-i-1);
        }
        return valor;
    }
    
    public boolean esNumero(int codigo)
    {
        return (int)'0' <= codigo && codigo <= (int)'9';
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