/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodeestudio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author tonif
 */
public class PoblacioEscriptura {
    private ObjectOutputStream f;

public PoblacioEscriptura(String c){
    try{
        f = new ObjectOutputStream(new FileOutputStream(c));
	} catch (Exception e){ System.err.println("Error");}
}

public void escriptura(Poblacio p){
    try{
        f.writeObject(p);
    } catch (Exception e) { System.err.println("Error"); }
}

public void cierre(){
    try{
        f.writeObject(Poblacio.getCentinela());
        f.close();
    } catch (Exception e) { System.err.println("Error"); }
}
}
