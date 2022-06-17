/*
FUNCIONALIDAD: verifica si una expresión aritmética es correcta en cuanto a
contener parentesis balanceados utilizando una pila
En una expresión aritmética no habrá más de 20 pares de paréntesis
 */
package clases_genericas_i;

public class parentesisBalanceados {
    //método main
    public static void main(String [] argumentos) {
        new parentesisBalanceados().metodoPrincipal();
    }
    
    //método metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración constante que representa el máximo número de
        //pares de parentesis que puede contener una expresión
        final int MAXIMO_PARES_PARENTESIS=20;
        //declaración pila de enteros que representarán los dígitos del
        //número binario
        Pila<Character> pilaParentesis=new Pila<Character>(MAXIMO_PARES_PARENTESIS);
        //declaración variable String para almacenar la expresión aritmética
        //leida por teclado y que hay que verificar
        String expresion;
        //declaración booleana para controlar el final del programa
        boolean fin=false;
        //declaración boolena para controlar si la expresión es correcta o no
        boolean correcta;
        
        //ACCIONES
        try {
            //bucle programa
            while (!fin) {
                correcta=true;
                //introducción número entero a convertir
                System.out.print("INTRODUCIR EXPRESIÓN ARITMÉTICA: ");
                expresion=LT.readLine();
                //tratamiento caracter a caracter de la expresión introducida
                //de modo que cada caracter '(' que contenga, éste será introducido
                //en la pila, y cada caracter ')' conllevará a la extracción
                //de un caracter '(' de la pila.
                for (int indice=0;(indice<expresion.length())&&correcta;indice++) {
                    if (expresion.charAt(indice)=='(') {
                        //introducir caracter indice de la expresión en la pila
                        pilaParentesis.introducir(expresion.charAt(indice)); 
                    }
                    else if (expresion.charAt(indice)==')') {
                        //verificar si la pila está vacia
                        if (!pilaParentesis.estaVacia()) {
                            //extraer caracter de la pila
                            pilaParentesis.extraer();
                        }
                        else {
                            //la expresión no es correcta porque ha aparecido un 
                            //')' no conteniendo la pila su pareja '('
                            correcta=false;
                        }
                    }
                }
                if (correcta&&pilaParentesis.estaVacia()) {
                    //mensaje de EXPRESIÓN CORRECTA 
                    System.out.println("EXPRESIÓN CORRECTA EN CUANTO A PARÉNTESIS BALANCEADOS");
                }
                else {
                    //mensaje de EXPRESIÓN NO CORRECTA 
                    System.out.println("EXPRESIÓN NO CORRECTA");
                }
                                    
                //verificar si se quiere continuar         
                System.out.print("CONTINUAR s/n: ");
                fin=(LT.readChar()=='n');
                
            }
        }catch (Exception error) {
            System.out.println(error.toString());
        }  

    }
    
    public static class numeroIncorrecto extends Exception {
        public numeroIncorrecto(String s) {
            super(s);
        }
    }
    
}
