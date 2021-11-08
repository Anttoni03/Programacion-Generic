/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de caracteres por consola
 * y mostrar la cadena invertida
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 05.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio01
{
    //DECLARACIONES DE CLASE
    final char FINAL_SECUENCIA='.';
    char[] caracteres = new char[100];
    char[] inversa = new char[100];
    int contador = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio01().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        //mensaje para introducir cadena
        System.out.print("Introduce una cadena de caracteres: ");
        caracteres[contador] = LT.readChar();
        recibirCadena();
        
        invertirCadena();
        
        //VISUALIZAR EL RESULTADO
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO recibirCadena
    private void recibirCadena()
    {
        while (caracteres[contador] != FINAL_SECUENCIA && contador < caracteres.length - 1)
        {
            contador++;
            caracteres[contador] = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO invertirCadena
    private void invertirCadena()
    {
        for (int i = 0;i<caracteres.length;i++)
            inversa[i] = caracteres[caracteres.length - 1 -i];
    }
    
    //método procedimiento visualizar para visualizar la cadena resultante
    private void visualizar()
    {
        for (int i = 0;i<inversa.length;i++)
            System.out.print(inversa[i]);
    }
}