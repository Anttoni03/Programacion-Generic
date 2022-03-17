/*
Implementar un programa que lleve a cabo la lectura, a nivel de objetos, de las
películas contenidas en el fichero PeliculaConCentinela.dat visualizándolas en pantalla. 
 */
package clasepractica__10_03_2022;

public class Problema3_Con_Centinela__08_03_20221 {
    //método main
    public static void main(String [] argumentos) {
        new Problema3_Con_Centinela__08_03_20221().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES  
        //declaración objeto PeliculaConCentinela para almacenar, de uno en uno, los objetos
        //Pelicula leídos desde el fichero
        PeliculaConCentinela pelicula;
        //declaración objeto PeliculaConCentinelaObjetoFicherosIn para posibilitar la
        //lectura de objetos Pelicula desde el fichero 
        PeliculaConCentinelaObjetoFicherosIn fichero;        
        
        //ACCIONES
        //instanciación objeto PeliculaObjetoFicherosIn fichero para establecer
        //el enlace con el fichero físico peliculas.dat a nivel de lectura
        //de objetos PeliculaConCentinela
        fichero=new PeliculaConCentinelaObjetoFicherosIn("PeliculaConCentinela.dat");  
        //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
        //los objetos PeliculaConCentinela contenidos en el fichero
        for (pelicula=fichero.lectura();!pelicula.esCentinela();) {
            //visualización objeto PeliculaConCentinela leido
            System.out.println(pelicula.toString());
            //lectura siguiente objeto PeliculaConCentinela
            pelicula=fichero.lectura();
        }
        //cierre del enlace con el fichero
        fichero.cerrarEnlaceFichero();
    }
}
