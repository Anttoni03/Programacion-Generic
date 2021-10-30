/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado y acabada
con el caracter '.', visualiza la frecuencia de aparición de la pareja de 
caracteres 'l''a'.
ejemplo:
secuencia de entrada: hola que tal esta la noche.
salida: el número de pareja de caracteres 'l''a' es 2.

OBJETIVO: TRATAMIENTO SECUENCIAL DE CARACTERES. TRATAMIENTO DE RECORRIDO A NIVEL
DE CARACTERES.
FECHA DE CREACIÓN: 19.10.2021
Autor: Juan Montes de Oca
 */
package clase_teoria_29_10_2021;

public class FrecuenciaParejaDeCaracteres_v1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración constante de tipo char para representar el caracter de
        //final de secuencia
        final char FINAL_SECUENCIA='.';
        //declaración constantes de tipo char para representar los caracteres
        //integrantes de la pareja a buscar
        final char CARACTER1='l',CARACTER2='a';
        //declaración variable de tipo char para almacenar, de uno en uno, los
        //caracteres leídos de la secuencia
        char caracter;
        //declaración variable de tipo int para almacenar el número de parejas de
        //caracteres a contar
        int contador=0;
  
        //ACCIONES
        //MENSAJE USUARIO PARA INTRODUCIR SECUENCIA DE CARACTERES
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //LECTURA CARACTER
        caracter=LT.readChar();
        //TRATAMIENTO DE RECORRIDO A NIVEL DE CARACTERES
        while (caracter!=FINAL_SECUENCIA) {
            //TRATAMIENTO CARACTER
            //verificar si el caracter leído es igual al primer caracter de la
            //pareja a buscar
            if (caracter==CARACTER1) {
                //LECTURA CARACTER
                caracter=LT.readChar();
                //verificar si el caracter leído es igual al segundo caracter de
                //la pareja a buscar
                if (caracter==CARACTER2) {
                    //INCREMENTAR CONTADOR DE PAREJA DE CARACTERES
                    contador++;
                }
            }
            else {
                //LECTURA CARACTER
                caracter=LT.readChar();
            }
        }
        
        //VISUALIZAR RESULTADO
        System.out.println("EL NÚMERO DE PAREJA DE CARACTERES "+CARACTER1+CARACTER2+" ES: "+contador);
    } 
}