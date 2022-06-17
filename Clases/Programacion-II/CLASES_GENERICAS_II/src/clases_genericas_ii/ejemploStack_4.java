/*
FUNCIONALIDAD: introducción de N productos en una pila para posteriormente
visualizar aquellos con un stock superior a 100

OBJETIVO: INTRODUCCIÓN CLASE Stack
 */
package clases_genericas_ii;
import java.util.Stack;

public class ejemploStack_4 {
    public static void main(String [] argumentos) throws Exception {
        new ejemploStack_4().metodoPrincipal();
    }
    
    public void metodoPrincipal() throws Exception {
        //DELARACIONES
        //instanciación pila utilizando la clase Stack para objetos Producto
        Stack<Producto> pila=new Stack<Producto>();
        //declaración objeto Producto para almacenar
        Producto producto;
        //declaración variable entera numeroProductos para almacenar el número de
        //productos a introducir
        int numeroProductos=0;
        
        //ACCIONES
        //solicitud número de productos a introducir
        System.out.print("NÚMERO DE PRODUCTOS A INTRODUCIR: ");
        numeroProductos=LT.readInt();
        //lectura por teclado e introducción en la pila de los numeroProductos
        for (int indice=0;indice<numeroProductos;indice++) {
            //instanciación objeto producto
            producto=new Producto();
            //lectura producto
            producto.lectura();
            //introducción del producto leido en la pila
            pila.push(producto);
        }
        //visualización de los productos contenidos en la pila cuyo stock sea superior a
        //100
        System.out.println("\nPRODUCTOS CON UN STOCK SUPERIOR A 100");
        while (!pila.empty()) {
            //extracción elemento de la pila
            producto=pila.pop();
            //verificación de si el stock del producto extraido de la pila es
            //mayor que 100
            if (producto.getStock()>100) {
                //visualización del producto
                System.out.println(producto.toString());                
            }

        }
    }
    
    
}

