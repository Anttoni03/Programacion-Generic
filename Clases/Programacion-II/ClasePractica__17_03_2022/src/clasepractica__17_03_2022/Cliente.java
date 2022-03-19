/*
CLASE Cliente
 */
package clasepractica__17_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Cliente implements java.io.Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private int codigo;
    private String nombre;
    private String nif;
    private String direccion;
    private int edad;
    private String email;
    private String telefono;
    
    //declaración objeto CENTINELA
    private static final Cliente CENTINELA=new Cliente(Integer.MAX_VALUE,"","","",0,"",""); 
    
    //MÉTODOS CONSTRUCTORES
    
    public Cliente() {
        codigo=0;
    }
    
    public Cliente(int dato1, String dato2, String dato3, String dato4,
                   int dato5, String dato6, String dato7) {
        codigo=dato1;
        nombre=dato2;
        nif=dato3;
        direccion=dato4;
        edad=dato5;
        email=dato6;
        telefono=dato7;
    }
    
    //MÉTODOS GET's
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }    
    
    public String getNif() {
        return nif;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getTelefono() {
        return telefono;
    }

    //MÉTODOS SET's
    public void setCodigo(int dato) {
        codigo=dato;
    }
    
    public void setNombre(String dato) {
        nombre=dato;
    }    
    
    public void setNif(String dato) {
        nif=dato;
    }
    
    public void setDireccion(String dato) {
        direccion=dato;
    }
    
    public void setEdad(int dato) {
        edad=dato;
    }
    
    public void setEmail(String dato) {
        email=dato;
    }
    
    public void setTelefono(String dato) {
        telefono=dato;
    }    
    
    //método letura que lleva a cabo la lectura de un objeto Cliente
    //desde el teclado
    public void lectura() {
        //DECLARACIONES
        //instanciación objeto BufferedReader para enlazar el teclado posibilitando
        //la lectura a través de dicho objeto desde el teclado
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        
        //ACCIONES
        try {
            //mensaje usuario para introducir objeto CLIENTE
            System.out.println("INTRODUCCIÓN DATOS NUEVO CLIENTE");
            //Mensajes y lecturas de los diferentes atributos del nuevo cliente
            System.out.print("CÓDIGO: ");
            codigo=Integer.parseInt(teclado.readLine());       
            System.out.print("NOMBRE: ");
            nombre=teclado.readLine();
            System.out.print("NIF: ");
            nif=teclado.readLine();
            System.out.print("DIRECCIÓN: ");
            direccion=teclado.readLine();
            System.out.print("EDAD: ");
            edad=Integer.parseInt(teclado.readLine());
            System.out.print("EMAIL: ");
            email=teclado.readLine();
            System.out.print("TELÉFONO: ");
            telefono=teclado.readLine();            
        }catch (IOException error) {
            System.out.println("ERROR LECTURA DE DATOS");
        }
    }
    
    //método toString
    @Override
    public String toString() {
        return "CODIGO: "+codigo+" - NOMBRE: "+nombre+" - NIF: "+nif+"\n"+
               "DIRECCIÓN: "+direccion+"  - EDAD: "+edad+" - EMAIL: "+email+"\n"+
               "TELÉFONO: "+telefono;
    }
    
    //método esCentinela
    public boolean esCentinela() {
        return codigo==CENTINELA.codigo;
    }
    
    //método getCentinela
    public static Cliente getCentinela() {
        return CENTINELA;
    }
    
    //método que verifica si un objeto cliente tiene el mismo atributo nombre que
    //el dado por parámetro
    public boolean esIgualNombre(String dato) {
        return nombre.equals(dato);
    }
}
