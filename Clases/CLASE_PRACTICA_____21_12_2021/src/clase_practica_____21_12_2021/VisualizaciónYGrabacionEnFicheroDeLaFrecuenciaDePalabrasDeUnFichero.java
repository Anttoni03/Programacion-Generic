/*
FUNCIONALIDAD: dado un fichero de texto, de nombre texto.txt, lleva a cabo
la visualización y grabación en un fichero de texto, de nombre frecuencias.txt, de
la frecuencia de aparición de las palabras contenidas en el
fichero texto.txt

NOTA: UTILIZACIÓN DE LA CLASE FrecuenciaPalabras
 */
package clase_practica_____21_12_2021;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class VisualizaciónYGrabacionEnFicheroDeLaFrecuenciaDePalabrasDeUnFichero {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new VisualizaciónYGrabacionEnFicheroDeLaFrecuenciaDePalabrasDeUnFichero().programaPrincipal();
    }
    
    //declaración método programaPrincipal
    public void programaPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosIn para posibilitar la lectura, a nivel
        //de palabras, desde un fichero de texto
        PalabraFicherosLectura fichero1;
        //declaración objeto BufferedWriter para posibilitar la escritura, a nivel
        //de caracteres, en un fichero de texto
        BufferedWriter fichero2;
        //declaración objeto FrecuenciaPalabras para gestionar la frecuencia
        //de palabras
        FrecuenciaPalabras frecuencia=new FrecuenciaPalabras();
        //declaración objeto Palabra para representar la palabra leida
        //desde el fichero
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //instanciación objeto PalabraFicherosIn fichero1 para establecer el enlace
        //con el fichero de texto texto.txt
        fichero1=new PalabraFicherosLectura("texto.txt");
        //instanciación objeto BufferedWriter fichero2 para establecer el enlace
        //con el fichero de texto frecuencias.txt
        fichero2=new BufferedWriter(new FileWriter("frecuencias.txt"));
        //BUCLE DE LECTURA Y TRATAMIENTO 
        while (fichero1.hayPalabras()) {
            //lectura palabra desde el fichero
            palabra=fichero1.lectura();
            //actualización del objeto frecuencia con la pàlabra leida
            frecuencia.actualizacion(palabra);
        }
        //visualización frecuencia de caracteres
        System.out.println(frecuencia.toString());
        //grabación de la frecuencia de caracteres en el fichero
        //para ello primero obtenemos los caracteres objeto de la gestión 
        //de frecuencia
        Palabra [] palabras=frecuencia.getPalabras();
        for (int indice=0;indice<frecuencia.getNumeroPalabras();indice++) {
            fichero2.write(frecuencia.toString((palabras[indice])));
            //grabación nueva linea
            fichero2.newLine();
        }     
        //cierre enlaces ficheros
        fichero1.cerrarEnlaceFichero();
        fichero2.close();        
    }   
}
