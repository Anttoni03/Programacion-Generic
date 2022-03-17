/*
FUNCIONALIDAD: dado un texto introducido por teclado y acabado en '.' lleva a cabo
la escritura, caracter a caracter, en un fichero de texto de nombre fichero2.txt.
NOTA: no utilizamos la variable entera codigo porque la funcionalidad read de la
clase FileWriter posibilita dar como parámetro el caracter y ella misma se encarga 
de garabar en el fichero el código de caracter correspondiente
 */
package claseteorica_____03_12_2021;

import java.io.FileReader;
import java.io.FileWriter;

public class PruebasDeFicherosJejeje {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración constante char para representar el final del texto con el
        //caracter '.'
        final char FINAL_TEXTO='.';
        int codigo;
        //declaración objeto FileWriter para escritura con fichero de texto
        //fichero2
        FileWriter ficheroEsc;
        FileReader ficheroLec;
        //declaración variable char para almacenar, de uno en uno, los caracteres
        //leídos desde el teclado
        char caracter;
        
        //ACCIONES
        //Instanciación objeto FileWriter fichero para establecer enlace con el
        //fichero físico fichero2.txt
        
        ficheroEsc=new FileWriter("fichero2.    txt");
        //mensaje usuario para introducir texto por teclado
        System.out.print("INTRODUCIR TEXTO: ");
        //lectura primer caracter del texto introducido por teclado
        caracter=LT.readChar();
        //bucle de lectura desde el teclado y escritura en el fichero caracter
        //a caracter
        while (caracter!=FINAL_TEXTO) {
            //escritura en el fichero del caracter leído desde el teclado
            ficheroEsc.write(caracter);
            //lectura siguiente caracter del texto desde el teclado
            caracter=LT.readChar();
        }
        ficheroEsc.close();
        ficheroLec=new FileReader("fichero2.txt");
        codigo = ficheroLec.read();
        while (codigo != -1){
            System.out.print((char)codigo);
            codigo = ficheroLec.read();
        }
        //cierre del enlace del fichero
        ficheroLec.close();
    }
    
}
