/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar las
 * palabras con una cantidad par de caracteres en maýusculas y las de cantidad impar invertidas
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 08.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class ProblemaClase05
{
    //DECLARACIONES DE CLASE
    char caracter = 'a';
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    String cadena = "";
    char[] palabra = new char[13];
    int indicePalabra;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        
        new ProblemaClase05().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        System.out.print("Introduce una cadena con palabras de hasta 13 caracteres: ");
        caracter = LT.readChar();
        
        while (caracter != FINAL_CARACTER)
        {
            manejarEspacio();
            
            indicePalabra = -1;
            manejarPalabra();
            
            if ((indicePalabra+1) % 2 == 1)
                invertirPalabra();
            else
                palabraAMayusculas();
        }
        
        //VISUALIZAR
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra PARA CONTROLAR LAS ACCIONES EN LA ESCRITURA DE UNA PALABRA
    private void manejarPalabra()
    {
        while (caracter != FINAL_CARACTER && caracter != ESPACIO)
        {
            indicePalabra++;
            palabra[indicePalabra] = caracter;
            caracter = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO palabraAMayusculas usado para poner a mayúsculas las palabras pares
    private void palabraAMayusculas()
    {
        for (int i = 0; i <= indicePalabra; i++) {
            if (97 <= palabra[i] && palabra[i] <= 122 )
                palabra[i] -= 32;
            
            cadena += palabra[i];
        }
    }
    
    //MÉTODO PROCEDIMIENTO invertirPalabra usado para invertir las palabras impares
    private void invertirPalabra()
    {
        char[] invertida = new char[indicePalabra+1];
        for (int i = 0; i <= indicePalabra; i++) {
            invertida[i] = palabra[indicePalabra - i];
            cadena += invertida[i];
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarEspacio PARA CONTROLAR LAS ACCIONES FUERA DE LA ESCRITURA DE UNA PALABRA
    private void manejarEspacio()
    {
        while (caracter == ESPACIO)
        {
            cadena += caracter;
            caracter = LT.readChar();
        }
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        System.out.println(cadena);
    }
}