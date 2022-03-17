/*
CLAS DE Carta aglutina las declaraciones y funcionalidades para poder gestionar
objetos Carta
*/
package clase_practica_____21_12_2021;

public class Carta {
    //DECLARACIÓN ATRIBUTOS
    private String palo;
    private int valor;
    
    //MÉTODO CONSTRUCTOR
    public Carta(String dato1, int dato2) {
        palo = dato1;
        valor = dato2;
    }
    
    //MÉTODOS FUNCIONALES
    public String getPalo() {
        return palo;
    }
    
    public int getValor() {
        return valor;
    }
    
    @Override
    public String toString() {
        return "(Palo: " + palo + " | Valor:" + valor + ")";
    }
}
