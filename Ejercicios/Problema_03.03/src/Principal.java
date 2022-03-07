/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Principal {
    
    private Pelicula[] peliculas = new Pelicula[3];
    private PeliculaLectura ficheroLectura;
    private PeliculaEscritura ficheroEscritura;
    
    public static void main(String[] args)
    {
        new Principal().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        System.out.print("Nombre del fichero a escribir: ");
        ficheroEscritura = new PeliculaEscritura(LT.readLine(), true);
        System.out.print("Nombre del fichero a leer: ");
        ficheroLectura = new PeliculaLectura(LT.readLine());
        
        for (int i = 0; i < peliculas.length; i++)
        {
            ficheroEscritura.escrituraSeparador1();
            
            peliculas[i] = new Pelicula();
            System.out.println("\n\n\n\n\n\n");
            System.out.println("Película " + (i+1));
            System.out.print("Título: ");
            peliculas[i].setTitulo(LT.readLine());
            System.out.print("Director: ");
            peliculas[i].setDirector(LT.readLine());
            System.out.print("Año de estreno: ");
            peliculas[i].setEstreno(LT.readInt());
            
            ficheroEscritura.escritura(peliculas[i]);
            ficheroEscritura.escrituraSeparador2();
            
        }
        
        System.out.println("\n\n\n\n");
        
        while (ficheroLectura.hayInformacion())
        {
            System.out.print("Título: ");
            System.out.println(ficheroLectura.lecturaTitulo());
            if (ficheroLectura.hayInformacion())
            {
                System.out.print("Director: ");
                System.out.println(ficheroLectura.lecturaDirector());
            }
            if (ficheroLectura.hayInformacion())
            {
                System.out.print("Año de estreno: ");
                System.out.println(ficheroLectura.lecturaEstreno());
            }
            System.out.println("");
        }
        
        ficheroEscritura.cerrarEnlace();
        ficheroLectura.cerrarEnlace();
    }
}
