package EjerciciosEstudiantes;
import General.LT;

/*
CLASE Estudiante
 */



//clase serializada para poder llevar a cabo la gestión de objetos en
//ficheros a través del flujo de datos con ObjectInputStream y ObjectOutputStream
public class Estudiante implements java.io.Serializable {
    // ATRIBUTOS
     private int nif;
     private String nombre;
     private String estudios;
     private int grupo;
     private String asignatura;
     private static final Estudiante CENTINELA=new Estudiante(Integer.MAX_VALUE);
     
     
    // MÉTODOS CONSTRUCTORES
    public Estudiante()
    {
        
    }
    
    public Estudiante(int nif) {
        this.nif=nif;
    }
    
    public Estudiante(int nif, String nombre, String estudios, int grupo, String asignatura) {
        this.nif=nif;
        this.nombre=nombre;
        this.estudios = estudios;
        this.grupo = grupo;
        this.asignatura = asignatura;
    }
   
    //MÉTODOS FUNCIONALES
    //método que devuelve el objeto Estudiante centinela
    public static Estudiante getCentinela() {
        return CENTINELA;
    }
    
    //método que verifica si un objeto Estudiante es centinela o no
    public boolean esCentinela() {
        return nif==CENTINELA.nif;
    }
      
    //lectura de objeto Estudiante desde el teclado. 
    public void lectura() {
        
        try{
            System.out.print("NIF: ");
            nif=LT.readInt();
            System.out.print("NOMBRE DEL ESTUDIANTE: ");
            nombre=LT.readLine();
            System.out.print("ESTUDIOS DEL ESTUDIANTE: ");
            estudios = LT.readLine();
            System.out.print("GRUPO DEL ESTUDIANTE: ");
            grupo = LT.readInt();
            System.out.print("ASIGNATURA DEL ESTUDIANTE: ");
            asignatura = LT.readLine();
        }catch(NullPointerException e)
        {
            System.err.println("ERROR " + e.toString());
        }
    }   

    
    //conversión a String de un objeto Estudiante con fines de visualización
    @Override
    public String toString() {
        return "NIF: " + nif + " - NOMBRE: " + nombre + " - ESTUDIOS: " + estudios +
                " - GRUPO: " + grupo + " - ASIGNATURA: " + asignatura;
    } 
    
    //métodos gets
    public int getNif() {
        return nif;
    }    
    public String getNombre() {
        return nombre;
    }
    public int getGrupo() {
        return grupo;
    }
    
    //métodos sets
    public void setNif(int ni) {
        nif=ni;
    }    
    public void setNombre(String nom) {
        nombre=nom;
    }   
   
    public static int estudianteConMenorNif(Estudiante[] est)
    {
        int menor = 0;
        
        for (int i = 1; i < est.length; i++)
        {
            menor = (est[i].getNif() < est[menor].getNif()) ? i : menor;
        }
        
        return menor;
    }
}


