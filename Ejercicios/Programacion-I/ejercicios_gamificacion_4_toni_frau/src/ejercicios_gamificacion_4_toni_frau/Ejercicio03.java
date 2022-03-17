/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras acabadas
 * en vocal introducidas en una secuencia finaliazada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio03 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA = '.';
    final char ESPACIO = ' ';
    char caracter1 = ' ',caracter2;
    int contadorAcabadasVocal = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio03().metodoPrincipal();
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
            if (esVocal(caracter1))
                contadorAcabadasVocal++;
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorAcabadasVocal + 
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
