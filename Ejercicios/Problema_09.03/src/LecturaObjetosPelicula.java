

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
        try {
            //establecimiento enlace con fichero instanciación objeto FicheroObjetosPalabraIn
            fichero=new PeliculaObjetoFicherosIn("peliculas.dat");
            try {
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
            }catch (Exception error) {
                System.out.println("ERROR: "+error.toString());
            }finally {
                //cierre del enlace fichero
                    try {
                    fichero.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR CIERRE FICHERO" + error.toString());          
                }
            }
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
}
