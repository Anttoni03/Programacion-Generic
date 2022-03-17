/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras constituidas
 * por 2 vocales y 3 consonantes dadas por una secuencia finalizada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio07 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA = '.';
    final char ESPACIO = ' ';
    final int OBJETIVO_VOCALES = 2, OBJETIVO_CONSONANTES = 3;
    char caracter;
    int contadorPalabrasValidas = 0;
    int vocales = 0, consonantes = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio07().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal
    private void metodoPrincipal()
    {
        //ACCIONES
        //mensaje para introducir cadena
        System.out.print("Introduce una cadena de caracteres: ");
        
        caracter = LT.readChar();
        //TRATAMIENTO DE RECORRIDO
        while (caracter != FINAL_SECUENCIA)
        {            
            manejarEspacio();
            manejarPalabra();
            if (vocales == OBJETIVO_VOCALES && consonantes == OBJETIVO_CONSONANTES)
                contadorPalabrasValidas++;
            vocales = 0; consonantes = 0;
            
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorPalabrasValidas + 
                " palabras formadas con 2 vocales y 3 consonantes");
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra
    private void manejarPalabra()
    {
        while (caracter != FINAL_SECUENCIA && caracter != ESPACIO)
        {
            if (esVocal(caracter))
                vocales++;
            else
                consonantes++;
            
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarExcepciones
    private void manejarEspacio()
    {
        while (caracter == ESPACIO)
            caracter = LT.readChar();
    }
    
    //MÉTODO FUNCIÓN esVocal
    /**
     * Función para saber si un carácter es vocal
     * @param caracter caracter a comprobar si es vocal
     * @return devuelve true si caracter es una vocal (minúscula) y false si no
     */
    private boolean esVocal(char caracter)
    {
        boolean resultado = caracter == 'a' || caracter == 'e' || 
                caracter == 'i' || caracter == 'o' || caracter == 'u';
        return resultado;
    }
}
