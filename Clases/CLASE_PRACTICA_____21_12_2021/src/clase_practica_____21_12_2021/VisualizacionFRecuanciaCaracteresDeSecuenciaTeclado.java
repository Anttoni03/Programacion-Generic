/*
FUNCIONALIDAD: dada una secuencia de caracteres introducida por teclado
y acabada con el caracter '.', visualiza la frecuencia de aparición de los
caracteres contenidos en la secuencia dada.

NOTA: UTILIZACIÓN DE LA CLASE FrecuenciaCaracteres
 */
package clase_practica_____21_12_2021;

public class VisualizacionFRecuanciaCaracteresDeSecuenciaTeclado {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new VisualizacionFRecuanciaCaracteresDeSecuenciaTeclado().programaPrincipal();
    }
    
    //declaración método programaPrincipal
    public void programaPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante caracter para representar final de secuencia
        final char FINAL_SECUENCIA='.';
        //declaración objeto FrecuenciaCaracteres para gestionar la frecuencia
        //de los caracteres contenidos en la secuencia de entrada
        FrecuenciaCaracteres frecuencia=new FrecuenciaCaracteres();
        //declaración variable caracter para almacenar, de uno en uno, los caracteres
        //leidos desde la secuencia de entrada
        char caracter;
        
        //ACCIONES
        //mensaje usuario para introducir secuencia
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        //lectura primer caracter de la secuencia
        caracter=LT.readChar();
        //BUCLE DE LECTURA Y TRATAMIENTO A NIVEL DE CARACTERES
        while (caracter!=FINAL_SECUENCIA) {
            //tratamiento caracter a través de la actualización del objeto frecuencia
            frecuencia.actualizacion(caracter);
            //lectura siguiente caracter de la secuencia
            caracter=LT.readChar();
        }
        //Visualización frecuencia caracteres de la secuencia
        System.out.println(frecuencia.toString());
    }
    
}
