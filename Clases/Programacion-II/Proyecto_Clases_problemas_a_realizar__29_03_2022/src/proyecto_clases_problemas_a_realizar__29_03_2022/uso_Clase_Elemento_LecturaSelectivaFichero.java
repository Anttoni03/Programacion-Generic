/*
FUNCIONALIDAD: Dado un número de orden introducido por teclado, a petición
del programa, visualiza, si existe, el objeto Elemento con el código dado.
(ES IMPORTANTE QUE EXISTA LA CORRESPONDENCIA ENTRE EL
        //ATRIBUTO codigo Y LA POSICIÓN QUE OCUPA EL OBJETO Elemento
        //DENTRO DEL FICHERO).

NOTA: utilización de la clase RandomAccessFile a través de la clase FicheroElementoInOut

autor: Juan Montes de Oca
 */

package proyecto_clases_problemas_a_realizar__29_03_2022;

public class uso_Clase_Elemento_LecturaSelectivaFichero {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new uso_Clase_Elemento_LecturaSelectivaFichero().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto FicheroElementoInOut 
        FicheroElementoInOut fichero;
        //declaración variable entera para representar el código de elemento
        //a leer (ES IMPORTANTE QUE EXISTA LA CORRESPONDENCIA ENTRE EL
        //ATRIBUTO codigo Y LA POSICIÓN QUE OCUPA EL OBJETO Elemento
        //DENTRO DEL FICHERO)
        int codigo;
        //declaración objeto Elemento
        Elemento elemento;
        //declaracion variable booleana para controlar el fin de lecturas
        boolean finLecturas=false;
        
        //ACCIONES
        try {
            //declaración objeto FicheroElementoInOut para posibilitar la
            //lectura desde el fichero
            fichero=new FicheroElementoInOut("elementos.dat");
            //bucle lectura
            while (!finLecturas) {
                //borrado de la ventana de visualización
                borrarPantalla("LECTURA SELECTIVA DE ELEMENTOS DESDE UN FICHERO");
                //mensaje para introducir el código del objeto Elemento a leer
                System.out.print("CÓDIGO ELEMENTO A LEER: ");
                codigo=LT.readInt();
                //lectura elemento
                elemento=fichero.lectura(codigo);
                //visualización objeto Elemento leido
                if (elemento.getCodigo()!=0) {
                    System.out.println(elemento.toString());
                }    
                finLecturas=!continuar();   
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
