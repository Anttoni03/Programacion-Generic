import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FicheroControlHistorico {
    
    private boolean escritura;
    BufferedReader lector;
    BufferedWriter escritor;
    
    public FicheroControlHistorico(boolean esc, String ruta) throws Exception
    {
        escritura = esc;
        if (escritura)
        {
            escritor = new BufferedWriter(new FileWriter(ruta,true));
        }
        else
        {
            lector = new BufferedReader(new FileReader(ruta));
        }
    }
    
    public void guardarRegistro(char[] nombre, int punt) throws Exception
    {
        DateTimeFormatter formatoTiempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        char[] tiempo = (formatoTiempo.format(LocalDateTime.now())).toCharArray();
        char[] puntos = separarNumero(punt);
        for (int indice = 0; indice < tiempo.length; indice++)
        {
            escritor.write(tiempo[indice]);
        }
        escritor.write("\tNombre: ");
        for (int indice = 0; indice < nombre.length; indice++) {
            escritor.write(nombre[indice]);
        }
        escritor.write("\tPuntos: ");
        for (int indice = 0; indice < puntos.length; indice++) {
            escritor.write(puntos[indice]);
        }
        escritor.write("\n");
    }
    
    private char[] separarNumero(int num)
    {
        char[] digitos = new char[12];
        int aux = Math.abs(num), aux2;
        int contador = 0;
        boolean negativo = num < 0;
        boolean primerNoCero = false;
        for (int i = digitos.length-1; i >=0; i--) {
            aux2 = aux/(int)Math.pow(10, i);
            aux -= aux2 * Math.pow(10, i);
            digitos[digitos.length-1-i] = (char)(aux2+(int)'0');
            if (!primerNoCero && digitos[digitos.length-1-i] != '0')
            {
                primerNoCero = true;
            }
            if (primerNoCero)
            {
                contador++;
            }
        }
        char[] digitosFinal;
        if (!negativo)
        {
            digitosFinal = new char[contador];
            for (int i = digitos.length-contador, j = 0; i < digitos.length; i++,j++) {
                digitosFinal[j] = digitos[i];
            }
        }
        else
        {
            digitosFinal = new char[contador+1];
            digitosFinal[0] = '-';
            for (int i = digitos.length-contador , j = 1; i < digitos.length; i++,j++) {
                digitosFinal[j] = digitos[i];
            }
        }
        return digitosFinal;
    }
    
    public void recuperarRegistros() throws Exception
    {
        int codigoLeido = ' ';
        System.out.println("Registros: ");
        while (codigoLeido != -1) {            
            System.out.print((char)codigoLeido);
            codigoLeido = lector.read();
        }
    }
    
    public void cerrarEnlace() throws Exception
    {
        if (escritura)
        {
            escritor.close();
        }
        else
        {
            lector.close();
        }
    }
}
