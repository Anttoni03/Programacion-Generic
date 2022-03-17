/*
Dado un fichero de texto, de nombre introducido por teclado a petición del
programa, genera dos ficheros, en el primero grabará las palabras contenidas
en el fichero de entrada que tengan de 1 a 8 carateres y, en el segundo fichero,
grabará las palabras que tengan de 9 a 20 caracteres.
Los ficheros de salida no deben ser eliminados al ejecutarse el programa, es decir,
el enlace con estos ficheros se debe realizar utilizando el constructor de adición
de la clase PalabraFicherosEscritura.
 */
package clasepractica___14_12_2021;

public class problemaClase_14_12_2021___2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new problemaClase_14_12_2021___2().metodoPrincipal();
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
        //declaración de String para almacenar el nombre del fichero introducido
        //por teclado
        String nombreFichero;
 
        
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
        //el enlace con el fichero de texto palabras_1_8.txt en modo escritura a
        //nivel de objetos Palabra
        fichero2=new PalabraFicherosEscritura("palabras_1_8.txt",true);
        //instanciación objeto PalabraFicherosEscritura fichero3 para establecer
        //el enlace con el fichero de texto palabras_9_20.txt en modo escritura a
        //nivel de objetos Palabra
        fichero3=new PalabraFicherosEscritura("palabras_9_20.txt",true);
        //BUCLE DE TRATAMIENTO DE RECORRIDO DE LECTURA DESDE EL FICHERO entrada.txt
        //Y ESCRITURA EN LOS FICHEROS palabras_1_8.txt Y palabras_9_20.txt
        while (fichero1.hayPalabras()) {
            //lectura objeto Palabra desde el fichero de entrada a través del
            //objeto fichero1
            palabra=fichero1.lectura();
            //tratamiento objeto Palabra leído
            if (palabra.getNumeroCaracteres()<=8) {
                //escribir palabra en el fichero palabras_1_8.txt
                fichero2.escritura(palabra);
                //escribir salto de linea en el fichero palabras_1_8.txt
                fichero2.nuevaLinea();
            }
            else {
                //escribir palabra en el fichero palabras_9_20.txt
                fichero3.escritura(palabra);
                //escribir salto de linea en el fichero palabras_9_20.txt
                fichero3.nuevaLinea();                
            }
        }
        //cierre enlaces ficheros
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero();
        fichero3.cerrarEnlaceFichero();        
    }
    
}
