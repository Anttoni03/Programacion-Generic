/*
5. Dado un fichero de texto, de nombre problema5.txt, visualizar el número de 
caracteres vocales, el número de caracteres consonantes y el número de espacios 
en blanco contenidos en el fichero. Generar el fichero problema5.txt con un 
editor de texto con el formato texto.
 */
package clasepractica_07_12_2021;

import java.io.FileReader;


public class Problemas___03_12_2021__5 {    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Problemas___03_12_2021__5().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar el código de final de
        //fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto FileReader para lectura desde el fichero problema5.txt
        FileReader fichero;
        //declaración variable entera para almacenar, de uno en uno, los códigos
        //de caracter contenidos en el fichero problema5.txt
        int codigo;
        //declaración de variables enteras para almacenar el número de caracteres
        //vocales, el número de caracteres consonantes y el número de caracteres
        //espacio
        int numeroVocales=0, numeroConsonantes=0, numeroEspacios=0;
        
        //ACCIONES
        //instanciar el objeto FileReader fichero para establecer el enlace
        //con el fichero problema5.txt en modo lectura
        fichero=new FileReader("problema5.txt");
        //lectura primer código de caracter desde el fichero
        codigo=fichero.read();
        //BUCLE DE TRATAMIENTO DE RECORRIDO
        while (codigo!=FINAL_FICHERO) {
            //TRATAMIENTO código de caracter leído
            if (codigo==(int) ' ') {
                //incremento del contador de caraceteres espacio
                numeroEspacios++;
            }
            else {
                if (esVocal((char) codigo)) {
                    //incremento contador de vocales
                    numeroVocales++;
                }
                else {
                    //incrementar contador de consonantes
                    numeroConsonantes++;
                }
            }
            
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();
        }
        //cierre del enlace del fichero
        fichero.close();
        
        //visualizar resultados
        System.out.println("NÚMERO DE CONSONANTES: "+numeroConsonantes+"\n"
                + "NÚMERO DE VOCALES: "+numeroVocales+"\n"
                + "NÚMERO DE ESPACIOS: "+numeroEspacios);
    }

    
    //método función esVocal verifica si el caracter dado por parámetro es una
    //vocal
    private boolean esVocal(char caracter) {
        return ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||
                (caracter=='u'));
    }
}
