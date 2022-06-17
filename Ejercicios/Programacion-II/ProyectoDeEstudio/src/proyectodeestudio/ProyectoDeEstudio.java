/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodeestudio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;


public class ProyectoDeEstudio{

    Exception nuevaExc;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ProyectoDeEstudio().cosa();
    }
    
    private void cosa()
    {
        int numerin;
        do {
            numerin = menu();
            switch (numerin){
                case 1: iniciarPoblacion(); break;
                case 2: iniciarRegistro(); break;
                case 3: actualizarRegistro(); break;
            }
            
        } while (numerin != 0);
        
        
        
        
    }
    
    
    private int menu()
    {
        System.out.print("Fitxers Infecció\n"
                + "\t1.Inicialitza fitxer població\n"
                + "\t2.Inicialitza fitxer registre\n"
                + "\t3.Actualitza dades registre amb les de poblacio\n"
                + "\t0.Sortir\n"
                + "\n"
                + "\n"
                + "\tInserir opció: ");
        
        return LT.lecturaEntero();
    }
    
    private void iniciarPoblacion()
    {
        File f = new File("Poblacio.dat");
        if (f.exists()) f.delete();
        
        PoblacioEscriptura fPoblacio = new PoblacioEscriptura("Poblacio.dat");
        try{
            BufferedReader fNoms = new BufferedReader(new FileReader("LlistaNoms.txt"));
                        
            int n = new Random().nextInt(20)+1;
            System.out.println("N -> "+n );
            for (int i = 0; i < n; i++){
                Poblacio p = new Poblacio();
                String nom = fNoms.readLine();
                p.aleatori(nom);
                fPoblacio.escriptura(p);
                System.out.println(p);
            }
            fNoms.close();
        } catch (Exception e) {}
        fPoblacio.cierre();
    }
    
    private void iniciarRegistro()
    {
        File f = new File("Registres.dat");
        if (f.exists()) f.delete();
        
        RegistreInOut fRegistre = new RegistreInOut("Registres.dat");
        
        for (int i = 0; i < 5; i++){
            Registre r = new Registre();
            fRegistre.escriptura(r);
            System.out.println(r);
        }
        
        fRegistre.cierre();
    }
    
    private void actualizarRegistro(){
        //File f = new File("Registres.dat");
        //if (f.exists()) f.delete();
        
        RegistreInOut fRegistre = new RegistreInOut("Registres.dat");
        PoblacioLectura fPoblacio = new PoblacioLectura("Poblacio.dat");
        
        for (int i = 0; i < 20; i++){
            Registre r = new Registre();
            
            Poblacio pAux;
            do
            {
                pAux = fPoblacio.lectura();
                if (pAux.getCodi() == i) r.actualitzar(pAux);
                
            } while (!pAux.esCentinela());
            
            System.out.println(r);
        }
        
        fRegistre.cierre();
        fPoblacio.cierre();
    }
}
