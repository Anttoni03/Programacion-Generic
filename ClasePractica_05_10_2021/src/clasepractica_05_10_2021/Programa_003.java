package clasepractica_05_10_2021;

/*
FUNCIONALIDAD: lleva a cabo operaciones aritméticas, lógicas y de comparación.
FECHA REALIZACIÓN: 05.octubre.2021
ASIGNATURA: Programación I
ESTUDIOS: ING. Informática
AUTOR: Juan MOntes de Oca
 */

public class Programa_003 {
    //declaración del método main necesario para que la clase pueda ser ejecutada
    //directamente.
    public static void main(String [] argumentos) throws Exception {
        //OPERACIONES ARITMÉTICAS
        //declaración de variables a utilizar
        int var1=5,var2=10,cambioSigno,suma,resta,producto,division1,division2;
        double division3,division4;
        //operaciones aritméticas
        suma=var1+var2;     //suma
        cambioSigno=-var1;  //cambio de signo
        resta=var1-5;       //resta
        producto=var2*2;    //producto
        division1=var2/2;   //division entera
        division2=var1/2;   //division entera conlleva a descartar el resto de la división en el resultado,
                            //es decir, en el ejemplo tenemos que var1 almacena el valor entero 5 que al
                            //llevar a cabo la división entera con el literal entero 2 nos da como resultado
                            //2.
        division3=var2/var1;   //al ser division3 una variable de tipo double el operador / automáticamente, aunque
                               //los operandos son enteros lleva a cabo la división real.
                               //también podríamos realizar el casting al tipo double con la expresión (double) (var2/var1);
        division4=var1/2.0; 
        
        System.out.println("********************* OPERACIONES ARITMÉTICAS *********************\n\n"
                            + "DATOS: \n"
                            + "var1=5,var2=10 \n\n"
                            + "RESULTADOS: \n"
                            + "suma=var1+var2 --> suma="+suma+"\n"
                            + "cambioSigno=-var1 --> cambioSigno="+cambioSigno+"\n"
                            + "resta=var1-5 --> resta="+resta+"\n"
                            + "producto=var2*2 --> producto="+producto+"\n"
                            + "division1=var2/2 --> division1="+division1+"\n"
                            + "division2=var1/2 --> division2="+division2+"\n"
                            + "division3=var2/var1 --> division3="+division3+"\n"
                            + "division4=var1/2.0 --> division4="+division4+"\n\n\n");   
        
        //OPERACIONES DE COMPARACIÓN
        //declaración de variables a utilizar
        int var3=5,var4=10;
        boolean resultado1,resultado2,resultado3,resultado4,resultado5,resultado6,resultado7=true;
        //operaciones lógicas
        resultado1=var3==var4;      //operador de igualdad --> ==
        resultado2=var3<var4;       //operador menor que --> <
        resultado3=var3<=var4;      //operador menor o igual --> <=
        resultado4=var3>var4;       //operador mayor que --> >
        resultado5=var3>=var4;      //operador mayor o igual --> >=
        resultado6=var3!=var4;      //operador diferente a --> !=

        
        System.out.println("***************** OPERACIONES DE COMPARACIÓN ******************\n\n"
                            + "DATOS: \n"
                            + "var3=5,var4=10 \n\n"
                            + "RESULTADOS: \n"
                            + "resultado1=var3==var4 --> resultado1="+resultado1+"\n"
                            + "resultado2=var3<var4 --> resultado1="+resultado2+"\n"
                            + "resultado3=var3<=var4 --> resultado1="+resultado3+"\n"
                            + "resultado4=var3>var4 --> resultado1="+resultado4+"\n"
                            + "resultado5=var3>=var4 --> resultado1="+resultado5+"\n"
                            + "resultado6=var3!=var4 --> resultado1="+resultado6+"\n\n\n");    

        //OPERACIONES LÓGICAS
        //declaración de variables a utilizar
        boolean comparacion1,comparacion2,comparacion3,comparacion4;
        //operaciones lógicas
        comparacion1=resultado1 && resultado2;      //operador lógico AND --> &&
        comparacion2=resultado1 || resultado2;      //operador lógico OR --> ||
        comparacion3=((resultado1 || resultado2) && (resultado3 || resultado4));      //composición de expresiones lógicas
        comparacion4=!((resultado1 || resultado2) && (resultado3 || resultado4));      //composición de expresiones lógicas

        
        System.out.println("********************* OPERACIONES LÓGICAS *********************\n\n"
                            + "DATOS: \n"
                            + "resultado1="+resultado1+", resultado2="+resultado2+", resultado3="+resultado3+", resultado4="+resultado4+"\n\n"
                            + "RESULTADOS: \n"
                            + "comparacion1=resultado1 && resultado2 --> comparacion1="+comparacion1+"\n"
                            + "comparacion2=resultado1 || resultado2 --> comparacion2="+comparacion2+"\n"
                            + "comparacion3=((resultado1 || resultado2) && (resultado3 || resultado4)) --> comparacion3="+comparacion3+"\n"
                            + "comparacion4=!((resultado1 || resultado2) && (resultado3 || resultado4)) --> comparacion4="+comparacion4+"\n\n\n");    
        
    }
    
}
