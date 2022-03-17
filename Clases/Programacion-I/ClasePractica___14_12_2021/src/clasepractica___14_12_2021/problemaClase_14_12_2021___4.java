/*
Dado un fichero de texto, de nombre introducido por el usuario a petición del
programa, genera 3 ficheros:
palabrasVocales.txt --> en él se grabarán todas las palabras del fichero de entrada
que estén constituidas por caracteres vocales.
palabrasConsonantes.txt --> en él se grabarán todas las palabras del fichero de entrada
que estén constituidas por caracteres consonantes.
restoDePalabras.txt --> en él se grabarán el resto de palabras del fichero de 
entrada.

noat: los ficheros de entrada no deben ser eliminados en caso que existan previamente.
 */
package clasepractica___14_12_2021;

public class problemaClase_14_12_2021___4 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new problemaClase_14_12_2021___4().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración objeto PalabraFicherosLectura para porder leer objetos 
        //Palabra desde un fichero de texto
        PalabraFicherosLectura ficheroIn;
        //declaración objeto PalabraFicherosEscritura para poder escribir
        //objetos Palabra en un fichero de texto
        PalabraFicherosEscritura ficheroOut1,ficheroOut2,ficheroOut3;
        //declaración objeto Palabra
        Palabra palabra=new Palabra(); 
        //declaración String para almacenar el nombre de fichero introducido
        //por el usuario
        String nombreFichero;
        
        //ACCIONES
        //mensaje usuario para introducir el nombre del fichero de lectura
        System.out.print("INTRODUCIR NOMBRE DE FICHERO: ");
        //lectura desde el teclado del nombre del fichero
        nombreFichero=LT.readLine();
        //instanciación del objeto PalabraFicherosLectura ficheroIn para establecer
        //el enlace con el fichero, cuyo nombre ha sido introducido por el usuario,
        //en modo lectura a través del objeto ficheroIn
        ficheroIn=new PalabraFicherosLectura(nombreFichero);        
        //instanciación objeto PalabraFicherosEscritura ficheroOut1 para establecer
        //el enlace con el fichero de texto palabrasVocales.txt en modo escritura a
        //nivel de objetos Palabra
        ficheroOut1=new PalabraFicherosEscritura("palabrasVocales.txt");
        //instanciación objeto PalabraFicherosEscritura ficheroOut2 para establecer
        //el enlace con el fichero de texto palabrasConsonantes.txt en modo escritura a
        //nivel de objetos Palabra
        ficheroOut2=new PalabraFicherosEscritura("palabrasConsonantes.txt");
        //instanciación objeto PalabraFicherosEscritura ficheroOut3 para establecer
        //el enlace con el fichero de texto restoDePalabras.txt en modo escritura a
        //nivel de objetos Palabra
        ficheroOut3=new PalabraFicherosEscritura("restoDePalabras.txt");
        //BUCLE DE TRATAMIENTO DE RECORRIDO DE LECTURA DESDE EL FICHERO DE ENTRADA
        //Y ESCRITURA EN LOS FICHEROS DE SALIDA SEGÚN EL TRATAMIENTO
        while (ficheroIn.hayPalabras()) {
            //lectura objeto Palabra desde el fichero de entrada a través del
            //objeto fichero1
            palabra=ficheroIn.lectura();
            //tratamiento objeto Palabra leído
            if (palabra.numeroVocales()==palabra.getNumeroCaracteres()) {
                //escribir objeto Palabra leído en el fichero palabrasVocales.txt
                ficheroOut1.escritura(palabra);
                //grabar salto de linea en el fichero palabrasVocales.txt
                ficheroOut1.nuevaLinea();
            }
            else {
                if (palabra.numeroConsonantes()==palabra.getNumeroCaracteres()) {
                    //escribir objeto Palabra leído en el fichero palabrasConsonantes.txt
                    ficheroOut2.escritura(palabra);
                    //grabar salto de linea en el fichero palabrasConsonantes.txt
                    ficheroOut2.nuevaLinea();
                }
                else {
                    //escribir objeto Palabra leído en el fichero restoDePalabras.txt
                    ficheroOut3.escritura(palabra);
                    //grabar salto de linea en el fichero restoDePalabras.txt
                    ficheroOut3.nuevaLinea();                    
                }
            }
        }
        //cierre enlaces ficheros
        ficheroIn.cerrarEnlaceFichero();
        ficheroOut1.cerrarEnlaceFichero();
        ficheroOut2.cerrarEnlaceFichero();
        ficheroOut3.cerrarEnlaceFichero();  
    }   
}