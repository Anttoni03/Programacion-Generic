/*
EJEMPLO DE UTILIZACIÓN DE LA CLASE Vector
*/
package vectoresmatrices_i;


public class Uso_clase_Vector_1 {
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        Vector a=new Vector(3);
        Vector b=new Vector(3);
        //lectura desde el teclado del vector a
        a.lectura();
        //asignación de valores aleatoria al vector b con valores [0,20)
        b.lectura();
        //visualización de los vectores y del módulo de los mismos
        System.out.println("El modulo del vector " + a.toString()+" es: " + a.modulo());
        System.out.println("El modulo del vector " + b.toString()+" es: " + b.modulo());  
        
        System.out.println(a.productoEscalar(b));
    }
    
}
