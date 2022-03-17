/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.', visualiza la frecuencia de aparición de la pareja de 
caracteres 'l''a'.
ejemplo:
secuencia de entrada: hola que tal esta la noche.
salida: el número de pareja de caracteres 'l''a' es 2.

OBJETIVO: TRATAMIENTO SECUENCIAL DE CARACTERES. TRATAMIENTO DE RECORRIDO CONDICIONAL
A ENCONTRAR EL PRIMER CARACTER DE LA PAREJA Y UTILIZACIÓN DE SUBPROGRAMAS.
FECHA DE CREACIÓN: 22.10.2021
Autor: Juan Montes de Oca
 */
package clase_teoria_29_10_2021;

public class FrecuenciaParejaDeCaracteres_v3_CON_SUBPROGRAMAS {
    //DECLARACIONES ATRIBUTOS DE LA CLASE
    //declaración atributo constante de tipo char para representar el caracter de
    //final de secuencia
    static final char FINAL_SECUENCIA='.';
    //declaración constantes de tipo char para representar los caracteres
    //integrantes de la pareja a buscar
    static final char CARACTER1='l',CARACTER2='a';
    //declaración atributo variable de tipo char para almacenar, de uno en uno, los
    //caracteres leídos de la secuencia
    static char caracter;
    
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES

        //declaración variable de tipo int para almacenar el número de parejas de
        //caracteres a contar
        int contador=0;
  
        //ACCIONES
        //MENSAJE USUARIO PARA INTRODUCIR LA SECUENCIA DE CARACTERES POR TECLADO
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //LECTURA CARACTER
        caracter=LT.readChar();
        //TRATAMIENTO DE BÚSQUEDA DEL PRIMER CARACTER DE LA PAREJA EN LA SECUENCIA
        buscarPrimerCaracterPareja();
        
        //TRATAMIENTO PRINCIPAL DE RECORRIDO 
        while (caracter!=FINAL_SECUENCIA) {
            //TRATAMIENTO
            //lectura siguiente caracter
            caracter=LT.readChar();
            //verificar si el caracter leido es igual al segundo caracter de la
            //pareja a buscar
            if (caracter==CARACTER2) {
                //incrementar contador pareja identificada
                contador++;
            }
            
            //TRATAMIENTO DE BÚSQUEDA DEL PRIMER CARACTER DE LA PAREJA EN LA SECUENCIA
            buscarPrimerCaracterPareja();           
        }
        
        //VISUALIZAR RESULTADO
        System.out.println("EL NÚMERO DE PAREJA DE CARACTERES "+CARACTER1+CARACTER2+" ES: "+contador);
    } 
    
    //método buscarPrimerCaracterPareja que lleva a cabo la búsqueda del primer 
    //caracter de la pareja a contabilizar en la secuencia de caracteres
    public static void buscarPrimerCaracterPareja() throws Exception {
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=CARACTER1)) {
            //LECTURA CARACTER
            caracter=LT.readChar();
        }          
    }
}