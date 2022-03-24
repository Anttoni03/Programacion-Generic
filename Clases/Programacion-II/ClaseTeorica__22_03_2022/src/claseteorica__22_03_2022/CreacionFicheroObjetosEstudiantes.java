/*
Posibilita la lectura por teclado de objetos 
Estudiante y su grabación en un fichero. El proceso de 
lectura y grabación finalizará cuando el usuario lo indique. Se supone que los 
estudiantes se grabarán en orden ascendente del atributo nif.
 */
package claseteorica__22_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreacionFicheroObjetosEstudiantes {
    //método main
    public static void main(String [] argumentos) {
        new CreacionFicheroObjetosEstudiantes().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //instanciación objeto BufferedReader para enlazar el teclado posibilitando
        //la lectura a través de dicho objeto desde el teclado
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        //declaración objeto Estudiante para almacenar, de uno en uno, los objetos
        //Estudiante a leer desde el teclado
        Estudiante estudiante;
        //declaración objeto FicheroObjetosEstudianteOut para posibilitar la
        //escritura de objetos Estudiante en un fichero
        FicheroObjetosEstudianteOut fichero;
        //declaración String para almacenar el nombre del fichero para visualizar
        String nombreFichero;
        
        //ACCIONES
        try {
            //mensaje usuario para introducir nombre del fichero a crear
            System.out.print("NOMBRE DEL FICHERO DE ESTUDIANTES A CREAR: ");
            //lectura nombre del fichero a visualizar
            nombreFichero=teclado.readLine();  
            //instanciación objeto FicheroObjetosEstudianteOut fichero para establecer
            //el enlace con el fichero físico clientes.dat a nivel de escritura
            //de objetos Estudiante
            fichero=new FicheroObjetosEstudianteOut(nombreFichero);
            //bucle de lectura y grabación de objetos Estudiante 
            for (boolean fin=false;!fin;) {
                //instanciación objeto Estudiante
                estudiante=new Estudiante();
                //lectura objeto Estudiante desde el teclado
                estudiante.lectura();
                //grabación objeto Estudiante leído en el fichero
                fichero.escritura(estudiante);
                //mensaje usuario para continuar
                System.out.print("<> CONTINUAR (s/n): ");
                fin=!(teclado.readLine().charAt(0)=='s');
            }
            //grabación del objeto Cliente CENTINELA al final del fichero
            fichero.escritura(Estudiante.getCentinela());
            //cierre del enlace con el fichero
            fichero.cierre();                
        }catch (IOException error) {
            System.out.println("ERROR LECTURA DATOS");
        }
        
    }
    
}
