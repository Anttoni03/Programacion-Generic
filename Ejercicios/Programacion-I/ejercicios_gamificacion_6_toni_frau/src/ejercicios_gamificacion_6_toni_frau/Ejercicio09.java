/*
 * FUNCIONALIDAD: crear programa para mostrar la cantidad de votos recibidos de cada
 * partido político y su porcentaje del total
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 07.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio09
{
    //DECLARACIONES DE CLASE
    String[] partidos = {"PARTIDO ROJO", "PARTIDO AZUL", "PARTIDO VERDE", "PARTIDO AMARILLO",
        "PARTIDO VIOLETA", "PARTIDO MAGENTA", "PARTIDO ROSA", "PARTIDO MARRÓN",
        "PARTIDO BLANCO", "PARTIDO NEGRO"};
    int[] votos = {395837,184790,156899,149865, 195789,104359,135853,134674,994215,072015};
    int totales = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio09().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        calculoTotales();
        
        //VISUALIZAR
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO calculoTotales
    private void calculoTotales()
    {
        for (int i = 0; i < votos.length; i++)
            totales += votos[i];
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        for (int i = 0; i<partidos.length;i++)
        {
            float porcentaje = votos[i]*100/(float)totales;
            System.out.println(partidos[i] + " -> \t número de votos: " + votos[i] +
                    "\t porcentaje: " + porcentaje + "%");
        }
    }
}
