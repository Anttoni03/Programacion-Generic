/*
FUNCIONALIDAD: funcionalidades para llevar a cabo la lectura de datos desde el teclado
 */
package complejidadalgoritmica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LT {

    private static char[] secuencia;
    private static int indice = 0;

    private static char[] readln() {
        String res = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
            res = br.readLine();
        } catch (IOException e) {
        }
        return res.toCharArray();
    }

    public static char readCharacterSequence() {
        int elemento = 0;
        if (indice == 0) {
            secuencia = readln();
        }
        elemento = indice;
        indice = (secuencia[indice] == '.') ? 0 : (indice + 1);
        return (secuencia[elemento]);

    }

    public static Integer readInt() {
        Integer res = 0;
        try {
            char[] pal = readln();
            res = Integer.parseInt(new String(pal));
        } catch (NumberFormatException e) {
            res = null;
        }
        return res;
    }

    public static Double readReal() {
        Double res = 0.0;
        try {
            char[] pal = readln();
            res = Double.parseDouble(new String(pal));
        } catch (NumberFormatException e) {
            res = null;
        }
        return res;
    }

    public static String readLine() {
        String res;
        char[] pal = readln();
        res = new String(pal);
        return res;
    }

    public static Character readCharacter() {
        Character res;
        char[] pal = readln();
        String s = new String(pal);
        if (s.length() == 0) {
            res = null;
        } else {
            res = new Character(s.charAt(0));
        }
        return res;
    }

}
