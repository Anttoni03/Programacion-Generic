/*
 * Calse excepción no predefinida asociada a eventos en los que el valor introducido
 * no está en el rango permitido y esperado. Por ejemplo, en el caso del factorial,
 * un valor fuera de rango, atribuible a esta excepción sería un número entero n<0
 */
package ejercicioclase.programacionii;

public class NumeroFueraDeRango extends Exception {
    public NumeroFueraDeRango(String mensaje)
    {
        super(mensaje);
    }
}