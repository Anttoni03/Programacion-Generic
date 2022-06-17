/*
EJEMPLO UTILIZACIÓN CLASE Lista
 */
package clases_genericas_i;

public class prueba1ClaseCola {
    public static void main(String [] argumentos) throws Exception {
        Cola <String> miCola=new Cola <String>(10);
        String [] literales={"uno","dos","tres","cuatro"};
        for (int i=0;i<literales.length;i++) {
            miCola.introducir(literales[i]);
        }
        for (int i=0;!miCola.estaVacia();i++) {
            System.out.println(miCola.extraer());
        }   
    }
    
}
