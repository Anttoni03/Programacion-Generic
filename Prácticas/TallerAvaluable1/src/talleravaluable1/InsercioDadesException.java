/*
CREADOR: TONI ROCA CASTRO
CLASE InsercioDadesException (EXCEPCIÓN NO PREDEFINIDA)
 */
package talleravaluable1;

public class InsercioDadesException extends Exception{
    public InsercioDadesException(String mensaje) {
        super("¡¡¡ "+mensaje+" !!!");
    }
}
