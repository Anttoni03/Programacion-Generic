/*
3. Realizar un programa que a través de un menú pueda llevar a término las siguientes
funcionalidades:
1. Codificación.
2. Decodificación.
3. Finalizar.
Funcionalidad Codificación: el programa solicitará al usuario el nombre del fichero a codificar y el
nombre del fichero resultante de la codificación. Una vez terminada la funcionalidad el programa
volverá al menú general.
Funcionalidad Decodificación: el programa solicitará al usuario el nombre del fichero a decodificar
y el nombre del fichero resultante de la decodificación. Una vez terminada la funcionalidad el
programa volverá al menú general.
Funcionalidad Finalizar: se finalizará la ejecución del programa.
 */
package clase_practica_____21_12_2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class Actividad_11__Gamificacion__problema_3 {
    public static void main(String [] argumentos) throws Exception {
        new Actividad_11__Gamificacion__problema_3().metodoPrincipal();
    }
    
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        boolean fin=false;
        int opcion;        
        
        //ACCIONES
        while (!fin) {
            menu();
            //lectura opción
            opcion=LT.readInt();
            switch (opcion) {
                case 1: tratamiento(opcion);break;
                case 2: tratamiento(opcion);break;
                case 3: fin=true;
            }    
        }   
    }
    
    //método que lleva a cabo la codificación de un caracter dado
    public void tratamiento(int operacion) throws Exception {
        //DECLARACIONES
        final char [] ALFABETO="abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char  [] ALF_COD="defghijklmnopqrstuvwxyzabc".toCharArray();
        String nombreFichero1,nombreFichero2;
        BufferedReader fichero1;
        BufferedWriter fichero2;
        int codigo;
        final int FINAL_FICHERO=-1;
        final int ESPACIO=(int) ' ';
        
        //ACCIONES
        System.out.print("NOMBRE FICHERO DE ENTRADA: ");
        nombreFichero1=LT.readLine();
        System.out.print("NOMBRE FICHERO DE SALIDA: ");
        nombreFichero2=LT.readLine();
        fichero1=new BufferedReader(new FileReader(nombreFichero1));
        fichero2=new BufferedWriter(new FileWriter(nombreFichero2));
        codigo=fichero1.read();
        while (codigo!=FINAL_FICHERO) {
            if (codigo!=ESPACIO) {
                if (operacion==1) {
                    codigo=codificacionDecodificacion(ALFABETO,ALF_COD,(char) codigo);
                }
                else  {
                    codigo=codificacionDecodificacion(ALF_COD,ALFABETO,(char) codigo);
                }
                
            }
            fichero2.write(codigo);
            codigo=fichero1.read();
        }
        fichero1.close();
        fichero2.close();
    }

    public int codificacionDecodificacion(char [] ALF1, char [] ALF2, char caracter) {
        
        //ACCIONES
        //búsqueda en ALFABETO el caracter dado
        int indice=0;
        while (caracter!=ALF1[indice]) {
            indice++;
        }
        //retornar caracter codificado correspondiente
        return (int) ALF2[indice];        
    }    
    private void menu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("                CODIFICACIÓN/DECODIFICACIÓN\n");
        System.out.println("         [1] CODIFICACIÓN.");
        System.out.println("         [2] DECODIFICACIÓN.");
        System.out.println("         [1] FINALIZACIÓN.");
        System.out.println("\n\n         [OPCIÓN] --> ");     
    }
    
}

