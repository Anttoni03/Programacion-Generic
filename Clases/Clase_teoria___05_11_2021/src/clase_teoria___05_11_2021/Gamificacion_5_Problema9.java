/*
9. Declara un array con 100 componentes enteras dándole como valores los 100
primeros primos. Visualiza su contenido posteriormente.

 */
package clase_teoria___05_11_2021;

public class Gamificacion_5_Problema9 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_5_Problema9().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable array con componentes enteras para almacenar los
        //100 primeros números primos
        int [] numerosPrimos=new int[100];
        //declaración variable entera para contar el número de primos obtenidos
        //y asignados al array
        int contadorPrimos=0;
        
        //ACCIONES
        //inicialización (asignación como primer número primo al array del número
        //1
        numerosPrimos[0]=1;
        //inicremetar en una unidad el contador de primos
        contadorPrimos++;
        //BUCLE DE TRATAMIENTO
        for (int candidato=2;contadorPrimos<100;candidato++) {
            //verificar si candidato es un número primo
            if (esPrimo(candidato)) {
                //asignación de candidato al array de números primos
                numerosPrimos[contadorPrimos]=candidato;
                //incrementar contador de números primos obtenidos y asignados
                contadorPrimos++;
            }
        }
        
        //visualización números primos obtenidos
        visualizacion(numerosPrimos);
    }
    
    //método función esPrimos lleva a cabo la verificación de si el número
    //dado por parámetro es primo o no
//    private boolean esPrimo(int numero) {
//        //DECLARACIONES
//        //declaración
//        
//        //ACCIONES
//        for (int divisor=numero/2;divisor>1;divisor--) {
//            if (numero%divisor==0) {
//                return false;
//            }
//        }
//        
//        //devolución true pues el número es primo
//        return true;
//    }

    //método función esPrimos lleva a cabo la verificación de si el número
    //dado por parámetro es primo o no
    private boolean esPrimo(int numero) {
        //DECLARACIONES
        //declaración variable booleana para controlar el resultado de la verificación
        boolean resultado=true;
        
        //ACCIONES
        for (int divisor=numero/2;(divisor>1)&&(resultado);divisor--) {
            if (numero%divisor==0) {
                resultado=false;
            }
        }
        
        //devolución resultado
        return resultado;
    }
    
    //método procedimiento visualizacion que lleva a cabo la visualización
    //del array dado por parámetro
    private void visualizacion(int [] datos) {
        //bucle de visualización
        for (int indice=0; indice<datos.length; indice++) {
            //visualización componente indice-ésima del array
            System.out.print(datos[indice]+" ");
        }
        //salto de línea
        System.out.println();
    }
}
