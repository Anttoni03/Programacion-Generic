/*
FUNCIONALIDAD: dado un fichero de texto, con el nombre fichero1.txt, lleva a cabo
la lectura y visualización de su contenido caracter a caracter.
NOTA: en esta versión no utilizamos la variable char caracter porque visualizamos
directamente el casting char del código de caracter ((char) codigo)).
 */
package claseteorica_____03_12_2021;

import java.io.FileReader;

public class ProblemaFicherosIntroduccionLectura_v2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar el código de final de fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto FileReader para lectura de un fichero de texto
        FileReader fichero;
        //declaración variable entera para almacenar, de uno en uno, los códigos de
        //caracteres contenidos en el fichero fichero1.txt
        int codigo;
        
        //ACCIONES
        //instanciación objeto FileReader fichero para establecer enlace con el fichero
        //físico fichero1.txt
        fichero=new FileReader("fichero1.txt");
        //lectura primer código de caracter del fichero
        codigo=fichero.read();
        //bucle de lectura desde el fichero y visualización
        while (codigo!=FINAL_FICHERO) {
            //visualización caracter correspondiente al código leído desde
            //el fichero
            System.out.print((char) codigo);
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();
        }
        //cierre del enlace con el fichero
        fichero.close();
    }
}
