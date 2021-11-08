/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la cantidad
 * de palabras con cinco vocales
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 07.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio11
{
    //DECLARACIONES DE CLASE
    char caracter;
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    boolean vA = false,vE = false,vI = false,vO = false,vU = false;
    int contador = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio11().metodoPrincipal();
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
            vA = false;vE = false;vI = false;vO = false;vU = false;
            
            manejarPalabra();
            if (vA && vE && vI && vO && vU)
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
            comprobarVocal();
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
    
    //MÉTODO PROCEDIMIENTO comprobarVocal PARA CONFIRMAR SI EL CARACTER ES VOCAL
    private void comprobarVocal()
    {
        if (caracter == 'a')
            vA = true;
        
        if (caracter == 'e')
            vE = true;
        
        if (caracter == 'i')
            vI = true;
        
        if (caracter == 'o')
            vO = true;
        
        if (caracter == 'u')
            vU = true;
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        System.out.println("Hay un total de " + contador + " palabras con 5 vocales");
    }
}
