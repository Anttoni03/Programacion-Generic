

public class BusquedaFicheroClientes {
    
    private ClienteObjetoFicherosIn fichero;
    private Cliente cliente = new Cliente();
    private int codigo;
    
    public static void main(String[] args){
        new BusquedaFicheroClientes().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        fichero = new ClienteObjetoFicherosIn("clientes.dat");
        
        System.out.print("Introduce el código del cliente a buscar: ");
        codigo = LT.readInt();
        
        cliente = fichero.lectura();
        while (cliente.getCodigo() != codigo && !cliente.esCentinela())
        {
            cliente = new Cliente();
            cliente = fichero.lectura();                
        }
        
        if (!cliente.esCentinela())
            System.out.println(cliente.toString());
        else
            System.out.println("El cliente con código " + codigo + " no está en el fichero.");
        
    }
}
