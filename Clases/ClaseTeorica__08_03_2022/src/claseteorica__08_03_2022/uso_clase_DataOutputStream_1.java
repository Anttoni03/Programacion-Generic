package claseteorica__08_03_2022;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
FUNCIONALIDAD: crea los ficheros ficheroEnteros.dat, ficheroReales.dat, 
ficheroCaracteres.dat y ficheroBooleanos.dat
en base a grabar en ellos 26 elementos en cada uno de ellos del tipo primitivo 
correspondiente.
OBJETIVOS:
    - uso de la clase DataOutputStream.
autor: Juan Montes de Oca
 */

public class uso_clase_DataOutputStream_1 {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new uso_clase_DataOutputStream_1().metodoPrincipal();
    }    
    
    //declaración metodoPrincipal
    public void metodoPrincipal() throws Exception {    
        //DECLARACIONES
        //declaración constante que representa el número de elementos a garbar en cada fichero
        final int NUMERO_ELEMENTOS=26;
        //declaración objeto DataOutputStream para posibilitar la escritura de un
        //fichero a nivel de enteros
        DataOutputStream ficheroEnteros;
        //declaración objeto DataOutputStream para posibilitar la escritura de un
        //fichero a nivel de reales
        DataOutputStream ficheroReales;
        //declaración objeto DataOutputStream para posibilitar la escritura de un
        //fichero a nivel de caracteres
        DataOutputStream ficheroCaracteres;
        //declaración objeto DataOutputStream para posibilitar la escritura de un
        //fichero a nivel de booleanos
        DataOutputStream ficheroBooleanos;
        //declaración variable entera para representar los valores enteros a escribir
        //en el fichero ficheroEnteros
        int entero;
        //declaración variable real para representar los valores reales a escribir
        //en el fichero ficheroReales
        double real;
        //declaración variable caracter para representar los valores caracteres a escribir
        //en el fichero ficheroCaracteres
        char caracter;
        //declaración variable booleana para representar los valores booleanos a escribir
        //en el fichero ficheroBooleanos
        boolean booleano; 
        
        //ACCIONES
        try {
            //instanciación objeto DataOutputStream fichero para enlazar con fichero
            //ficheroEnteros.dat
            ficheroEnteros=new DataOutputStream(new BufferedOutputStream(
                                 new FileOutputStream("ficheroEnteros.dat")));
            //instanciación objeto DataOutputStream fichero para enlazar con fichero
            //ficheroReales.dat
            ficheroReales=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("ficheroReales.dat")));
            //instanciación objeto DataOutputStream fichero para enlazar con fichero
            //ficheroCaracteres.dat
            ficheroCaracteres=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("ficheroCaracteres.dat")));
            //instanciación objeto DataOutputStream fichero para enlazar con fichero
            //ficheroBooleanos.dat
            ficheroBooleanos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("ficheroBooleanos.dat")));
            try {
                //bucle de escritura en los ficheros
                for (int indice=0; indice<NUMERO_ELEMENTOS; indice++) {
                    //grabación entero de valor indice en el fichero ficheroEnteros.dat
                    ficheroEnteros.writeInt(indice);
                    //grabación real de valor indice en el fichero ficherosReales.fat
                    ficheroReales.writeDouble((double) indice);
                    //grabación caracter de valor (codigo caracter 'a' + indice) en el fichero ficheroCaracteres.dat
                    ficheroCaracteres.writeChar(((int) 'a'+indice));
                    //grabación booleano de valor true si indice es par y false si indice es impar
                    if (indice%2==0) {
                        ficheroBooleanos.writeBoolean(true);
                    }
                    else {
                        ficheroBooleanos.writeBoolean(false);
                    }
                }
            }catch (IOException error) {
                System.out.println(error.toString());
            }catch (Exception error) {
                System.out.println(error.toString());
            }finally {
                try {
                    //cierre del enlace ficheros
                    ficheroEnteros.close();
                    ficheroReales.close();
                    ficheroCaracteres.close();
                    ficheroBooleanos.close();                 
                }catch (IOException error) {
                    System.out.println(error.toString());
                }            
            }
        }catch (FileNotFoundException error) {
                System.out.println(error.toString());
        }catch (Exception error) {
                    System.out.println(error.toString());          
        }
    }
}
