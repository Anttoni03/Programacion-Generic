/*
FUNCIONALIDAD:
1. declaración un array de 5 objetos Productos.
3. Lectura, desde el teclado, de todos los objetos Producto del array.
4. Visualización de todos los objetos Producto del array.
5. Visualizar los objetos Producto del array
que sean mas baratos de 100.00 euros
 */
package clasepractica_16_11_2021;

public class Producto_uso_1_v2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Producto_uso_1_v2().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //1. declaración un array de 5 objetos Productos.
        Producto [] productos=new Producto[5];
        
        //ACCIONES
        //3. Lectura, desde el teclado, de todos los objetos Producto del array.
        for (int indice=0;indice<productos.length;indice++) {
            //instanciación de la componente indice-ésima del array productos
            //como objeto producto
            productos[indice]=new Producto();
            //lectura del objeto Producto componente indice del array productos
            //desde el teclado
            productos[indice].lectura();
        }
        
        //4. Visualización de todos los objetos Producto del array.
        for (int indice=0;indice<productos.length;indice++) {
            //visualización del objeto Producto que está almacenado en
            //la componente indice-ésima del array productos
            System.out.println(productos[indice]);
        }
        
        //5. Visualizar los objetos Producto del array
        //que sean mas baratos de 100.00 euros
        //mensaje comunicación de la visualziación
        System.out.println("LISTADO DE PRODUCTOS MÁS BARATOS QUE 100.00 euros");
        for (int indice=0;indice<productos.length;indice++) {
            //verificar que el objeto Producto almacenado en
            //componente indice-ésima del array productos es 
            //más barato de 100.00 euros
            if (productos[indice].masBaratoQue(100.0)) {
                //visualización del objerto Producto pues es más barato
                System.out.println(productos[indice].toString());
            }
        }
    }
    
}
