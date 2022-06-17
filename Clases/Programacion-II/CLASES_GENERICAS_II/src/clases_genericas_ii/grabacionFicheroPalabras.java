/*
FUNCIONALIDAD: dado un texto introducido por teclado, visualiza y graba las palabras
contenidas en dicho texto en un fichero, de nombre palabras.dat.
La escritura de palabras se lleva  a cabo a nivel de objetos Palabra utilizando
la clase base ObjectOutputStream a través de la clase FicheroObjetosPalabraOut.
nota: para ello, la clase Palabra debe estar serializada.

autor: Juan Montes de Oca
*/
package clases_genericas_ii;

public class grabacionFicheroPalabras {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new grabacionFicheroPalabras().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto Palabra
        Palabra palabra; 
        //declaración objeto FicheroObjetosPalabraOut
        FicheroObjetosPalabraOut fichero;
        
        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto FicheroObjetosPalabraOut
            fichero=new FicheroObjetosPalabraOut("palabras.dat");
            try {
                //mensaje usuario solicitando introducir texto por teclado
                System.out.print("INTRODUCIR TEXTO: ");
                //bucle de lectura desde el teclado y escritura en fichero a nivel
                //de objetos Palabra
                while (Palabra.hayPalabras()) {
                    //instanciación objeto Palabra (MUY IMPORTANTE SIEMPRE A REALIZAR)
                    palabra=new Palabra();
                    //lectura palabra desde el texto introducido por teclado
                    palabra.lectura();
                    //visualización palabra leida
                    System.out.println(palabra.toString());
                    //escritura palabar leida en el fichero a nivel de objeto Palabra
                    fichero.escritura(palabra);       
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
