/*
3. Dado un fichero de texto, de nombre problema3.txt, visualizar el primer 
carácter vocal contenido en el fichero. En caso que no hubiese ningún carácter 
vocal se tiene que visualizar el mensaje correspondiente. Generar el fichero 
problema3.txt con un editor de texto con el formato texto.
 */
package clasepractica_07_12_2021;

import java.io.FileReader;


public class Problemas___03_12_2021__3 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Problemas___03_12_2021__3().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar el código de final de
        //fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto FileReader para lectura desde el fichero problema3.txt
        FileReader fichero;
        //declaración variable entera para almacenar, de uno en uno, los códigos
        //de caracter contenidos en el fichero problema3.txt
        int codigo;
        //declaración variable booleana para gestionar y controlar la búsqueda
        boolean hayVocal=false;
        
        //ACCIONES
        //instanciar objeto FileReader para establecer enlace con el fichero
        //problema3.txt en modo lectura
        fichero=new FileReader("problema3.txt");
        //lectura primer código de caracter desde el fichero problema3.txt a
        //través del objeto FileReader fichero
        codigo=fichero.read();
        //BUCLE DE TRATAMIENTO DE BÚSQUEDA
        while ((codigo!=FINAL_FICHERO)&&(!hayVocal)) {
            //tratamiento código de caracter leído para verificar si se corresponde
            //con un caracter vocal
            if (esVocal((char) codigo)) {
                //visualización primera vocal encontrada
                System.out.println("LA PRIMERA VOCAL ES "+(char) codigo);
                //actualización variable booleana hayVocal para finalizar
                //la búsqueda
                hayVocal=true;     
            }
            else {
                //lectura siguiente código de caracter desde el fichero
                codigo=fichero.read();
            }   
        }
        //cierre enlace fichero
        fichero.close();
        
        if (!hayVocal) {
            //mensaje corespondiente
            System.out.println("EN EL FICHERO NO HAY VOCALES");
        }
        
    }

    
    //método función esVocal verifica si el caracter dado por parámetro es una
    //vocal
    private boolean esVocal(char caracter) {
        return ((caracter=='a')||(caracter=='e')||(caracter=='i')||(caracter=='o')||
                (caracter=='u'));
    }

    
    
}
