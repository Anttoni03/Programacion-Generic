/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la
 * primera palabra que contenga un número par de caracteres
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class ProblemaClase03
{
    //DECLARACIONES DE CLASE
    char caracter = 'a';
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    String palabra = "";
    int caracteres = 0;
    boolean palabraEncontrada = false;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        
        new ProblemaClase03().metodoPrincipal();
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
            
            manejarPalabra();
            
            if (caracteresPar())
                palabraEncontrada = true;
            else if(!palabraEncontrada)
            {
                caracteres = 0;
                palabra = "";
            }
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
            if (!palabraEncontrada)
                palabra += caracter;
            
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO FUNCIÓN caracteresPar PARA INDICAR SI HAY UN NÚMERO PARA DE CARACTERES
    private boolean caracteresPar()
    {
        return (caracteres % 2 == 0);
    }
    
    //MÉTODO PROCEDIMIENTO manejarEspacio PARA CONTROLAR LAS ACCIONES FUERA DE LA ESCRITURA DE UNA PALABRA
    private void manejarEspacio()
    {
        while (caracter == ESPACIO)
            caracter = LT.readChar();
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        if (palabraEncontrada)
            System.out.println("La primera palabra con un número par de caracteres es: " + palabra);
        else
            System.out.println("No hay ninguna palabra con un número par de caracteres");
    }
}