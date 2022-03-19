/*
3.	Realizar un programa que posibilite la lectura por teclado de objetos 
Clientes y su grabación en un fichero de nombre clientes.dat. El proceso de 
lectura y grabación finalizará cuando el usuario lo indique. Se supone que los 
clientes se grabarán en orden ascendente del atributo código.
 */
package clasepractica__17_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreacionFicheroObjetosClientes {
    //método main
    public static void main(String [] argumentos) {
        new CreacionFicheroObjetosClientes().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //instanciación objeto BufferedReader para enlazar el teclado posibilitando
        //la lectura a través de dicho objeto desde el teclado
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        //declaración objeto Cliente para almacenar, de uno en uno, los objetos
        //Cliente a leer desde el teclado
        Cliente cliente;
        //declaración objeto ClienteObjetoFicherosOut para posibilitar la
        //escritura de objetos Cliente en un fichero
        ClienteObjetoFicherosOut fichero;
        //declaración String para almacenar el nombre del fichero para visualizar
        String nombreFichero;
        
        //ACCIONES
        try {
            //mensaje usuario para introducir nombre del fichero a visualizar
            System.out.print("NOMBRE DEL FICHERO A VISUALIZAR: ");
            //lectura nombre del fichero a visualizar
            nombreFichero=LT.readLine();  
            //instanciación objeto ClienteObjetoFicherosOut fichero para establecer
            //el enlace con el fichero físico clientes.dat a nivel de escritura
            //de objetos Cliente
            fichero=new ClienteObjetoFicherosOut(nombreFichero);
            //bucle de lectura y grabación de objetos Cliente 
            for (boolean fin=false;!fin;) {
                //instanciación objeto Cliente
                cliente=new Cliente();
                //lectura objeto Cliente desde el teclado
                cliente.lectura();
                //grabación objeto Cliente leído en el fichero
                fichero.escritura(cliente);
                //mensaje usuario para continuar
                System.out.print("<> CONTINUAR (s/n): ");
                fin=!(teclado.readLine().charAt(0)=='s');
            }
            //grabación del objeto Cliente CENTINELA al final del fichero
            fichero.escritura(Cliente.getCentinela());
            //cierre del enlace con el fichero
            fichero.cierre();                
        }catch (IOException error) {
            System.out.println("ERROR LECTURA DATOS");
        }
        
    }
    
}
