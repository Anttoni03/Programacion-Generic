/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la cantidad
 * de palabras con más de 5 y menos de 15 caracteres
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 08.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio12
{
    //DECLARACIONES DE CLASE
    char caracter;
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    final int MIN_CARACTERES = 5,MAX_CARACTERES = 15;
    int contador = 0, caracteres = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio12().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        System.out.print("Introduce una cadena: ");
        caracter = LT.readChar();
        
        while (caracter != FINAL_CARACTER)
        {
            manejarEspacio();
            caracteres = 0;
            manejarPalabra();
            if (caracteres > MIN_CARACTERES && caracteres < MAX_CARACTERES)
                contador++;
        }
        
        //VISUALIZAR
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra PARA CONTROLAR LAS ACCIONES EN LA ESCRITURA DE UNA PALABRA
    private void manejarPalabra()
    {
        while (caracter != FINAL_CARACTER && caracter != ESPACIO)
        {
            caracteres++;
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarEspacio PARA CONTROLAR LAS ACCIONES FUERA DE LA ESCRITURA DE UNA PALABRA
    private void manejarEspacio()
    {
        while (caracter == ESPACIO)
        {
            caracter = LT.readChar();
        }
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        System.out.println("Hay un total de " + contador + " palabras con entre 5 y 15 caracteres");
    }
}
