package ejerciciosmatrices;


import java.io.*;

public class FicheroMatricesInOut {
    private RandomAccessFile fichero = null;
    private String ruta;
    private int cantidadMat;
    
    public FicheroMatricesInOut(String rutaFichero)
    {
        try{
            ruta = rutaFichero;
            fichero = new RandomAccessFile(ruta,"rw");
        } catch(FileNotFoundException e){
            System.err.println("ERROR FICHERO NO ENCONTRADO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE CONEXIÓN CON FICHERO: " + e.toString());
        }
    }
    
    public MatrizNxM lectura()
    {
        MatrizNxM mat = new MatrizNxM();
        
        try{
            int dim1 = fichero.readInt();
            int dim2 = fichero.readInt();
            mat.setElementos(lecturaElementos(dim1, dim2));
        } catch(EOFException e){
        }catch(IOException e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        }
        
        return mat;
    }
    public MatrizNxM lectura(int posicion)
    {
        MatrizNxM mat = null;
        try{
            if (posicion >= 0 && posicion < cantidadMat){
                fichero.seek(obtenerSeek(posicion))
                mat = lectura();
            }
        } catch(IOException e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE LECTURA CON FICHERO: " + e.toString());
        }
        return mat;
    }
    private double [][] lecturaElementos(int filas, int columnas)
    {
        double[][] resultado = null;
        try{
            resultado = new double[filas][columnas];
            for (int i = 0; i < filas; i++)
            {
                for (int j = 0; j < columnas; j++)
                {
                    resultado[i][j] = fichero.readDouble();
                }
            }
        } catch (IOException e){
            
        } finally {
            return resultado;
        }
    }
    
    public void escritura(MatrizNxM mat)
    {
        try{
            fichero.seek(fichero.length());
            
            fichero.writeInt(mat.getDim1());
            fichero.writeInt(mat.getDim2());
            escrituraElementos(mat.getElementos());
        } catch(IOException e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        }
    }
    public void escritura(MatrizNxM mat, int posicion)
    {
        try{
            if (posicion >= 0 && posicion < cantidadMat)
            {
                fichero.seek(obtenerSeek(posicion));

                fichero.writeInt(mat.getDim1());
                fichero.writeInt(mat.getDim2());
                escrituraElementos(mat.getElementos());
            }
        } catch(IOException e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        } catch(Exception e){
            System.err.println("ERROR DE ESCRITURA CON FICHERO: " + e.toString());
        }
    }
    public void escrituraElementos(double[][] elem)
    {
        
        try{
            for (int i = 0; i < elem.length; i++)
            {
                for (int j = 0; j < elem[0].length; j++) {
                    fichero.writeDouble(elem[i][j]);
                }
            }
        } catch(Exception e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    private long obtenerSeek(int posicion)
    {
        FicheroMatricesInOut f;
        int cantidad = 0;
        try{
            f = new FicheroMatricesInOut(ruta);
            f.fichero.seek(0);
            while (true){
                System.out.println("File pointer -> "+f.fichero.getFilePointer());
                if (cantidad == posicion)
                {
                    long r = f.fichero.getFilePointer();
                    f.cerrarEnlace();
                    return r;
                }
                int filas = f.fichero.readInt();
                int columnas = f.fichero.readInt();
                int dimension = MatrizNxM.getDimension(filas, columnas);
                cantidad++;
                
                f.fichero.seek(f.fichero.getFilePointer()+dimension-8);
            }
        } catch (Exception e) {}
        
        return 0;
    }
    
    public int getCantidadMatrices()
    {
        return cantidadMat;
    }
    
    public void actualizarCantidad()
    {
        int cantidad = 0;
        FicheroMatricesInOut f = null;
        try{
            f = new FicheroMatricesInOut(ruta);
            f.fichero.seek(0);
            while (true){
                int filas = f.fichero.readInt();
                int columnas = f.fichero.readInt();
                int dimension = MatrizNxM.getDimension(filas, columnas);
                cantidad++;
                f.fichero.seek(f.fichero.getFilePointer()+dimension-8);
            }
        } catch (Exception e) {f.cerrarEnlace();}
        cantidadMat = cantidad;
    }
    
    public void cerrarEnlace()
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
