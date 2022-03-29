/*
EXEPCIÓN NO PREDEFINIDA
 */


package proyecto_clases_problemas_a_realizar__29_03_2022;


public class EntradaIncorrecta extends Exception {
    public EntradaIncorrecta (String mensaje) {
        super("¡¡¡¡ "+mensaje+" !!!!");
    }
}
