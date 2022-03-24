
package CosasPeliculas;

public class DivisionPeliculas {
    public static void main(String[] args)
    {
        new DivisionPeliculas().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        FicheroObjetosPeliculaIn ficheroLectura = new FicheroObjetosPeliculaIn("peliculas.dat");
        Pelicula pelicula = new Pelicula();
        Genero[] generos = Genero.values();
        
        FicheroObjetosPeliculaOut[] ficherosEscritura = new FicheroObjetosPeliculaOut[generos.length];
        
        for (int i = 0; i < ficherosEscritura.length; i++)
        {
            ficherosEscritura[i] = new FicheroObjetosPeliculaOut(generos[i].name() +".dat");
        }
        
        
        pelicula = ficheroLectura.lectura();
        while (!pelicula.esCentinela())
        {
            int indiceFichero = Pelicula.getIndiceGenero(pelicula.getGenero());
            ficherosEscritura[indiceFichero].escritura(pelicula);
            pelicula = ficheroLectura.lectura();
        }
        
        for (int i = 0; i < ficherosEscritura.length; i++)
        {
            ficherosEscritura[i].escritura(Pelicula.getCentinela());
            ficherosEscritura[i].cierre();
        }
        ficheroLectura.cierre();
    }
    
    
}
