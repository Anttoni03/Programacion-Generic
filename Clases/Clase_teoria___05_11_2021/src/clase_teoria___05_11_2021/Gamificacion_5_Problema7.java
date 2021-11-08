/*
7. Declara un array de caracteres que contenga de la ‘A’ a la ‘Z’ (solo las mayúsculas).
Después, ve pidiendo posiciones del array por teclado y si la posición es correcta, se
añadirá a una cadena que se mostrara al final. Se dejará de insertar cuando se introduzca
un -1.
Por ejemplo, si escribo los siguientes números
0 //Añadira la ‘A’
5 //Añadira la ‘F’
25 //Añadira la ‘Z’
50 //Error, inserte otro numero
-1 //fin
Cadena resultante: AFZ
 */
package clase_teoria___05_11_2021;

public class Gamificacion_5_Problema7 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_5_Problema7().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración constante entera para representar la posición de finalización
        final int POSICION_FINAL=-1;
        //declaración variable entera para almacenar la posición dada por teclado
        int posicion;
        //declaración variable de tipo String para alamacenar la cadena de 
        //caracteres a conformar en función de las posiciones introducidas por
        //el usuario
        String cadena="";
        //declaración constante array de componentes char para almacenar los caracteres
        //alfabéticos mayúsculas
//        final char [] LETRAS={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ',
//            'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        final char [] LETRAS="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        
        //ACCIONES
        //mensaje usuario para introducir primera posición
        System.out.print("INTRODUCE NUEVA POSICIÓN: ");
        //lectura primera posición
        posicion=LT.readInt();
        //bucle de tratamiento
        while (posicion!=POSICION_FINAL) {
            //tratamiento posición
            if ((posicion>=0)&&(posicion<=LETRAS.length-1)) {
                //la posición al ser correcta nos posibilita concatenar el
                //caracter alfabético mayúscula de la componente de indice
                //igual a la posición en la cadena
                cadena=cadena+LETRAS[posicion];
            }
            else {
                //la posición introducida no es correcta y se visualiza el
                //mensaje correspondiente
                System.out.println("POSICIÓN NO CORRECTA - VUELVE A INTRODUCIR OTRA POSICIÓN");
            }
            
            //mensaje usuario para introducir siguiente posición
            System.out.print("INTRODUCE NUEVA POSICIÓN: ");
            //lectura primera posición
            posicion=LT.readInt();
        }
        
        //visualización secuencia conformada
        System.out.println("\nLA SECUENCIA CONFORMADA ES: "+cadena);

    }

}
