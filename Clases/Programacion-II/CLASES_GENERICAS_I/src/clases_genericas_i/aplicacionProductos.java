/*
FUNCIONALIDAD: gestión de productos a través de un meno utilizando una pila de
productos.
 */
package clases_genericas_i;

public class aplicacionProductos {
    //declaración constante que representa el máximo número de
    //productos
    private final int MAXIMO_NUMERO_PRODUCTOS=100;
    //declaración pila de objetos Producto
    private PilaComparador<Producto> pilaProductos=new PilaComparador<Producto>(MAXIMO_NUMERO_PRODUCTOS);
    

    //método main
    public static void main(String [] argumentos) {
        new aplicacionProductos().metodoPrincipal();
    }
    
    //método metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración variable String para almacenar la expresión aritmética
        //leida por teclado y que hay que verificar
        Producto producto;
        //declaración booleana para controlar el final del programa
        boolean fin=false;
        //declaración boolena para controlar si la expresión es correcta o no
        boolean correcta;
        
        try {
        while (!fin) {
            menu();
            System.out.print("\nINTRODUCIR OPCIÓN: ");
            switch (LT.readInt()) {
                case 1: producto=new Producto();
                        producto.lectura();
                        //introducir producto en la pila
                        introducirProducto(producto);
                        break;
                case 2: //introducir código de producto a eliminar
                        System.out.print("INTRODUCIR CÓDIGO DE PRODUCTO A ELIMINAR: ");
                        int codigo=LT.readInt();
                        eliminarProducto(codigo);
                        break;
                case 3: //visualización productos de la pila
                        visualizacionPila();
                        break;
                case 4: //eliminación de los productos de la pila
                        vaciarPila();
                        break;
                case 5: fin=true;
            }

                
        }
        }catch (Exception error) {
            System.out.println(error.toString());
        }  


    }
    
    private void menu() {
        System.out.println("\n\n                  MENU\n\n");
        System.out.println("[1] INTRODUCIR PRODUCTO.");
        System.out.println("[2] ELIMINAR PRODUCTO.");
        System.out.println("[3] LISTADO PRODUCTOS.");
        System.out.println("[4] ELIMINAR TODOS LOS PRODUCTOS");
        System.out.println("[5] SALIR.");
    }
    
    private void introducirProducto(Producto producto) {
        PilaComparador<Producto> pilaAuxiliar=new PilaComparador<Producto>(MAXIMO_NUMERO_PRODUCTOS);
        
        if (pilaProductos.estaVacia()) {
            pilaProductos.introducir(producto);
        }
        else {
            //buscar lugar que le corresponde
            while ((!pilaProductos.estaVacia())&&(producto.compara(pilaProductos.cima())>=0)) {
                //transferir producto cima de la pilaProductos a pilaAuxiliar
                pilaAuxiliar.introducir(pilaProductos.extraer());
            }
            //introducir producto en pilaProductos
            pilaProductos.introducir(producto);
            //transferir los productos de pilaAuxiliar a pilaProductos
            while (!pilaAuxiliar.estaVacia()) {
                pilaProductos.introducir(pilaAuxiliar.extraer());
            }
        }       
    }
    
    private void eliminarProducto(int codigo) {
        PilaComparador<Producto> pilaAuxiliar=new PilaComparador<Producto>(MAXIMO_NUMERO_PRODUCTOS);
        
        if (pilaProductos.estaVacia()) {
            System.out.println("EL PRODUCTO DE CÓDIGO "+codigo+" NO HA PODIDO SER ELIMINADO PORQUE"
                    + " NO HAY NINGÚN PRODUCTO.");
        }
        else {
            //buscar lugar que le corresponde
            while ((!pilaProductos.estaVacia())&&(pilaProductos.cima().getCodigo()!=codigo)) {
                //transferir producto cima de la pilaProductos a pilaAuxiliar
                pilaAuxiliar.introducir(pilaProductos.extraer());
            }
            if (pilaProductos.estaVacia()) {
                System.out.println("EL PRODUCTO DE CÓDIGO "+codigo+" NO HA PODIDO SER ELIMINADO PORQUE"
                    + " EN LA PILA NO HAY NINGÚN PRODUCTO CON DICHO CÓDIGO");
            }
            else {
                //extraer producto cima de la pilaProductos pues el producto cuyo código es
                //el buscado
                pilaProductos.extraer();
            }
            //transferir los productos de pilaAuxiliar a pilaProductos
            while (!pilaAuxiliar.estaVacia()) {
                pilaProductos.introducir(pilaAuxiliar.extraer());
            }
        }         
    }
    
    private void visualizacionPila() {
        PilaComparador<Producto> pilaAuxiliar=new PilaComparador<Producto>(MAXIMO_NUMERO_PRODUCTOS);
        //copiar pilaProductos a pilaAuxiliar
        pilaProductos.copiar(pilaAuxiliar);
        //visualización pilaAuxiliar
        System.out.println("LISTADO DE PRODUCTOS");
        while (!pilaAuxiliar.estaVacia()) {
            System.out.println(pilaAuxiliar.extraer().toString());
        }
    }
    private void vaciarPila() {
        while (!pilaProductos.estaVacia()) {
            pilaProductos.extraer();
        }
    }

    
}
