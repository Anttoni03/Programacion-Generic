package Taller1;

import java.util.Random;

public class Voto {
    
    //DECLARACIÓN DE ATRIBUTOS
    //Atributo de objeto que indica la posición del álbum a votar
    private int posicionAlbum;
    //Atributo de objeto que indica la puntuación del voto
    private int puntuacion;
    
    //MÉTODOS
    //Método constructor para instanciar objetos Voto
    public Voto()
    {
        posicionAlbum = 0;
        puntuacion = 0;
    }
    
    //MÉTODOS FUNCIONALES
    //Métodos setters de los atributos de objeto
    public void setPosicion(int posicionAlbum)
    {
        this.posicionAlbum = posicionAlbum;
    }
    public void setPuntuacion(int puntuacion)
    {
        this.puntuacion = puntuacion;
    }
    
    //Métodos getters de los atributos de objeto
    public int getPosicion()
    {
        return posicionAlbum;
    }
    public int getPuntuacion()
    {
        return puntuacion;
    }
    
    
    //Método lecturaManual para aplicar los valores del voto por teclado
    public void lecturaManual() throws InsercionDatosException
    {
        System.out.print("Número del disco al que quieres votar [1..100]? ");
        posicionAlbum = LT.readInt();
        if (posicionAlbum < 1 || 100 < posicionAlbum)
            throw new InsercionDatosException("Error de inserción de datos");
        System.out.print("Puntuación [1..10]: ");
        puntuacion = LT.readInt();
        if (puntuacion < 1 || 10 < puntuacion)
            throw new InsercionDatosException("Error de inserción de datos");
    }
    
    //Método lecturaAleatoria para aplicar el valor del álbum de forma aleatoria
    public void lecturaAleatoria(int puntuacion)
    {
        Random r = new Random();
        
        posicionAlbum = r.nextInt(100)+1;
        this.puntuacion = puntuacion;
    }
    
    //Método toString para generar un String con los datos del voto
    @Override
    public String toString()
    {
        String resultado = "[#"+posicionAlbum
                + "\t- "+puntuacion
                +"]";
        
        return resultado;
    }
}
