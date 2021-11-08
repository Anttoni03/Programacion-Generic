/*
 * FUNCIONALIDAD: crear programa para recibir una cadena de texto y mostrar la cantidad
 * de palabras que acaben por "ion"
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 08.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_6_toni_frau;

public class Ejercicio14
{
    //DECLARACIONES DE CLASE
    char caracter1,caracter2,caracter3,caracter4;
    final char ESPACIO = ' ', FINAL_CARACTER = '.';
    final char PRIMER_CARACTER = 'i',SEGUNDO_CARACTER = 'o',TERCER_CARACTER = 'n';
    int contador = 0;
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio14().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //ACCIONES
        System.out.print("Introduce una cadena: ");
        caracter4 = LT.readChar();
        caracter1 = caracter4;
        caracter2 = caracter4;
        caracter3 = caracter4;
        
        while (caracter4 != FINAL_CARACTER)
        {
            manejarEspacio();
            
            manejarPalabra();
            if (comprobarCoincidenciaCaracteres())
                contador++;
        }
        
        //VISUALIZAR
        visualizar();
    }
    
    //MÉTODO PROCEDIMIENTO manejarPalabra PARA CONTROLAR LAS ACCIONES EN LA ESCRITURA DE UNA PALABRA
    private void manejarPalabra()
    {
        while (caracter4 != FINAL_CARACTER && caracter4 != ESPACIO)
        {
            caracter1 = caracter2;
            caracter2 = caracter3;
            caracter3 = caracter4;
            caracter4 = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO manejarEspacio PARA CONTROLAR LAS ACCIONES FUERA DE LA ESCRITURA DE UNA PALABRA
    private void manejarEspacio()
    {
        while (caracter4 == ESPACIO)
        {
            caracter4 = LT.readChar();
        }
    }
    
    //MÉTODO PROCEDIMIENTO comprobarCoincidendiaCaracteres PARA CONFIRMAR SI LOS CARÁCTERES SON LOS INDICADOS
    private boolean comprobarCoincidenciaCaracteres()
    {
        return (caracter1 == PRIMER_CARACTER && 
                caracter2 == SEGUNDO_CARACTER && 
                caracter3 == TERCER_CARACTER);
    }
    
    //MÉTIDO PROCEDIMIENTO visualizar PARA VISUALIZAR RESULTADOS
    private void visualizar()
    {
        System.out.println("Hay un total de " + contador + " palabras que acaban en \"ion\"");
    }
}
