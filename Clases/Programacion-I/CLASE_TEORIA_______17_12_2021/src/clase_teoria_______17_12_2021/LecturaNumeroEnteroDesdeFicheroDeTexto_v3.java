/*
FUNCIONALIDAD: dado un fichero de texto, de nombre fichero3.txt, y cuyo contenido
son secuencias de caracteres numéricos, una por línea, lleva a cabo la lectura de estos caracteres
y su conversión a valor numerico y posterior visualización.
NOTA: tener en cuenta los salto de linea
 */
package clase_teoria_______17_12_2021;

import java.io.BufferedReader;
import java.io.FileReader;

public class LecturaNumeroEnteroDesdeFicheroDeTexto_v3 {
    //DECLARACIONES ATRIBUTOS DE LA CLAS        
    //declaración constante char para representar el caracter de control
    //RETURN
    private final char RETURN='\r';
    //declaración constante char para representar el caracter de control
    //SALTO DE LÍNEA
    private final char SALTO_LINEA='\n';
    //declaración constante char para representar el caracter espacio
    private final char ESPACIO=' ';
    //declaración constante entera para representar el código de final de
    //fichero
    private final int FINAL_FICHERO=-1;
    //declaración variable entera para almacenar, de uno en uno, los códigos
    //de caracteres contenidos en el fichero
    private int codigo;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new LecturaNumeroEnteroDesdeFicheroDeTexto_v3().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto BufferedReader para establecer el enlace en modo
        //lectura con el fichero fichero.txt
        BufferedReader fichero=new BufferedReader(new FileReader("fichero3.txt"));
        //declaración variable entera para alamcenar el valor numérico que representa
        //la secuencia de caracteres numéricos contenida en el fichero
        int numero;
        
        //ACCIONES
        //lectura primer código de caracter desde el fichero
        codigo=fichero.read();
        //bucle de lectura desde el fichero y tratamiento
        while (codigo!=FINAL_FICHERO) {
            //lectura numero
            numero=lecturaNumero(fichero);
            //visualización numero
            System.out.println("EL VALOR NUMÉRICO ES: "+numero);  
            //siguiente linea
            siguienteLinea(fichero);
        }
    }
    
    //método lecturaNumero que lleva  a cabo la lectura desde un fichero de
    //los códigos de caracteres correspondiente a una secuencia numérica convirtiéndola
    //en su valor numérico entero
    public int lecturaNumero(BufferedReader f) throws Exception{
        //DECLARACIONES
        //declaración variable entera para almacenar el valor numérico de 
        //la secuencia numérica
        int valorNumerico=0;
        
        //ACCIONES
        //bucle de lectura y conversión a númerico de la secuencia de códigos de 
        //caracteres numericos desde el fichero
        while ((codigo >= (int) '0')&&(codigo <= (int) '9')) {
            valorNumerico=valorNumerico*10+(codigo-(int)'0');
            //lectura siguiente código de caracter desde el fichero
            codigo=f.read();
        }
        
        //devolución valor numérico resultante
        return valorNumerico;
        
    }
    
    //método siguienteLinea lleva a cabo la búsqueda de la siguiente linea en el fichero
    public void siguienteLinea(BufferedReader f) throws Exception {
        while (((char) codigo==RETURN)||((char)codigo==SALTO_LINEA)||((char)codigo==ESPACIO)) {
            //lectura siguiente código de caracter desde el fichero
            codigo=f.read();
        }
        
    }
    
}
