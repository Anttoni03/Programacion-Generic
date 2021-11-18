/*
FUNCIONALIDAD: lleva a cabo las siguientes acciones:
1. declaración de un objeto Libro sin incialización.
2. declaración de un objeto Libro con inicialización.
3. lectura del objeto Libro declarado sin inicialización.
4. visualización de los dos objetos Libros declarados.
 */
package clasepractica_16_11_2021;

public class Lbro_uso_1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Lbro_uso_1().metodoPrincipal();
    }
    
    //método metodoPrincipal() 
    private void metodoPrincipal() {
        //DECLRACIONES
        //1. declaración de un objeto Libro sin incialización
        Libro libro1=new Libro();
        //2. declaración de un objeto Libro con inicialización
        Libro libro2=new Libro("primero","uno","primerGenero","primera",2001);
        
        //ACCIONES
        //3. lectura del objeto Libro declarado sin inicialización
        libro1.lectura();
        
        //4. visualización de los dos objetos Libros declarados
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        //sentencia equivalente a las dos anteriores
//        System.out.println(libro1.toString()+"\n"+libro2.toString());
        
    }
    
    
}
