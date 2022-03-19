
/*
CLASE DE GRABACIÓN DE ESTUDIANTES A NIVEL DE OBJETO DE FORMA SERIALIZADA EN UN
FICHERO DE NOMBRE INTRODUCIDO POR EL USUARIO POR TECLADO
*/
public class GrabacionEstudiantes {
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new GrabacionEstudiantes().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal
    private void metodoPrincipal()
    {
        System.out.print("Nombre del fichero a grabar estudiantes(sin extensión): ");
        String rutaFichero = LT.readLine() + ".dat";
        EstudianteObjetoFicherosOut fichero = new EstudianteObjetoFicherosOut(rutaFichero);
        
        for (char b = ' ';b != 'n';System.out.print("Continuar (s/n)?: "), b = LT.readChar())
        {
            Estudiante estudiante = new Estudiante();
            estudiante.lectura();
            fichero.escritura(estudiante);
            System.out.println("");
        }
        
        fichero.escritura(Estudiante.getCentinela());
        fichero.cierre();
    }
}