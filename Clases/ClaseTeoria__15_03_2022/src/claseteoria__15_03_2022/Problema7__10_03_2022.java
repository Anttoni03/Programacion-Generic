/*
7.	Realizar un programa que posibilite grabar en un fichero, de nombre 
clientes_edad_<edad>.dat, todos los objetos Clientes del fichero clientes.dat 
que tengan la edad intrdocida por teclado a petición del programa.
Por ejemplo, si el usuario introduce la edad 18 el fichero deberá llamarse 
clientes_edad_18.dat.

 */
package claseteoria__15_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

        
     
public class Problema7__10_03_2022 {
    //método main
    public static void main(String [] argumentos) {
        new Problema7__10_03_2022().metodoPrincipal();
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
        ClienteObjetoFicherosIn fichero1;      
        //declaración objeto ClienteObjetoFicherosOut para posibilitar la
        //lectura de objetos Cliente desde el fichero 
        ClienteObjetoFicherosOut fichero2;    
        //declaración variable int para almacenar la edad introducida por
        //el usuario
        int edad;
        
        //ACCIONES
        try {
            //mensaje usuario para introducir la edad a buscar
            System.out.print("INTRODUCIR EDAD DE CLIENTE: ");
            //lectura edad
            edad=Integer.parseInt(teclado.readLine());
            //instanciación objeto ClienteObjetoFicherosIn fichero1 para establecer
            //el enlace con el fichero físico clientes.dat a nivel de lectura
            //de objetos Cliente
            fichero1=new ClienteObjetoFicherosIn("clientes.dat");  
            //instanciación objeto ClienteObjetoFicherosOut fichero2 para establecer
            //el enlace con el fichero físico clientes_edad_<edad>.dat a escritura
            //de objetos Cliente
            fichero2=new ClienteObjetoFicherosOut("clientes_edad_"+edad+".dat");  
            //bucle de RECORRIDO para llevar a cabo la búsqueda, en el fichero, de
            //todos los objetos Cliente que tengan como edad la introducida por el usuario
            //para grabarlos en el fichero clientes_edad_<edad>.dat 
            for (cliente=fichero1.lectura();!cliente.esCentinela();) {
                //tratamiento objeto Cliente leido
                if (edad==cliente.getEdad()) {
                    //grabación objeto Cliente leído en el fichero clientes_edad_<edad>.dat 
                    fichero2.escritura(cliente);
                }
                //lectura siguiente objeto Cliente
                cliente=fichero1.lectura();
            }
            //grabación objeto Cliente CENTINELA en el fichero clientes_edad_<edad>.dat 
            fichero2.escritura(Cliente.getCentinela());
            //cierre de los enlaces con los ficheros
            fichero1.cierre(); 
            fichero2.cierre();
        }catch (IOException error) {
            System.err.println("ERROR LECTURA DE DATOS");
        }
    }
}
