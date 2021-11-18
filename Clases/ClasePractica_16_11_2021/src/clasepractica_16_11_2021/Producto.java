/*
CLASE Producto
Aglutina la declaración de los atributos y las funcionalidades de objetos Procuto
 */
package clasepractica_16_11_2021;

public class Producto {
    //DECLARACIONES DE LOS ATRIBUTOS DE LA CLASE QUE DEFINEN EL ESTADO
    //DE TODO OBJETO Producto
    //declaración atributo de objeto para representar el nombre de un objeto producto
    private String nombre;
    //declaración atributo de objeto para representa la fecha de creacion de un
    //objeto Producto
    private String fechaCreacion;
    //declaración atributo de objeto para representa la fecha de caducidad de un
    //objeto Producto
    private String fechaCaducidad;    
    //declaración atributo de objeto para representar el precio de venta del
    //objeto Producto
    private double precioVenta;
    //declaración atributo de objeto para representar el proveedor de un objeto
    //Producto
    private String proveedor;
    //declaración atributo de objeto para representar el IVA de un objeto 
    //Producto
    private double iva;
    
    
    //MÉTODOS
    
    //MÉTODOS CONSTRUCTORES
    //método constructor sin parámetros
    public Producto() {}
    
    //método constructor con parámetros que posibilitan inicializar los atributos
    //del objeto Producto a instanciar
    public Producto(String dato1, String dato2, String dato3, double dato4, 
            String dato5, double dato6) {
        nombre=dato1;
        fechaCreacion=dato2;
        fechaCaducidad=dato3;
        precioVenta=dato4;
        proveedor=dato5;
        iva=dato6;
    }
    
    //MÉTODO FUNCIONALES QUE DEFINEN EL COMORTAMIENTO DE TODO OBJETO Producto
    
    //método de objeto lectura que lleva a cabo la lectura desde el teclado
    //de un objeto Producto
    public void lectura() {
        //mensaje usuario para comunicarle la introducción de un objeto Producto
        //desde el teclado
        System.out.println("LECTURA OBJETO Producto");
        //mensaje usuario para introducir el nombre del producto
        System.out.print("NOMBRE: ");
        //lectura valor introducido desde el teclado asignándolo al atributo
        //nombre
        nombre=LT.readLine();
        //mensaje usuario para introducir el nombre de la fecha de creación
        System.out.print("FECHA DE CREACIÓN: ");
        //lectura valor introducido desde el teclado asignándolo al atributo
        //fechaCreacion
        fechaCreacion=LT.readLine();
        //mensaje usuario para introducir la fecha de caducidad del producto
        System.out.print("FECHA DE CADUCIDAD: ");
        //lectura valor introducido desde el teclado asignándolo al atributo
        //fechaCaducidad
        fechaCaducidad=LT.readLine();
        //mensaje usuario para introducir el precio de venta del producto
        System.out.print("PRECIO DE VENTA: ");
        //lectura valor introducido desde el teclado asignándolo al atributo
        //precioVenta
        precioVenta=LT.readDouble();
        //mensaje usuario para introducir el proveedor del producto
        System.out.print("PROVEEDOR: ");
        //lectura valor introducido desde el teclado asignándolo al atributo
        //proveedor
        proveedor=LT.readLine();
        //mensaje usuario para introducir el IVA del producto
        System.out.print("IVA: ");
        //lectura valor introducido desde el teclado asignándolo al atributo
        //iva
        iva=LT.readDouble();
    }
    
    
   //método función toString de tipo String que lleva a cabo la conversión
    //de la información representada por los atributos de un objeto a formato
    //String con fines de visualización a través de las sentencias System.out.print
    //o System.out println
    public String toString() {
        return "NOMBRE: "+nombre+"\n"+
               "FECHA DE CREACIÓN: "+fechaCreacion+"\n"+
               "FECHA DE CADUCIDAD: "+fechaCaducidad+"\n"+
               "PRECIO DE VENTA: "+precioVenta+"\n"+
               "PROVEEDOR: "+proveedor+"\n"+
               "IVA: "+iva+"\n";
    }
    
    //método función masBaratoQue booleano que lleva a cabo la verificación de
    //si el precio de venta de un objeto Producto es menor que el dado por
    //parámetro
    public boolean masBaratoQue(double precio) {
        return (precioVenta<precio);
    }
    
    
}
