

public class Pelicula {
    
    private char[] titulo;
    private char[] director;
    private int estreno;
    
    public Pelicula()
    {
        
    }
    
    public Pelicula(char[] titulo, char[] director, int estreno)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo = titulo.toCharArray();
    }
    public void setDirector(String director)
    {
        this.director = director.toCharArray();
    }
    public void setEstreno(int estreno)
    {
        this.estreno = estreno;
    }
    
    public char[] getTitulo()
    {
        return titulo;
    }
    public char[] getDirector()
    {
        return director;
    }
    public int getEstreno()
    {
        return estreno;
    }
    
    public String toString()
    {
        String resultado = "\tTitulo:";
        for (int i = 0; i < titulo.length; i++) {
            resultado += titulo[i];
        }
        resultado += "\n\tDirector:";
        for (int i = 0; i < director.length; i++) {
            resultado += director[i];
        }
        resultado += "\n\tAño de estreno:";
        resultado += estreno + "";
        
        return resultado;
    }
}
