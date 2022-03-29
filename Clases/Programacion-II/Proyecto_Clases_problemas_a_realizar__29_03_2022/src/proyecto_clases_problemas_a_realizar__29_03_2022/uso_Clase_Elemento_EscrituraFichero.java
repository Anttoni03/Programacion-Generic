/*
FUNCIONALIDAD: graba en un fichero los objetos de la clase Elemento introducidos
por teclado.
NOTA: utilización de la clase RandomAccessFile a través de la clase FicheroElementoInOut.

autor: Juan Montes de Oca
 */

package proyecto_clases_problemas_a_realizar__29_03_2022;

public class uso_Clase_Elemento_EscrituraFichero {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new uso_Clase_Elemento_EscrituraFichero().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto FicheroElementoInOut
        FicheroElementoInOut fichero;
        //declaración objeto Elemento
        Elemento elemento=new Elemento();
        //declaracion variable booleana para controlar el fin de lecturas
        boolean finEscritura=false;
        
        try {   
            //delaración objeto FicheroElementoInOut para posibilitar la escritura
            //de un objeto Contacto en el fichero
             fichero=new FicheroElementoInOut("elementos.dat");  
            //bucle escritura
            while (!finEscritura) {
                //borrado de la ventana de visualización
                borrarPantalla("ESCRITURA ELEMENTO EN FICHERO");
                //lectura del objeto Contacto desde el teclado
                elemento.lectura();
                //escritura del objeto Contacto leido en el fichero
                fichero.escritura(elemento);
                //solicitud confirmación de continuar
                finEscritura=!continuar();
            }
            //cierre del enlace con el fichero
            fichero.cierre();            
        }catch (Exception error) {
           System.out.println("ERROR: "+error.toString());
        }  
    }
    
        
    //MÉTODO QUE BORRA LA VENTANA DE VISUALIZACIÓN Y VISUALIZA EL TÍTULO DE LA
    //APLICACIÓN
    private void borrarPantalla(String mensaje) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("<<<<<<"+mensaje+">>>>>>\n\n");
    }
    
   //MÉTODO QUE SOLICITA RESPUESTA PARA CONTINUAR O NO 
   private boolean continuar() {
       //DECLARACIONES
       //declaración variable char para obtener la respuesta pro teclado
       char respuesta='n';
       
       //ACCIONES
       try {
           //mensaje para continuar o no
           System.out.print("CONTINUAR (s/n):  "); 
           //lectura respuesta
           respuesta=LT.readChar();
           //devolver respuesta           
       }catch (Exception error) {
           System.out.println("ERROR CONTINUAR: "+error.toString());
       }
       return ((respuesta=='s') || (respuesta=='S'));
   }
}
