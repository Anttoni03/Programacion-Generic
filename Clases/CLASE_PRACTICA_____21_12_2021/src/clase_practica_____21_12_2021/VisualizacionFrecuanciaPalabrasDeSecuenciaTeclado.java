/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado
y acabada con el caracter '\n' (SALTO DE LINEA), visualiza la frecuencia de aparición de las
palabras contenidas en la secuencia dada.

NOTA: UTILIZACIÓN DE LA CLASE FrecuenciaPalabras
 */
package clase_practica_____21_12_2021;

public class VisualizacionFrecuanciaPalabrasDeSecuenciaTeclado {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new VisualizacionFrecuanciaPalabrasDeSecuenciaTeclado().programaPrincipal();
    }
    
    //declaración método programaPrincipal
    public void programaPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto FrecuenciaPalabras para gestionar la frecuencia
        //de las palabras contenidas en la secuencia de entrada
        FrecuenciaPalabras frecuencia=new FrecuenciaPalabras();
        //declaración objeto Palabra para almacenar, de una en una, las palabras
        //leidas desde la secuencia de enrada
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //mensaje usuario para introducir secuencia
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //BUCLE DE LECTURA Y TRATAMIENTO A NIVEL DE PALABRAS
        while (Palabra.hayPalabras()) {
            //lectura palabra desde la secuencia
            palabra.lectura();
            //tratamiento palabra leida a través de la actualización del objeto frecuencia
            frecuencia.actualizacion(palabra);
        }
        //Visualización frecuencia palabras de la secuencia
        System.out.println(frecuencia.toString());
    }
    
}
