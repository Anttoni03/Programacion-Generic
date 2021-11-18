/*
FUNCIONALIDAD:
1. declaración de un objeto Producto sin inicializar.
2. declaración de un objeto Producto con inicialización.
3. Lectura, desde el teclado, del objeto Producto declarado
sin incializar.
4. Visualización de los dos objeto Producto declarados.
 */
package clasepractica_16_11_2021;

public class Producto_uso_1_v1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Producto_uso_1_v1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //1. declaración de un objeto Producto sin inicializar.
        Producto producto1=new Producto();
        //2. declaración de un objeto Producto con inicialización.
        Producto producto2=new Producto("Producto Segundo",
                                        "16-11-2021","16-11-2024",
                                        22.2,"Industrias Ferrerias sl",
                                        21.0);
        
        //ACCIONES
        //3. Lectura, desde el teclado, del objeto Producto declarado
        //sin incializar.
        producto1.lectura();
        
        //4. Visualización de los dos objeto Producto declarados.
        System.out.println("\nPRIMER PRODUCTO --> \n"+producto1.toString()+
                "\nSEGUNDO PRODUCTO --> \n"+producto2.toString());
        
    }
    
}
