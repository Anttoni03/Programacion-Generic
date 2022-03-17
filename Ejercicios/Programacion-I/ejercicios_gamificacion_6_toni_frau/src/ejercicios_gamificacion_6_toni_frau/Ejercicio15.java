/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la cantidad
 * de palabras que comiencen por "ion"
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 08.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio15
{
    //DECLARACIONES DE CLASE
    char caracter1,caracter2;
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    final char PRIMER_CARACTER = 'i',SEGUNDO_CARACTER = 'o',TERCER_CARACTER = 'n';
    int contador = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio15().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        System.out.print("Introduce una cadena: ");
        caracter2 = LT.readChar();
        
        while (caracter2 != FINAL_CARACTER)
        {
            manejarEspacio();
            caracter1 = ESPACIO;
            manejarPalabra();
        }
        
        //VISUALIZAR
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra PARA CONTROLAR LAS ACCIONES EN LA ESCRITURA DE UNA PALABRA
    private void manejarPalabra()
    {
        while (caracter2 != FINAL_CARACTER && caracter2 != ESPACIO)
        {
            if (caracter2 == PRIMER_CARACTER && caracter1 == ESPACIO)
            {
                caracter2 = LT.readChar();
                caracter1 = caracter2;
                if (caracter2 == SEGUNDO_CARACTER)
                {
                    caracter2 = LT.readChar();
                    if (caracter2 == TERCER_CARACTER)
                        contador++;
                }
            }
            else
            {
                caracter2 = LT.readChar();
                caracter1 = caracter2;
            }
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarEspacio PARA CONTROLAR LAS ACCIONES FUERA DE LA ESCRITURA DE UNA PALABRA
    private void manejarEspacio()
    {
        while (caracter2 == ESPACIO)
            caracter2 = LT.readChar();
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        System.out.println("Hay un total de " + contador + " palabras que empiezan en \"ion\"");
    }
}
