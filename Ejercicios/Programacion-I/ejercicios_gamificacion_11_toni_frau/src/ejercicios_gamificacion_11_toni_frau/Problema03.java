/*
 * FUNCIONALIDAD: dadas unas opciones como menú: 1-codificar, 2-decodificar,
 * 3-finalizar, pedir al ususario el nombre de los ficheros a leer y escribir
 * mediante entrada del teclado. Una vez dados, realizar la operación indicada 
 * en los ficheros de los nombres dados
 * FECHA DE REALIZACIÓN: 18-12-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_11_toni_frau;

public class Problema03 {
    public static void main(String[] args) throws Exception
    {
        new Problema03().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIÓN DE VARIABLES
        int operacion = 0;
        
        //ACCIONES
        //mostrar el menú con las opciones disponibles y realizar una determinada
        //operación tras indtroducir por teclado la opción escogida
        while (operacion != 3)
        {
            System.out.println("====  MENÚ ====");
            System.out.print("Introduce una operacion\n1 = codificar\n2 = decodificar\n3 = finalizar\n---> ");
            operacion = LT.readInt();
            
            if (operacion != 3)
                operar(operacion == 1);
        } 
        
        //llamada al método finalización para indicar  que se finaliza el programa
        finalizacion();
    }
        
    //método procedimiento operar que realiza la acción de codificar o decodificar
    //según el parámetro dado. Recibe por teclado los nombres de archivos a leer
    //y escribir y realiza las operaciones allí
    private void operar(boolean codificacion) throws Exception
    {
        //DECLARACIÓN DE VARIABLES
        String nombreFicheroLectura, nombreFicheroEscritura;
        PalabraFicherosLectura ficheroLectura;
        PalabraFicherosEscritura ficheroEscritura;
        Palabra palabra = new Palabra();
        
        //ACCIONES
        //recibir los nombres de los ficheros con el mensaje según la operación 
        //a realizar -> codificar / decodificar
        System.out.print("Introduce el nombre del fichero ");
        if (codificacion) System.out.print("a codificar: ");
        else System.out.print("codificado: ");
        nombreFicheroLectura = LT.readLine();
        
        System.out.print("Introduce el nombre del fichero ");
        if (codificacion) System.out.print("codificado: ");
        else System.out.print("descodificado: ");
        nombreFicheroEscritura = LT.readLine();
        
        //inicialización de los ficheros de lectura y escritura con los nombres dados
        ficheroLectura = new PalabraFicherosLectura(nombreFicheroLectura);
        ficheroEscritura = new PalabraFicherosEscritura(nombreFicheroEscritura);
        
        //leer cada palabra del archivo de lectura y dependiendo de la operación
        //a realizar -> codificar / decodificar, escribirla en le archivo de
        //escritura con la operación realiazda
        while (ficheroLectura.hayPalabras())
        {
            palabra = ficheroLectura.lectura();
            if (codificacion)
                palabra.codificar();
            else
                palabra.decodificar();
            ficheroEscritura.escritura(palabra);
            
            ficheroEscritura.escrituraSeparador();
        }
        //cerrar los enlaces de los ficheros
        ficheroLectura.cerrarEnlaceFichero();
        ficheroEscritura.cerrarEnlaceFichero();
        
        System.out.println("\n");
    }
    
    //método procedimiento finalización que indica que el programa ha finalizado
    private void finalizacion()
    {
        System.out.println("    ·   ·   ·   ·\nEl programa ha finalizado.");
    }
}
