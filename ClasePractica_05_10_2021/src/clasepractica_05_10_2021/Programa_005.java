package clasepractica_05_10_2021;

/*
FUNCIONALIDAD: lleva a cabo la ilustración del orden de evaluación de las expresiones
REGLAS: 
    Los operandos se evalúan de izquierda a derecha.
    Los operandos de un operador se evalúan antes que el operador.
    Los operadores son evaluados de acuerdo a la precedencia del operador.
    El orden de evaluación tiene en cuenta las siguientes directrices: 
            Primero, los paréntesis (si tiene)
            Después, seguir el orden de prioridad de operadores (* y / son prioritarios sobre + y -)
            Por último, si aparecen dos o más operadores iguales, se evalúan de izquierda a derecha.

FECHA REALIZACIÓN: 05.octubre.2021
ASIGNATURA: Programación I
ESTUDIOS: ING. Informática
AUTOR: Juan MOntes de Oca
 */

public class Programa_005 {
    //declaración del método main necesario para que la clase pueda ser ejecutada
    //directamente.
    public static void main(String [] argumentos) throws Exception {
        //declaración de variables que vamos a utilizar
        int var1=1,var2=2,var3=3,var4=4,resultado1,resultado2,resultado3,resultado4;
        
        resultado1=var1+var2*var3;
        resultado2=(var1+var2)*var3;
        resultado3=var1*var2+var3*var4;
     
        System.out.println("****************** ORDEN DE EVALUACIÓN DE EXPRESIONES ******************\n\n"
                            + "DATOS: \n"
                            + "var1=1,var2=2,var3=3,var4=4 \n\n"
                            + "RESULTADOS: \n"
                            + "resultado1=var1+var2*var3 --> resultado1="+resultado1+"\n"
                            + "resultado2=(var1+var2)*var3 --> resultado2="+resultado2+"\n"
                            + "resultado3=var1*var2+var3*var4 --> resultado3="+resultado3+"\n");  
        
        }
    
}
