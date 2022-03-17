/*
FUNCIONALIDAD: dado un fichero de enteros, de nombre enteros.dat,
lleva a cabo la visualización de las enteros contenidas en él.
La lectura de enteros se lleva  a cabo utilizando
la clase ObjectInputStream.

autor: Juan Montes de Oca
*/
package claseteorica__08_03_2022;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class uso_clase_ObjectInputStream_1 {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new uso_clase_ObjectInputStream_1().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración variable entera
        int numero; 
        //declaración objeto ObjectInputStream
        ObjectInputStream fichero;
        
        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto ObjectInputStream
            fichero = new ObjectInputStream(new BufferedInputStream
                                  (new FileInputStream("enteros.dat")));
            try {
                //lectura primer entero desde el fichero
                numero=(int) fichero.readObject();
                //bucle de lectura desde el fichero y visualización a nivel
                //de objetos Palabra
                while (true) {
                    //visualización entero resultante del casting Integer
                    System.out.println(numero);
                    //lectura siguiente entero desde el fichero
                    numero=(int) fichero.readObject();  
                }                
            }catch (EOFException error) {
                //NO HACEMOS NADA - SIGNIFICARÁ QUE EL FICHERO HA SIDO LEIDO
                //COMPLETAMENTE
            }catch (IOException | ClassNotFoundException error) {
                System.out.println("ERROR: "+error.toString());
            }finally {
                //cierre del enlace fichero
                try {
                    fichero.close();
                } catch (IOException error) {
                    System.out.println("ERROR CIERRE FICHERO" + error.toString());          
                }
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
}
