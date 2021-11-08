/*
1. Declara un array de 5 componentes, asígnale valores numéricos enteros por 
teclado y visualiza todas las componentes por pantalla. 
Utiliza un metodo para la asignación y otro para la visualización.
 */
package clase_teoria___05_11_2021;

public class Gamificacion_5_Problema1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_5_Problema1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración array de 5 componentes enteras
        int [] numeros=new int[5];
        
        //ACCIONES
        //inicialización de las componentes del array numeros a través del
        //teclado
        inicializacion(numeros);

        //visualización de las componentes del array numeros
        visualizacion(numeros);   
    }
    
    //método inicializacion que lleva a cabo la inicialización por teclado de
    //las componentes del array pasado por parámetro
    private void inicializacion(int [] dato) {
        for (int indice=0;indice<dato.length;indice++) {
            //mensaje usuario para introducir el valor para la componente
            //indice-ésima del array numeros
            System.out.print("VALOR COMPONENTE "+(indice+1)+": ");
            //lectura valor introducido por teclado asignándolo a la 
            //componentes indice-ésima del array numeros
            dato[indice]=LT.readInt();
        }
    }
    
    //método visualizacion lleva a cabo la visualización del array, componente
    //a componente, dado por parámetro
    private void visualizacion(int [] dato) {
        for (int indice=0;indice<dato.length;indice++) {
            //visualización componente indice-ésima del array numeros
            System.out.println("COMPONENTE "+(indice+1)+": "+dato[indice]);
        }        
    }
    
}
