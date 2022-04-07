
public class ProductoDistrito implements java.io.Serializable{
    
    private int codigo;
    private int ventas;
    private static final ProductoDistrito CENTINELA = new ProductoDistrito(-1,0);
    
    public ProductoDistrito(){
        codigo = 0;
        ventas = 0;
    }
    
    public ProductoDistrito(int codigo, int ventas)
    {
        this.codigo = codigo;
        this.ventas = ventas;
    }
    
    
    public void lectura()
    {
        try{
            System.out.print("INTRODUCE UN CÓDIGO: ");
            codigo = LT.readInt();
            System.out.print("INTRODUCE LAS VENTAS: ");
            ventas = LT.readInt();
        } catch(Exception e){
            System.err.println("ERROR DE LECTURA");
        }
    }
    
    
    public int getCodigo()
    {
        return codigo;
    }
    public int getVentas()
    {
        return ventas;
    }
    
    
    public static ProductoDistrito getCentinela()
    {
        return CENTINELA;
    }
    public boolean esCentinela()
    {
        return codigo == CENTINELA.codigo;
    }
    
    
    public String toString()
    {
        return "Codigo: "+codigo+"\tVentas: "+ventas;
    }
}
