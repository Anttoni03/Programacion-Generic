/*
CLASE Palabra

PROGRAMACIÓN II
JUAN MONTES DE OCA
UNIVERSITAT DE LES ILLES BALEARS
 */
package busquedaordenacion;

public class Palabra {
    private static final int DIMENSION=40+4;
    private static final int MAXIMO = 20;
    private static char caracter=' ';
    private static final char FINAL_SECUENCIA='.';
    private static final char ESPACIO=' ';
    private char caracteres []=new char[MAXIMO];
    private int numCaracteres;

    public Palabra() {
     numCaracteres=0;
    }
    
    public Palabra(String pal) {
        numCaracteres=pal.length();
        caracteres=pal.toCharArray();
    }
    
    public Palabra(char [] car,int num) {
        caracteres=car;
        numCaracteres=num;
    }
    
    @Override
    public String toString() {
        String pal="";
        for (int i=0;i<numCaracteres;i++) pal=pal+caracteres[i];
        return pal;
    }

    public void lectura() throws Exception {
        numCaracteres=0;
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
                caracteres[numCaracteres]=caracter;
                numCaracteres++;
                caracter=(char) System.in.read();
       }
    }


    public static boolean hayPalabras() {
        buscarPalabra();
        return (caracter!=FINAL_SECUENCIA);
    }

   public  static void buscarPalabra() {
        try {
            while (caracter==ESPACIO) {
                caracter= (char) System.in.read();
            }
        } catch (Exception e) {}
    }

   //método que verifica si una palabra es menor que otra dada por parámetro
   //según orden creciente alfabético
   public boolean menor(Palabra b) {
       for (int indice=0;(indice<numCaracteres)&&(indice<b.numCaracteres);indice++) {
           if (caracteres[indice]<b.caracteres[indice]) {
               return true;
           }
           else {
               if (caracteres[indice]>b.caracteres[indice]) {
                   return false;
               }
           }
       } 
       return (numCaracteres<=b.numCaracteres);
   }
    
    public static int getDimension() {
        return DIMENSION;
    }
    
    public char [] getCaracteres() {
        return caracteres;
    }
    
    public char getCaracter(int pos) {
        return caracteres[pos];
    }
    public void setCaracteres(char [] caracteres) {
        this.caracteres=caracteres;
    }
    
    public int getNumCaracteres() {
        return numCaracteres;
    }
    
    public void setNumCaracteres(int numero) {
        this.numCaracteres=numero;
    }
    
    public static void copiar(Palabra pal1,Palabra pal2) {
        pal2.caracteres=pal1.caracteres;
        pal2.numCaracteres=pal1.numCaracteres;
    }
    
    public static int getMaximoNumeroCaracteres() {
        return MAXIMO;
    }
    
}

