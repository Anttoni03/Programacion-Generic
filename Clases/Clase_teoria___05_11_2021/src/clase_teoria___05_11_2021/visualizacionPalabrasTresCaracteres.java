/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.', visualiza todas aquellas palabras contenidas en la secuencia
que estén conformadas por 3 caracteres.
OBJETIVO: tratamiento secuencial. tratamiento de recorrido. arrays.
FECHA DE CREACIÓN: 05.11.2021
AUTOR: Juan Montes de Oca
 */
package clase_teoria___05_11_2021;

public class visualizacionPalabrasTresCaracteres {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //atributo constante de tipo int para representar el máximo número de 
    //caracteres que puede tener una palabra
    final int MAXIMO_NUMERO_CARACTERES=20;
    //atributo constante de tipo char para representar el caracter de final
    //de secuencia
    final char FINAL_SECUENCIA='.';
    //atributo constante de tipo char para representar el caracter espacio
    final char ESPACIO=' ';
    //atributo variable de tipo char para almacenar, de uno en uno, los
    //caracteres leídos de la secuencia
    char caracter;
    //atributo variable de componente tipo char para almacenar los caracteres
    //de una palabra leídos desde la secuencia
    char [] palabra=new char[MAXIMO_NUMERO_CARACTERES];
    //atributo variable de tipo int para almacenar el número de caracteres de
    //la palabra almacenada en el array palabra
    int numeroCaracteres;
    
    //método main
    public static void main(String [] argumentos) throws Exception  {
        new visualizacionPalabrasTresCaracteres().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante de tipo int para representar el número de caracteres
        //que tiene que tener una palabra para ser visualizada según el
        //problema
        final int NUMERO_CARACTERES=3;
        
        //ACCIONES
        //mensaje usuario para introducir secuencia de caracteres
        System.out.print("INTRODUCIR SECUENCIA: ");
        //lectura primer caracter de la secuencia
        caracter=LT.readChar();
        //buscar primera palabra
        buscarPalabra();
        //BUCLE DE TRATAMIENTO DE RECORRIDO
        while (caracter!=FINAL_SECUENCIA) {
            //lectura palabra
            lecturaPalabra();
            //tratamiento palabra
            if (numeroCaracteres==NUMERO_CARACTERES) {
                //visualización palabra
                visualizacionPalabra();
            }
            //buscar siguiente palabra
            buscarPalabra();
        }
    }
    
    //método buscarPalabra
    private void buscarPalabra() {
        while (caracter==ESPACIO) {
            //lectura siguiente caractere
            caracter=LT.readChar(); 
        }
    }
    
    //método lecturaPalabra lleva a cabo la lectura de una palabra leyendo
    //sus caracteres, de uno en uno, de la secuencia de entrada. Los caracteres
    //de la palabra son almacenados en el array palabra
    private void lecturaPalabra() {
        //ACCIONES
        //inicializar el atributo numeroCaracteres
        numeroCaracteres=0;
        //bucle de lectura y almacenamiento de los caracteres de la palabra
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
            //almacenamiento caracter leido de la palabra en la componente
            //correspondiente del array palabra
            palabra[numeroCaracteres]=caracter;
            //incrementar el atributo numeroCaracteres pues acabamos de almacenar
            //un caracter de la palabra en el array palabra
            numeroCaracteres++;
            
            //lectura siguiente caracter de la secuencia
            caracter=LT.readChar();
        }
    }
    
    //método procedimiento visualización que lleva a cabo la visualización de
    //la palabra almacenada 
    private void visualizacionPalabra() {
        for (int indice=0;indice<numeroCaracteres;indice++) {
            System.out.print(palabra[indice]);
        }
        //salto de linea
        System.out.println();
    }
    
    
}
