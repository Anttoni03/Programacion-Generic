/*
 * FUNCIONALIDAD: crear programa para visualizar el número de plabras acabadas
 * en consonante introducidas en una secuencia finaliazada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio04 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA = '.';
    final char ESPACIO = ' ';
    char caracter1 = ' ',caracter2;
    int contadorAcabadasConsonante = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio04().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal
    private void metodoPrincipal()
    {
        //ACCIONES
        //mensaje para introducir cadena
        System.out.print("Introduce una cadena de caracteres: ");
        
        caracter2 = LT.readChar();
        //TRATAMIENTO DE RECORRIDO
        while (caracter2 != FINAL_SECUENCIA)
        {            
            manejarEspacio();
            manejarPalabra();
            if (noEsVocal(caracter1))
                contadorAcabadasConsonante++;
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorAcabadasConsonante + 
                " palabras acabadas en vocal");
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra
    private void manejarPalabra()
    {
        while (caracter2 != FINAL_SECUENCIA && caracter2 != ESPACIO)
        {
            caracter1 = caracter2;
            caracter2 = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarExcepciones
    private void manejarEspacio()
    {
        while (caracter2 == ESPACIO)
            caracter2 = LT.readChar();
    }
    
    //MÉTODO FUNCIÓN noEsVocal
    /**
     * Función para saber si un carácter no es vocal
     * @param caracter caracter a comprobar si no es vocal
     * @return devuelve true si caracter no es una vocal (minúscula) y false si lo es
     */
    private boolean noEsVocal(char caracter)
    {
        boolean resultado = caracter == 'a' || caracter == 'e' || 
                caracter == 'i' || caracter == 'o' || caracter == 'u';
        return !resultado;
    }
}
