/*
CLASE QuinielaAglutina las declaraciones y las funcionalidades relativas a 
objeto Quiniela
 */
package clasepractica_16_11_2021;

public class Quiniela {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //declaración atributo de clase que representa el número de apuestas de
    //un objeto quiniela
    private static final int NUMERO_APUESTAS=15;
    //declaración atributo de objeto que represente las apuestas de un objeto
    //Quiniela
    private char [] apuestas=new char[NUMERO_APUESTAS];
    //declaración atributo de clase que representa los resultados que se han producido de
    //la quiniela
    private static char [] RESULTADOS=new char[NUMERO_APUESTAS];
    //declaración atributo de clase que representa el total de la recaudación
    //por las apuestas de quiniela
    private static double totalRecaudacion;
    //declaración de los porcentajes de la recudación asignados a los números de
    //aciertos premiados, de forma que,
    //          De 0 aciertos a 11 aciertos --> 0%
    //          15 aciertos --> 25%
    //          14 aciertos --> 20%
    //          13 aciertos --> 15%
    //          12 aciertos --> 10%
    private static final double [] PORCENTAJES_PREMIOS={0.0,0.0,0.0,0.0,0.0,0.0,
                                                        0.0,0.0,0.0,0.0,0.0,
                                                        0.0,10.0,15.0,20.0,25.0};
    //declaración del número de acertantes en función del número de aciertos
    private static int [] numeroAcertantes=new int[NUMERO_APUESTAS+1];
    
    //MÉTODOS
    
    //MÉTODOS CONSTRUCTORES
    //método constructor sin parámetros que posibilitará utilizando el operador new
    //instanciar (crear/generar) objetos Quiniela
    public Quiniela() {}
    
    //MÉTODO FUNCIONALES
    //método apuestarQuiniela lleva a cabo la lectura por teclado de las apuestas de
    //una quiniela
    public void apuestaQuiniela() {
        //mensaje usuario para comunicar que se va a llevar  a cabo la realización
        //de una apuesta de quiniela
        System.out.println("\nNUEVA APUESTA DE QUINIELA: ");
        //bucle de lectura de las 15 apuestas de la quiniela a leer
        for (int indice=0;indice<NUMERO_APUESTAS;indice++) {
            //mensaje usuario para introducir apuesta numero (indice+1)
            System.out.print("APUESTA "+(indice+1)+" (1,x,2): ");
            //lectura valor introducido por teclado
            apuestas[indice]=LT.readChar();
            //saltar línea
            LT.skipLine();
        }
    }
    
    //método setTotalRecaudacion lleva a cabo la asignación al atributo
    //totalRecaudacion el total de la recaudación de las quinielas
    public static void setTotalRecaudacion(double importe) {
        totalRecaudacion=importe;
    }
    
    //método getApuestasAciertos lleva a cabo la asignación del número de apuestas
    //habidas en función del número de resultados obtenidos
    public static void getApuestasAciertos() {
        //mensjae usuario para comunicarle que tiene que introducir el número
        //de apouestas en enfunción del número de aciertos
        System.out.println("\nINTRODUCCIÓN NÚMERO DE APUESTAS EN FUNCIÓN DE LOS ACIERTOS");
        //bucle de lectura del número de apuesta en función del número de acietos
        for (int indice=0;indice<=15;indice++) {
            //mensaje usuario para introducir el número de apuestas con aciertos indice
            System.out.print("NÚMERO DE APUESTAS CON "+indice+" ACIERTOS: ");
            //lectura y asignación del número de apuestas para indice aciertos
            numeroAcertantes[indice]=LT.readInt();
        }           
    }
    
    //método entero obtenerNumeroAciertos lleva a cabo el cálculo del número de aceirtos
    //de un objeto Quiniela
    public int obtenerNumeroAciertos() {
        //DECLARACIONES
        //declaración variable entera para almacenar el número de aciertos
        int numAciertos=0;
        
        //ACCIONES
        //bucle de comparación para obtener el número de aciertos
        for (int indice=0;indice<NUMERO_APUESTAS;indice++) {
            if (RESULTADOS[indice]==apuestas[indice]) {
                //incrementar el número de aciertos
                numAciertos++;
            }
        }
        
        //devolución número de aciertos obtenido
        return numAciertos;
    }
    
    //método de clase asignacionResultados lleva a cabo la asignación de los resultados
    //reales de la quiniela
    public static void asignacionResultados() {
        //mensaje usuario para comunicarle que tiene que introducir los resultados
        //reales de la quiniela
        System.out.println("\nINTRODUCCIÓN RESULTADOS DEFINITIVOS");
        //bucle de inbtroducción
        for (int indice=0;indice<NUMERO_APUESTAS;indice++) {
            //mensaje para introducir el resultado del encuentro (indice+1)
            System.out.print("RESULTADO ENCUENTRO "+(indice+1)+": ");
            //lectura reusltado
            RESULTADOS[indice]=LT.readChar();
            //saltar línea
            LT.skipLine();
        }
    }
    
    //método toString que lleva a cabo la convwersión aString de un objeto Quiniela
    public String toString() {
        //DECLARACIONES
        //declaración variable String para almacenar a través de concatenaciones
        //la información de un objeto Quiniela
        String informacion="";
        
        //ACCIONES
        //almacenamiento del la información del objeto Quiniela en el String
        for (int indice=0;indice<NUMERO_APUESTAS;indice++) {
            informacion=informacion+"APUESTA "+(indice+1)+": "+apuestas[indice]+".\n";
        }
        //devolución String resultante
        return informacion;
    }
    
    //método real obtnerPremio lleva a cabo el cálculo del premio que le corresponde
    //a un objeto Quiniela
    public double obtenerPremio() {
        return (totalRecaudacion*PORCENTAJES_PREMIOS[obtenerNumeroAciertos()]/100)
                /numeroAcertantes[obtenerNumeroAciertos()];
    }
    
    
}
