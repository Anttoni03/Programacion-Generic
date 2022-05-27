package taller1;
//Autor: Nahuel Vazquez
import java.io.IOException;

//Clase que hereda de IOException que permite la implementacion de una excepcion para las entradas
//de datos por consola invalidas.
public class InsercioDadesException extends IOException{
    public InsercioDadesException (String mensaje) {
        super("¡¡¡¡ "+mensaje+" !!!!");
    }
}
