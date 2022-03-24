/*
2. Dados tres ficheros de objetos Estudiante correspondientes a la asignatura
Programación II y grupos G01, G02, G03, ..., G10, (los objetos de estos ficheros están ordenados
por nif en orden ascendente), implementar un programa que posibilite la creación de
un fichero, de nombre, estudiantesProgramacionII.dat, resultante de llevar a cabo la
fusión secuencial de los 10 primeros ficheros.
 */
package claseteorica__22_03_2022;

public class Problema_2__fusionSecuencialFicheros {
    //método main
    public static void main(String [] argumentos) {
        new Problema_2__fusionSecuencialFicheros().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES 
        //declaración constante entera para representar el número de ficheros
        //a fusionar
        final int NUMERO_FICHEROS=10;
        //declaración array objetos FicheroObjetosEstudianteIn para posibilitar la
        //lectura de objetos Estudiante desde los dos ficheros objeto de la fusión
        //simétrica
        FicheroObjetosEstudianteIn [] ficherosFusionar=new FicheroObjetosEstudianteIn[NUMERO_FICHEROS]; 
        //declaración objetos FicheroObjetosEstudianteOut para posibilitar la
        //escritura de objetos Estudiante en el fichero resultado de la fusión
        //simétrica
        FicheroObjetosEstudianteOut fichero; 
        //declaración objeto Estudiante para almacenar, de uno en uno, los objetos Estudiantes 
        //leídos de todos los ficheros de entrada
        Estudiante estudiante=new Estudiante();
        
        //ACCIONES
        //bucle instanciación objetos array FicheroObjetosEstudianteIn ficherosFusionar para establecer
        //los enlaces con los fichero físicos de objetos Estudiante a fusionar a nivel de lectura 
        for (int indice=0;indice<NUMERO_FICHEROS;indice++) {
            //instanciación componente indice del array ficherosFusionar para
            //establecer el enlace con el fichero "estudiantes_G0"+(indice+1)+".dat"
            ficherosFusionar[indice]=new FicheroObjetosEstudianteIn("estudiantes_G0"+(indice+1)+".dat");
        }
        //instanciación objeto FicheroObjetosEstudianteOut fichero para establecer
        //el enlace con el fichero físico estudiantesProgramacionII.dat a nivel de escritura
        //de objetos Estudiante
        fichero=new FicheroObjetosEstudianteOut("estudiantesProgramacionII.dat");
        //BUCLE TRATAMIENTO FUSIÓN SECUENCIAL
        for (int indice=0;indice<NUMERO_FICHEROS;indice++) {
            //lectura primer objeto Estudiante del fichero correspondiente a la componente
            //indice del array ficherosFusionar
            estudiante=ficherosFusionar[indice].lectura();
            while (!estudiante.esCentinela()) {
                //grabar en el fichero resultado de la fusión el objeto Estudiante
                //leído correspondiente al fichero de la componente indice
                //del array ficherosFusionar 
                fichero.escritura(estudiante);
                //lectura siguiente objeto Estudiante del fichero de la componente
                //indice del array ficherosFusionar
                estudiante=ficherosFusionar[indice].lectura();  
            }
        }
        //grabación del objeto Cliente CENTINELA en el fichero estudiantesProgramacionII.dat
        fichero.escritura(Estudiante.getCentinela());
        //bucle cierre de enlaces de ficheros
        for (int indice=0;indice<NUMERO_FICHEROS;indice++) {
            //cierre enlace con el fichero correspondiente a la componente indice
            //del array ficherosFusionar
            ficherosFusionar[indice].cierre();
        }
        //cierre del enlace con el fichero resultado de la fusión
        fichero.cierre();
    }
}
