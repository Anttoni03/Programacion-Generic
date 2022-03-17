/*
 * FUNCIONALIDAD: crear programa para inicializar 1 array con los caracteres del
 * abecedario y visualizar una cadena dada por los caracteres que correspondan
 * a los enteros dados por consola sobre el abecedario
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 02.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_5_toni_frau;

public class Ejercicio07 {
    //INICIALIZACIÓN
    final int VALOR_FINALIZACION = -1;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio07().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIONES
        char[] abecedario = {'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        //ACCIONES
        introducirLetraPorEntero(abecedario);
        
    }
    
    //método proceso introducirLetraPorEntero que muestra los caracteres dados en enteros
    private void introducirLetraPorEntero(char[] caracteres)
    {
        //INICIALIZACIÓN
        char[] cadena = new char[26];
        int indice = 0;
        System.out.print("Introduce un valor:");
        int valor = LT.readInt();
        
        //ACCIONES
        while (valor != VALOR_FINALIZACION || indice >= cadena.length)
        {
            if (valor >= 0 && valor < caracteres.length-1)
            {
                cadena[indice] = caracteres[valor];
                indice++;
            }
            else
                System.out.println("Error, inserte otro numero");
            
            System.out.print("Introduce un valor:");
            valor = LT.readInt();
        }
        
        //VISUALIZACIÓN
        for (int i = 0; i < cadena.length; i++)
            System.out.print(cadena[i]);
    }
}