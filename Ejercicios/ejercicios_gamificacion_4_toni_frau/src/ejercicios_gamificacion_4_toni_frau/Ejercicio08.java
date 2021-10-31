/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras constituidas
 * por al menos 2 vocales y tenga una cantidad impar de caracteres dadas por 
 * una secuencia finalizada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio08 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA = '.';
    final char ESPACIO = ' ';
    final int OBJETIVO_MINIMO_VOCALES = 2;
    char caracter;
    int contadorPalabrasValidas = 0, contadorCaracteres = 0, vocales = 0;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio08().metodoPrincipal();
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
            if (vocales == OBJETIVO_MINIMO_VOCALES && (contadorCaracteres % 2 != 0))
                contadorPalabrasValidas++;
            
        }
        
        //VISUALIZAR EL RESULTADO
        System.out.println("Hay un total de " + contadorPalabrasValidas + 
                " palabras con al menos 2 vocales y de una cantidad impar de caracteres");
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra
    private void manejarPalabra()
    {
        while (caracter != FINAL_SECUENCIA && caracter != ESPACIO)
        {
            contadorCaracteres++;
            if (esVocal(caracter))
                vocales++;
            
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarExcepciones
    private void manejarEspacio()
    {
        while (caracter == ESPACIO)
        {
            vocales = 0;
            contadorCaracteres = 0;
            caracter = LT.readChar();
        }
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
