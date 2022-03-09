/*
FUNCIONALIDAD: dado una secuencia de enteros introducidos por teclado, 
visualiza y graba los enteros leidos en un fichero, de nombre enteros.dat.
La escritura de enteros se lleva  a cabo a nivel de objetos Integer utilizando
la clase base AdicionObjectOutputStream para posibilitar la adición de objetos 
en el fichero.
nota: para ello, la clase Integer está serializada.

autor: Juan Montes de Oca
*/
package claseteorica__08_03_2022;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class uso_clase_ObjectOutputStream_1_v2 {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new uso_clase_ObjectOutputStream_1_v2().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración variable entera
        int numero; 
        //declaración objeto AdicionObjectOutputStream
        AdicionObjectOutputStream fichero;
        //declaración variable booleana para controlar el fin del programa
        boolean fin=false;
        
        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto AdicionObjectOutputStream
            fichero=new  AdicionObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("enteros.dat",true)));
            try {
                while (!fin) {
                    //mensaje usuario solicitando introducir entero por teclado
                    System.out.print("INTRODUCIR ENTERO: ");
                    //bucle de lectura desde el teclado y escritura en fichero a nivel
                    //de objetos Palabra
                    //lectura entero desde el teclado
                    numero=LT.readInt();
                    //visualización palabra leida
                    System.out.println("ENTERO LEIDO: "+numero);
                    //escritura entero leida en el fichero a nivel de objeto Integer
                    fichero.writeObject(numero);             
                    //mensaje para continuar
                    System.out.print("CONTINUAR (s/n): ");
                    //lectura respuesta
                    char respuesta;
                    respuesta=LT.readChar();
                    if ((respuesta!='s')&&(respuesta!='S')) {
                        fin=true;
                    }       
                }                       
            }catch (IOException error) {
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
