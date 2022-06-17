/*
CLASE Producto
 */
package clases_genericas_ii;

public class Producto {
    //DECLARACIÓN ATRIBUTOS
    private int codigo;
    private String descripcion;
    private int stock;
    
    //MÉTODOS
    public Producto() {}
    
    public Producto(int dato1, String dato2, int dato3) {
        codigo=dato1;
        descripcion=dato2;
        stock=dato3;
    }
    
    public void lectura() {
        System.out.print("CODIGO: ");
        codigo=LT.readInt();
        System.out.print("DESCRIPCIÓN: ");
        descripcion=LT.readLine();
        System.out.print("STOCK: ");
        stock=LT.readInt();
    }
    
    @Override
    public String toString() {
        return "CODIGO: "+codigo+" / DESCRIPCION: "+descripcion+" / STOCK: "+stock;
    }
    
    public int getStock() {
        return stock;
    }
    
}
