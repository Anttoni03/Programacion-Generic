
import java.io.*;
public class FicheroProductoDistritoIn {
    private ObjectInputStream fichero = null;
    
    public FicheroProductoDistritoIn(String nombreFichero)
    {
        try{
            fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreFichero)));
        } catch(IOException e){
            System.err.println("ERROR DE CONEXIÓN CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE CONEXIÓN CON FICHERO: " + e.toString());
        }
    }
    
    public ProductoDistrito lectura()
    {
        ProductoDistrito producto = new ProductoDistrito();
        try{
            producto = (ProductoDistrito) fichero.readObject();
        } catch(IOException e){
            System.err.println("ERROR DE LECTURA EN FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE LECTURA EN FICHERO: " + e.toString());
        }
        return producto;
    }
    
    public void cierre(){
        try{
            if (fichero != null)
            {
                fichero.close();
            }
        } catch(IOException e){
            System.err.println("ERROR DE CIERRE DE FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE CIERRE DE FICHERO: " + e.toString());
        }
    }
}
