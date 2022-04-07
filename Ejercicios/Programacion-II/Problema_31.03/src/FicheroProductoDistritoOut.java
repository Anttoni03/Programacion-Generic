
import java.io.*;
public class FicheroProductoDistritoOut {
    private ObjectOutputStream fichero = null;
    
    public FicheroProductoDistritoOut(String nombreFichero)
    {
        try{
            fichero = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero)));
        } catch(IOException e){
            System.err.println("ERROR DE CONEXIÓN CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE CONEXIÓN CON FICHERO: " + e.toString());
        }
    }
    
    public void escritura(ProductoDistrito producto)
    {
        try{
            fichero.writeObject(producto);
        } catch(IOException e){
            System.err.println("ERROR DE ESCRITURA EN FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE ESCRITURA EN FICHERO: " + e.toString());
        }
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
    
    public static int bytesCentinela()
    {
        FicheroProductoDistritoOut fichero;
        int bytes = 0;
        try{
            fichero = new FicheroProductoDistritoOut("tempCent.dat");
            fichero.escritura(ProductoDistrito.getCentinela());
            fichero.cierre();
            File f = new File("tempCent.dat");
            bytes = (int)f.length();
            f.delete();
        } catch(Exception e){
            System.err.println("ERROR: "+e.toString());
        }
        return bytes;
    }
}
