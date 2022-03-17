/*
 * FUNCIONALIDAD: dados 2 ficheros, uno con 20 palabras, 1 en cada línea y otro 
 * del diccionario en español con la misma estructura. Se cogen 5 palabras de forma
 * aleatoria de las 20 y se indica si también se encuentran en el diccionario.
 * Existe la posibilidad de escoger si obtener las 5 palabras de forma aleatoria
 * siendo la misma y de forma que no se repitan
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 11-01-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_12_toni_frau;

import java.util.Random;

public class Ejercicio01 {
    //VARIABLES DE LA CLASE
    Random random = new Random();
    final int CANTIDAD_PALABRAS_TOTALES = 20;
    final int CANTIDAD_PALABRAS_MOSTRAR = 5;
    boolean[] palabrasDisponibles = new boolean[CANTIDAD_PALABRAS_TOTALES];
    Palabra[] palabras = new Palabra[CANTIDAD_PALABRAS_MOSTRAR];
    Palabra palabraLeida = new Palabra();
    boolean palabrasRepetidas;
    
    public static void main(String[] args) throws Exception
    {
        new Ejercicio01().metodoPrincipal();
    }
    
    //MÉTODO metodoPrincipal PARA EJECUTAR TODO EL PROGRAMA PRINCIPAL
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIÓN DE VARIABLES
        int numeroRandom;
        int indiceFichero;
        
        for (int i = 0; i < CANTIDAD_PALABRAS_TOTALES; i++) {
            palabrasDisponibles[i] = true;
            if (i < CANTIDAD_PALABRAS_MOSTRAR)
                palabras[i] = new Palabra();
        }
                        
        System.out.print("Quieres que se repitan las palabras?(si - 1 / no - 0): ");
        palabrasRepetidas = LT.readInt() == 1;
        
        
        for (int i = 0; i < CANTIDAD_PALABRAS_MOSTRAR; i++)
        {
            PalabraFicherosLectura ficheroPals = new PalabraFicherosLectura("Palabras1.txt");
            
            indiceFichero = -1;
            numeroRandom = random.nextInt(CANTIDAD_PALABRAS_TOTALES);
            while (ficheroPals.hayPalabras() && indiceFichero < numeroRandom)
            {                
                palabraLeida = ficheroPals.lectura();
                indiceFichero++;
            }
            
            if (!palabrasRepetidas)
                if (palabrasDisponibles[numeroRandom])
                    comprobarPalabra(i, numeroRandom);
                else
                    i--;
            else
                comprobarPalabra(i, numeroRandom);
            
            ficheroPals.cerrarEnlaceFichero();
        }
    }
    
    //MÉTODO comprobarPalabra QUE INDICA SI UNA PALABRA ESTÁ EN EL DICCIONARIO
    private void comprobarPalabra(int i, int rand) throws Exception
    {
        Palabra.copiar(palabraLeida, palabras[i]);
        if (contenidaEnDiccionario(palabras[i]))
            System.out.println((i+1) + ".La palabra \"" + palabras[i].toString() + "\" está en el diccionario");
        else
            System.out.println((i+1) + ".La palabra \"" + palabras[i].toString() + "\" no está en el diccionario");
        palabrasDisponibles[rand] = false;
    }
    
    //MÉTODO contenidaEnDiccionario QUE GUARDA SI UNA PALABRA ESTÁ EN EL DICCIONARIO
    private boolean contenidaEnDiccionario(Palabra pal) throws Exception
    {
        PalabraFicherosLectura ficheroDiccionario = new PalabraFicherosLectura("DiccionarioCastellano.txt");
        while (ficheroDiccionario.hayPalabras()) {
            Palabra temp = ficheroDiccionario.lectura();
            if (Palabra.iguales(temp, pal))
            {
                ficheroDiccionario.cerrarEnlaceFichero();
                return true;
            }
        }
        
        ficheroDiccionario.cerrarEnlaceFichero();
        return false;
    }
}