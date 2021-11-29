/*
ACTIVIDAD 8 - GAMIFICACIÓN
Si una Persona viene descrita con los siguientes atributos:
    - nombre.
    - nif.
    - edad.
    - saldo en la cuenta corriente.

1.Implementar la clase Persona atendiendo a:
    1. Declaración de los atributos de la clase.
    2. Implementación de un método constructor sin parámetros 
    inicializando el atributo saldo a 0.
    3. Implementación de un método constructor con los parámetros 
    que inicializan los atributos nombre, nif y edad. El atributo saldo 
    será inicializado a 0.
    4. Implementación de un método constructor con los parámetros 
    que inicializan los atributos nombre, nif, edad y saldo.
    5. Implementa los métodos necesarios para poder obtener el 
    contenido de los atributos de la clase.
    6. Implementa el método toString para convertir la información 
    de un objeto Persona en String.
    7. Implementa el método lectura para llevar a cabo la lectura 
    desde el teclado de un objeto Persona.
    8. Implementación del método copia que devuelve una copia de un 
    objeto Persona.
    9. Implementación del método cumpleaños que lleva a cabo el 
    incremento de la edad de un objeto Persona en una unidad.
    10. Implementación del método cobro que incrementa el saldo 
    de un objeto Persona con el importe pasado por parámetro.
    11. Implementación del método cobro sin parámetros que lleva 
    a cabo el incremento del saldo de un objeto Persona con el 
    importe del salario mínimo. El salario mínimo es para todos 
    los objetos Persona de 1000.00 euros.
    12. Implementación del método gasto que lleva a cabo la reducción 
    del saldo de un objeto Persona con el importe dado por parámetro.


CLASE Persona aglutina las declaraciones y funcionalidades de los 
objetos Persona
 */
package actividad_8_gamificacion;


public class Persona {
//////1. Declaración de los atributos de la clase.
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE QUE DEFINEN EL ESTADO DE
    //LOS OBJETOS Persona
    //declaración atributo de objeto que representa el nombre de un objeto
    //Persona
    private String nombre;
    //declaración atributo de objeto para representar el nif de un objeto
    //Persona
    private String nif;
    //declaración atributo de objeto para representar la edad de un
    //objeto Persona
    private int edad;
    //declaración atributo de objeto para representar el saldo de la
    //cuenta corriente de un objeto Persona
    private double saldo;
    //delaración atributo de clase constante para representación 
    //del salario mínimo
    private static final double SALARIO_MINIMO=1000.0;
    
    ////////////////////////// MÉTODOS ////////////////////////////////
    //MÉTODO CONSTRUCTORES
//////2. Implementación de un método constructor sin parámetros 
    //inicializando el atributo saldo a 0.
    public Persona() {
        saldo=0.0;
    }
    
//////3. Implementación de un método constructor con los parámetros 
    //que inicializan los atributos nombre, nif y edad. 
    //El atributo saldo será inicializado a 0.
    public Persona(String dato1, String dato2, int dato3) {
        nombre=dato1;
        nif=dato2;
        edad=dato3;
        saldo=0.0;
    }
    
//////4. Implementación de un método constructor con los parámetros 
    //que inicializan los atributos nombre, nif, edad y saldo.
    public Persona(String dato1, String dato2, int dato3, double dato4) {
        nombre=dato1;
        nif=dato2;
        edad=dato3;
        saldo=dato4;
    }   
    
    
    //MÉTODOS FUNCIONALES QUE DEFINEN EL COMPORTAMIENTO DE LOS OBJETOS
    //Persona
    
//////5. Implementa los métodos necesarios para poder obtener el contenido de 
    //los atributos de la clase.
    //método getNombre que posibilita acceder al atributo nombre
    public String getNombre() {
        return nombre;
    }
    //método getNif que posibilita acceder al atributo nif
    public String getNif() {
        return nif;
    } 
    //método getNombre que posibilita acceder al atributo edad
    public int getEdad() {
        return edad;
    }
    //método getNombre que posibilita acceder al atributo saldo
    public double getSaldo() {
        return saldo;
    }
    
//////6. Implementa el método toString para convertir la información de un 
    //objeto Persona en String.
    public String toString() {
        return "INFORMACIÓN Persona --> \n"+
                "NOMBRE: "+nombre+"\n"+
                "NIF: "+nif+"\n"+
                "EDAD: "+edad+"\n"+
                "SALDO C/C: "+saldo+"\n";
    }
    
//////7. Implementa el método lectura para llevar a cabo la lectura 
    //desde el teclado de un objeto Persona.
    public void lectura() {
        //mensaje usuario para comunicarle la lectura de un objeto Persona
        System.out.println("LECTURA PERSONA");
        //mensaje usuario para lectura atributo nombre
        System.out.print("NOMBRE: ");
        //lectura atributo nombre
        nombre=LT.readLine();
        //mensaje usuario para lectura atributo nif
        System.out.print("NIF: ");
        //lectura atributo nif
        nif=LT.readLine();
        //mensaje usuario para lectura atributo edad
        System.out.print("EDAD: ");
        //lectura atributo edad
        edad=LT.readInt();
        //mensaje usuario para lectura atributo saldo
        System.out.print("SALDO C/C: ");
        //lectura atributo saldo
        saldo=LT.readDouble();
    }
    
//////8. Implementación del método copia que devuelve una copia de un 
    //objeto Persona.
    public Persona copia() {
        //DECLARACIONES
        //declaración objeto Persona local
        Persona local=new Persona();
        
        //ACCIONES
        //asignación de los atributos del objeto Persona que ha llamado
        //al método copia a los atributos del objeto Persona local
        local.nombre=nombre;
        local.nif=nif;
        local.edad=edad;
        local.saldo=saldo;
        
        //devolución el objeto Persona local como copia resultante
        return local;
    }
    
//////9. Implementación del método cumpleaños que lleva a cabo el 
    //incremento de la edad de un objeto Persona en una unidad.
    public void cumpleaños() {
        edad++;
    }
    
//////10. Implementación del método cobro que incrementa el saldo 
    //de un objeto Persona con el importe pasado por parámetro.
    public void cobro(double importe) {
        saldo=saldo+importe;
    }
    
//////11. Implementación del método cobro sin parámetros que lleva 
    //a cabo el incremento del saldo de un objeto Persona con el 
    //importe del salario mínimo. El salario mínimo es para todos 
    //los objetos Persona de 1000.00 euros.
    public void cobro() {
        saldo=saldo+SALARIO_MINIMO;
    }
    
//////12. Implementación del método gasto que lleva a cabo la 
    //reducción del saldo de un objeto Persona con el importe dado 
    //por parámetro.
    public void gasto(double importe) {
        saldo=saldo-importe;
    }
}
