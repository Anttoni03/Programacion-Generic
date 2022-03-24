package EjerciciosEstudiantes;


import General.LT;


/*
CLASE PARA DIVIDIR OBJETOS Estudiante SERIALIZADOS EN DIFERENTES FICHEROS SEGÚN
SU ATRIBUTO GRUPO
*/
public class DivisionFicheroEstudiantesPorGrupo {
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new DivisionFicheroEstudiantesPorGrupo().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        System.out.print("Nombre del fichero a leer(sin extensión): ");
        EstudianteObjetoFicherosIn ficheroLectura = new EstudianteObjetoFicherosIn(LT.readLine()+".dat");
        
        EstudianteObjetoFicherosOut[] ficherosEscritura = new EstudianteObjetoFicherosOut[3];
        Estudiante estudiante = new Estudiante();
        
        System.out.println("");
        
        for (int i = 0; i < ficherosEscritura.length; i++)
        {
            System.out.print("Nombre del fichero " + (i+1) + " a dividir los estudiantes(sin extensión): ");
            ficherosEscritura[i] = new EstudianteObjetoFicherosOut(LT.readLine()+".dat");
        }
        
        estudiante = ficheroLectura.lectura();
        while (!estudiante.esCentinela())
        {
            int grup = estudiante.getGrupo();
            switch (grup)
            {
                case 1:
                    ficherosEscritura[0].escritura(estudiante);
                    break;
                case 2:
                    ficherosEscritura[1].escritura(estudiante);
                    break;
                case 3:
                    ficherosEscritura[2].escritura(estudiante);
                    break;
            }
            
            estudiante = ficheroLectura.lectura();
        }
        
        //cierre de ficheros
        ficheroLectura.cierre();
        for (int i = 0; i < ficherosEscritura.length; i++)
        {
            ficherosEscritura[i].escritura(Estudiante.getCentinela());
            ficherosEscritura[i].cierre();
        }
        
    }
}
