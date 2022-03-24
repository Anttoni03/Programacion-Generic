package EjerciciosEstudiantes;
import General.LT;


/*
CLASE DE LECTURA DE ESTUDIANTES A NIVEL DE OBJETOS DE FORMA SERIALIZADA DESDE
UN FICHERO DE NOMBRE INTRODUCIDO POR EL USUARIO USANDO LA TÉCNICA DEL CENTINELA
*/
public class LecturaEstudiantes {
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new LecturaEstudiantes().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal
    private void metodoPrincipal()
    {
        System.out.print("Nombre del fichero a leer estudiantes(sin extensión): ");
        String rutaFichero = LT.readLine() + ".dat";
        System.out.println(rutaFichero);
        EstudianteObjetoFicherosIn fichero = new EstudianteObjetoFicherosIn(rutaFichero);
        
        Estudiante estudiante;
        
        estudiante = fichero.lectura();
        while (!estudiante.esCentinela())
        {
            System.out.println(estudiante.toString());
            estudiante = fichero.lectura();
        }
        
        fichero.cierre();
    }
}