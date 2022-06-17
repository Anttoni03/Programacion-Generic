/*
FUNCIONALIDAD: Visualización invertida de las palabras invertidas contenidas en un fichero
de palabras utilizando una pila
 */
package clases_genericas_ii;


public class visualizacionInvertidaPalabrasFichero {
    public static void main(String [] argumentos) {
        new visualizacionInvertidaPalabrasFichero().metodoPrincipal();
    }
    
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración pila de palabras
        PilaConArrayList<Palabra> pilaPalabras=new PilaConArrayList<Palabra>();
        //declaración objeto FicheroObjetosPalabraIn
        FicheroObjetosPalabraIn fichero;
        //declaración objeto Palabra
        Palabra palabra;
        //declaración objeto palabraInvertida
        Palabra palabraInvertida;
        
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
                    //introducción palabra en la pila
                    pilaPalabras.introducir(palabra);
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
        //bucle de extracción y visualización de las palabras contenidas en la pila
        while (!pilaPalabras.estaVacia()) {
            //extracción palabra de la pila e inversión a través del metodo inversa de la
            //clase Palabra
            palabraInvertida=pilaPalabras.extraer().inversion();
            System.out.println(palabraInvertida.toString());    
        }
    }
    
}
