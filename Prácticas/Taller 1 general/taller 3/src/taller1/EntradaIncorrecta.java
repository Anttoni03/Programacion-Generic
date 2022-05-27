/*
EXEPCIÓN NO PREDEFINIDA
 */


package taller1;


public class EntradaIncorrecta extends Exception {
    public EntradaIncorrecta (String mensaje) {
        super("¡¡¡¡ "+mensaje+" !!!!");
    }
}
