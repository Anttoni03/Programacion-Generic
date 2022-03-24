/*
programa que posibilita el recorrido del fichero dado 
visualizando en pantalla los objetos Estudiante contenidos en él.
autor: Juan Montes de Oca
 */
package claseteorica__22_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class visualizadorFicheroObjerosEstudiante {
    //método main
    public static void main(String [] argumentos) {
        new visualizadorFicheroObjerosEstudiante().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES  
        //instanciación objeto BufferedReader para enlazar el teclado posibilitando
        //la lectura a través de dicho objeto desde el teclado
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        //declaración objeto Estudiante para almacenar, de uno en uno, los objetos
        //Estudiante leídos desde el fichero
        Estudiante estudiante;
        //declaración objeto FicheroObjetosEstudianteIn para posibilitar la
        //lectura de objetos Estudiante desde el fichero 
        FicheroObjetosEstudianteIn fichero;  
        //declaración String para almacenar el nombre del fichero a visualizar
        String nombreFichero;
        
        //ACCIONES
        try {
            //mensaje usuario para introducir nombre del fichero a visualizar
            System.out.print("NOMBRE DEL FICHERO DE ESTUDIANTES A VISUALIZAR: ");
            //lectura nombre del fichero a visualizar
            nombreFichero=teclado.readLine();
            //instanciación objeto FicheroObjetosEstudianteIn fichero para establecer
            //el enlace con el fichero físico a nivel de lectura
            //de objetos Estudiante
            fichero=new FicheroObjetosEstudianteIn(nombreFichero); 
            //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
            //los objetos Estudiante contenidos en el fichero
            for (estudiante=fichero.lectura();!estudiante.esCentinela();) {
                //visualización objeto Estudiante leido
                System.out.println(estudiante.toString());
                //lectura siguiente objeto Estudiante
                estudiante=fichero.lectura();
            }
            //cierre del enlace con el fichero
            fichero.cierre();            
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       } 

    }
}
