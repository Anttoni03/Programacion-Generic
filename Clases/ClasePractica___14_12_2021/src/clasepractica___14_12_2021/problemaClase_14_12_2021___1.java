/*
Dado un fichero de texto, de nombre entrada.txt, lleva a cabo la grabación 
de las palabras que tengan las 5 vocales, contenidas en dicho fichero, en un
fichero de texto, de nombre salida1.txt, y el resto de palabras en otro
fichero de texto, de nombre salida2.txt.
Las palabras serán grabadas cada una en una línea.
NOTA: el contenido prevío de los ficheros de salida no debe ser eliminado al
ejecutarse este programa, es decir, ambos ficheros deben ser instanciados
con el constructor de la clase PalabraFicherosEscritura que posibilita añadir
en el fichero objetos Palabra.
 */
package clasepractica___14_12_2021;

public class problemaClase_14_12_2021___1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new problemaClase_14_12_2021___1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para porder leer objetos 
        //Palabra desde un fichero de texto
        PalabraFicherosLectura fichero1;
        //declaración objetos PalabraFicherosEscritura para poder escribir
        //objetos Palabra en ficheros de texto
        PalabraFicherosEscritura fichero2,fichero3;
        //declaración objeto Palabra
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //instanciación objeto PalabraFicherosLectura fichero1 para establecer el
        //enlace con el fichero de texto entrada.txt en modo lectura a nivel
        //de objetos Palabra
        fichero1=new PalabraFicherosLectura("entrada.txt");
        //instanciación objeto PalabraFicherosEscritura fichero2 para establecer
        //el enlace con el fichero de texto salida1.txt en modo escritura a
        //nivel de objetos Palabra
        fichero2=new PalabraFicherosEscritura("salida1.txt",true);
        //instanciación objeto PalabraFicherosEscritura fichero3 para establecer
        //el enlace con el fichero de texto salida2.txt en modo escritura a
        //nivel de objetos Palabra
        fichero3=new PalabraFicherosEscritura("salida2.txt",true);
        //BUCLE DE TRATAMIENTO DE RECORRIDO DE LECTURA DESDE EL FICHERO entrada.txt
        //Y ESCRITURA EN LOS FICHEROS salida1.txt Y salida2.txt
        while (fichero1.hayPalabras()) {
            //lectura objeto Palabra desde el fichero entrada.txt a través del
            //objeto fichero1
            palabra=fichero1.lectura();
            //tratamiento objeto Palabra leído
            if (palabra.tieneLasCincoVocales()) {
                //escribir palabra en el fichero salida1.txt
                fichero2.escritura(palabra);
                //escribir salto de linea en el fichero salida1.txt
                fichero2.nuevaLinea();
            }
            else {
                //escribir palabra en el fichero salida2.txt
                fichero3.escritura(palabra);
                //escribir salto de linea en el fichero salida2.txt
                fichero3.nuevaLinea();                
            }
        }
        //cierre enlaces ficheros
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero();
        fichero3.cerrarEnlaceFichero();        
    }
    
}
