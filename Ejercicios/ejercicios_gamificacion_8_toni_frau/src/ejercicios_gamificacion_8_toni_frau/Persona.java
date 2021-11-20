/*
 * FUNCIONALIDAD: crear la clase Persona atendiendo a sus posibles características
 * y acciones como su nombre o su cumpleaños
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 20.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_8_toni_frau;

public class Persona {
    //VARIABLES DE LA CLASE
    //atributo de objeto que indica el nombre de la persona
    private String nombre;
    //atributo de objeto que indica el nif de la persona
    private String nif;
    //atributo de objeto que indica la edad de la persona
    private int edad;
    //atributo de objeto que indica el saldo de la persona
    private double saldo;
    
    //MÉTODOS
    //MÉTODOS CONSTRUCTORES
    //método constructor sin parámetros
    public Persona()
    {
        saldo = 0;
    }
    
    //método constructor con parámetros de nombre, nif y edad
    public Persona(String nombre, String nif, int edad)
    {
        this.nombre = nombre;
        this.nif = nif;
        this.edad = edad;
        saldo = 0;
    }
    
    //método constructor con parámetros de nombre, nif, edad y saldo
    public Persona(String nombre, String nif, int edad, double saldo)
    {
        this.nombre = nombre;
        this.nif = nif;
        this.edad = edad;
        this.saldo = saldo;
    }
    
    //MÉTODOS FUNCIONALES
    //método para obtener el nombre de la persona
    public String getNombre()
    {
        return nombre;
    }
    
    //método para obtener el nif de la persona
    public String getNif()
    {
        return nif;
    }
    
    //método para obtener la edad de la persona
    public int getEdad()
    {
        return edad;
    }
    
    //método para obtener el saldo de la persona
    public double getSaldo()
    {
        return saldo;
    }
    
    //método para convertir la información de la persona en texto
    public String toString()
    {
        String texto;
        
        texto = "\n======INFORMACIÓN DE LA PERSONA======\n"+
                "NOMBRE: " + nombre + "\n" +
                "NIF: " + nif + "\n" +
                "EDAD: " + edad + "\n" +
                "SALDO DE CUENTA: " + saldo + "€\n";
        
        return texto;
    }
    
    //método para leer la información de la persona
    public void lectura()
    {
        System.out.println("INTRODUCE LOS DATOS DE LA PERSONA");
        
        System.out.print("NOMBRE: ");
        nombre = LT.readLine();
        
        System.out.print("NIF: ");
        nif = LT.readLine();
        
        System.out.print("EDAD: ");
        edad = LT.readInt();
        
        System.out.print("SALDO DE CUENTA: ");
        saldo = LT.readDouble();
    }
    
    //método para devolver una copia de la persona
    public Persona copia()
    {
        Persona pers = new Persona(nombre, nif, edad, saldo);
        
        return pers;
    }
    
    //método para que la persona realice el cumpleaños
    public void cumpleanos()
    {
        edad++;
        System.out.println(nombre + " acaba de hacer " + edad + " años!");
    }
    
    //método para realizar el cobro con importe definido de la persona
    public void cobro(double importe)
    {
        saldo += importe;
        System.out.println(nombre + " ha cobrado " + importe + "€\n" + 
                           "Tiene un total de " + saldo + "€ de saldo");
    }
    
    //método para realizar el cobro sin importe definido de la persona
    public void cobro()
    {
        saldo += 1000;
        System.out.println(nombre + " ha cobrado 1000.00€\n" + 
                           "Tiene un total de " + saldo + "€ de saldo");
    }
    
    //método para realizar un cobro de importe definido a la persona
    public void gasto(double importe)
    {
        saldo -= importe;
        System.out.println("A " + nombre + " le han cobrado " + importe + "€\n" + 
                           "Tiene un total de " + saldo + "€ de saldo");
    }
}
