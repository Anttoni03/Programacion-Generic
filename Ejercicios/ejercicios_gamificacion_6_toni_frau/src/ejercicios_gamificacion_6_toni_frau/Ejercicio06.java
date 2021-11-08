/*
 * FUNCIONALIDAD: crear programa para visualizar la comunidad autónoma con mayor
 * casos de COVID y la media de casos nacional
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio06
{
    //DECLARACIONES DE CLASE
    String[] comunidades = {"Andalucía", "Aragón", "Asturias", "Baleares",
        "Canarias", "Cantabria", "Castilla la Mancha", "Castilla y León",
        "Cataluña", "Comunidad Valenciana", "Extremadura", "Galicia", "La Rioja",
        "Madrid", "Murcia", "Navarra", "País Vasco", "Ceuta y Melilla"};
    int[] casosCOVID = {1000,3095,3673,4786,4678,2466,8750,2546,4588,9765,1466,
    4577,4585,5683,9753,3455,3475,2346};
    
    String mayorComunidad;
    int mayorCasos,totalCasos = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio06().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        //mensaje para introducir cadena
        mayorContagios();
        
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO mayorContagios
    private void mayorContagios()
    {
        mayorComunidad = comunidades[0];
        mayorCasos = casosCOVID[0];
        for (int i = 0; i < casosCOVID.length; i++)
        {
            if (casosCOVID[i] > mayorCasos)
            {
                mayorCasos = casosCOVID[i];
                mayorComunidad = comunidades[i];
            }
            totalCasos += casosCOVID[i];
        }
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar para visualizar resultados
    private void visualizar()
    {
        System.out.println("La comunidad con más contagios es: " + mayorComunidad
        + " con " + mayorCasos + " casos");
        
        System.out.println("La media nacional es de " + (float)totalCasos/casosCOVID.length + " casos");
        System.out.println("Casos inventados :)");
    }
}
