/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodeestudio;

import java.io.RandomAccessFile;

/**
 *
 * @author tonif
 */
public class RegistreInOut {
    private RandomAccessFile f;

    public RegistreInOut(String c){
        try{
            f = new RandomAccessFile(c, "rw");
        }catch (Exception e) { System.err.println("Error1"); }
    }

    public void escriptura(Registre r){
        try{
            f.seek(f.length());
            f.writeInt(r.getQuantitatSans());
            f.writeInt(r.getQuantitatInfectats());
            f.writeInt(r.getQuantitatCurats());
            f.writeInt(r.getQuantitatDifunts());
        } catch (Exception e) { System.err.println("Error2");}
    }

    public void escriptura(Registre r, int pos){
        try{
            f.seek(pos * Registre.getLongitud());
            f.writeInt(r.getQuantitatSans());
            f.writeInt(r.getQuantitatInfectats());
            f.writeInt(r.getQuantitatCurats());
            f.writeInt(r.getQuantitatDifunts());
        } catch (Exception e) { System.err.println("Error3");}
    }

    public Registre lectura(){
        try{
            int[] dades = new int[4];
            for (int i = 0; i < dades.length; i++){
                dades[i] = f.readInt();
            }
            return new Registre(dades);
        } catch (Exception e) { System.err.println("Error4"); }
        return null;
    }

    public Registre lectura(int pos){
        try{
            int[] dades = new int[4];
            long pointer = f.getFilePointer();
            f.seek(pos*Registre.getLongitud());
            for (int i = 0; i < dades.length; i++){
                dades[i] = f.readInt();
            }
            f.seek(pointer);
            return new Registre(dades);
        } catch (Exception e) { System.err.println("Error5"); }
        return null;
    }

    public void cierre(){
        try{
            f.close();
        } catch (Exception e) { System.err.println("Error6"); }
    }
}
