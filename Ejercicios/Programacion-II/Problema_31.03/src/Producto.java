/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Producto {
    //4 bytes
    private int codigo;
    //32 carácteres máximo --> 64 bytes
    private String descripcion;
    //8 bytes
    private double precioUnidad;
    //8 bytes
    private double iva;
    //4 bytes
    private int ventas;
    //8 bytes
    private double importeVentas;
    
    private static final int DIMENSION = 88;
    
    public Producto(){
        codigo = 0;
        ventas = 0;
    }
    
    public void lectura(int codigo){
        try{
            this.codigo = codigo;
            System.out.print("INTRODUCIR UNA DESCRIPCIÓN: ");
            descripcion = LT.readLine();
            System.out.print("INTRODUCIR EL PRECIO POR UNIDAD: ");
            precioUnidad = LT.readDouble();
            System.out.print("INTRODUCIR UNA CANTIDAD DE IVA(ENTERA): ");
            iva = precioUnidad * LT.readDouble() / 100;
            setImporte();
        } catch(Exception e){
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    
    public int getCodigo()
    {
        return codigo;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    public double getPrecio()
    {
        return precioUnidad;
    }
    public int getVentas()
    {
        return ventas;
    }
    public double getIVA()
    {
        return iva;
    }
    public double getImporteVentas()
    {
        return importeVentas;
    }
    public static int getDimension()
    {
        return DIMENSION;
    }
    
    
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    public void setPrecio(double precio)
    {
        this.precioUnidad = precio;
    }
    public void setIva(double iva)
    {
        this.iva = iva;
    }
    public void setVentas(int ventas)
    {
        this.ventas = ventas;
    }
    public void setImporte()
    {
        importeVentas = ventas * (precioUnidad + iva);
    }
    
    
    public String toString() {       
         return "CODIGO: " + codigo + 
                "\nDESCRIPCIÓN: " + descripcion + 
                "\nPRECIO: " + (float)precioUnidad +
                "\nIVA: " + (float)iva + 
                "\nVENTAS: " + ventas + 
                "\nIMPORTE DE VENTAS: " + importeVentas+"\n";
    }
}
