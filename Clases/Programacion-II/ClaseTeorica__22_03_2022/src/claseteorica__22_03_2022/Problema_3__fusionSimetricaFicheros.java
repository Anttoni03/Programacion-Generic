/*
3. Dados tres ficheros de objetos Estudiante correspondientes a la asignatura
Programación II y grupos G01, G02, G03,..., G10, implementar un programa que posibilite la
creación de un fichero, de nombre, estudiantesProgramacionII.dat, resultante de llevar
a cabo la fusión simétrica de los 10 primeros ficheros.

 */
package claseteorica__22_03_2022;

public class Problema_3__fusionSimetricaFicheros {
    //método main
    public static void main(String [] argumentos) {
        new Problema_3__fusionSimetricaFicheros().metodoPrincipal();
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
        //declaración objetos ClienteObjetoFicherosOut para posibilitar la
        //escritura de objetos Estudiante en el fichero resultado de la fusión
        //simétrica
        FicheroObjetosEstudianteOut fichero; 
        //declaración array objetos Estudiante para almacenar los objetos Estudiante leídos,
        //de uno en uno, desde los ficheros a fusionar
        Estudiante [] estudiantes=new Estudiante[NUMERO_FICHEROS];
        
        //ACCIONES
        //bucle instanciación objetos array FicheroObjetosEstudianteIn ficherosFusionar para establecer
        //los enlaces con los fichero físicos de objetos Estudiante a fusionar a nivel de lectura y también
        //para instanciar los objetos Estudiante del array estudiantes
        for (int indice=0;indice<NUMERO_FICHEROS;indice++) {
            //instanciación componente indice del array ficherosFusionar para
            //establecer el enlace con el fichero "estudiantes"+indice+".dat"
            ficherosFusionar[indice]=new FicheroObjetosEstudianteIn("estudiantes_G0"+(indice+1)+".dat");
            //instanciación objeto Estudiante indice-ésimo del array estudiantes
            estudiantes[indice]=new Estudiante();
        }
        //instanciación objeto FicheroObjetosEstudianteOut fichero para establecer
        //el enlace con el fichero físico estudiantesProgramacionII.dat a nivel de escritura
        //de objetos Estudiante
        fichero=new FicheroObjetosEstudianteOut("estudiantesProgramacionII.dat");
        //bucle lectura del primer objeto Estudiante contenido en cada uno de los dos
        //ficheros a fusionar
        for (int indice=0;indice<NUMERO_FICHEROS;indice++) {
            //lectura primer objeto Estudiante del fichero correspondiente a la componente
            //indice del array ficherosFusionar
            estudiantes[indice]=ficherosFusionar[indice].lectura();
        }
        //BUCLE TRATAMIENTO FUSIÓN SIMÉTRICA
        while (!ficherosFinalizados(estudiantes)) {
            //obtención del objeto Estudiante menor
            int menor=Estudiante.menor(estudiantes);
            //grabar en el fichero resultado de la fusión el objeto Estudiante
            //que tenga el nif menor
            fichero.escritura(estudiantes[menor]);
            //lectura del siguiente objeto Estudiante del fichero procedente
            //el objeto grabado en la sentencia anterior
            estudiantes[menor]=ficherosFusionar[menor].lectura();
        }
        //grabación del objeto Estudiante CENTINELA en el fichero estudiantesProgramacionII.dat
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
    
    //método booleano que verifica si todos los ficheros estudiantes a fusionar han
    //sido leídos en su totalidad y por lo tanto están finalizados
    private boolean ficherosFinalizados(Estudiante [] datos) {
        for (int indice=0;indice<datos.length;indice++) {
            if (!datos[indice].esCentinela()) {
                return false;
            }
        }
        return true;
    }
}
