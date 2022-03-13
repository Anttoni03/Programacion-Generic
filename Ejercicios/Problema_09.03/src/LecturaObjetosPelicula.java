

public class LecturaObjetosPelicula {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new LecturaObjetosPelicula().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto Palabra
        Pelicula pelicula; 
        //declaración objeto FicheroObjetosPalabraIn
        PeliculaObjetoFicherosIn fichero;
        
        //ACCIONES
        //establecimiento enlace con fichero instanciación objeto FicheroObjetosPalabraIn
        fichero=new PeliculaObjetoFicherosIn("peliculas.dat");
        //lectura primera palabra desde el fichero
        pelicula=fichero.lectura();
        //bucle de lectura desde el fichero y visualización a nivel
        //de objetos Palabra
        while (pelicula!=null) {
            //visualización palabra leida desde el fichero
            System.out.println(pelicula.toString());
            //lectura siguiente palabra desde el fichero
            pelicula=fichero.lectura();       
        }                
        //cierre del enlace fichero
        fichero.cierre();
    }
}
