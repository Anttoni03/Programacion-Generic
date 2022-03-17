/*
2. Declara un array de 10 componentes inicializándolas con valores numéricos 
enteros variados y visualiza la media artimética de dichos valores. 
utiliza un método para calcular la media aritmética.
 */
package clasepractica_02_11_2021;

public class Gamificacion_5_Problema2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Gamificacion_5_Problema2().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración array de 10 componentes entera con inicialización
        int [] numeros={10,15,20,25,30,25,40,45,50,55};
        
        //ACCIONES
        //visualización media aritmetica de los valores contenidos en las
        //componentes del array numeros
        System.out.println("LA MEDIA ARITMÉTICA ES: "+mediaAritmetica(numeros));
    }
    
    //método función mediaAritmetica que lleva a cabo el cálculo de la media 
    //aritmética de los valores contenidos en las componentes del array dado
    //por parámetro
    private double mediaAritmetica(int [] dato) {
        //DECLARACIONES
        //declaración variable entera para almacenar la suma de los valores
        //de las componentes del array
        int suma=0;
        
        //ACCIONES
        //tratamiento para sumar los valores de las componentes del array
        for (int indice=0;indice<dato.length;indice++) {
            //incrementar suma con el valor de la componente indice-ésima del
            //array
            suma=suma+dato[indice];
        }
        
        //devolver la media aritmética
        return suma/dato.length;
    }
    
}
