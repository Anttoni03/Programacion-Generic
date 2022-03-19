/*
4.	Realizar un programa que posibilite el recorrido del fichero clientes.dat 
visualizando en pantalla los objetos Cliente contenidos en él.
 */
package clasepractica__17_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class visualizadorFicheroObjerosCliente {
    //método main
    public static void main(String [] argumentos) {
        new visualizadorFicheroObjerosCliente().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES  
        //instanciación objeto BufferedReader para enlazar el teclado posibilitando
        //la lectura a través de dicho objeto desde el teclado
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        //declaración objeto Cliente para almacenar, de uno en uno, los objetos
        //Cliente leídos desde el fichero
        Cliente cliente;
        //declaración objeto ClienteObjetoFicherosIn para posibilitar la
        //lectura de objetos Cliente desde el fichero 
        ClienteObjetoFicherosIn fichero;  
        //declaración String para almacenar el nombre del fichero a visualizar
        String nombreFichero;
        
        //ACCIONES
        try {
            //mensaje usuario para introducir nombre del fichero a visualizar
            System.out.print("NOMBRE DEL FICHERO A VISUALIZAR: ");
            //lectura nombre del fichero a visualizar
            nombreFichero=teclado.readLine();
            //instanciación objeto ClienteObjetoFicherosIn fichero para establecer
            //el enlace con el fichero físico clientes.dat a nivel de lectura
            //de objetos Cliente
            fichero=new ClienteObjetoFicherosIn(nombreFichero); 
            //
            //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
            //los objetos Cliente contenidos en el fichero
            for (cliente=fichero.lectura();!cliente.esCentinela();) {
                //visualización objeto PeliculaConCentinela leido
                System.out.println(cliente.toString());
                //lectura siguiente objeto PeliculaConCentinela
                cliente=fichero.lectura();
            }
            //cierre del enlace con el fichero
            fichero.cierre();            
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       } 

    }
}
