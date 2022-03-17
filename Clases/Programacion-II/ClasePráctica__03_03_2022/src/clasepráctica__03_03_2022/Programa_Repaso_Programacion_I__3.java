/*
3. Dado un fichero de texto, graba todas las palabras que tengan más de 10 
caracteres en otro fichero de texto.
 */
package clasepráctica__03_03_2022;

public class Programa_Repaso_Programacion_I__3 {
    //declaración método main
    public static void main(String [] argumentos) {
        new Programa_Repaso_Programacion_I__3().metodoPrincipal();
    }
    
    //declaración método principal
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para posibilitar la lectura
        //a nivel de palabras desde un fichero de texto
        PalabraFicherosLectura fichero1;
        //declaración objeto PalabraFicherosEscritura para posibilitar la escritura
        //a nivel de palabras en un fichero de texto
        PalabraFicherosEscritura fichero2;
        //declaración objeto Palabra
        Palabra palabra=new Palabra();
        //declaración constante entera para representar el número de caracteres
        //de las palabras a buscar
        final int NUMERO_CARACTERES=10;
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura fichero1 para establecer el
        //enlace a nivel de lectura de palabras con el fichero físico del cual vamos a leer
        fichero1=new PalabraFicherosLectura("ficheroPalabras.txt");
        //instanciación objeto PalabraFicherosEscritura fichero2 para establecer el
        //a nivel de escritura de palabras con el fichero físico en el que vamos a grabar
        fichero2=new PalabraFicherosEscritura("palabrasMas10.txt");
        //bucle de tratamiento de lectura y escritura de palabras
        while (fichero1.hayPalabras()) {
            //lectura palabra 
            palabra=fichero1.lectura();
            //tratamiento palabra leída 
            if (palabra.getNumeroCaracteres()>NUMERO_CARACTERES) {
                //grabar palabra en el fichero de escritura
                fichero2.escritura(palabra);
            }
        }
        //cierre de enlaces con ficheros
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero(); 
    }
    
}
