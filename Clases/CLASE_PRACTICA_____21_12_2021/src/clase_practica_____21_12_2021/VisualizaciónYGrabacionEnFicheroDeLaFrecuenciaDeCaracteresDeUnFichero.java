/*
FUNCIONALIDAD: dado un fichero de texto, de nombre texto.txt, lleva a cabo
la visualización y grabación en un fichero de texto, de nombre frecuencias.txt, de
la frecuencia de aparición de los caracteres contenidos en el
fichero texto.txt

NOTA: UTILIZACIÓN DE LA CLASE FrecuenciaCaracteres
 */
package clase_practica_____21_12_2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class VisualizaciónYGrabacionEnFicheroDeLaFrecuenciaDeCaracteresDeUnFichero {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new VisualizaciónYGrabacionEnFicheroDeLaFrecuenciaDeCaracteresDeUnFichero().programaPrincipal();
    }
    
    //declaración método programaPrincipal
    public void programaPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto BufferedReader para posibilitar la lectura, a nivel
        //de caracteres, desde un fichero de texto
        BufferedReader fichero1;
        //declaración objeto BufferedWriter para posibilitar la escritura, a nivel
        //de caracteres, en un fichero de texto
        BufferedWriter fichero2;
        //declaración constante entera para representar final de fichero
        final int FINAL_FICHERO=-1;
        //declaración objeto FrecuenciaCaracteres para gestionar la frecuencia
        //de cacaracteres
        FrecuenciaCaracteres frecuencia=new FrecuenciaCaracteres();
        //declaración variable entera para representar el código de caracter leido
        //desde el fichero
        int codigo;
        
        //ACCIONES
        //instanciación objeto BufferedReader fichero1 para establecer el enlace
        //con el fichero de texto texto.txt
        fichero1=new BufferedReader(new FileReader("texto.txt"));
        //instanciación objeto BufferedWriter fichero2 para establecer el enlace
        //con el fichero de texto frecuencias.txt
        fichero2=new BufferedWriter(new FileWriter("frecuenciasCaracteres.txt"));
        //lectura primer código de caracter desde el fichero texto.txt
        codigo=fichero1.read();
        //BUCLE DE LECTURA Y TRATAMIENTO 
        while (codigo!=FINAL_FICHERO) {
            //actualización del objeto frecuencia con el caracter correspondiente
            //al código de caracter leido
            frecuencia.actualizacion((char) codigo);
            //lectura siguiente código de caracter desde el fichero texto.txt
            codigo=fichero1.read();
        }
        //visualización frecuencia de caracteres
        System.out.println(frecuencia.toStringApariciones());
        //grabación de la frecuencia de caracteres en el fichero
        //para ello primero obtenemos los caracteres objeto de la gestión 
        //de frecuencia
        char [] caracteres=frecuencia.getCaracteres();
        for (int indice=0;indice<caracteres.length;indice++) {
            fichero2.write(frecuencia.toString((caracteres[indice])));
            //grabación nueva linea
            fichero2.newLine();
        }     
        //cierre enlaces ficheros
        fichero1.close();
        fichero2.close();        
    }   
}
