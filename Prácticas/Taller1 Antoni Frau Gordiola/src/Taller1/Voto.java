package Taller1;

import java.io.*;
import java.util.Random;

public class Voto {
    private int posicionAlbum;
    private int puntuacion;
    
    public Voto()
    {
        posicionAlbum = 0;
        puntuacion = 0;
    }
    
    public void setPosicion(int posicionAlbum)
    {
        this.posicionAlbum = posicionAlbum;
    }
    public void setPuntuacion(int puntuacion)
    {
        this.puntuacion = puntuacion;
    }
    
    public int getPosicion()
    {
        return posicionAlbum;
    }
    public int getPuntuacion()
    {
        return puntuacion;
    }
    
    public void lecturaManual()
    {
        try{
            System.out.print("Número del disco al que quieres votar [1..100]? ");
            posicionAlbum = LT.readInt();
            if (posicionAlbum < 1 || 100 < posicionAlbum)
                throw new InsercioDadesException("Error de inserción de datos");
            System.out.print("Puntuación [1..10]: ");
            puntuacion = LT.readInt();
            if (puntuacion < 1 || 10 < puntuacion)
                throw new InsercioDadesException("Error de inserción de datos");
        } catch (InsercioDadesException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (NumberFormatException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    public void lecturaAleatoria(int puntuacion)
    {
        Random r = new Random();
        posicionAlbum = r.nextInt(100)+1;
        this.puntuacion = puntuacion;
    }
    
    public String toString()
    {
        String resultado = "[#"+posicionAlbum
                + "\t- "+puntuacion
                +"]";
        
        return resultado;
    }
}
