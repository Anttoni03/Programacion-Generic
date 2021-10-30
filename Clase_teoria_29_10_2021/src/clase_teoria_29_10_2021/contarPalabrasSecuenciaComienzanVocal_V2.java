 /*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.', visualiza el número de palabras contenidas en la secuencia que
comienzan con caracter vocal.

NOTA: UTILIZACIÓN MÉTODO BOOLEANO esVocal PARA VERIFICAR SI UN CARACTER ES VOCAL

OBJETIVO: TRATAMIENTO SECUENCIAL DE CARACTERES. TRATAMIENTO DE RECORRIDO CONDICIONAL
A ENCONTRAR EL PRIMER CARACTER DE UNA PALABRA Y UTILIZACIÓN DE SUBPROGRAMAS.
FECHA DE CREACIÓN: 29.10.2021
Autor: Juan Montes de Oca
 */
package clase_teoria_29_10_2021;

public class contarPalabrasSecuenciaComienzanVocal_V2 {
    //DECLARACIONES ATRIBUTOS DE LA CLASE
    //declaración atributo constante de tipo char para representar el caracter de
    //final de secuencia
    final char FINAL_SECUENCIA='.';
    //declaración atributo constante de tipo char para representa el caracter espacio
    final char ESPACIO=' ';
    //declaración atributo variable de tipo char para almacenar, de uno en uno, los
    //caracteres leídos de la secuencia
    char caracter;
    
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new contarPalabrasSecuenciaComienzanVocal_V2().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable de tipo int para almacenar el número de palabras
        //contenidas en la secuencia
        int numeroPalabrasComienzanVocal=0;
        
        //ACCIONES
        //mensaje usuario para introducir secuencia de caracteres
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //lectura caracter desde la secuencia introducida
        caracter=LT.readChar();
        //llamar subprograma método procedimiento buscarPalabra
        buscarPalabra();
        //TRATAMIENTO DE RECORRIDO
        while (caracter!=FINAL_SECUENCIA) {
            //tratamiento palabra 
            if (esVocal()) {
                //contabilizar palabra que comienza por vocal
                numeroPalabrasComienzanVocal++;
            }

            //llamada al método procedimiento saltarPalabra que posibilita terminar
            //de leer todos los caracteres que restan en la secuencia de la palabra
            //que acabamos de tratar
            saltarPalabra();
            //buscar siguiente palabra
            buscarPalabra();  
        }
        
        //visualizar resultado
        System.out.println("EL NÚMERO DE PALABRAS CONTENIDAS EN LA SECUENCIA "
                + "QUE COMIENZAN CON CARACTER VOCAL ES "+numeroPalabrasComienzanVocal);
           

    } 
    
    //método procedimiento buscarPalabra lleva a cabo la búsqueda, a través
    //de la lectura de caracteres de la secuencia, de una palabra, es decir,
    //del primer caracter de una palabra.
    private void buscarPalabra() {
        while (caracter==ESPACIO) {
            //lectura caracter
            caracter=LT.readChar();
        }
    }
    
    //método procedimiento buscarPalabra que lleva a cabo la lectura de los
    //caracteres que restan de una palabra detectada
    private void saltarPalabra() {
        //mientras el caracter leido sea alfabético se lee el sieguiente
        //caracter de la secuencia
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
            //lectura caracter
            caracter=LT.readChar();
        }
    }
    
    //método función de tipo booleano esVocal que lleva a cabo la verificación
    //de si el caracter leido (almacenado en el atributo caracter) es una vocal
    //o no
    private boolean esVocal() {
        return ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||
                    (caracter=='u'));
    }
    

}