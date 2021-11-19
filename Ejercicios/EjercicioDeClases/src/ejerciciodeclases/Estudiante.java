/*
 * FUNCIONALIDAD: clase Estudiante con algunas variables de objeto, de clase y
 * al menos un constructor, un método funcional y el método toString
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 18.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejerciciodeclases;

public class Estudiante {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //atributo de clase que representa las asignaturas totales del estudiante
    private static final int CANTIDAD_ASIGNATURAS = 10;
    //atributo de clase que indica el director del centro
    private static String director;
    //atributo de clase que indica la nota mínima para aprobar
    private static final int NOTA_MINIMA = 5;
    
    //atributo de objeto que indica el nombre del estudiante
    private String nombre;
    //atributo de objeto que representa su identificación
    private String nif;
    //atributo de objeto que indica las asignaturas matriculadas
    private String[] asignaturas = new String[CANTIDAD_ASIGNATURAS];
    //atributo de objeto que indica las notas de las asignaturas
    private int[] notas = new int[CANTIDAD_ASIGNATURAS];
    //atributo de objeto que indica la cantidad de asignaturas aprobadas
    private int asignaturasAprobadas;
    
    
    //DECLARACIÓN DE MÉTODOS DE LA CLASE
    //MÉTODOS CONSTRUCTORES
    public Estudiante(String dato1, String dato2)
    {
        nombre = dato1;
        nif = dato2;
    }
    
    
    //MÉTODOS FUNCIONALES
    //método de objeto asignarCalificaciones para asignar las calificaciones
    public void asignarCalificaciones()
    {
        for (int i = 0; i < CANTIDAD_ASIGNATURAS; i++) {
            System.out.print("Introduce la asignatura " + (i+1) + ": ");
            asignaturas[i] = LT.readLine();
        }
        
        for (int i = 0; i < CANTIDAD_ASIGNATURAS; i++) {
            System.out.print("Introduce la nota de " + asignaturas[i] + ": ");
            notas[i] = LT.readInt();
        }
    }
    
    //método de clase asignarDirector para asignar el director del centro
    public static void asignarDirector(String dato)
    {
        director = dato;
    }
    
    //método de objeto calcularAprobados para calcular las asignaturas aprobadas
    public void calcularAprobados()
    {
        int contador = 0;
        for (int i = 0; i < CANTIDAD_ASIGNATURAS; i++) {
            if (notas[i] >= NOTA_MINIMA)
                contador++;
        }
        
        asignaturasAprobadas = contador;
    }
    
    //método de objeto toString que hace la conversión a String de un estudiante
    //álvaro estuvo aquí : larga vida al GMAT
    public String toString()
    {
        String mensaje = "NOMBRE: " + nombre + "\n"+
                         "NIF: " + nif + "\n";
        for (int i = 0; i < CANTIDAD_ASIGNATURAS; i++) {
            mensaje += "ASIGNATURA " + asignaturas[i] + ": " +  notas[i] + "\n";
        }
        mensaje += "CANTIDAD DE ASIGNATURAS APROBADAS: " + asignaturasAprobadas + "\n";
        mensaje += "DIRECTOR: " + director;
        
        return mensaje;
    }
    
}
