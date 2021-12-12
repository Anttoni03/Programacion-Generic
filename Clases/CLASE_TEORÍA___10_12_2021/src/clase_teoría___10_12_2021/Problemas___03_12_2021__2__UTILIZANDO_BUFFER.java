/*
2. Dado un fichero de texto, de nombre problema2.txt, visualizar en pantalla 
el número de caracteres vocales contenidos en dicho fichero. Generar el fichero 
problema2.txt con un editor de texto con el formato texto.
NOTA: UTILIZACIÓN DE LA CLASE BufferedReader
 */
package clase_teoría___10_12_2021;

import java.io.BufferedReader;
import java.io.FileReader;


public class Problemas___03_12_2021__2__UTILIZANDO_BUFFER {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Problemas___03_12_2021__2__UTILIZANDO_BUFFER().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar el código de final de
        //fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto BufferedReader para lectura desde el fichero problema2.txt
        BufferedReader fichero;
        //declaración variable entera para almacenar, de uno en uno, los códigos
        //de caracter contenidos en el fichero problema2.txt
        int codigo;
        //declaración variable entera para almacenar el número de caracteres
        //vocales 
        int numeroVocales=0;
        
        //ACCIONES
        //instanciación del objeto BufferedReader fichero para establecer el enlace
        //con el fichero fisico problema2.txt en modo lectura
        fichero=new BufferedReader(new FileReader("problema2.txt"));
        //lectura primer código de caracter desde el fichero problema2.txt
        codigo=fichero.read();
        //BUCLE DE TRATAMIENTO DE RECORRIDO
        while (codigo!=FINAL_FICHERO) {
            //tratamiento caracter correspondiente alcódigo de caracter leído
            if (esVocal((char) codigo)) {
                //incrementar contador de vocales
                numeroVocales++;
                
            }
            
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();
        }
        //cierre enlace fichero
        fichero.close();
        //visualizar resultado
        System.out.println("EL NÚMERO DE CARACTERES VOCALES ES: "+numeroVocales);

    }
    
    //método función esVocal verifica si el caracter dado por parámetro es una
    //vocal
    private boolean esVocal(char caracter) {
        return ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||
                (caracter=='u'));
    }
    

}
