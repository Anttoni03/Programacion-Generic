/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package busquedaordenacion;

import java.io.*;
import java.util.*;
public class crearFichero {

    public static void main(String[] args) {
        Random rand = new Random();
        try{
            FileOutputStream fichero=new FileOutputStream("numeros.dat");
            BufferedOutputStream buffer=new BufferedOutputStream(fichero);
            DataOutputStream datos=new DataOutputStream(buffer);
            for (int i=400;i>0;i--) datos.writeInt(rand.nextInt(500));
            datos.close();
        } catch (IOException e) {System.out.println("ERROR  " +
                e.toString());}
    }

}

