/*
2. Dado un fichero de texto visualiza la frecuencia de aparición de cada una de las 
palabras contenidas en él. Se entiende que en el fichero no habrá nunca más de 
500 palabras diferentes.
 */
package clasepráctica__03_03_2022;

public class Programa_Repaso_Programacion_I__2 {
    //declaración método main
    public static void main(String [] argumentos) {
        new Programa_Repaso_Programacion_I__2().metodoPrincipal();
    }
    
    //método principal
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto FrecuenciaPalabras
        FrecuenciaPalabras estructura=new FrecuenciaPalabras();
        //declaración objeto PalabraFicherosLectura para posibilitar la lectura
        //de objetos Palabra desde un fichero de texto
        PalabraFicherosLectura fichero=null;
        //declaración objeto Palabra para almacenar, de una en una, las palabras
        //leídas desde el fichero y a tratar
        Palabra palabra=new Palabra();       
        
        //ACCIONES
        fichero=new PalabraFicherosLectura("ficheroPalabras.txt");
        //bucle tratamiento de recorrido de lectura y tratamiento a nivel
        //de objetos Palabra
        while (fichero.hayPalabras()) {
            //lectura palabra desde el fichero
            palabra=fichero.lectura();
            //tratamiento palabra leída
            estructura.actualizacion(palabra);
        }
        //visualización resultado a nivel de la estructura de frecuencias
        //de palabras utilizada
        System.out.println(estructura.toString());
        //cierre del enlace con el fichero
        fichero.cerrarEnlaceFichero();
    }
    
}
