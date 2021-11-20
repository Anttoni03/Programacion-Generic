/*
clase Estudiante aglutina las declaraciones (atributos) y las funcionalidades
(métodos) relativos a los objetos Estudiante
 */
package claseteorica_19_11_2021;


public class Estudiante {
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE QUE DEFINEN EL ESTADO DE LOS
    //OBJETOS Estudiante
    //declaración atributo de clase ara representar el máximo número de 
    //asignaturas que puede realizar un objeto Estudiante
    private static final int NUMERO_MAXIMO_ASIGNATURAS=10;
    //declaración atributo de objeto para representar el NIF de un objeto
    //Estudiante
    private String nif;
    //declaración atributo de objeto para representar el nombre de un
    //objeto Estudiante
    private String nombre;
    //declaración atributo de objeto que represente los estudios que cursa
    //un objeto Estudiante
    private String estudios;
    //declaración atributo de objeto que represente el curso de un objeto
    //Estudiante
    private int curso;
    //declaración atributo de objeto para representar las asignaturas que cursa
    //un estudiante
    private String [] asignaturas=new String[NUMERO_MAXIMO_ASIGNATURAS];
    //declaración atributo de objeto que representa el número de asinaturas
    private int numeroAsignaturas=0;

    
    //MÉTODOS
    
    //MÉTODOS CONSTRUCTORES
    //método constructor sin parámetros 
    public Estudiante() { //posibilita la instanciación, utilizando el operador
                           //new, de un objeto Estudiante sin inicialización
       //inicialización del atributo numeroAsignaturas a 0
       numeroAsignaturas=0;
    }
    
    //método constructor con parámetros para inicializar los atributos de
    //nif, nombre, estudios
    public Estudiante(String dato1, String dato2, String dato3) {
        nif=dato1;
        nombre=dato2;
        estudios=dato3;
        //inicialización del atributo numeroAsignaturas a 0
       numeroAsignaturas=0;
    }
    
    //método cosntaructor con parámetros para inicializar todos los
    //atruibutos de un objeto Estudiante
    public Estudiante(String dato1, String dato2, String dato3, int dato4,int dato5) {
        nif=dato1;
        nombre=dato2;
        estudios=dato3;
        curso=dato4;
        numeroAsignaturas=dato5;
        //solitar la lectura por teclado de las asignaturas
        lecturaAsignaturas();
    }
    
    //método de objeto privado que lleva a cabo la solicitud por teclado de las
    //asignaturas
    private void lecturaAsignaturas() {
        //MENSAJE USUARIO PARA COMUNICAR LAINTRODUCCIÓN DE LAS ASIGNATURAS
        System.out.println("INTRODUCCIÓN DE LAS "+numeroAsignaturas+" DEL ESTUDIANTE");
        //bucle de solictud por teclado y asignación al array asignturas de las
        //asignaturas que va a cursar el estudiante
        for (int indice=0; indice<numeroAsignaturas;indice++) {
            //mensjae usuario para introducir asignatura (indice+1)
            System.out.print("ASIGNATURA "+(indice+1)+": ");
            //lectura asignatura
            asignaturas[indice]=LT.readLine();
        }
    }
    
    //MÉTODOS FUNCIONALES QUE DESCRIBEN EL COMPORTAMIENTO DE LOS OBJETOS Estudiante
    //método de obvjeto lectura que lleva a cabo la lectura de un objeto Estudiante
    //desde el teclado
    public void lectura() {
        //mensaje usuario para comunicar la introducción de los datos de un
        //objeto Estudiante
        System.out.println("INTRODUCIÓN DATOS ESTUDIANTE");
        //mensaje usuario para introducir el atributo nif del objeto Estudiante
        System.out.print("NIF: ");
        //lectura valor desde el teclado y asignación del mismo al atributo
        //nif del objeto Estudiante
        nif=LT.readLine();
        //mensaje usuario para introducir el atributo nombre del objeto Estudiante
        System.out.print("NOMBRE: ");
        //lectura valor desde el teclado y asignación del mismo al atributo
        //nombre del objeto Estudiante
        nombre=LT.readLine();
        //mensaje usuario para introducir el atributo estudios del objeto Estudiante
        System.out.print("ESTUDIOS: ");
        //lectura valor desde el teclado y asignación del mismo al atributo
        //estudios del objeto Estudiante
        estudios=LT.readLine();
        //mensaje usuario para introducir el atributo curso del objeto Estudiante
        System.out.print("CURSO: ");
        //lectura valor desde el teclado y asignación del mismo al atributo
        //curso del objeto Estudiante
        curso=LT.readInt();
        //verificar si las asignaturas ya han sido leidas o no
        if (numeroAsignaturas==0) {
            //mensaje usuario para introducir el número de asignaturas a cursar
            System.out.print("NÚMERO DE ASIGNATURAS A CURSAR: ");
            //lectura número de asignaturas a cursar
            numeroAsignaturas=LT.readInt();
            //llamada al método lecturaAsignaturas para leer las asignatuyras a cursar
            lecturaAsignaturas();  
        }  
    }

    //método función toSTring que lleva a cabo la conversión a String de la información
    //que representa un objeto Estudiante
    public String toString() {
        //DECLARACIONES
        //declaración variable String para devolver el String resultante
        //de la concatenación de la información del objeto Estudiante
        String tmp;
        
        //ACCIONES
        tmp="\nINFORMACIÓN ESTUDIANTE\n"+
                "NIF: "+nif+"\n"+
                "NOMBRE: "+nombre+"\n"+
                "ESTUDIOS: "+estudios+"\n"+
                "CURSO: "+curso+"\n"+
                "ASINATURAS: "+"\n";
        //bulce para concatenar en el String tmp las asignaturas
        for (int indice=0;indice<numeroAsignaturas;indice++) {
            //concatenación de la asignatura (indice+1-ésima) del estudiante
            tmp=tmp+asignaturas[indice]+"\n";
        }      
        
        //devolución String tmp
        return tmp;
    }
    
    
}
