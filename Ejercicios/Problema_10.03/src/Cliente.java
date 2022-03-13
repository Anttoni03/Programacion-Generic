
public class Cliente implements java.io.Serializable {
    
    private int codigo;
    private String nombre;
    private String nif;
    private String direccion;
    private int edad;
    private String mail;
    private String telefono;
    
    private static final Cliente CENTINELA = new Cliente(-1," "," "," ",0," "," ");
    
    public Cliente()
    {
        codigo = 0;
    }
    
    public Cliente(int codigo, String nombre, String nif, String direccion, int edad, String mail, String telefono)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.edad = edad;
        this.mail = mail;
        this.telefono = telefono;
    }
    
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setNif(String nif)
    {
        this.nif = nif;
    }
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
    
    public int getCodigo()
    {
        return codigo;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getNif()
    {
        return nif;
    }
    public String getDireccion()
    {
        return direccion;
    }
    public int getEdad()
    {
        return edad;
    }
    public String getMail()
    {
        return mail;
    }
    public String getTelefono()
    {
        return telefono;
    }
    
    public void lectura()
    {
        System.out.print("Introduzca el código: ");
        codigo = LT.readInt();
        System.out.print("Introduzca el nombre: ");
        nombre = LT.readLine();
        System.out.print("Introduzca el NIF: ");
        nif = LT.readLine();
        System.out.print("Introduzca la dirección: ");
        direccion = LT.readLine();
        System.out.print("Introduzca la edad: ");
        edad = LT.readInt();
        System.out.print("Introduzca el email: ");
        mail = LT.readLine();
        System.out.print("Introduzca el teléfono: ");
        telefono = LT.readLine();
    }
    
    public String toString()
    {
        String resultado = "";
        
        resultado += "El código es " + codigo;
        resultado += "\nEl nombre es " + nombre;
        resultado += "\nEl NIF es " + nif;
        resultado += "\nLa dirección es " + direccion;
        resultado += "\nLa edad es " + edad;
        resultado += "\nEl email es " + mail;
        resultado += "\nEl teléfono es " + telefono;
        
        return resultado;
    }
    
    public boolean esCentinela()
    {
        return codigo == CENTINELA.codigo;
    }
    
    public static Cliente getCentinela()
    {
        return CENTINELA;
    }
}
