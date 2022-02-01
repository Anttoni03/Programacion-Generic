//Antoni Frau Gordiola
//Alejandro Sánchez Sayes
package practicafinalscrabble;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FicheroControlHistorico {
    
    //DECLARACIÓN DE LOS ATRIBUTOS
    //atributo de objeto que indica si el modo de funcionamiento del objeto es
    //de lectura o escritura
    private boolean escritura;
    //atributo de objeto que estará en uso si se decide que el modo de funcionamiento
    //es de lectura
    private BufferedReader lector;
    //atributo de objeto que estará en uso si se decide que el modo de funcionamiento
    //es de escritura
    private BufferedWriter escritor;
    
    //MÉTODOS
    //método constructor que instancia el objeto indicando si el modo de
    //funcionamiento es de lectura o escritura y la ruta del fichero
    public FicheroControlHistorico(boolean esc, String ruta) throws Exception
    {
        //se instancia el objeto dependiendo del booleano dado
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
    
    //método guardarRegistro que escribe en el fichero de registros históricos
    //la fecha y hora y el nombre, la puntuación y los turnos dados
    public void guardarRegistro(char[] nombre, int punt, int turn) throws Exception
    {
        //DECLARACIONES
        //aplicar el formato para visualizar la fecha y hora
        DateTimeFormatter formatoTiempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        //aplicar el formato para obtener la fecha y hora como cadena de caracteres
        char[] tiempo = (formatoTiempo.format(LocalDateTime.now())).toCharArray();
        //obtener la puntuación dada en forma de cadena de caracteres
        char[] puntos = separarNumero(punt);
        //obtener los turnos dados en forma de cadena de caracteres
        char[] turnos = separarNumero(turn);
        //escribe en el fichero la fecha y hora
        for (int indice = 0; indice < tiempo.length; indice++)
        {
            escritor.write(tiempo[indice]);
        
        }
        //escribe en el fichero el nombre del usuario
        escritor.write("\tNombre: ");
        for (int indice = 0; indice < nombre.length; indice++) {
            escritor.write(nombre[indice]);
        }
        //escribe en el fichero la puntuación final
        escritor.write("\tPuntos: ");
        for (int indice = 0; indice < puntos.length; indice++) {
            escritor.write(puntos[indice]);
        }
        //escribe en el fichero la cantidad de turnos
        escritor.write(" en ");
        for (int indice = 0; indice < turnos.length; indice++) {
            escritor.write(turnos[indice]);
        }
        escritor.write(" turnos.");
        escritor.write("\n");
    }
    
    //método separarNumero que devuleve los dígitos de un número entero dado
    //como componentes de una cadena de caracteres, incluído el símbolo de un
    //número negativo
    private char[] separarNumero(int num)
    {
        //DECLARACIONES
        //cadena de caracteres con 12 dígitos como máximo
        char[] digitos = new char[12];
        //números auxiliares para los cálculos intermedios
        int aux = Math.abs(num), aux2;
        //contador para las posiciones de los dígitos
        int contador = 0;
        //indicador de si el número dado es o no negativo
        boolean negativo = num < 0;
        //indicador booleano para saber se si ha encontrado el primer no cero
        boolean primerNoCero = false;
        //cadena final con la dimensión más reducida que necesita
        char[] digitosFinal;
        
        //ACCIONES
        //bucle para completar la cadena de caracteres con los dígitos
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
        //indicaciones para simplificar la cadena final según si el entero dado
        //es o no negativo
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
        //devuelve los dígitos finales
        return digitosFinal;
    }
    
    //método recuperarRegistros que imprime por pantalla el fichero de registros
    //históricos en el caso de que el modo de funcionamiento sea lectura
    public void recuperarRegistros() throws Exception
    {
        //DECLARACIONES
        //indicador del código leído del fichero
        int codigoLeido = lector.read();
        
        //ACCIONES
        //Impresión del fichero de registros
        System.out.println("Registros: ");
        while (codigoLeido != -1) {            
            System.out.print((char)codigoLeido);
            codigoLeido = lector.read();
        }
    }
    
    //método cerrarEnlace para cerrar el enlace con el fichero de registros
    //históricos dependiendo del modo de funcionamiento
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