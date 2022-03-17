/*
FUNCIONALIDAD: dado un texto introducido por teclado, visualiza y graba las palabras
contenidas en dicho texto en un fichero, de nombre palabras.dat.
La escritura de palabras se lleva  a cabo a nivel de objetos Palabra utilizando
las clases bases ObjectOutputStream o AdicionObjectOutputStream, dependiendo
si el fichero ya existe o no respectivamente, a través de la clase FicheroObjetosPalabraOutAdd, todo 
ello nos permitirá añadir al final del fichero las palabras que grabemos a través de este
programa si el fichero ya existía.
nota: para ello, la clase Palabra debe estar serializada.

autor: Juan Montes de Oca
*/
package claseteorica__08_03_2022;

public class uso_clase_ObjectOutputStream_2_v2 {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new uso_clase_ObjectOutputStream_2_v2().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto Palabra
        Palabra palabra; 
        //declaración objeto FicheroObjetosPalabraOut
        FicheroObjetosPalabraOutAdd fichero;
        
        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto FicheroObjetosPalabraOut
            fichero=new FicheroObjetosPalabraOutAdd("palabras.dat");
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
