
package CosasPeliculas;

import General.LT;


public class GrabarPeliculasFichero {
    public static void main(String[] args){
        new GrabarPeliculasFichero().metodoPrincipal();
    }
    private void metodoPrincipal(){
        FicheroObjetosPeliculaOut fichero = new FicheroObjetosPeliculaOut("peliculas.dat");
        
        
        do{
            Pelicula pelicula = new Pelicula();
            pelicula.lectura();
            fichero.escritura(pelicula);
            System.out.print("Continuar la lectura de peliculas(s/n)?: ");
        } while (LT.readChar() == 's');
        
        fichero.escritura(Pelicula.getCentinela());
        fichero.cierre();
    }
}
