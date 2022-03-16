/*
5.	Realizar un programa que posibilite la búsqueda de un objeto Cliente 
en el fichero clientes.dat. Se solicitará al usuario la introducción del código 
del objeto Cliente a buscar.
 */
package claseteoria__15_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

        
     
public class Problema5__10_03_2022 {
    //método main
    public static void main(String [] argumentos) {
        new Problema5__10_03_2022().metodoPrincipal();
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
        //declaración variable entera para almacenar el código introducido por
        //el usuario
        int codigo;
        
        //ACCIONES
        try {
            //mensaje usuario para introducir el código a buscar
            System.out.print("INTRODUCIR CÓDIGO DE CLIENTE A BUSCAR: ");
            //lectura código
            codigo=Integer.parseInt(teclado.readLine());
            //verificar si el código introducido es correcto 
            if (codigo>0) {
                //instanciación objeto ClienteObjetoFicherosIn fichero para establecer
                //el enlace con el fichero físico clientes.dat a nivel de lectura
                //de objetos Cliente
                fichero=new ClienteObjetoFicherosIn("clientes.dat");  
                //bucle de BÚSQUEDA para llevar a cabo la búsqueda, en el fichero, de
                //un objeto Cliente cuyo atributo codigo coincida con el introducido por
                //el usuario
                //NOTA: se supone que los clientes han sido grabados en el fichero en
                //orden ascendente del atributo codigo
                for (cliente=fichero.lectura();(cliente.getCodigo()<codigo)&&(!cliente.esCentinela());) {
                    //lectura siguiente objeto Cliente
                    cliente=fichero.lectura();
                }
                //verificar el resultado de la búsqueda
                if (cliente.getCodigo()==codigo) {
                    //el objeto Cliente buscado ha sido localizado y por lo tanto será
                    //visualizado
                    System.out.println("CLIENTE ENCONTRADO: \n"+cliente.toString());
                }
                else {
                    //en el fichero no se ha localizado ningún objeto cliente con el
                    //código introducido
                    System.out.println("CLIENTE NO EXISTENTE EN EL FICHERO");
                }
                //cierre del enlace con el fichero
                fichero.cierre();                      

            }
            else {
                        
                throw new CodigoNoCorrectoException(); 
            }       
        }catch (CodigoNoCorrectoException error) {
            System.err.println("ERROR CODIGO INTRODUCIDO NO CORRECTO");
        }
        catch (IOException error) {
            System.err.println("ERROR LECTURA DE DATOS");
        }
    }
    
    //declaración no predefinida CodigoNoCorrectoException que será invocada
    //cuando sea introducido un código de cliente <=0
    private class CodigoNoCorrectoException extends Exception {}
}
