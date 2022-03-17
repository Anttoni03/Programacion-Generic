/*
FUNCIONALIDAD: dado una secuencia de enteros introducidos, de uno en uno, por teclado, 
visualiza y graba los enteros leidos en un fichero, de nombre enteros.dat.
La escritura de enteros se lleva a cabo utilizando
la clase base ObjectOutputStream.

autor: Juan Montes de Oca
*/
package claseteorica__08_03_2022;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class uso_clase_ObjectOutputStream_1_v1 {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new uso_clase_ObjectOutputStream_1_v1().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración variable entera
        int numero; 
        //declaración objeto ObjectOutputStream
        ObjectOutputStream fichero;
        //declaración variable booleana para controlar el fin del programa
        boolean fin=false;
        
        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto ObjectOutputStream
            fichero=new ObjectOutputStream(new BufferedOutputStream
                                        (new FileOutputStream("enteros.dat")));
            try {
                //bucle del programa
                while (!fin) {
                    //mensaje usuario solicitando introducir entero por teclado
                    System.out.print("INTRODUCIR ENTERO: ");
                    //lectura entero desde el teclado
                    numero=LT.readInt();
                    //visualización entero leido
                    System.out.println("ENTERO LEIDO: "+numero);
                    //escritura entero leido en el fichero a nivel de entero
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
                    fichero.close();
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
}
