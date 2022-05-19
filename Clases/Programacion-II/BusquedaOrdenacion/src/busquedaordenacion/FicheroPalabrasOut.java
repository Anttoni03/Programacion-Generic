/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaordenacion;

import java.io.*;

public class FicheroPalabrasOut {
    private FileWriter objetoOut =null;
    private static final char ESPACIO=' ';

    
   public FicheroPalabrasOut(String nom) throws Exception {
       objetoOut = new FileWriter(nom);
    }
    
    public void escritura(Palabra pal) throws Exception {
        objetoOut.write(pal.toString()+" ");
    }
    
    public void cierre() throws Exception {
        objetoOut.close();
    }
    
}
