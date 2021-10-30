 /*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.', visualiza el número de palabras contenidas en la secuencia que
tengan las cinco vocales.


OBJETIVO: TRATAMIENTO SECUENCIAL DE CARACTERES. TRATAMIENTO DE RECORRIDO CONDICIONAL
A ENCONTRAR EL PRIMER CARACTER DE UNA PALABRA Y UTILIZACIÓN DE SUBPROGRAMAS.
FECHA DE CREACIÓN: 29.10.2021
Autor: Juan Montes de Oca
 */
package clase_teoria_29_10_2021;

public class contarPalabrasSecuenciaConLasCincoVocales {
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
        new contarPalabrasSecuenciaConLasCincoVocales().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable de tipo int para almacenar el número de palabras
        //contenidas en la secuencia
        int numeroPalabrasConLasCincoVocales=0;

        
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
            if (esPalabraCincoVocales()) {
                //incrementar contador de palabras
                numeroPalabrasConLasCincoVocales++;
            }
            //buscar siguiente palabra
            buscarPalabra();  
        }
        
        //visualizar resultado
        System.out.println("EL NÚMERO DE PALABRAS CONTENIDAS EN LA SECUENCIA "
                + "QUE CONTIENEN LAS CINCO VOCALES ES "+numeroPalabrasConLasCincoVocales);
           

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
   
    
    //método función de tipo boolean para verificar si una palabra tiene las
    //cinco vocales
    private boolean esPalabraCincoVocales() {
        //DECLARACIONES
        //declaración variables enteras para representar los contadores de las
        //cinco vocales
        int contador_a=0,contador_e=0,contador_i=0,contador_o=0,contador_u=0; 
        
        //ACCIONES
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
            //tratamiento caracter de la palabra
            if (esVocal()) {
                switch (caracter) {
                    case 'A':
                    case 'a':   //incrementar contador de a's
                                contador_a++;
                                break;
                    case 'E':
                    case 'e':   //incrementar contador de e's
                                contador_e++;
                                break;
                    case 'I':
                    case 'i':   //incrementar contador de i's
                                contador_i++;
                                break;
                    case 'O':
                    case 'o':   //incrementar contador de o's
                                contador_o++;
                                break;
                    case 'U':
                    case 'u':   //incrementar contador de u's
                                contador_u++;
                }
            }
            //lectura siguiente caracter
            caracter=LT.readChar();
        }      
        //devolución resultado
        return ((contador_a>0)&&(contador_e>0)&&(contador_i>0)&&(contador_o>0)&&(contador_u>0));
        
    }
    
    
    //método función de tipo booleano esVocal que lleva a cabo la verificación
    //de si el caracter leido (almacenado en el atributo caracter) es una vocal
    //o no
    private boolean esVocal() {
        return ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||
                    (caracter=='u')||
                (caracter=='A')||(caracter=='E')||(caracter=='I')||(caracter=='O')||
                    (caracter=='U'));
    }

}