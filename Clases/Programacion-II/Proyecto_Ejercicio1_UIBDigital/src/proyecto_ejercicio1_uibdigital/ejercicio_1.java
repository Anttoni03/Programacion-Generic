/*
Exercici 1 
Una pel·lícula es caracteritza per un títol, el nom del director i l'any 
d'estrena. 
Escriviu un programa que sigui capaç d'emmagatzemar tres registres d'aquest 
tipus dins un fitxer i després recuperar aquesta informació del fitxer per 
mostrar-la per la finestra de text. Plantegeu la solució emprant les classes 
FileWriter i FileReader y/o complementarias BufferedReader y/o BufferedWriter.

 */
package proyecto_ejercicio1_uibdigital;

public class ejercicio_1 {
    public static void main(String [] argumentos) {
        new ejercicio_1().metodoPrincipal();
    }
    
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración Strings para almacenar los valores correspondientes a los
        //atributos titulo y director de un objeto Pelicula
        String titulo, director;
        //declaración variable entera para almacenar el valor correspondiente al
        //atributo año de un objeto Pelicula
        int año;
        //declaració objeto PeliculaFicherosLectura
        PeliculaFicherosLectura fichero1;
        //declaración objeto PeliculaFicherosEscritura
        PeliculaFicherosEscritura fichero2;
        //declaración objeto Pelicula
        Pelicula pelicula;
        //declaración constante entera para representar el número de peliculas a
        //tratar
        final int NUMERO_PELICULAS=3;
        
        //ACCIONES
        //LECTURA DE PELÍCULAS POR TECLADO Y GRABACIÓN DE LAS MISMAS EN UN FICHERO
        //instanciación objeto PeliculaFicherosEscritura fichero2 para establecer
        //el enlace con el fichero físico a nivel de escritura de objetos Pelicula
        fichero2=new PeliculaFicherosEscritura("peliculas.txt");
        //bucle lectura datos de 3 peliculas, instanciación de los objetos
        //Pelicula correspondientes y grabación en el fichero de salida
        for (int indice=1;indice<=NUMERO_PELICULAS;indice++) {
            //instanciación objeto Pelicula
            pelicula=new Pelicula();
            //lectura desde el teclado del objeto Pelicula
            pelicula.lectura();
            //grabación objeto Pelicula leído en el fichero
            fichero2.escritura(pelicula);
        }
        //cierre enlace fichero2
        fichero2.cerrarEnlaceFichero();
        
        //LECTURA
        //instanciación objeto PeliculaFicherosLectura fichero1 para establecer
        //el enlace con el fichero físico a nivel de escritura de objetos Pelicula
        fichero1=new PeliculaFicherosLectura("peliculas.txt");
        //mendjae usuario de visualización peliculas contenidas en el fichero
        System.out.println("\n*********** LISTADO PELÍCULAS EN EL FICHERO ***********");
        //bucle lectura de las películas contenidas en el fichero y visualización de
        //las mismas
        while ((pelicula=fichero1.lectura())!=null) {
            //visualización pelicula leida
            System.out.println(pelicula.toString());
        }
        //cierre enlace fichero1
        fichero1.cerrarEnlaceFichero();
    }
    
}
