/*
FUNCIONALIDAD:
Implementar un programa que dado un número entero mayor o igual a 0 visualice 
los caracteres numéricos que se corresponden con los dígitos de dicho número.
 */
package clase_teoría___10_12_2021;

public class Descompoosicion_Numero_En_Caracteres_Numericos {
    
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Descompoosicion_Numero_En_Caracteres_Numericos().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración e inicialización variable entera para almacenar el número
        //entero a descomponer
        int numero=3;
        //declaración variable char para almacenar, de uno en uno, los caracteres
        //que representan los dígitos númericos en los que se compone el número
        //a descomponer
        char caracter;
        //declaración variable entera para representar el orden de dígito
        int orden=5; //inicialización a 5 que se corresponde con las centenas de
                     //millares
        //declaración variable entera para almacenar, de uno en uno, el digito
        //extraido del número
        int digito;
        //declaración variable booleana para controlar la existencia de 0's a la
        //izquierda
        boolean cerosIzquierda=true;

        
        //ACCIONES
        
        if (numero>0) {
            //BUCLE DE TRATAMIENTO
            while (orden==0){
                //obtener, a partir del número, el dígito correspondiente al orden
                //de esta iteración
                digito=numero/(int) Math.pow(10.0, (double) orden);
                //obtener el caracter numérico que le corresponde al dígito obtenido
                caracter=(char) ((int) '0'+digito);
                if ((digito!=0)&&(cerosIzquierda)) {
                    cerosIzquierda=false;
                }
                if (!cerosIzquierda) {
                    //visualizar caracter obtenido
                    System.out.print(caracter);
                }  
                //PREPARACIÓN SIGUIENTE ITERACIÓN DEL TRATAMIENTO
                //actualizar número
                numero=numero%(int) Math.pow(10.0, (double) orden);
                //actualización orden
                orden--;
            }
        }
        else {
            System.out.print('0');
        }
    }
}
