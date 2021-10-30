/*
PROBLEMA 5
Máximo de tres enteros.
Subprograma que recibe tres enteros y devuelve el más grande, usando el subprograma
del PROBLEMA 3.
 */


public class Problema5_Gamificacion_3 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Problema5_Gamificacion_3().metodoPrincipal();
    }
    
    //método metodoPrincipal
    public void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración de 3 variables de tipo int para representar los
        //3 números enteros del problema
        int numero1=20, numero2=10, numero3=40;
        
        //ACCIONES
        //visualización del mayor de los 3 números
        System.out.println("EL MAYOR DE LOS TRES NÚMEROS ES "+mayorTres(numero1,numero2,numero3));
    }
    
    //método función mayorTres que devuelve el mayor de los 3 números dados por parámetro. Este método
    //utiliza el subprograma función mayorDos desarrollado en el problema3
    private int mayorTres(int dato1, int dato2, int dato3) {
        //ACCIONES
        return (mayorDos(dato1,mayorDos(dato2,dato3)));
        
    }
    
    
    //método función mayorDos que devuelve el mayor de los 2 números dadospor
    //parámetro.
    private int mayorDos(int dato1, int dato2) {
        //ACCIONES
        if (dato1>=dato2) {
            //devolución dato1 como mayor
            return dato1;
        }
        else {
            //devolución dato2 como mayor
            return dato2;
        }
    }
    
}
