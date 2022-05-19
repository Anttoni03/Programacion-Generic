 /*
CLASE PalabraFicheroIn aglutina las declaraciones y funcionalidades que posibilitan
la lectura de objetos Palabra desde un fichero
 */
package busquedaordenacion;

import java.io.BufferedReader;
import java.io.FileReader;

public class PalabraFicherosIn {
    //DECLARACIONES DE LOS ATRIBUTOS DE LA CLASE
    private static final int FINAL_FICHERO=-1;
    private static final int COD_ESPACIO=(int)' ';
    private static final int RETURN=(int) '\r';
    private static final int SALTO_LINEA=(int) '\n';
    private int codigoCaracter=COD_ESPACIO;
    private BufferedReader fichero=null;
    
    //MÉTODOS
    //CONSTRUCTORES
    public PalabraFicherosIn(String nombre) throws Exception {
        //establecimiento del enlace lógico con el fichero físico
        fichero=new BufferedReader(new FileReader(nombre));
    }
    
    //MÉTODOS FUNCIONALES
    //verifica si hay una palabra en el fichero
    public boolean hayPalabras() throws Exception {
        buscarPalabra();
        return (codigoCaracter!=FINAL_FICHERO);
    }
    
    //busca una palabra en el fichero
    private void buscarPalabra() throws Exception {
        while ((esSeparador(codigoCaracter))||
               (codigoCaracter==RETURN)||
               (codigoCaracter==SALTO_LINEA)) {
            //lectura siguiente código de caracter desde el fichero
            codigoCaracter=fichero.read();
        }
    }
    
    //lectura de una palabra desde el fichero
    public Palabra lectura() throws Exception {
        //DECLARACIONES
        //declaración array de componentes char para alamacenar los caracteres
        //de la palabra leida a través de sus códigos de caracter desde el fichero
        char [] caracteres=new char[20];
        //declaración variable entera para funcionar como índice del array 
        //caracteres
        int indice=0;
        
        //BUCLE DE LECTURA Y ALMACENAMIENTO DE LOS CARACTERES DE LA PALABRA A LEER
        while ((codigoCaracter!=FINAL_FICHERO)&&
               (!esSeparador(codigoCaracter))&&
               (codigoCaracter!=RETURN)&&
               (codigoCaracter!=SALTO_LINEA)) {
            //almacenar caracter de la palabra en la componente índice del array
            //caracteres
            caracteres[indice]=(char) codigoCaracter;
            //inbcrementar indice
            indice++;
            //lectura siguiente código de caracter desde el fichero
            codigoCaracter=fichero.read();
        }
        
        //DEVOLVER OBJETO Palabra resultante
        return new Palabra(caracteres,indice);
    }
    
    //Cierre del enlace lógico del fichero
    public void cierreEnlace() throws Exception {
        if (fichero!=null) {
            fichero.close();
        }
    }
    
    //verifica si un caracter dado es un caracter separador
    private boolean esSeparador(int cod) {
        return (((cod==' ')||(cod==',')||(cod==';')||(cod==':')||(cod=='.')||
                (cod=='(')||(cod==')')||(cod=='-')||(cod=='[')||(cod==']')||
                (cod=='{')||(cod=='}')));
    }
    
    
}
