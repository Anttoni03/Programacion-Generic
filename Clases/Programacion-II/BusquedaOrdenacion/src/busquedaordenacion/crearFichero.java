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
            
            FileInputStream f2 = new FileInputStream("numeros.dat");
            BufferedInputStream b2 = new BufferedInputStream(f2);
            DataInputStream d2 = new DataInputStream(b2);
            while (true){
                System.out.println(d2.readInt());
            }
        } catch (IOException e) {System.out.println("ERROR  " +
                e.toString());}
    }

}

