/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la
 * primera palabra que contenga las cinco vocales
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 10.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class ProblemaClase01
{
    //DECLARACIONES DE CLASE
    char caracter = 'a';
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    String palabra = "";
    boolean tA = false, tE = false, tI = false, tO = false, tU = false;
    boolean palabraEncontrada = false;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        
        new ProblemaClase01().metodoPrincipal();
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
            
            if (tieneCincoVocales())
                palabraEncontrada = true;
            else if(!palabraEncontrada)
            {
                tA = false; tE = false; tI = false; tO = false; tU = false;
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
            comprobarVocal();
            if (!palabraEncontrada)
                palabra += caracter;
            
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO FUNCIÓN tieneCincoVocales PARA INDICAR SI UNA PALABRA TIENE CINCO VOCALES
    private boolean tieneCincoVocales()
    {
        return (tA && tE && tI && tO && tU);
    }
    
    //MÉTODO PROCEDIMIENTO comprobarVocal para comprobar si el caracter leído es vocal
    private void comprobarVocal()
    {
        if (caracter == 'a')
            tA = true;
        if (caracter == 'e')
            tE = true;
        if (caracter == 'i')
            tI = true;
        if (caracter == 'o')
            tO = true;
        if (caracter == 'u')
            tU = true;
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
            System.out.println("La primera palabra con 5 vocales es " + palabra);
        else
            System.out.println("No hay ninguna palabra con 5 vocales");
    }
}