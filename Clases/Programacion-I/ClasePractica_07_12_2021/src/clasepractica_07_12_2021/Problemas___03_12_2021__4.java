/*
4. Dado un fichero de texto, de nombre problema4.txt, visualizar el número 
de parejas de caracteres ‘l’’a’ contenidas en el fichero. Generar el fichero 
problema4.txt con un editor de texto con el formato texto.
 */
package clasepractica_07_12_2021;

import java.io.FileReader;


public class Problemas___03_12_2021__4 {
    //ATRIBUTOS DE LA CLASE
    //declaración constante entera para representar el código de final de
    //fichero
    private final int FINAL_FICHERO=-1;
    //declaración variable entera para almacenar, de uno en uno, los códigos
    //de caracter contenidos en el fichero problema4.txt
    private int codigo;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Problemas___03_12_2021__4().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto FileReader para lectura desde el fichero problema4.txt
        FileReader fichero;
        //declaración variable entera para almacenar el número de parejas de
        //caracteres 'l''a'
        int contador=0;
        //declaración constante char para representar el primer caracter de la pareja
        final char caracter1='l';
        //declaración constante char para representar el segundo caracter de la pareja
        final char caracter2='a';
        
        
        //ACCIONES
        //instanciar objeto FileReader fichero para establecer el enlace con
        //el fichero físico problema4.txt en modo lectura
        fichero=new FileReader("problema4.txt");
        //lectura primer código de caracter desde el fichero problema4.txt a través
        //del objeto fichero
        codigo=fichero.read();
        //buscar siguiente primer caracter de la pareja
        buscarPrimerCaracterPareja(fichero,caracter1);
        //BUCLE DE TRATAMIENTO DE RECORRIDO
        while (codigo!=FINAL_FICHERO) {
            //TRATAMIENTO
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();
            //verificar si el código de caracter leído se corresponde con
            //el segundo caracter de la pareja a buscar
            if ((char) codigo==caracter2) {
                //incrementar contandor de parejas
                contador++;
            }
            //buscar siguiente primer caracter de la pareja
            buscarPrimerCaracterPareja(fichero,caracter1);
        }
        
        //visualizaciñon resultado
        System.out.println("EL NÚMERO DE PAREJAS "+"'"+caracter1+"''"+caracter2+"' ES: "+
                contador);

    }
    
    //método buscarPrimerCaracterPareja
    private void buscarPrimerCaracterPareja(FileReader f, char caracter) throws Exception {  
        //ACCIONES
        //bucle de búsqueda
        while ((codigo!=FINAL_FICHERO)&&(codigo!=(int)caracter)) {
            //lectura siguiente código de caracter del fichero
            codigo=f.read();
        }
    }
    
}
