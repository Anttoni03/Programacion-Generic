/*
CLASE Producto
 */
package clases_genericas_i;

public class Producto implements Comparador {
    //DECLARACIONES
    private int codigo;
    private String descripcion;
    
    //MÉTODOS
    
    //CONSTRUCTORES
    public Producto() {}
    
    public Producto(int dato1, String dato2) {
        codigo=dato1;
        descripcion=dato2;
    }
    
    //OTROS MÉTODOS
    
    //método que lleva a cabo la lectura de un producto desde el teclado
    public void lectura() {
        try {
            System.out.println("INTRODUCIR DATOS DEL PRODUCTO");
            System.out.print("   CÓDIGO: ");
            codigo=LT.readInt();
            System.out.print("   DESCRIPCIÓN: ");
            descripcion=LT.readLine();            
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //método que convierte un objeto Producto a String con fines de visualización
    @Override
    public String toString() {
        return "CODIGO: "+codigo+" / DESCRIPCIÓN: "+descripcion;
    }
    
    //método que retorna el código de un objeto Producto
    public int getCodigo() {
        return codigo;
    }
    
    //MÉTODO QUE RETORNA
    //  -1 SI EL CÓDIGO DEL PRODUCTO ES MENOR QUE EL DEL PRODUCTO DADO
    //  0 SI EL CÓDIGO DEL PRODUCTO ES IGUAL QUE EL DEL PRODUCTO DADO
    //  1 SI EL CÓDIGO DEL PRODUCTO ES mayor QUE EL DEL PRODUCTO DADO
    @Override
    public int compara(Comparador objeto) {
        if (codigo<((Producto) objeto).codigo) {
            return -1;
        } else if (codigo==((Producto) objeto).codigo) {
            return 0;
        }
        else {
            return 1;
        }
    }


    //MÉTODO QUE DEVUELVE true SI EL CÓDIGO DEL PRODUCTO ES MENOR QUE EL
    //CÓDIGO DEL PRODUCTO DADO
    @Override
    public boolean menorQue(Comparador objeto) {
        return (codigo<((Producto) objeto).codigo) ;
    }    
}
