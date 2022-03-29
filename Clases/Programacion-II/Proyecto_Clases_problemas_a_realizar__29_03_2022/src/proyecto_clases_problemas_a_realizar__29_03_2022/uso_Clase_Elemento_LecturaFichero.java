/*
FUNCIONALIDAD: visualiza los objetos Elemento leidos desde un fichero.

NOTA: utilización de la clase RandomAccessFile a través de la clase FicheroElementoInOut

autor: Juan Montes de Oca
 */

package proyecto_clases_problemas_a_realizar__29_03_2022;

public class uso_Clase_Elemento_LecturaFichero {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new uso_Clase_Elemento_LecturaFichero().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto FicheroElementoInOut
        FicheroElementoInOut fichero;
        //declaración objeto Elemento
        Elemento elemento;
        
        //ACCIONES
        try {
            //borrado de la ventana de visualización
            borrarPantalla("VISUALIZACIÓN ELEMENTOS CONTENIDOS EN EL FICHERO");
            //declaración objeto FicheroContactoInOut para posibilitar la
            //lectura desde el fichero
            fichero=new FicheroElementoInOut("elementos.dat");
            try {
                 //lectura del primer objeto Elemento desde el fichero
                elemento=fichero.lectura();
                //bucle de lectura y visualización
                while (elemento!=null) {
                    //visualización objeto Elemento leido
                    System.out.print(elemento.toString()+"\n"); 
                    //lectura siguiente objeto Elemento desde el fichero  
                    elemento=fichero.lectura();
                }                
            }catch (Exception error) { 
              //SE HA TERMINADO EL FICHERO
            }finally {    
              try { 
                  //cierre del enlace del fichero
                  fichero.cierre();     
              } catch (Exception error) {
                  System.out.println("ENLACE FICHERO YA CERRADO");
              } 
            }   
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
}
