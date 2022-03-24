
package CosasPeliculas;

import General.LT;

public class LeerPeliculasFichero {
    public static void main(String[] args)
    {
        new LeerPeliculasFichero().metodoPrincipal();
    }
    
    private void metodoPrincipal(){
        System.out.print("Indica el nombre del fichero a escribir(sin extensión): ");
        FicheroObjetosPeliculaIn fichero = new FicheroObjetosPeliculaIn(LT.readLine()+".dat");
        Pelicula pelicula;
        
        pelicula = fichero.lectura();
        while (!pelicula.esCentinela())
        {
            System.out.println(pelicula.toString());
            pelicula = fichero.lectura();
        }
        
        fichero.cierre();
    }
}
