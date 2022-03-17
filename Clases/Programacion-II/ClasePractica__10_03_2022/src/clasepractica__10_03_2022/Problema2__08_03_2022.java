/*
Implementar un programa que posibilite la lectura, desde el teclado, de todas las
películas que el usuario desee, grabándolas en un fichero de nombre, películas.dat, a
nivel de objetos Pelicula. Realizarlo posibilitando el poder añadir objetos películas en
un fichero ya existente.
 */
package clasepractica__10_03_2022;

public class Problema2__08_03_2022 {
    //método main
    public static void main(String [] argumentos) {
        new Problema2__08_03_2022().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto Pelicula para almacenar, de uno en uno, los objetos
        //Pelicula a leer desde el teclado
        Pelicula pelicula;
        //declaración objeto PeliculaObjetoFicherosOutAdd para posibilitar la
        //escritura de objetos Pelicula en un fichero preservando su contenido
        PeliculaObjetoFicherosOutAdd fichero;
        
        //ACCIONES
        //instanciación objeto PeliculaObjetoFicherosOutAdd fichero para establecer
        //el enlace con el fichero físico peliculas.dat a nivel de escritura
        //de objetos Pelicula
        fichero=new PeliculaObjetoFicherosOutAdd("peliculas.dat");
        //bucle de lectura y grabación de objetos Pelicula 
        for (boolean fin=false;!fin;) {
            //instanciación objeto Pelicula
            pelicula=new Pelicula();
            //lectura objeto Pelicula desde el teclado
            pelicula.lectura();
            //grabación objeto Pelicula leído en el fichero
            fichero.escritura(pelicula);
            //mensaje usuario para continuar
            System.out.print("<> CONTINUAR (s/n): ");
            fin=(LT.readChar()!='s');
        }
        //cierre del enlace con el fichero
        fichero.cerrarEnlaceFichero();
    }
    
}
