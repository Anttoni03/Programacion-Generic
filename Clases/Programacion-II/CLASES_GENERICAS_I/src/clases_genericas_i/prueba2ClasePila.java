/*
EJEMPLO UTILIZACIÓN CLASE Lista
 */
package clases_genericas_i;

public class prueba2ClasePila {
    public static void main(String [] argumentos) throws Exception {
        Pila<Integer> pila=new Pila<Integer>(10);
        Pila<Integer> pilaAuxiliar;
        for (int i=0;i<10;i++) {
            pila.introducir(i);
        }
        System.out.println("ELEMENTO CIMA: "+pila.cima());
        System.out.println("ELEMENTO BASE: "+pila.elementoBase());
        
        System.out.println("VISUALIZACIÓN CONTENIDO PILA"+pila.toString());
        pilaAuxiliar=pila.invertir();
        System.out.println("VISUALIZACIÓN CONTENIDO PILA INVERTIDA"+pilaAuxiliar.toString());
        
    }
    
}
