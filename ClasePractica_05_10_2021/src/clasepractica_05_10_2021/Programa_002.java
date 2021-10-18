package clasepractica_05_10_2021;

/*
FUNCIONALIDAD: lleva a cabo la declaración de variables de tipos primitivos y asignación
de literales.
FECHA REALIZACIÓN: 05.octubre.2021
ASIGNATURA: Programación I
ESTUDIOS: ING. Informática
AUTOR: Juan MOntes de Oca
 */

public class Programa_002 {
    //declaración del método main necesario para que la clase pueda ser ejecutada
    //directamente.
    public static void main(String [] argumentos) throws Exception {
        //declaración de variable del tipo char
        char var1;
        //declaración de variable del tipo char con inicialización
        char var2='a';
        
        //declaración de variables de los diferentes tipos numéricos enteros
        byte var3, var4=1;  //el tipo byte representa valores enteros representados a través de 1 byte.
        short var5, var6=2; //el tipo short representa valores enteros representados a través de 2 bytes. 
        int var7,var8=3; //el tipo int representa valores enteros representados a través de 4 bytes. 
        long var9, var10=4; //el tipo long representa valores enteros representados a través de 8 bytes. 
        
        //declaración de variables de los diferentes tipos numéricos reales
        float var11, var12=(float) 5.0, var13= 6.0f;  //el tipo float representa valores reales representados a través de 4 bytes.
                                                      //la asignación de un literal real a una variable float debe llevar el
                                                      //casting del tipo double (ejemplo var12), o bien, especificar el literal
                                                      //real como float introduciendo el sufijo f en el mismo (ejemplo var13)
                                                      //Todo ello es debido a que los valores reales predeterminados en java
                                                      //corresponden al tipo double
        double var14, var15=6.0; //el tipo double representa valores reales representados a través de 8 bytes.    
        
        //declaración de variables del tipo boolean
        boolean var16, var17=true; //el tipo boolean representa los valores booleanos true y false.
        
        //declaración de variables del tipo String
        String var18, var19="SOY UN LITERAL STRING"; //el tipo String representan a las cadenas de caracteres       
    }
    
}
