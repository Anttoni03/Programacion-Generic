/*
1. Dado un fichero de texto, de nombre problema1In.txt, se tiene que llevar a 
cabo la grabación del contenido del fichero, código de carácter a código de 
carácter, a otro fichero de texto de nombre problema1Out.txt. Generar el 
fichero problema1In.txt con un editor de texto con el formato texto.

NOTA: UTILIZACIÓN DE LAS CLASES BufferedReader y BufferedWriter
 */
package clase_teoría___10_12_2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Problemas___03_12_2021__1__UTILIZANDO_BUFFER {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Problemas___03_12_2021__1__UTILIZANDO_BUFFER().metodoPrincipal();
    }
     
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar el cñodigo de final de 
        //fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto BufferedReader para lectura desde un fichero de texto
        BufferedReader fichero1;
        //declaraciónj variable entera para almacenar, de uno en uno, los códigos
        //de caractereres leidos desde el fichero de texto
        int codigo;
        //declaración objeto BufferedWriter para escritura en un fichero de texto
        BufferedWriter fichero2;
        
        //ACCIONES
        //instanciar el objeto BufferedReader fichero1 para establecer el enlace con
        //el fichero problema1In.txt en modo lectura
        fichero1=new BufferedReader(new FileReader("problema1In.txt"));
        //instanciar el objeto BufferedWriter fichero2 para establecer el enlace con
        //el fichero problema1Out.txt en modo escritura
        fichero2=new BufferedWriter(new FileWriter("problema1Out.txt"));
        //lectura primer código de caracter desde el fichero fichero1In.txt a través
        //del objeto FileReader fichero1
        codigo=fichero1.read();
        //BUCLE DE TRATAMIENTO DE RECORRIDO PARA LLEVAR A CABO LA LECTURA, CÓDIGO
        //DE CARACTER A CÓDIGO DE CARACTER, DEL FICHERO fichero1In.txt Y LA
        //ESCRITURA, CÓDIGO DE CARACTER A CÓDIGO DE CARACTER, EN EL FICHERO
        //fichero1Out.txt
        while (codigo!=FINAL_FICHERO) {
            //escritura del código de caracter leído en el fichero fichero1Out.txt
            fichero2.write(codigo);
            //lectura del siguiente código de caracter desdel el fichero fichero1In.txt
            codigo=fichero1.read();
        }
        
        //cierre de enlaces de ficheros
        fichero1.close();
        fichero2.close();
        
      
    }
    
}
