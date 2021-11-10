/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la
 * primera palabra que contenga las mismas vocales que consonantes
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class ProblemaClase02
{
    //DECLARACIONES DE CLASE
    char caracter = 'a';
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    String palabra = "";
    int consonantes = 0, vocales = 0;
    boolean palabraEncontrada = false;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        
        new ProblemaClase02().metodoPrincipal();
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
            
            if (consonantesIgualVocales())
                palabraEncontrada = true;
            else if(!palabraEncontrada)
            {
                consonantes = 0; vocales = 0;
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
            comprobarCaracter();
            if (!palabraEncontrada)
                palabra += caracter;
            
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO FUNCIÓN consonantesIgualVocales PARA INDICAR SI HAY TANTAS VOCALES COMO CONSONANTES
    private boolean consonantesIgualVocales()
    {
        return (consonantes == vocales);
    }
    
    //MÉTODO PROCEDIMIENTO comprobarCaracter para comprobar si el caracter leído es vocal o consonante
    private void comprobarCaracter()
    {
        if (caracter == 'a' || caracter == 'e' || caracter == 'i' || 
                caracter == 'o' || caracter == 'u')
            vocales++;
        else
            consonantes++;
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
            System.out.println("La primera palabra con las mismas vocales como consonantes es: " + palabra);
        else
            System.out.println("No hay ninguna palabra con tantas vocales como consonantes");
    }
}