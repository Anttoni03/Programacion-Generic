/*
CLASE Libroglutina las declaraciones y funcionalidades relativas a los objeto Libro
 */
package clasepractica_16_11_2021;

public class Libro {
    //DECLARACIÓN DE ATRIBUITOS DE LA CLASE
    //declaración atributo de objeto que represente el autor de un objeto Libro
    private String autor;
    //declaración atributo de objeto que represente el título de un objeto Libro
    private String titulo;
    //declaración atributo de objeto que represente el género de un objeto Libro
    private String genero;
    //declaración atributo de objeto que represente la editorial de un objeto
    //Libro
    private String editorial;
    //declaración atributo de objeto que represente el año de edición de un objeto
    //Libro
    private int anyoEdicion;
    
    
    //MÉTODOS
    
    //MÉTODOS CONSTRUCTORES
    //método constructor sin parámetros que conlleva con el uso a la instanciación 
    //de un objeto Libro 
    public Libro() {
        //al no contener ninguna sentencia el bloque de acciones de este método
        //constructor conlleva  a que el objeto Libro se instanciará a partir de 
        //él sin inicialización alguna.
    }
    
    //método constructor con parámetros que nos posibilitan inicializar los
    //atributos del objerto Libro ainstanciar con los valores dados
    public Libro(String dato1, String dato2, String dato3, String dato4, int dato5) {
        //ACCIONES
        //asignación de los parámetros dados a los atributos dl objeto Libro
        autor=dato1;
        titulo=dato2;
        genero=dato3;
        editorial=dato4;
        anyoEdicion=dato5;
    }
    
    //MÉTODO FUNCIONALES QUE DEFINEN EL COMORTAMIENTO DE LOS OBJETOS Libro
    //método lectura que lleva a cabo la lectura de un objeto Libro desde
    //el teclado
    public void lectura() {
        //ACCIONES
        //mensaje usuario para introducir los datos de un objeto Libro
        System.out.println("LECTURA OBJETO Libro");
        //mensaje usuario para introducir el autor del objeto Libro
        System.out.print("AUTOR: ");
        //lectura del valor introducido desde el teclado asignándolo al atributo
        //autor
        autor=LT.readLine();
        //mensaje usuario para introducir el título del objeto Libro
        System.out.print("TÍTULO: ");
        //lectura del valor introducido desde el teclado asignándolo al atributo
        //titulo
        titulo=LT.readLine();
        //mensaje usuario para introducir el género del objeto Libro
        System.out.print("GÉNERO: ");
        //lectura del valor introducido desde el teclado asignándolo al atributo
        //genero
        genero=LT.readLine();
        //mensaje usuario para introducir la editorial del objeto Libro
        System.out.print("EDITORIAL: ");
        //lectura del valor introducido desde el teclado asignándolo al atributo
        //editorial
        editorial=LT.readLine();
        //mensaje usuario para introducir el año de edición del objeto Libro
        System.out.print("AÑO DE EDICIÓN: ");
        //lectura del valor introducido desde el teclado asignándolo al atributo
        //anyoEdicion
        anyoEdicion=LT.readInt();
    }
    
    //método toString lleva a cabo la conversión de un objeto Libro a String con
    //la finalidad de visualización con las sentencias System.out.print y
    //System.out.println
    public String toString() {
        //ACCIONES
        //devolución de la asignación con concatenación de los diferentes 
        //literales y atributos
        return "AUTOR: "+autor+"\n"
                + "TÍTULO: "+titulo+"\n"
                + "GÉNERO: "+genero+"\n"
                + "EDITORIAL: "+editorial+"\n"
                + "AÑO DE EDICIÓN: "+anyoEdicion;
    }
    
    //método booleano que lleva a cabo la verificación de si un libro 
    //es de un año de ecición dado
    public boolean verificacionAño(int año) {
        //devuelve el resultado de compoarar el atrubuto anyoEdicion del
        //objeto Libro con el año dado por parámetro
        return anyoEdicion==año;
    }
    
    
    //MÉTODOS GETS Y SETS
    //los métodos gets y sets posibilitan el acceso y la modificación respectivamente
    //de los atributos de los objetos Libro
    //para cada atributo podemos declarar sus propios métodos get y set siempre y cuando
    //esté justificado, es decir, que el acceso al contenido y/o la modificación
    //del contenido de ese atributo sea necesario que se lleve a término por
    //un programa ajeno a la clase.
    //En definitiva, se deberán de delclarar aquellos métodos get y set justificados
    
    //COMO INTRODUCIÓN EN ESTA CLASE DECLARAREMOS LOS MÉTODOS GET Y SET DE TODOS
    //LOS ATRIBUTOS A MODO DE ILUSTRACIÓN:
    
    //método get del atributo autor
    public String getAtributo() {
        return autor;
    }
    //método set del atributo autor
    public void setAtributo(String dato) {
        autor=dato;
    }

    //método get del atributo titulo
    public String getTitulo() {
        return titulo;
    }
    //método set del atributo titulo
    public void setTitulo(String dato) {
        titulo=dato;
    }

    //método get del atributo genero
    public String getGenero() {
        return genero;
    }
    //método set del atributo genero
    public void setGenero(String dato) {
        genero=dato;
    }

    //método get del atributo editorial
    public String getEditorial() {
        return editorial;
    }
    //método set del atributo editorial
    public void setEditorial(String dato) {
        editorial=dato;
    }

    //método get del atributo anyoEdicion
    public int getAnyoEdicion() {
        return anyoEdicion;
    }
    //método set del atributo anyoEdicion
    public void setAnyoEdicion(int dato) {
        anyoEdicion=dato;
    }    
    
}
