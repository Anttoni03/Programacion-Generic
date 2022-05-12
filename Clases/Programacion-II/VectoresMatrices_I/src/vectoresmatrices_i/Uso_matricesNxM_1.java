/*
FUNCIONALIDAD: ejemplo uso de la CLASE MatrizNxM
*/

package vectoresmatrices_i;


public class Uso_matricesNxM_1 {
    public static void main(String [] argumentos) throws Exception {
        //declaración de 3 objeto MatrizNxM
        MatrizNxM a=new MatrizNxM(3,2);
        MatrizNxM b=new MatrizNxM(2,3);        
        MatrizNxM c;
                
        //lectura matriz a por teclado
        a.lectura();
        //lectura matriz b por teclado
        b.lectura();
        //visualización matrices a y b
        System.out.println(a.toString());
        System.out.println(b.toString());

        //asignación a la matriz c del producto de las matrices a*b
        c=MatrizNxM.producto(a, b);
        //visualización matriz c
        System.out.println(c.toString());     
    }   
}
