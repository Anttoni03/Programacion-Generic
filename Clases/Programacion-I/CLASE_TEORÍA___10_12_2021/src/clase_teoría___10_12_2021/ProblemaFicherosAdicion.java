/*
FUNCIONALIDAD: dado un texto introducido por teclado y acabado en '.' lleva a cabo
la escritura, caracter a caracter, en un fichero de texto de nombre fichero2.txt.
NOTA: la escritura no tiene que eliminar el contenido del fichero en caso que éste ya
existiese antes de la ejecuciòn del programa. PARA ELLO UTILIZAREMOS EL SEGUNDO
CONSTRUCTOR DEL CLASE FileWriter:
        FileWriter(String nombreFichero, boolean valorTRUE)
 */
package clase_teoría___10_12_2021;

import java.io.FileWriter;

public class ProblemaFicherosAdicion {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración constante char para representar el final del texto con el
        //caracter '.'
        final char FINAL_TEXTO='.';
        //declaración objeto FileWriter para escritura con fichero de texto
        //fichero2
        FileWriter fichero;
        //declaración variable char para almacenar, de uno en uno, los caracteres
        //leídos desde el teclado
        char caracter;
        
        //ACCIONES
        //Instanciación objeto FileWriter fichero para establecer enlace con el
        //fichero físico fichero2.txt en modo escritura ADICIÓN
        fichero=new FileWriter("fichero2.txt",true);
        //mensaje usuario para introducir texto por teclado
        System.out.print("INTRODUCIR TEXTO: ");
        //lectura primer caracter del texto introducido por teclado
        caracter=LT.readChar();
        //bucle de lectura desde el teclado y escritura en el fichero caracter
        //a caracter
        while (caracter!=FINAL_TEXTO) {
            //escritura en el fichero del caracter leído desde el teclado
            fichero.write(caracter);
            //lectura siguiente caracter del texto desde el teclado
            caracter=LT.readChar();
        }
        //cierre del enlace del fichero
        fichero.close();

    }
    
}
