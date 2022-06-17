/*
FUNCIONALIDAD: dado un fichero de objetos Palabra, de nombre palabras.dat,
lleva a cabo la visualización de las palabras contenidas en él.
La lectura de palabras se lleva  a cabo a nivel de objetos Palabra utilizando
la clase base ObjectInputStream a través de la clase FicheroObjetosPalabraIn.
nota: para ello, la clase Palabra debe estar serializada.

autor: Juan Montes de Oca
*/
package clases_genericas_ii;

public class lecturaFicheroPalabras {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new lecturaFicheroPalabras().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto Palabra
        Palabra palabra; 
        //declaración objeto FicheroObjetosPalabraIn
        FicheroObjetosPalabraIn fichero;
        
        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto FicheroObjetosPalabraIn
            fichero=new FicheroObjetosPalabraIn("palabras.dat");
            try {
                //lectura primera palabra desde el fichero
                palabra=fichero.lectura();
                //bucle de lectura desde el fichero y visualización a nivel
                //de objetos Palabra
                while (palabra!=null) {
                    //visualización palabra leida desde el fichero
                    System.out.println(palabra.toString());
                    //lectura siguiente palabra desde el fichero
                    palabra=fichero.lectura();       
                }                
            }catch (Exception error) {
                System.out.println("ERROR: "+error.toString());
            }finally {
                //cierre del enlace fichero
                    try {
                    fichero.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR CIERRE FICHERO" + error.toString());          
                }
            }
        }catch (Exception error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
}
