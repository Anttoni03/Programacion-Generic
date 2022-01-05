/*
Dadas 10 palabras, introducidas por teclado a través de una secuencia de caracteres
terminada con el caracter '.', y un fichero de texto, de nombre introducido por teclado
a petición del programa, lleva a cabo la visualización del número de apariciones
de cada una de las palabras en el fichero de texto.

NOTA: EL TRATAMIENTO PRINCIPAL SE FUNDAMENTA EN OBTENER PARA CADA PALABRA, CONTENIDA
EN LA SECUENCIA DE CARACTERES INTRODUCIDA POR TECLADO, EL NÚMERO
DE VECES QUE APARECEN EN EL FICHERO DE TEXTO UN ÚNICO RECORRIDO DEL FICHERO DE
TEXTO.
 */
package clase_practica_____21_12_2021;

public class problemaClase_14_12_2021___5_v2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new problemaClase_14_12_2021___5_v2().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para porder leer objetos 
        //Palabra desde un fichero de texto
        PalabraFicherosLectura fichero;
        //declaración objeto Palabra
        Palabra palabra=new Palabra();
        //declaración constante entera para representar el número de 
        //objetos palabras contenidas en la secuencia de caracteres introducida
        //por teclado
        final int NUMERO_PALABRAS=10;
        //declaración array de NUMERO_PALABRAS componentes de objetos 
        //Palabra para almacenar las palabras contenidas en secuencia
        //introducida por teclado
        Palabra [] palabras=new Palabra[NUMERO_PALABRAS];
        //declaración array de componentes enteras para almacenar, por correspondencia
        //posicional con el array palabras, el número de apariciones de cada una
        //de las palabras almacenadas en el array palabras
        int [] numeroApariciones=new int[NUMERO_PALABRAS];
        //declaración String para almacenar el nombre del fichero a leer
        String nombreFichero;
 
        
        //ACCIONES
        //mensaje usuario para introducir el nombre del fichero de lectura
        System.out.print("INTRODUCIR NOMBRE DE FICHERO: ");
        //lectura desde el teclado del nombre del fichero
        nombreFichero=LT.readLine(); 
        //instanciación del objeto PalabraFicherosLectura fichero para establecer
        //el enlace con el fichero, cuyo nombre ha sido introducido por el usuario,
        //en modo lectura a través del objeto fichero
        fichero=new PalabraFicherosLectura(nombreFichero);  
        //inicialización array numeroApariciones
        for (int indice=0;indice<numeroApariciones.length;indice++) {
            numeroApariciones[indice]=0;
        }
        //Instanciación de las componentes objetos Palabra del array palabras
        for (int indice=0; indice<palabras.length;indice++) {
            palabras[indice]=new Palabra();
        }   
        //mensaje usuario para introducir secuencia de caracteres con las 10 palabras
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //BUCLE DE LECTURA DE LA SECUENCIA DE CARACTERES A NIVEL DE OBJETOS Palabra Y
        //ALMACENAMIENTO DE ÉSTOS EN EL ARRAY palabras
        //nota --> se supone que le usuario es pperfecto y siempre en la secuencia
        //introducida por teclado habrá 10 palabras
        for (int indice=0;indice<palabras.length;indice++) {
            //verificación de si hay algún objeto Palabra por leer en la secuencia
            if (Palabra.hayPalabras()) {
                //lectura objeto Palabra desde la secuencia
                palabra.lectura();
                //copiar el objeto Palabra leído en la componente indice del array
                //palabras
                Palabra.copiar(palabra, palabras[indice]);
            }
        }
        //BUCLE DE TRATAMIENTO DE LOS OBJETOS Palabra CONTENIDOS EN EL ARRAY palabras
        //BASADO EN OBTENER EL NÚMERO DE APARICIONES DE CADA UNA DE LAS PALABRAS
        //REALIZANDO UN ÚNICO TRATAMIENTO DE RECORRIDO DE LECTURA DEL FICHERO
        while (fichero.hayPalabras()) {
            //lectura objeto Palabra desde el fichero
            palabra=fichero.lectura();
            //busqueda palabra leida en el array palabras
            for (int indice=0;indice<palabras.length;indice++) {
                //verificar si el objeto Palabra leído desde el fichero
                //es igual al objeto Palabra contenido en la componente
                //indice del array palabras
                if (Palabra.iguales(palabra, palabras[indice])) {
                    //incrementar contador correspondiente a la palabra
                    //contenida en la componente indice del array Palabras
                    numeroApariciones[indice]++;
                }
            }
        }

        //cierre del enlace con el fichero de texto a través del objeto fichero
        fichero.cerrarEnlaceFichero();

        //visualización resultado
        System.out.println("\nNÚMERO DE APARICIONES DE LAS PALABRAS INTRODUCIDAS POR TECLADO");
        for (int indice=0;indice<palabras.length;indice++) {
            System.out.println(palabras[indice]+": "+numeroApariciones[indice]+" apariciones.");
        }
    }
    
}
