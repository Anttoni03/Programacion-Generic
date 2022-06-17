/*
EJEMPLO UTILIZACIÓN CLASE Lista
 */
package clases_genericas_i;

public class prueba1ClasePila {
    public static void main(String [] argumentos) throws Exception {
        Pila <String> miPila=new Pila <String>(10);
        String [] literales={"uno","dos","tres","cuatro"};
        for (int i=0;i<literales.length;i++) {
            miPila.introducir(literales[i]);
        }
        for (int i=0;!miPila.estaVacia();i++) {
            System.out.println(miPila.extraer());
        } 
    }
    
}
