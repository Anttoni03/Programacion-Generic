package CosasPeliculas;

import General.LT;

enum Genero{
    ACCION,
    AUTOR,
    CIFI,
    COMEDIA,
    DRAMA,
    POLICIACA,
    TERROR
}


public class Pelicula implements java.io.Serializable {
    
    private String titulo;
    private String director;
    private int estreno;
    private Genero genero;
    private static final Pelicula CENTINELA = new Pelicula("","",-1,Genero.ACCION);
    
    public Pelicula()
    {
        
    }
    
    public Pelicula(String titulo, String director, int estreno, Genero genero)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
        this.genero = genero;
    }
    
    public void lectura()
    {
        System.out.print("Título: ");
        titulo = LT.readLine();
        System.out.print("Director: ");
        director = LT.readLine();
        System.out.print("Año de estreno: ");
        estreno = LT.readInt();
        introducirGenero();
        
    }
    
    private void introducirGenero()
    {
        int dato = 0;
        while (dato < 1 || dato > 7){
            System.out.print("Género:"
                + "\n[1] ACCIÓN"
                + "\n[2] AUTOR"
                + "\n[3] CIFI"
                + "\n[4] COMEDIA"
                + "\n[5] DRAMA"
                + "\n[6] POLICIACA"
                + "\n[7] TERROR"
                + "\n\t-----> ");
            dato = LT.readInt();
        }
        switch(dato){
            case 1:
                genero = Genero.ACCION;
                break;
            case 2:
                genero = Genero.AUTOR;
                break;
            case 3:
                genero = Genero.CIFI;
                break;
            case 4:
                genero = Genero.COMEDIA;
                break;
            case 5:
                genero = Genero.DRAMA;
                break;
            case 6:
                genero = Genero.POLICIACA;
                break;
            case 7:
                genero = Genero.TERROR;
                break;
        }
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
    public void setEstreno(int estreno)
    {
        this.estreno = estreno;
    }
    public void setGenero(Genero genero)
    {
        this.genero = genero;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    public String getDirector()
    {
        return director;
    }
    public int getEstreno()
    {
        return estreno;
    }
    public Genero getGenero()
    {
        return genero;
    }
    
    public static int getIndiceGenero(Genero genero)
    {
        Genero[] generos = Genero.values();
        
        for (int i = 0; i < generos.length; i++)
        {
            if (generos[i] == genero)
                return i;
        }
        return 0;
    }
    
    public String toString()
    {
        String resultado = "Titulo: " + titulo+
                "\tDirector: " + director+
                "\tAño de estreno: " + estreno+
                "\tGénero: " + genero;
        
        return resultado;
    }
    
    public boolean esCentinela()
    {
        return estreno == CENTINELA.estreno;
    }
    
    public static Pelicula getCentinela()
    {
        return CENTINELA;
    }
}
