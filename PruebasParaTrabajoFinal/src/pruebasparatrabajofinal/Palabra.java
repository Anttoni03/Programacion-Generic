//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package pruebasparatrabajofinal;

/*
CLASE Palabra
Aglutina las declaraciones y funcionalidades para gestionar objetos Palabra
 */

public class Palabra {
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE QUE DESCRIBEN EL ESTADO DE LOS
    //OBJETOS Palabra
    //declaración atributo de clase constante de tipo entero para representar el máximo
    //número de caractres que puede tener un objeto Palabra
    private static final int MAXIMO_NUMERO_CARACTERES=20;
    //declaración atributo de clase constante de tipo char para representar el
    //caracter de fin de secuencia de caracteres
    private static final char FINAL_SECUENCIA='.';
    //declaración atributo de clase constante de tipo char que representa el
    //caracter espacio en blanco(' '
    private static final char ESPACIO=' ';
    //declaración atributo de clase variable de tipo char paa representar el
    //caracter leido de la secuencia de caracteres
    private static char caracter=ESPACIO;
    //declaración atributo de objeto de tipo array de componentes tipo char para
    //representar/almacenarlos caracteres de un objeto Palabra
    private char [] caracteres=new char[MAXIMO_NUMERO_CARACTERES];
    //declaración atrbuto de objeto de tipo entero para representar el número
    //de caracteres de un objeto Palabra
    private int numeroCaracteres;
    
    
    //MÉTODOS
    //método constructor
    public Palabra() {
        //inicialización del atributo de objeto numeroCaracteres
        numeroCaracteres=0;
    }   
        
    //método de clase buscarPalabra que lleva a cabo la búsqueda de un objeto Palabra 
    //en la secuencia de caracteres
    public static void buscarPalabra() {
        while (!esLetra(caracter) && caracter != FINAL_SECUENCIA) {
            //lectura siguiente caracter de la secuencia
            caracter=LT.readChar();
        }
    }
    
    //método de objeto lectura que lleva a cabo la lectura de un objeto Palabra
    //desde la secuencia de caracteres.
    //NOTA: el método lectura solo será llamado siempre y cuando haya, al menos,
    //una palabra en la secuencia para leer
    public void lectura() {
        //inicialización atributo numeroCaracteres a 0
        numeroCaracteres=0;
        //bucle de lectura y almacenamiento de los caracteres del objeto Palabra a leer
        //desde la secuencia de caracteres
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
            //al ser un caracter alfabético es un caracter de la palabra que estamos
            //leyendo y or lo tanto será almacenado en la componente que
            //le corresponde del array caracteres
            caracteres[numeroCaracteres]=caracter;
            //incremneto del atributo numeroCaracteres
            numeroCaracteres++;
            //lectura siguiente caracter de la secuencia 
            caracter=LT.readChar();
        }
        caracter = ESPACIO;
    }
    
    
    //método booleano esLetra que lleva a cabo la comprobación de ser una letra
    //con el carácter dado
    private static boolean esLetra(char car){
        return (int)car >= 'a' && (int)car <= 'z';
    }
    
    //método de objeto getNumeroCaracteres devuelve el número de caracteres de 
    //un objeto Palabra
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
  
    //MÉTODO adicionCaracter LLEVA A CABO LA ADICIÓN DE UN CARACTER DADO POR PARÁMETRO
    //EN UN OBJETO Palabra
    public void adicionCaracter(char caracter) {
        //almacenar el caracter dado en la primera componente libre del atributo
        //caracteres del objeto Palabra. El índice de dicha componente coincide
        //con el valor del atributo numeroCaracteres del mismo objeto Palabra
        caracteres[numeroCaracteres]=caracter;
        //incrementar el atributo numeroCaracteres del objeto Palabra para que
        //tenga en cuenta el caracter que acabamos de añadir en la palabra
        numeroCaracteres++;
    }
    
    //MÉTODO obtenerCaracter LLEVA A CABO LA OBTENCIÓN DEL CARACTER DE UNA
    //PALABRA QUE ESTÁ ALMACENADO EN LA POSICIÓN DADA DENTRO DEL ATRIBUTO
    //caracteres DE DICHO OBJETO Palabra
    public char obtenerCaracter(int posicion) {
        //devolver el caracter del objeto Palabra que está en la posición
        //dada dentro del atributo array caracteres
        return (caracteres[posicion]);
    }   
    
    //MÉTODO DE CLASE copiar LLEVA A CABO LA COPIA DE UN PRIMER OBJETO Palabra DADO
    //POR PARÁMETRO EN UN SEGUNDO OBJETO Palabra DADO POR PARÁMETRO
    public static void copiar(Palabra palabra1, Palabra palabra2) {
        //asignación al atributo numeroCaracteres del objeto palabra2 del contenido
        //del atributo numeroCaracateres del objeto palabra1
        palabra2.numeroCaracteres=palabra1.numeroCaracteres;
        //bucle de copiado, caracter a caracter, del atributo caracteres del
        //objeto palabra1 en el atributo caracteres del objeto palabra2
        for (int indice=0;indice<palabra1.numeroCaracteres;indice++) {
            //asignación a la componente indice del atributo caracteres del
            //objeto palabra2 del contenido de la componente indice del
            //atributo caracteres del objeto palabra1
            palabra2.caracteres[indice]=palabra1.caracteres[indice];
        }
    }
    
    //MÉTODO DE CLASE iguales LLEVA A CABO LA VERIFICACIÓN DE SI LOS DOS OBJETOS
    //Palabra DADOS PORPARÁMETROS SON IGUALES
    public static boolean iguales(Palabra palabra1, Palabra palabra2) {
        if (palabra1.numeroCaracteres==palabra2.numeroCaracteres) {
            //verificación si son iguales a nivel de caracteres
            for (int indice=0;indice<palabra1.numeroCaracteres;indice++) {
                //verificación si son iguales a nivel de la componente indice
                //del atributo caracteres
                if (palabra1.caracteres[indice]!=palabra2.caracteres[indice]) {
                    //devolución valor false porque no son iguales
                    return false;
                }
            }
            //devolución valor true porque ambos objetos Palabra son iguales
            //ya que tienen todos los caracteres son iguales
            return true;
        }
        else {
            //devolución valor false porque los dos objetos no son iguales
            //porque no tienen el mismo número de caracteres
            return false;
        }
    }
}
