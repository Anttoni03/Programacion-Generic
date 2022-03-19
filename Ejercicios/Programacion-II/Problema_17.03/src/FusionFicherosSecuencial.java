
/*
CLASE QUE PROPORCIONA UN FICHERO EstudiantesProgramacionII_Sec.txt QUE AGLUTINA
DE FORMA SECUENCIAL TODOS LOS OBJETOS Estudiante DE LOS FICHEROS DADOS: G01,
G02 y G03
*/

public class FusionFicherosSecuencial {
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new FusionFicherosSecuencial().metodoPrincipal();
    }
    
    //MÉTDO metodoPrincipal
    private void metodoPrincipal()
    {
        //declaración variables
        EstudianteObjetoFicherosOut ficheroEscritura = new EstudianteObjetoFicherosOut("EstudiantesProgramacionII_Sec.dat");
        EstudianteObjetoFicherosIn[] ficherosLectura = new EstudianteObjetoFicherosIn[3];
        Estudiante estudiante = new Estudiante();
        
        //inicialización n ficheros de lectura
        for (int i = 0; i < ficherosLectura.length; i++)
        {
            System.out.print("Nombre del fichero " + (i+1) + " a leer(sin extensión): ");
            ficherosLectura[i] = new EstudianteObjetoFicherosIn(LT.readLine()+".dat");
        }
        
        System.out.println("");
        
        //lectura de n ficheros y escritura de su contenido secuencialmente
        for (int i = 0; i < ficherosLectura.length; i++)
        {
            estudiante = ficherosLectura[i].lectura();
            while (!estudiante.esCentinela())
            {
                ficheroEscritura.escritura(estudiante);
                estudiante = new Estudiante();
                estudiante = ficherosLectura[i].lectura();
            }
            
            //cierre de ficheros
            ficherosLectura[i].cierre();
        }
        
        ficheroEscritura.escritura(Estudiante.getCentinela());
        ficheroEscritura.cierre();
    }
}
