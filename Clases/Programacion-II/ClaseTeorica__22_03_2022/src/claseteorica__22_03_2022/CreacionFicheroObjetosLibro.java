/*
Lleva a cabo la lectura por teclado de objetos 
Libro y su grabación en un fichero de nombre libros.dat. 
El proceso de lectura y grabación finalizará cuando el usuario lo indique. Se supone que los 
clientes se grabarán en orden ascendente del atributo código.
 */
package claseteorica__22_03_2022;


public class CreacionFicheroObjetosLibro {
    //método main
    public static void main(String [] argumentos) {
        new CreacionFicheroObjetosLibro().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto Libro para almacenar, de uno en uno, los objetos
        //Libro a leer desde el teclado
        Libro libro;
        //declaración objeto FicheroObjetosLibroOut para posibilitar la
        //escritura de objetos Libro en un fichero
        FicheroObjetosLibroOut fichero;
        //declaración String para almacenar el nombre del fichero a crear
        String nombreFichero;
        
        //ACCIONES
        //mensaje para introducir nomnbre del fichero a crear
        System.out.print("NOMRE DEL FICHERO DE LIBROS A CREAR: ");
        //lectura nombre del fichero
        nombreFichero=LT.readLine();
        //instanciación objeto FicheroObjetosLibroOut fichero para establecer
        //el enlace con el fichero físico a nivel de escritura
        //de objetos Cliente
        fichero=new FicheroObjetosLibroOut(nombreFichero);
        //bucle de lectura y grabación de objetos Cliente 
        for (boolean fin=false;!fin;) {
            //instanciación objeto Cliente
            libro=new Libro();
            //lectura objeto Cliente desde el teclado
            libro.lectura();
            //grabación objeto Cliente leído en el fichero
            fichero.escritura(libro);
            //mensaje usuario para continuar
            System.out.print("<> CONTINUAR (s/n): ");
            fin=!(LT.readChar()=='s');
        }
        //grabación del objeto Cliente CENTINELA al final del fichero
        fichero.escritura(Libro.getCentinela());
        //cierre del enlace con el fichero
        fichero.cierre();            
    }
    
}
