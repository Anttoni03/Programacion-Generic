/*
CLASE Elemento

autor: Juan Montes de Oca
*/
package proyecto_clases_problemas_a_realizar__29_03_2022;

public class Elemento {
    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de clase constante entero que representa la dimensión
    //en bytes de un objeto Elemento
    // codigo -> 4 bytes
    // descripcion -> 32 caracteres * 2 bytes = 64 bytes
    private static final int DIMENSION = 68;
    //declaración atributos campos de un objeto Contacto
    private int codigo;
    private String descripcion;
     
    //MÉTODOS
    
    //MÉTODOS CONSTRUCTORES
     public Elemento() {
        codigo=0;
     }
    
     //MÉTODOS FUNCIONALES
     
     //método lectura posibilita le lectura de un objeto Elemento desde el teclado
     public void lectura() {     
         System.out.print("INTRODUCE EL CÓDIGO: ");            
         codigo = LT.readInt(); 
         System.out.print("INTRODUCE LA DESCRIPCIÓN: ");            
         descripcion = LT.readLine();                   
     }
    
     //MÉTODOS get y set del atributo descripcion de un
     //objeto Contacto
     public String  getDescripcion() {
         return descripcion;
     }     
     public void  setDescripcion(String dato) {      
         descripcion=dato;
     }

     //MÉTODOS get y set del atributo codigo de un
     //objeto Contacto           
     public  void  setCodigo(int str) {   
         codigo=str; 
     }      
     public int getCodigo() {        
         return codigo;
     }
     
     //método que convierte a String un objeto Contacto
     @Override   
     public String toString() {       
         return "CODIGO: " + codigo + 
                "\nDESCRIPCION: " + descripcion+"\n";
     }
         
     //método que devuelve la dimensión en bytes de un objeto Contacto  
     public static int getDimension() {
         return DIMENSION; 
     }
}
