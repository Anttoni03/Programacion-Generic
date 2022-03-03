package clasepráctica__03_03_2022;


/*
CLASE Entero
Aglutina las declaraciones y funcionalidades para poder gestionar objetos Entero
que posibilitan la lectura de número enteros desde un fichero utilizando la
clase FileInputStream fundamentando la confección de un entero en base a ir
acumulando a su valor los diferentes dígitos numéricos que lo conforman.

autor: Juan Montes de Oca
 */

public class Entero {
    //ATRIBUTOS
    //declaración código de caracter correspondiente al menor caracter
    //dígito numérico (0)
    private static final int CODIGO_MENOR=48;
    //declaración código de caracter correspondiente al mayor caracter
    //dígito numérico (9)
    private static final int CODIGO_MAYOR=57;    
    //declaración atributo entero que representa el valor entero de un objeto Entero
    private int valor;
    //declaración atributo entero que representa el número de digitos de un objeto
    //Entero
    private int digito;
    
    //CONSTRUCTOR
    public Entero() {
        digito=0;     
    }
    
    //método insertarDigito lleva a cabo la inserción de un nuevo dígito a un objeto 
    //Entero
    public void insertarDigito(int codigo) {
        //incialización del atributo valor para empezar a admitir digitos numéricos
        if (digito==0) {
            valor=0;
        }
        //acumular en valor el valor correspondiente al nuevo dígito
        valor=(valor*10)+(codigo-CODIGO_MENOR);
        //incrementar digito
        digito++;
    }
    
    //método toString
    public String toString() {
        return ""+valor;
    }
    
    //método esDigitoNumerico verifica si un código corresponde a un caracter numérico
    public static boolean esDigitoNumerico(int codigo) {
        return ((codigo>=CODIGO_MENOR)&&(codigo<=CODIGO_MAYOR));
    }
    
    //método que verifica si un objeto Entero representa un valor numérico
    public boolean representaValorNumerico() {
        return (digito>0);
    }
}
