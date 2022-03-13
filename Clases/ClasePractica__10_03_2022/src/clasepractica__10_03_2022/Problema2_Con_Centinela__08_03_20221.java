/*
Implementar un programa que posibilite la lectura, desde el teclado, de todas las
películas que el usuario desee, grabándolas en un fichero de nombre, PeliculaConCentinela.dat, a
nivel de objetos PeliculaConCentinela.Si el fichero ya existía su contenido será eliminado.
 */
package clasepractica__10_03_2022;

public class Problema2_Con_Centinela__08_03_20221 {
    //método main
    public static void main(String [] argumentos) {
        new Problema2_Con_Centinela__08_03_20221().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto PeliculaConCentinela para almacenar, de uno en uno, los objetos
        //Pelicula a leer desde el teclado
        PeliculaConCentinela pelicula;
        //declaración objeto PeliculaConCentinelaObjetoFicherosOut para posibilitar la
        //escritura de objetos PeliculaConCentinela en un fichero
        PeliculaConCentinelaObjetoFicherosOut fichero;
        
        //ACCIONES
        //instanciación objeto PeliculaObjetoFicherosOutAdd fichero para establecer
        //el enlace con el fichero físico PeliculaConCentinela.dat a nivel de escritura
        //de objetos PeliculaConCentinela
        fichero=new PeliculaConCentinelaObjetoFicherosOut("PeliculaConCentinela.dat");
        //bucle de lectura y grabación de objetos PeliculaConCentinela 
        for (boolean fin=false;!fin;) {
            //instanciación objeto Pelicula
            pelicula=new PeliculaConCentinela();
            //lectura objeto PeliculaConCentinela desde el teclado
            pelicula.lectura();
            //grabación objeto PeliculaConCentinela leído en el fichero
            fichero.escritura(pelicula);
            //mensaje usuario para continuar
            System.out.print("<> CONTINUAR (s/n): ");
            fin=(LT.readChar()!='s');
        }
        //grabación del objeto PeliculaConCentinela CENTINELA al final del fichero
        fichero.escritura(PeliculaConCentinela.getCentinela());
        //cierre del enlace con el fichero
        fichero.cerrarEnlaceFichero();
    }
    
}
