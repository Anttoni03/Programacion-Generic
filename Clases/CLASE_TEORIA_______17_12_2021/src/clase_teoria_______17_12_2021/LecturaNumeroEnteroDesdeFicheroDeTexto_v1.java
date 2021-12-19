/*
FUNCIONALIDAD: dado un fichero de texto, de nombre fichero1.txt, y cuyo contenido
es una secuencia de caracteres numéricos lleva a cabo la lectura de estos caracteres
y su conversión a valor numerico y posterior visualización
 */
package clase_teoria_______17_12_2021;

import java.io.BufferedReader;
import java.io.FileReader;

public class LecturaNumeroEnteroDesdeFicheroDeTexto_v1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new LecturaNumeroEnteroDesdeFicheroDeTexto_v1().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar el código de final de
        //fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto BufferedReader para establecer el enlace en modo
        //lectura con el fichero fichero.txt
        BufferedReader fichero=new BufferedReader(new FileReader("fichero1.txt"));
        //declaración variable entera para almacenar, de uno en uno, los códigos
        //de caracteres contenidos en el fichero
        int codigo;
        //declaración variable entera para alamcenar el valor numérico que representa
        //la secuencia de caracteres numéricos contenida en el fichero
        int numero=0;
        
        //ACCIONES
        //lectura primer código de caracter desde el fichero
        codigo=fichero.read();
        //bucle de lectura desde el fichero y tratamiento
        while (codigo!=FINAL_FICHERO) {
            //acumular en numero el valor númérico del caracter correspondiente
            //al código de caracter leído
            numero=numero*10+(codigo-(int)'0');
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();
        }
        //visualización valor numérico de la secuencia de caracteres numéricos
        //contenida en el fichero
        System.out.println("EL VALOR NUMÉRICO ES: "+numero);  
    }
    
}
