/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodeestudio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author tonif
 */
public class PoblacioLectura {
    private ObjectInputStream f;

public PoblacioLectura(String c){
    try{
        f = new ObjectInputStream(new BufferedInputStream(new FileInputStream(c)));
    } catch (Exception e){ System.err.println("Error10");}
}

public Poblacio lectura(){
    Poblacio p = new Poblacio();
    try{
        p = (Poblacio) f.readObject();
        return p;
    } catch (Exception e) { System.err.println(e.getMessage()); }
    return Poblacio.getCentinela();
}

public void cierre(){
    try{
        f.close();
    } catch (Exception e) { System.err.println("Error12"); }
}
}
