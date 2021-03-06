/*
CLASE Contacto

autor: Juan Montes de Oca
*/
package proyecto_clases_problemas_a_realizar__29_03_2022;

public class Contacto {
    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de clase constante entero que representa la dimensión
    //en bytes de un objeto Contacto
    // codigo -> 4 bytes
    // nombre -> 32 caracteres * 2 bytes = 64 bytes
    // telefono -> 16 caracteres * 2 bytes = 32 bytes
    // email -> 32 caracteres * 2 bytes = 64 bytes
    // direccion -> 64 caracteres * 2 bytes = 128 bytes
    // edad --> 4 bytes
    // eliminado --> 1 byte
    private static final int DIMENSION = 297;
    //declaración atributos campos de un objeto Contacto
    private int codigo;
    private String nombre, telefono, email, direccion;
    private int edad;
    //atributo booleano para implementar la eliminación lógica de objetos
    //Contacto en un fichero
    private boolean eliminado=false;
     
    //MÉTODOS
    
    //MÉTODO CONSTRUCTOR
     public Contacto() {
        codigo=0;
     }
    
     //MÉTODOS FUNCIONALES
     
     //método lectura posibilita le lectura de un objeto Contacto desde el teclado
     public void lectura() {     
         System.out.print("INTRODUCE EL CÓDIGO: ");            
         codigo = LT.readInt(); 
         System.out.print("INTRODUCE EL NOMBRE: ");            
         nombre = LT.readLine();        
         System.out.print("INTRODUCE EL TELEFONO: ");        
         telefono = LT.readLine();        
         System.out.print("INTRODUCE EL EMAIL: ");       
         email = LT.readLine();        
         System.out.print("INTRODUCE LA DIRECCION: ");        
         direccion = LT.readLine();       
         System.out.print("INTRODUCE LA EDAD: ");        
         edad=LT.readInt();             
     }
     
     //método lectura posibilita le lectura de un objeto Contacto desde el teclado
     //al que se le asigna el código dado por parámetro
     public void lectura(int cod) {  
         codigo=cod;
         System.out.println("DATOS CONTACTO CÓDIGO "+codigo); 
         System.out.print("INTRODUCE EL NOMBRE: ");            
         nombre = LT.readLine();        
         System.out.print("INTRODUCE EL TELEFONO: ");        
         telefono = LT.readLine();        
         System.out.print("INTRODUCE EL EMAIL: ");       
         email = LT.readLine();        
         System.out.print("INTRODUCE LA DIRECCION: ");        
         direccion = LT.readLine();       
         System.out.print("INTRODUCE LA EDAD: ");        
         edad=LT.readInt();             
     }
    
     //MÉTODOS get, set y lectura desde el teclado del atributo nombre de un
     //objeto Contacto
     public String  getNombre() {
         return nombre;
     }     
     public void  setNombre(String dato) {      
         nombre=dato;
     }
     public void lecturaNombre() { 
         System.out.print("INTRODUCE EL NOMBRE: ");
         nombre = LT.readLine();
     }
     
     //MÉTODOS get, set y lectura desde el teclado del atributo telefono de un
     //objeto Contacto
     public  String getTelefono() {      
         return telefono;   
     }   
     public  void setTelefono(String dato) {     
         telefono=dato;   
     }        
     public  void lecturaTelefono() throws Exception { 
         System.out.print("INTRODUCE EL TELEFONO: ");
         telefono = LT.readLine();
     }

     //MÉTODOS get, set y lectura desde el teclado del atributo email de un
     //objeto Contacto
     public  String  getEmail() {      
         return email;
     }
     public  void  setEmail(String dato) {
         email=dato;
     }
     public  void  lecturaEmail() {     
         System.out.print("INTRODUCE EL EMAIL: ");
         email = LT.readLine();
     }
     
     //MÉTODOS get, set y lectura desde el teclado del atributo direccion de un
     //objeto Contacto     
     public  String  getDireccion() {   
         return direccion;
     }
     public void  setDireccion(String dato) {
         direccion=dato;
     }
     public  void  readDireccion() { 
         System.out.print("INTRODUCE LA DIRECCION: ");
         direccion = LT.readLine();
     }
     
     //MÉTODOS get, set y lectura desde el teclado del atributo edad de un
     //objeto Contacto        
     public  int  getEdad() {
         return edad;
     }
     public  void  setEdad(int dato) {
         edad=dato;
     }       
     public  void  readEdad() {
      System.out.print("INTRODUCE LA EDAD: ");
      edad=LT.readInt();
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
                "\nNOMBRE: " + nombre + 
                "\nTELEFONO: " + telefono +
                "\nEMAIL: " + email + 
                "\nDIRECCIÓN: " + direccion + 
                "\nEDAD: " + edad+"\n";
     }
         
     //método que devuelve la dimensión en bytes de un objeto Contacto  
     public static int getDimension() {
         return DIMENSION; 
     }
     
     //método que cataloga a un contacto como eliminado
     public void setEliminado() {
         eliminado=true;
     }

     //método que cataloga a un contacto como eliminado
     public void setEliminado(boolean dato) {
         eliminado=dato;
     }     
     //método que permite el acceso al atributo eliminado
     public boolean getEliminado() {
         return eliminado;
     }
}
