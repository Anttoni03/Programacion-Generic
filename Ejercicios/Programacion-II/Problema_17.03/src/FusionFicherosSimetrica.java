
/*
CLASE QUE PROPORCIONA UN FICHERO EstudiantesProgramacionII_Sim.txt QUE AGLUTINA
DE FORMA SIMÉTRICA TODOS LOS OBJETOS Estudiante DE LOS FICHEROS DADOS: G01,
G02 y G03
*/

public class FusionFicherosSimetrica {
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new FusionFicherosSimetrica().metodoPrincipal();
    }
    
    //MÉTDO metodoPrincipal
    private void metodoPrincipal()
    {
        //declaración variables
        EstudianteObjetoFicherosOut ficheroEscritura = new EstudianteObjetoFicherosOut("EstudiantesProgramacionII_Sim.dat");
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
        
        //lectura de n ficheros y escritura de su contenido simétricamente
        while (algunoNoEsCentinela(estudiantes))
        {
            menor = Estudiante.estudianteConMenorNif(estudiantes);
            ficheroEscritura.escritura(estudiantes[menor]);
            
            estudiantes[menor] = new Estudiante();
            estudiantes[menor] = ficherosLectura[menor].lectura();
            
        }
        
        //cierre de ficheros
        for (int i = 0; i < ficherosLectura.length; i++)
        {
            ficherosLectura[i].cierre();
        }
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
