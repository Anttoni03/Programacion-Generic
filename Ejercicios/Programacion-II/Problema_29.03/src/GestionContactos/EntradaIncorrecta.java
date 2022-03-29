/*
EXEPCIÓN NO PREDEFINIDA
 */


package GestionContactos;


public class EntradaIncorrecta extends Exception {
    public EntradaIncorrecta (String mensaje) {
        super("¡¡¡¡ "+mensaje+" !!!!");
    }
}
