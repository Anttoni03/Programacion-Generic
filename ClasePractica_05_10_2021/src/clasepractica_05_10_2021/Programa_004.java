package clasepractica_05_10_2021;

/*
FUNCIONALIDAD: lleva a cabo la ilustración del casting en la división real y 
de la representación numérica de caracteres.
FECHA REALIZACIÓN: 05.octubre.2021
ASIGNATURA: Programación I
ESTUDIOS: ING. Informática
AUTOR: Juan MOntes de Oca
 */

public class Programa_004 {
    //declaración del método main necesario para que la clase pueda ser ejecutada
    //directamente.
    public static void main(String [] argumentos) throws Exception {
        //declaración de variables que vamos a utilizar
        int var1=5,var2=2;
        float var3,var4;
        
        //el casting en la división real
        var3=var1/var2;
        var4=(float) var1/(float) var2;
        
        System.out.println("****************** CASTING EN DIVISIÓN REAL ******************\n\n"
                            + "DATOS: \n"
                            + "var1=5,var2=2 \n\n"
                            + "RESULTADOS: \n"
                            + "var3=var1/var2 --> var3="+var3+"\n"
                            + "var4=(float) var1/(float) var2 --> var4="+var4+"  <--- ¡¡¡ UTILIZACIÓN CASTING !!!\n\n\n");  
        
        
        //declaración de variables que vamos a utilizar
        char car1='a',car2='m',car3='z',car4='A';
        int codigo1,codigo2,codigo3,codigo4;
        
        //operaciones de representación numérica de caracteres
        codigo1=car1;
        codigo2=car2;
        codigo3=car3;
        codigo4=car4;
        
        System.out.println("*********** REPRESENTACIÓN NUMÉRICA DE CARACTERES ************\n\n"
                            + "DATOS: \n"
                            + "car1='a',car2='m',car3='z',car4='A' \n\n"
                            + "OBTENER EL CÓDIGO NUMÉRICO DE UN CARACTER DADO \n"
                            + "RESULTADOS: \n"
                            + "codigo1=car1; --> codigo1="+codigo1+" --> representa el código correspondiente al caracter 'a'\n"
                            + "codigo2=car2; --> codigo2="+codigo2+" --> representa el código correspondiente al caracter 'm'\n"
                            + "codigo3=car3; --> codigo3="+codigo3+" --> representa el código correspondiente al caracter 'z'\n"
                            + "codigo4=car4; --> codigo4="+codigo4+" --> representa el código correspondiente al caracter 'A'\n"
                            + "JAVA ES UN LENGUAJE CASE SENSITIVE Y, POR ELLO, LOS CARACTERES MINÚSCULAS SON DIFERENTES A LOS"
                                    + " CARACTERES MAYÚSCULAS FUNDAMENTÁNDOSE EN QUE TIENEN DIFERENTE CÓDIGO DE CARACTER."); 
        
        
       //TAMBIÉN PODEMOS, FUNDAMENTÁNDONOS EN LOS CÓDIGOS DE CARACTERES, REALIZAR EL PASO OPUESTO, ES DECIR, A PARTIR DE UN
       //CÓDIGO NUMÉRICO OBTENER EL CARACTER AL QUE CORRESPONDE
       
        char car5,car6,car7,car8;
        
        //SE LLEVA A CABO EL CASTING DEL TIPO CHAR PARA ELLO
        car5= (char) codigo1;
        car6= (char) codigo2;
        car7= (char) codigo3;
        car8= (char) codigo4;

        System.out.println("OBTENER EL CARÁCTER A PARTIR DE UN CÓDIGO NUMÉRICO DADO \n\n"
                            + "DATOS: \n"
                            + "car1='a',car2='m',car3='z',car4='A' \n\n"
                            + "RESULTADOS: \n"
                            + "car5= (char) codigo1; --> car5="+car5+" --> representa el carácter correspondiente al código "+codigo1+"\n"
                            + "car6= (char) codigo2; --> car6="+car6+" --> representa el carácter correspondiente al código "+codigo2+"\n"
                            + "car7= (char) codigo3; --> car7="+car7+" --> representa el carácter correspondiente al código "+codigo3+"\n"
                            + "car8= (char) codigo4; --> car8="+car8+" --> representa el carácter correspondiente al código "+codigo4+"\n\n");         
        
        //UTILIZACIÓN DE LOS OPERADORES DE COMPARACIÓN CON EL TIPO char
        //fundamentándonos en la correspondencia de los caracteres con los códigos numéricos de caracteres podemos utilizar los
        //operadores de comparación directamente con los caracteres
        boolean resultado=car1<car2;
        
        System.out.println("UTILIZACIÓN DE LOS OPERADORES DE COMPARACIÓN CON EL TIPO char \n\n"
                            + "fundamentándonos en la correspondencia de los caracteres con los códigos numéricos de caracteres podemos utilizar los\n" +
                               "operadores de comparación directamente con los caracteres \n"
                            + "de esta forma podemos realizar la siguiente comparación: boolean resultado=car1<car2; \n"
                            + "siendo el resultado un valor booleano: "+resultado+"\n\n\n");
        }
    
}
