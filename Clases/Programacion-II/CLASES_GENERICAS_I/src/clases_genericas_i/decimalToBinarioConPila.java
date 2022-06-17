/*
FUNCIONALIDAD: visualiza la conversión binaria de un número entero introducido
por teclado utilizando una pila.
En número binario no tendrá más de 15 dígitos
 */
package clases_genericas_i;

public class decimalToBinarioConPila {
    //método main
    public static void main(String [] argumentos) {
        new decimalToBinarioConPila().metodoPrincipal();
    }
    
    //método metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración constante que representa el máximo número de digitos 
        //permitidos para la representación del número binario
        final int MAXIMO_DIGITOS=15;
        //declaración pila de enteros que representarán los dígitos del
        //número binario
        Pila<Integer> pilaRepresentacionBinario=new Pila<Integer>(MAXIMO_DIGITOS);
        //declaración variable entera para almacenar el número entero a convertir
        int numero;
        //declaración booleana para controlar el final del programa
        boolean fin=false;
        
        //ACCIONES
        try {
            //bucle programa
            while (!fin) {
                //introducción número entero a convertir
                System.out.print("INTRODUCIR NÚMERO A CONVERTIR A BINARIO: ");
                numero=LT.readInt();
                //verificar si el número entero a convertir representa un número
                //de digitos en binario superior al máximo establecido
                //log2 N = log10 N / log10 2
                if ((Math.log10(numero)/Math.log10(2))<=MAXIMO_DIGITOS) {
                    //tratamiento para extraer los dígitos binarios del número
                    //entero fundamentándonos en introducir los restos de las 
                    //sucesivas divisiones por 2

                    //declaración variable para representar el dividendo
                    int dividendo=numero;
                    //declaración variable para representar el resto
                    int resto;

                    //bucle tratamiento
                    while (dividendo>1) {
                        //cálculo del resto de la división de la iteración
                        resto=dividendo%2;
                        //introducción en la pila del resto correspondiente a
                        //la división de la iteración
                        pilaRepresentacionBinario.introducir(resto);
                        //actualización del dividendo para la siguiente iteración
                        dividendo=dividendo/2;
                    }
                    //introducir el dividendo final como dígito binario en la pila
                    pilaRepresentacionBinario.introducir(dividendo);
                    
                    //visualización del número binario en base a extraer de la
                    //pila los restos introducidos en el tratamiento anterior
                    System.out.print("\nLA REPRESENTACIÓN BINARIA DEL NÚMERO "+numero+" ES: ");
                    while (!pilaRepresentacionBinario.estaVacia()) {
                        System.out.print(pilaRepresentacionBinario.extraer());
                    }
                    //salto de linea
                    System.out.println();
                    //verificar si se quiere continuar
                    System.out.print("CONTINUAR s/n: ");
                    fin=(LT.readChar()=='n');
                }
                else {
                    throw new numeroIncorrecto("EL NÚMERO INTRODUCIDO TIENE MÁS DE "+MAXIMO_DIGITOS+" DIGITOS EN"
                            + " SU REPRESENTACIÓN BINARIA");
                }
            }            
        }catch (numeroIncorrecto error) {
            System.out.println(error.toString());
        }  

    }
    
    public static class numeroIncorrecto extends Exception {
        public numeroIncorrecto(String s) {
            super(s);
        }
    }
    
}
