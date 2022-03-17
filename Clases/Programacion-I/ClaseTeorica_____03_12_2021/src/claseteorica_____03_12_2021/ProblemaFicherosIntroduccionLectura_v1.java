/*
FUNCIONALIDAD: dado un fichero de texto, con el nombre fichero1.txt, lleva a cabo
la lectura y visualización de su contenido caracter a caracter.
 */
package claseteorica_____03_12_2021;

import java.io.FileReader;

public class ProblemaFicherosIntroduccionLectura_v1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar el código de final de fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto FileReader para lectura con fichero de texto
        FileReader fichero;
        //declaración variable entera para almacenar, de uno en uno, los códigos de
        //caracteres contenidos en el fichero fichero11.txt
        int codigo;
        //declaración variable char para almacenar el caracter correspondiente al código
        //de caracter leído desde el fichero
        char caracter;
        
        //ACCIONES
        //instanciación objeto FileReader fichero para establecer enlace con el fichero
        //físico fichero1.txt
        fichero=new FileReader("fichero1.txt");
        //lectura primer código de caracter del fichero
        codigo=fichero.read();
        //bucle de lectura desde el fichero y visualización
        while (codigo!=FINAL_FICHERO) {
            //conversión del código de caracter leído al caracter que representa
            caracter=(char) codigo;
            //visualización caracter correspondiente al código leído desde
            //el fichero
            System.out.println(codigo);
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();
        }
        //cierre del enlace con el fichero
        fichero.close();
    }
    
}
