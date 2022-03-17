/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la cantidad
 * de palabras que contengan la 'b','p' y 'm'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 08.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio13
{
    //DECLARACIONES DE CLASE
    char caracter;
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    boolean tieneB = false, tieneP = false, tieneM = false;
    int contador = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio13().metodoPrincipal();
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
            tieneB = false; tieneP = false; tieneM = false;
            
            manejarPalabra();
            if (tieneB && tieneP && tieneM)
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
            comprobarConsonantes();
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
    
    //MÉTODO PROCEDIMIENTO comprobarConsonante PARA CONFIRMAR SI EL CARACTER ES UNA CONSONANTE INDICADA
    private void comprobarConsonantes()
    {
        if (caracter == 'b')
            tieneB = true;
        
        if (caracter == 'p')
            tieneP = true;
        
        if (caracter == 'm')
            tieneM = true;
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        System.out.println("Hay un total de " + contador + " palabras con los caracteres"
                + " \'b\',\'p\' y \'m\'");
    }
}
