/*
 * dadas 10 palabras entroducidas por teclado acabada en punto y un fich de texto visualizar el num
 * de apariciones de cada una de las palabras ntroducidas de la secuencia en el fichero
 */
package ejercicios_gamificacion_10_toni_frau;

public class EjercicioClase2 {
    public static void main(String[] argumentos) throws Exception
    {
        new EjercicioClase2().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception
    {
        final int CANTIDAD_PALABRAS = 10;
        Palabra palabra = new Palabra();
        Palabra palabrasUsuario[] = new Palabra[CANTIDAD_PALABRAS];
        int[] contadorPalabras = new int[CANTIDAD_PALABRAS];        
        
        for (int i = 0; i < CANTIDAD_PALABRAS; i++){
            palabrasUsuario[i] = new Palabra();
            contadorPalabras[i] = 0;
            if (Palabra.hayPalabras()) {
                palabrasUsuario[i].lectura();
            }
        }
        
        PalabraFicherosLectura fichero = new PalabraFicherosLectura("palabras.txt");
        
        while (fichero.hayPalabras()){
        
            palabra = fichero.lectura();
            int[] validacion = palabraEstaEn(palabra, palabrasUsuario);
            if (validacion[0] == 1){
                contadorPalabras[validacion[1]]++;
            }
        }
        
        for (int i = 0; i < CANTIDAD_PALABRAS; i++)
            System.out.println("La palabra " + palabrasUsuario[i].toString() + " "
                    + "aparece \t\t" + contadorPalabras[i] + " veces.");
        fichero.cerrarEnlaceFichero();
    }
    
    private int[] palabraEstaEn(Palabra palabra, Palabra[] listaPalabras)
    {
        for (int i = 0; i < listaPalabras.length; i++) {
            if (Palabra.iguales(palabra, listaPalabras[i]))
                return new int[]{1,i};
        }
        return new int[]{0,0};
    }
}