/*

 */
package taller1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FicheroLecturatxt {
    
    //Atributos
    private static final int RETURN=(int) '\r';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';
    private BufferedReader fichero = null;
    
    //MÈTODES 
    //Mètode constructor
    public FicheroLecturatxt(String nombreFichero) throws Exception {
        //establiment de l'encllaç BufferReader amb el fitxetr de text 
        //indentificat a trabés del paràmetre Strng nombreFichero donat
        fichero=new BufferedReader(new FileReader(nombreFichero));
    }

    //Mètodes funcionals
    
    //mètode que permetrà lleir una línia

    public void close(){
        try{
            fichero.close();
        }catch(IOException e){
            System.out.println("Error al cerrar fichero");
        }
        
    }
    
}
