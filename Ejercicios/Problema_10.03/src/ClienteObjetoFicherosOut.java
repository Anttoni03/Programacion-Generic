
import java.io.*;

public class ClienteObjetoFicherosOut {
    
    private ObjectOutputStream fichero = null;
    
    public ClienteObjetoFicherosOut(String nombreFichero)
    {
        try {
            fichero = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero)));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR AL NO ENCONTRARSE EL FICHERO " + nombreFichero);
        }
        catch (IOException e) {
            System.err.println("ERROR DE ESCRITURA CON EL FICHERO" + nombreFichero);
        }
    }
    
    public void escritura(Cliente cliente)
    {
        try {
            fichero.writeObject(cliente);
        } catch (IOException e) {
            System.err.println("ERROR DE ESCRITURA CON EL FICHERO");
        }
    }
    
    public void cerrarEnlace()
    {
        try {
            if (fichero != null)
            {
                escritura(Cliente.getCentinela());
                fichero.close();
            }
        } catch (IOException e) {
            System.err.println("ERROR AL CERRAR EL FICHERO DE ESCRITURA");
        }
    }
}
