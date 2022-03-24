package EjerciciosLibro;
import General.LT;

/*
CLASE DE GRABACIÓN DE ESTUDIANTES A NIVEL DE OBJETO DE FORMA SERIALIZADA EN UN
FICHERO DE NOMBRE INTRODUCIDO POR EL USUARIO POR TECLADO
*/
public class GrabacionLibros {
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new GrabacionLibros().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal
    private void metodoPrincipal()
    {
        System.out.print("Nombre del fichero a grabar libros(sin extensión): ");
        String rutaFichero = LT.readLine() + ".dat";
        FicheroObjetosLibroOut fichero = new FicheroObjetosLibroOut(rutaFichero);
        
        for (char b = ' ';b != 'n';System.out.print("Continuar (s/n)?: "), b = LT.readChar())
        {
            Libro libro = new Libro();
            libro.lectura();
            fichero.escritura(libro);
            System.out.println("");
        }
        
        fichero.escritura(Libro.getCentinela());
        fichero.cierre();
    }
}