/*
6. realizar un programa en java que nos permita conocer el número de aciertos de
nuestra quiniela de futbol. Para ello, el programa tendrá los resultados de las 15
apuestas de la jornada correspondiente. Nuestra quiniela será demandada por el
programa y la introduciremos por teclado. Utiliza los métodos que creas conveniente.
 */
package clase_teoria___05_11_2021;

public class Gamificacion_5_Problema6 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_5_Problema6().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable array de 15 componentes de tipo char para representar
        //la quiniela de apuestas de usuario introducidas por teclado
        char [] apuesta=new char[15];
        //declaración variable de tipo int para almacenar el número de aciertos
        //obtenidos en la quiniela de apuestas del usuario
        int aciertos;

        //ACCIONES
        //Introdución quiniela apuestas del usuario
        lectura(apuesta);
        //obtención número de aciertos de la quiniela del 
        aciertos=verificacion(apuesta);
        //visualización resultado
        System.out.println("NÚMERO DE ACIERTOS: "+aciertos);
    }
    
    //método procedimiento lectura lleva a cabo la lectura, por teclado, de la
    //quiniela apuesta del usuario
    private void lectura(char [] datos) throws Exception {
        //ACCIONES
        //bucle de lectura y asignación al array dado
        for (int indice=0;indice<datos.length;indice++) {
            //mensaje al usuario para la introducción de la apuesta indice-ésima
            System.out.print("APUESTA "+(indice+1)+": ");
            //lectura y asignación a la componente indice-ésima del array dado
            datos[indice]=LT.readChar();
            //vaciar buffer de entrada
            LT.skipLine();
        } 
    }
    
    //método función verificación lleva a cabo la obtención del número de aciertos
    //de la quiniela de apuestas dada por parámetro
    private int verificacion(char [] datos) {
        //DECLARACIONES
        //declaración constante array de componentes tipo char para almacenar los
        //resultados reales de la jornada correspondiente
        final char [] RESULTADOS={'1','2','x','1','1','2','2','2','x','x','1','2','x','1','2'};
        //declaración variable entera para contar el número de aciertos
        int contadorAciertos=0;
        
        //ACCIONES
        //bucle de verificación comparando las componentes del array RESULTADOS con
        //las del array datos para contabilizar los aciertos
        for (int indice=0;indice<RESULTADOS.length;indice++) {
            //comparación de las componentes indice-ésimas de ambos arrays
            if (RESULTADOS[indice]==datos[indice]) {
                //incrementar contador de aciertos
                contadorAciertos++;
            }
        }
        
        //devolución del número de aciertos obtenido
        return contadorAciertos;
    }
    

    
}
