/*
 * FUNCIONALIDAD: crear programa para visualizar el número de palabras que
 * contengan al menos una vocal introducidas en una secuencia finaliazada en '.'
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 30.10-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_4_toni_frau;

public class Ejercicio06 {
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA = '.';
    final int DIFERENCIA_CARACTERES = 32;
    char caracter;
    
    //MÉTODO main
    public static void main(String[] args) throws Exception
    {
        new Ejercicio06().metodoPrincipal();
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
            manejarTexto();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra
    private void manejarTexto()
    {
        while (caracter != FINAL_SECUENCIA)
        {
            //PROCESO DE VISUALIZAR EL RESULTADO
            if (esVocal(caracter))
                System.out.print(convertirCaracter(caracter));
            else
                System.out.print(caracter);
            
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO FUNCIÓN esVocal
    /**
     * Función para saber si un carácter es vocal
     * @param caracter caracter a comprobar si es vocal
     * @return devuelve true si caracter es una vocal y false si no
     */
    private boolean esVocal(char caracter)
    {
        boolean resultado = caracter == 'a' || caracter == 'e' || 
                caracter == 'i' || caracter == 'o' || caracter == 'u' || 
                caracter == 'A' || caracter == 'E' || caracter == 'I' || 
                caracter == 'O' || caracter == 'U';
        return resultado;
    }
    
    //MÉTODO FUNCIÓN convertirCaracter
    /**
     * Función para cambiar un carácter de mayúscula a minúscula y viceversa
     * @param caracter Carácter a cambiar de formato
     * @return El carácter dado cambiado de formato
     */
    private char convertirCaracter(char caracter)
    {
        if (caracter > 64 && caracter < 91)
            caracter += DIFERENCIA_CARACTERES;
        else
            caracter -= DIFERENCIA_CARACTERES;
                
        return caracter;
    }
}