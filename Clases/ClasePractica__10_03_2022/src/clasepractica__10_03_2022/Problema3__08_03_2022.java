/*
Implementar un programa que lleve a cabo la lectura, a nivel de objetos, de las
películas contenidas en el fichero películas.dat visualizándolas en pantalla. 
 */
package clasepractica__10_03_2022;

public class Problema3__08_03_2022 {
    //método main
    public static void main(String [] argumentos) {
        new Problema3__08_03_2022().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES  
        //declaración objeto Pelicula para almacenar, de uno en uno, los objetos
        //Pelicula leídos desde el fichero
        Pelicula pelicula;
        //declaración objeto PeliculaObjetoFicherosIn para posibilitar la
        //lectura de objetos Pelicula desde el fichero 
        PeliculaObjetoFicherosIn fichero;        
        
        //ACCIONES
        //instanciación objeto PeliculaObjetoFicherosIn fichero para establecer
        //el enlace con el fichero físico peliculas.dat a nivel de lectura
        //de objetos Pelicula
        fichero=new PeliculaObjetoFicherosIn("peliculas.dat");  
        //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
        //los objetos Peliculas contenidos en el fichero
        for (pelicula=fichero.lectura();pelicula!=null;) {
            //visualización objeto Pelicula leido
            System.out.println(pelicula.toString());
            //lectura siguiente objeto Pelicula
            pelicula=fichero.lectura();
        }
        //cierre del enlace con el fichero
        fichero.cerrarEnlaceFichero();
    }
}
