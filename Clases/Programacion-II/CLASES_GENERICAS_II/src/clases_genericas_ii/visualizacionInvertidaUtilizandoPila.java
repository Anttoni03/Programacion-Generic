/*
FUNCIONALIDAD: Visualización invertida del contenido de un fichero de texto utilizando
una pila.
 */
package clases_genericas_ii;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class visualizacionInvertidaUtilizandoPila {
    public static void main(String [] argumentos) {
        new visualizacionInvertidaUtilizandoPila().metodoPrincipal();
    }
    
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración constante que representa el final de fichero
        final int FINAL_FICHERO=-1;
        //declaración pila de caracteres
        PilaConArrayList<Character> pilaCaracteres=new PilaConArrayList<Character>();
        //declaración objeto FileReader
        FileReader fichero;
        //declaración variable entera para almacenar los códigos de caracteres
        //del fichero
        int codigo;
        
        //ACCIONES
        try {
            //establecimiento enlace con fichero
            fichero=new FileReader("texto.txt");    
            try {
                //lectura primer código de caracter desde el fichero
                codigo=fichero.read();
                //bucle lectura del fichero e introducción caracteres en la pila
                while (codigo!=FINAL_FICHERO) {
                    //introducción caracter correspondiente al código leido en
                    //la pila
                    pilaCaracteres.introducir((char) codigo);
                    //lectura siguiente código de caracter desde el fichero
                    codigo=fichero.read();
                }
                //cierre del enlace del fichero
                fichero.close();
                //bucle de extracción y visualización de los caracteres 
                //contenidos en la pila
                while (!pilaCaracteres.estaVacia()) {
                    //visualización caracter extraido
                    System.out.print(pilaCaracteres.extraer());
                }
                //salto de linea
                System.out.println();
            }catch (IOException error) {
                System.out.println("ERROR: "+error.toString());
            }
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: "+error.toString());
        }

        
        
        
    }
    
}
