/*
 * CALSE FicheroElementoInOut AGLUTINA LAS DECLARACIONES Y LAS FUNCIONALIDADES
 * QUE POSIBILITAN LA LECTURA Y ESCRITURA DE OBJETOS Elemento UTILIZANDO LA
 * CLASE RandomAccessFile.

autor: Juan Montes de Oca
*/
package proyecto_clases_problemas_a_realizar__29_03_2022;

import java.io.*;

public class FicheroElementoInOut {
    //DECLARACIÓN ATRIBUTOS
    //declaración objeto RandomAccessFile para posibilitar la lectura/escritura
    //de objetos Elemento desde/en fichero
    private RandomAccessFile fichero=null;
   
    //MÉTODOS
    
    //MÉTODO CONSTRUCTOR
    public FicheroElementoInOut(String nombreFichero) throws Exception { 
        try {
            //instanciación objeto RandomAccessFile para establecer el enlace con
            //el fichero a nivel de lectura/escritura
            fichero = new RandomAccessFile(nombreFichero,"rw");
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //MÉTODOS FUNCIONALES

    //método lectura que posibilita la lectura de un objeto Elemento desde el
    //fichero
    public Elemento lectura() {
        //DECLARACIONES
        //declaración objeto Contacto
        Elemento elemento=new Elemento();
        
        //ACCIONES
        try {
            //lectura campo atributo codigo del objeto Elemento
            elemento.setCodigo(fichero.readInt());
            //lectura campo atributo nombre del objeto Elemento a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            elemento.setDescripcion(lecturaString(32));
        }catch (EOFException error) {
            return null;
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return elemento;
    }
    
    
    //método lectura que posibilita la lectura de un objeto Elemento desde el
    //fichero dado el número del elemento de fichero Elemento
    public Elemento lectura(int posicion) {
        //DECLARACIONES
        //declaración objeto Contacto
        Elemento elemento=new Elemento();
        
        //ACCIONES
        try {
            //verificación si la posición del elemento a leer existe en el fichero
            if ((posicion>0) && (posicion<=(fichero.length()/Elemento.getDimension()))) {
                //posicionamiento puntero del fichero en el elemento de fichero
                //Elemento dado
                fichero.seek(((posicion-1)*Elemento.getDimension()));
                //lectura campo atributo codigo del objeto Elemento
                elemento.setCodigo(fichero.readInt());
                //lectura campo atributo nombre del objeto Elemento a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                elemento.setDescripcion(lecturaString(32));                
            }
            else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new EntradaIncorrecta("POSICIÓN NO EXISTENTE");
            }
        }catch (EntradaIncorrecta error) {
            System.out.println(error.toString());
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return elemento;
    }
    
    //método que lleva a cabo la lectura de un String desde el fichero a través 
    //de la lectura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private String lecturaString(int dimension) {
        //DECLARACIONES
        //declaración String para ir concatenando los caracteres que van a ser
        //leidos desde el fichero
        String campo="";
        
        try {
            //ACCIONES
            //bucle de lectura y concatenación de los caracteres desde el fichero
            for (int i=0;i<dimension;i++) {
                //concatenación en el String campo del caracter leido desde el
                //fichero
                campo=campo+fichero.readChar();
            }  
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());            
        }
        //devolución del String resultante
        return campo;
    }
    
    //método escritura que posibilita la escritura de un objeto Elemento en el
    //fichero
    public  void escritura(Elemento elemento) {
        try {
            //posicionamiento del puntero al final del fichero de objetos Elemento
            fichero.seek(fichero.length());
            //escritura en el fichero del atributo código correspondiente al
            //objeto Elemento 
            fichero.writeInt(elemento.getCodigo());
            //escritura en el fichero del atributo nombre. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo descripcion
            escrituraString(elemento.getDescripcion(), 32);           
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //método que posibilita la reescritura en el fichero de un objeto Elemento
    //en función del número que ocupa en el fichero
    public void escritura(Elemento elemento,int posicion) {
        try {
            //verificación si la posición del elemento a leer existe en el fichero
            if ((posicion>0) &&(posicion<=(fichero.length()/Elemento.getDimension()))) {
                //posicionamiento del puntero en el elemento de fichero objeto Elemento
                //correspondiente al número dado por parámetro
                fichero.seek((posicion-1)*Contacto.getDimension());            
                //escritura en el fichero del atributo código correspondiente al
                //objeto elemento 
                fichero.writeInt(elemento.getCodigo());
                //escritura en el fichero del atributo nombre. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo descripcion
                escrituraString(elemento.getDescripcion(), 32);  
            }
            else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new EntradaIncorrecta("NO ES POSIBLE ESCRIBIR EL ELEMENTO DADO");                
            }
        }catch (EntradaIncorrecta error) {
            System.out.println(error.toString());
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }

    //método que lleva a cabo la escritura de un String en el fichero a través 
    //de la escritura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private void escrituraString (String campo, int dimension) throws IOException {
        try {
            //bucle de escritura en el fichero, caracter a caracter, del String
            //y en función de la dimensión dada
            for (int i=0;((i<dimension) && (i<campo.length())); i++) {
                //escritura en el fichero del caracter i-ésimo del String
                fichero.writeChar(campo.charAt(i));
            }
            //verificar si la dimensión del String dado es menor que la dimensión
            //del atributo que debe representar del objeto Contacto
            if (campo.length()<dimension) {
                //al ser la dimnensión del String menor que la dimensión del atributo
                //que representa del objeto Contacto se escribirán caracteres
                //espacio hasta llegar a la dimensión del atributo
                for (int i=0; i<(dimension-campo.length()); i++) {
                    //escritura en el fichero del caracter espacio
                    fichero.writeChar(' ');
                }
            }            
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());            
        }
    }
    
    
    //cierre del enlace con el fichero
    public void cierre() throws Exception {
        try {
            fichero.close();            
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }

}
