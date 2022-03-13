
import java.io.*;

public class ClienteObjetoFicherosIn {
    
    private ObjectInputStream fichero = null;
    
    public ClienteObjetoFicherosIn(String nombreFichero)
    {
        try
        {
            fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreFichero)));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR AL NO ENCONTRARSE EL FICHERO " + nombreFichero);
        }
        catch (IOException e) {
            System.err.println("ERROR DE LECTURA CON " + nombreFichero);
        }
    }
    
    public Cliente lectura()
    {
        Cliente cliente = new Cliente();
        try {
            cliente = (Cliente) fichero.readObject();
        } catch (IOException e) {
            cliente = null;
            System.err.println("ERROR DE LECTURA");
        }
        catch (ClassNotFoundException e){
            cliente = null;
            System.err.println("ERROR AL NO ENCONTRARSE LA CLASE CLIENTE");
        }
        finally {
            return cliente;
        }
    }
    
    public void cerrarEnlace()
    {
        try {
            if (fichero != null)
                fichero.close();
        }
        catch (IOException e) {
            System.err.println("ERROR AL CERRAR EL FICHERO");
        }
    }
}
