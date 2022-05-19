/*
CLASE PalaraFicherosOut aglutina las declaraciones y funcionalidades para habilitar
la escritura de objetos Palabra en un fichero
 */
package busquedaordenacion;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PalabraFicherosOut {
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE
    private static final int RETURN=(int) '\r';
    private static final int SALTO_LINEA=(int) '\n';
    private BufferedWriter fichero=null;
    
    //MÉTODOS
    //CONSTRUCTORES
    public PalabraFicherosOut(String nombre) throws Exception {
        //establecimiento enlace lógico con el fichero físico correspondiente
        fichero=new BufferedWriter(new FileWriter(nombre));
    }
    
    //MÉTODOS FUNCIONALES
   
    public void escritura(Palabra pal) throws Exception {
        fichero.write(pal.toString());
    }
    
    
    public void escribirSeparador(char separador) throws Exception {
        fichero.write(separador);
    }
    
    //graba un salto de línea en el fichero corespondiente. 
    public void escribirSaltoLinea() throws Exception {
        fichero.newLine();
    }
    public void cierreEnlace() throws Exception {
        if (fichero!=null) {
            fichero.close();
        }
    }
}
