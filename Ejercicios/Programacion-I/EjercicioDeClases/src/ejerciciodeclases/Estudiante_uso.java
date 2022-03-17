package ejerciciodeclases;

public class Estudiante_uso {
    public static void main(String[] args) throws Exception
    {
        new Estudiante_uso().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Estudiante est = new Estudiante("Antonio", "12345678S");
        
        est.asignarCalificaciones();
        est.calcularAprobados();
        Estudiante.asignarDirector("Cardona");
        System.out.println(est.toString());
    }
    
}
