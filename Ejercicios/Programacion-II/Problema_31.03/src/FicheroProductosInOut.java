
import java.io.*;

public class FicheroProductosInOut {
    private RandomAccessFile fichero = null;
    
    public FicheroProductosInOut(String rutaFichero)
    {
        try{
            fichero = new RandomAccessFile(rutaFichero,"rw");
        } catch(FileNotFoundException e){
            System.err.println("ERROR FICHERO NO ENCONTRADO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE CONEXIÓN CON FICHERO: " + e.toString());
        }
    }
    
    public Producto lectura()
    {
        Producto producto = new Producto();
        
        try{
            producto.setCodigo(fichero.readInt());
            producto.setDescripcion(lecturaString(32));
            producto.setPrecio(fichero.readDouble());
            producto.setVentas(fichero.readInt());
            producto.setIva(fichero.readDouble());
            producto.setImporte();
        } catch(EOFException e){
        }catch(IOException e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        }
        
        return producto;
    }
    
    public Producto lectura(int codigo)
    {
        Producto producto = new Producto();
        try{
            if (codigo > 0 && codigo <= (fichero.length()/Producto.getDimension())){
                
                fichero.seek((codigo - 1) * Producto.getDimension());
                
                producto = lectura();
            }
            
        } catch(IOException e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        }
        return producto;
    }
    
    private String lecturaString(int caracteres)
    {
        String temp = "";
        
        try{
            for (int i = 0; i < caracteres; i++)
            {
                temp += fichero.readChar();
            }
        } catch (IOException e){
            System.err.println("ERROR EN LA LECTURA DEL FICHERO: " + e.toString());
        } finally {
            return temp;
        }
    }
    
    public void escritura(Producto producto)
    {
        try{
            fichero.seek(fichero.length());
            
            fichero.writeInt(producto.getCodigo());
            fichero.writeChars(escrituraString(producto.getDescripcion(),32));
            fichero.writeDouble(producto.getPrecio());
            fichero.writeInt(producto.getVentas());
            fichero.writeDouble(producto.getIVA());
        } catch(IOException e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        }
    }
    
    public void escritura(Producto producto, int posicion)
    {
        try{
            if (posicion > 0 && posicion <= (fichero.length() / Producto.getDimension()))
            {
                fichero.seek((posicion - 1) * Producto.getDimension());

                fichero.writeInt(producto.getCodigo());
                fichero.writeChars(escrituraString(producto.getDescripcion(),32));
                fichero.writeDouble(producto.getPrecio());
                //System.out.println("Hora de escribir-"+producto.getVentas());
                fichero.writeInt(producto.getVentas());
                fichero.writeDouble(producto.getIVA());
            }
        } catch(IOException e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        }
    }
    
    public String escrituraString(String texto, int caracteres)
    {
        String resultado = "";
        
        try{
            for (int i = 0; i < texto.length() && i < caracteres; i++)
            {
                resultado += texto.charAt(i);
            }

            
            for (int i = 0; i < caracteres - texto.length(); i++)
            {
                resultado += ' ';
            }
            
        } catch(Exception e){
            System.err.println("ERROR: " + e.toString());
        }
        
        return resultado;
    }
    
    public int getNuevoCodigo()
    {
        int nuevoCodigo = 0;
        try{
            nuevoCodigo = (int) ((fichero.length() / Producto.getDimension()) + 1);
        } catch(Exception e){
            System.err.println("ERROR: " + e.toString());
        }
        return nuevoCodigo;
    }
    
    public void cierre()
    {
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
