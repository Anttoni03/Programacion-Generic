/*
FUNCIONALIDAD: ilustración arrays.
FECHA DE CREACIÓN: 02.11.2021
AUTOR:Juan Montes de Oca
 */
package clasepractica_02_11_2021;

public class IlustracionArrays_1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new IlustracionArrays_1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception {
        //DECLARACIONES
        //declaración variable array de componentes tipo int sin especificación
        //del número de componentes
        int [] array1;
        //declaración constante array de componentes de tipo int
        final int [] ARRAY2={10,20,30,40,50};
        //declaración variable array de 10 componentes de tipo int sin inicialización
        int [] array3=new int[10];
        //declaración variable array de 10 componentes de tipo int con inicialización
        int [] array4={1,2,3,4,5,6,7,8,9,10};
        //declaración variable array de 5 componetes de tipo char con inicialización
        char [] array5={'a','e','i','o','u'};
        //declaración variable array de 3 componentes de tipo boolean con 
        //inicialización
        boolean [] array6={true,false,true};
        //declaración constante array de 7 componentes de tipo String 
        final String [] array7={"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES",
            "SABADO","DOMINGO"};
        //declaración variable array de 2 componentes de tipo String con inicializacion
        String [] finSemana={"SABADO","DOMINGO"};
        
        //ACCIONES
        //dimensionar con 10 componentes sin incialización el array1
        array1=new int[10];
        //asignar valores a todas las componentes del array array1
        for (int indice=0;indice<array1.length;indice++) {
            array1[indice]=indice+1;
        }
        //asignar a la segunda componente del array1 el valor 234
        array1[1]=234;
        //visualización de todas las componentes del array1
        System.out.println("VISUALIZACIÓN ARRAY array1");
        for (int indice=0;indice<array1.length;indice++) {
            //visualización componente indice-ésima del array
            System.out.println("COMPONENTE "+(indice+1)+" DEL ARRAY array1: "+array1[indice]);   
        }
        
        //visualización invertida de las componentes del array1
        System.out.println("VISUALIZACIÓN INVERTIDA ARRAY array1");
        for (int indice=array1.length-1;indice>=0;indice--) {
            //visualización componente indice-ésima del array
            System.out.println("COMPONENTE "+(indice+1)+" DEL ARRAY array1: "+array1[indice]);  
        }
    }
    
}
