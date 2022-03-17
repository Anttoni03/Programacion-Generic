/*
FUNCIONALIDAD: lleva a cabo la codificación/decodificación de un fichero
dado en función de la opción elegida por el usuario a través de un menu.
EL resultado será la generación de un fichero de texto.
Los nombres de los ficheros serán introducidos por el usuario.

NOTA: UTILIZACIÓN CLASE CodificacionAlfabetica
 */
package clase_practica_____21_12_2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CodificarDecodificarFichero {
    //DECLARACIÖN ATRIBUTOS
    //declaración atributos String para representar los nombres
    //de los ficheros que entran en juego
    private String nombreFichero1,nombreFichero2;
    //declaración atributo entero para representar desplazamiento
    //del alfabeto para la codificacion/decodificación
    private int desplazamiento=5; //por defecto tendrá el valor 5.
    
    //declaración método main
    public static void main( String args[] ) throws Exception {
        new CodificarDecodificarFichero().programaPrincipal();
    }
    
    //declaración método programaPrincipal
    public void programaPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable booleana para gestionar la salida
        //del bucle del menu
        boolean fin=false;
        //Bucle del menu
        while (!fin) {
            //borrado de la ventana de salida
            borrarPantalla();
            //visualización menu
            menu();
            //lectura opción elegida
            int opcion = LT.readInt();
            //gestión opción elegida
            switch (opcion) {
                case 1:
                    codificacioDecodificacion(1);
                    break;
                case 2:
                    codificacioDecodificacion(2);
                    break;
                default: fin=true;
            }
        }
    }
    
    //MÉTODO borrarPantalla lleva a cabo el borrado de la pantalla a 
    //través de sucesivos saltos de línea
    private void borrarPantalla() {       
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    //método menu
    private void menu() {
        //visualización menu
        System.out.println("\n                     MENU ");
        System.out.println("       (1) CODIFICACIÓN.");
        System.out.println("       (2) DECODIFICACIÓN.");
        System.out.println("       (3) SALIR.");
        System.out.println("\n  ");
        System.out.print("         [] opcion --> ");        
    }
    
    //MÉTODO codificacioDecodificacion LLEVA A CABO CODIFICACIÓN/DECODIFICACIÓN
    //DE UN FICHERO GENERANDO OTRO COMO RESULTADO. EL PARÁMETRO ENTERO
    //INDICARÁ QUÉ OPERACIÓN SE HA DE LLEVAR A CABO: CODIFICACIÓN O DECODIFICACIÓN
    private void codificacioDecodificacion(int operacion) throws Exception {
        //declaración constante entera para representar final de fichero
        //de texto
        final int FINAL_FICHERO=-1;
        //declaración objeto BufferedReader para posibilitar la lectura de
        //un fichero de texto a nivel de caracteres
        BufferedReader fichero1;
        //declaración objeto BufferedWriter para posibilitar la escritura de
        //un fichero de texto a nivel de caracteres
        BufferedWriter fichero2;
        //declaración objeto CodificacionAlfabetica para llevar a cabo la
        //codificación
        CodificacionAlfabetica codificacion;
        //declaración variable entera para representar código de caracter
        //leido desde el fichero de texto
        int codigo;  
        
        //ACCIONES
        //solitud nombres de ficheros
        solitudNombresFicheros(operacion);
        //establecimiento enlace con fichero texto.txt a través del objeto BufferedReader
        fichero1=new BufferedReader(new FileReader(nombreFichero1));
        //establecimient enlace con fichero textoCodificado.txt a través del objeto
        //BufferedWriter
        fichero2=new BufferedWriter(new FileWriter(nombreFichero2));
        //instanciación objeto CodificacionAlfabetica 
        codificacion=new CodificacionAlfabetica(desplazamiento);
        //lectura primer codigo caracter desde el fichero
        codigo=fichero1.read();
        //BUCLE DE LECTURA DESDE EL FICHERO DE ENTRADA Y ESCRITURA EN EL FICHERO
        //DE SALIDA
        while (codigo!=FINAL_FICHERO) {   
            char caracter=(char) codigo;
            //codificar/decodificar caracter 
            switch (operacion) {
                case 1 : caracter=codificacion.codificar((char) codigo);break;
                case 2 : caracter=codificacion.deCodificar((char) codigo);break;
            }
            //escritura en el fichero de salida del caracter correspondiente
            fichero2.write(caracter);

            //lectura siguiente código de caracter desde el fichero
            codigo=fichero1.read();
        }
        //cierre de enlaces con ficheros
        fichero1.close();
        fichero2.close();
    }
    
    //MÉTODO solitudNombresFicheros QUE LLEVA A CABO LA SOLITUD AL USUARIO
    //DE LOS NOMBRES DE LOS FICHEROS QUE ENTRAN EN JUEGO
    private void solitudNombresFicheros(int operacion) throws Exception {
        borrarPantalla();
        switch (operacion) {
            case 1: System.out.println("NOMBRE DEl FICHERO A CODIFICAR: ");
                    nombreFichero1=LT.readLine();
                    System.out.println("NOMBRE DEl FICHERO CODIFICADO: ");
                    nombreFichero2=LT.readLine();
                    break;
            case 2: System.out.println("NOMBRE DEl FICHERO A DECODIFICAR: ");
                    nombreFichero1=LT.readLine();
                    System.out.println("NOMBRE DEl FICHERO DECODIFICADO: ");
                    nombreFichero2=LT.readLine();
                    break;                               
        }
    }
   
}
