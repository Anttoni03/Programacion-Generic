package claseteoria__15_03_2022;

/*
AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA LLEVAR A CABO LA GESTIÓN 
DE FICHEROS DE OBJETOS Palabra A NIVEL DE ESCRITURA
autor: Juan Montes de Oca
*/

import java.io.*;

public class ClienteObjetoFicherosOut {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos Cliente
    private ObjectOutputStream fichero=null;
    
    //MÉTODO CONSTRUCTOR
    public ClienteObjetoFicherosOut(String nombreFichero) { 
       try {
            //instanciación objeto ObjectOutputStream con el fichero dado
            //para posibilitar la escritura de objetos Cliente
            fichero=new ObjectOutputStream(new BufferedOutputStream(
                                new FileOutputStream(nombreFichero)));      
       }catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       } 
   }     

    //MÉTODOS FUNCIONALES
    
    //MÉTODO escritura LLEVA A CABO LA ESCRITURA DE UN OBJETO Palabra EN EL FICHERO
    //ENLAZADO CON EL OBJETO ClienteObjetoFicherosOut
    public void escritura(Cliente cliente) {
        try {
            //escritura objeto Palabra dado
            fichero.writeObject(cliente);
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }      
    }
     
    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() {
        try {
            //verificar si el enlace con el fichero no es null
            if (fichero!=null) {
                    fichero.close();        
            }
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        } 
    }
}
   

