/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.*;
public class Borrar {
    public static void main(String[] args) throws Exception{
        new Borrar().metPrinc();
    }
    
    private void metPrinc() throws Exception
    {
        BufferedOutputStream f = new BufferedOutputStream(new FileOutputStream("borrar.txt"));
        
        //1.000.000 -> 976 kb
        //10.000.000 -> 9'76 mb
        //55.000.000 -> 97'656 mb
        //102.400.000 -> 99'992 mb
        for (int i = 0; i < 102400000; i++) {
            f.write('a');
        }
    }
}
