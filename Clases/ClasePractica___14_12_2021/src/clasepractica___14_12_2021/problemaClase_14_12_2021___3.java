/*
Dado un fichero de texto, de nombre introducido por teclado a petición del
programa, genera otro fichero, de nombre salida.txt, cuyo contenido serán
las palabras del primer fichero en orden inverso.
nota: en un fichero no habrá mas de 50 palabras.
 */
package clasepractica___14_12_2021;

public class problemaClase_14_12_2021___3 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new problemaClase_14_12_2021___3().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para porder leer objetos 
        //Palabra desde un fichero de texto
        PalabraFicherosLectura fichero1;
        //declaración objeto PalabraFicherosEscritura para poder escribir
        //objetos Palabra en un fichero de texto
        PalabraFicherosEscritura fichero2;
        //declaración objeto Palabra
        Palabra palabra=new Palabra();
        //declaración constante entera para representar el máximo número de 
        //objetos palabras que puede contener un fichero
        final int MAXIMO_NUMERO_PALABRAS=50;
        //declaración array de MAXIMO_NUMERO_PALABRAS componetes de objetos 
        //Palabra para almacenar las palabras contenidas en el fichero de entrada
        Palabra [] palabras=new Palabra[MAXIMO_NUMERO_PALABRAS];
        //declaración String para almacenar el nombre del fichero a leer
        String nombreFichero;
        //declaración variable entera para almacenar el número de palabras contenidas
        //en el fichero de lectura
        int numeroPalabras=0;
 
        
        //ACCIONES
        //mensaje usuario para introducir el nombre del fichero de lectura
        System.out.print("INTRODUCIR NOMBRE DE FICHERO: ");
        //lectura desde el teclado del nombre del fichero
        nombreFichero=LT.readLine();
        //instanciación del objeto PalabraFicherosLectura fichero1 para establecer
        //el enlace con el fichero, cuyo nombre ha sido introducido por el usuario,
        //en modo lectura a través delobjeto fichero1
        fichero1=new PalabraFicherosLectura(nombreFichero);        
        //instanciación objeto PalabraFicherosEscritura fichero2 para establecer
        //el enlace con el fichero de texto salida.txt en modo escritura a
        //nivel de objetos Palabra
        fichero2=new PalabraFicherosEscritura("salida.txt");
        //BUCLE DE TRATAMIENTO DE RECORRIDO DE LECTURA DESDE EL FICHERO DE ENTRADA
        //Y ASIGNACIÓN DE LAS MISMAS AL ARRAY DE OBJETOS Palabra palabras
        while (fichero1.hayPalabras()) {
            //lectura objeto Palabra desde el fichero entrada.txt a través del
            //objeto fichero1
            palabra=fichero1.lectura();
            //instanciación primera componente objeto Palabra del array palabras
            palabras[numeroPalabras]=new Palabra();
            //asignar/copiar la palabra leída desde el fichero en la componente
            //numeroPalabras del array palabras
            Palabra.copiar(palabra, palabras[numeroPalabras]);
            //incrementar contador numeroPalabras
            numeroPalabras++;
        }
        //ECRITURA DE LAS PALABRAS ALMACENADAS EN EL ARRAY palabras EN EL FICHERO
        //DE SALIDA EN ORDEN INVERSO
        for (int indice=numeroPalabras-1;indice>=0;indice--) {
            //escritura del objeto Palabra contenido en la componente indice
            //del array palabras en el fichero de salida
            fichero2.escritura(palabras[indice]);
            //escritura en el fichero de salida del separador
            fichero2.escrituraSeparador();
        }
        
        //cierre enlaces ficheros
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero();      
    }
    
}
