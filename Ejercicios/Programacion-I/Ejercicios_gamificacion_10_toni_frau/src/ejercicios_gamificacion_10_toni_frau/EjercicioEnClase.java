/*
 * Dado un fichero de texto de nombre introducido por user y pedido por el programa
 * generar 2 ficheros en los que se grabarán en el primero las palabras con más 
 * de 8 caracteres y en el 2º las palabras con menos o igual de 1 a 8 caracteres.
 *
 * NOTA: El programa se podrá ejecutar tantas veces como se desee impidiendo que
 * los datos que había en el fichero sean eliminados
 */
package ejercicios_gamificacion_10_toni_frau;


public class EjercicioEnClase {
    public static void main(String[] argumentos) throws Exception{
        new EjercicioEnClase().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        String nombreFichero;
        
        System.out.print("Introduce el nombre del fichero con palabras de 8+ caracteres(con el tipo del fichero): ");
        nombreFichero = LT.readLine();
        
        PalabraFicherosEscritura fichero1 = new PalabraFicherosEscritura(nombreFichero.toString(),true);
        
        
        System.out.print("Introduce el nombre del fichero con palabras de 1-8 caracteres(con el tipo del fichero): ");
        nombreFichero = LT.readLine();
        
        PalabraFicherosEscritura fichero2 = new PalabraFicherosEscritura(nombreFichero.toString(),true);
        
        
        Palabra palabra = new Palabra();
        System.out.print("Introducir un texto para probar: ");
        boolean escritoEnFichero1 = false, escritoEnFichero2 = false;
        while (Palabra.hayPalabras()) {            
            palabra.lectura();
            if (palabra.getNumeroCaracteres() > 8)
            {
                fichero1.escritura(palabra);
                fichero1.escrituraSeparador();
                escritoEnFichero1 = true;
            }
            else
            {
                fichero2.escritura(palabra);
                fichero2.escrituraSeparador();
                escritoEnFichero2 = true;
            }
        }
        if (escritoEnFichero1) fichero1.nuevaLinea();
        if (escritoEnFichero2) fichero2.nuevaLinea();
        
        
        fichero1.cerrarEnlaceFichero();
        fichero2.cerrarEnlaceFichero();
    }
}
