package clasepractica__17_03_2022;

/*
AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA LLEVAR A CABO LA GESTIÓN 
DE FICHEROS DE OBJETOS Cliente A NIVEL DE LECTURA
autor: Juan Montes de Oca
*/

import java.io.*;

public class ClienteObjetoFicherosIn {
    //ATRIBUTOS
    //declaración objeto ObjectInputStream para posibilitar la lectura en ficheros
    //a nivel de objetos
    private ObjectInputStream fichero=null;

     
    //MÉTODO CONSTRUCTOR   
    public ClienteObjetoFicherosIn(String nombreFichero) {
       try {
           //instanciación objeto ObjectInputStream con el fichero dado
           //para posibilitar la lectura de objetos de dicho fichero 
           fichero = new ObjectInputStream(new BufferedInputStream
                            (new FileInputStream(nombreFichero)));
       }catch (FileNotFoundException error) {
           System.out.println("ERROR: "+error.toString());
       }
       catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       }   
    }
    
    //MÉTODOS FUNCIONALES
    
    //MÉTODO lectura LLEVA A CABO LA LECTURA DE UN OBJETO Cliente EN EL FICHERO
    //ENLAZADO CON EL OBJETO ClienteObjetoFicherosIn   
    public Cliente lectura() { 
        //declaración objeto Palabra para alamcenar el objeto Cliente a leer desde el fichero
        Cliente cliente=new Cliente();
        try {
            //lectura objeto Palabra leido desde el fichero
            cliente= (Cliente) fichero.readObject();      
        }catch (EOFException error) { 
            //devolución valor null porque hemos llegado al final del fichero
            return null;
        }catch (ClassNotFoundException | IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        }
        //devolución objeto Palabra leido desde el fichero
        return cliente;
    }

    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() {
        try {
            if (fichero!=null) {
                fichero.close();
            }            
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        }     
    }
}

