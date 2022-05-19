/*
CLASE FicheroPalabrasInOut contiene las declaraciones y funcionalidades que posibilitan
la gestión de un fichero de objetos Palara tanto a nivel de lectura como
de escritura utilizando la clase RandomAccessFile

PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
 */
package busquedaordenacion;


import java.io.*;

public class FicheroPalabrasInOut {
    //DECLARACIÓN DE ATRIBUTOS
    //Objeto RandomAccesFile
    private RandomAccessFile fichero =null;
    //atributo que representa el número de objetos Palabra contenidos
    //en el fichero enlazado con el objeto RandomAccessFile
    private int numPalabras;
    //atributo que representará el número de palabras leidas utilizando
    //la lectura secuencial
    private int numObjetosPalabrasLeidos=0;

    //CONTSRUCTOR
    public FicheroPalabrasInOut(String nombreFichero) {
        try {
            fichero = new RandomAccessFile(nombreFichero,"rw");
            numPalabras= (int) (fichero.length()/Palabra.getDimension());
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: "+error.toString());
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //MÉTODOS FUNCIONALES
    
    //lleva a cabo la lectura desde el fichero del objeto Palabra cuyo orden
    //sea el dado por parámetro
    public Palabra lectura(int orden) {
        Palabra palabra=new Palabra();
        try {
            if (orden*Palabra.getDimension()<(fichero.length())) {
                fichero.seek(orden*Palabra.getDimension());
                palabra.setCaracteres(lecturaArrayCaracteres());
                palabra.setNumCaracteres(fichero.readInt());

            }
            else {
                palabra=null;
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return palabra; 
    }
    
    //lleva a cabo la lectura secuencial desde el fichero de objetos Palabra  
    public Palabra lectura() {
        Palabra palabra=new Palabra();
        try {
            if ((numObjetosPalabrasLeidos*Palabra.getDimension())<(fichero.length())) {
                palabra.setCaracteres(lecturaArrayCaracteres());
                palabra.setNumCaracteres(fichero.readInt());
                numObjetosPalabrasLeidos++;
            }
            else {
                palabra=null;
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return palabra;
    }

    //lleva a cabo la escritura del objeto Palabra dado en el fichero.
    public void escritura(Palabra pal) {
        try {
            //escritura de los caracteres del objeto Palabra en el fichero
            escrituraArrayCaracteres(pal);
            //escritura del número de caracteres del objeto Palabra en el fichero
            fichero.writeInt(pal.getNumCaracteres());
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //lleva a cabo la escritura del objeto Palabra dado en el fichero en el
    //orden indicado
    public void escritura(Palabra pal,int orden)  {
        try {
            if ((orden*Palabra.getDimension())<(fichero.length())) {
                //posicionamiento apuntador del fichero 
                fichero.seek(orden*Palabra.getDimension());
                //escritura de los caracteres del objeto Palabra en el fichero
                escrituraArrayCaracteres(pal);
                //escritura del número de caracteres del objeto Palabra en el fichero
                fichero.writeInt(pal.getNumCaracteres());            
            }            
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
  
    public void cierre() throws Exception {
        fichero.close();
    }
    
    public int getNumPalabras() {
        return numPalabras;
    }
    
    public char [] lecturaArrayCaracteres() {
        char [] tmp=new char[Palabra.getMaximoNumeroCaracteres()];
        try {
            for (int i=0;i<tmp.length;i++) {
                tmp[i]=fichero.readChar();
            } 
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return tmp;
    }
    
    public void escrituraArrayCaracteres(Palabra pal) {
        char espacio=' ';
        int i;
        try {
            for (i=0;i<pal.getNumCaracteres();i++) {
                fichero.writeChar(pal.getCaracter(i));
            }
            if (pal.getNumCaracteres()<Palabra.getMaximoNumeroCaracteres()) {
                for (;i<Palabra.getMaximoNumeroCaracteres();i++) {
                    fichero.writeChar(espacio);
                }
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
}
    
