package EjerciciosEstudiantes;
import General.LT;

/*
CLASE QUE PROPORCIONA UN FICHERO EstudiantesProgramacionII_Sim.txt QUE AGLUTINA
DE FORMA ASIMÉTRICA TODOS LOS OBJETOS Estudiante DE LOS FICHEROS DADOS: G01,
G02 y G03
*/

public class FusionFicherosAsimetrica {
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new FusionFicherosAsimetrica().metodoPrincipal();
    }
    
    //MÉTDO metodoPrincipal
    private void metodoPrincipal()
    {
        //declaración variables
        EstudianteObjetoFicherosOut ficheroEscritura = new EstudianteObjetoFicherosOut("EstudiantesProgramacionII_Asim.dat");
        EstudianteObjetoFicherosIn[] ficherosLectura = new EstudianteObjetoFicherosIn[3];
        Estudiante estudiantes[] = new Estudiante[3];
        int menor;
        
        //inicialización n ficheros de lectura
        for (int i = 0; i < ficherosLectura.length; i++)
        {
            estudiantes[i] = new Estudiante();
            System.out.print("Nombre del fichero " + (i+1) + " a leer(sin extensión): ");
            ficherosLectura[i] = new EstudianteObjetoFicherosIn(LT.readLine()+".dat");
            estudiantes[i] = ficherosLectura[i].lectura();
        }
        
        System.out.println("");
        
        //lectura de n ficheros y escritura de su contenido asimétricamente
        for (int i = 0; i < ficherosLectura.length; i++)
        {
            while (!estudiantes[i].esCentinela())
            {
                menor = Estudiante.estudianteConMenorNif(estudiantes);
                while (menor > i)
                {
                    ficheroEscritura.escritura(estudiantes[menor]);
                    estudiantes[menor] = ficherosLectura[menor].lectura();
                    menor = Estudiante.estudianteConMenorNif(estudiantes);
                }
                
                ficheroEscritura.escritura(estudiantes[i]);
                estudiantes[i] = ficherosLectura[i].lectura();
            }
            ficherosLectura[i].cierre();
        }
        
        //cierre de ficheros
        ficheroEscritura.escritura(Estudiante.getCentinela());
        ficheroEscritura.cierre();
    }
    
    //MÉTODO algunoNoEsCentinela QUE COMPRUEBA SI ALGÚN ESTUDIANTE NO ES CENTINELA
    private boolean algunoNoEsCentinela(Estudiante[] est)
    {
        boolean resultado = false;
        for (int i = 0; i < est.length && !resultado; i++)
        {
            resultado = !est[i].esCentinela();
        }
        
        return resultado;
    }
}
