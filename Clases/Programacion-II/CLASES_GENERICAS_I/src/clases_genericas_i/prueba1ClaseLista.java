/*
EJEMPLO UTILIZACIÓN CLASE Lista
 */
package clases_genericas_i;

public class prueba1ClaseLista {
    public static void main(String [] argumentos) throws Exception {
        Lista <String> milista=new Lista<String>(10);
        String [] literales={"uno","dos","tres","cuatro","cinco","seis"};
        for (int i=0;i<literales.length;i++) {
            milista.introducir(literales[i]);
        }
        for (int i=0;!milista.estaVacia();i++) {
            System.out.println(milista.extraer((milista.numElementos()-1)));
        }    
    }    
}
