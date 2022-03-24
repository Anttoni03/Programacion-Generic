/*
5. Dado el fichero resultante del problema anterior, estudiantesProgramacionII.dat, 
llevar a cabo la división de dicho fichero en diez ficheros (G01.dat, G02.dat,...,
G010.dat) teniendo en cuenta como atributo de división el atributo grupo.
 */
package claseteorica__22_03_2022;

public class Problema_5__DivisionFicheros {
     //método main
    public static void main(String [] argumentos) {
        new Problema_5__DivisionFicheros().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES 
        //declaración constante entera para representar el número de ficheros
        //a fusionar
        final int NUMERO_FICHEROS=10;
        //declaración array objetos FicheroObjetosEstudianteOut para posibilitar la
        //grabación de objetos Estudiante en los  ficheros resultantes de la división
        FicheroObjetosEstudianteOut [] ficherosResultantes=new FicheroObjetosEstudianteOut[NUMERO_FICHEROS]; 
        //declaración objetos FicheroObjetosEstudianteIn para posibilitar la
        //lectura de objetos Estudiante desde el fichero objeto de la división
        FicheroObjetosEstudianteIn fichero; 
        //declaración objeto Estudiante para almacenar, de uno en uno, los objetos
        //Estudiante leídos desde el fichero objeto de la fusión
        Estudiante estudiante=new Estudiante();
        
        //ACCIONES
        //bucle instanciación objetos array FicheroObjetosEstudianteOut ficherosResultantes para establecer
        //los enlaces con los fichero físicos de objetos Estudiante resultantes del proceso
        //de división a nivel de escritura
        for (int indice=0;indice<NUMERO_FICHEROS;indice++) {
            //instanciación componente indice del array ficherosResultantes para
            //establecer el enlace con el fichero "estudiantes"+indice+".dat"
            ficherosResultantes[indice]=new FicheroObjetosEstudianteOut("G0"+(indice+1)+".dat");
        }
        //instanciación objeto FicheroObjetosEstudianteIn fichero para establecer
        //el enlace con el fichero físico  estudiantesProgramacionII.dat a nivel de lectura
        //de objetos Estudiante
        fichero=new FicheroObjetosEstudianteIn(" estudiantesProgramacionII.dat");
        //lectura primer objeto Estudiante desde el fichero estudiantesProgramacionII.dat enlazado
        //por el objeto fichero
        estudiante=fichero.lectura();
        //BUCLE DE DIVISIÓN EN FUNCIÓN DEL ATRIBUTO grupo
        while (!estudiante.esCentinela()) {
            //tratamiento objeto Estudiante leído y grabación del mismo en el fichero
            //de salida correspodniente
            ficherosResultantes[estudiante.getGrupo()-1].escritura(estudiante);
            //lectura siguiente objeto Estdiante desde el fichero objeto de la división
            estudiante=fichero.lectura();
        }
        //bucle grabación objeto Estudiante CENTINELA en los ficheros resultantes de
        //la división y cierre de enlaces de los mismos
        for (int indice=0;indice<NUMERO_FICHEROS;indice++) {
            //grabación del objeto Estudiante CENTINELA en el fichero correspondiente a la componente indice
            //del array ficherosResultantes
            ficherosResultantes[indice].escritura(Estudiante.getCentinela());
            //cierre enlace con el fichero correspondiente a la componente indice
            //del array ficherosResultantes
            ficherosResultantes[indice].cierre();
        }
        //cierre del enlace con el fichero objeto de la división
        fichero.cierre();
    }
}
